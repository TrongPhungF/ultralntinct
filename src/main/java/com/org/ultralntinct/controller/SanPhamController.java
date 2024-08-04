package com.org.ultralntinct.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.org.ultralntinct.dao.impl.LoaiSanPhamDAOImpl;
import com.org.ultralntinct.dao.impl.SanPhamDAOImpl;
import com.org.ultralntinct.dao.jpa.LoaiSanPhamDAO;
import com.org.ultralntinct.dao.jpa.SanPhamDAO;
import com.org.ultralntinct.model.LoaiSanPham;
import com.org.ultralntinct.model.SanPham;
import com.org.ultralntinct.service.S3Service;
import com.org.ultralntinct.utils.Constant;
import com.org.ultralntinct.utils.DateUtil;
import com.org.ultralntinct.utils.FileUtil;
import com.org.ultralntinct.utils.StringUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * <p>
 * Servlet implementation class SanPhamController
 * </p>
 * .
 *
 * @author MinhNgoc
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
@WebServlet(urlPatterns = { "/san-pham" })
public class SanPhamController extends HttpServlet {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The san pham DAO. */
    private final SanPhamDAO sanPhamDAO;

    /** The loai san pham DAO. */
    private final LoaiSanPhamDAO loaiSanPhamDAO;

    /** The s 3 service. */
    private final S3Service s3Service;

    /**
     * Instantiates a new san pham controller.
     *
     * @see HttpServlet#HttpServlet()
     */
    public SanPhamController() {
        sanPhamDAO = new SanPhamDAOImpl();
        s3Service = new S3Service();
        loaiSanPhamDAO = new LoaiSanPhamDAOImpl();
    }

    /**
     * <p>
     * The method Do get.
     * </p>
     *
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sanPhamKeySearch = request.getParameter("sanPhamKeySearch");
        List<SanPham> sanPhamList;
        if (StringUtils.isNotBlank(sanPhamKeySearch)) {
            sanPhamList = sanPhamDAO.searchSanPham(sanPhamKeySearch);
        } else {
            sanPhamList = sanPhamDAO.findAll();
        }
        for (var sanPham : sanPhamList) {
            String url = s3Service.generatePresignedUrl(sanPham.getHinh(), Constant.BUCKET_NAME_S3);
            sanPham.setHinh(url);
        }

        request.setAttribute("sanPhamList", sanPhamList);
        request.getRequestDispatcher("/views/san-pham/san-pham.jsp").forward(request, response);
    }

    /**
     * <p>
     * The method Do post.
     * </p>
     *
     * @author MinhNgoc
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getParameter("_method");
        if ("put".equalsIgnoreCase(method)) {
            doPut(request, response);
        } else if ("delete".equalsIgnoreCase(method)) {
            doDelete(request, response);
        } else {
            createOrUpdateSanPham(request, response);
        }
    }

    /**
     * <p>
     * The method Creates the or update san pham.
     * </p>
     *
     * @author MinhNgoc
     * @param request  the request
     * @param response the response
     * @throws IOException      Signals that an I/O exception has occurred.
     * @throws ServletException the servlet exception
     */
    private void createOrUpdateSanPham(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String sanPhamNoStr = request.getParameter("sanPhamNo");
        String maSanPhamStr = request.getParameter("maSanPham");
        if (StringUtils.isNotBlank(maSanPhamStr)) {
            Optional<SanPham> optionalSanPham = sanPhamDAO.findByMaSanPham(maSanPhamStr);
            if (optionalSanPham.isEmpty()) {
                redirectToDetailPageWithError(request, response, maSanPhamStr, "Không tìm thấy sản phẩm !!!");
                return;
            }
        }

        String maLoaiSanPhamStr = request.getParameter("maLoaiSanPham");
        Optional<LoaiSanPham> optLoaiSanPham = loaiSanPhamDAO.findByMaLoaiSanPham(maLoaiSanPhamStr);

        if (optLoaiSanPham.isEmpty()) {
            redirectToDetailPageWithError(request, response, maSanPhamStr, "Không tìm thấy mã loại sản phẩm !!!");
            return;
        }

        SanPham sanPham = buildSanPhamFromRequest(request, sanPhamNoStr, optLoaiSanPham.get());

        Part filePart = request.getPart("hinh");
        String keyFile = generateS3KeyForFile(sanPham.getMaSanPham(), filePart);
        s3Service.uploadObject(Constant.BUCKET_NAME_S3, keyFile, filePart.getInputStream());
        sanPham.setHinh(keyFile);

        saveOrUpdateSanPham(sanPham, request);

        response.sendRedirect(request.getContextPath() + "/san-pham");
    }

    /**
     * <p>
     * The method Redirect to detail page with error.
     * </p>
     *
     * @author MinhNgoc
     * @param request      the request
     * @param response     the response
     * @param maSanPhamStr the ma san pham str
     * @param errorMessage the error message
     * @throws IOException      Signals that an I/O exception has occurred.
     * @throws ServletException
     */
    private void redirectToDetailPageWithError(HttpServletRequest request, HttpServletResponse response,
            String maSanPhamStr, String errorMessage) throws IOException, ServletException {
        request.setAttribute("errorMessage", errorMessage);
        request.getRequestDispatcher("/views/san-pham/san-pham.jsp").forward(request, response);
    }

    /**
     * *
     * <p>
     * The method Builds the san pham from request.
     * </p>
     *
     * @author MinhNgoc
     * @param request      the request
     * @param sanPhamNoStr the san pham no str
     * @param loaiSanPham  the loai san pham
     * @return the san pham
     */
    private SanPham buildSanPhamFromRequest(HttpServletRequest request, String sanPhamNoStr, LoaiSanPham loaiSanPham) {
        SanPham sanPham = new SanPham();
        if (StringUtils.isNotBlank(sanPhamNoStr)) {
            sanPham.setSanPhamNo(Long.parseLong(sanPhamNoStr));
        }
        if (StringUtils.isNotBlank(request.getParameter("maSanPham"))) {
            sanPham.setMaSanPham(request.getParameter("maSanPham"));
        } else {
            sanPham.setMaSanPham(StringUtil.genCode(Constant.SP_CODE));
        }
        sanPham.setTenSanPham(request.getParameter("tenSanPham"));
        sanPham.setGiaNiemYet(new BigDecimal(request.getParameter("giaNiemYet")));
        sanPham.setLoaiSanPham(loaiSanPham);
        return sanPham;
    }

    /**
     * *
     * <p>
     * The method Generate S 3 key for file.
     * </p>
     *
     * @author MinhNgoc
     * @param maSanPham the ma san pham
     * @param filePart  the file part
     * @return the string
     */
    private String generateS3KeyForFile(String maSanPham, Part filePart) {
        String timestamp = DateUtil.convertPatternLocalDateTimeToString(LocalDateTime.now(),
                DateUtil.DATE_TIME_PATTERN);
        String fileName = timestamp + "_" + FileUtil.getFileName(filePart);
        return Constant.S3_FOLDER.formatted("san-pham", maSanPham, fileName);
    }

    /**
     * <p>
     * The method Save or update san pham.
     * </p>
     *
     * @author MinhNgoc
     * @param sanPham the san pham
     * @param request the request
     */
    private void saveOrUpdateSanPham(SanPham sanPham, HttpServletRequest request) {
        if (sanPham.getSanPhamNo() == null) {
            sanPhamDAO.save(sanPham);
            request.setAttribute("successMessage", "Lưu sản phẩm thành công !!!");
        } else {
            sanPhamDAO.update(sanPham);
            request.setAttribute("successMessage", "Cập nhật sản phẩm thành công !!!");
        }
    }

    /**
     * <p>
     * The method Do put.
     * </p>
     *
     * @author MinhNgoc
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        createOrUpdateSanPham(request, response);
    }

    /**
     * <p>
     * The method Do delete.
     * </p>
     *
     * @author MinhNgoc
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String maSanPham = request.getParameter("maSanPham");
        if (maSanPham != null) {
            try {
                // Log for debugging
                System.out.println("Attempting to delete product with maSanPham: " + maSanPham);

                // Attempt to delete the product
                sanPhamDAO.deleteByMaSanPham(maSanPham);
                request.setAttribute("successMessage", "Sản phẩm đã được xóa thành công !!!");

                // Log success
                System.out.println("Successfully deleted product with maSanPham: " + maSanPham);
            } catch (Exception e) {
                // Log the exception for debugging
                e.printStackTrace();
                request.setAttribute("errorMessage", "Có lỗi xảy ra khi xóa sản phẩm: " + e.getMessage());
            }
        } else {
            request.setAttribute("errorMessage", "Mã sản phẩm không hợp lệ hoặc không được cung cấp.");
        }

        // Load updated product list
        List<SanPham> sanPhamList = sanPhamDAO.findAll();
        for (SanPham sanPham : sanPhamList) {
            String url = s3Service.generatePresignedUrl(sanPham.getHinh(), Constant.BUCKET_NAME_S3);
            sanPham.setHinh(url);
        }
        request.setAttribute("sanPhamList", sanPhamList);

        // Forward to product list page
        request.getRequestDispatcher("/views/san-pham/san-pham.jsp").forward(request, response);
    }
}
