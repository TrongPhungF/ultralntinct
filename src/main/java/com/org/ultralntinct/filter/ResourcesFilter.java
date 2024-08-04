package com.org.ultralntinct.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/img/*", "/css/*", "/icon/*", "/bootstrap-5.3.3-dist/*", "/views/*" })
public class ResourcesFilter implements HttpFilter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Initialization code if needed
	}

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// Allow all requests to resources
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// Cleanup code if needed
	}

}
