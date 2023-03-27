package projectDB.servlets;

import projectDB.ProductDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(req.getParameter("id"));
            ProductDB.delete(id);
            resp.sendRedirect(req.getContextPath() + "/catalog");
        }catch (Exception e){
            getServletContext().getRequestDispatcher("/project.jsp/notfound.jsp").forward(req,resp);
        }
    }
}
