package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/tst")
public class tstservlet extends HttpServlet{





    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


        System.out.println("aici:"+req.getParameter("subject"));
            req.getRequestDispatcher("cookie.jsp").forward(req,resp);

        }



    }


