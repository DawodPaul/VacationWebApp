package servlets;
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

@WebServlet("/creare")
public class creareContServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        if (req.getParameter("user").equals("") || req.getParameter("parola").equals("") || req.getParameter("nume").equals("") || req.getParameter("prenume").equals("")) {
            req.setAttribute("mesajCreareCont", "Toate campurile trebuie completate!");
            req.getRequestDispatcher("creareCont.jsp").forward(req, response);
        } else {
            try {
                if (userRepository.Unique_User_BD(DbConnection.Deschidere_Con_BD(), req.getParameter("user")) == true) {

                    userRepository.creareUserBD(req.getParameter("user"), req.getParameter("parola"), req.getParameter("nume"), req.getParameter("prenume"));
                    req.setAttribute("mesajCreareCont", "Cont creat");
                    req.getRequestDispatcher("creareCont.jsp").forward(req, response);
                } else {
                    req.setAttribute("mesajCreareCont", "User deja existent");
                    req.getRequestDispatcher("creareCont.jsp").forward(req, response);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();

            }
        }
    }
}
