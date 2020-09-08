package servlets;

import repository.vacanteRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteVac")
public class deleteVac extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        int temp = -1;
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("idV")) {
                temp = Integer.parseInt(cookies[i].getValue());
            }
        }

        try {
            vacanteRepository.deleteVac(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" mere");


        req.getRequestDispatcher("vacanta").forward(req, resp);
    }
    }

