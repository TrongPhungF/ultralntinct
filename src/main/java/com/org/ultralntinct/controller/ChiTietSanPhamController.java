package com.org.ultralntinct.controller;

import com.org.ultralntinct.dao.impl.SanPhamDAOImpl;
import com.org.ultralntinct.dao.jpa.SanPhamDAO;
import com.org.ultralntinct.model.SanPham;
import com.org.ultralntinct.service.S3Service;
import com.org.ultralntinct.utils.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class ChiTietSanPhamController
 */
@WebServlet("/chi-tiet-san-pham")
public class ChiTietSanPhamController extends HttpServlet {

    private static final long serialVersionUID = 1L;


    private final SanPhamDAO sanPhamDAO;

    private final S3Service s3Service;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietSanPhamController() {
        super();
        sanPhamDAO = new SanPhamDAOImpl();
        s3Service = new S3Service();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String maSanPhamStr = request.getParameter("maSanPham");
        if (StringUtils.isNotBlank(maSanPhamStr)) {
            Optional<SanPham> sanPham = sanPhamDAO.findByMaSanPham(maSanPhamStr);
            sanPham.ifPresent(pham -> {
                String url = s3Service.generatePresignedUrl(pham.getHinh(), Constant.BUCKET_NAME_S3);
                pham.setHinh(url);
                request.setAttribute("sanPham", pham);
            });
            request.setAttribute("isCreate", Boolean.FALSE);
        } else {
            request.setAttribute("isCreate", Boolean.TRUE);
        }
        request.getRequestDispatcher("/views/san-pham/chi-tiet-san-pham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }

}
