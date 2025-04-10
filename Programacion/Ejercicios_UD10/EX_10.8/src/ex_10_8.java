import java.util.ArrayList;
import java.io.*;
public class ex_10_8 {
    public static void main(String[] args) {
        ArrayList<Persona> list = new ArrayList<>();
        list.add(new Alumno("Juan", "123457A", 25, "Universidad"));
        list.add(new Alumno("Ana", "4578876A", 22, "Grado Superior"));
        list.add(new Alumno("Luis", "497876A", 30, "Máster"));
        list.add(new Profesor("Carlos", "2456710A", 40, "Matemáticas"));
        list.add(new Profesor("María", "4521876A", 35, "Historia"));
        list.add(new Profesor("Pedro", "4207876A", 50, "Física"));

        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\personas.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Persona p : list) {
                oos.writeObject(p);
            }
            oos.close();
            fos.close();

            System.out.println("Datos guardados correctamente en personas.dat");

            FileInputStream fis = new FileInputStream("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\personas.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Persona> MostrarLista = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                MostrarLista.add((Persona) ois.readObject());
            }



            ois.close();
            fis.close();
            System.out.println("Datos leídos correctamente de personas.dat");
            // Imprimir el contenido del array
            for (Persona p : MostrarLista) {
                System.out.println(p);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }

    }
}
