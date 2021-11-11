package bacit.web.Servlet;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static bacit.web.Servlet.UTILS.DisplayDbUTIL.ListTools;


@WebServlet(name = "DisplayToolServlet", value = "/DisplayToolServlet")
public class DisplayToolServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            request.setAttribute("Tools", ListTools());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("DisplayTools.jsp").forward(request,response);


    }
}
