
package com.utp.daos;

import com.utp.connectionBD.ConnectionDB;
import com.utp.entities.Cliente;
import com.utp.interfaces.ICliente;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ClienteDAO implements ICliente {

    private static PreparedStatement pstm;
    private static ResultSet res;
    private static ConnectionDB con;

    public ClienteDAO() {
        con = ConnectionDB.getInstance();
    }

    @Override
    public Cliente findbyDNI(String dni) {
        Cliente cliente = null;
        final String SQL_SELECT = "SELECT * FROM cliente WHERE id = ?";

        try {
            int id = Integer.parseInt(dni); // Suponemos que 'dni' es el valor del 'id'

            pstm = con.getConnection().prepareStatement(SQL_SELECT);
            pstm.setInt(1, id);

            res = pstm.executeQuery();

            if (res.next()) {
                // Encontramos un cliente con el ID proporcionado
                cliente = new Cliente();
                cliente.setId(res.getInt("id"));
                cliente.setNombre(res.getString("nombre"));
                cliente.setApellido(res.getString("apellido"));
                cliente.setCorreo(res.getString("correo"));
                cliente.setCelular(res.getString("celular"));
            }
        } catch (NumberFormatException e) {
            System.out.println("El valor de 'dni' no es un número válido.");
        } catch (Exception e) {
            System.out.println("Error al buscar cliente por DNI: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }

        return cliente;
    }

    @Override
    public List<Cliente> findByApellido(String apellido) {
        List<Cliente> clientes = new ArrayList<>();
        final String SQL_SELECT = "SELECT * FROM cliente WHERE apellido = ?";

        try {
            pstm = con.getConnection().prepareStatement(SQL_SELECT);
            pstm.setString(1, apellido);

            res = pstm.executeQuery();

            while (res.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(res.getInt("id"));
                cliente.setNombre(res.getString("nombre"));
                cliente.setApellido(res.getString("apellido"));
                cliente.setCorreo(res.getString("correo"));
                cliente.setCelular(res.getString("celular"));

                clientes.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar clientes por apellido: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }

        return clientes;
    }

    @Override
    public Boolean insert(Cliente t) {
        Boolean result = false;
        final String SQL_INSERT = "insert into cliente values(?,?,?,?)";
        try {
            pstm = con.getConnection().prepareStatement(SQL_INSERT);
            pstm.setString(1, t.getNombre());
            pstm.setString(2, t.getApellido());
            pstm.setString(3, t.getCorreo());
            pstm.setString(4, t.getCelular());
            int resultInsert = pstm.executeUpdate();
            if (resultInsert > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error al insertar :" + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }
        return result;
    }

    @Override
    public Boolean update(Cliente t) {

        Boolean result = false;
        final String SQL_UPDATE = "update cliente set nombre=?,apellido=?,correo=?,celular=? where id=?";

        try {

            pstm = con.getConnection().prepareStatement(SQL_UPDATE);

            pstm.setString(1, t.getNombre());
            pstm.setString(2, t.getApellido());
            pstm.setString(3, t.getCorreo());
            pstm.setString(4, t.getCelular());
            pstm.setInt(5, t.getId());

            int resultUpdate = pstm.executeUpdate();

            if (resultUpdate > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error al modificar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }

        return result;

    }

    @Override
    public Cliente selectById(Integer id) {
        Cliente cliente = null;
        final String SQL_SELECT = "SELECT * FROM cliente WHERE id = ?";

        try {
            pstm = con.getConnection().prepareStatement(SQL_SELECT);
            pstm.setInt(1, id);

            res = pstm.executeQuery();

            if (res.next()) {
                // Encontramos un cliente con el ID proporcionado
                cliente = new Cliente();
                cliente.setId(res.getInt("id"));
                cliente.setNombre(res.getString("nombre"));
                cliente.setApellido(res.getString("apellido"));
                cliente.setCorreo(res.getString("correo"));
                cliente.setCelular(res.getString("celular"));
            }
        } catch (Exception e) {
            System.out.println("Error al buscar cliente por ID: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }

        return cliente;
    }

    @Override
    public List<Cliente> selectAll() {
        List<Cliente> clientes = new ArrayList<>();
        final String SQL_SELECT_ALL = "SELECT * FROM cliente";

        try {
            pstm = con.getConnection().prepareStatement(SQL_SELECT_ALL);
            res = pstm.executeQuery();

            while (res.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(res.getInt("id"));
                cliente.setNombre(res.getString("nombre"));
                cliente.setApellido(res.getString("apellido"));
                cliente.setCorreo(res.getString("correo"));
                cliente.setCelular(res.getString("celular"));

                clientes.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener todos los clientes: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }

        return clientes;
    }

    @Override
    public void delete(Integer id) {
        final String SQL_DELETE = "DELETE FROM cliente WHERE id = ?";

        try {
            pstm = con.getConnection().prepareStatement(SQL_DELETE);
            pstm.setInt(1, id);

            int rowsDeleted = pstm.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Cliente con ID " + id + " eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún cliente con ID " + id + ".");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private void close() {
        try {
            if (res != null) {
                res.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexion");
            e.printStackTrace();
        }
    }

}
