import java.io.*;
import java.sql.*;

public class InsecureDemo {
    public static void main(String[] args) throws Exception {
        //read file
        FileInputStream fis = new FileInputStream("/tmp/input.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();

        // write to database 
        // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "user", "password");
        // Statement stmt = conn.createStatement();
        // String query = "INSERT INTO demo_table (data) VALUES ('" + sb.toString() + "')";
        // stmt.executeUpdate(query);
        // stmt.close();
        // conn.close();

    }
}
  