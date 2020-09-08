package repository;

import models.vacUserFriendly;
import utils.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class rapoarteRepository {


    public static int celeMaiMulteAtractii(int idU) throws SQLException {
        Connection connection= DbConnection.Deschidere_Con_BD();
        Statement statement = connection.createStatement();
        String sql= "select ID_V from(select ID_U,count(ID_V) as\"NR_A\",ID_V from vacante join atractii_user on (vacante.idVacante=atractii_user.ID_V) where ID_U="+idU+" group by ID_V order by 2 desc limit 1 ) as T";
        ResultSet resultSet= statement.executeQuery(sql);
        if(resultSet.next())
        return resultSet.getInt("ID_V");
        else
            return -1;
    }

    public static int ceaMaiLungaVacantaUser(int idU) throws SQLException {
        Connection connection= DbConnection.Deschidere_Con_BD();
        Statement statement = connection.createStatement();
        String sql="select idVacante\n" +
                "from\n" +
                "(select idVacante,id_U, datediff(Data_Sf,Data_St) \n" +
                "from vacante\n" +
                "where id_U=+"+idU+"\n" +
                ") as T";
        ResultSet resultSet=statement.executeQuery(sql);
        if(resultSet.next())
            return resultSet.getInt("idVacante");
            else
                return 0;



    }

    public  static int ceaMaiScumpaVacanta(int idU) throws SQLException
    {
        Connection connection= DbConnection.Deschidere_Con_BD();
        Statement statement = connection.createStatement();
        String sql="\n" +
                "select idVacante,ID_U,(BaniV+BaniA)  as BaniTot from\n" +
                "(\n" +
                "select idVacante,ID_U,BaniV,ifnull(sBani,0) as BaniA from\n" +
                "(\n" +
                "select *\n" +
                "from vacante left join (select ID_V,IFNUll(sum(Bani),0) as sBani\n" +
                "from atractii_user\n" +
                "group by ID_V)as t on(idVacante=ID_V)\n" +
                ")as tab)as tabe\n" +
                "where ID_U="+idU+"\n" +
                "order by 3 desc\n" +
                "limit 1\n";
        ResultSet resultSet= statement.executeQuery(sql);
        if (resultSet.next())
            return resultSet.getInt("idVacante");
        else
            return 0;

    }
    public  static vacUserFriendly friendlyVacation(int id_V) throws SQLException {
        Connection connection= DbConnection.Deschidere_Con_BD();
        Statement statement = connection.createStatement();
        String sql=" select Nume,Data_St,Data_Sf\n" +
                "from vacante join locatii on(ID_L=idLocatii)\n" +
                "where idVacante="+id_V;
        ResultSet resultSet= statement.executeQuery(sql);
        if(resultSet.next())
        {
            return new vacUserFriendly(resultSet.getString("Nume"),resultSet.getDate("Data_St"),resultSet.getDate("Data_Sf"));
        }
        else return null;
    }

}
