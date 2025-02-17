import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInput {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String s = "";
    while (s!=null) {
        System.out.println("type abc to quit");
        s = in.readLine();
        if(s!=null){
            s=s.trim();
        }
        System.out.println("read:"+s);
        if(s.equals("abc")){
            System.out.println("=====right question quit======");
            System.exit(0);
        }
    }
  }
}
