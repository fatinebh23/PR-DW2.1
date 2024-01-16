package org.example;

import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        //ruta BBDD
        Path ruta = Path.of("src", "main", "resources", "f12006sqlite.db");

        Piloto pilotoParam = new Piloto("Fatine","boihrich","hmidi","uolaa","español","https://en.wikipedia.org/wiki/Carlos_Sainz_Jr.");

        OperacionesCRUDPilotos.crearPiloto(ruta,pilotoParam);

        OperacionesCRUDPilotos.LeerPiloto(ruta,3);

        List<Piloto> pilotos = OperacionesCRUDPilotos.LeerPilotos(ruta);
    }
}