import java.io.*;
import java.sql.*;

public class InsecureDemo {
    public static void main(String[] args) throws Exception {
        // Insecure file read
        FileInputStream fis = new FileInputStream("/tmp/input.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();

        // Insecure database write
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "user", "password");
        Statement stmt = conn.createStatement();
        String query = "INSERT INTO demo_table (data) VALUES ('" + sb.toString() + "')";
        stmt.executeUpdate(query);
        stmt.close();
        conn.close();
    }
}
  