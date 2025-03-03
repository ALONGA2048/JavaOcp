public class Animal {
    private boolean alive = true;
    private boolean haveBones = true;
    private String name = null;
    private int age = 0;
    public Animal (int age,String name){
        this.age = age;
        this.name = name;
    }
    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public boolean isHaveBones() {
        return haveBones;
    }
    public void setHaveBones(boolean haveBones) {
        this.haveBones = haveBones;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return age+name;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)//確認是否本身
            return true;
        if (obj == null)//避免空指針
            return false;
        if (getClass() != obj.getClass())//確認類別
            return false;
        Animal other = (Animal) obj;//往上轉型object型別
        if (age != other.age)//要進行的特殊型別比較
            return false;
        return true;
    }
    
}
