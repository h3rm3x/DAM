/*import java.util.Scanner;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            int dia_nac = sc.nextInt();
            int mes_nac = sc.nextInt();
            int ano_nac = sc.nextInt();

            int dia_actual = sc.nextInt();
            int mes_actual = sc.nextInt();
            int ano_actual = sc.nextInt();

            if (dia_actual == 0 && dia_nac == 0 && mes_nac == 0 && mes_actual == 0 && ano_nac == 0 && ano_actual == 0) {
                break;
            }
            if (dia_actual == dia_nac && mes_actual == mes_nac) {
                System.out.println(0);
                continue;
            }

            int dias_totales = calcularNoCumpleanos(dia_nac, mes_nac, ano_nac, dia_actual, mes_actual, ano_actual);
            System.out.println(dias_totales);
        }
    }




    public static int calcularNoCumpleanos(int dia_nac, int mes_nac, int ano_nac, int dia_actual, int mes_actual, int ano_actual) {
        int dias_del_ano_actual = dia_actual+1;
        int[] dias_mes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 0; i <mes_actual-1; i++) {
            dias_del_ano_actual += dias_mes[i];
        }
        int dias_del_ano_nac = dias_mes[mes_nac-1]-dia_nac;
        for (int i = mes_nac; i < 12; i++) {
            dias_del_ano_nac += dias_mes[i];

        }
        int dias_restantes = (ano_actual-ano_nac-1)*365;
        int cumpleanos_vividos= ano_actual-ano_nac;

        return dias_del_ano_nac+dias_del_ano_actual+dias_restantes- cumpleanos_vividos;
    }*/
import java.util.Scanner;

    public class no_cumpleanos {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);


            while (true) {
                // Leer la fecha de nacimiento
                int diaNac = sc.nextInt();
                int mesNac = sc.nextInt();
                int anoNac = sc.nextInt();


                // Leer la fecha actual

                int diaActual = sc.nextInt();
                int mesActual = sc.nextInt();
                int anoActual = sc.nextInt();

                // Finalizar si los seis valores son ceros
                if (anoNac == 0 && mesNac == 0 && diaNac == 0 && anoActual == 0 && mesActual == 0 && diaActual == 0) {
                    break;
                }

                // Caso especial: si es el día del cumpleaños
                if (diaActual == diaNac && mesActual == mesNac) {
                    System.out.println(0);
                    continue;
                }

                // Cálculo de los no cumpleaños
                int noCumpleanos = calcularNoCumpleanos(anoNac, mesNac, diaNac, anoActual, mesActual, diaActual);
                System.out.println(noCumpleanos);
            }

            sc.close();
        }

        private static int calcularNoCumpleanos(int anoNac, int mesNac, int diaNac, int anoActual, int mesActual, int diaActual) {
            // Total de días en cada mes (sin considerar años bisiestos)
            int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            // Calcular días completos vividos desde el nacimiento hasta el final del año de nacimiento
            int diasIniciales = 0;
            diasIniciales += diasMes[mesNac - 1] - diaNac; // Días del mes de nacimiento
            for (int i = mesNac; i < 12; i++) { // Meses restantes del año
                diasIniciales += diasMes[i];
            }

            // Calcular días completos vividos desde el inicio del año actual hasta la fecha actual
            int diasFinales = 0;
            for (int i = 0; i < mesActual - 1; i++) { // Meses desde enero hasta el mes anterior al actual
                diasFinales += diasMes[i];
            }
            diasFinales += diaActual - 1; // Días del mes actual (sin contar el día actual)

            // Calcular días completos entre los años intermedios
            int diasIntermedios = (anoActual - anoNac - 1) * 365; // Años completos vividos (sin el primero ni el último)

            // Sumar todos los días vividos
            int diasTotales = diasIniciales + diasFinales + diasIntermedios;

            // Calcular no cumpleaños (días totales - cumpleaños vividos)
            int cumpleanosVividos = anoActual - anoNac; // Un cumpleaños por cada año vivido
            return diasTotales - cumpleanosVividos;
        }
    }