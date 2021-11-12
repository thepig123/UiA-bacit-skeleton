package bacit.web.Servlet.Servlets;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static bacit.web.Servlet.UTILS.DisplayFilesUtil.ListFiles;


@WebServlet(name = "displayFile", value = "/displayFile")
public class DisplayFileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            request.setAttribute("Files", ListFiles());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("DisplayFiles.jsp").forward(request,response);


    }
}
