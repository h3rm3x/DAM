public interface enReparacion {
    final int precio_hora = 50;

    static int reparar(int horas) {
        return horas * precio_hora;
    }


}
