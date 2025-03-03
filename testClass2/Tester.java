public class Tester {
    private int age;
    
   
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if(age<120 &&age>18){
            this.age = age;
        }
    }
}
