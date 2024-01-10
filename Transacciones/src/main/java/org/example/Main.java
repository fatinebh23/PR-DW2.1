package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

     String sentenciaSQL= "SELECT * FROM actores";
        String insertarnombre= "INSERT INTO actores  VALUES (?,?,?)";
        String elimiarnombre= "DELETE FROM actores WHERE nombre = ?";


     String usuario="postgres";
     String contrasenya = "postgres";

     try(Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/mi-base", usuario,contrasenya);
         PreparedStatement sentenciaSelect= con.prepareStatement(sentenciaSQL)){

         ResultSet resultados = sentenciaSelect.executeQuery();

         System.out.println("SELECT: ");

         while (resultados.next()){
            String nombre= resultados.getString("nombre");
            Integer edad= resultados.getInt("edad");
             Integer id= resultados.getInt("id");
             System.out.println(nombre);
             System.out.println(edad);
             System.out.println(id);
         }

         System.out.println("INSERTAR UN NOMBRE : ");
         //insertar un nombre

         PreparedStatement sentenciaInsert= con.prepareStatement(insertarnombre);

         sentenciaInsert.setInt(1, 26);
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

         System.out.println("Despues de Eliminar un nombre: ");


         PreparedStatement sentenciaEliminar= con.prepareStatement(elimiarnombre);

         sentenciaEliminar.setString( 1,"ANA");

         sentenciaEliminar.executeUpdate();
        //volvemos a ejecutar la consulta select


         while (resultados.next()){
             String nombre= resultados.getString("nombre");
             Integer edad= resultados.getInt("edad");
             Integer id= resultados.getInt("id");
             System.out.println(nombre);
             System.out.println(edad);
             System.out.println(id);
         }

         resultados.close();
     }catch (SQLException e){
         //Rollback en caso de error

         throw new RuntimeException();
        }










    }
}