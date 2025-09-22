import java.util.Scanner;

public class Simulacro_examen {
        static Scanner sc = new Scanner(System.in);
        public static String[] leer_usuario_contrasena(){ //entra un usario y contraseña y son guardados en un array
            System.out.println("FORMULARIO DE REGISTRO");
            System.out.println("Introduzca el usuario: ");
            String usuario = sc.nextLine();
            System.out.println("Introduzca la contraseña: ");
            String contrasena = sc.nextLine();
            String[] usuario_contrasena = new String[2];
            usuario_contrasena[0] = usuario;
            usuario_contrasena[1] = contrasena;
            return usuario_contrasena;
        }
        public static void main(String[] args) {
            int opcion=0;
            String[] usuarios = new String[50]; // array para almacenar todos los usuarios entrados en el programa
            String[] contrasenas = new String[50]; // array para almacenar todas las contraseñas entradas en el programa
            String[] usuario_contrasena = new String[2]; // array temporal donde se guarda el ultimo usuario y contraseña entrados por el usuario
            int intentos = 0;
            int index_usuario=0;
            int index_contrasena=0;

            while (opcion != 3) {
                System.out.println("MENU");
                System.out.println("1. Registro");
                System.out.println("2. Inicio de sesion");
                System.out.println("3. Salir del progrma");
                opcion = sc.nextInt();
                sc.nextLine();


                if(opcion==1){ usuario_contrasena = leer_usuario_contrasena();
                    usuarios[index_usuario] = usuario_contrasena[0];
                    contrasenas[index_contrasena] = usuario_contrasena[1]; // una vez entrados el usuario y contraseña se almacenan en el array temporal
                    index_contrasena++;
                    index_usuario++;
        //         System.out.println(usuario_contrasena[0]+" "+ usuario_contrasena[1]); // test
                }
                else if (opcion==2) {

                        System.out.println("Introduzca el usuario: ");
                        String usuario = sc.nextLine();
                        System.out.println("Introduzca la contraseña: ");
                        String contrasena = sc.nextLine();
                        if (usuario.equals(usuario_contrasena[0]) && contrasena.equals(usuario_contrasena[1])) { // coprueba si se han entrado el usuario y contraseña correctos
                            System.out.println("Ha inicado sesión de manera correcta. Ha usado " + intentos + " intentos para entrar el usuario y contraseña correctos");
                            intentos=0; // se reinicia la variable intentos una vez se ha iniciado sesion
                        }
                        else {
                            System.out.println("El usuario o la contraseña son icorrectos ");
                            intentos++;
                            //System.out.println(usuario_contrasena[0]+" "+ usuario_contrasena[1]); //test1
                        }
                }
                else if (opcion==3) {
                        System.out.println("fin del programa ");
                        System.out.println("los usuarios y contraseña introducids han sido: ");
                        for (int index=0; index<index_contrasena; index++) { // imprime todos los usuario y contraseñas entradas por el usuario
                            System.out.println("usuario "+ index+" " + usuarios[index] + " contraseña "+ index+" " + contrasenas[index]);

                        }


                    }
                else {
                    System.out.println("Opcion incorrecta, intrudece una opcion entre 1 y 3 ");
                }

            }
        }
    }


