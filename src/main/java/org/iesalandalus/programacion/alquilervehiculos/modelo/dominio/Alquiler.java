package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Alquiler {

    protected static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final int PRECIO_DIA = 20;

    private Cliente cliente;
    private Turismo turismo;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;

    // CONSTRUCTORES
    public Alquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) {
        setCliente(cliente);
        setTurismo(turismo);
        setFechaAlquiler(fechaAlquiler);
    }

    public Alquiler(Alquiler alquiler) {
        if (alquiler == null) {
            throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo.");
        }
        setCliente(new Cliente(alquiler.getCliente()));
        setTurismo(new Turismo(alquiler.getTurismo()));
        setFechaAlquiler(alquiler.getFechaAlquiler());
        setFechaDevolucion(alquiler.getFechaDevolucion());
    }

    // GETTERS
    public Cliente getCliente() {
        return cliente;
    }

    public Turismo getTurismo() {
        return turismo;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    // SETTERS

    public void setCliente(Cliente cliente) {
        if (cliente == null) {
            throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
        }
        this.cliente = cliente;
    }

    public void setTurismo(Turismo turismo) {
        if (turismo == null) {
            throw new NullPointerException("ERROR: El turismo no puede ser nulo.");
        }
        this.turismo = turismo;
    }

    public void setFechaAlquiler(LocalDate fechaAlquiler) {
        if (fechaAlquiler == null) {
            throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
        }
        if (fechaAlquiler.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("ERROR: La fecha de alquiler no puede ser futura.");
        }
        if (fechaAlquiler.isBefore(LocalDate.now()) || fechaAlquiler.isEqual(LocalDate.now())) {
            this.fechaAlquiler = fechaAlquiler;
        }
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        if (fechaDevolucion == null) {
            throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
        }
        if (fechaDevolucion.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser futura.");
        }
        if (fechaDevolucion.isBefore(this.fechaAlquiler) || fechaDevolucion == fechaAlquiler) {
            throw new IllegalArgumentException("ERROR: La fecha de devolución debe ser posterior a la fecha de alquiler.");
        }
        this.fechaDevolucion = fechaDevolucion;
    }

    // MÉTODO devolver
    public void devolver(LocalDate fechaDevolucion) throws OperationNotSupportedException {
        if (fechaDevolucion == null) {
            throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
        }
        if (this.fechaDevolucion != null) {
            throw new OperationNotSupportedException("ERROR: La devolución ya estaba registrada.");
        }
        setFechaDevolucion(fechaDevolucion);
    }

    // MÉTODO getPrecio
    public int getPrecio() {
        if (fechaDevolucion == null) {
            return 0;
        }
        int factorCilindrada = turismo.getCilindrada() / 10;
        int numDias = (int) ChronoUnit.DAYS.between(fechaAlquiler, fechaDevolucion);
        return (PRECIO_DIA + factorCilindrada) * numDias;
    }

    // MÉTODO hashCode & equals
    @Override
    public int hashCode() {
        return Objects.hash(getCliente(), getTurismo(), getFechaAlquiler(), getFechaDevolucion());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alquiler alquiler)) return false;
        return Objects.equals(getCliente(), alquiler.getCliente()) && Objects.equals(getTurismo(), alquiler.getTurismo()) && Objects.equals(getFechaAlquiler(), alquiler.getFechaAlquiler()) && Objects.equals(getFechaDevolucion(), alquiler.getFechaDevolucion());
    }

    // MÉTODO toString
    @Override
    public String toString() {
        return String.format("%s <---> %s, %s - %s (" + getPrecio() + "€)",
                getCliente(), getTurismo(), getFechaAlquiler().format(FORMATO_FECHA),
                (getFechaDevolucion() == null) ? "Aún no devuelto" : fechaDevolucion.format(FORMATO_FECHA),
                (getFechaDevolucion() == null) ? LocalDate.now().format(FORMATO_FECHA) : "",
                getPrecio());
    }

}
