package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Alquileres {

    private List<Alquiler> coleccionAlquileres;

    // CONSTRUCTOR
    public Alquileres() {
        coleccionAlquileres = new ArrayList<>();
    }

    // MÉTODO get
    public List<Alquiler> get() {
        ArrayList<Alquiler> copiaAlquileres = new ArrayList<>(coleccionAlquileres);
        return copiaAlquileres;
    }

    // MÉTODO get cliente
    public List<Alquiler> get(Cliente cliente) {
        if (cliente == null) {
            throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
        }
        List<Alquiler> coleccionCliente = new ArrayList<>();
        for (Alquiler alquiler : coleccionAlquileres) {
            if (alquiler.getCliente().equals(cliente)) {
                coleccionCliente.add(alquiler);
            }
        }
        return coleccionCliente;
    }

    // MÉTODO get turismo
    public List<Alquiler> get(Turismo turismo) {
        if (turismo == null) {
            throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
        }
        List<Alquiler> coleccionTurismo = new ArrayList<>();
        for (Alquiler alquiler : coleccionAlquileres) {
            if (alquiler.getTurismo().equals(turismo)) {
                coleccionTurismo.add(alquiler);
            }
        }
        return coleccionTurismo;
    }

    // MÉTODO getCantidad
    public int getCantidad() {
        return coleccionAlquileres.size();
    }

    // MÉTODO insertar
    public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
        if (alquiler == null) {
            throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
        }
        if (comprobarAlquiler(alquiler.getCliente(), alquiler.getTurismo(), alquiler.getFechaAlquiler())) {
            coleccionAlquileres.add(new Alquiler(alquiler));
        }
    }

    // MÉTODO comprobarAlquiler
    private boolean comprobarAlquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) throws OperationNotSupportedException {
        boolean estadoAlquiler = true;
        for (Alquiler alquiler2 : coleccionAlquileres) {
            if ((cliente.equals(alquiler2.getCliente())) && (alquiler2.getFechaDevolucion() == null)) {
                estadoAlquiler = false;
                throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");
            }
            if ((turismo.equals(alquiler2.getTurismo())) && (alquiler2.getFechaDevolucion() == null)) {
                estadoAlquiler = false;
                throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
            }
            if (cliente.equals(alquiler2.getCliente()) && (alquiler2.getFechaDevolucion().isAfter(fechaAlquiler))) {
                estadoAlquiler = false;
                throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
            }
            if (turismo.equals(alquiler2.getTurismo()) && alquiler2.getFechaDevolucion().isAfter(fechaAlquiler)) {
                estadoAlquiler = false;
                throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");
            }
        }
        return estadoAlquiler;
    }

    // MÉTODO devolver
    public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException  {
        boolean estadoAlquiler = false;
        if (alquiler == null || fechaDevolucion == null) {
            throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
        }
        for (Alquiler alquiler2 : coleccionAlquileres) {
            if (alquiler2.equals(alquiler)) {
                alquiler2.devolver(fechaDevolucion);
            }
            estadoAlquiler = true;
        }
        if (estadoAlquiler == false) {
            throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
        }
    }

    // MÉTODO borrar
    public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
        if (alquiler == null) {
            throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
        }
        if (coleccionAlquileres.contains(alquiler)) {
            coleccionAlquileres.remove(alquiler);
        } else {
            throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
        }
    }

    // MÉTODO buscar
    public Alquiler buscar(Alquiler alquiler) {
        if (alquiler == null) {
            throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
        }
        if (coleccionAlquileres.contains(alquiler)) {
            Alquiler alquiler2 = coleccionAlquileres.get(coleccionAlquileres.indexOf(alquiler));
            return alquiler2;
        } else {
            return null;
        }
    }

}
