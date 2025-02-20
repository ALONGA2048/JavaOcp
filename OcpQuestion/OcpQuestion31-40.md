
## Q31

given:

``` java

   interface Interfacel{
   	  public int method() throws Exception;
   	  private void pMethod(){
   	  	 /* implementation */
   	  }
   }
   interface Interfacel2 {
   	  public boolean equals();
   	  public static void sMethod(){
   	  	  /* implementation */
   	  }
   }
   interface Interfacel3 {
   	 public void method();
   	 public void method(String str);
   } 
   interface Interface4{
   	  public void aMethod(){
   	  	  /* implementation */
   	  }
   	  public void method();
   }
   interface Interface5 {
   	   public static void sMethod;
   	   public  void method(String str);
   }
```

which two interfaces can be used in lamda expressions?(choose two)

A Interface1

B Interface2

C Interface3

D Interface4

E Interface5

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :A 
   
   Lambda 可用的介面，必須符合「Functional Interface（函式介面）」的條件：

  ✅ 只包含一個抽象方法（SAM，Single Abstract Method）

  ❌ 不能有多個抽象方法（否則編譯器無法判斷 Lambda 代表哪個方法）

  ❌ 不能是 Object 類別的方法（如 equals()）
      
  ❌ 不能繼承多個有不同抽象方法的介面

  介面方法預設是 public abstract (不可實作) 如封裝為default private

  protected都不會是abstract(可實作) 而static字眼則一定要實做

</div>

**↑↑↑**

---

### Q32

given:

``` java

   enum Alphabet{

   	   A,B,C;
   	   //line 1

   }
```
and

``` java

    public static void main(String[] args) {
    	 System.out.print(Alphabet.getFirstItem());
    }
```
what code should be written at line 1 to make this code print :A?

A 

``` java
  
   final String getFirstItem(){
   	   return A.toString();
   }
```

B

``` java
   
   static String getFirstItem(){
   	 return Alphabet.values()[1].toString();
   }
```

C 

``` java 

    static String getFirstItem(){
    	return A.toString();
    }
```

D 

``` java

    String getFirstItem(){
    	return A.toString();
    }
```
---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :C 

   列舉型別的方法必須是static 而其值都有預設.value()方法所以直接呼叫就好了

   B 錯誤的地方在其為value陣列的[0]不是1

   Alphabet.values()會回傳列舉項目的陣列
   

</div>

**↑↑↑**

---

## Q33

given:

``` java 

    public interface TestInterface {
    	default void sampingProbeProcedure(){
    		   probeProcedure();
    		   System.out.print("p");
    		   System.out.print("q");
    	}
    	default void explosionProbeProcedure(){
    		probeProcedure();
    		System.out.print("r");
    	}
    	//line 1

    }
```

Eliminate code duplication.

keep contastent the number of methods other classes may implement fr
om 

this interface which method can be added line 1 to meet these requirements?

### 中翻

在line1 增加哪一個方法後 可以保持讚其他類別實作這個介面時的方法數量不變?

A private default void probeProcedure(){

	System.out.print("S");
}

B static void probeProcedure(){

	System.out.print("S");
}

C private void probeProcedure(){

	System.out.print("S");
}

D default void probeProcedure(){

	System.out.print("S");
}

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :C 

   以private宣稱的話 之後的繼承方法將無法覆寫或再使用他
   

</div>

**↑↑↑**

---

### Q34 

given: 

``` java
    
    public class Main{
          private static class Greet{
          	  private void print(){
          	  	  System.out.print("an exam");
          	  }
          }
          public static void main(String[] args) {
          	  Main.Greet i = new Greet();
          	  i.print();
          }
    }
```

what was the result?

A the compilation fails at line9

B the compilation fails at line2

C an exam

D the compilation fails at line 8

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :C 

   因為都在同一個class內的內部類別 private宣告不影響 main方法的使用
   

</div>

**↑↑↑**

---

### Q35

given:

``` java

    public static void main(String[] args) {
    	var data = new ArrayList<>();
    	data.add("Duke");
    	data.add(30);
    	data.add("hello world");
    	data.set(1,25);
    	data.remove(2);
    	data.set(3,1000L); //line 8
    	System.out.print(data);
    }
```

what is the output?

A [hello world , 1000]

B [Duke,30,Hello world]

C [Duke,25,null,1000]

D an excention is thrown at run time

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :D

   沒寫泛型時 默認為object型別 而使任意型別都可以輸入
   D 是因為 line 8 中指定不存在的陣列空間引發ArrayOutsidebox
   

</div>

**↑↑↑**

---

### Q36

which two are succesful example of autoboxing? (choose two)

A String a = "A";

B Integer b = 5;

C Float c = Float.valueOf(null);

D Double d = 4;

E Long e = 23L;

F Float f = 6.0;

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :BE

   自動從基本型別轉為包裝類別
   23l為 long 23的意思

</div>

**↑↑↑**

---


### Q37

given:

``` java

public class Hello{
	class Greeting{
		void sayhi(){
			System.out.print("hi");
		}
	}
	public static void main(String[] args) {
    // optionA
		Hello.Greeting gA = new Hello.Greeting();
		gA.sayhi();
	
	// optionB
	   Hello hb = new Hello();
	   Hello.Greeting gB = hB.new Greeting();
       gB.sayhi();
    // optionC
       Hello hc = new Hello();
       Hello.Greeting gc = hC.new Hello.Greeting();
       gc.sayhi();
    // option D\
       Hello hd = new Hello();
       Greeting hg = new Greeting();
       hG.sayhi();

	}
}
```

which option enable the code to print hi?

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :B

   內部類別 也需要有外部欸別的參考 才可以建立內部類別

   A 須改為 Hello.Greeting gA = new Hello.new Greeting();(宣告也可寫為Greeting)

   C 須改為 Hello.Greeting gc = hc.new Greeting();或Greeting gc = hc.new Greeting();

   D Greeting hG = hD.new Greeting();


</div>

**↑↑↑**

---

### Q38

given:

``` java
   enum Color implements Serializable {
   	   R(1),G(2),B(3);
   	   int code;
   	   public Color(int c){
   	   	  this.code = c;
   	   }
   }
```

what action ensures successful compilation ?

A replace public Color(int c) with private Color(int c)

B replace int c ;with private in c;

C replace int c ;with private final int c;

D replace enum Color implements Serializable with public enum Color

E replace enum Color with public enum Color.

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :A 

   eunm的建構子不可為private以外(沒寫也預設private) 因為她不能被修改或創建新的物件


</div>

**↑↑↑**

---


### Q39

given:

``` java

    public class A {

    }
```
And 

``` java
 
    public final class B extends A{

    }
```
what was the result of compiling these two classes?

A the compilation fails because there is no zero ards constructor defined in class A

B the compilation fails because either class A or class B needs to implemnets the toString() method

C the compilation fails because a final cnnot  extend another class

D the compilation succeeds

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :D 

  

</div>

**↑↑↑**

---

### Q40

given:

``` java

  public class Test{
  	   class Student{   // line 1
  	   	   String Student{
  	   	   	  String name;
  	   	   	  Student(String name){ //line 2
  	   	   	  	this.name = name;
  	   	   	  }
  	   	   }
  	   }
  	   public static void main(String[] args) {
  	   	  var student = new Student("Duke"); //line 3
  	   }
  }
```
which two independent changes will make the test class compiled(Choose two)

A Move the entire Students class declaration to seperate java file,Student.java

B change line2 to public Student(String name).

C change line1 to public class Student{.

D change line3 to Student student = new Student("Duke");

E Change line 1 to static class Student{.

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :AE

   內部移成外部後成一般
   內部改static 區域內都可以直接呼叫

  

</div>

**↑↑↑**

---