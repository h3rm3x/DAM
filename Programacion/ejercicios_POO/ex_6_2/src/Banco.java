import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cuenta_bancaria cuenta1 = new Cuenta_bancaria(1,"Alan","1234567A");
        Cuenta_bancaria cuenta2 = new Cuenta_bancaria(2,45778.87,"David","2345678A");
        Cuenta_bancaria cuenta3 = new Cuenta_bancaria(3,"Diego","1234567B");
        Cuenta_bancaria cuenta4 = new Cuenta_bancaria(4);


        System.out.println("ingresa el saldo de la cuenta numero "+  cuenta1.getNumero_cuenta()+ " perteneciente a" + cuenta1.getNombre_titular());
        cuenta1.setSaldo(sc.nextDouble());
        sc.nextLine();
        System.out.println("ingresa el saldo de la cuenta numero "+ cuenta3.getNumero_cuenta()+" perteneciente a "+ cuenta3.getNombre_titular());
        cuenta3.setSaldo(sc.nextDouble());
        sc.nextLine();
        System.out.println("ingresa el nombre del titular de la cuenta: "+ cuenta4.getNombre_titular());
        cuenta4.setNombre_titular(sc.nextLine());
        System.out.println("ingresa el DNi de: " + cuenta4.getNombre_titular());
        cuenta4.setDNI_titular(sc.nextLine());
        System.out.println("ingresa el saldo de la cuenta "+ cuenta4.getNumero_cuenta() +" perteneciente a" + cuenta4.getNombre_titular());
        cuenta4.setSaldo(sc.nextDouble());
        sc.nextLine();

/*
        cuenta1.verSaldo();
        System.out.println();
        cuenta2.verSaldo();
        System.out.println();
        cuenta3.verSaldo();
        System.out.println();
        cuenta4.verSaldo();
        System.out.println();
*/
        int opcion=1;
        int numero_cuenta;
        while (opcion!=0){
            System.out.println("MENU");
            System.out.println("0. Salir");
            System.out.println("1. Ingresar dinero en la cuenta");
            System.out.println("2. Retirar dinero de la cuenta");
            System.out.println("3. Comprobar el saldo de la cuenta");

            System.out.println("Ingresa una opcion");
            opcion=sc.nextInt();
            switch (opcion){
                case 1: {
                    System.out.println("Ingresa el numero de la cuenta a la que quieres ingresar dinero: ");
                    numero_cuenta = sc.nextInt();
                    if (numero_cuenta == cuenta1.getNumero_cuenta()) {
                        System.out.println("ingresa la cantidad de dinero que quieres ingresae");
                        cuenta1.depositar(sc.nextDouble());
                        sc.nextLine();
                        break;
                    } else if (numero_cuenta == cuenta2.getNumero_cuenta()) {
                        System.out.println("ingresa la cantidad de dinero que quieres ingresae");
                        cuenta2.depositar(sc.nextDouble());
                        sc.nextLine();
                        break;
                    } else if (numero_cuenta == cuenta3.getNumero_cuenta()) {
                        System.out.println("ingresa la cantidad de dinero que quieres ingresae");
                        cuenta3.depositar(sc.nextDouble());
                        sc.nextLine();
                        break;
                    } else if (numero_cuenta == cuenta4.getNumero_cuenta()) {
                        System.out.println("ingresa la cantidad de dinero que quieres ingresae");
                        cuenta4.depositar(sc.nextDouble());
                        sc.nextLine();
                        break;
                    } else {
                        System.out.println("ERROR, el numero de cuenta no existe. /n vuelve a elegir esta opcion e ingresa un numero de cuenta existente");
                    }
                }
                case 2: {
                    System.out.println("Ingresa el numero de la cuenta a la que quieres retirar dinero: ");
                    numero_cuenta = sc.nextInt();
                    if (numero_cuenta == cuenta1.getNumero_cuenta()) {
                        System.out.println("ingresa la cantidad de dinero que quieres retirar");
                        double retirado = sc.nextDouble();
                        while (retirado > cuenta1.getSaldo()) {
                            System.out.println("ERROR, ingrese una cantidad igual o inferior al saldo de la cuenta"+ cuenta1.getSaldo());
                            retirado = sc.nextDouble();
                        }
                        cuenta1.retirar(retirado);
                        sc.nextLine();
                        break;
                    } else if (numero_cuenta == cuenta2.getNumero_cuenta()) {
                        System.out.println("ingresa la cantidad de dinero que quieres retirar");
                        double retirado = sc.nextDouble();
                        while (retirado > cuenta2.getSaldo()) {
                            System.out.println("ERROR, ingrese una cantidad igual o inferior al saldo de la cuenta"+ cuenta2.getSaldo());
                            retirado = sc.nextDouble();
                        }
                        cuenta2.retirar(retirado);
                        sc.nextLine();
                        break;
                    } else if (numero_cuenta == cuenta3.getNumero_cuenta()) {
                        System.out.println("ingresa la cantidad de dinero que quieres retirar");
                        double retirado = sc.nextDouble();
                        while (retirado > cuenta3.getSaldo()) {
                            System.out.println("ERROR, ingrese una cantidad igual o inferior al saldo de la cuenta"+ cuenta3.getSaldo());
                            retirado = sc.nextDouble();
                        }
                        cuenta3.retirar(retirado);
                        sc.nextLine();
                        break;
                    } else if (numero_cuenta == cuenta4.getNumero_cuenta()) {
                        System.out.println("ingresa la cantidad de dinero que quieres retirar");
                        double retirado = sc.nextDouble();
                        while (retirado > cuenta4.getSaldo()) {
                            System.out.println("ERROR, ingrese una cantidad igual o inferior al saldo de la cuenta"+ cuenta4.getSaldo());
                            retirado = sc.nextDouble();
                        }
                        cuenta4.retirar(retirado);
                        sc.nextLine();
                        break;
                    } else {
                        System.out.println("ERROR, el numero de cuenta no existe. /n vuelve a elegir esta opcion e ingresa un numero de cuenta existente");
                    }
                }
                case 3: {
                    System.out.println("Ingresa el numero de la cuenta a la que quieres ingresar dinero: ");
                    numero_cuenta = sc.nextInt();
                    if (numero_cuenta == cuenta1.getNumero_cuenta()) {
                        cuenta1.verSaldo();
                        break;
                    } else if (numero_cuenta == cuenta2.getNumero_cuenta()) {
                        cuenta2.verSaldo();
                        break;
                    } else if (numero_cuenta == cuenta3.getNumero_cuenta()) {
                        cuenta3.verSaldo();
                        break;
                    } else if (numero_cuenta == cuenta4.getNumero_cuenta()) {
                        cuenta4.verSaldo();
                        break;
                    } else {
                        System.out.println("ERROR, el numero de cuenta no existe. /n vuelve a elegir esta opcion e ingresa un numero de cuenta existente");
                    }
                }
                case 0: break;
                default: System.out.println("ERROR, la opcion introducida es incorrecta. Vuelva a escribir una opcion entre 0 y 3");

            }
        }
    }
}
