import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRegistration {

    public static void registerUser(String email, String password) {
        Connection connection = null;
        Statement statement = null;
        try {
            // Step 5: Establish a connection (Replace "YourDBURL", "Username", "Password" with actual database details)
            connection = DriverManager.getConnection("YourDBURL", "Username", "Password");
            
            // Step 6: Create SQL insert statement
            String sql = "INSERT INTO users (email, password) VALUES ('" + email + "', '" + password + "')";
            
            // Step 7: Execute the insert statement
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            
            System.out.println("User registered successfully");
        } catch (SQLException e) {
            // Step 8: Handle SQL exceptions
            e.printStackTrace();
        } finally {
            // Step 9: Close the connection
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        registerUser("example@email.com", "password123");
    }
}