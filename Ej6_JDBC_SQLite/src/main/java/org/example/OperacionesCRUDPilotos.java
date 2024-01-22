package org.example;

import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperacionesCRUDPilotos {

    static String usuario="postgres";
    static String contrasenya = "postgres";
    static String ruta="jdbc:postgresql://localhost:5432/f12006-pg";

    // CrearPiloto(), que reciba un objeto Piloto y lo añada a la base de datos
    //FUNCIONaaaA
    public static void crearPiloto( Piloto pilotoParam) {

        try(Connection con = DriverManager.getConnection(ruta,usuario,contrasenya)){

            String insercionSQL = "INSERT INTO drivers ( code, forename, surname, dob, nationality, url) VALUES (?, ?, ?, ?, ?,?)";

        // Creamos ahora una sentencia de modificación, en este caso un INSERT

            PreparedStatement insercion = con.prepareStatement(insercionSQL);

            insercion.setString(1, pilotoParam.getCode());
            insercion.setString(2, pilotoParam.getForename());
            insercion.setString(3, pilotoParam.getSurname());
            insercion.setDate(4, Date.valueOf(pilotoParam.getDob()));
            insercion.setString(5, pilotoParam.getNationality());
            insercion.setString(6, pilotoParam.getUrl());

            insercion.executeUpdate();
            // Comprobamos los cambios realizados en la tabla drivers


        }catch (SQLException e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            throw new RuntimeException();
        }
    }


   /*2. LeerPiloto(), que reciba un entero y devuelva un objeto Piloto con la información del piloto
    con el driverid coincidente*/

   //Funcionaaaaaaa
   public static Piloto LeerPiloto( int paramID) {

       try (Connection con =  DriverManager.getConnection(ruta,usuario,contrasenya)) {

           String sentenciaLeer = "SELECT * FROM drivers WHERE driverid = ?";

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
    public static List<Piloto> LeerPilotos() throws SQLException {

        List<Piloto> pilotos = new ArrayList<>();
        try (Connection con =  DriverManager.getConnection(ruta,usuario,contrasenya)) {

            String sql = "SELECT * FROM drivers";

            PreparedStatement statement = con.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery();

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


        return pilotos;
        }
// ActualizarPiloto(), que reciba un objeto Piloto y actualice los datos del registro coincidente
//   en la base de datos con el mismo driverid.

    public static void ActualizarPiloto(Piloto piloto) {

        try (Connection connection =  DriverManager.getConnection(ruta,usuario,contrasenya)) {
            String query = "UPDATE drivers SET code = ?,Forename = ?,Surname = ?,Dob = ?,Nationality = ?,Url = ?, WHERE driverid = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query) ;


                preparedStatement.setString(1, piloto.getCode());
                preparedStatement.setString(2, piloto.getForename());
                preparedStatement.setString(3, piloto.getSurname());
                preparedStatement.setString(4, piloto.getDob());
                preparedStatement.setString(5, piloto.getNationality());
                preparedStatement.setString(6, piloto.getUrl());

                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Piloto actualizado con éxito.");
                } else {
                    System.out.println("No se encontró ningún piloto con el ID proporcionado.");
                }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
//    private String code ;
//    private  String forename;
//    private String surname ;
//    private String dob ;
//    private String nationality;
//    private String url ;


//5.BorrarPiloto(), que reciba un objeto Piloto y lo elimine de la base de datos.
    //Funcionaaaaaaa
        public static void BorrarPiloto(Piloto piloto) throws SQLException {
            try (Connection connection =  DriverManager.getConnection(ruta,usuario,contrasenya)) {

                String query = "DELETE FROM drivers WHERE code = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1, piloto.getCode());

            preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }




}

























