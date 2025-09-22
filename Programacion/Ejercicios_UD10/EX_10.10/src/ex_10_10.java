import java.net.URL;
import java.util.*;
import java.io.*;
public class ex_10_10 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.basketball-reference.com/");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));


            String inputLine;
            StringBuilder inputText = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                inputText.append(inputLine);
            }
            br.close();

            FileWriter fw = new FileWriter("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ex_10_10.txt");
            fw.write(inputText.toString());

        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

}

