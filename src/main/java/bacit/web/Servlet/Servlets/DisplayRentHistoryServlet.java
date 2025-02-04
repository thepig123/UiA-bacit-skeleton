package bacit.web.Servlet;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static bacit.web.Servlet.UTILS.ListRentalHistoryDBUtil.ListRentals;

@WebServlet(name = "DisplayRentHistoryServlet", value = "/DisplayRentHistoryServlet")
public class DisplayRentHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            request.setAttribute("Rentals", ListRentals());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("DisplayRentalHistory.jsp").forward(request,response);


    }
}