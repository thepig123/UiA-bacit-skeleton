package bacit.web.Servlet.Servlets;

import bacit.web.Servlet.DAO.FileDAO;
import bacit.web.Servlet.Models.FileModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Logger;

import static bacit.web.Servlet.UTILS.DisplayFilesUtil.ListFiles;

@WebServlet(name = "fileDownload", value = "/fileDownload")
public class FileDownloadServlet extends HttpServlet {

    Logger logger = Logger.getLogger(String.valueOf(FileUploadServlet.class));

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String stringId = getQueryStringParameter(request);
        int id = Integer.parseInt(stringId);
        try{
            FileModel fileModel =  getFile(id);
            writeFileResult(response,fileModel);
        }
        catch(Exception ex)
        {
            logger.severe(ex.getMessage());
        }

    }

    private void writeFileResult(HttpServletResponse response, FileModel fileModel) {
    }


    protected FileModel getFile(int id) throws Exception
    {
        return new FileDAO().getFile(id);
    }

    protected String getQueryStringParameter(HttpServletRequest request)
    {
        return request.getParameter("id");
    }

    protected void writeFileResult(HttpServletResponse response, FileModel model, PrintWriter out, String errorMessage) throws IOException
    {
        response.setContentType(model.getContentType());
        response.setHeader("Content-Disposition", "attachment; filename="+model.getName());
        OutputStream outStream = response.getOutputStream();
        outStream.write(model.getContents());

        if(errorMessage!=null)
        {
            out.println("<h3>"+errorMessage+"</h3>");
        }
        out.println("<form action='fileDownload' method='POST' enctype='multipart/form-data'>");
        out.println("<label for='file'>Upload a file</label> ");
        out.println("<input type='file' name='file'/>");
        out.println("<input type='submit' value='Upload file'/>");
        out.println("</form>");

    }
}
