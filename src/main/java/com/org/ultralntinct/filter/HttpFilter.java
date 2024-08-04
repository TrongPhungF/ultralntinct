package com.org.ultralntinct.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <p>
 * The Interface HttpFilter.
 * </p>
 *
 * @author MinhNgoc
 */
public interface HttpFilter extends Filter {

    /**
     * <p>
     * The method Do filter.
     * </p>
     *
     * @author MinhNgoc
     * @param arg0 the arg 0
     * @param arg1 the arg 1
     * @param arg2 the arg 2
     * @throws IOException      Signals that an I/O exception has occurred.
     * @throws ServletException the servlet exception
     */
    @Override
    default void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        this.doFilter(request, response, arg2);
    }

    /**
     * <p>
     * The method Do filter.
     * </p>
     *
     * @author MinhNgoc
     * @param request  the request
     * @param response the response
     * @param arg2     the arg 2
     * @throws IOException      Signals that an I/O exception has occurred.
     * @throws ServletException the servlet exception
     */
    void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain arg2)
            throws IOException, ServletException;

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
    default void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    /**
     * <p>
     * The method Destroy.
     * </p>
     *
     * @author MinhNgoc
     */
    @Override
    default void destroy() {
        Filter.super.destroy();
    }
}
