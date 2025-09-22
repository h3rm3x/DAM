import java.io.*;
import java.util.ArrayList;

public class ejemplo_personas {
    public static void main(String[] args) {
        ArrayList<personas> lista = new ArrayList<>();

        lista.add(new personas("Juan", 25, "12345678A"));
        lista.add(new personas("Ana", 30, "87654321B"));
        lista.add(new personas("Luis", 40, "11223344C"));
        lista.add(new personas("Maria", 35, "44332211D"));
        lista.add(new personas("Pedro", 28, "55667788E"));
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\objetos.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\objetos.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<personas> listaLeida = new ArrayList<>();
            listaLeida = (ArrayList<personas>) ois.readObject();
            ois.close();
            fis.close();

            // Imprimir el contenido del array
            for (personas p : listaLeida) {
                System.out.println(p);
            }


        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
