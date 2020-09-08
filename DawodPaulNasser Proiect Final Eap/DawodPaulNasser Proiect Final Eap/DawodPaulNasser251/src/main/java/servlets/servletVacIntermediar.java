package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vacInterm")
public class servletVacIntermediar  extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {

       // request.setAttribute("id_v");
        //request.getRequestDispatcher("paginaVacanta.jsp").forward(request,response);
    }
}
