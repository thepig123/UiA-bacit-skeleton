package bacit.web.Servlet.Servlets;

import bacit.web.Servlet.UTILS.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static bacit.web.Servlet.Servlets.CredentialCheckServlet.getUserID;
import static bacit.web.Servlet.UTILS.ListRentalHistoryDBUtil.ListRentals;


@WebServlet(name = "DeliverToolServlet", value = "/DeliverToolServlet")
public class DeliverToolServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            request.setAttribute("Rentals", ListRentals());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("RentATool.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int Item_ID = Integer.parseInt(request.getParameter("Item_ID"));
        String Rental_startDate = request.getParameter("Rental_startDate");
        String Rental_endDate = request.getParameter("Rental_endDate");

        Connection db = null;
        PrintWriter out = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();


            String query22 = "Update MytestDB.tools set availability=false where Item_ID=?";

            assert db != null;
            PreparedStatement statement = null;
            PreparedStatement statement2 = null;
            try {

                statement2 = db.prepareStatement(query22);

                HttpSession session = request.getSession();
                statement.setInt(1, getUserID(session));
                statement.setInt(2, Item_ID);
                statement.setString(3, Rental_startDate);
                statement.setString(4,Rental_endDate);

                statement2.setInt(1, Item_ID);


                statement.executeQuery();
                statement2.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }
}