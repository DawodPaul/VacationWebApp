package servlets;

import models.vacante;
import repository.vacanteRepository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet("/vacanta")
public class vacanteServlet extends HttpServlet {

public void doGet(HttpServletRequest req, HttpServletResponse response)
{
    doPost(req,response);
}
    public void doPost(HttpServletRequest req, HttpServletResponse response)
    {
        int id_u = -1;
        Cookie[] cookies=req.getCookies();
        for (int i = 0; i <cookies.length ; i++) {
                if(cookies[i].getName().equals("idU"))
                {
                    System.out.println("a intrat");
                    id_u=Integer.parseInt(cookies[i].getValue());
                }
        }
        System.out.println("are valoarea="+ id_u);
        try {
            req.setAttribute("listVac",vacanteRepository.afisareVacanteIDU(id_u));
            req.getRequestDispatcher("vacante.jsp").forward(req,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
