import java.util.*;

public class MyElevetor{

             public final int  MAX_Floor = 10;
             public final int  MIN_Floor = 1;
             boolean open = false;
             int currentFloor = 1;
             public void openDoor(){
                         System.out.println("Try to open the door");
                         if(open == true){
                                 System.out.println("door is already open ");
                          }else{
                                 open =true;
                                 System.out.println("door is open now");
                          }
              }
             
              public void closeDoor(){
                         System.out.println("Try to close the door");
                         if(open == false){
                                 System.out.println("door is already close ");
                          }else{
                                 open =false;
                                 System.out.println("door is close now");
                          }

               }
             
               public void up(){
                         if(currentFloor>=MAX_Floor){
                                    System.out.println("elevetor is in the top");
                         }else{
                                    System.out.println("elevetor is going up");
                                    currentFloor +=1;
                                    System.out.println("now" +currentFloor +"...");
                          }
                }
               
                public void down(){
                            if(currentFloor<=MIN_Floor){
                                    System.out.println("elevetor is in the lowest");
                         }else{
                                    System.out.println("elevetor is going down");
                                    currentFloor -=1;
                                    System.out.println("now" +currentFloor +"...");
                          }


                }
}
             

            