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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/manVac")
public class managerVacante extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bool=0;
        Cookie[] cookies1= req.getCookies();
        for (int j = 0; j < cookies1.length; j++) {
            if (cookies1[j].getName().equals("idV")) {
               bool=1;
            }
        }
        if(bool==0) {
            if (req.getParameter("idLoc").equals("") || req.getParameter("dataStrt").equals("") || req.getParameter("dataStop").equals("") || req.getParameter("bani").equals("")) {
                System.out.println("nu intra");
                req.getRequestDispatcher("testN.jsp").forward(req, resp);
            } else {
                int id_u = -1;
                Cookie[] cookies = req.getCookies();
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals("idU")) {
                        System.out.println("a intrat");
                        id_u = Integer.parseInt(cookies[i].getValue());
                    }
                }

                try {
                    java.util.Date t = new SimpleDateFormat("yyyy-MM-dd").parse((String) req.getParameter("dataStrt"));
                    Date st = new java.sql.Date(t.getTime());
                    t = new SimpleDateFormat("yyyy-MM-dd").parse((String) req.getParameter("dataStop"));
                    Date fn = new java.sql.Date(t.getTime());
                    int id_v = vacanteRepository.addVacanta(id_u, Integer.parseInt((String) req.getParameter("idLoc")), st, fn,
                            Integer.parseInt((String) req.getParameter("bani")));
                    System.out.println(id_v);
                    req.setAttribute("id_v", id_v);
                } catch (SQLException | ParseException throwables) {
                    throwables.printStackTrace();
                }


            }
            req.getRequestDispatcher("paginaVacanta.jsp").forward(req, resp);
        }
        if(bool==1)
        {
            req.getRequestDispatcher("paginaVacanta.jsp").forward(req, resp);
        }

    }

}
