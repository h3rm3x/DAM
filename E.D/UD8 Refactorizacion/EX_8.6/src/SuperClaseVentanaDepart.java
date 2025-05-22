import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SuperClaseVentanaDepart extends JFrame {
    JTextField nombre = new JTextField(25);
    JTextField loc = new JTextField(25);

    public void visualiza(int dep) {
        String nom = "", loca = "";
        long pos;
        int depa;
        File fichero = new File("AleatorioDep.dat");
        try {
            RandomAccessFile file = new RandomAccessFile(fichero, "r");
            // Calculo del reg a leer
            pos = 44 * (dep - 1);
            file.seek(pos);
            depa = file.readInt();
            System.out.println("Depart leido:" + depa);
            char nom1[] = new char[10], aux, loc1[] = new char[10];
            for (int i = 0; i < 10; i++) {
                aux = file.readChar();
                nom1[i] = aux;
            }
            for (int i = 0; i < 10; i++) {
                aux = file.readChar();
                loc1[i] = aux;
            }
            nom = new String(nom1);
            loca = new String(loc1);
            System.out.println("DEP: " + dep + ", Nombre: " + nom + ", Localidad: " + loca);
            nombre.setText(nom);
            loc.setText(loca);
            file.close();
        } catch (IOException e1) {
            System.out.println("ERRROR AL LEEERRRRRR AleatorioDep.dat");
            e1.printStackTrace();
        }
    } // fin visualiza

    void grabar(int dep, String nom, String loc) {
        long pos;
        StringBuffer buffer = null;
        File fichero = new File("AleatorioDep.dat");
        try {
            RandomAccessFile file = new RandomAccessFile(fichero, "rw");
            // Calculo del reg a leer
            pos = 44 * (dep - 1);
            //if (file.length()==0) return false; // si est� vac�o

            file.seek(pos);
            file.writeInt(dep);
            buffer = new StringBuffer(nom);
            buffer.setLength(10);
            file.writeChars(buffer.toString());//insertar nombre
            buffer = new StringBuffer(loc);
            buffer.setLength(10);
            file.writeChars(buffer.toString());//insertar loc
            file.close();
            System.out.println(" GRABADOOO el " + dep);
        } catch (IOException e1) {
            System.out.println("ERRROR AL grabarr AleatorioDep.dat");
            e1.printStackTrace();
        }
    } // fin grabar
}
