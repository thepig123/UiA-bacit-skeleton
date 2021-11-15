package bacit.web.Servlet.Servlets;

import bacit.web.Servlet.UTILS.DBUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static bacit.web.Servlet.UTILS.PasswordEncrypting.encrypt;

@WebServlet(name = "AddUserServlet", value = "/AddUserServlet")
    public class AddUserServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            addUserhtml(out);
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("User_firstName");
        String lastName = request.getParameter("User_lastName");
        String userEmail = request.getParameter("User_Email");
        String userPassword = request.getParameter("User_Password");
        int userPhonenumber = Integer.parseInt(request.getParameter("User_PhoneNumber"));

        Connection db = null;
        try {
            PrintWriter out = response.getWriter();
            db = DBUtils.getINSTANCE().getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        String query3 = "insert into MytestDB.user (User_firstName, User_lastName, User_Email, User_password, User_PhoneNumber) " +
                "values(?, ?, ?, ?, ?); ";
assert db != null;
        PreparedStatement statement = null;
        try {
            statement = db.prepareStatement(query3);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, userEmail);
            statement.setString(4, encrypt(userPassword));
            statement.setInt(5, userPhonenumber);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void addUserhtml(PrintWriter out) {
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Login</title>");
        out.println("<link rel=\"stylesheet\" href=\"style.css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src=\"amv-logo.png\" alt=\"amv logo\" width=\"241\" height=\"131\" id=\"AMVLogo\"> <br>");
        out.println("<div id=\"Add User\">");
        out.println("<h1>Login</h1>");
        out.println("<form action=\"AddUserServlet\" method=\"post\">");
        out.println("<label for=\"User_firstName\">First Name:</label> <br>");
        out.println("<input type=\"text\"  name=\"User_firstName\" placeholder=\"Martin\" required pattern=\".\\S+.\"> <br>")   ;
        out.println("<label for=\"User_lastName\">Last Name:</label> <br>");
        out.println("<input type=\"text\"  name=\"User_lastName\" placeholder=\"Olsen\" required pattern=\".\\S+.\">  <br>");
        out.println("<label for=\"User_Email\">Email:</label> <br>");
        out.println("<input type=\"text\"  name=\"User_Email\" placeholder=\"Example@gmail.com\" required pattern=\".\\S+.\"> <br>");
        out.println("<label for=\"User_PhoneNumber\">PhoneNumber:</label> <br>");
        out.println("<input type=\"text\"  name=\"User_PhoneNumber\" placeholder=\"32145854\" required pattern=\".\\S+.\"> <br>");
        out.println("<label for=\"User_Password\">Password:</label> <br>");
        out.println("<input type=\"password\"  name=\"User_Password\" placeholder=\"12345\" required pattern=\".\\S+.\"> <br>");
        out.println("<input class=\"button\" type=\"Submit\" value=\"Submit\" />");
        out.println("</form>");
        out.println("</body></html>");
    }
}