package org.example.ejercicios.Ejercicio6JDBCySQLite;


import java.util.List;

/**
 * Clase principal para probar el CRUD de pilotos
 */
public class Ejercicio6 {
    public static void main(String[] args){
        // Prueba de CRUD de pilotos
        int driverId = 39;
Piloto pilotoPrueba = new Piloto(39, "NOR", "Lando", "Norris", "1999-11-13", "British", 1, "https://en.wikipedia.org/wiki/Lando_Norris");
Piloto pilotoPrueba2 = new Piloto(39, "RIC", "Daniel", "Ricciardo", "1989-07-01", "Australian", 1, "https://en.wikipedia.org/wiki/Daniel_Ricciardo");
        // Crear piloto
        OperacionesCRUDPilotos.crearPiloto(pilotoPrueba);
        // Leer piloto
        Piloto pilotoTest = OperacionesCRUDPilotos.leerPiloto(39);
        // Mostrar piloto
        System.out.println(pilotoTest);
        // Actualizar piloto
        OperacionesCRUDPilotos.actualizarPiloto(pilotoPrueba2, driverId);
        //Compruebo la modificación
        pilotoTest = OperacionesCRUDPilotos.leerPiloto(39);
        System.out.println(pilotoTest);
        // Borrar piloto
        OperacionesCRUDPilotos.borrarPiloto(39);
        //Compruebo el borrado
        pilotoTest = OperacionesCRUDPilotos.leerPiloto(39);
        System.out.println("piloto: "+ pilotoTest);
        // Mostrar clasificación de pilotos
        System.out.println("clasificacion piloto");
        OperacionesCRUDPilotos.MostrarClasificacionPiloto();
        // Mostrar clasificación de constructores
        OperacionesCRUDPilotos.MostrarClasificacionConstructores();
        // Leer pilotos
        List<Piloto> pilotos = OperacionesCRUDPilotos.leerPilotos();
        // Mostrar pilotos
        for (Piloto piloto : pilotos) {
            System.out.println(piloto);
        }
    }
}
