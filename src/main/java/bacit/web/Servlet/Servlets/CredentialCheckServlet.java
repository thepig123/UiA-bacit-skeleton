package bacit.web.Servlet.Servlets;

import bacit.web.Servlet.Models.UserModel;
import bacit.web.Servlet.UTILS.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static bacit.web.Servlet.UTILS.PasswordEncrypting.encrypt;


@WebServlet(name = "CredentialCheckServlet ", value = "/CredentialCheckServlet")
public class CredentialCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        loginhtml(out);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String userEmail = request.getParameter("User_Email");
        String userPassword = request.getParameter("User_Password");

        if (CheckUser(userEmail, userPassword, out) && CheckAdmin(userEmail, userPassword,out)) {
            request.getRequestDispatcher("admin.jsp").forward(request,response);
        } else if (CheckUser(userEmail, userPassword, out) && !CheckAdmin(userEmail, userPassword, out)) {
            request.getRequestDispatcher("System.jsp").forward(request,response);
        } else if (!CheckUser(userEmail, userPassword, out) && !CheckAdmin(userEmail, userPassword,out)) {
            out.println("Wrong credentials");
        }
    }

    private boolean CheckUser(String Email, String Password, PrintWriter out) throws IOException {
        Connection db = null;
        String query4 = "select * from MytestDB.user where User_Email=? and User_password=? ";
        PreparedStatement statement = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();
            statement = db.prepareStatement(query4);
            statement.setString(1, Email);
            statement.setString(2, Password);
            ResultSet rs;
            rs = statement.executeQuery();

            UserModel test = null;

            while (rs.next()) {
                test = new UserModel();
                test.setEmail(rs.getString("User_Email"));
                test.setPassword(rs.getString("User_password"));
            }
            if (test != null){

                return true;
            } else {
                return false;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean CheckAdmin(String Email, String Password, PrintWriter out) throws IOException {
        Connection db = null;
        String query4 = "select * from MytestDB.user where User_Email=? and User_password=? ";
        PreparedStatement statement = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();
            statement = db.prepareStatement(query4);
            statement.setString(1, Email);
            statement.setString(2, encrypt(Password));
            ResultSet rs;
            rs = statement.executeQuery();

            UserModel test = null;

            while (rs.next()) {
                test = new UserModel();
                test.setEmail(rs.getString("User_Email"));
                test.setPassword(rs.getString("User_password"));
            }
            if (test != null && test.getEmail().equals("admin") && test.getPassword().equals("admin")) {

                return true;
            } else {
                return false;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void loginhtml(PrintWriter out) {
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Login</title>");
        out.println("<link rel=\"stylesheet\" href=\"style.css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src=\"amv-logo.png\" alt=\"amv logo\" width=\"241\" height=\"131\" id=\"AMVLogo\"> <br>");
        out.println("<div id=\"Log in\">");
        out.println("<h1>Login</h1>");
        out.println("<form class=\"login\"action=\"CredentialCheck\" method=\"post\">");
        out.println("<label for=\"Email\">Email:</label> <br>");
        out.println("<input type=\"text\" id=\"Email\" name=\"User_Email\" placeholder=\"Example@gmail.com\"")   ;
        out.println("<label for=\"User_Password\">Password:</label> <br>");
        out.println("<input type=\"password\" id=\"User_Password\" name=\"User_Password\" placeholder=\"Password\"> <br>");
        out.println("<button class=\"button\" type=\"submit\" value=\"\"> Log In</button>");
        out.println("</form>");
        out.println("</body></html>");
    }
}
