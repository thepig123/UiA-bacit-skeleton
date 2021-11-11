package bacit.web.Servlet.DAO;

import bacit.web.Servlet.Models.FileModel;
import bacit.web.Servlet.UTILS.DBUtils;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FileDAO {

    public void persistFile(FileModel file) throws Exception {

         Connection db = DBUtils.getINSTANCE().getConnection();
            String query6 = "insert into MytestDB.Files (Name, Content, ContentType) values(?,?,?)";

            PreparedStatement statement = db.prepareStatement(query6);
            statement.setString(1, file.getName());
            statement.setBlob(2, new SerialBlob(file.getContents()));
            statement.setString(3, file.getContentType());
            statement.executeUpdate();
            db.close();
    }

    public FileModel getFile(int id) throws Exception {
        Connection db = DBUtils.getINSTANCE().getConnection();
        String query7 = "select Name, Content, ContentType from MytestDB.Files where id = ?";
        PreparedStatement statement = db.prepareStatement(query7);
        statement.setInt(1, id);
        ResultSet rs =  statement.executeQuery();
        FileModel model = null;
        if (rs.next()) {
            model = new FileModel(
                    rs.getString("Name"),
                    rs.getBytes("Content"),
                    rs.getString("ContentType")
            );
        }
        db.close();
        return model;
    }
}
