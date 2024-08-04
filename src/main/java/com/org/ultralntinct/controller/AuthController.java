package com.org.ultralntinct.controller;

import java.io.IOException;
import java.util.Optional;

import com.org.ultralntinct.dao.impl.NhanVienDAOImpl;
import com.org.ultralntinct.dto.UserSession;
import com.org.ultralntinct.model.NhanVien;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * The Class AuthController.
 *
 * @author MinhNgoc
 */
public class AuthController extends HttpServlet {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new auth controller.
     */
    public AuthController() {
        super();
    }

    /**
     * Do get.
     *
     * @author MinhNgoc
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/auth/dang-nhap.jsp").forward(request, response);
    }


    /**
     * Do post.
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

        String username = request.getParameter("username"); // username ->
                                                            // maNhanVien
        String password = request.getParameter("password");

        try {
            System.out.println("Attempting login for user: " + username);
            NhanVienDAOImpl dao = new NhanVienDAOImpl();
            // username ->// maNhanVien
            Optional<NhanVien> userOptional = dao.findByMaNhanVien(username);

            if (userOptional.isPresent()) {
                NhanVien user = userOptional.get();
                System.out.println("User found: " + user.getMaNhanVien());
                if (user.getMatKhau().equals(password)) {
                    System.out.println("Password matches for user: " + username);
                    UserSession userSession = UserSession.getInstance();
                    userSession.setUserName(username);
                    userSession.setRole(user.getChucVu());
                    userSession.setInformation(user.getTenNhanVien() + " " + user.getHoNhanVien());

                    request.getSession().setAttribute("user", userSession);
                    response.sendRedirect(request.getContextPath() + "/home");
                } else {
                    System.out.println("Password does not match for user: " + username);
                    request.setAttribute("message", "Invalid username or password");
                    request.getRequestDispatcher("/views/auth/dang-nhap.jsp").forward(request, response);
                }
            } else {
                System.out.println("User not found: " + username);
                request.setAttribute("message", "Invalid username or password");
                request.getRequestDispatcher("/views/auth/dang-nhap.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Login failed", e);
        }
    }
}
