import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/Preferences")
public class PreferencesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String preferredLanguage = req.getParameter("preferredLanguage");
        String theme = req.getParameter("theme");
        String notificationSetting = req.getParameter("notificationSetting");
        String url="jdbc:mysql://localhost:3306/Login_info";
        String user = "root";
        String pass = "pass123";
        PrintWriter pr = resp.getWriter();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try(Connection conn = DriverManager.getConnection(url, user, pass)){
                Statement stmt = conn.createStatement();
                String sql = "select * from login where u_name='" + name + "' and password='" + password + "'";
                ResultSet rs = stmt.executeQuery(sql);
                if(rs.next()){
                    HttpSession session = req.getSession(true);
                    session.setAttribute("name", name);
                    session.setAttribute("password", password);
                    session.setAttribute("preferredLanguage", preferredLanguage);
                    session.setAttribute("theme", theme);
                    session.setAttribute("notificationSetting", notificationSetting);
                    System.out.println("The entered data is \nName: "+name+" \nPassword: "+password+" \nPreferred Language: "+preferredLanguage+" \nTheme: "+theme);
                    resp.sendRedirect("DisplayPreferences");
                }
                else{
                    resp.sendRedirect("New_file.html");
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
