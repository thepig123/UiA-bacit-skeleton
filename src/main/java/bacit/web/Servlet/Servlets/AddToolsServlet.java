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


@WebServlet(name = "AddToolsServlet", value = "/AddToolsServlet")
public class AddToolsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        addToolshtml(out);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String toolName = request.getParameter("Tool_name");
        String toolInfo = request.getParameter("Tool_info");
        String toolType = request.getParameter("Tool_type");
        String priceFirstDay = request.getParameter("Price_firstDay");
        String priceFollowingDays = request.getParameter("Price_followingDays");
        boolean availability = Boolean.parseBoolean(request.getParameter("Availability"));

        if (toolName.isBlank()) {
            request.getRequestDispatcher("toolsFailed.jsp").forward(request,response);
            return;
        }

        Connection db = null;
        try {
            PrintWriter out = response.getWriter();
            db = DBUtils.getINSTANCE().getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        

        String query5 = "insert into MytestDB.tools (Tool_name, Tool_info, Tool_type, Price_firstDay, Price_followingDays, Availability) " +
                "values(?, ?, ?, ?, ?, ?); ";
        assert db != null;
        PreparedStatement statement = null ;
        try {
            statement = db.prepareStatement(query5);
            statement.setString(1, toolName);
            statement.setString(2, toolInfo);
            statement.setString(3, toolType);
            statement.setString(4, priceFirstDay);
            statement.setString(5, priceFollowingDays);
            statement.setBoolean(6, availability);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("addToolSuccess.jsp").forward(request,response);
    }
    private void addToolshtml(PrintWriter out) {
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<meta charset=\"UTF-16\">");
        out.println("<title>Add Tool</title>");
        out.println("<link rel=\"stylesheet\" href=\"style.css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src=\"amv-logo.png\" alt=\"amv logo\" width=\"241\" height=\"131\" id=\"AMVLogo\"> <br>");
        out.println("<div id=\"login\">");
        out.println("<h1>Login</h1>");
        out.println("<form action=\"AddToolsServlet\" method=\"post\">");
        out.println("<label for=\"Tool_name\">Tool Name:</label> <br>");
        out.println("<input type=\"text\"  name=\"Tool_name\" placeholder=\"Navnet på utstyret\" required pattern=\".\\S+.\"> <br>");
        out.println("<label for=\"Tool_info\">Tool Info:</label> <br>");
        out.println("<input type=\"text\"  name=\"Tool_info\" placeholder=\"Philips Flathead\" required pattern=\".\\S+.\">  <br>");
        out.println("<label for=\"Tool_type\">Tool Type:</label> <br>");
        out.println("<input type=\"text\"  name=\"Tool_type\" placeholder=\"Diverse småutstyr\" required pattern=\".\\S+.\"> <br>");
        out.println("<label for=\"Price_firstDay\">Price first day:</label> <br>");
        out.println("<input type=\"text\"  name=\"Price_firstDay\" placeholder=\",-\" required pattern=\".\\S+.\"> <br>");
        out.println("<label for=\"Price_followingDays\">Price following days:</label> <br>");
        out.println("<input type=\"text\"  name=\"Price following days\" placeholder=\",-\" required pattern=\".\\S+.\"> <br>");
        out.println("<input class=\"button\" type=\"Submit\" value=\"Submit\" />");
        out.println("</form>");
        out.println("</body></html>");
    }
}


