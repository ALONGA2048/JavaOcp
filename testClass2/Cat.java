public class Cat extends Animal implements Movement{
    
    public Cat(int age,String name){
        super(age,name);
        
    }
    @Override
    public void roar() {
        System.out.println("meao meao nigga");
    }
    @Override
    public void play() {
        System.out.println("play with sofa");
    }
    

}
