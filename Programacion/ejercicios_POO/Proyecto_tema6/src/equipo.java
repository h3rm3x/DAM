public class equipo {
    private Miembros_equipo[] equipo;
    private int index;
    private String nombre_equipo;
    private int puntos;
    private int partidos_jugados = 0;
    private int partidos_ganados = 0;
    private int partidos_empatados = 0;
    private int partidos_perdidos = 0;

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

    public int getPartidos_jugados() {
        return partidos_jugados;
    }

    public int getPartidos_ganados() {
        return partidos_ganados;
    }

    public int getPartidos_empatados() {
        return partidos_empatados;
    }

    public int getPartidos_perdidos() {
        return partidos_perdidos;
    }

    public void setPartidos_jugados(int partidos_jugados) {
        this.partidos_jugados = partidos_jugados;
    }

    public void setPartidos_ganados(int partidos_ganados) {
        this.partidos_ganados = partidos_ganados;
    }

    public void setPartidos_empatados(int partidos_empatados) {
        this.partidos_empatados = partidos_empatados;
    }

    public void setPartidos_perdidos(int partidos_perdidos) {
        this.partidos_perdidos = partidos_perdidos;
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
        partidos_ganados++;
        partidos_jugados++;

    }

    public void PartidoEmpatado() {
        puntos += 1;
        partidos_empatados++;
        partidos_jugados++;
    }

    public void PartidoPerdido() {
        puntos += 0;
        partidos_perdidos++;
        partidos_jugados++;
    }

    public void eliminarJugador(String dni) {
        for (int i = 0; i < index; i++) {
            if (equipo[i] instanceof Jugador && equipo[i].getDni().equals(dni)) {
                for (int j = i; j < index - 1; j++) {
                    equipo[j] = equipo[j + 1];
                }
                equipo[index - 1] = null;
                index--;
                break;
            }
        }
    }

    public String toString() {
        String p_equipo = "Nombre Equipo: " + nombre_equipo + ", Puntos: " + puntos + "\n";
        for (int i = 0; i < index; i++) {
            p_equipo += equipo[i] + "\n";
        }
        return p_equipo;
    }
}