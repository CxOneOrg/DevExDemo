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
            String email = request.getParameter("email");//SAST Node #0 (input): &#34;&#34;email&#34;&#34; ()//SAST Node #1: getParameter ()//SAST Node #2: email ()
        String token = request.getParameter("password");

        String sql = "select * from users where email = ? and password = ?"; //SAST Node #3: email ()//SAST Node #4: sql ()

        Connection connection = pool.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, email);
        statement.setString(2, token);

        HttpSession session = request.getSession();
        String role = (String)session.getAttribute("role");

        if (role.equals(ADMIN)){
            ResultSet result = statement.executeQuery();//SAST Node #5: sql ()//SAST Node #6 (output): executeQuery ()
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
