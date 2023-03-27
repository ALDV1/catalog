package projectDB.servlets;

import projectDB.Product;
import projectDB.ProductDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Product product = ProductDB.selectOne(id);
            if (product != null) {
                getServletContext().getRequestDispatcher("/project.jsp/edit.jsp").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/project.jsp/notfound.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            getServletContext().getRequestDispatcher("/project.jsp/notfound.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));

            Product product = new Product(id,name,price);
            ProductDB.update(product);
            resp.sendRedirect(req.getContextPath() + "/catalog");

        }catch(Exception e){
            getServletContext().getRequestDispatcher("/project.jsp/notfound.jsp").forward(req,resp);
        }
    }
}
