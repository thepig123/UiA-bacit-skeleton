package bacit.web.Servlet.UTILS;

import Models.ToolsModel;
import bacit.web.Servlet.Models.RentalModel;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentAToolDBUtil {

    public static List<ToolsModel> ListTools() throws SQLException, ClassNotFoundException {
        List<ToolsModel> ToolList = new ArrayList<>();

        Connection db = null;
        PrintWriter out = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();

            String query12 = "SELECT * FROM MytestDB.tools where availability = true";


            assert db != null;
            PreparedStatement statement = null;
            try {
                statement = db.prepareStatement(query12);
                ResultSet rs;
                rs = statement.executeQuery();

                while (rs.next()) {


                    int Item_ID = Integer.parseInt(rs.getString("Item_ID"));
                    String Tool_name = rs.getString("Tool_name");
                    boolean availability = rs.getBoolean("Availability");
                    String Price_firstDay = rs.getString("Price_firstDay");
                    String Price_followingDays = rs.getString("Price_followingDays");
                    String Tool_info = rs.getString("Tool_info");
                    String Tool_type = rs.getString("Tool_type");


                    ToolsModel tools = new ToolsModel( Item_ID, availability, Tool_name, Price_firstDay,  Price_followingDays,  Tool_info,  Tool_type);

                    ToolList.add(tools);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return ToolList;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
