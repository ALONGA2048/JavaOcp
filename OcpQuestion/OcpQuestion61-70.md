###  Q61

which statement about access modifiers is correct?

A an instance variable can be declared by static modifier

B an local variable can be declared with the final modifier

C an abstract method can be declared with the private modifier

D an inner class cannot be declaered with the public modifier

E an interface can be declared with the protected modifier


---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : B
   
   A 實例變數是屬於物件不能用靜態宣稱

   C 抽象類必定要繼承 不能用private

   D 密名內部可以用public宣告

   E 介面唯獨不能被protect宣稱
   

</div>

**↑↑↑**

---

### Q62

given

``` java

    class Employee{
    	private String name;
    	public void setName(String name){
    		String title = "Dr. ";
    		name = title + name;

    	}
    	public String toString(){
    		return name;
    	}

    }
```
And 

``` java 

     public static void main(String[] args) {
     	Employee p = new Employee();
     	p.setName("who");
     	System.out.print(p);
     }
```
what was the result?

A Dr. who

B Dr. null

C an exception is thrown in runtime

D null

### Q63

given:

``` java

    public class Exam{
    	private int sum;
    	public int calculate(){
    		int x = 0;
    		while(x<3){
    			sum+=x++;
    		}
    		return sum;
    	}
    }
    public static void main(String[] args) {
    	Exam t = new Exam();
    	int sum = t.calculate();
    	sum = t.calculate();
    	t.calculate();
    	System.out.print(sum);
    }
```
what was the result?

A 9

B an exception is thrown at runtime

C 3

D 6

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : D

   int 類別欄位會自動初始化 只有區域變數不會(final則一定會)

   static也會自動復職 

   行12,13分別有用main中的sum更新其成員欄位的值

   但第14行沒有 所以 只有更新到6

</div>

**↑↑↑**

---

### Q64

given:

``` java

    package a;
    public abstract class Animal{
    	protected abstract void eat();

    }
```
and 

``` java 

	package b;
	import a.Animal;
	public abstract class Tiger extends Animal{
		//line 1

	}
```
which two lines inserted in line 1 will allow this code to compile?(choose two)

A protected void eat(){}

B void eat(){}

C abstract void eat();

D private void eat(){}

E public abstract void eat();

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : AE

   覆寫權限只能大於原本的權限 所以要protected以上
   而BC都是default

</div>

**↑↑↑**

---

### Q65

given:

```  java

    public class Test{
    	public static void main(String[] args) {
    		int a = 4;
    		int b = 2;
    		System.out.print(a+b+"=(a+b)"+a+b);

    	}
    }
```
what was the result

A an exception is thrown at runtime

B 42=(a+b)=42

C 42=(a+b)=6

D 6=(a+b)=42

E 6=(a+b)=6

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : D

   運算子在沒遇到字串都是運算符號 遇到後直接變成字串串聯符號

</div>

**↑↑↑**

---

### Q66

given:

``` java 

    public static void main(String[] args) {
    	byte x=8,y=7;
    	//line1
    	System.out.print(z);
    }
```
which expression when added at line 1 will produce the output of 1.14?

A float z = (float)(Math.round((float)x/y乘100)/100);

B float z = Math.round((int)(x/y),2);

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : D

   Math方法會還傳int整數所以BC都沒辦法

   而A 是在運算完成回傳int後才強轉float

   應該要在除數或被除數中有float的話結果也會轉為float表示

</div>

**↑↑↑**

---

### Q67

``` java 
    public class Exam{
        public static void main(String[] args) {
            int i = 0;
            for(String s : args){
                System.out.print((i++) + ")" + s +" ");
            }
        }
    }
    
```
executed with this commend

``` cmd
    java Exam one two three
```
what was the output of this class?

A the compilation fails

B 0)one 1)two 2)three

C A java.lang.ArrayIndexOutOfboundsException is thrown

D 0)one

E nothing


---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : B

   會先執行print方法之後才會執行i的遞增 故b正確

</div>

**↑↑↑**

---

### Q68

which three initialization statements are correct(Choose three)

A int x = 12_21;

B short sh = (short)'A';

C String contact# = "(999(111)";

D boolean true = (2==2);

E float x = 1.99;

F int[][] e = {{3,3},{2,2}};

G byte b = 10; char c = b;

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : ABF

  B char本來就可以轉成數字ASSKCode

  C 變量不可以有特殊符號

  D 不可為關鍵字

  E float的型態為1.99f 正常紓解都為double long->1.99l

  G byte不能自動轉換 要先強轉不然會抱錯

</div>

**↑↑↑**

---

### Q69

given:

``` java 

    public class Test{
        static void print(int ... arr){
            System.out.print("int[]...");
        }
        static void print(long l1,long l2){
            System.out.print("long,long");
        }
        static void print(Integer i1,Integer i2){
            System.out.print("Integer,Integer");
        }
        public static void main(String[] args) {
            int i = 9;
            print(i,i);
        }
    }
```
what was the result of comiling and running the following code ?

A does not compile

B print int[]...

C print long,long

D print Integer,Integer

E Throws Exception

F none of these

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : C

   符合參數數量優先 再來是基本型別高於包裝型別 所以C 先選

</div>

**↑↑↑**

---

### Q70

given a class Exam with instance filed Integers,and many constructor options like below

``` java 

    public class Exam{
        private Integer[] integers;
        //option A
        public Exam(List<Integer> integers){
            this.integers = integers;
        }
        //option B
        public Exam(Integer... integers){
            integers = integers;
        }
        //option C
        public Exam(Integer... integers){
            this.integers = integers;
        }
        //option D
        public Exam(Integer integers){
            integers = integers;
        }
        //option E
        public Exam(Integer[] integers){
            this.integers = integers;
        }
    }
```
which two constructors independently will compile and set the class field integers?(Choose two)

A Option A

B Option B

C OPtion C

D Option D

E Option E

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : CE

   A 失敗實際變數欄位和建構子參數型態不符
   

</div>

**↑↑↑**

---
