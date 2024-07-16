import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import cnt.Security.*;

import java.lang.StringBuffer;
import java.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

// Class Declaration
class Login
{
    public static void main(String[] args)   
    {
        try {
            // Original Code
            
            // String email = request.getParameter("email");
            // String token = request.getParameter("password");

            // String sql = "select * from users where (email ='" + email +"' and password ='" + token + "')";

            // Connection connection = pool.getConnection();
            // Statement statement = connection.createStatement();
            
            // HttpSession session = request.getSession();
            // String role = (String)session.getAttribute("role");
            // if (role.equals(ADMIN)) {
            //     ResultSet result = statement.executeQuery(sql);
            //     statement.close();
            //     connection.close();
            // }

            String email = request.getParameter("email");
        String password = request.getParameter("password"); //SAST Node #0 (input): "password" ()

        // we can use PreparedStatement instead of statement to mitigate Sql injection
        String updateStatement = "SELECT * from users WHERE email = ? and password = ?"; //SAST Node #3: getParameter () //SAST Node #4: updateStatement ()

        Connection connection = pool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        HttpSession session = request.getSession();
        String role = (String)session.getAttribute("role");
        if (role.equals(ADMIN)) {
            ResultSet result = preparedStatement.executeQuery(); //SAST Node #5: executeQuery () //SAST Node #6 (output): executeQuery ()
            // method continues ...
        } 
            
        catch (SQLException ex) {
            handleExceptions(ex);
        }
        finally {
            statement.close();
            connection.close();
        }
    }
} 
