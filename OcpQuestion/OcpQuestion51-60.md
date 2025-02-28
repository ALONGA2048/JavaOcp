### Q51

given:
``` java
public class ATGSynch{
	int acount;
	int tcount;
	int ccount;
	int gcount;
	ATGSynch(int a,int tCount,int c ,int g){
		//line1
	}
	int setCCount(int c){
		return c;
	}
	voif setGCount(int G){
		this.gcount = g;
	}
}
```
which two line of the code when inserted in line1 correctly modifies instance varilbles(Choose three)

A setCCount(c) = cCount;

B tCount = tCount

C setGCount(g)

D cCount = setCCount(c);

E aCount = a

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :CDE

   A 編譯失敗左側等號必須是變數

   B tCount 無法修改實例變數 必須改為this.tCount = tCount(被區域變數遮蔽)

</div>

**↑↑↑**

---

### Q52

given:

``` java

   class MyDog{

   }
```
And 

``` cmd
   javac C:\exam\MyDog.java
```
what was the expected result of the javac?

A javac fails to compile the class and prints the error message,C:\exam\MyDog.java:error:package java does not exist

B javac complies MyDog.java without errors or warnings

C javac fails to compile the class and prints the error message,C:\exam\MyDog.java:error:expected import java.lang

D javac fails to compile the class and prints the error message,Error:Could not find or load main class MyDog.class

### Q53

given:
``` java 
   interface Food{
   	    void getIngredients();
   }
   abstract class Cookie implements Food{
   }

   class ChocolateCookie implements cookie{
   	     public void getIngredients(){}
   }

   class SpecialChcolateCookie extends ChocolateCookie{
   	    void getIngredients(int x){}
   }
```
which is true

A the compilation fails due to the error one line 6

B the compilation succeeds

C the compilation fails due to the error one line 4

D the compilation fails due to the error one line 10

E the compilation fails due to the error one line 7

F the compilation fails due to the error one line 9

G the compilation fails due to the error one line 2

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :A

   不能運行 在第六行有抱錯 應改成extends方法 之後就可以運行了 後面的方法是overload
</div>

**↑↑↑**

---

### Q54

given:

``` java 

    StringBuilder sb = new StringBuilder("ABCD");
```
which would cause sb to be AZCD ?

A sb.replace(sb.indexOf("A"),sb.indexOf("B"),"Z");

B sb.replace(sb.indexOf("B"),sb.indexOf("C"),"Z");

C sb.replace(sb.indexOf("B"),sb.indexOf("B"),"Z");

D sb.replace(sb.indexOf("A"),sb.indexOf("B"),"Z");

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :B

   方法中start end replaceone 而他都是其始點包含不包含尾端
   
</div>

**↑↑↑**

---

### Q55

given:

``` java

    class Stuff{
    	String office;
    	//other fileds

    }
    class Admin{
    	var stuff = new ArrayList<Stuff>();
    	public  var display(){
    		var stuff = new stuff();
    		var offices = new ArrayList<>();
    		offices.add("A");
    		offices.add("B");
    		for(var office : offices){
    			System.out.print("stuff location:"+ office);
    		}
    	}
    }
````
which two lines cause compilation errors?(choose two)

A line 12

B line 6

C line 9

D line 8

E line 7
---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :DE
   var 只能用在區域變數class屬於全域變數

</div>

**↑↑↑**

---

###  Q56

given 

``` java 
interface MyInterface{
	void printone();
}
```
And

``` java
   //option A
   abstract class MyclassA implements MyInterface{
   	    public abstract void printone();
   }
   //option B
   class MyclassB implements MyInterface{
   	    private void printone(){
   	    	System.out.print("one");
   	    }
   }
   //option C
   class MyclassC implements MyInterface{
   	    public void printone(){
   	    	System.out.print("one");
   	    }
   }
   //option D
   abstract class MyclassD implements MyInterface{
   	    public void printone(){
   	    	System.out.print("one");
   	    }
   }
   //option E
   abstract class MyclassA implements MyInterface{
   	    public String printone(){
   	    	return "one";
   	    }
   }
   //option F

   class MyClasF{
   	   public void printone(){
   	   	 System.out.print("one");
   	   }
   }
```

which three classes successfully override printone()?(choose three)

A option A

B option B

C option C

D option D

E option E

F option F

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :ACD
   B 必須是public(封裝範圍不可縮小)

   E 需void

   F 未實作interface
</div>

**↑↑↑**

---

### Q57

``` java 

    class SomeKlass{
    	public void operation(){
    		System.out.print("SomeKlass:operation() ");
    	}
    }
    class AnotherKlass extends SomeKlass{
    	public void operation(){
    		System.out.print("AnotherKlass:operation()");
    	}
    }
    public class Test{
    	public static void main(String[] args) {
    		AnotherKlass ac = new AnotherKlass();
    		SomeKlass sc = new AnotherKlass();
    		ac = sc;
    		sc.operation();
    		ac.operation();
    	}
    }
```

what was the result?

A A classCastExcetion is thrown at runtime

B AnotherKlass:operation() AnotherKlass:operation()

C the compilation fails

D SomeKlass:opeeration() AnotherKlass:operation()

E AnotherKlass:operation() SomeKlass:opeeration()

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :C
    ac = sc

   沒轉型會編譯錯誤

   override是以實際型別為主 只有靜態方法因為使以類別為主所以會以宣告型別決定要實作的方法

</div>

**↑↑↑**

---

### Q58

given:

``` java

   public class OverloadLab{

   	   public void test(Object[] o){
   	   	System.out.print("this is an object array");
   	   }

   	   public void test(long[] l){
   	   	  System.out.print("this is a arrary");
   	   }

   	   public void test(Object o){
   	   	   System.out.print("this is a object");
   	   }
   	   public static void main(String[] args) {
   	   	    int[] arr = new int[1];
   	   	    new OverloadLab().test(arr);
   	   }
   }
```

what was the output

A this is an object array

B the compilation fails due to an error in line 1

C this is an array

D this is an object

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :D
   他會去搜尋契合度最高的int[] 和object最接近
   int[] 和 long[] 是完全不同的類別
   而int[] 又是object的子類 才會優先選object(object[] 不是int[] 的子類)

</div>

**↑↑↑**

---

### Q59

given:

``` java

    class DoubleNumber{
    	private final double value;
    	public DoubleNumber(String value){
    		this(Double.parseDouble(value));
    	}
    	public DoubleNumber(double value){
    		this.value = value;
    	}
    	public DoubleNumber(){
    	}
    	public double getValue(){
    		return value;
    	}
    }
```
And

``` java 

    public static void main(String[] args) {
    	DoubleNumber d1= new DoubleNumber("1.99");
    	DoubleNumber d2 = new DoubleNumber(0.99);
    	DoubleNumber d3 = new DoubleNumber();
    	System.out.print(d1.getValue()+", "+d2.getValue()+", "+ d3.getValue());
    }
````
what was the result?

A the compilation fails

B 1.99,0.99,0

C 1.99,0.99,0.0

D 1.99,0.99

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :A
   第九行編譯失敗在要是final沒給值他一定要在建構子有初始化的管道

</div>

**↑↑↑**

---

### Q60

given :

``` java

    class MySuper{
          protected MySuper(){
          	   this(2);
          	   System.out.print("1");
          }
          protected MySuper(int i){
          	System.out.print(i);
          }
    }
    public class MySub extends MySuper{
    	MySub(){
    		this(4);
    		System.out.print("3");
    	}
    	MySub(int i){
    		System.out.print(i);
    	}
    	public static void main(String[] args) {
    		new MySub(4);
    	}
    }
```
what was the result?

A 2134

B 2143

C 214

D 234

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :C
   
   子類別建構子執行前 先執行父類別建構子
   

</div>

**↑↑↑**

---