package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
     String sentenciaSQL= "SELECT * FROM actores";


     String usuario="postgres";
     String contrasenya = "postgres";

     try(Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/mi-base", usuario,contrasenya);
         PreparedStatement sentencia= con.prepareStatement(sentenciaSQL)){

         ResultSet resultados = sentencia.executeQuery();

         while (resultados.next()){
            String nombre= resultados.getString("nombre");
            Integer edad= resultados.getInt("edad");
             Integer id= resultados.getInt("id");
             System.out.println(nombre);
             System.out.println(edad);
             System.out.println(id);
         }

     }catch (SQLException e){
         throw new RuntimeException();
        }
    }
}