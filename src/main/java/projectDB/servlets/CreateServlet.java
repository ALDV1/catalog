package projectDB.servlets;

import projectDB.Product;
import projectDB.ProductDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/create")
public class CreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/project.jsp/create.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            Product product = new Product(name, price);
            ProductDB.insert(product);
            resp.sendRedirect(req.getContextPath() + "/catalog");
        }catch (Exception e){
            getServletContext().getRequestDispatcher("/project.jsp/create.jsp").forward(req,resp);
        }
    }
}
