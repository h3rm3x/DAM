package modelo;

import java.time.LocalDate;

public class Reserva {
    private int id;
    private String libroISBN;
    private String clienteNIE;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean devueltoTarde;
    private LocalDate fechaRealFin;
    private LocalDate fechaRealInicio;
    private String estado;
    
    // Constructor
    public Reserva(int id, String libroISBN, String clienteNIE, LocalDate fechaInicio, 
                  LocalDate fechaFin, boolean devueltoTarde, LocalDate fechaRealFin, 
                  LocalDate fechaRealInicio, String estado) {
        this.id = id;
        this.libroISBN = libroISBN;
        this.clienteNIE = clienteNIE;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.devueltoTarde = devueltoTarde;
        this.fechaRealFin = fechaRealFin;
        this.fechaRealInicio = fechaRealInicio;
        this.estado = estado;
    }
    
    // Getters y setters completos
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getLibroISBN() {
        return libroISBN;
    }
    
    public void setLibroISBN(String libroISBN) {
        this.libroISBN = libroISBN;
    }
    
    public String getClienteNIE() {
        return clienteNIE;
    }
    
    public void setClienteNIE(String clienteNIE) {
        this.clienteNIE = clienteNIE;
    }
    
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public LocalDate getFechaFin() {
        return fechaFin;
    }
    
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    public boolean isDevueltoTarde() {
        return devueltoTarde;
    }
    
    public void setDevueltoTarde(boolean devueltoTarde) {
        this.devueltoTarde = devueltoTarde;
    }
    
    public LocalDate getFechaRealFin() {
        return fechaRealFin;
    }
    
    public void setFechaRealFin(LocalDate fechaRealFin) {
        this.fechaRealFin = fechaRealFin;
    }
    
    public LocalDate getFechaRealInicio() {
        return fechaRealInicio;
    }
    
    public void setFechaRealInicio(LocalDate fechaRealInicio) {
        this.fechaRealInicio = fechaRealInicio;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", libroISBN='" + libroISBN + '\'' +
                ", clienteNIE='" + clienteNIE + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", devueltoTarde=" + (devueltoTarde ? 'S' : 'N') +
                ", fechaRealFin=" + fechaRealFin +
                ", fechaRealInicio=" + fechaRealInicio +
                ", estado='" + estado + '\'' +
                '}';
    }
}