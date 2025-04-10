import java.net.URL;
import java.util.*;
import java.io.*;
public class ex_10_10 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.basketball-reference.com/");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));


            String inputLine;
            String inputText = "";
            while ((inputLine = br.readLine()) != null) {
                inputText += inputLine ;

            }
            br.close();

            FileInputStream fis = new FileInputStream("ex_10_10.txt");
            BufferedReader br2 = new BufferedReader(new InputStreamReader(fis));


        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    }
}
