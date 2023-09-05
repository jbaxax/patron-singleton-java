/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.test;

import com.utp.daos.ClienteDAO;
import com.utp.entities.Cliente;
import java.util.List;

/**
 *
 * @author Walter
 */
public class TestClient {

    public static void main(String[] args) {

        
//         //<INSERT>
//        Cliente cliente = new Cliente.Builder()
//                .nombre("Luis")
//                .apellido("Ramirez")
//                .correo("luisramirez@gmail.com")
//                .celular("984985154")
//                .build();
////        System.out.println(""+cliente);
//        
//        ClienteDAO clienteDAO = new ClienteDAO();
//        
//        if(clienteDAO.insert(cliente)){
//            System.out.println("se creo el cliente");
//        }else{
//            System.out.println("No se creo el cliente");
//        }
//        //</INSERT>
        
        //<DELETE>
//        int clienteIdToDelete = 1; // Reemplaza con el ID correcto
//
//        // Eliminar un cliente por ID
//        clienteDAO.delete(clienteIdToDelete);
//        System.out.println("Cliente con ID " + clienteIdToDelete + " eliminado");
        //</DELETE>
        
        
        //<SELECTALL>
        // Obtener todos los clientes de la base de datos y mostrarlos
//        System.out.println("Listado de todos los clientes:");
//        clienteDAO.selectAll().forEach(System.out::println);
        //<SELECTALL>

        
        //<SELECtBYID>
//       int clienteIdToFind = 4; // Reemplaza con el ID correcto
//
//        // Buscar un cliente por su ID
//        Cliente clienteEncontrado = clienteDAO.selectById(clienteIdToFind);
//
//        if (clienteEncontrado != null) {
//            System.out.println("Cliente encontrado por ID:");
//            System.out.println(clienteEncontrado);
//        } else {
//            System.out.println("No se encontró ningún cliente con ID " + clienteIdToFind);
//        }
        //</SELECtBYID>


//        //<UPDATE>
//        ClienteDAO clienteDAO = new ClienteDAO();
//
//        int clienteIdToUpdate = 6; // Reemplaza con el ID correcto
//
//        // Buscar el cliente por su ID
//        Cliente clienteExistente = clienteDAO.selectById(clienteIdToUpdate);
//
//        if (clienteExistente != null) {
//            // Actualizar los datos del cliente
//            clienteExistente.setNombre("hola");
//            clienteExistente.setApellido("123");
//            clienteExistente.setCorreo("aea@correo.com");
//            clienteExistente.setCelular("98765896");
//
//            // Llamar al método de actualización
//            boolean actualizacionExitosa = clienteDAO.update(clienteExistente);
//
//            if (actualizacionExitosa) {
//                System.out.println("Cliente actualizado con éxito:");
//                System.out.println(clienteExistente);
//            } else {
//                System.out.println("No se pudo actualizar el cliente.");
//            }
//        } else {
//            System.out.println("No se encontró ningún cliente con ID " + clienteIdToUpdate);
//        }
//         //</UPDATE>


     ClienteDAO clienteDAO = new ClienteDAO();

        // Supongamos que tienes el apellido que deseas buscar
        String apellidoToFind = "zorra"; // Reemplaza con el apellido correcto

        // Buscar clientes por apellido
        List<Cliente> clientesEncontrados = clienteDAO.findByApellido(apellidoToFind);

        if (!clientesEncontrados.isEmpty()) {
            System.out.println("Clientes encontrados por apellido:");
            for (Cliente cliente : clientesEncontrados) {
                System.out.println(cliente);
            }
        } else {
            System.out.println("No se encontraron clientes con el apellido " + apellidoToFind);
        }
    }
}
