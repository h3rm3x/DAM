import java.util.Scanner;
public class ex4_17_cambio_a_binario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un numero: ");
        int num = sc.nextInt();
        int resultado=0;
        int[] binario = new int[100];
        int i = 0;

        do {

            resultado = num % 2;
            num /=2 ;
            binario[i] = resultado;
            i++;


        } while (num >= 1);
        i-=1;
        while (i>=0){
            System.out.print(binario[i]);
            i--;
        }



    }

}