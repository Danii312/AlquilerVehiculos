package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;

public class Vista {

    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        if (controlador == null) {
            throw new NullPointerException("ERROR: El controlador no puede ser nulo.");
        }
        this.controlador = controlador;
    }

    public void comenzar() throws Exception {
        Opcion opcion = null;
        do {
            while (opcion == null) {
                Consola.mostrarMenu();
                try {
                    opcion = Consola.elegirOpcion();
                } catch (OperationNotSupportedException e) {
                    e.getMessage();
                }
                if (opcion != null) {
                    switch (opcion) {
                        case INSERTAR_CLIENTE:
                            insertarCliente();
                            opcion = null;
                            break;
                        case INSERTAR_TURISMO:
                            insertarTurismo();
                            opcion = null;
                            break;

                        case INSERTAR_ALQUILER:
                            insertarAlquiler();
                            opcion = null;
                            break;

                        case BUSCAR_CLIENTE:
                            buscarCliente();
                            opcion = null;
                            break;

                        case BUSCAR_TURISMO:
                            buscarTurismo();
                            opcion = null;
                            break;

                        case BUSCAR_ALQUILER:
                            buscarAlquiler();
                            opcion = null;
                            break;

                        case MODIFICAR_CLIENTE:
                            modificarCliente();
                            opcion = null;
                            break;

                        case DEVOLVER_ALQUILER:
                            devolverAlquiler();
                            opcion = null;
                            break;

                        case BORRAR_CLIENTE:
                            borrarCliente();
                            opcion = null;
                            break;

                        case BORRAR_TURISMO:
                            borrarTurismo();
                            opcion = null;
                            break;

                        case BORRAR_ALQUILER:
                            borrarAlquiler();
                            opcion = null;
                            break;
                        case LISTAR_CLIENTES:
                            listarCliente();
                            opcion = null;
                            break;
                        case LISTAR_TURISMOS:
                            listarTurismo();
                            opcion = null;
                            break;
                        case LISTAR_ALQUILERES:
                            listarAlquiler();
                            opcion = null;
                            break;
                        case LISTAR_ALQUILERES_CLIENTES:
                            listarAlquileresCliente();
                            opcion = null;
                            break;
                        case LISTAR_ALQUILERES_TURISMO:
                            listarAlquileresTurismo();
                            opcion = null;
                            break;

                        default:
                            opcion = Opcion.SALIR;
                    }
                }
            }
        } while (opcion != Opcion.SALIR);
        terminar();

    }

    public void terminar() {
        System.out.println("Fin de la ejecución");
    }

    private void insertarCliente() {
        Consola.mostrarCabecera("Insertar cliente");
        Cliente cliente = Consola.leerCliente();
        try {
            controlador.insertar(cliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void insertarTurismo() {
        Consola.mostrarCabecera("Insertar turismo");
        Turismo turismo = Consola.leerTurismo();
        try {
            controlador.insertar(turismo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void insertarAlquiler() throws Exception {
        Consola.mostrarCabecera("Insertar alquiler");
        Alquiler alquiler = Consola.leerAlquiler();
        try {
            controlador.insertar(alquiler);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void buscarCliente() {
        Consola.mostrarCabecera("Buscar cliente");
        Cliente cliente = Consola.leerClienteDni();
        try {
            cliente = controlador.buscar(cliente);
            System.out.println(cliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void buscarTurismo() throws Exception {
        Consola.mostrarCabecera("Buscar turismo");
        Turismo turismo = Consola.leerTurismoMatricula();
        try {
            turismo = controlador.buscar(turismo);
            System.out.println(turismo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void buscarAlquiler() throws Exception {
        Consola.mostrarCabecera("Buscar alquiler");
        Alquiler alquiler = Consola.leerAlquiler();
        try {
            alquiler = controlador.buscar(alquiler);
            System.out.println(alquiler);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void modificarCliente() {
        Consola.mostrarCabecera("Modificar cliente");
        Cliente cliente = Consola.leerClienteDni();
        String nombre = Consola.leerNombre();
        String telefono = Consola.leerTelefono();
        try {
            controlador.modificar(cliente, nombre, telefono);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void devolverAlquiler() throws Exception {
        Consola.mostrarCabecera("Devolver alquiler");
        Alquiler alquiler = Consola.leerAlquiler();
        LocalDate fechaDevolucion = Consola.leerFechaDevolucion();
        try {
            controlador.devolver(alquiler, fechaDevolucion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void borrarCliente() {
        Consola.mostrarCabecera("Borrar cliente");
        Cliente cliente = Consola.leerClienteDni();
        try {
            controlador.borrar(cliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void borrarTurismo() throws Exception {
        Consola.mostrarCabecera("Borrar turismo");
        Turismo turismo = Consola.leerTurismoMatricula();
        try {
            controlador.borrar(turismo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void borrarAlquiler() throws Exception {
        Consola.mostrarCabecera("Borrar alquiler");
        Alquiler alquiler = Consola.leerAlquiler();
        try {
            controlador.borrar(alquiler);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void listarCliente() {
        Consola.mostrarCabecera("Listar clientes");
        try {
            System.out.println(controlador.getClientes());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void listarTurismo() {
        Consola.mostrarCabecera("Listar todos los turismos");
        try {
            System.out.println(controlador.getTurismos());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void listarAlquiler() {
        Consola.mostrarCabecera("Listar alquileres");
        try {
            System.out.println(controlador.getAlquileres());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void listarAlquileresCliente() {
        Consola.mostrarCabecera("Listar alquileres de un cliente");
        Cliente cliente = Consola.leerClienteDni();
        try {
            System.out.println(controlador.getAlquileres(cliente));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void listarAlquileresTurismo() throws Exception {
        Consola.mostrarCabecera("Listar alquileres de un turismo");
        Turismo turismo = Consola.leerTurismoMatricula();
        try {
            System.out.println(controlador.getAlquileres(turismo));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
