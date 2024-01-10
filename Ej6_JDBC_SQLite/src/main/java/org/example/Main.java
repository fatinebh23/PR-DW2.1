package org.example;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        //ruta BBDD
        Path ruta = Path.of("src", "main", "resources", "f12006sqlite.db");

        Piloto pilotoParam = new Piloto("Fatine","boihrich","hmidi","uolaa","español","https://en.wikipedia.org/wiki/Carlos_Sainz_Jr.");

        OperacionesCRUDPilotos.crearPiloto(ruta,pilotoParam);
    }
}