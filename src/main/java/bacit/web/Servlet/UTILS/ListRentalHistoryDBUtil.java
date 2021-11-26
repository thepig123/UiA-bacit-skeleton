package bacit.web.Servlet.UTILS;

import Models.ToolsModel;
import bacit.web.Servlet.Models.RentalModel;

import javax.tools.Tool;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListRentalHistoryDBUtil  {

    public static List<RentalModel> ListRentals() throws SQLException, ClassNotFoundException {
        List<RentalModel> HistoryList = new ArrayList<>();

        Connection db = null;
        PrintWriter out = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();

            String query14 = "SELECT * FROM MytestDB.rental_system";

            assert db != null;
            PreparedStatement statement = null;
            try {
                statement = db.prepareStatement(query14);
                ResultSet rs;
                rs = statement.executeQuery();

                while (rs.next()) {

                    int Item_ID = Integer.parseInt(rs.getString("Item_ID"));
                    //String Tool_name = rs.getString("Tool_name");
                    String damage_report = rs.getString("Damage_report");
                    String rental_startDate = rs.getString("Rental_startDate");
                    String rental_endDate = rs.getString("Rental_endDate");

                    RentalModel history = new RentalModel(Item_ID, damage_report, rental_startDate, rental_endDate);

                    HistoryList.add(history);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return HistoryList;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
