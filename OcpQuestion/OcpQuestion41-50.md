###  Q41

which two statements correctly describe capabilities of interface and abstract classes?(choose two)

A interface cannot have protected methods but abstract classes can 

B Both interfaces and abstract classes can have final methods

C interface connot have instance fields but abstracts classes can

D interface cannot have static methods but abstracts classes can

E interface cannot have methods with bodies but abstracts classes can

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :AC 

   介面的方法修飾詞只能是public private abstract default static strictfp 且可以有內容

   介面的欄位修飾詞只能是public static final 因此不會有實例變數欄位 所以c選項是正確的

  

</div>

**↑↑↑**

---

### Q42

given:

``` java

    enum GRADE{
    	A(100),B(75),C(50);
    	int persent;
    	private GRADE(int percent){
    		this.percent = percent;
    	}
    }
```

And

``` java
    static void checkgrade(GRADE g){
    	switch (g) {
    	case /* line 1 */
    		System.out.print("Great");
    		break;
    	default:
    		System.out.print("Not great");
    		break;
    		
    	}
    }
```

which code fragment can be inserted into line 1 to print great?

A GRADE.A.ValueOf()

B A

C A.toString()

D GRADE.A

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :B,D

   B 可以直接用enum的字代表 他相當於GRADE.A 在switch內(可簡化)
   但在switch外的話則只能用GRADE.A來表達

  

</div>

**↑↑↑**

---

### Q43

given: 

``` java 
   
   enum Letter{
   	 ALPHA(100),DELTA(200),OMICRON(300);
   	 int i;
   	 Letter(int i){
   	 	this.i = i;
   	 }
   	 /*line 1*/

   }
   public static void main(String[] args) {
   	System.out.print(Letter.values()[1]);
   }
```
what code should be written at line 1 for this code to print 200?

A public String toString(){return String.valueOf(ALPHA.i);}

B public String toString(){return String.valueOf(Letter.values()[1]);}

C public String toString(){return String.valueOf(i);}

D String toString(){ return "200"}

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :C
   原本就指定了Delta那需要的是他的欄位直所以覆寫toString方法可以直接取的他的屬性
  

</div>

**↑↑↑**

---

###  Q44

given :

``` java

   //option A
   @FunctionalInterface
   interface MyInterfaceA{
   	   public void run();
   }
   //optionB
   @FunctionalInterface
   interface MyInterfaceB{
   	   public void run();
   	   public void call();
   }
   //optionC
   @FunctionalInterface
   interface MyInterfaceC{
   	   public default void run(){}
   	   public void run(String s);
   }
   //optionD
   @FunctionalInterface
   interface MyInterfaceD{}
   //option E
   
   interface MyInterfaceE{
   	   @FunctionalInterface
   	   public void run();
   }
```
which two are funtionalinterface(choose two)

A MyinterfaceA

B MyinterfaceB

C MyinterfaceC

D MyinterfaceD

E MyinterfaceE

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :AC
   函數型介面只能存在1個抽象方法 是用來實作lamda表達式的

   default 方法是為了在已實現的介面加入新方法而不抱錯設立的

   期必須有寫入實作 而放入時才不會抱錯 有多個default跟static方法是可行的
  

</div>

**↑↑↑**

---

### Q45

``` java

   public static void main(String[] args) {
   	  var i = 1235; 
   	  var s = "" +i; 
   	  if("1235".equals(s))
   	  	System.out.print("Alpha");
   	  if("1235" == s)
   	  	System.out.print("Delta");

   }
```
what will be the output of this code

A does not complie

B prints nothing

C print Alpha only

D prints Alpha followed by "Delta"

E print Alpha only

F thrown the exception

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :C 
   
   只要 + 字串就會變成連接字串符號 所以 s會變成String 
   但他們的地址直不相同所以==不會相等
  

</div>

**↑↑↑**

---

### Q46

given:

```  java  

    public static void main(String[] args) {
    	int[] nums = {1,2,3,4,5};
    	output(nums);

    }
    private static void output(int[] nums){
    	//code block
    }
```

And

``` java

   //option A
   for (int i=0;++i<10&&i<nums.length ; ) {
   	 System.out.print(nums[i]);
   }
   //option B
   for (var i = 0; i<nums.length;i++){
   	 System.out.print(nums[i]);
   }
   // option C
   for(int i = nums.length;i>0;i--){
   	System.out.print(nums[i]);
   }
   //option D
   for(int j = 0,i=j;i<=nums.length -1;i++){
   	 System.out.print(nums[i]);
   }
   //option E
   for(var j = 0,i=j;i<= nums.length -1;++i){
   	 System.out.print(nums[i]);
   }
```

which of the following fragments can be inserted within the output() method,so that all the numbers form 1 to 5 are print on the console choose 2

A option A

B option B

C option C

D option D

E option E

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :BD
   
   A 將寫出1,2,3,4 2345 會直接從1開始印並在4的時候結束(每輪迴圈不會影響)

</div>

**↑↑↑**

### Q47


given :

``` java 

   class Super{

   	   private boolean checkValue(int val){
   	   	  return  true;
   	   }
   }
   class Sub extends Super{
          public int changeVal(int val){
          	 if(checkValue(val)){
          	 	return val;
          	 }else{
          	 	return 0;
          	 }
          }
   }
```
And

``` java

   public class Test{

   	    public static void main(String[] args) {
   	    	Sub b = new Sub();
   	    	System.out.print(b.changeVal(1));

   	    }
   }
```

what was the result?

A nothing

B it fails to compile

C 0

D A java.lang.IlegalArgumentException is thrown

E 10

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :B
   
  第八行錯誤 是private的父類方法沒辦法給子類別使用


</div>

**↑↑↑**

---

### Q48

given

``` java

   public static void main(String[] args) {
   	  StringBuilder sb = new StringBuilder();
   	  sb.append("Howdz");
   	  sb.insert(0,' ');
   	  sb.replace(3,5,"XX");
   	  sb.insert(6,"COW");
   	  sb.delete(2,7);
   	  System.out.print(sb.length());

   }
```
what was the result?

A 4

B 3

C an exception is thrown at runtime

D 5


---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :A
   
	  sb.append("Howdz")	"Howdz"	    5
	sb.insert(0, ' ')	" Howdz"	    6
	sb.replace(3,5,"XX")	" HoXXz"	6
	sb.insert(6,"COW")	" HoXXzCOW"	    9
	sb.delete(2,7)	" HoW"	            4         
   其描述的索引 第一個都包含本身 最後一個不包含

</div>

**↑↑↑**

---

### Q49

given:

```   java

    public static void main(String[] args) {
    	var list = new ArrayList<String>();
    	list.add("one");
    	list.add("two");
    	//line 5
    	for(var s : list){
    		System.out.print(s);
    	}
```

which of the following options can be added to line 5 for the code to compile and run correctly?

A list.add(3);

B list.add(String.valueOf("3"))

C list.add(Integer.valueOf(3));

D list.add(Integer.parseInt("3"));

E list.add(3,"three");

F None of these

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :B
   只能放入String 型態
   E 因為長度為2會拋出IndexOutofBoundsExceptions
	 

</div>

**↑↑↑**

---

### Q50

given:

``` java 

   package a;
   public class Employee{
   	  protected Employee(){ //line 3

   	  }
   }
``` 

And 

``` java 

   package b;
   import a.Employee;
   public class Main{
   	    public static void main(String[] args) {
   	    	Employee p = new Employee(); //line 10
   	    }
   }
```

which two allow b.Main to allocate a new employee(choose two)

A in line3,change the access modifer to private

private Employee()

B in line3,change the access modifer to public

public Employee()

C in line8 add extends Employee to the main class
and change line 10 to create a new Main object

public class Main extends Employee

Employee p = new Main();

D in line 8,change the access modifier to protected

protected class Main

E in line 1,remove the access modifier

Employee()

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :BC
   建構子以protect宣告 只有繼承關西才能跨package 存取 
   將B 升為public也是一種方式
	 

</div>

**↑↑↑**

---
