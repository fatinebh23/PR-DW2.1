package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Piloto {

  /*  Una clase Piloto que facilite la lectura y escritura de pilotos en la tabla drivers. Para hacerte la vida
    más fácil, no tengas en cuenta la clave ajena que la tabla drivers tiene a la tabla constructors, es
    decir, crea pilotos sin equipo*/


    private String code ;
    private  String forename;
    private String surname ;
    private String dob ;
    private String nationality;
    private String url ;

}
