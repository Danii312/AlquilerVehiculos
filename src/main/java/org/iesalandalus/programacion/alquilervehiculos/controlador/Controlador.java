package org.iesalandalus.programacion.alquilervehiculos.controlador;

import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

import java.time.LocalDate;
import java.util.List;

public class Controlador {

    private Modelo modelo;
    private Vista vista;

    // CONSTRUCTOR
    public Controlador(Modelo modelo, Vista vista) {
        if (modelo == null) {
            throw new IllegalArgumentException("ERROR: El modelo no puede ser nulo.");
        }
        if (vista == null) {
            throw new IllegalArgumentException("ERROR: La vista no puede ser nula.");
        }
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControlador(this);
    }

    // MÉTODO comenzar
    public void comenzar() throws Exception {
        modelo.comenzar();
        vista.comenzar();
    }

    // MÉTODO terminar
    public void terminar() {
        vista.terminar();
    }

    // MÉTODOS insertar
    public void insertar(Cliente cliente) throws Exception {
        modelo.insertar(cliente);
    }

    public void insertar(Turismo turismo) throws Exception {
        modelo.insertar(turismo);
    }

    public void insertar(Alquiler alquiler) throws Exception {
        modelo.insertar(alquiler);
    }

    // MÉTODOS buscar
    public Cliente buscar(Cliente cliente) throws Exception {
        return modelo.buscar(cliente);
    }

    public Turismo buscar(Turismo turismo) throws Exception {
        return modelo.buscar(turismo);
    }

    public Alquiler buscar(Alquiler alquiler) throws Exception {
        return modelo.buscar(alquiler);
    }

    // MÉTODO modificar
    public void modificar(Cliente cliente, String nombre, String telefono) throws Exception {
        modelo.modificar(cliente, nombre, telefono);
    }

    // MÉTODO devolver
    public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws Exception {
        modelo.devolver(alquiler, fechaDevolucion);
    }

    // MÉTODOS borrar
    public void borrar(Cliente cliente) throws Exception {
        modelo.borrar(cliente);
    }

    public void borrar(Turismo turismo) throws Exception {
        modelo.borrar(turismo);
    }

    public void borrar(Alquiler alquiler) throws Exception {
        modelo.borrar(alquiler);
    }

    // MÉTODOS get
    public List<Cliente> getClientes() {
        return modelo.getClientes();
    }

    public List<Turismo> getTurismos() {
        return modelo.getTurismos();
    }

    public List<Alquiler> getAlquileres() {
        return modelo.getAlquileres();
    }

    public List<Alquiler> getAlquileres(Cliente cliente) {
        return modelo.getAlquileres(cliente);
    }

    public List<Alquiler> getAlquileres(Turismo turismo) {
        return modelo.getAlquileres(turismo);
    }

}
