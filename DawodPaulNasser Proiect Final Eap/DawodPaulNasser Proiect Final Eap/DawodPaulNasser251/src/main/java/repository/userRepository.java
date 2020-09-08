package repository;

import models.user;
import utils.DbConnection;

import java.sql.*;
import java.util.Scanner;

public class userRepository {

    public static user logare_BD(String temp_u, String temp_p) throws SQLException {


        Connection connection = DbConnection.Deschidere_Con_BD();
        String sql = "select * from user where userlogin='" + temp_u + "' and password ='" + temp_p + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if(resultSet.next()) {
            user temp = new user(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                    resultSet.getString(5), resultSet.getInt(6));
            return temp;
        }
        return null;
    }


    static public boolean Unique_User_BD(Connection connection, String user_d) throws SQLException {
        String sql = "select userlogin from user";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {

            if (user_d.equals(resultSet.getString("userlogin")))
                return false;
        }
        return true;
    }

    //Inceput lucru cu BD
    public static void creareUserBD(String u,String p, String n,String pr) throws SQLException {

        Connection connection = DbConnection.Deschidere_Con_BD();
        Statement statement = connection.createStatement();
        String sql = "insert into user(userlogin,password,Nume,Prenume)\n" +
                "values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        preparedStatement.setString(1, u);
        preparedStatement.setString(2, p);
        preparedStatement.setString(3, n);
        preparedStatement.setString(4, pr);
        preparedStatement.execute();


    }
    public  static void stergereUser(int id_u) throws SQLException {
        Connection connection = DbConnection.Deschidere_Con_BD();
        Statement statement = connection.createStatement();
        String sql="DELETE FROM user WHERE idUser ="+id_u+" ;";
        statement.execute(sql);

    }


}
