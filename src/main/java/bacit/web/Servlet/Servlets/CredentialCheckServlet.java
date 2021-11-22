package bacit.web.Servlet.Servlets;

import bacit.web.Servlet.Models.UserModel;
import bacit.web.Servlet.UTILS.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static bacit.web.Servlet.UTILS.PasswordEncrypting.encrypt;


@WebServlet(name = "CredentialCheckServlet", value = "/CredentialCheckServlet")
public class CredentialCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String userEmail = request.getParameter("User_Email");
        String userPassword = request.getParameter("User_Password");



        /* Få hjelp til å fikse admincheck*/
        if (CheckUser(userEmail, userPassword, out) && CheckAdmin(userEmail, userPassword,out)) {
            request.getRequestDispatcher("admin.jsp").forward(request,response);
        } else if (CheckUser(userEmail, userPassword, out) && !CheckAdmin(userEmail, userPassword, out)) {
            request.getRequestDispatcher("HomePage.jsp").forward(request,response);
        } else if (!CheckUser(userEmail, userPassword, out) && !CheckAdmin(userEmail, userPassword,out)) {
            out.println("Wrong credentials");
        }
    }

    private boolean CheckUser(String Email, String Password, PrintWriter out) throws IOException {
        Connection db = null;
        String query4 = "select * from MytestDB.user where User_Email=? and User_password=? ";
        PreparedStatement statement = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();
            statement = db.prepareStatement(query4);
            statement.setString(1, Email);
            statement.setString(2, encrypt(Password));
            ResultSet rs;
            rs = statement.executeQuery();

            UserModel test = null;

            while (rs.next()) {
                test = new UserModel();
                test.setEmail(rs.getString("User_Email"));
                test.setPassword(rs.getString("User_password"));
            }
            if (test != null){

                return true;
            } else {
                return false;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean CheckAdmin(String Email, String Password, PrintWriter out) throws IOException {
        Connection db = null;
        String query4 = "select * from MytestDB.user where User_Email=? and User_password=? ";
        PreparedStatement statement = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();
            statement = db.prepareStatement(query4);
            statement.setString(1, Email);
            statement.setString(2, encrypt(Password));
            ResultSet rs;
            rs = statement.executeQuery();

            UserModel test = null;

            while (rs.next()) {
                test = new UserModel();
                test.setEmail(rs.getString("User_Email"));
                test.setPassword(rs.getString("User_password"));
            }
            if (test != null && test.getEmail().equals("admin") && test.getPassword().equals("admin")) {

                return true;
            } else {
                return false;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
