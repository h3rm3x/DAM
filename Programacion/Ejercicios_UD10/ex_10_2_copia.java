import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
public class EX_10_2 {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\alanr\\Downloads");
        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".jpg")| name.endsWith(".png");
            }
        });
        for (File file : files) {
            System.out.println(file.getName());
        }


    }
}
