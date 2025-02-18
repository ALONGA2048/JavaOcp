## Ocp 題目及解答過程

---

### Q1

---

give

``` java
   public static void main (String[] args){
   	int a;
   	int b = 5;
   	if(b>2){
   		a = ++b;
   		b = a + 7;

   	}else{
   		b++;
   	}
   	System.out.println(a+" "+b);
   }
```
what was the result

A :complilation error

B:0 5 

C:6 13

D:5 12

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :A 
   
   編譯失敗 沒有設初始值 在第五行時在if else區塊內 所以無法確定是否有正確給值

</div>

**↑↑↑**

---

### Q2

given:

``` java

 public class DNASynch {
 	int acount;
 	int tcount;
 	int ccount;
 	int gcount;
 	DNASynch(int a,int tcount,int c,int g){
 		//line 1
 	}
    int setCCount(int c){
    	return c;

    }
    void setGCount(int gCount){
    	this.gCount = gCount;
    }
 }
```
which two lines of code when inserted in line 1 correctly modifies instance variables ?
A.setCCount(c) = cCount;
B.tcount = tcount;
C.acount = a;
D.setGcount(g);
E.cCcount = setCCount(c);

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
  ans :CD

  A 附值顛倒錯誤

  B 錯誤沒意義

  E 乍看是對的 但方法回傳值後並不會修改到欄位值 當後面接方法時他就不會視其為欄位值了

</div>

**↑↑↑**

---

### Q3 

given

``` java
    public static void main(String [] args){
    	char c = 'b';
    	int i = 0;
    	switch (c){
    	case 'a':
    		i++;
    		break;
    	case 'b':
    		i++;
    	case 'c' | 'd' : //line 1
    		i++;
    	case 'e':
    		i++;
    		break;
    	case 'f';
    		i++;
    		break;
    	default :
    		System.out.println(c);

    	}
    	System.out.println(i);
    }
```
What was the result

A b1

B 2

C b2

D 1

E b3

F 3

G the compilation fails due to an error in line1

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
  ans :F 

  java switch 有fall-through 如果沒有break 程式會從符合的case一路往下執行

</div>

**↑↑↑**


---

### Q4

given:

``` java
   public static void main (String[] args){
   	   int a = 0;
   	   do{
   	   	 a++;
   	   	 if(a==1){
   	   	 	continue;

   	   	 }
   	   	 System.out.println(a);

   	   }while(a<1)
            
   	   
   }
```
what was the result ?

A 01

B 0

C 1

D the program prints nothing 

E it prints 1 in the infinite loop.

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
  Ans : D
  
  在contiune出現後後面的程式碼都直接忽略

</div>

**↑↑↑**

---

### Q5

given 

``` java 
    
    public static void main(String... args){
    	//任意直可變化型別
    	for(var y:args){
    		System.out.println(y);
    	}
    }
```

what is the type of the local variable y?

A Character

B char

C String []

D String

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans D 

   var 關鍵字可以推導型別 以 右側判斷 (如python

   String ... 則可以視為 String [] 只是沒有限制數量 傳入多少就多少 以多個參數的話只能當最後一個
  
</div>

**↑↑↑**

---

### Q6

given: 

``` java
    
    public class Exam{
    	static String prefix = "Hello";

    	private String name = "World ";

    	public static String getname(){
    		return new Exam.name;
    	}
    	public static void main(String [] args){
    		Exam q = new Exam();
    	    System.out.println(/*insert code here*/);
    	}
    }
```
which two options can you insert inside println() method to produce Helloworld? (Choose two.)

A Exam.prefix +Exam.name

B new Exam().prefix + new Exam().name

C Exam.prefix + Exam.getname()

D Exam.getname + prefix

E prefix + Exam.name

F prefix + name

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans BC 

   ### 記住兩個要點  

   - 靜態欄位可以用 創物件呼叫 也可以直接用類別呼叫

   - 物件欄位只能用創建物件的方式創建

</div>

**↑↑↑**


---


### Q7

given

``` java
    
    class Super{
      
       public void x(){
            print();
       }
    
       private void print(){
          System.out.println("Bonjour le monde!");

       }
    }
    class Sub extends Super{
        public void y(){
            print();
        }
        private void print(){
             System.out.print("Hello world!");
        }
    }  
    
    public static void main(String[] args){
       Sub b = new Sub();
       b.x();
       b.y();
    }
```
what is the output?

A hello world! Bonjour le monde !

B Hello world! hello world !

C Bonjour le monde! Hello world!

D Bonjour le monde! Bonjour le monde!

--- 

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans : c

   因為父類方法print是private所以無法覆寫 

   如果改為protect or public就可以

</div>

**↑↑↑**



---

### Q8

given 

``` java
    public void stuff() throws StuffException{

       //...
    }
```

and omitting the throws stuffException clause results in a compilation error. which statements is true about stuffException?

A.StuffException is a subclass of runtimeError

B.StuffException is unchecked

C. the body of stuff() can only throw StuffException

D. the body of stuff() can only throw StufffException or its subclass

---
### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans : D

  因為一般的異常會在編譯時期強制你拋出Exception(checked Exception已知錯誤)強制你安全 

  除非是運行後才會知道的錯誤(unchecked Exception未能防範錯誤) 如NullPointerException ArrayIndexOutOfBoundsException 才不會設置throwable
  異常結構圖

``` php

java.lang.Throwable  <-- 最上層父類別
│
├── java.lang.Exception  <-- 已檢查異常（Checked Exception）
│   ├── java.lang.RuntimeException  <-- 未檢查異常（Unchecked Exception）
│   │   ├── NullPointerException
│   │   ├── ArrayIndexOutOfBoundsException
│   │   ├── ArithmeticException
│   │   ├── ClassCastException
│   │   ├── ...
│   │
│   ├── IOException
│   ├── SQLException
│   ├── ParseException
│   ├── ...
│
└── java.lang.Error  <-- 錯誤（Error，通常表示系統級問題）
    ├── OutOfMemoryError
    ├── StackOverflowError
    ├── VirtualMachineError
    ├── ...

```

</div>

**↑↑↑**


---

### Q9

Which describes an aspect of java that contributes to high performance?

A.java prioritizes garbage collection

B.java has a library of built-in funtions that can be used to enables pipeline burst execution 

C.java monitors and optimizes codes that is frequently executed

D.java automatically parallelizes code execution

### 中翻

哪一個敘述描述了 Java 有助於提升效能的特性？

A. Java 優先執行垃圾回收（Garbage Collection, GC）

B. Java 具有內建函式庫，可用於實現流水線突發執行（pipeline burst execution）

C. Java 監測並優化頻繁執行的程式碼

D. Java 自動將程式碼並行執行（parallelizes code execution）

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :C

   A 確實會移除不需要的記憶體使用 但對執行時需要的高效能幫助不大

   B 只針對特定的功能 與本身優化無關

   D 必須藉由程式碼實作或指定 非自動 如Threads,ExecutorService

   C java 具有許多提升效能的機制，其中最重要的機制之一是 JIT（Just-In-Time 編譯器），它會監測並優化頻繁執行的程式碼，提高執行效率

</div>

**↑↑↑**



---

### Q10

given:

``` java

    public class Methodlab{
       //line 1
    }
    public void methodA(){
       System.out.println("methodA");
    }
    public String methodB(){
      System.out.println("methodB");
    }
    public void methodC(){
      return i++;
    }
    public boolean methodD(int x){
       return x >0;
    }
    public char methodE(String msg){
      return msg;
    }
```
which two method implementations are correct when insertes independently in line 1?(choose two)

A: methodA

B methodB

C methodC

D methodD

E methodE

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans : A D

   b沒有回傳值

   C不知道 i是甚麼

   E 回傳的型態錯誤

</div>

---

**↑↑↑**