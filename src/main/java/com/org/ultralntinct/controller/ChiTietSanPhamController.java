package com.org.ultralntinct.controller;

import java.io.IOException;
import java.util.Optional;

import com.org.ultralntinct.dao.impl.SanPhamDAOImpl;
import com.org.ultralntinct.dao.jpa.SanPhamDAO;
import com.org.ultralntinct.model.SanPham;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChiTietSanPhamController
 */
@WebServlet("/chi-tiet-san-pham")
public class ChiTietSanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    private SanPhamDAO sanPhamDAO;

  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietSanPhamController() {
        super();
        sanPhamDAO = new SanPhamDAOImpl();
        // TODO Auto-generated constructor stub
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sanPhamNoStr = request.getParameter("sanPhamNo");
        if (sanPhamNoStr != null && !sanPhamNoStr.isEmpty()) {
            Long sanPhamNo = Long.parseLong(sanPhamNoStr);
            Optional<SanPham> sanPham = sanPhamDAO.findById(sanPhamNo);
            if (sanPham.isPresent()) {
                request.setAttribute("sanPham", sanPham.get());
            }
        }
        request.getRequestDispatcher("/views/san-pham/chi-tiet-san-pham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
