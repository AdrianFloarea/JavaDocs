package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by user on 7/12/2016.
 */
public class InfoHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headers=req.getHeaderNames();
        PrintWriter out=resp.getWriter();
        StringBuffer s=new StringBuffer("<table>");
        while (headers.hasMoreElements()){
            String headerName=headers.nextElement();
            s.append("<tr><td>"+headerName+"</td><td>"+req.getHeader(headerName)+"</td></tr>");
        }
        s.append("</table>");
        out.write(s.toString());
    }
}
