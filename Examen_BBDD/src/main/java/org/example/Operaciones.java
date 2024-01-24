package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Operaciones {
    static String usuario="postgres";
    static String contrasenya = "postgres";
    static String ruta="jdbc:postgresql://localhost:5432/accounts";
    PreparedStatement consulta;
    //crear cuenta

    public static void crearCuenta( Cuenta cuentaparam) {

        try(Connection con = DriverManager.getConnection(ruta,usuario,contrasenya)){

            String insercionSQL = "INSERT INTO accounts ( iban, balance, clientid) VALUES ( ?, ?, ?)";

            // Creamos ahora una sentencia de modificación, en este caso un INSERT

            PreparedStatement insercion = con.prepareStatement(insercionSQL);

            insercion.setString(1, cuentaparam.getIban());
            insercion.setDouble(2, cuentaparam.getBalance());
            insercion.setInt(3, cuentaparam.getClientid());

            insercion.executeUpdate();
            // Comprobamos los cambios realizados en la tabla accounts


        }catch (SQLException e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            throw new RuntimeException();
        }
    }
//    crear un cliente
    public static void crearCliente( Cliente clienteParam) {

        try(Connection con = DriverManager.getConnection(ruta,usuario,contrasenya)){

            String insercionSQL = "INSERT INTO clientes ( nombre, apellidos,telefono,usuario,contrasenya,dni,email,nacionalidad,dob,calle,cp,municipio,provincia) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

            // Creamos ahora una sentencia de modificación, en este caso un INSERT

            PreparedStatement insercion = con.prepareStatement(insercionSQL);


            insercion.setString(1, clienteParam.getNombre());
            insercion.setString(2, clienteParam.getApellidos());
            insercion.setString(3, clienteParam.getTelefono());
            insercion.setString(4, clienteParam.getUsuario());
            insercion.setString(5, clienteParam.getContrasenya());
            insercion.setString(6, clienteParam.getDni());
            insercion.setString(7, clienteParam.getEmail());
            insercion.setString(8, clienteParam.getNacionalidad());
            insercion.setDate(9, Date.valueOf(String.valueOf(clienteParam.getDob())));
            insercion.setString(10, clienteParam.getCalle());
            insercion.setInt(11, clienteParam.getCp());
            insercion.setString(12, clienteParam.getMunicipio());
            insercion.setString(13, clienteParam.getProvincia());



            insercion.executeUpdate();
            // Comprobamos los cambios realizados en la tabla accounts


        }catch (SQLException e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            throw new RuntimeException();
        }
    }

    public static void BorrarCuenta(Cuenta ibanparam) throws SQLException {
        try (Connection connection =  DriverManager.getConnection(ruta,usuario,contrasenya)) {

            String query = "DELETE FROM accounts WHERE iban = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, ibanparam.getIban());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void BorrarCliente(int idparam) throws SQLException {
        try (Connection connection =  DriverManager.getConnection(ruta,usuario,contrasenya)) {

            String query = "DELETE FROM clientes WHERE clientid = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, idparam);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void BorrarCliente2(Cliente cliente, int idparam) throws SQLException {
        try (Connection connection =  DriverManager.getConnection(ruta,usuario,contrasenya)) {

            String query = "DELETE FROM clientes WHERE clientid = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, cliente.getClientid());
            preparedStatement.setInt(1, idparam);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void Actualizarcuenta(Cuenta cuenta,int id) {

        try (Connection con = DriverManager.getConnection(ruta,usuario,contrasenya)){
            String update = "UPDATE accounts SET iban = ?, balance = ?, clientid = ? WHERE clientid = ?";
            PreparedStatement preparedStatement = con.prepareStatement(update);


            preparedStatement.setString(1, cuenta.getIban());

            preparedStatement.setDouble(2, cuenta.getBalance());
            preparedStatement.setInt(3, cuenta.getClientid());
            preparedStatement.setInt(4, id);


            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }


    public static void ActualizarCliente(Cliente cliente,int id) {

        try (Connection con = DriverManager.getConnection(ruta,usuario,contrasenya)){
            String update = "UPDATE clientes SET nombre = ?, apellidos = ?, telefono = ?, usuario = ?, contrasenya = ?, dni = ?, email = ?, nacionalidad = ?, dob = ?, calle = ?, cp = ?, municipio = ?, provincia = ? WHERE clientid = ? ";
            PreparedStatement preparedStatement = con.prepareStatement(update);

            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellidos());
            preparedStatement.setString(3, cliente.getTelefono());
            preparedStatement.setString(4, cliente.getUsuario());
            preparedStatement.setString(5, cliente.getContrasenya());
            preparedStatement.setString(6, cliente.getDni());
            preparedStatement.setString(7, cliente.getEmail());
            preparedStatement.setString(8, cliente.getNacionalidad());
            preparedStatement.setDate(9, Date.valueOf(String.valueOf(cliente.getDob())));
            preparedStatement.setString(10, cliente.getCalle());
            preparedStatement.setInt(11, cliente.getCp());
            preparedStatement.setString(12, cliente.getMunicipio());
            preparedStatement.setString(13, cliente.getProvincia());
            preparedStatement.setInt(14, id);

            preparedStatement.executeUpdate();


        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public static List<Cuenta> Leercuentas() throws SQLException {

        List<Cuenta> cuentas = new ArrayList<>();
        try (Connection con =  DriverManager.getConnection(ruta,usuario,contrasenya)) {

            String sql = "SELECT * FROM accounts";

            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                cuentas.add(new Cuenta(
                        resultSet.getString("iban"),
                        resultSet.getString("balance"),
                        resultSet.getString("clientid")

                ));

            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            throw new RuntimeException(e);
        }


        return cuentas;
    }

    public static List<Cliente> LeerClientes() throws SQLException {

        List<Cliente> clientes = new ArrayList<>();
        try (Connection con =  DriverManager.getConnection(ruta,usuario,contrasenya)) {

            String sql = "SELECT * FROM clientes";

            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String telefono = resultSet.getString("telefono");
                String usuario = resultSet.getString("usuario");
                String contrasenya = resultSet.getString("contrasenya");
                String dni = resultSet.getString("dni");
                String email = resultSet.getString("email");
                String nacionalidad = resultSet.getString("nacionalidad");
                String dob = resultSet.getString("dob");
                String calle = resultSet.getString("calle");
                String cp = resultSet.getString("cp");
                String municipio = resultSet.getString("municipio");
                String provincia = resultSet.getString("provincia");





                Cliente cliente = new Cliente(nombre, apellidos, telefono,usuario,contrasenya,dni,email,nacionalidad,dob,calle,cp,municipio,provincia);
                clientes.add(cliente);

            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            throw new RuntimeException(e);
        }


        return clientes;
    }

    public static Cuenta Devolvercuenta( int paramID) {

        try (Connection con =  DriverManager.getConnection(ruta,usuario,contrasenya)) {

            String sentenciaLeer = "SELECT * FROM accounts WHERE clientid = ?";

            PreparedStatement insercion = con.prepareStatement(sentenciaLeer);

            insercion.setInt(1, paramID);
//hollaaa
            ResultSet resultados = insercion.executeQuery();

            try (ResultSet resultSet = insercion.executeQuery()) {
                while (resultSet.next()) {

                    String iban = resultSet.getString("iban");
                    String balance = resultSet.getString("balance");
                    String clientid = resultSet.getString("clienteid");



                    return new Cuenta(iban, balance, clientid);
                }
                resultados.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            throw new RuntimeException(e);
        }


        return null;
    }

    public static Cliente DevolverCliente(int paramID) {

        try (Connection con =  DriverManager.getConnection(ruta,usuario,contrasenya)) {

            String sentenciaLeer = "SELECT * FROM clientes WHERE clientid = ?";

            PreparedStatement insercion = con.prepareStatement(sentenciaLeer);

            insercion.setInt(1, paramID);
//hollaaa
            ResultSet resultados = insercion.executeQuery();

            try (ResultSet resultSet = insercion.executeQuery()) {

                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String telefono = resultSet.getString("telefono");
                String usuario = resultSet.getString("usuario");
                String contrasenya = resultSet.getString("contrasenya");
                String dni = resultSet.getString("dni");
                String email = resultSet.getString("email");
                String nacionalidad = resultSet.getString("nacionalidad");
                String dob = resultSet.getString("dob");
                String calle = resultSet.getString("calle");
                String cp = resultSet.getString("cp");
                String municipio = resultSet.getString("municipio");
                String provincia = resultSet.getString("provincia");




                return new Cliente(nombre, apellidos, telefono,usuario,contrasenya,dni,email,nacionalidad,dob,calle,cp,municipio,provincia);

            }


        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            throw new RuntimeException(e);
        }


    }

}


