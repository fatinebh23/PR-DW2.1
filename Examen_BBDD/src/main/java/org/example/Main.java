package org.example;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Cuenta cuentaPrueba = new Cuenta(11,"ES06300446891645624429433",5452.96,45);
        Cuenta actualizarcuenta = new Cuenta(11,"ES06300446891645624429433",5452.96,46);

        Cliente clientePrueba =new Cliente(3,"fatine","bouhrich","562616854","fatine123","jhgje2","2091789862l","fatinebh@gmail.com","Marruecos", Date.valueOf("1999-11-13"),"calle alcalde",12530,"burriana","castellon");


        Cliente actualizarCliente =new Cliente(3,"fatine","bouhrich","562616854","fatine123","jhgje2","2091789862l","fatinebh@gmail.com","Marruecos", Date.valueOf("1999-11-13"),"calle alcalde",12530,"burriana","castellon");

        //cerar cuenta(funciona)
       // Operaciones.crearCuenta(cuentaPrueba);


        //crear cliente(funciona)
        //Operaciones.crearCliente(clientePrueba);

        //borrar cuenta (funciona)
        //Operaciones.BorrarCuenta(cuentaPrueba);


        //borrar cliente
    //Operaciones.BorrarCliente(3);


        //borrar cliente
        //Operaciones.BorrarCliente2(clientePrueba,3);

        //actulizar cuenta
       // Operaciones.Actualizarcuenta(actualizarcuenta,3);

        //actulizar cliente
       // Operaciones.ActualizarCliente(actualizarCliente,3);


        //Listar las cuentas
        List<Cuenta> cuentas = Operaciones.Leercuentas();

//mostrar informacion de cuentas
     for (Cuenta cuenta : cuentas) {
          System.out.println( "iban: "+cuenta.getIban()+ "balance: "+cuenta.getBalance()+ "clientid: : "+cuenta.getClientid())   ;


      }


        //Listar los clientes
        List<Cliente> clientes = Operaciones.LeerClientes();
//mostrar informacion de clientes
        for (Cliente cliente : clientes) {
            System.out.println( clientes);

        }

//obtener/devolver cuenta
        Cuenta nuevaCuenta= Operaciones.Devolvercuenta(2);

        //obtener/devolver cliente
        Cliente nuevCliente= Operaciones.DevolverCliente(2);



    }
}