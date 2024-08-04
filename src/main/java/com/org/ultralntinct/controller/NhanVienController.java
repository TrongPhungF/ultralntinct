package com.org.ultralntinct.controller;

import java.io.IOException;
import java.util.List;

import com.org.ultralntinct.dao.impl.NhanVienDAOImpl;
import com.org.ultralntinct.dao.jpa.NhanVienDAO;
import com.org.ultralntinct.model.NhanVien;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NhanVienController
 */
@WebServlet(urlPatterns = {"/nhan-vien"})
public class NhanVienController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private NhanVienDAO nhanVienDAO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NhanVienController() {
        nhanVienDAO = new NhanVienDAOImpl();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        List<NhanVien> nhanVienList = nhanVienDAO.findAll();
        nhanVienList.forEach(t -> System.out.println(t.toString()));
        request.setAttribute("nhanVienList", nhanVienList);
        request.getRequestDispatcher("/views/nhan-vien/nhan-vien.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
