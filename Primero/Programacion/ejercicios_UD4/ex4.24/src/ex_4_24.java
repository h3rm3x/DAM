import java.util.Objects;
import java.util.Scanner;
public class ex_4_24 {
    static Scanner sc = new Scanner(System.in);
    public static double Lllegireuros (){
        double euros;
        System.out.println("Escribe la cantidad de euros: ");
        euros= sc.nextDouble();
        sc.nextLine();
        return euros;
    }
    public static String moneda_a_convertir (){
        String moneda;
        System.out.println("Escribe la moneda a la que quieres convertir esta cantidad(yens, libras o dolares: ");
        moneda= sc.nextLine();
        return moneda;
    }
    public static void conversor() {
        double euros = Lllegireuros ();
        String moneda= moneda_a_convertir();

        double conversion=0;
        if(Objects.equals(moneda, "yens")){
            conversion= euros * 136.66;
            System.out.println(euros + "€ en Yens son "+ conversion + "yens");
            return;
        }
        if(Objects.equals(moneda, "libras")){
            conversion= euros * .85;
            System.out.println(euros+"€ en Libras son "+ conversion + "libras");
        }
        if(Objects.equals(moneda, "dolares")){
            conversion= euros * 1.16;
            System.out.println(euros+"€ en Dolares son "+ conversion + "dolares");
        }


    }
    public static void main(String[] args) {
        while (true) {
            conversor();
            System.out.println("Escribe caulquier numero para continuar con el programa o 0 para finalizar ");
            String  finalizar = sc.nextLine();

            if (Objects.equals(finalizar, "0")) {
                break;
            }
        }
    }
}