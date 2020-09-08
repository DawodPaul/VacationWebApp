package servlets;

import repository.vacanteRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/updateVacanta")
public class updateVacanta extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        if (req.getParameter("dataStrt").equals("") || req.getParameter("dataStop").equals("") || req.getParameter("bani").equals(""))
        {

        }
        else {
        Cookie[] cookies = req.getCookies();
        int temp = -1;
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("idV")) {
                temp = Integer.parseInt(cookies[i].getValue());
            }
        }

        try {
            java.util.Date t = new SimpleDateFormat("yyyy-MM-dd").parse((String) req.getParameter("dataStrt"));
            Date st = new java.sql.Date(t.getTime());
            t = new SimpleDateFormat("yyyy-MM-dd").parse((String) req.getParameter("dataStop"));
            Date fn = new java.sql.Date(t.getTime());
            vacanteRepository.updateVac(temp,st,fn,Integer.parseInt(req.getParameter("bani")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("paginaVacanta.jsp").forward(req,response);
        }
    }
}
