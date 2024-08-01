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

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * <p>
 * Servlet implementation class HomeController
 * </p>
 *
 * @author MinhNgoc
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class SanPhamController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final SanPhamDAO sanPhamDAO;

    private final LoaiSanPhamDAO loaiSanPhamDAO;

    private final S3Service s3Service;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SanPhamController() {
        sanPhamDAO = new SanPhamDAOImpl();
        s3Service = new S3Service();
        loaiSanPhamDAO = new LoaiSanPhamDAOImpl();
    }

    /**
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
        sanPhamList.stream().filter(sanPham -> StringUtils.isNotBlank(sanPham.getHinh())).peek(
                sanPham -> sanPham.setHinh(s3Service.generatePresignedUrl(sanPham.getHinh(), Constant.BUCKET_NAME_S3)));

        request.setAttribute("sanPhamList", sanPhamList);
        request.getRequestDispatcher("/views/san-pham/san-pham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getParameter("_method");
        if ("put".equals(method)) {
            doPut(request, response);
        }

        if ("delete".equals(method)) {
            doDelete(request, response);
        }

    }

    private void createOrUpdateSanPham(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String sanPhamNoStr = request.getParameter("sanPhamNo");
        String maSanPhamStr = request.getParameter("maSanPham");
        Optional<SanPham> optionalSanPham = sanPhamDAO.findByMaSanPham(maSanPhamStr);
        if (optionalSanPham.isEmpty()) {
            request.setAttribute("errorMessage", "Không tìm thấy sản phẩm !!!");
            response.sendRedirect(request.getContextPath() + "/chi-tiet-san-pham?maSanPham=" + maSanPhamStr);
            return;
        }

        String maLoaiSanPhamStr = request.getParameter("maLoaiSanPham");
        Optional<LoaiSanPham> optLoaiSanPham = loaiSanPhamDAO.findByMaLoaiSanPham(maLoaiSanPhamStr);
        LoaiSanPham loaiSanPham = null;
        if (optLoaiSanPham.isEmpty()) {
            request.setAttribute("errorMessage", "Không tìm thấy mã loại sản phẩm !!!");
            response.sendRedirect(request.getContextPath() + "/chi-tiet-san-pham?maSanPham=" + maSanPhamStr);
            return;
        } else {
            loaiSanPham = optLoaiSanPham.get();
        }

        SanPham sanPham = new SanPham();
        if (StringUtils.isNotBlank(sanPhamNoStr)) {
            sanPham.setSanPhamNo(Long.parseLong(sanPhamNoStr));
        }
        sanPham.setMaSanPham(request.getParameter("maSanPham"));
        sanPham.setTenSanPham(request.getParameter("tenSanPham"));
        sanPham.setGiaNiemYet(new BigDecimal(request.getParameter("giaNiemYet")));

        Part filePart = request.getPart("hinh");

        StringBuilder fileName = new StringBuilder(
                DateUtil.convertPatternLocalDateTimeToString(LocalDateTime.now(), DateUtil.DATE_TIME_PATTERN))
                .append("_").append(FileUtil.getFileName(filePart));

        String keyFile = Constant.S3_FORDER.formatted("san-pham", sanPham.getMaSanPham(), fileName);

        s3Service.uploadObject(Constant.BUCKET_NAME_S3, keyFile, filePart.getInputStream());
        sanPham.setHinh(keyFile);
        sanPham.setLoaiSanPham(loaiSanPham);

        if (sanPham.getSanPhamNo() == null) {
            sanPhamDAO.save(sanPham);
            request.setAttribute("successMessage", "Lưu sản phẩm thành công !!!");
        } else {
            sanPhamDAO.update(sanPham);
            request.setAttribute("successMessage", "Cập nhật sản phẩm thành công !!!");
        }

        response.sendRedirect(request.getContextPath() + "/san-pham");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        createOrUpdateSanPham(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long sanPhamNo = Long.parseLong(request.getParameter("sanPhamNo"));
        sanPhamDAO.deleteById(sanPhamNo);
        response.sendRedirect(request.getContextPath() + "/san-pham");
    }
}
