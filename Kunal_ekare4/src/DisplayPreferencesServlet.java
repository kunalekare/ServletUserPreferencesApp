import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DisplayPreferences")
public class DisplayPreferencesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        PrintWriter pr = resp.getWriter();
        resp.setContentType("text/html");
        if (session != null) {
            String name = (String) session.getAttribute("name");
            String pass = (String) session.getAttribute("password");
            String preferredLanguage = (String) session.getAttribute("preferredLanguage");
            String theme = (String) session.getAttribute("theme");
            String notificationSetting = (String) session.getAttribute("notificationSetting");
            String cssClass = "light-mode";
            String bodyStyle = "background-color: white; color: black;";
            if ("Dark Mode".equals(theme)) {
                cssClass = "dark-mode";
                bodyStyle = "background-color: black; color: white;";
            }
            pr.print("<html><head><style>");
            pr.print("body { font-family: Arial, sans-serif; margin: 0; padding: 20px; }");
            pr.print("h1 { margin-bottom: 20px; }");
            pr.print(".dark-mode { background-color: black; color: white; }");
            pr.print(".light-mode { background-color: white; color: black; }");
            pr.print("a { color: #007BFF; text-decoration: none; }");
            pr.print("a:hover { text-decoration: underline; }");
            pr.print("button { background-color: #007BFF; color: white; border: none; padding: 10px 15px; border-radius: 4px; cursor: pointer; }");
            pr.print("button:hover { background-color: #0056b3; }");
            pr.print("</style></head>");
            pr.print("<body class='" + cssClass + "' style='" + bodyStyle + "'>");

            pr.print("<h1>Your Preferences</h1>");
            pr.print("<p>Your name: " + name + "</p>");
            pr.print("<p>Password: " + pass + "</p>");
            pr.print("<p>Preferred Language: " + preferredLanguage + "</p>");
            pr.print("<p>Theme: " + theme + "</p>");
            pr.print("<p>Notification Setting: " + notificationSetting + "</p>");

            if("Light Mode".equals(theme)) {
                pr.print("<a href='Aboutus_white.html'>About us</a><br/>");
            }
            else if("Dark Mode".equals(theme)) {
                pr.print("<a href='Aboutus_dark.html'>About us</a><br/>");
            }
            pr.print("<a herf ='Logout.html'>Logout</a>");

            pr.print("</body></html>");
        }

        else {
            pr.print("<html><body><h1>No preferences found.</h1></body></html>");
        }
    }
}
