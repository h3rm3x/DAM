public abstract class InstrumentosMusicales implements Sonidos {
    private String nombre;
    private String tipo;
    private String marca;
    private String modelo;

    public InstrumentosMusicales(String nombre, String tipo, String marca, String modelo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String emitirSonido() {
        return "Sonido de instrumento musical";
    }

}
