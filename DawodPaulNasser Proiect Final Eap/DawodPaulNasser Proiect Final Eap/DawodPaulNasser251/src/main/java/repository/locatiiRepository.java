package repository;

import models.locatii;
import utils.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class locatiiRepository {

   static public ArrayList<locatii> ToateLocatiile() throws SQLException {
        Connection connection= DbConnection.Deschidere_Con_BD();
        Statement statement = connection.createStatement();
        String sql="select * from locatii";
       ResultSet resultSet= statement.executeQuery(sql);
       ArrayList<locatii> loc=new ArrayList<>();
       while (resultSet.next())
       {
           loc.add(new locatii(resultSet.getInt(1),resultSet.getString(2)));
       }
       return loc;
    }
}
