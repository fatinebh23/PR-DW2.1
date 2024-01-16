package org.example;

import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperacionesCRUDPilotos {

   // CrearPiloto(), que reciba un objeto Piloto y lo añada a la base de datos
    public static void crearPiloto(Path ruta, Piloto pilotoParam) {

        try(Connection con = DriverManager.getConnection("jdbc:sqlite:" + ruta.toString())){

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
   public static Piloto LeerPiloto(Path ruta, int paramID) {

       try (Connection con = DriverManager.getConnection("jdbc:sqlite:" + ruta.toString())) {

           String sentenciaLeer = "SELECT * FROM pilotos WHERE driverid = ?";

           PreparedStatement insercion = con.prepareStatement(sentenciaLeer);

           insercion.setInt(1, paramID);
//hollaaa
           ResultSet resultados = insercion.executeQuery();

           try (ResultSet resultSet = insercion.executeQuery()) {
               while (resultSet.next()) {

                   String code = resultSet.getString("code");
                   String nombre = resultSet.getString("forename");
                   String surname = resultSet.getString("surname");
                   String dob = resultSet.getString("dob");
                   String nationality = resultSet.getString("nationality");
                   String url = resultSet.getString("url");


                   return new Piloto(code, nombre, surname, dob, nationality, url);
               }
               resultados.close();
           }
       } catch (SQLException e) {
           System.err.println(e.getClass().getName() + ": " + e.getMessage());
           throw new RuntimeException(e);
       }


       return null;
   }
//    LeerPilotos(), que devuelva un listado completo de objetos Piloto.
    public static List<Piloto> LeerPilotos(Path ruta) throws SQLException {

        List<Piloto> pilotos = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:sqlite:" + ruta.toString())) {

            String sql = "SELECT * FROM pilotos";

            try (PreparedStatement statement = con.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    String code = resultSet.getString("code");
                    String nombre = resultSet.getString("forename");
                    String surname = resultSet.getString("surname");
                    String dob = resultSet.getString("dob");
                    String nationality = resultSet.getString("nationality");
                    String url = resultSet.getString("url");


                    Piloto piloto = new Piloto(code, nombre, surname, dob, nationality, url);
                    pilotos.add(piloto);
                }
            } catch (SQLException e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                throw new RuntimeException(e);
            }


            return null;
        }


    }}







