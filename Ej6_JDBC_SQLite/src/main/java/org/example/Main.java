package org.example;

import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        //ruta BBDD
        Path ruta = Path.of("src", "main", "resources", "f12006sqlite.db");

        Piloto pilotoParam = new Piloto("FAT","fatine","hmidi","2004-07-10","español","https://en.wikipedia.org/wiki/Carlos_Sainz_Jr.");
//ejer1
        //OperacionesCRUDPilotos.crearPiloto(pilotoParam);

//ejer2
        Piloto nuevoPiloto= OperacionesCRUDPilotos.LeerPiloto(2);
        System.out.println(nuevoPiloto.getForename());


//        List<Piloto> pilotos = OperacionesCRUDPilotos.LeerPilotos();
//
//        for (Piloto piloto : pilotos) {
//            System.out.println("Code: " + piloto.getCode() + ", Nombre: " + piloto.getForename()+ ", Apellidos: " + piloto.getForename()+ ", Url: " + piloto.getUrl()+ ", Nacionalidad: " + piloto.getNationality()+ ", Dob: " + piloto.getDob());
//            // Imprimir otros atributos según la estructura de tu tabla
//        }
//        OperacionesCRUDPilotos.ActualizarPiloto(pilotoParam);
        //OperacionesCRUDPilotos.BorrarPiloto(pilotoParam);

    }
}