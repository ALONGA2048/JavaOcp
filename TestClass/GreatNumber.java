import java.util.*;

public class GreatNumber{
                   
               public static void main(String [] args){
                             Scanner sc  = new Scanner(System.in);
                             System.out.println("please enter the first num");
                             int firstnum = sc.nextInt();
                             System.out.println("please enter the second num");
                             int secondnum = sc.nextInt();
                             if(firstnum==6||secondnum==6){
                                         System.out.println("true");
                             }else if(firstnum%6==0||secondnum%6==0){
                                          System.out.println("true");
                             }else{
                                      System.out.println("false");
                              }
               }
}
                                        