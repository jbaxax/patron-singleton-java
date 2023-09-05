
package com.utp.interfaces;

import com.utp.entities.Cliente;
import java.util.List;


public interface ICliente extends ICRUD<Cliente>    {
    
    Cliente findbyDNI(String dni);
    List<Cliente> findByApellido(String apellido);
    
    
}
