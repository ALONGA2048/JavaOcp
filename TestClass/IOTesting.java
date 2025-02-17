import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class IOTesting {
   
    public static void main(String[] args) throws  Exception {
        

        byte[] b = new byte[128];
        int bLen = b.length; //會幫我建立複製的訊息
        try(FileInputStream fis = new FileInputStream("source.txt");
            FileOutputStream fos = new FileOutputStream("target.txt")){
            System.out.println("will copy byte" +fis.available());
            int read = 0;  //available方法-> 有多少byte可供讀取
            while ((read=fis.read(b))!=-1) { //若檔案讀取完畢則會回傳-1以此結束迴圈
                if(read<bLen){ //若剩餘字數不足128則會使用 將剩餘字數由上個其始點寫入
                    fos.write(b,0,read);
                }else{
                    fos.write(b); //一次寫入128 byte的單位
                }
            }
        } catch(FileNotFoundException fns){
            fns.printStackTrace();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
