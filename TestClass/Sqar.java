import java.util.*;

public class Sqar{
                 
                  public static void main(String[] args){
                                Scanner sc = new Scanner(System.in);
                                int aim = sc.nextInt();
                                int count =1;
                                while(aim>2){
                                      if(count*count<aim){
                                               count++;
                                      }else{
                                              if(count*count!=aim){
                                              	  count--;
                                                  System.out.printf("your sqar is %d%n",count);
                                                  break;
                                              }else{
                                                  System.out.printf("your sqar is %d%n",count);
                                                  break;
                                              }
                                      }
                                 }
                                sc.close();
                    }
}