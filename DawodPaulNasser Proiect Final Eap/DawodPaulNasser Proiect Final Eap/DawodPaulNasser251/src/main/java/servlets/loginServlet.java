package servlets;


import models.user;
import repository.userRepository;
import utils.DbConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/log")
public class loginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("logare.jsp").forward(req,resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


        try {
            if(userRepository.logare_BD(req.getParameter("user"),req.getParameter("parola"))!=null) {
                req.setAttribute("user", userRepository.logare_BD(req.getParameter("user"), req.getParameter("parola")));
                req.setAttribute("return","0");
            }
            else
            {
                req.setAttribute("return","1");
            }
            System.out.println(req.getAttribute("return"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



        if(req.getAttribute("return")=="0") {
            user User =(user) req.getAttribute("user");
                    Cookie cookieU = new Cookie("idU", User.getIdUser().toString());
            resp.addCookie(cookieU);
        }
        req.getRequestDispatcher("logare.jsp").forward(req,resp);

    }
}
