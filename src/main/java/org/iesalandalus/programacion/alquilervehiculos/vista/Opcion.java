package org.iesalandalus.programacion.alquilervehiculos.vista;

import javax.naming.OperationNotSupportedException;

public enum Opcion {

    SALIR("Salir"),
    INSERTAR_CLIENTE("Insertar cliente"),
    INSERTAR_TURISMO("Insertar turismo"),
    INSERTAR_ALQUILER("Insertar alquiler"),
    BUSCAR_CLIENTE("Buscar cliente"),
    BUSCAR_TURISMO("Buscar turismo"),
    BUSCAR_ALQUILER("Buscar alquiler"),
    MODIFICAR_CLIENTE("Modificar cliente"),
    DEVOLVER_ALQUILER("Devolver alquiler"),
    BORRAR_CLIENTE("Borrar cliente"),
    BORRAR_TURISMO("Borrar turismo"),
    BORRAR_ALQUILER("Borrar alquiler"),
    LISTAR_CLIENTES("Listar clientes"),
    LISTAR_TURISMOS("Listar turismos"),
    LISTAR_ALQUILERES("Listar alquileres"),
    LISTAR_ALQUILERES_CLIENTES("Listar alquileres de clientes"),
    LISTAR_ALQUILERES_TURISMO("Listar alquileres de turismos");

    private String cadenaAMostrar;

    Opcion(String cadenaAmostrar) {
        this.cadenaAMostrar = cadenaAmostrar;
    }

    private boolean esOrdinalValido(int ordinal) {
        return (ordinal >= 0 && ordinal < Opcion.values().length - 1);
    }

    public Opcion get(int ordinal) throws OperationNotSupportedException {
        if (esOrdinalValido(ordinal)) {
            return Opcion.values()[ordinal];
        } else {
            throw new OperationNotSupportedException("ERROR: Ordinal de la opción no válido.");
        }
    }

    @Override
    public String toString() {
        return String.format("%d.-%s", ordinal(), cadenaAMostrar);
    }

}
