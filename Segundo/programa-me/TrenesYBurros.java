public class TrenesYBurros { // Asume fichero llamado solution.java
    static java.util.Scanner in;

    public static boolean casoDePrueba() {
        int estaciones = in.nextInt();
        if (estaciones == 0)
            return false;
        else {
            int contador = 0;
            // leer n-1 elementos para recibir los tiempos en tren y en burro
            long tiempostren[] = new long[estaciones-1];
            for (int i = 0; i < estaciones-1; i++) {
                tiempostren[i]= in.nextInt();
            }
            long tiemposburro[] = new long[estaciones-1];
            for (int i = 0; i < estaciones-1; i++) {
                tiemposburro[i]= in.nextInt();
            }
            
            // comprobar cuantos trayectos se pueden hacer en burro mas rapido que en tren
            // Para cada par de estaciones (i, j) donde i < j
            for (int i = 0; i < estaciones; i++) {
                long sumaTren = 0;
                long sumaBurro = 0;
                for (int j = i; j < estaciones-1; j++) {
                    // Acumular tiempos del tramo j
                    sumaTren += tiempostren[j];
                    sumaBurro += tiemposburro[j];
                    // Comparar trayecto completo de estación i a estación j+1
                    if (sumaBurro < sumaTren) {
                        contador++;
                    }
                }
            }
            
            System.out.println(contador);
            return true;
         }
    } // casoDePrueba

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main

} // class solution