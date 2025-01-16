public class equipo {
    private Miembros_equipo[] equipo;
    private int index;
    private String nombre_equipo;
    private int puntos;

    public equipo(String nombre_equipo) {
        equipo = new Miembros_equipo[100];
        index = 0;
        this.nombre_equipo = nombre_equipo;
        puntos = 0;
    }


    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;

    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public void ingresarJugador(String nombre_equipo, String nombre, String apellido, String dni, String fecha_nacimiento, String posicion, int dorsal) {
        equipo[index] = new Jugador(nombre_equipo, nombre, apellido, dni, fecha_nacimiento, posicion, dorsal);
        index++;
    }

    public void ingresarStaff(String nombre_equipo, String nombre, String apellido, String dni, String fecha_nacimiento, String ambito, String rol) {
        equipo[index] = new staff(nombre_equipo, nombre, apellido, dni, fecha_nacimiento, ambito, rol);
        index++;
    }

    public void ingresarDirectiva(String nombre_equipo, String nombre, String apellido, String dni, String fecha_nacimiento, String cargo) {
        equipo[index] = new directiva(nombre_equipo, nombre, apellido, dni, fecha_nacimiento, cargo);
        index++;
    }

    public void PartidoGanado() {
        puntos += 3;
    }

    public void PartidoEmpatado() {
        puntos += 1;
    }

    public void PartidoPerdido() {
        puntos += 0;
    }

    public void verEquipo() {
        for (int i = 0; i < index; i++) {
            System.out.println(equipo[i]);
        }
    }
}