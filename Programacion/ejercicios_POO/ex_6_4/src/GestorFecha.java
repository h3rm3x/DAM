import java.util.Scanner;

public class GestorFecha {
    static Fecha[] fechas = new Fecha[50];
    static int index = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion=1;
        while (opcion!=4) {
            System.out.println("MENU");
            System.out.println("\n1. Ingresar Fecha");
            System.out.println("\n2. Modificar Fecha");
            System.out.println("\n3. Dar el dia siguiente a la fecha introducida");
            System.out.println("\n4. Salir");
            opcion=sc.nextInt();

            switch (opcion) {
                case 1: {
                    System.out.println("Ingrese la fecha: ");
                    System.out.println();

                    System.out.println("Ingrese el dia: ");
                    int dia = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el mes: ");
                    int mes = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el ano: ");
                    int ano = sc.nextInt();
                    sc.nextLine();
                    fechas[index] = new Fecha(dia, mes, ano);
                    index++;
                    break;
                }
                case 2: {
                    System.out.println("Modificar Fecha: ");
                    System.out.println("1. Modificar dia");
                    System.out.println("2. Modificar mes");
                    System.out.println("3. Modificar año");
                    System.out.println("4. Modificar dia mes y año");
                    System.out.println();
                    int modificar = sc.nextInt();
                    switch (modificar) {
                        case 1: {
                            System.out.println("Ingrese el dia: ");
                            int dia = sc.nextInt();
                            fechas[index].SetDia(dia);
                            break;
                        }
                        case 2: {
                            System.out.println("Ingrese el mes: ");
                            int mes = sc.nextInt();
                            fechas[index].SetMes(mes);
                            break;
                        }
                        case 3: {
                            System.out.println("Ingrese el ano: ");
                            int ano = sc.nextInt();
                            fechas[index].SetAno(ano);
                            break;
                        }
                        case 4: {
                            System.out.println("Ingrese el dia: ");
                            int dia = sc.nextInt();
                            fechas[index].SetDia(dia);
                            System.out.println("Ingrese el mes: ");
                            int mes = sc.nextInt();
                            fechas[index].SetMes(mes);
                            System.out.println("Ingrese el año: ");
                            int ano = sc.nextInt();
                            fechas[index].SetAno(ano);
                            break;
                        }
                    }
                        break;
                }
                case 3: {
                    System.out.println("Dia siguiente a la fecha: ");
                    System.out.println("el dia siguiente a la fecha "+ fechas[index-1].GetDia()+"/"+fechas[index-1].GetMes()+"/"+fechas[index-1].GetAno()+ " es "+ fechas[index-1].manana().GetDia()+"/"+fechas[index-1].manana().GetMes()+"/"+fechas[index-1].manana().GetAno());
                    break;
                }
                case 4: break;

            }

        }
    }
}
