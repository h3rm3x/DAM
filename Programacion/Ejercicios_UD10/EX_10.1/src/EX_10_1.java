import java.util.Scanner;
import java.io.File;
public class EX_10_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File dir = new File("C:\\Users\\alanr\\Documents\\DAM\\Programacion");
        File[] files = dir.listFiles();
        System.out.println("Listado de ficheros del directorio "+ dir.getName()+ " localizado en "+ dir.getPath());
        for (File f : files) {
            System.out.println(f.getName());
        }

    }
}
