import java.util.Scanner;

public class stringBuilder {
     //String 不可改變的 
     //StringBuffer 可改變的字串 thread安全但效率低
     //StringBuilder 可改變的字串 thread不安全但效率高
  @SuppressWarnings("resource")
public static void main(String[] args) {
    //String 方法
    
    String string  = "baa";
    String string2 = "bab";
    //substring可以輸入要開始的起點之後截取之後的字符形成字串
    System.out.println(string.substring(1));
    System.out.println("-----");
    
    System.out.println(string.concat(string2));
    boolean ans = string2.contains("b");
    System.out.println(ans);
    string.endsWith("b");
    System.out.println("-------");
    int i = string.indexOf("a",2);
    System.out.println(i);
    System.out.println(string.replace("a", "b"));
    System.out.println("-------");
    //StringBuilder 方法實作內容
    StringBuilder sb = new StringBuilder(5);//可在建構子內傳入需要的初始長度
    sb.append("HOWDY"); //要加入的字串(疊加進入)
    sb.insert(0, " ");//插入點 插入的字串
    sb.replace(3, 5, "LL"); //代替的起點 終點 代替字串
    //(注意!計算都是含起點不含終點 如:起3終5那他會替換掉3,4而已!!)
    sb.insert(6,"COW");//從索引六開始插入COW字串(別擔心她超出索引範圍 他會依照需求空間無限變大)
    
    sb.delete(2, 7);//刪除2到六索引的內容
    System.out.println(sb.length());//印出其長度
  }
}
