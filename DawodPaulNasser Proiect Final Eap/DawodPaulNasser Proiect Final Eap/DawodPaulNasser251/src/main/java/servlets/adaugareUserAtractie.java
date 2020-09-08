package servlets;

import repository.atractiiRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/adUsAtr")
public class adaugareUserAtractie extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
int i=0;
        for (int j = 0; j < cookies.length; j++) {
            if (cookies[j].getName().equals("idV")) {
                i = Integer.parseInt(cookies[j].getValue());
            }
            if (request.getParameter("bani").equals("") || request.getParameter("idAtr").equals("") || request.getParameter("rate").equals("") )
            {
                System.out.println("nu s-a introdus");
                request.getRequestDispatcher("paginaVacanta.jsp").forward(request,response);

            }
            else {
                try {
                    atractiiRepository.addAtrUser(Integer.parseInt(request.getParameter("idAtr")), i, Integer.parseInt(request.getParameter("rate")),
                            Integer.parseInt(request.getParameter("bani")), request.getParameter("com"));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                request.getRequestDispatcher("paginaVacanta.jsp").forward(request,response);
            }
        }

    }
}
