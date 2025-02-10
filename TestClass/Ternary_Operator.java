import java.util.*;

public class Ternary_Operator{
             
             public static void main(String[] args){
                               int a =150;int b= 210;int c= 165;
                               int temp = a>b ? a : b;
                               int ans = temp>c ? c :temp;
                               System.out.println(ans);
             }
}