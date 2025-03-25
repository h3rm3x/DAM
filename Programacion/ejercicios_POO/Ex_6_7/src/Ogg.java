public class Ogg extends Musica {

    public Ogg(double duracion) {
        super(duracion);

    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo ogg");
    }
}
