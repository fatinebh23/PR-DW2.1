package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String sentenciaSQL= "SELECT * FROM drivers WHERE nationality ='Spanish'";
        String sentenciaProced= "select get_results_by_driver('ALO')";

        String usuario="postgres";
        String contrasenya = "postgres";



        try(Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/f12006-pg", usuario,contrasenya);

            PreparedStatement sentenciaSelect= con.prepareStatement(sentenciaSQL)) {


            ResultSet resultados = sentenciaSelect.executeQuery();


            System.out.println("SELECT: ");

            while (resultados.next()) {
                String nombre = resultados.getString("forename");
                String apellido = resultados.getString("surname");
                System.out.println("piloto " + nombre + " " + apellido);


            }

/////////////////////////////////////////////////////////////////////////////////////////////


            //Mostrar info procedimeinto almacenado "get_results_by_driver


            PreparedStatement procedimientoDriver = con.prepareStatement(sentenciaProced);

            procedimientoDriver.execute();

            ResultSet resultados2 = sentenciaSelect.executeQuery();

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

          /*  while (resultados2.next()) {
                System.out.format("%4d%30s%20s%10f\n",resultados2.getInt("round"),
                        resultados.getString("circuit"),
                        resultados2.getInt("result"),
                        resultados2.getInt("points"),
                        resultados2.getDate("date"));*/


         /*   round INT,
            circuit VARCHAR,
            result INT,
            points INT,
            date DATE*/


        }catch (SQLException e) {

            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }
}