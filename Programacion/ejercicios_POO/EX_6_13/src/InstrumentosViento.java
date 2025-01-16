public class InstrumentosViento extends InstrumentosMusicales {

    public InstrumentosViento(String nombre, String tipo, String marca, String modelo) {
        super(nombre, tipo, marca, modelo);
    }

    public String emitirSonido() {
        return "Sonido de instrumento de viento";
    }
}
