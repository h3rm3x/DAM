package modelo;

import java.time.LocalDate;

public class Cliente {
    private String NIE;
    private String nombre;
    private String apellido;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String email;
    private boolean redFlag;
    
    // Constructor, getters y setters
    public Cliente(String NIE, String nombre, String apellido, String telefono, 
                  LocalDate fechaNacimiento, String email, boolean redFlag) {
        this.NIE = NIE;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.redFlag = redFlag;
    }
    
    // Getters y setters para todos los campos
    public String getNIE() {
        return NIE;
    }
    public void setNIE(String NIE) {
        this.NIE = NIE;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isRedFlag() {
        return redFlag;
    }
    public void setRedFlag(boolean redFlag) {
        this.redFlag = redFlag;
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "NIE='" + NIE + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", email='" + email + '\'' +
                "," + (redFlag ? "Red Flag: sí" : "Red Flag: no")+
                '}';
    }
}