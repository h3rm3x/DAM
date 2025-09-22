public class InstruentosPercusion extends InstrumentosMusicales {
    public InstruentosPercusion(String nombre, String tipo, String marca, String modelo) {
        super(nombre, tipo, marca, modelo);
    }

    public String emitirSonido() {
        return "Sonido de instrumento de percusión";
    }
}
