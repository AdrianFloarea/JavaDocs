package ro.teamnet.zth.web;

import ro.teamnet.zth.file.LogFileWriter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by user on 7/13/2016.
 */
public class HeadersLogFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LogFileWriter.logHeader("user",request.getParameter("user").toString());
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
