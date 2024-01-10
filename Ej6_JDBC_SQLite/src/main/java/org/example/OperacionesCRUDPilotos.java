package org.example;

import java.nio.file.Path;
import java.sql.*;

public class OperacionesCRUDPilotos {

   // CrearPiloto(), que reciba un objeto Piloto y lo añada a la base de datos
    public static void crearPiloto(Path ruta, Piloto pilotoParam) {

        try(Connection con = DriverManager.getConnection("jdbc:sqlite:" + ruta.toString()){

            String insercionSQL = "INSERT INTO drivers ( code, forename, surname, dob, nationality, url) VALUES (?, ?, ?, ?, ?,?)";

        // Creamos ahora una sentencia de modificación, en este caso un INSERT

            PreparedStatement insercion = con.prepareStatement(insercionSQL);

            insercion.setString(1, pilotoParam.getCode());
            insercion.setString(2, pilotoParam.getCode());
            insercion.setString(3, pilotoParam.getCode());
            insercion.setString(4, pilotoParam.getCode());
            insercion.setString(5, pilotoParam.getCode());
            insercion.setString(6, pilotoParam.getCode());


            // Comprobamos los cambios realizados en la tabla drivers

            insercion.close();
        }catch (SQLException e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            throw new RuntimeException();
        }
    }


   /*2. LeerPiloto(), que reciba un entero y devuelva un objeto Piloto con la información del piloto
    con el driverid coincidente*/
   public static void LeerPiloto(Path ruta, Piloto pilotoId) {

       try(Connection con = DriverManager.getConnection("jdbc:sqlite:" + ruta.toString()){

           String consultaSQL = "SELECT driverid, code, forename, surname, strftime('%d/%m/%Y', dob) AS formatted_dob, nationality " +
                   "FROM drivers " +
                   "WHERE driverid = ? ";

           // Creamos ahora una sentencia de modificación, en este caso un INSERT

           PreparedStatement insercion = con.prepareStatement(consultaSQL);

           ResultSet resultados = insercion.executeQuery();


           // Comprobamos los cambios realizados en la tabla drivers


           while (resultados.next()) {
               String circuit = resultados.getString("circuit");
               Integer result = resultados.getInt("result");
               Integer points = resultados.getInt("points");
               Date date = resultados.getDate("date");


               System.out.println(circuit);
               System.out.println(result);
               System.out.println(points);
               System.out.println(date);

           }
       }catch (SQLException e) {

           System.err.println(e.getClass().getName() + ": " + e.getMessage());
           throw new RuntimeException();
       }
   }


   }


}



