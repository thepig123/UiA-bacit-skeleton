package bacit.web.Servlet.Servlets;

import bacit.web.Servlet.DAO.*;
import bacit.web.Servlet.Models.FileModel;
import bacit.web.Servlet.UTILS.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.logging.Logger;

@WebServlet(name = "fileDownload", value = "/fileDownload")
public class FileDownloadServlet extends HttpServlet {

    Logger logger = Logger.getLogger(String.valueOf(FileUploadServlet.class));
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        ArrayList<Integer> indexes = getPDFs(out);

        assert indexes != null;
        ListIterator<Integer> iteratoren = indexes.listIterator();
        while(iteratoren.hasNext()) {
            Integer index = iteratoren.next();

            out.println("<p>Pdf " + index + "</p>");
            out.println("<form method=\"post\" action=\"fileDownload\">");
            out.println("<input type=\"hidden\" name=\"id\" value=\"" + index + "\">");
            out.println("<input type=\"submit\" value=\"Last ned pdf\">");
            out.println("</form>");
        }
        out.println("</body></html>");
    }

    private ArrayList<Integer> getPDFs (PrintWriter out) {
        try {
            Connection db = null;

            try {
                db = DBUtils.getINSTANCE().getConnection();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            PreparedStatement ps;

            ArrayList <Integer> indexes = new ArrayList<>();
            String query;
            query = "SELECT * FROM Files";

            assert db != null;
            ps = db.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();

            while (rs.next()) {
                indexes.add(rs.getInt("Id"));
            }

            return indexes;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String stringId = getQueryStringParameter(request);
        int id = Integer.parseInt(stringId);
        try{
            FileModel fileModel =  getFile(id);
            writeFileResult(response, fileModel);
        }
        catch(Exception ex)
        {
            logger.severe(ex.getMessage());
        }

    }

    protected FileModel getFile(int id) throws Exception
    {
        return new FileDAO().getFile(id);
    }

    protected String getQueryStringParameter(HttpServletRequest request)
    {
        return request.getParameter("id");
    }

    protected void writeFileResult(HttpServletResponse response, FileModel model) throws IOException
    {
        response.setContentType(model.getContentType());
        response.setHeader("Content-Disposition", "attachment; filename="+model.getName());
        OutputStream outStream = response.getOutputStream();
        outStream.write(model.getContents());
    }
}