import java.util.*;

public class Palindrome{
              
                public static void main(String[] args){
                                Scanner sc = new  Scanner(System.in);
                                int aim = sc.nextInt();
                                int finaim=aim;
                                int compare =0;
                                while(aim!=0){
                                             int temp=aim%10;
                                             aim /=10;
                                             compare=10*compare+temp;
                                            
                                 }
                                 if(finaim==compare){
                                        System.out.println("True");
                                 }else{
                                         System.out.println("false");
                                 }
                                 sc.close();

                }
}