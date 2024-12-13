import java.util.Scanner;

public class NoCumpleanos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int diaNac = sc.nextInt();
            int mesNac = sc.nextInt();
            int anoNac = sc.nextInt();
            int diaActual = sc.nextInt();
            int mesActual = sc.nextInt();
            int anoActual = sc.nextInt();
            int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            // Finalizar si los seis valores son ceros
            if (anoNac == 0 && mesNac == 0 && diaNac == 0 && anoActual == 0 && mesActual == 0 && diaActual == 0) {
                break;
            }

            // Caso especial: si es el día del cumpleaños
            if (diaActual == diaNac && mesActual == mesNac) {
                System.out.println(0);
                continue;
            } else {
                // Calcular días completos vividos desde el nacimiento hasta el final del año de nacimiento
                long diasIniciales = diasMes[mesNac - 1] - diaNac; // Días del mes de nacimiento
                for (int i = mesNac; i < 12; i++) { // Meses restantes del año
                    diasIniciales += diasMes[i];

                }

                // Calcular días completos vividos desde el inicio del año actual hasta la fecha actual
                long diasFinales = diaActual;
                for (int i = 0; i < mesActual - 1; i++) { // Meses desde enero hasta el mes anterior al actual
                    diasFinales += diasMes[i];
                }

                System.out.println("inic" +diasIniciales + "FINAL"+ diasFinales);

                // Calcular días completos entre los años intermedios
                long diasIntermedios = (anoActual - anoNac - 1) * 365L; // Años completos vividos (sin el primero ni el último)
                System.out.println("inter"+diasIntermedios);
                // Sumar todos los días vividos
                long diasTotales = diasIniciales + diasFinales + diasIntermedios;

                // Calcular no cumpleaños (días totales - cumpleaños vividos)
                long noCumpleanos = diasTotales - (anoActual - anoNac - 1);
                if (diaActual > diaNac && mesActual == mesNac || mesActual > mesNac) {
                    noCumpleanos--;
                }
                System.out.println(noCumpleanos);
            }
        }
    }
}