/*
package somePackage;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;


@WebServlet(urlPatterns = "/catalog")
public class ProductServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            //устанвливаем соединение с базой данных
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
            // Делаем Sql-запрос
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM products");
            // Записываем данные
            ResultSet rs = pstmt.executeQuery();


            while (rs.next()) {
                Products phones = new Products();
                phones.setId(rs.getInt("id"));
                phones.setProductName(rs.getString("productName"));
                phones.setManufacture(rs.getString("manufacture"));
                phones.setProductCount(rs.getInt("productCount"));
                phones.setPrice(rs.getDouble("price"));
                pw.println("<h2>" + phones + "</h2>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
*/
