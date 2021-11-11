package bacit.web.Servlet.UTILS;

import Models.ToolsModel;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayDbUTIL {

    public static List<ToolsModel> ListTools() throws SQLException, ClassNotFoundException {
        List<ToolsModel> Tools = new ArrayList<>();

        Connection db = null;
        PrintWriter out = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();

            String query5 = "SELECT * FROM MytestDB.tools";

            assert db != null;
            PreparedStatement statement = null;
            try {
                statement = db.prepareStatement(query5);
                ResultSet rs;
                rs = statement.executeQuery();

                while (rs.next()) {

                    boolean Availability = rs.getBoolean("Availability");
                    String Tool_name = rs.getString("Tool_name");
                    String Price_firstDay = rs.getString("Price_firstDay");
                    String Price_followingDays = rs.getString("Price_followingDays");
                    String Tool_info = rs.getString("Tool_info");
                    String Tool_type = rs.getString("Tool_type");



                    ToolsModel tempTools = new ToolsModel(Availability, Tool_name, Price_firstDay, Price_followingDays, Tool_info, Tool_type);

                    Tools.add(tempTools);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Tools;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}