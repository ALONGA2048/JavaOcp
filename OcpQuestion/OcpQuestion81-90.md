### Q81

given "while" loop samlpe :

``` java

   int x = 0;
   while(x<10){
   	    System.out.print(x++);
   }
```

And following "for" loops:

``` JAVA
    public static void main(String[] args) {
    	//option A
    	int a = 0;
    	for(;a<10;){
    		System.out.print(++a);
    	}
    	//option B
    	for(b;b<10;b++){
    		System.out.print(b);
    	}
    	//option C
    	for(int c = 0;c<10;){
    		System.out.print(c);
    		++c;
    	}
    	//option D
    	for(int d = 0;; d++){
    		System.out.print(d);
    		if(d==10){
    			break;
    		}
    	}
    }
```

which "for" loop produces the same output as "while" loop?

A optionA

B option B

C option C

D option D

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :C

   while會印出012-9的數字

   A 會從1開始

   B 會報錯(未定義變數)

   D 會印出10

</div>

**↑↑↑**

---

### Q82

given 

``` java

    public static void main(String[] args) {
    	String[][] color2drr={
            {"Brown","Pink"},{"Black"},{"Blue","Yellow","Green","Grey"}
    	};
        for(int row = 0;row< color2drr.length;row++){
        	int column = 0;
        	for(;column < color2drr[row].length;column){
        		System.out.print("["+row+","+column+"]="+color2drr[row][column]+" ");
        	}
        }
    }
```

what is the result?

A [0,0]=Brown [0,1]=Pink [1,0]=Black [,1]=Blue [2,0]=Yellow [2,1]=Green [3,0]=Grey

B [0,0]=Brown [1,0]=Black [2,0]=Blue

C java.lang.ArrayOutOfBoundsException is thrown

D [0,0]=Brown [0,1]=Pink [1,0]=Black [2,0]=Blue [2,1]=Yellow [2,2]=Green [2,3]=Grey

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :D

   內部迴圈只是提出宣告變數依然持續迴圈 

   在二階陣列中array.length提出第幾行 

   在array[row].length 提出第幾列 

   
</div>

**↑↑↑**

---

### Q83

given:

``` java

    interface MyInterface{
    	abstract void x ();
    }
    abstract class ClassB /* position 1*/{
    	/* position 2*/
    	public void x(){}
    	public abstract void z();
    }
    class ClasssC extends ClassB implements MyInterface{
    	/* position 3*/
    }
```
which code when inserted at one or more marked positions ,would allow ClassB and ClassC compile?

A @override // position 3

 void x(){} // position 3

 @override // position 3

 public void z(){} //position 3

B @override // position 2

 public void z(){} //position 3

C implements MyInterface //position 1

 @override //position 2

D public void z (){} //position 3

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :D

   因為有 extends classB 而取得實作x方法 唯一需要實作的事void z()方法 所以選D

   A x Override需要public 否則 protected 權限縮小錯誤

   B 要加@override position 1 必須要有 implements MyInterface 所以B 錯誤

   C 沒有z方法
   
</div>

**↑↑↑**

---

### Q84

given:

``` java

    public class  Exam{
    	private final int a = 9;
    	static final int b;
    	public Exam(){
    		System.out.print(a);
    		System.out.print(b);
    	}
    }
    	public static void main(String[] args) {
    		new Exam();
    	}
```

what is the result

A 9

B the compilation fails at line 3

C the compilation fails at line 9

D the compilation fails at line 6
   
---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :B

   static 的final 變數 必須要在宣告時給值 或在static區塊內給值 否則報錯
   
</div>

**↑↑↑**

---

### Q85

given :

``` java

    class GameObject{
    	public Object[] moveto(int x,int y){
    		System.out.println("MoveTo GameObject");
    		return new Integer[] {x+5,y+5}
    	}
    }
    class DeskGame extends GameObject{
    	public Object[] move(Number x,Number y){
    		System.out.println("MoveTo DeskName");
    		return  super.moveto(x.intValue(),y.intValue());

    	}
    }
```
And

``` java

    public  class Test{
    	public static void main(String[] args) {
    		var game = new DeskGame();
    		game.move(5.0,5.0);
    		game.moveto(5,5);
    	}
    }
```

what is the result?

A

    Moveto GameObject

    Moveto GameObject

B
   Moveto DeskGame

   Moveto GameObject

   Moveto GameObject

C

    Moveto GameObject

D

    Moveto GameObject

    Moveto DeskGame

    Moveto GameObject

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :B

   3用var宣告 game推測型別為Deskgame

   Test 行4呼叫move 行5 呼叫 moveto方法
   
</div>

**↑↑↑**

---

### Q86

given:

``` java

    public static void main(String[] args) {
    	int x = 0;
    	for(;x<10;x++){
    		System.out.print(++x + " ");
    	}
    }
```

what was the result?

A 1 3 5 7 9

B 1 3 5 7 9 11

C 2 4 6 8 10

D 2 4 6 8

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :A

   x++ 是先印出x後再加數字

   ++x 則會先運算過後再加1
   
</div>

**↑↑↑**

---

### Q87

given:

``` java

    class Item{
    	private String name;
    	public Item(String name){
    		this.name;
    	}
    }
```

And :

``` java

    public class Test{
    	public static void main(String[] args) {
    		Item[] items = createItemArray()
    		/* line 1 */
    		for(Iten t: items){
    			System.out.print(t);
    		}
    	}
    	private  static Item[] createItemArray(){
    		Item[] items = new Item[3];
    		items[0] = new Item("Hat");
    		items[1] = new Item("Rat");
    		items[2] = items[0];
    		items[0] = new Item("Cat");

    	}
    }
```

how many item objects are eligible for garbage collection in line 1?

A 3

B 2

C 0

D 1

E 4

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :D

   有多少物件有資格被資源回收

   在items的創建下 items[1]最後被指向hat 使他創建的Rat無人連接使用 可以進行回收處理
   
</div>

**↑↑↑**

---

### Q88

given:

``` java

    class MySuper{
    	protected MySuper(){
    		this(2);
    		System.out.print("3");
    	}
    	protected MySuper(int i){
    		System.out.print(i);
    	}
    }

    class MySub extends MySuper{
    	MySub(){
    		this(4);
    		System.out.print("1");
    	}
    	MySub(int i){
    		System.out.print(i);
    	}
```

And:

```  java

    public static void main(String[] args) {
    	new MySub(4);
    }
```

What is the result

A 2134

B 234

C 2341

D 214

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :B

   要先呼叫父建構子所以會呼叫super()之後才繼續執行
   
</div>

**↑↑↑**

---

### Q89

given:

``` java

   class Plant{

   }
   class Tree extends Plant{
   }
```

And :

``` java 

    public class Garden{
    	private static Plant plant;
    	public static void main(String[] args) {
    		plant = new Tree();
    		feed(plant);
    		feed(plant);
    	}
    	public static void feed(Plant p){
    		if(p instanceof Tree){
    			System.out.print("is a tree, ");
    		}

    		p=null;
    	}
    }
```

what is the result?

A is a tree

B the program prints nothing

C is a tree,is a tree

D An exception thrown at runtime

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :C

   若feed中是針對plant進行修改則會改變 但她只對區域變數做所以不會有任何影響
   
</div>

**↑↑↑**

---

### Q90

given:

``` java

   public static void main(String[] args) {
   	  StringBuilder sb = new StringBuilder("MMNOOPQQ");
   	  int i = 0;
   	  a:
   	  while(i<sb.length()){
   	  	char x = sb.charAt(i);
   	  	int j = 0;
   	  	i++;
   	  	b:
   	  	while(j<sb.length()){
   	  		char y = sb.charAt(j);
   	  		if(i != j && y==x){
   	  			sb.deleteChatAt(j);
   	  			//line1
   	  		}
   	  		j++;
   	  	}
   	  }
   	  System.out.print(sb);
   }
```
which two statement inserted independently at line 1 enable this code to print MOOQ?

A i--;

B countinue b;

C break b;

D j--;

E continue a;

F break a;

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :CE

   a: b: 叫做label可以指定迴圈 

   而CE他們兩個的意義相同 希望刪除一個就好而馬上進入下一個迴圈
   
</div>

**↑↑↑**

---
