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

@WebServlet(name = "DeleteToolServlet", value = "/DeleteToolServlet")
public class DeleteToolServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        deleteToolshtml(out);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ToolName = request.getParameter("Tool_name");

        Connection db = null;
        try {
            PrintWriter out = response.getWriter();
            db = DBUtils.getINSTANCE().getConnection();


        String query400 = "DELETE FROM MytestDB.tools WHERE Tool_name = ?";
        assert db != null;
        PreparedStatement statement = null;
        try {
            statement = db.prepareStatement(query400);
            statement.setString(1, ToolName);

            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    private void deleteToolshtml(PrintWriter out) {
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Login</title>");
        out.println("<link rel=\"stylesheet\" href=\"style.css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src=\"amv-logo.png\" alt=\"amv logo\" width=\"241\" height=\"131\" id=\"AMVLogo\"> <br>");
        out.println("<h1>Slett utstyr</h1>");
        out.println("<form class=\"form\" action=\"DeleteToolServlet\" method=\"post\">");
        out.println("<label for=\"Tool_name\">Navn på utstyr:</label> <br>");
        out.println("<input type=\"text\" name=\"Tool_name\" placeholder=\"Navn på utstyr\" required pattern=\".\\S+.\"> <br>");
        out.println("<input class=\"button\" type=\"Submit\" value=\"Submit\" />");
        out.println("</form>");
        out.println("</body></html>");
    }
}