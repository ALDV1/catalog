package somePackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/hello")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // получаем объект сессии
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        User tom = (User) session.getAttribute("firstUser");
        User jack = (User) session.getAttribute("secondUser");
        //возвращаем из сессии объект с ключом: name. Если он не был определен ранее, то возвращается null

        try (PrintWriter pw = resp.getWriter()) {
            if (tom == null && jack == null) {
                pw.println("Session are set");

                tom = new User("Tom Soyer",13);
                jack = new User("Jack Jones",25);

                session.setAttribute("firstUser", tom);
                session.setAttribute("secondUser", jack);
            } else {
                pw.println("Name:" + tom.getUserName() + "<br>Age: " + tom.getAge());
                pw.println("<br>Name:" + jack.getUserName() + "<br>Age: " + jack.getAge());
                pw.println("<br>session id: " + session.getId());
            }
        }finally {
            Enumeration keys = session.getAttributeNames();
            while(keys.hasMoreElements()){
                System.out.println(keys.nextElement());
            }
        }
    }
}
