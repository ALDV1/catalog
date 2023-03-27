package projectDB.servlets;

import projectDB.Product;
import projectDB.ProductDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/catalog")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = ProductDB.select();
        req.setAttribute("products",products);

        getServletContext().getRequestDispatcher("/project.jsp/index.jsp").forward(req,resp);
    }
}
