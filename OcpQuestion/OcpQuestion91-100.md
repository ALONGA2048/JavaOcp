### Q91

given:

``` java

   public class Exam{

   	    enum Machine{
   	    	AUTO("Car"),MEDICAL("Printer");
   	    	private String type;
   	    	private Machine(String type){
   	    		this.type = type;
   	    	}
   	    	public String getType(){
   	    		return type;
   	    	}
   	    	public void setType(String type){
   	    		this.type = type; //line 1
   	    	}
   	    }
   	    public static void main(String[] args) {
   	    	Machine.Auto.setType("abcd");
   	    	for(Machine p : Machine.values()){
   	    		System.out.println(p+":"+p.getType()); //line 3

   	    	}
   	    }
   }
```
A an exception is thrown in runtime

B AUTO:abcd

MEDICAL:Printer

C the compilation fails due to an error on line 2

D the compilation fails due to an error on line 1

E AUTO:Car

MEDICAL:Printer

F the compilation fails due to an error on line 3
    
---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :B

   因為列舉型別的列舉項目是public static 和final 

   所以在更改type後會實際更改其type而印出
   
</div>

**↑↑↑**

---

### Q92

given:

``` java

    interface MyInterface{
    	void showTest();
    }
```

And:

``` java

    //option A
    abstract class MyClassA implements MyInterface{
    	public String showTest(){
    		return "test";
    	}
    }

    //option B
    abstract class MyClassB implements MyInterface{
    	public void showTest(){
    		System.out.print("test");
    	}
    }
    //option C
    class MyclassC implements MyInterface{
    	void showTest();
    }
    //option D
    class MyclassD implements MyInterface{
    	private void showTest(){
    		System.out.print("test");
    	}
    }
    //option E
    abstract class MyClassB implements MyInterface{
    	   public abstract void showTest();
    }
    //optionF
    class MyclassF implements MyInterface{
    	public void showTest(){
    		 System.out.print("test");
    	}
    }
```

which three classes successfully override showTest()?

A optionA

B optionB

C optionC

D optionD

E optionE

F optionF

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :BEF

   override條件是名稱加上參數完全一樣

   存取型態必須更高或相同

   回傳的型態跟拋出例外 要相同或是子類別

   A 回傳參數必須是void

   C class實現 就必須實作內容

   D 封裝型態小於public
   
</div>

**↑↑↑**

---

### Q93

given:

``` java

    public static void main(String[] args) {
    	char[][] arr2d = {{'a','b'},{'c','d'},{'e','f'}};
    	for(char[] arr1d:arr2d){
    		for(char c: arr1d){
    			System.out.print(c);
    		}
    		System.out.print(" ");
    	}
    }
```
what is the result?

A An arrayIndexOutsideOfBoundsException is thrown in runtime

B the compilation fails

C ac eb df

D ab cd ef

E ace bdf

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :D

   第一層for呼叫第一列 第二層呼叫第二行 進行打印 每一行結束一個空格[] [] 的概念
</div>

**↑↑↑**

---

### Q94

given:

``` java

    interface Printer{
    	public default void print(String msg){
    		System.out.println("Message from printer:"+msg);
    	}
    	abstract class AbstractPrinter{
    		protected void print(String load){
    			System.out.print("Message from Abstract Printer: "+load);
    		}
    	}
    }
```

And:

``` java

    public class PrinterImpl extends AbstractPrinter implements Printer{
    	public static void main(String[] args) {
    		PrinterImpl test = new PrinterImpl();
    		test.print("Good day");
    	}
    }
```

what is the output

A compilation error

B Message from Printer:Good Day

C Message from Abstract Printer: Good day

D A runtime error is thrown

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :A 

   java會以父類別覆寫介面方法 但因protected無法遮蔽public 而編譯失敗

</div>

**↑↑↑**

---

### Q95

given:

``` java 
    interface Calculator{
    	public int Calc(int a,int b);
    }
```
And:

``` java

    public static void main(String[] args) {
    	int result = 0;
    	// line 1
    	result = c.Calc(30,40);
    	System.out.println(result);
    }
```
which two options,independently can be inserted in line 1 to compile?

A Calculator c = (int x,int y)->{x乘y}; //乘號會報錯所以用中文代替

B Calculator c = (int x,int y)->{return x乘y;};

C Calculator c = (x,y)->x乘y;

D Calculator c = x,y-> x乘y;

E Calculator c = (int x,y)->{return x乘y;};

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :BC

   lamda表達式用法 前面一定要加括弧 參數宣告可寫可不寫 箭頭後的大括號 有寫一定要return 沒寫不用

</div>

**↑↑↑**

---

### Q96

given:

``` java 

    public class Test{
    	static StringBuilder sb1 = new StringBuilder("d ");
    	StringBuilder sb2 = new StringBuilder("c ");
    	StringBuilder foo(StringBuilder s){
    		System.out.print(s+"b "+ sb2);
    		return new StringBuilder("e");
    	}
    	public static void main(String[] args) {
    		sb1 = sb1.append(new Test().foo(new StringBuilder("a ")));
    		System.out.println(sb1);
    	}
    }
```

what is the result

A a b c e 

B a b c

C A compile error

D d e

E b c a

F a b c d e

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :F

   可以累加進去 append寫出方法所以ab1會在原本的d上再加e

</div>

**↑↑↑**

---

### Q97

given:

``` java

    public class Test{
    	static int myInt = 999;
    	public static void main(String[] args) {
    		int myInt = myInt;
    		System.out.print(myInt);
    	}
    }
```
what is true

A the code does not compile successfully

B it prints 999

C the codes compiles and runs successfully but with a wrong answer(bug)

D code compiles but throws a runtime exception when run

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :A

   main方法內獨自宣告直所以跟static變數沒有關西 但他自己給自己值所以錯誤

   the local varible myInt may not have been initialized


</div>

**↑↑↑**

---

### Q98

given:

``` java

    public class Test{
    	public void output(byte v){
    		System.out.println("byte value is "+v);
    	}
    	public void outpt(short v){
    		System.out.println("short value is " + v);
    	}
    	public void output(Object v){
    		System.out.println("Object values is "+ v);
    	}
    	public static void main(String[] args) {
    		byte x = 27;
    		short y = 13;
    		new Test().output(x+y);//line 1
    	}
    }
```
what is the output

A Short value is 40

B the compilation fails due to an error in line1

C Byte value is 40

D Object value is 40

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :D

  java在計算 byte short char會自動升級數字 成int進行計算(int不能降級去合適 所以相似度較object低)

  所以最終會選擇object Interger子類別


</div>

**↑↑↑**

---

### Q99

given:

``` java

    interface MyInterface{
    //option A
    	final void methodA();
    //option B
    	public void methodB(){
    		System.out.print("B");
    	}
    //option C
    	public abstract void methodC();
    //option D
    	private  abstract void methodD();
    //option E
    	public  int E;
    //optionF
    	public String methodF();
    //option G
    	final void methodG(){
    		System.out.print("G");
    	}
    }
```

which two statments are vaild to be written in this interface?

A option A

B option B

C option C

D option D

E option E 

F option F

G option G

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :CE

  A 方法不可以是final

  B 預設abstract 不可以有實做方法

  D 不可以有 private 

  E 欄位必定要public static final

  G 不可以是 final


</div>

**↑↑↑**

---

### Q100

given:

``` java

    package p1;
    public class A{
    	public int x = 52;
    	protected A(){} //line 1
    }
```
And

``` java 

    package p2;
    import p1.A;
    public class B extends A{
    	int x = 27;//line 2
    	public B(){super();}; //line 3
    }
```

And :

``` java 

    import p1.A;
    import p2.B;
    public class Test{
    	public static void main(String[] args) {
    		A obj = new B(); //line 4
    		System.out.print(obj.x); //line 5
    	}
    }
```

what is the result

A the compilatin fail due to an error in line 1

B the compilatin fail due to an error in line 2

C the compilatin fail due to an error in line 3

D the compilatin fail due to an error in line 4

E the compilatin fail due to an error in line 5

F 52

G 27 

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :F

   欄位遮蔽效應line2 可以通過編譯

   A 的 protected 建構函數可以被 B 存取，所以 super(); 不會報錯。

   B 物件 可以當作 A 來使用（因為 B extends A）。

   x 變數是 變數遮蔽（hiding），不受多型影響，所以 obj.x 取的是 A.x，值為 52。

   所有語法都是合法的，因此程式碼成功編譯！


</div>

**↑↑↑**

---