package bacit.web.Servlet.UTILS;


import bacit.web.Servlet.Models.FileModel;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayFilesUtil {

    public static List<FileModel> ListFiles() throws SQLException, ClassNotFoundException {
        List<FileModel> Files = new ArrayList<>();

        Connection db = null;
        PrintWriter out = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();

            String query12 = "SELECT * FROM MytestDB.Files";

            assert db != null;
            PreparedStatement statement = null;
            try {
                statement = db.prepareStatement(query12);
                ResultSet rs;
                rs = statement.executeQuery();

                while (rs.next()) {

                    String name = rs.getString("Name");
                    byte[] contents = rs.getBytes("Contents");
                    String contentType = rs.getString("ContentType");




                    FileModel tempFiles = new FileModel(name, contents, contentType);

                    Files.add(tempFiles);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Files;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}