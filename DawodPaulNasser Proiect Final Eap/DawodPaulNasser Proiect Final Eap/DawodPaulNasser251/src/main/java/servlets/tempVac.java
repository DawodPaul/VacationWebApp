package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tempVac")
public class tempVac extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("idVT")!=null) {
            Cookie idV = new Cookie("idV", req.getParameter("idVT"));
            resp.addCookie(idV);
        }
        req.getRequestDispatcher("paginaVacanta.jsp").forward(req,resp);
    }
}
