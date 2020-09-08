package utils;

import java.sql.*;

public class DbConnection {

    //JDBC Driver and DB URL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/proiecteap";

    //mySql User and Pass
    private static final String USER = "root";
    private static final String PASS = "MYSQLROOTPA55";

    private static Connection connection;


    public static Connection Deschidere_Con_BD() {
        try {

            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Nu merge");
        }

    }

    public static void Testare() {
        Connection connection = Deschidere_Con_BD();
        String sql = "select * from user";
        try {

            Statement statement = connection.createStatement();
            //statement.execute(sql) pt inserturi sau cv care n are return;
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet == null) {
                System.out.println("Nu exista");
            }
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("idUser") + " " + resultSet.getString("userlogin") +
                        " " + resultSet.getString("password")+" "+resultSet.getString("Nume"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}