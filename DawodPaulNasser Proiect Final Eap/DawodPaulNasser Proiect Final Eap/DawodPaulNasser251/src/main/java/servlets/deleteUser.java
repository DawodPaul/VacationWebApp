package servlets;


import repository.userRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete")
public class deleteUser extends HttpServlet {


    public  void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
            Cookie[] cookies = req.getCookies();

            int temp = -1;
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("idU")) {
                    temp = Integer.parseInt(cookies[i].getValue());
                }
            }
            try {
                userRepository.stergereUser(temp);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            req.getRequestDispatcher("paginaPrincipala.jsp").forward(req, resp);
        }
    }

