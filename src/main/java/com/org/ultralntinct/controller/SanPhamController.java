package com.org.ultralntinct.controller;

import java.io.IOException;
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

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
     */
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
     */
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
