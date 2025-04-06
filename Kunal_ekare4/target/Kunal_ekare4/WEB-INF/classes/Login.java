import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String namerec = req.getParameter("name");
        String passwordrec = req.getParameter("password");
        String rolerec = req.getParameter("role");

        PrintWriter pr = resp.getWriter();
        resp.setContentType("text/html");

        if (namerec != null && namerec.equals("Kartik") && passwordrec != null && passwordrec.equals("12345") && namerec.equals("Kartik") && passwordrec.equals("12345") && rolerec.equals("Student")) {
            HttpSession hps = req.getSession(true);
            hps.setAttribute("Username", namerec);
            hps.setAttribute("Password", passwordrec);
            hps.setAttribute("Role", rolerec);

            pr.print("<html>");
            pr.print("<body>");
            pr.print("<h1>Hello " + namerec + "</h1>");
            pr.print("<a href='Aboutus' action='Aboutus' method ='get'>About us</a><br>");
            //pr.print("<a href='Session/Aboutus_white.html'>About us</a><br>");
            pr.print("<a href='Logout'>Logout</a>");
            pr.print("</body>");
            pr.print("</html>");
        } else {
            System.out.println("Incorrect Credentials");
            pr.print("Invalid, please try again");
            resp.sendRedirect("Login.html"); // Adjust this path as necessary
        }
    }
}
