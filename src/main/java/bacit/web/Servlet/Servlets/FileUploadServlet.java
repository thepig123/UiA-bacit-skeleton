package bacit.web.Servlet.Servlets;

import bacit.web.Servlet.DAO.FileDAO;
import bacit.web.Servlet.Models.FileModel;
import bacit.web.Servlet.UTILS.HtmlHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.logging.Logger;


@WebServlet(name = "fileUpload", value = "/fileUpload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileUploadServlet extends HttpServlet {

    Logger logger = Logger.getLogger(FileUploadServlet.class.getName());

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        HtmlHelper.writeHtmlStart(out, "Upload a file");
        writeFileUploadForm(out,null);
        HtmlHelper.writeHtmlEnd(out);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HtmlHelper.writeHtmlStart(out, "Upload a file");
        try{
            Part filePart = request.getPart("file");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            InputStream fileContent = filePart.getInputStream();
            byte[] fileBytes = fileContent.readAllBytes();

            FileModel fileModel = new FileModel(
                    fileName,
                    fileBytes,
                    filePart.getContentType());

            FileDAO dao = new FileDAO();
            dao.persistFile(fileModel);

            logger.info("Received file with name: "+fileModel.getName()+ "with the length of: "+fileModel.getContents().length+" bytes");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            logger.severe(ex.getMessage());
            writeFileUploadForm(out, ex.getMessage());

        }
        HtmlHelper.writeHtmlEnd(out);
    }

    private void writeFileUploadForm(PrintWriter out, String errorMessage) {

        if(errorMessage!=null)
        {
            out.println("<h3>"+errorMessage+"</h3>");
        }
        out.println("<form action='fileUpload' method='POST' enctype='multipart/form-data'>");
        out.println("<label for='file'>Upload a file</label> ");
        out.println("<input type='file' name='file'/>");
        out.println("<input type='submit' value='Upload file'/>");
        out.println("</form>");
    }

}