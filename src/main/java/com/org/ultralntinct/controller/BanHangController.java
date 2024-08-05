package com.org.ultralntinct.controller;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import com.org.ultralntinct.dao.impl.SanPhamDAOImpl;
import com.org.ultralntinct.dao.jpa.SanPhamDAO;
import com.org.ultralntinct.model.SanPham;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BanHangController
 */
@WebServlet(urlPatterns = { "/ban-hang" })
public class BanHangController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String SAN_PHAM_LIST = "sanPhamList";
    private static final String VIEW_BAN_HANG_INIT = "/views/hoa-don/ban-hang.jsp";

    private final SanPhamDAO sanPhamDAO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BanHangController() {
        super();
        sanPhamDAO = new SanPhamDAOImpl();
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
        } else if (uri.contains("dang-xuat")) {
//            doSignOut(request, response);
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

        List<SanPham> sanPhamList = sanPhamDAO.findAll();
        sanPhamList.sort(Comparator.comparing(SanPham::getSanPhamNo, Comparator.nullsLast(Comparator.reverseOrder())));
        request.setAttribute(SAN_PHAM_LIST, sanPhamList);

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
