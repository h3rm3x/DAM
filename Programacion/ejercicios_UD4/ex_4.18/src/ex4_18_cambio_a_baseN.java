import java.util.Scanner;
public class ex4_18_cambio_a_baseN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un numero: ");
        int num = sc.nextInt();
        System.out.println("Escribe la base en la que quieres que se transforme ");
        int n = sc.nextInt();
        int resultado = 0;
        int[] baseN = new int[100];
        int i = 0;
        do {

            resultado = num % n;
            num /= n;
            baseN[i] = resultado;
            i++;


        } while (num >= 1);

        i-=1;
        while (i >= 0) {
            System.out.print(baseN[i]+" * "+n+"^"+i+" ");
            i--;
        }
    }

}

