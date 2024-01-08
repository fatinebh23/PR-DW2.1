package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

     String sentenciaSQL= "SELECT * FROM actores";
        String insertarnombre= "INSERT INTO actores  VALUES (?,?,?)";
        String elimiarnombre= "DELETE FROM actores WHERE nombre = ANA";


     String usuario="postgres";
     String contrasenya = "postgres";

     try(Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/mi-base", usuario,contrasenya);
         PreparedStatement sentenciaSelect= con.prepareStatement(sentenciaSQL)){

         ResultSet resultados = sentenciaSelect.executeQuery();


         while (resultados.next()){
            String nombre= resultados.getString("nombre");
            Integer edad= resultados.getInt("edad");
             Integer id= resultados.getInt("id");
             System.out.println(nombre);
             System.out.println(edad);
             System.out.println(id);
         }

         //insertar un nombre

         PreparedStatement sentenciaInsert= con.prepareStatement(insertarnombre);

         sentenciaInsert.setInt(1, 25);
         sentenciaInsert.setString( 2,"ANA");
         sentenciaInsert.setInt( 3,56);

         sentenciaInsert.executeUpdate();

          resultados = sentenciaSelect.executeQuery();

         while (resultados.next()){
             String nombre= resultados.getString("nombre");
             Integer edad= resultados.getInt("edad");
             Integer id= resultados.getInt("id");
             System.out.println(nombre);
             System.out.println(edad);
             System.out.println(id);
         }


         //eliminar un nombre

         PreparedStatement sentenciaeliminar= con.prepareStatement(elimiarnombre);

         sentenciaeliminar.executeUpdate();

         resultados = sentenciaSelect.executeQuery();

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