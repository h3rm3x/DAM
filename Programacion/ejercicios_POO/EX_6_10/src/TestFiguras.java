import java.util.Scanner;

public class TestFiguras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Figuras_geometrticas[] f = new Figuras_geometrticas[1000];
        int contador_figuras = 0;
        int opcion;

        do {
            System.out.println("MENU");
            System.out.println("0 - Salir");
            System.out.println("1 - Crear Rectangulo");
            System.out.println("2 - Crear Circulo");
            System.out.println("3 - Crear Cuadrado");
            System.out.println("4 - Crear Robo");
            opcion = sc.nextInt();
            switch (opcion) {
                case 0:
                    break;
                case 1: {
                    System.out.println("CREAR RECTANGULO");
                    System.out.println("Introduce la coordenada X de la esquina mas cercana a (0,0)");
                    double x = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Introduce la coordenada Y de la esquina mas cercana a (0,0)");
                    double y = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Introduce el ancho del Rectangulo");
                    double ancho = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Introduce el alto del Rectangulo");
                    double alto = sc.nextDouble();
                    sc.nextLine();
                    f[contador_figuras] = new Rectangulo(x, y, ancho, alto);


                    f[contador_figuras].area();
                    f[contador_figuras].perimetro();
                    System.out.println(f[contador_figuras]);
                    contador_figuras++;
                    break;
                }
                case 2: {
                    System.out.println("CREAR CIRCULO");
                    System.out.println("Introduce la coordenada X del centro del Círculo");
                    double x = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Introduce la coordenada Y del centro del Círculo");
                    double y = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Introduce el Radio del circulo");
                    double radio = sc.nextDouble();
                    sc.nextLine();

                    f[contador_figuras] = new Circulo(radio, x, y);

                    f[contador_figuras].area();
                    f[contador_figuras].perimetro();
                    System.out.println(f[contador_figuras]);

                    contador_figuras++;
                    break;
                }
                case 3: {
                    System.out.println("CREAR CUADRADO");
                    System.out.println("Introduce la coordenada X de la esquina mas cercana a (0,0)");
                    double x = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Introduce la coordenada Y de la esquina mas cercana a (0,0)");
                    double y = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Introduce la longitud del lado del cuadrado");
                    double lado = sc.nextDouble();
                    sc.nextLine();

                    f[contador_figuras] = new Cuadrado(lado, x, y);

                    f[contador_figuras].area();
                    f[contador_figuras].perimetro();
                    System.out.println(f[contador_figuras]);
                    contador_figuras++;
                    break;
                }

                case 4: {
                    System.out.println("CREAR ROMBO");
                    System.out.println("Introduce la coordenada X de la esquina mas cercana a (0,0)");
                    double x = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Introduce la coordenada Y de la esquina mas cercana a (0,0)");
                    double y = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Introduce la longitud de la diagonal mayor del Rombo");
                    double Dmayor = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Introduce la longitud de la diagonal menor del Rombo");
                    double Dmenor = sc.nextDouble();
                    sc.nextLine();

                    f[contador_figuras] = new Rombo(Dmayor, Dmenor, x, y);

                    f[contador_figuras].area();
                    f[contador_figuras].perimetro();
                    System.out.println(f[contador_figuras]);
                    contador_figuras++;
                    break;
                }
                default: {
                    System.out.println("Opcion no valida");
                    System.out.println("Introduce una opcion valida");
                    break;
                }

            }
        } while (opcion != 0);
    }
}
