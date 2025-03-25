public class Mp3 extends Musica {


    public Mp3(double duracion) {
        super(duracion);
    }

    @Override
    public void reproducir() {
        System.out.println("Mp3 reproducir");
    }

}
