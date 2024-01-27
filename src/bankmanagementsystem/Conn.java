package bankmanagementsystem;

import java.sql.Connection;
import java.sql.*;


public class Conn {

    Connection connection;
    Statement statement;
    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/AtmSim","root","Anuhr1402");
            statement=connection.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

