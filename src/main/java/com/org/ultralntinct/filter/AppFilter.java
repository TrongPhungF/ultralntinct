package com.org.ultralntinct.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.org.ultralntinct.dto.UserSession;
import com.org.ultralntinct.utils.Constant;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class AppFilter implements HttpFilter {

	private static final String[] SALE_URL = { "/hoa-don", "/ban-hang", "/san-pham", "/chi-tiet-san-pham",
			"/khach-hang", "/chi-tiet-khach-hang" };
	private static final String[] STORER_URL = { "/san-pham", "/chi-tiet-san-pham", "/kho-hang", "/chi-tiet-kho-hang" };
	private static final String[] COMMON_URL = { "/home", "/thay-doi-mat-khau", "/thong-tin-tai-khoan", "/dang-nhap" };

	private static final Map<String, String[]> ROLE_URL_MAP = new HashMap<>();

	static {
		ROLE_URL_MAP.put(Constant.NV_BAN_HANG, SALE_URL);
		ROLE_URL_MAP.put(Constant.NV_KHO, STORER_URL);
	}

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("user") == null) {
			request.getRequestDispatcher("/dang-nhap").forward(request, response);
		} else {

			UserSession userSession = (UserSession) session.getAttribute("user");
			String requestURI = request.getRequestURI();
			if (isAccessAllowed(requestURI, userSession)) {
				chain.doFilter(request, response);
			} else {
				// If access is not allowed, redirect to access denied page
				request.getRequestDispatcher("/tu-choi-truy-cap").forward(request, response);
			}
		}
	}

	private boolean isAccessAllowed(String requestURI, UserSession userSession) {
		String userRole = userSession.getRole();

		if (Constant.ADMIN.equals(userRole)) {
			return true;
		}

		// Check if the URL is a common URL
		if (isUrlMatch(requestURI, COMMON_URL)) {
			return true;
		}

		// Check access based on role
		String[] allowedUrls = ROLE_URL_MAP.get(userRole);
		return allowedUrls != null && isUrlMatch(requestURI, allowedUrls);
	}

	private boolean isUrlMatch(String requestURI, String[] urlPatterns) {
		for (String urlPattern : urlPatterns) {
			if (requestURI.contains(urlPattern)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}
