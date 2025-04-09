import java.io.*;
import java.util.*;

public class ejemplo_objetos {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<Integer>();

        lista.add(512);
        lista.add(782);
        lista.add(123);
        lista.add(4576);
        lista.add(1234);
        lista.add(9412678);
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\objetos1.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\objetos1.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Integer> listaLeida = new ArrayList<>();
            listaLeida = (ArrayList<Integer>) ois.readObject();
            ois.close();
            fis.close();

            // Imprimir el contenido del array
            for (Integer integer : listaLeida) {
                System.out.println(integer);
            }






        } catch (IOException  | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
