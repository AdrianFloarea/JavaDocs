package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by user on 7/13/2016.
 */
public class HttpSessionZTH extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user=req.getParameter("username");
        String pass=req.getParameter("password");
        Cookie[] cookies=req.getCookies();
        if(user.equals("admin")&&pass.equals("admin")){
            PrintWriter out=resp.getWriter();
            out.write("Welcome back! /nUsername:"+user);
            for(Cookie c:cookies){
                out.write(c.getName()+":"+c.getValue());
            }
            out.write("The seesion id is: "+req.getSession().getId());
        }else{
            HttpSession session=req.getSession();
            session.setAttribute("username",user);
            session.setAttribute("session",session);
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("views/loginFail.jsp");
            requestDispatcher.forward(req,resp);
        }
    }
}
