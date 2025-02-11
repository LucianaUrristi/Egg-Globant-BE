package entidades;

import java.time.LocalDate;

public class Estancia {
    private int idEstancia;
    private Cliente cliente; // Relación con Cliente
    private Casa casa; // Relación con Casa
    private LocalDate fechaLlegada;
    private LocalDate fechaSalida;
    private int cantidadHabitaciones;


    public Estancia(int idEstancia, Cliente cliente, Casa casa, LocalDate fechaLlegada, LocalDate fechaSalida, int cantidadHabitaciones) {
        this.idEstancia = idEstancia;
        this.cliente = cliente;
        this.casa = casa;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public Estancia() {
        }
        
    
    public int getIdEstancia() {
        return idEstancia;
    }

    public void setIdEstancia(int idEstancia) {
        this.idEstancia = idEstancia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(int cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }
}
