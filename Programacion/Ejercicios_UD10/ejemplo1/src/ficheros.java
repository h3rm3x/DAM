import java.io.File;
public class ficheros {

    public static void main(String[] args) {
        // Crear un objeto de la clase Fichero
        File f = new File("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ejemplo1");

        System.out.println(f.exists());
//        try {
//            if(!f.exists()) {
//                f.createNewFile();
//            };
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // Comprobar si es un directorio
        if (f.isDirectory()) {
            System.out.println("Es un directorio");
        } else {
            System.out.println("No es un directorio");
        }

        // Listar los ficheros del directorio
        String[] lista = f.list();
        for (String s : lista) {
            System.out.println(s);
        }

    }
}
