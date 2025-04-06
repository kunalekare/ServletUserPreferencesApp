import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/Logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession hps2 = req.getSession(false);
        String Session_username = (String) hps2.getAttribute("name");
        PrintWriter pr = resp.getWriter();
        pr.print("Hi "+Session_username);
        if(hps2!=null){
            hps2.invalidate();
        }
        pr.print("<html>");
        pr.print("<body>");
        pr.print("<h3><p>You have successfully Logged out</p>");
        pr.print("<p>To again login,Click here</p>");
        pr.print("<a href='New_file.html'>Login</a></h3>");
        pr.print("</body>");
        pr.print("</html>");
    }
}
