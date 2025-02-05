import java.util.Scanner;

public class tests {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[] meses = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        while (true) {
            int dia = teclado.nextInt();
            int mes = teclado.nextInt();
            int anyo = teclado.nextInt();
            int diaHoy = teclado.nextInt();
            int mesHoy = teclado.nextInt();
            int anyoHoy = teclado.nextInt();

            if (dia == 0 && mes == 0 && anyo == 0 && diaHoy == 0 && mesHoy == 0 && anyoHoy == 0) {
                return;
            }

            if (dia == diaHoy && mes == mesHoy) {
                System.out.println("0");
            } else {
                long sum1 = anyo * 365 + dia;
                for (int i = 0; i < mes - 1; i++) {
                    sum1 += meses[i];
                }
                long sum2 = anyoHoy * 365 + diaHoy;
                for (int i = 0; i < mesHoy - 1; i++) {
                    sum2 += meses[i];
                }
                long sum = sum2 - sum1 - (anyoHoy - anyo - 1);
                if ((diaHoy > dia && mesHoy == mes) || (mesHoy > mes)) {
                    sum--;
                }
                System.out.println(sum);
            }
        }
    }
}