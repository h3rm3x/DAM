import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        double celsius, fahrenheit=0;
        Scanner input = new Scanner(System.in);
        System.out.print("Enta el valor en farenheit: ");
        fahrenheit = input.nextDouble();
        celsius = (fahrenheit-32)*5/9;
        System.out.println(fahrenheit +"º Farenheit, equival a "+celsius+ "º Celsius");
        };
    }
