package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class Clientes {

    private List<Cliente> coleccionClientes;

    // CONSTRUCTOR
    public Clientes() {
        coleccionClientes = new ArrayList<>();
    }

    // MÉTODO get
    public List<Cliente> get() {
        ArrayList<Cliente> copiaClientes = new ArrayList<>(coleccionClientes);
        return copiaClientes;
    }

    // MÉTODO getCantidad
    public int getCantidad() {
        return coleccionClientes.size();
    }

    // MÉTODO insertar
    public void insertar(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
        }
        if (coleccionClientes.indexOf(cliente) != -1) {
            throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
        }
        coleccionClientes.add(cliente);
    }

    // MÉTODO buscar
    public Cliente buscar(Cliente cliente) {
        if (cliente == null) {
            throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
        }
        if (coleccionClientes.indexOf(cliente) != -1) {
            return (coleccionClientes.get(coleccionClientes.indexOf(cliente)));
        }
        return null;
    }

    // MÉTODO borrar
    public void borrar(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
        }
        if (coleccionClientes.indexOf(cliente) != -1) {
            coleccionClientes.remove(coleccionClientes.indexOf(cliente));
        } else {
            throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
        }
    }

    // MÉTODO modificar
    public void modificar(Cliente cliente, String nombre, String telefono) throws Exception {
        if (cliente == null) {
            throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
        }
        if (nombre != null && !nombre.trim().isEmpty()) {
            cliente.setNombre(nombre);
        }
        if (telefono != null && !telefono.trim().isEmpty()) {
            cliente.setTelefono(telefono);
        }
        if (!coleccionClientes.contains(cliente)) {
            throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
        }

    }

}


