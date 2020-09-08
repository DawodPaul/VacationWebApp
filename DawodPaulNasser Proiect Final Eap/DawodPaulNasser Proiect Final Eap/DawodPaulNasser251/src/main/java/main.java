import repository.*;
import utils.DbConnection;

import java.sql.SQLException;

public class main {

    public static void main(String[] args) throws Exception {
        System.out.println(atractiiRepository.listaAtractiiByVac(4).get(1).toString());
    }

}
