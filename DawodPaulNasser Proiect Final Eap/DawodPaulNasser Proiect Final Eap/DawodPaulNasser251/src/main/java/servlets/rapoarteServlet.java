package servlets;

import repository.rapoarteRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/rapoarte")
public class rapoarteServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_u = -1;
        Cookie[] cookies=req.getCookies();
        for (int i = 0; i <cookies.length ; i++) {
            if(cookies[i].getName().equals("idU"))
            {

                id_u=Integer.parseInt(cookies[i].getValue());
            }
        }
        try {
            req.setAttribute("lungVac", rapoarteRepository.friendlyVacation(rapoarteRepository.ceaMaiLungaVacantaUser(id_u)));
            req.setAttribute("multeAtrac",rapoarteRepository.friendlyVacation(rapoarteRepository.celeMaiMulteAtractii(id_u)));
            req.setAttribute("scumpVac",rapoarteRepository.friendlyVacation(rapoarteRepository.ceaMaiScumpaVacanta(id_u)));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.getRequestDispatcher("rapoarte.jsp").forward(req,resp);
    }
}
