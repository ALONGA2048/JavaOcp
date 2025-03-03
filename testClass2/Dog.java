public class Dog extends Animal implements Movement{
    
    public Dog(int age,String name){
        super(age,name);
    
    }
    @Override
    public void roar(){
        System.out.println("woof woof chingchong");
    }
    @Override
    public void play() {
        System.out.println("play with bones");
    }
    
   
}
