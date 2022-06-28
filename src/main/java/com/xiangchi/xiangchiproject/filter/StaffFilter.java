package com.xiangchi.xiangchiproject.filter;

import com.xiangchi.xiangchiproject.common.Constant;
import com.xiangchi.xiangchiproject.staff.model.dto.StaffDto;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class StaffFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        StaffDto currentStaff = (StaffDto) session.getAttribute(Constant.XIANGCHI_STAFF);
        if (null == currentStaff) {
            PrintWriter out = new HttpServletResponseWrapper((HttpServletResponse) servletResponse).getWriter();
            out.write("{\n" +
                    "    \"code\": 401,\n" +
                    "    \"message\": \"请先登录\",\n" +
                    "    \"data\": null\n" +
                    "}");
            out.flush();
            out.close();
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
