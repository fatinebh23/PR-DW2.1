package org.example;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {

    private int clientid;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String usuario;
    private String contrasenya;
    private String dni;
    private String email;
    private String nacionalidad;
    private Date dob;
    private String calle;
    private int cp;
    private String municipio;
    private String provincia;

    public Cliente(String nombre, String apellidos, String telefono, String usuario, String contrasenya, String dni, String email, String nacionalidad, String dob, String calle, String cp, String municipio, String provincia) {
    }
}
