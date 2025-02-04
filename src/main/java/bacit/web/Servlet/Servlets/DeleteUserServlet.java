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

@WebServlet(name = "DeleteUserServlet", value = "/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        deleteUserhtml(out);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userEmail = request.getParameter("User_Email");

        Connection db = null;
        try {
            PrintWriter out = response.getWriter();
            db = DBUtils.getINSTANCE().getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        String query300 = "DELETE FROM MytestDB.user WHERE User_Email = ?";
        assert db != null;
        PreparedStatement statement = null;
        try {
            statement = db.prepareStatement(query300);
            statement.setString(1, userEmail);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void deleteUserhtml(PrintWriter out) {
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Login</title>");
        out.println("<link rel=\"stylesheet\" href=\"style.css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src=\"amv-logo.png\" alt=\"amv logo\" width=\"241\" height=\"131\" id=\"AMVLogo\"> <br>");
        out.println("<div id=\"Add User\">");
        out.println("<h1>Slett bruker</h1>");
        out.println("<form action=\"DeleteUserServlet\" method=\"post\">");
        out.println("<label for=\"User_Email\">Email:</label> <br>");
        out.println("<input type=\"text\"  name=\"User_Email\" placeholder=\"Example@gmail.com\" required pattern=\".\\S+.\"> <br>");
        out.println("<input class=\"button\" type=\"Submit\" value=\"Submit\" />");
        out.println("</form>");
        out.println("</body></html>");
    }
}