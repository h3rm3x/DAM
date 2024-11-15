import java.util.Scanner;
public class ex_4_30 {
        static Scanner sc = new Scanner(System.in);
    public static String leer_codigo(){
        System.out.println("Escribe el codigo: ");
        String codigo = sc.nextLine();
        int ceros;

        while (codigo.length()>13){
            System.out.println("ERROR, el numero ha de ser de maximo 13 digitos ");
            System.out.println("Escribe el codigo de nuevo: ");
            codigo = sc.nextLine();
        }
        if (codigo.length()<8){ // si el codigo tiene menos de 8 digitos añadir los ceros necesarios a la izquierda para llegar a 8 digitos
            ceros= 8- codigo.length();
            for (int i=0;i<ceros;i++){
                codigo = "0"+codigo;
            }


        }
        else if (codigo.length()>8 && codigo.length()<13){ // si el codigo tiene mas de 8 y menos de 13 digitos añadir los ceros necesarios a la izquierda para llegar a 13 digitos
            ceros=13 -  codigo.length();
            for (int i=0;i<ceros;i++){
                codigo = "0"+codigo;
            }


        }
        return codigo;
    }
public static Boolean comprobar_codigo(String codigo){
        int control=0;
        int digito;

        for (int i=codigo.length()-2;i>=0;i--){ // suma de los digitos multiplicados por un factor
            digito= Integer.parseInt(codigo.charAt(i)+"");
           //System.out.println(i + "i"); //test
            if (i%2==0){ // los digitos pares se suman multiplicados por 1
                control+=digito;
                //System.out.println(digito+ "par"); // test
            } else { // los digitos pares se suman multiplicados por 3
                control+=digito*3;
                //System.out.println(digito+ "impar"); //test

            }
            //System.out.println("control loop " +control); //test
        }

        int prox_decena= 10- control%10; // lel digito de control es la distancia desde el ultimo digito de control hasta la uultima decena
        if (prox_decena==10){
            prox_decena=0;
        }
        //System.out.println("prox decena "+prox_decena); //test
        if (Integer.parseInt(codigo.charAt(codigo.length()-1)+"")==(prox_decena)){
            return true;

        }else return false;
}
public static String pais_origen(String codigo){
        int EAN = Integer.parseInt(codigo.substring(0,3));

        String[] paises = {"EEUU","España","Reino Unido","Irlanda","Portugal","Noruega","Venezuela","Cuba","India"};
        int[] limite_inf = {0,840,500,539,560,700,759,850,890};
        int[] limite_sup = {100,849,509,539,560,709,759,850,890};
        for (int i=0;i<paises.length;i++){
            if (EAN>=limite_inf[i] && EAN<=limite_sup[i]){
                return paises[i];
            }
        }
        return "desconocido";
}
    public static void main(String[] args) {
        while (true) {
            String codigo = leer_codigo();
            String inverso = "";
            for (int i = codigo.length() - 1; i >= 0; i--) { // invirtiendo el codigo tal que el index 0 sea el digito 13 y no el digito 1
                inverso += codigo.charAt(i) + "";
            }
            if (comprobar_codigo(inverso) && codigo.length() == 8) {
                System.out.println("El codigo: " + codigo + " es EAN-8");
            } else if (comprobar_codigo(inverso) && codigo.length() == 13) {
                System.out.println("El codigo: " + codigo + " es EAN-13 y indica que el producto viene de " + pais_origen(codigo));
            } else if (!comprobar_codigo(inverso)) {
                System.out.println("El codigo: " + codigo + " NO es correcto");
            }
            System.out.println();

            System.out.println("Para finalizar el programa escribe 0, para continuar pulsa enter");
            String finalizar = sc.nextLine();
            if (finalizar.equals("0")){
                break;
            }
        }

    }
}