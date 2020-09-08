package repository;


import models.vacante;
import utils.DbConnection;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class vacanteRepository {


    public vacanteRepository() {
    }

    //    public static void addVacanta(int id_u) throws SQLException, Exception//ar fi bagata din meniu utilizator si ia de acolo automat id_u
//    {
//        Scanner scanner=new Scanner(System.in);
//        Connection connection=DbConnection.Deschidere_Con_BD();
//        String sql= "insert into vacante(id_u, id_l, data_st, data_sf, baniv) values (?,?,?,?,?)";
//        PreparedStatement preparedStatement= connection.prepareStatement(sql);
//        System.out.print("ID_L:");
//        int id_l=scanner.nextInt();
//        scanner.nextLine();
//        if(Locatie.checkExistLocatie(connection,id_l)==false)
//        {
//            System.out.println("Nu exista locatia");
//            System.out.print("ID_L:");
//            id_l=scanner.nextInt();
//            scanner.nextLine();
//        }
//
//        preparedStatement.setInt(1,id_u);
//        preparedStatement.setInt(2,id_l);
//        System.out.println("Data Start");
//        String temp=scanner.nextLine();
//        java.util.Date t= new SimpleDateFormat("dd-mm-yyyy").parse(temp);
//        java.sql.Date a= new java.sql.Date(t.getTime());
//        preparedStatement.setDate(3,a);
//        System.out.println("Data Final");
//        temp=scanner.nextLine();
//        t= new SimpleDateFormat("dd-mm-yyyy").parse(temp);
//        a= new java.sql.Date(t.getTime());
//        preparedStatement.setDate(4,a);
//        preparedStatement.setInt(5,0);
//        preparedStatement.execute();
//    }
    public static ArrayList<vacante> afisareVacanteBD() throws Exception {
        Connection connection = DbConnection.Deschidere_Con_BD();
        Statement statement = connection.createStatement();
        String sql = "select * from vacante ";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<vacante> Vac = new ArrayList<>();
        while (resultSet.next()) {
            Vac.add(new vacante(resultSet.getInt("idVacante"), resultSet.getInt("ID_U"), resultSet.getInt("ID_L"),
                    resultSet.getDate("Data_st"), resultSet.getDate("Data_sf"), resultSet.getInt("BaniV")));
        }

        return Vac;
    }

    public static ArrayList<vacante> afisareVacanteIDLBD(int id_l) throws Exception {
        Connection connection = DbConnection.Deschidere_Con_BD();
        Statement statement = connection.createStatement();
        String sql = "select * from vacante where ID_L=" + id_l;
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<vacante> Vac = new ArrayList<>();
        while (resultSet.next()) {
            Vac.add(new vacante(resultSet.getInt("idVacante"), resultSet.getInt("ID_U"), resultSet.getInt("ID_L"),
                    resultSet.getDate("Data_st"), resultSet.getDate("Data_sf"), resultSet.getInt("BaniV")));
        }

        return Vac;
    }

    public static ArrayList<vacante> afisareVacanteIDV(int id_v) throws Exception {
        Connection connection = DbConnection.Deschidere_Con_BD();
        Statement statement = connection.createStatement();
        String sql = "select * from vacante where idVacante=" + id_v;
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<vacante> Vac = new ArrayList<>();
        while (resultSet.next()) {
            Vac.add(new vacante(resultSet.getInt("idVacante"), resultSet.getInt("ID_U"), resultSet.getInt("ID_L"),
                    resultSet.getDate("Data_st"), resultSet.getDate("Data_sf"), resultSet.getInt("BaniV")));
        }
        return Vac;


    }

    public static ArrayList<vacante> afisareVacanteIDU(int id_u) throws Exception {
        Connection connection = DbConnection.Deschidere_Con_BD();
        Statement statement = connection.createStatement();
        String sql = "select * from vacante where ID_U=" + id_u;
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<vacante> Vac = new ArrayList<>();
        while (resultSet.next()) {
            Vac.add(new vacante(resultSet.getInt("idVacante"), resultSet.getInt("ID_U"), resultSet.getInt("ID_L"),
                    resultSet.getDate("Data_st"), resultSet.getDate("Data_sf"), resultSet.getInt("BaniV")));
        }

        return Vac;

    }

    static public int addVacanta(int id_u, int id_l, Date data_st, Date data_sf, int baniV) throws SQLException {
    Connection connection = DbConnection.Deschidere_Con_BD();
    String sql = "insert into vacante(id_u, id_l, data_st, data_sf, baniv) values (?,?,?,?,?)";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setInt(1,id_u);
    preparedStatement.setInt(2,id_l);
    preparedStatement.setDate(3,data_st);
    preparedStatement.setDate(4,data_sf);
    preparedStatement.setInt(5,baniV);
    preparedStatement.execute();
    Statement pr2=connection.createStatement();
    sql="select max(idVacante)\n" +
            "from vacante";
    ResultSet resultSet=pr2.executeQuery(sql);

    if(resultSet.next())
    return resultSet.getInt(1);
    else
        return 0;

    }

    static public vacante getVac(int id) throws SQLException
    {
        Connection connection= DbConnection.Deschidere_Con_BD();
        String sql= "select * from vacante where idVacante="+id;
        Statement statement=connection.createStatement();
        ResultSet resultSet=  statement.executeQuery(sql);
        if(resultSet.next())
        return new vacante(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getDate(4),resultSet.getDate(5),resultSet.getInt(6));

        else
            return null;
    }
    static public void updateVac(int id, Date data_st, Date data_sf, int baniV) throws SQLException {
        Connection connection = DbConnection.Deschidere_Con_BD();

        String sql2="UPDATE vacante SET Data_St = ?, Data_Sf = ?, `BaniV` = ? WHERE idVacante = ?;";
        PreparedStatement preparedStatement=connection.prepareStatement(sql2);
        preparedStatement.setDate(1,data_st);
        preparedStatement.setDate(2,data_sf);
        preparedStatement.setInt(3,baniV);
        preparedStatement.setInt(4,id);
        preparedStatement.executeUpdate();


    }

    static public void deleteVac(int id)throws Exception
    {
        Connection connection= DbConnection.Deschidere_Con_BD();
        String sql= "delete from vacante where idVacante="+id;
        Statement statement=connection.createStatement();
        statement.execute(sql);
    }
}
