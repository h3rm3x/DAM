public class Cuenta_bancaria {
    private double saldo;
    private String nombre_titular;
    private String DNI_titular;
    private int numero_cuenta;
    public Cuenta_bancaria() {}
    public Cuenta_bancaria(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }
    public Cuenta_bancaria(int numero_cuenta, String nombre_titular, String DNI_titular) {
        this.numero_cuenta = numero_cuenta;
        this.nombre_titular = nombre_titular;
        this.DNI_titular = DNI_titular;
    }
    public Cuenta_bancaria(String DNI_titular, String nombre_titular){
        this.DNI_titular = DNI_titular;
        this.nombre_titular = nombre_titular;
    }
    public Cuenta_bancaria(int numero_cuenta, double saldo, String nombre_titular, String DNI_titular){
        this.DNI_titular = DNI_titular;
        this.nombre_titular = nombre_titular;
        this.saldo = saldo;
        this.numero_cuenta = numero_cuenta;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    public void setNombre_titular(String nombre_titular){
        this.nombre_titular = nombre_titular;
    }
    public void setDNI_titular(String DNI_titular){
        this.DNI_titular = DNI_titular;
    }
    public double getSaldo(){
        return saldo;
    }
    public int getNumero_cuenta(){
        return numero_cuenta;
    }
    public String getNombre_titular(){
        return nombre_titular;
    }
    public String getDNI_titular(){
        return DNI_titular;
    }

    public void depositar(double valor){
        System.out.println(valor +"€ depositados correctamente.");
        System.out.println("Saldo anterior: " + saldo);
        this.saldo += valor;
        System.out.println("Saldo tras la operacion: " + saldo);
    }
    public void retirar(double valor){
        System.out.println(valor +"€ retirados correctamente.");
        System.out.println("Saldo anterior: " + saldo);
        this.saldo -= valor;
        System.out.println("Saldo tras la operacion: " + saldo);
    }
    public void verSaldo(){
        System.out.println("El saldo actual de la cuenta de "+ this.nombre_titular + " con DNI "+ this.DNI_titular+ "/n" + "es: "+ this.saldo);
    }

}
