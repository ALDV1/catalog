package somePackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/contextApplication")
public class BasicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user",getUsers());
        req.getRequestDispatcher("/basic.jsp").forward(req,resp);
    }

    private List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User("Alex",14));
        users.add(new User("Tom",22));
        users.add(new User("Serghey",26));
        users.add(new User("Vlad",30));
        return users;
    }
}
