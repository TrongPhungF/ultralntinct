package com.org.ultralntinct.controller;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.org.ultralntinct.dao.impl.KhachHangDAOImpl;
import com.org.ultralntinct.dao.impl.SanPhamDAOImpl;
import com.org.ultralntinct.dao.jpa.KhachHangDAO;
import com.org.ultralntinct.dao.jpa.SanPhamDAO;
import com.org.ultralntinct.model.KhachHang;
import com.org.ultralntinct.model.SanPham;
import com.org.ultralntinct.service.S3Service;
import com.org.ultralntinct.utils.Constant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BanHangController
 */
@WebServlet(urlPatterns = { "/ban-hang", "/ban-hang-get-khach-hang" })
public class BanHangController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String SAN_PHAM_LIST = "sanPhamList";
    private static final String VIEW_BAN_HANG_INIT = "/views/hoa-don/ban-hang.jsp";

    private final SanPhamDAO sanPhamDAO;

    private final S3Service s3Service;

    private final KhachHangDAO khachHangDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BanHangController() {
        super();
        sanPhamDAO = new SanPhamDAOImpl();
        s3Service = new S3Service();
        khachHangDAO = new KhachHangDAOImpl();
    }

    /**
     * Do service.
     *
     * @author MinhNgoc
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("ban-hang")) {
            doBanHang(request, response);
        } else if (uri.contains("get-khach-hang")) {
            doBanHangGetKhachHang(request, response);
        } else if (uri.contains("tu-choi-truy-cap")) {
//            doAccessDenied(request, response);
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doBanHang(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sanPhamKeySearch = request.getParameter("sanPhamKeySearch");
        String inputMaKhachHang = request.getParameter("inputMaKhachHang");

        List<SanPham> sanPhamList;
        if (StringUtils.isNotBlank(sanPhamKeySearch)) {
            sanPhamList = sanPhamDAO.searchSanPham(sanPhamKeySearch);
        } else {
            sanPhamList = sanPhamDAO.findAll();
        }

        KhachHang khachHang = new KhachHang();
        if (StringUtils.isNotBlank(inputMaKhachHang)) {
            khachHang = khachHangDAO.findByMaKhachHang(inputMaKhachHang).orElse(khachHang);
        }

        sanPhamList.sort(Comparator.comparing(SanPham::getSanPhamNo, Comparator.nullsLast(Comparator.reverseOrder())));
        sanPhamList.forEach((SanPham sanPham) -> {
            String url = s3Service.generatePresignedUrl(sanPham.getHinh(), Constant.BUCKET_NAME_S3);
            sanPham.setHinh(url);
        });

        request.setAttribute(SAN_PHAM_LIST, sanPhamList);
        request.setAttribute("khachHang", khachHang);
        request.getRequestDispatcher(VIEW_BAN_HANG_INIT).forward(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doBanHangGetKhachHang(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String maKhachHang = request.getParameter("inputMaKhachHang");
        List<SanPham> sanPhamList = sanPhamDAO.findAll();
        sanPhamList.sort(Comparator.comparing(SanPham::getSanPhamNo, Comparator.nullsLast(Comparator.reverseOrder())));
        sanPhamList.forEach((SanPham sanPham) -> {
            String url = s3Service.generatePresignedUrl(sanPham.getHinh(), Constant.BUCKET_NAME_S3);
            sanPham.setHinh(url);
        });
        request.setAttribute(SAN_PHAM_LIST, sanPhamList);
        KhachHang khachHang = khachHangDAO.findByMaKhachHang(maKhachHang).orElse(new KhachHang());
        request.setAttribute("khachHang", khachHang);
        request.getRequestDispatcher(VIEW_BAN_HANG_INIT).forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
