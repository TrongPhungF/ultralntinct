package com.org.ultralntinct.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.org.ultralntinct.dao.impl.SanPhamDAOImpl;
import com.org.ultralntinct.dao.jpa.SanPhamDAO;
import com.org.ultralntinct.model.SanPham;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <p>
 * Servlet implementation class HomeController
 * </p>
 *
 * @author MinhNgoc
 */

public class SanPhamController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private SanPhamDAO sanPhamDAO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SanPhamController() {
        sanPhamDAO = new SanPhamDAOImpl();
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
        request.setAttribute("sanPhamList", sanPhamList);
        request.getRequestDispatcher("/views/san-pham/san-pham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getParameter("_method");
        if ("put".equals(method)) {
            doPut(request, response);
        } else if ("delete".equals(method)) {
            doDelete(request, response);
        } else {
            createOrUpdateSanPham(request, response);
        }
    }

    private void createOrUpdateSanPham(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");
        String sanPhamNoStr = request.getParameter("sanPhamNo");
        SanPham sanPham = new SanPham();
        if (StringUtils.isNotBlank(sanPhamNoStr)) {
            sanPham.setSanPhamNo(Long.parseLong(sanPhamNoStr));
        }
        sanPham.setMaSanPham(request.getParameter("maSanPham"));
        sanPham.setTenSanPham(request.getParameter("tenSanPham"));
        sanPham.setGiaNiemYet(new BigDecimal(request.getParameter("giaNiemYet")));
        sanPham.setHinh(request.getParameter("hinh"));
        if (sanPham.getSanPhamNo() == null) {
            sanPhamDAO.save(sanPham);
        } else {
            sanPhamDAO.update(sanPham);
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



