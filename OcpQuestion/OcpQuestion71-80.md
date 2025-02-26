### Q71

given:

``` java 

    public static void main(String[] args) {
    	String s1 = new String("Java");
    	String s2 = "Java";
    	String s3 = s1.intern();
    	System.out.print((s1==s2)+" ");
    	System.out.print((s2==s3)+" ");
    	System.out.print((s1==s3)+" ");
    }
```
what was the result?

A false true true

B true false false

C false false true

D false true false

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : D
   
   new方法會創建一個String物件

   而s2創建後則是不可更改的存放在字串池

   s3則是去字串池用equal找有沒有相同的如果沒有就在字串池再建立一個

   因此s1不涉及字串池,s2,s3都涉及字串池可重複使用 s1!=s2 s2=s3 s1!=s3

</div>

**↑↑↑**

---

### Q73

given:

``` java

    public static void main(String[] args) {
    	var x = 10;
    	var y = 5;
    	x+=(y * 5 + y) /x-2;
    	System.out.print(x);
    }
```
what was the result

A 5

B 3

C 23

D 25

E 11

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : E 

   注意運算子的運算順序 最終直為11

</div>

**↑↑↑**

---

### Q73

``` java

    public class Exam{
    	private int a;
    	private static int b ;
    	public static void main(String[] args) {
    		Exam t1 = new Exam();
    		t1.a = 2;
    		Exam.b = 3;
    		Exam t2 = new Exam();
    		t2.a = 4;
    		t2.b = 5;
    		System.out.print(t1.a+","+t1.b+" ");
    		System.out.print(t2.a+","+Exam.b+" ");
    		System.out.print(t2.a+","+t1.b+" ");
    	}
    }
````
what is the result

A 2,3 4,3 4,5

B 2,3 4,5 4,5

C 2,5 4,5 4,5

D 2,3 4,5 4,3

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : E 

   注意運算子的運算順序 最終直為11

</div>

**↑↑↑**

---

### Q74

given:

``` java 

    interface MyFunInterface{
    	double getFunValue();
    }
```

``` java

   public class Test{
   	    public static void main(String[] args) {
   	    	MyFunInterface myfun;
   	    	myfun = ()->"3.14159";
   	    	System.out.print("value of Myfun = " + myfun.getFunValue());
   	    }
   }
```
A it throws a runtime exception

B value of Myfun = 3.14159

C the code does not compile

D value of Myfun = "3.14159"

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : C

   行4編譯失敗 應回傳double 而非 String 

   lamda表達式能直接實作抽象方法() -> "實作的回傳值" (要操作回傳的內容跟方式)

</div>

**↑↑↑**

---

### Q75

given:

``` java

   public class Exam{
   	    public static void main(String[] args) {

   	    	System.out.println(args[1]+"--"+args[3]+"--"+args[0]);
   	    }
   }
```
executed using this commend

``` cmd

   java Exam my pen is red
```

what was the output of this class ?

A pen--red--my

B my--pen--is

C my--is--java

D java--Exam--my

E Exam-pen--red

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : A

   陣列參數是0開始計算 所以 my pen is red (0 1 2 3)

</div>

**↑↑↑**

---

### Q76

which describes a characteristic of setting up the java development environment ?

A setting up the java development environment requires that you also install the JRE 

B the java development environment is set up for all operating systems by default 

C you set up the java development environment for a specific operating system when you install jdk

D setting up the java development environment occurs when you install an ide before the jdk

### 中翻

以下哪項描述了設定 Java 開發環境的特點？

A. 設定 Java 開發環境時，還需要安裝 JRE。

B. Java 開發環境預設適用於所有作業系統。

C. 當你安裝 JDK 時，會為特定的作業系統設定 Java 開發環境。

D. 當你在 JDK 之前安裝 IDE 時，就會完成 Java 開發環境的設定。

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : C

   A jdk已經包含jre不用再額外安裝
   B jdk各種作業系統版本並不是都可以一個套用

   D ide只是編寫程式碼的工具部會幫你設定jdk環境需要額外下載

</div>

**↑↑↑**

---

### Q77

given:

``` java

package lab.p1;

public class Super{
   public int x = 42;
   protected Super(){} //line1
}
```
And:

``` java

package lab.p2;

import lab.p1.Super;

public class Sub extends Super{
   int x = 10; //line2
   public Sub() {Super();} //line3

}
```

And:

``` java
package  lab;
import lab.p1.Super;
import lab.p2.Sub;

public class Exam{

   public static void main(String[] args) {
      Super obj = new Sub(); //line4
      System.out.print(obj.x); //line 5
   }
}
```
what is the result

A 42

B the compilation fails due to an error in line 4

C 10

D the compilation fails due to an error in line 3

E the compilation fails due to an error in line 2

F the compilation fails due to an error in line 1

G the compilation fails due to an error in line 5

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : A

   在物件中只有方法可以覆寫
   欄位是不會覆寫而互相獨立的
   呼叫物件方法時有覆寫功以實際型別為重
   呼叫物件欄位的時候 以宣告型別為重

</div>

**↑↑↑**

---

### Q78

given:

``` java

public static void main(String[] args) {
   char[][] arrays = {{'1','4'},{'2','5'},{'3','6'}};
   for(char[][] xx :arrays){
      System.out.print(yy);
   }
   System.out.print(" ");
}
```
what is the result

A 12 34 56

B an arrayindexOutofboundsException is thrown at runtime

C the compilation fails

D 123 456

E 14 25 36

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : E

   會按照順序印出

</div>

**↑↑↑**

---

### Q79

given:

``` java

    public class Exam{
          public static void main(String[] args) {
              System.out.print(args[0]+args[1]+args[2]);
          }
    }
```
executed using commend

``` cmd 
   java Exam "Good Day" Good day
```
A an exception is thrown at runtime

B Good DayGood Day

C Good Day Good Day

D Good DayGoodDay

E GoodGood DayGoodDay

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :D

   第一以字串相連後面都是獨立字串

</div>

**↑↑↑**

---

###  Q80

given:

``` java

    public static void main(String[] args) {
       String str = "this is it";
       int i = str.indexOf("is");
       str.subString(i+5);
       i = str.indexOf("is");
       System.out.println(str+" "+ i);
    }
```
what is the result

A is it 1

B An indexOutOfBoxBoundsException is thrown at runtime

C is it 0

D this is it 2

E this is it 5

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :D

   str.indexOf("is") 出現這個字串的最初位子012 -> 回傳2
   str.subString(i+5); 會回傳第幾索引的字符 (因String不可改變所以String本身不會被影響


</div>

**↑↑↑**

---

