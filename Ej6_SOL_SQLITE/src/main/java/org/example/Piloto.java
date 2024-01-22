package org.example.ejercicios.Ejercicio6JDBCySQLite;

import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Piloto {
        // Atributos
        private int driverId;
        private String driverCode;
        private String driverForename;
        private String driverSurname;
        private LocalDate driverDOB;
        private String driverNationality;
        private int constructorId;
        private String url;

        /**
         * Constructor de Piloto
         * @param driverId ID del piloto
         * @param driverCode Código del piloto
         * @param driverForename Nombre del piloto
         * @param driverSurname Apellido del piloto
         * @param driverDOB Fecha de nacimiento del piloto
         * @param driverNationality Nacionalidad del piloto
         * @param constructorId ID del constructor
         * @param url URL del piloto
         */
        public Piloto(int driverId, String driverCode, String driverForename, String driverSurname, String driverDOB, String driverNationality, int constructorId, String url) {
            this.driverId = driverId;
            this.driverCode = driverCode;
            this.driverForename = driverForename;
            this.driverSurname = driverSurname;
            this.driverDOB = LocalDate.parse(driverDOB);
            this.driverNationality = driverNationality;
            this.constructorId = constructorId;
            this.url = url;
        }
}
