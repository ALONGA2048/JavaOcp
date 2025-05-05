### Q1

Module vehicle depends on module part and makes its com.vehicle package available for all other modules.

Which module-info.java declaration meets the requirements?

``` java
    //optionA
    module vehicle{
        requires parts;
        exports com.vehicle;
    }
    //optionB
    module vehicle{
    	requires parts;
    	uses com.vehicle;
    } 
    //optionC
    module vehicle{
    	requires parts;
    	exports com.vehicle to part;
    }
    //optionD
    module vehicle{
    	requires com.vehicle;
    	exports part;
    }
```
A. optionA

B. optionB

C. optionC

D. optionD

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :A 
   
   requires 關鍵字是用來呼叫其依賴package
   exports 關鍵字是用來開放其package權限

</div>

**↑↑↑**

---

### Q2

given:

``` java

    class Super{
    	public List<Number> stuff(Set<CharSequence> m){
    		return null;
    	}
    }
    class Sub extends Super{
    	//line 1;
    }
```

which two statements can be added at line 1 in sub to successfully compile it ?(choose 2)

A. public List<Integer> stuff(Set<CharSequence> m){...}

B. public ArrayList<Number> stuff(Set<CharSequence> m){...}

C. public List<Integer> stuff(TreeSet<String> m){...}

D. public List<Integer> stuff(Set<String> m){...}

E. public List<Object> stuff(Set<CharSequence> m){...}

F. public ArrayList<Integer> stuff(Set<String> m){...}

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :BC
   
   1. A 其為覆寫 傳回型態必須是子類別 有泛型則型態必須相同 否則錯誤

   2. B 為覆寫 且其回傳型別為子類別 泛型相同

   3. C 為多載 不受限制

   4. D 錯誤,為Name clash

   5. E 錯誤如同A

   6. F 如同D 在覆寫時 要馬是完全不同 要馬完全相同

</div>

**↑↑↑**

---

### Q3 

given:

``` java

    public interface IA{
    	public Iterable x();

    }
    public interface IB extends IA{
    	public Collection x();

    }
    public interface IC extends IA{
    	public Path x();
    }
    public interface ID extends IB,IC{
    }
```
why does ID cause a compilation error?

A ID inheris x() only from IC

B ID inherits x() from IB and IC but the return types are incompatible.

C ID extends more than one interface.

D ID  does not define any method.

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :B
   
   在同時繼承兩個介面但是其相同覆寫回傳方法不同會造成,系統不知要繼承哪個方法而使其報錯

</div>

**↑↑↑**

---

### Q4

given:

``` java

    package test;
    import java.time.LocalDate;
    public class Daily{
    	private LocalDate now = LocalDate.now();
    	public LocalDate getDate(){
    		return now;
    	}
    }
```
And:

``` java

    package test;
    public class Test {
    	public static void main(String[] args) {
    		Daily d = new Daily();
    		System.out.println(d.getDate());
    	}
    }
```

which statement is true?

A Class Test does not need to import java.time

B All classes from the package java.time are loaded for the class Daily

C Only LocalDate class from java.time package is loaded.

D Class Test must import java.time.LocalDate in Order to Compile.

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :A
   
   B 不只有LocalDate class載入 也並非全部載入
   (如在使用localdate時也需要引入一些依賴的類別如clock,zoneid...)

   D Test不須引入(在實作時class Daily已經引入

</div>

**↑↑↑**

---

### Q5

given:

``` java

    public static void main(String[] args) {
    	List<String> list = Arrays.asList("j","a","v","a");
    	list.forEach(x->{System.out.print(x)});
    }
```

what is the type of x?

A char

B List<Character>

C String

D List<String>

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :C
   
   對每個傳入的參數(String)進行列印

</div>

**↑↑↑**

---

### Q6

given:

``` java

    public class Exam{
    	public static void checkFile(String FileName){
    		File file = new File(FileName);
    		if(!file.exist()){
               throw new Error("Fatal Error:" + FileName + " not found.");

    		}
    	}
    	public static void main(String[] args) {
    		checkFile("test.config");
    		System.out.println("test.config is ready");
    	}
    }
```

if file "test.config" is not found,what is the result?

A test.config is ready

B Compilation fails

C Exception in thread "main" java.lang.Error:Fatal Error:test.Config not found.

D nothing

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :C
   
   Error 是uncheck 不用tryCatch

</div>

**↑↑↑**

---

### Q7

given:

``` java

    module java.se{
    	...
    	requires transitive java.sql;
    	...
    }
```
what does the transitive modifier mean?

A only a module that requiers the java.se module is permitted to require the java.sql
module.

B Any module that requires the java.se module does not need to require the java.sql module.

C Any module that attempts to require the java.se module actually requires the java.sql
module instead.

D Any module that requires the java.sql module does not need to require the java.se module.


---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :B
   
   transitive 是"可傳遞的" 概念就是把這層依賴關悉也傳遞出去,以本例來說,宣告requires java.se的模組,可以隱含地取得java.sql,不需要再宣告requires java.sql;
</div>

**↑↑↑**

---

### Q8

given:
1. /ocp/exam/temp.txt file exists.
2. /ocp/exam/new.txt and /ocp/new.txt files do not exist

And:
``` java

    public static void main(String[] args) {
    	Path currentFile = Path.get("/ocp/exam/temp.txt");
    	Path outputFile = Paths.get("/ocp/exam/new.txt");
    	Path directory = Paths.get("/ocp/");
    	Files.copy(currentFile, outputFile);
    	Files.copy(outputFile,directory);
    	Files.delete(outputFile);
    }
```
what is the result?

A. /ocp/exam/new.txt and /ocp/new.txt are deleted

B. the program throws a FileAlreadyExistsException

C. the program throws a NoSuchFileException

D A copy of /ocp/exam/new.txt exist in the /ocp directory and /ocp/exam/new.txt is deleted.

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :B
   
   第一個copy會成功建立一個new.txt檔案
   第二個copy(若ocp資料夾不存在則會建立一個名為ocp的檔案
   但資料夾已經存在所以會拋出Exception FileAlreadyExistsException

</div>

**↑↑↑**

---

### Q9

given: 

``` java

    @interface Resourse{
    	String desc();
    	int priority() default 0;

    }
```
And

``` java

    //line 1
    class Exam{
    	//...
    }
```
which two annotations may be applied at line1 in the code fragment?(choose two)

A @Resource(priority =9)

B @Resource(priority =0)

C @Resource(desc="test",priority =9)

D @Resource(desc="test")

E @Resource

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :CD
   
   建立標註型別時,只要沒有使用default關鍵字建立元素預設值,就會被認為是必要元素

</div>

**↑↑↑**

---

### Q10

``` java


    class Resource{
    	public Worker owner;
    	public synchronized boolean bind(Worker worker){
    		if(this.owner ==null){
    			this.owner = worker;
    			return true;
    		}else{
    			 return false;
    		}
    	}
    	public synchronized  void unbind(){
    		owner=null;
    	}
    }
    public class Worker{
    	public synchronized void action(Resource... resources){
    		for (int i=0;i<10;i++){
    			while(!resources[0].bind(this)){
    			}
    			while(!resources[1].bind(this)){
    			}
    			//do work with resourse
    			resources[1].unbind();
    			resources[0].unbind();
    		}
    	}
    }
```

And

``` java

    public static void main(String[] args) {
    	Worker w1 = new Worker();
    	Worker w2 = new Worker();
    	Resource r1 = new Resource();
    	Resource r2 = new Resource();
    	new Thread(()->{
    		w1.action(r1,r2);
    	}).start();
    	new Thread(()->{
    		w2.action(r2,r1);
    	}).start();
    	
    }
```
which describes the fragment?

A it throws illegalMonitorStateException

B it is subject to dead-lock

C it is subject to live-lock

D the code does not compile

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :C
   
   利用兩個thread 各自執行不同的Worker 的物件實例分別是w1與w2的action()方法,不會造成lock但傳入action()方法的參數Resource r1,r2卻是共用的 加上bind() 方法使用sychronized 宣告 因此會有短暫的lock 情況 稱為live-lock 但不會造成dead-lock


</div>

**↑↑↑**

---


