package com.org.ultralntinct.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebFilter("/*")
public class I18NFilter implements HttpFilter {

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        String lang = req.getParameter("lang");
        if (lang != null) {
            req.getSession().setAttribute("lang", lang);
        }
        System.out.println("Current language: " + req.getSession().getAttribute("lang"));
        chain.doFilter(req, resp);
    }
}

