package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Consola {

    protected static final String PATRON_FECHA = "dd/MM/yyyy";
    protected static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);

    // CONSTRUCTOR
    private Consola() {

    }

    // MÉTODO mostrarCabecera
    public static void mostrarCabecera(String mensaje) {
        System.out.printf("%n%s%n", mensaje);
        String Str = "%0" + mensaje.length() + "d%n";
        System.out.println(String.format(Str, 0).replace("0", "-"));
    }

    // MÉTODO mostrarMenu
    public static void mostrarMenu() {
        mostrarCabecera("|Menú - Alquiler de vehículos|");
        System.out.println("");
        for (Opcion opcion : Opcion.values()) {
            System.out.println(opcion);
        }
    }

    // MÉTODO leerCadena
    private static String leerCadena(String mensaje) {
        System.out.println(mensaje);
        String cadena = Entrada.cadena();
        return cadena;
    }

    // MÉTODO leerEntero
    private static Integer leerEntero(String mensaje) {
        System.out.println(mensaje);
        Integer entero = Entrada.entero();
        return entero;
    }

    // MÉTODO leerFecha
    private static LocalDate leerFecha(String mensaje) {
        System.out.println(mensaje);
        LocalDate fecha = LocalDate.parse(Entrada.cadena(), FORMATO_FECHA);
        return fecha;
    }

    // MÉTODO elegirOpcion
    public static Opcion elegirOpcion() throws OperationNotSupportedException {
        try {
            Opcion opcion = null;
            while (opcion == null) {
                int ordinal = leerEntero("Introduce una opción");
                opcion = Opcion.values()[ordinal];
            }
            return opcion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // MÉTODO leerCliente
    public static Cliente leerCliente() {
        Cliente cliente = null;
        String nombre = leerNombre();
        String dni = leerCadena("Introduce el DNI: ");
        String telefono = leerTelefono();
        try {
            cliente = new Cliente(nombre, dni, telefono);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }

    // MÉTODO leerClienteDni
    public static Cliente leerClienteDni() {
        String dni = leerCadena("Introduce DNI del cliente: ");
        return Cliente.getClienteConDni(dni);
    }

    // MÉTODO leerNombre
    public static String leerNombre() {
        String nombre = leerCadena("Introduce el nombre: ");
        return nombre;
    }

    // MÉTODO leerTelefono
    public static String leerTelefono() {
        String telefono = leerCadena("Introduce el teléfono: ");
        return telefono;
    }

    // MÉTODO leerTurismo
    public static Turismo leerTurismo() {
        Turismo turismo = null;
        String marca = leerCadena("Introduce marca: ");
        String modelo = leerCadena("Introduce modelo: ");
        int cilindrada = leerEntero("Introduce número cilindrada: ");
        String matricula = leerCadena("Introduce matrícula - Formato (1111AAA)");
        try {
            turismo = new Turismo(marca, modelo, cilindrada, matricula);
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return turismo;
    }

    // MÉTODO leerTurismoMatricula
    public static Turismo leerTurismoMatricula() throws Exception {
        String matricula = leerCadena("Introduce matrícula - Formato (1111AAA)");
        return Turismo.getTurismoConMatricula(matricula);
    }

    // MÉTODO leerAlquiler
    public static Alquiler leerAlquiler() throws Exception {
        Cliente cliente = leerClienteDni();
        Turismo turismo = leerTurismoMatricula();
        Alquiler alquiler = null;
        LocalDate fechaDate = leerFecha("Introduce fecha de alquiler - Formato (dd/mm/aaaa)");
        try {
            alquiler = new Alquiler(cliente, turismo, fechaDate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return alquiler;
    }

    // MÉTODO leerFechaDevolucion
    public static LocalDate leerFechaDevolucion() {
        LocalDate fechaDevolucion = leerFecha("Introduce fecha de devolución - Formato (dd/mm/aaaa)");
        return fechaDevolucion;
    }

}
