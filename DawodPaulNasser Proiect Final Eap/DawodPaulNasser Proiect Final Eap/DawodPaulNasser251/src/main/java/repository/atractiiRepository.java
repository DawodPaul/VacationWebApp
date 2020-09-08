package repository;

import models.atractii;
import models.atractii_user;
import utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;

public class atractiiRepository {

    public static ArrayList<atractii_user> listaAtractiiByVac(int id_v) throws SQLException {
        Connection connection= DbConnection.Deschidere_Con_BD();
        Statement statement= connection.createStatement();
        String sql= "select* from\n" +
                "atractii_user\n" +
                "where ID_V="+id_v+";";
        ResultSet resultSet=statement.executeQuery(sql);
        ArrayList<atractii_user> atrUser=new ArrayList<>();
        while (resultSet.next())
        {

            atrUser.add(new atractii_user(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),
                    resultSet.getString(6)));
        }
        return atrUser;

    }

    public static ArrayList<atractii> atractiiByLoc(int id_l) throws SQLException {
        ArrayList<atractii> listAt=new ArrayList<>();
        Connection connection= DbConnection.Deschidere_Con_BD();
        Statement statement= connection.createStatement();
        String sql="select* from\n" +
                "atractii\n" +
                "where ID_L="+id_l;
        ResultSet resultSet=statement.executeQuery(sql);
        while (resultSet.next())
        {
listAt.add(new atractii(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getDouble(4)));
        }
return listAt;
    }
    public static void addAtrUser(int id_A,int id_v,int Rating_U,int Bani,String Recenzie) throws SQLException {
Connection connection=DbConnection.Deschidere_Con_BD();
String sql="INSERT INTO atractii_user (`idA`, `ID_V`, `Rating_U`, `Bani`, `Recenzie`) VALUES (?,?,?,?,?);";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
preparedStatement.setInt(1,id_A);
preparedStatement.setInt(2,id_v);
preparedStatement.setInt(3,Rating_U);
preparedStatement.setInt(4,Bani);
preparedStatement.setString(5,Recenzie);
preparedStatement.execute();

    }

}
