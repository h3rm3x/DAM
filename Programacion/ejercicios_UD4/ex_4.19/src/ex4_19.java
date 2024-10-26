import java.util.Scanner;
public class ex4_19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un numero: ");
        boolean primo = true;
        int numero = sc.nextInt();
        int divisor = 1;
        for (int i = (int) (Math.sqrt(numero)+1); i > 1; i--) {
            if (numero % i == 0) {
                primo = false;
                divisor=i;
                break;
            }
        }
        if (primo) {
            System.out.println("el numero "+ numero + " ES primo");
        }else {
            System.out.println("el numero "+ numero + " NO es primo, es divisible por " + divisor);
        }
    }
}