package com.org.ultralntinct.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <p>
 * The Class ResourcesFilter.
 * </p>
 *
 * @author phung
 */
@WebFilter(urlPatterns = { "/img/*", "/css/*", "/icon/*", "/bootstrap-5.3.3-dist/*", "/views/*" })
public class ResourcesFilter implements HttpFilter {

    /**
     * <p>
     * The method Inits the.
     * </p>
     *
     * @author MinhNgoc
     * @param filterConfig the filter config
     * @throws ServletException the servlet exception
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code if needed
    }

    /**
     * <p>
     * The method Do filter.
     * </p>
     *
     * @author MinhNgoc
     * @param request  the request
     * @param response the response
     * @param chain    the chain
     * @throws IOException      Signals that an I/O exception has occurred.
     * @throws ServletException the servlet exception
     */
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // Allow all requests to resources
        chain.doFilter(request, response);
    }

    /**
     * <p>
     * The method Destroy.
     * </p>
     *
     * @author MinhNgoc
     */
    @Override
    public void destroy() {
        // Cleanup code if needed
    }

}
