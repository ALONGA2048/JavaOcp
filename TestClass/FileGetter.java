import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileGetter {
     public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "start", "C:\\Users\\88690\\Desktop\\allData3.txt");
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     

     public static void filebuilder(){
        String userhome = System.getProperty("user.home");
        System.out.println(userhome);
        String desktop = userhome+ File.separator + "Desktop";
        File example = new File(desktop,"example.txt");
          try (FileWriter writer = new FileWriter(example)) {
            writer.write("這是一個測試文件！");
            System.out.println("文件已成功建立：" + example.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
}
