import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LecturaScv {

	public static void main(String[] args) {
		
		ArrayList<Persona> persones = new ArrayList<>();
		String linea;
		String[] dades = new String[3];
		
		FileReader fr = null;
		BufferedReader input = null; 
		try {
			fr = new FileReader ("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ejemplo_leer_csv\\datos_personas.csv");
			input = new BufferedReader (fr);
			
			while ((linea = input.readLine())!=null) {
				dades = linea.split(";");
				String nom = dades[0];
				int edat = Integer.parseInt(dades[1]);
				String dni = dades[2];
				
				persones.add((new Persona(nom, edat, dni)));
				
			}
			
			for (Persona p : persones) {
				System.out.println(p);
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				fr.close();
				input.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		

	}

}
