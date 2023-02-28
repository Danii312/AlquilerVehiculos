package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class Turismos {

    private List<Turismo> coleccionTurismos;

    // CONSTRUCTOR
    public Turismos() {
        coleccionTurismos = new ArrayList<>();
    }

    // MÉTODO get
    public List<Turismo> get() {
        ArrayList<Turismo> copiaTurismos = new ArrayList<>(coleccionTurismos);
        return copiaTurismos;
    }

    // MÉTODO getCantidad
    public int getCantidad() {
        return coleccionTurismos.size();
    }

    // MÉTODO insertar
    public void insertar(Turismo turismo) throws OperationNotSupportedException {
        if (turismo == null) {
            throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
        }
        if ((coleccionTurismos.contains(turismo))) {
            throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
        }
        coleccionTurismos.add(turismo);
    }

    // MÉTODO buscar
    public Turismo buscar(Turismo turismo) {
        Turismo turismo2 = null;
        if (turismo == null) {
            throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
        }
        if (coleccionTurismos.contains(turismo)) {
            turismo2 = (coleccionTurismos.get(coleccionTurismos.indexOf(turismo)));
        }
        return turismo2;
    }

    // MÉTODO borrar
    public void borrar(Turismo turismo) throws OperationNotSupportedException {
        if (turismo == null) {
            throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
        }
        if (coleccionTurismos.contains(turismo)) {
            coleccionTurismos.remove(turismo);
        } else {
            throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
        }
    }

}
