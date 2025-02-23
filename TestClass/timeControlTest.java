import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

public class timeControlTest {
   
    public static void main(String[] args) {
        // now方法取得目前時間 
        LocalDateTime time = LocalDateTime.now();
        // 在用formatter規劃要顯示的時間 看要怎麼表達 用這個寫出
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        // 回傳將會是字串
        String nowtime = time.format(dateFormat);
        System.out.println(nowtime);
    }
    //也可以像這樣回傳現在的時間跟範圍
    public static String getCurrentime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("mm:ss"));
    }
}
