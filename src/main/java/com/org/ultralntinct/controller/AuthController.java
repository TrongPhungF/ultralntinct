package com.org.ultralntinct.controller;

import java.io.IOException;
import java.util.Optional;

import com.org.ultralntinct.dao.impl.NhanVienDAOImpl;
import com.org.ultralntinct.dao.jpa.NhanVienDAO;
import com.org.ultralntinct.dto.UserSession;
import com.org.ultralntinct.model.NhanVien;
import com.org.ultralntinct.utils.Constant;
import com.org.ultralntinct.utils.UrlConstant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

/**
 * The Class AuthController.
 *
 * @author MinhNgoc
 */
@Log4j2
@WebServlet(urlPatterns = { "/dang-nhap", "/dang-xuat", "/tu-choi-truy-cap" })
public class AuthController extends HttpServlet {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The nhan vien DAO. */
    private final NhanVienDAO nhanVienDAO;

    /**
     * Instantiates a new auth controller.
     */
    public AuthController() {
        super();
        nhanVienDAO = new NhanVienDAOImpl();
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
        log.info("Xin chao ");
        String uri = request.getRequestURI();
        if (uri.contains("dang-nhap")) {
            doSignIn(request, response);
        }
//        else if (uri.contains("sign-up")) {
//            doSignUp(request, response);
        else if (uri.contains("dang-xuat")) {
            doSignOut(request, response);
        } else if (uri.contains("tu-choi-truy-cap")) {
            doAccessDenied(request, response);
        }

//        } else if (uri.contains("edit-profile")) {
//            doEditProfile(request, response);
//        } 
//		else if (uri.contains("forgot-password")) {
//
//        } else if (uri.contains("change-password")) {
//
//        }
    }

    /**
     * <p>
     * The method Do sign in.
     * </p>
     *
     * @author MinhNgoc
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    private void doSignIn(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getMethod();
        System.out.println("Do Signin");
        if (method.equalsIgnoreCase("POST")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            try {
                System.out.println("Attempting login for user: " + username);
                Optional<NhanVien> userOptional = nhanVienDAO.findByMaNhanVien(username);

                if (userOptional.isPresent()) {
                    NhanVien user = userOptional.get();
                    System.out.println("User found: " + user.getMaNhanVien());
                    if (user.getMatKhau().equals(password)) {
                        System.out.println("Password matches for user: " + username);
                        UserSession userSession = UserSession.getInstance();
                        userSession.setUserName(username);
                        userSession.setRole(user.getChucVu());
                        userSession.setInformation(user.getTenNhanVien() + " " + user.getHoNhanVien());
                        request.getSession().setAttribute(Constant.USER_SESSION, userSession);
                        request.getRequestDispatcher(UrlConstant.URL_HOME).forward(request, response);
                    } else {
                        System.out.println("Password does not match for user: " + username);
                        request.setAttribute(Constant.MESSAGE, "Invalid username or password");
                        request.getRequestDispatcher(UrlConstant.VIEW_URL_DANG_NHAP).forward(request, response);
                    }
                } else {
                    System.out.println("User not found: " + username);
                    request.setAttribute(Constant.MESSAGE, "Invalid username or password");
                    request.getRequestDispatcher(UrlConstant.VIEW_URL_DANG_NHAP).forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new ServletException("Login failed", e);
            }
        } else {
            request.getRequestDispatcher(UrlConstant.VIEW_URL_DANG_NHAP).forward(request, response);
        }
    }

    /**
     * <p>
     * The method Do access denied.
     * </p>
     *
     * @author MinhNgoc
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    private void doAccessDenied(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(UrlConstant.VIEW_URL_TU_CHOI_TRUY_CAP).forward(request, response);
    }

    /**
     * <p>
     * The method Do sign out.
     * </p>
     *
     * @author phung
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    private void doSignOut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.removeAttribute(Constant.USER_SESSION);
        session.invalidate();
        request.setAttribute(Constant.MESSAGE, "Đăng xuất thành công !!!");
        request.getRequestDispatcher(UrlConstant.VIEW_URL_DANG_NHAP).forward(request, response);
    }
}
