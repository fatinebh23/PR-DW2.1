package org.example;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para realizar operaciones CRUD sobre la tabla drivers
 */
public class OperacionesCRUDPilotos {
    // Path de la base de datos
    private static final Path pathDB = Path.of("src","main","resources","f12006sqlite.db");


    /**
     * Método para crear un piloto
     * @param piloto Piloto a crear
     */
    public static void crearPiloto(Piloto piloto){

        // Conexión a la base de datos
        PreparedStatement insert = null;

        // Inserción de datos
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + pathDB)) {

            // Inserción en la tabla drivers
            String sql = "INSERT INTO drivers (code, forename, surname, dob, nationality, constructorId, url) VALUES (?,?,?,?,?,?,?)";

            // Preparación de la inserción
            insert = conexion.prepareStatement(sql);

            // Inserción de datos
            insert.setString(1, piloto.getDriverCode());
            insert.setString(2, piloto.getDriverForename());
            insert.setString(3, piloto.getDriverSurname());
            insert.setString(4, piloto.getDriverDOB().toString());
            insert.setString(5, piloto.getDriverNationality());
            insert.setInt(6, piloto.getConstructorId());
            insert.setString(7, piloto.getUrl());

            // Ejecución de la inserción
            insert.executeUpdate();
        } catch (Exception SQLException) {

            System.err.println("Error al crear el piloto");
        } finally {
            try {
                // Cierre de la conexión
                assert insert != null;
                insert.close();
            } catch (Exception SQLException) {
                // Error al cerrar la conexión
                System.err.println("Error al cerrar la conexión");
            }
        }
        System.out.println("Piloto creado");
    }

    /**
     * Método para leer un piloto
     * @param driverId Id del piloto a leer
     * @return Piloto leído
     */
    public static Piloto leerPiloto(int driverId) {

        // Conexión a la base de datos
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + pathDB)) {
            System.out.println("Conexión establecida");

            // Consulta de la tabla drivers
            String sql = "SELECT * FROM drivers WHERE driverId = ?";

            // Preparación de la consulta
            PreparedStatement select = conexion.prepareStatement(sql);

            // Inserción de datos
            select.setInt(1, driverId);

            // Ejecución de la consulta
                ResultSet resultados = select.executeQuery();
            // Devolución del piloto
            return new Piloto(
                    resultados.getInt("driverId"),
                    resultados.getString("code"),
                    resultados.getString("forename"),
                    resultados.getString("surname"),
                    resultados.getString("dob"),
                    resultados.getString("nationality"),
                    resultados.getInt("constructorId"),
                    resultados.getString("url"));
        } catch (Exception SQLException) {
            // Error al leer el piloto
            System.err.println("Error al leer el piloto");
            return null;
        }
    }

    /**
     * Método para leer todos los pilotos
     * @return Lista de pilotos
     */
    public static List<Piloto> leerPilotos() {

        // Conexión a la base de datos
        List<Piloto> pilotos = new ArrayList<>();

        // Consulta de la tabla drivers
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + pathDB)) {

            System.out.println("Conexión establecida");

            // Preparación de la consulta
            String sql = "SELECT * FROM drivers";

            // Ejecución de la consulta
            PreparedStatement select = conexion.prepareStatement(sql);

            // Resultados de la consulta
            ResultSet resultados = select.executeQuery();

            // Creación de la lista de pilotos
            while (resultados.next()){

                // Añadir piloto a la lista
                pilotos.add(new Piloto(
                        resultados.getInt("driverId"),
                        resultados.getString("code"),
                        resultados.getString("forename"),
                        resultados.getString("surname"),
                        resultados.getString("dob"),
                        resultados.getString("nationality"),
                        resultados.getInt("constructorId"),
                        resultados.getString("url")
                ));
            }

        } catch (Exception SQLException) {
            System.err.println("Error al leer los pilotos");
        }
        // Devolución de la lista de pilotos
        System.out.println("Pilotos creados");
        return pilotos;
    }

    /**
     * Método para actualizar un piloto
     * @param piloto Piloto a actualizar
     * @param driverId Id del piloto a actualizar
     */
    public static void actualizarPiloto(Piloto piloto, int driverId){

        // Conexión a la base de datos
        PreparedStatement update = null;

        // Actualización de datos
        try(Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + pathDB)){

            // Preparación de la actualización
            String sql = "UPDATE drivers SET code = ?, forename = ?, surname = ?, dob = ?, nationality = ?, constructorId = ?, url = ? WHERE driverId = ?";

            // Ejecución de la actualización
            update = conexion.prepareStatement(sql);

            // Inserción de datos
            update.setString(1, piloto.getDriverCode());
            update.setString(2, piloto.getDriverForename());
            update.setString(3, piloto.getDriverSurname());
            update.setString(4, piloto.getDriverDOB().toString());
            update.setString(5, piloto.getDriverNationality());
            update.setInt(6, piloto.getConstructorId());
            update.setString(7, piloto.getUrl());
            update.setInt(8, driverId);

            // Ejecución de la actualización
            update.executeUpdate();
            System.out.println("Piloto actualizado");
        } catch (Exception SQLException) {
            System.err.println("Error al actualizar el piloto");
        } finally {
            try{
                assert update != null;
                update.close();
            } catch (Exception SQLException) {
                System.err.println("Error al cerrar la conexión");
            }

        }
    }

    /**
     * Método para borrar un piloto
     * @param driverId Id del piloto a borrar
     */
    public static void borrarPiloto(int driverId) {

        // Conexión a la base de datos
        try(Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + pathDB)){

            // Borrado de datos
            System.out.println("Conexión establecida");

            // Preparación del borrado
            String sql = "DELETE FROM drivers WHERE driverId = ?";

            // Ejecución del borrado
            PreparedStatement delete = conexion.prepareStatement(sql);

            // Inserción de datos
            delete.setInt(1, driverId);

            // Ejecución del borrado
            delete.executeUpdate();
            System.out.println("Piloto borrado");
        } catch (Exception SQLException) {
            System.err.println("Error al borrar el piloto");
        }
    }

    /**
     * Método para mostrar la clasificación de pilotos
     */
    public static void MostrarClasificacionPiloto(){

        // Conexión a la base de datos
        try(Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + pathDB)){
            System.out.println("Conexión establecida");

            // Consulta de la tabla drivers
            //String sql = "SELECT d.code, r.points FROM drivers d JOIN results r ON d.driverid = r.driverid GROUP BY d.code ORDER BY r.points DESC";
            String sql = "SELECT d.code, sum(r.points) AS points " +
                    "FROM drivers d JOIN results r ON d.driverid = r.driverid \n" +
                    "group by d.code order by sum(r.points) DEsc";

            // Ejecución de la consulta
            PreparedStatement select = conexion.prepareStatement(sql);

            // Resultados de la consulta
            ResultSet resultados = select.executeQuery();

            // Mostrar resultados
            while (resultados.next()){
                System.out.println(resultados.getString("code") + " " + resultados.getInt("points"));
            }
        } catch (Exception SQLException) {
            System.err.println("Error al mostrar la clasificación de pilotos");
        }
    }


    /**
     * Método para mostrar la clasificación de constructores
     */
    public static void MostrarClasificacionConstructores(){

        // Conexión a la base de datos
        try(Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + pathDB)){
            System.out.println("Conexión establecida");

            // Consulta de la tabla drivers
            String sql = "SELECT c.name, SUM(r.points) AS Puntos " +
                    "FROM constructors c INNER JOIN drivers d " +
                    "ON c.constructorid = d.constructorid " +
                    "INNER JOIN results r ON d.driverid = r.driverid " +
                    "GROUP BY c.constructorid ORDER BY puntos DESC";

            // Ejecución de la consulta
            PreparedStatement select = conexion.prepareStatement(sql);

            // Resultados de la consulta
            ResultSet resultados = select.executeQuery();

            // Mostrar resultados
            while (resultados.next()){
                System.out.println(resultados.getString("name") + " " + resultados.getInt("Puntos"));
            }
        } catch (Exception SQLException) {
            System.err.println("Error al mostrar la clasificación de constructores");
        }
    }
}
