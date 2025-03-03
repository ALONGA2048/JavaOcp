

public class Hello{

    
    
    public static void main(String [] args){
        System.out.println(new Object());
        Animal catopus = new Cat(32, "catopus");
        if(catopus instanceof Cat){
            ((Cat)catopus).roar();
            ((Cat)catopus).play();
        }
        System.out.println(catopus.toString());
        System.out.println(((Cat)catopus).getName());
        System.out.println(catopus.getAge());
        System.out.println(catopus.isAlive());
        Animal dogoogle = new Dog(32, "dogoogle");
        if(dogoogle instanceof Dog){
            ((Dog)dogoogle).roar();
            ((Dog)dogoogle).play();
        }
        System.out.println(dogoogle.isHaveBones());
        System.out.println(dogoogle.getName());
        System.out.println(dogoogle.toString());
        System.out.println(dogoogle.equals(catopus));
    }
    
}