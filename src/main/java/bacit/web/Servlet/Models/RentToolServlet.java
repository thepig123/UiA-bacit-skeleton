package bacit.web.Servlet.Models;

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

    @WebServlet(name = "RentToolServlet", value = "/RentToolServlet")
    class RentToolServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            PrintWriter out = response.getWriter();

            try {
                rentTools(out);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

        }

        private boolean rentTools(PrintWriter out) throws SQLException {
            Connection db = null;
            try {
                db = DBUtils.getINSTANCE().getConnection();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            String query4 = "insert into MytestDB.rental_system (User_ID, Item_ID, Damage_report, Rental_startDate, Rental_endDate, Availability) " +
                    "values(1,4,'Ingen skade','2021-10-28','2021-10-30', false);";



            assert db != null;
            PreparedStatement statement = db.prepareStatement(query4);
            statement.execute();

            return true;
        }
    }
