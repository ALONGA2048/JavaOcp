### Q81

which set of commands is necessary to create and run a custom runtime image from java source files?

A java,jdpes

B javac,jlink

C jar,jlink

D javac,jar

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:B
    javac中的jlink指令可以打包所需的指定jar依賴包
    客製化custom runtime image

</div>

**↑↑↑**

---

### Q82

which of the following pairs of methods satisfy overloading rules?

``` java

    //optionA
    public void methodA(Throwable t){
    }
    public int methodA(Exception e){
    	return 0;
    }
    //optionB
    public void methodB(String[] s1){
    }
    public void methodB(String s2){
    	
    }
    //optionC
    public var methodC(List<String> l){
    }
    public var methodC(Double s){
    }
    //optionD
    public boolean methodD(Float f1){
    }
    public void methodD(Float f2){
    }
    //optionE
    public void methodE(List<boolean> b){

    }
    public void methodE(List<Character> c){

    }
    //optionF
    public void methodF(int[] i1){

    }
    public void methodF(Integer[] i2){

    }
```
---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:ABF
    
    overloading只能用在名稱相同 參數不同 回傳型態不計

    C 錯誤 var只能用於區域變數

    D 錯誤 因為方法名稱相同 參數相同

    E 顯示錯誤訊息 泛型會在編譯時期型態抹除以致在執行時期無法區分導制編譯失敗
</div>

**↑↑↑**

---

### Q83

which of the following are advantges of java Platform Module System?

A PlatForm Independent

B better Performance

C Package Encapsulation

D object Encapsulation

E none of these

F all of these

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:BC
    
   模組化後

   有更高階的權限控制

   且對於分類來說可以更加的清楚

</div>

**↑↑↑**

---

### Q84

given:

``` java

    private static void bar(Object next){
    }
    private static void foo(Object next){
    }
```
And:

``` java

    public static void main(String[] args) {
    	{
    		Iterator it = List.of(4,5,6).iterator();
    		while(it.hasNext()){
    			foo(it.next());
    		}
    		Iterator it2 = List.of(4,5,6).iterator();
    		while(it2.hasNext()){
    			bar(it2.next());
    		}
    	}
    	for(Iterator it = List.of(4,5,6).iterator(); it.hasNext();){
    		foo(it.next());
    	}
    	for(Iterator it2 = List.of(4,5,6).iterator(); it.hasNext();){
    		foo(it2.next());
    	}
    }
```
which loop incurs a compile time error?

A the loop starting line 11

B the loop starting line 7

C the loop starting line 14

D the loop starting line 3

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:C
    錯誤在區域變數的有效範圍

    14使用了it 但是在他內部的區塊沒有宣告所以編譯失敗


</div>

**↑↑↑**

---

### Q85

which two statements are true about java modules?(choose two)

A modular jars loaded from --module-path are automatic modules

B Any named module can directly access all classes in an automatic module

C classes found in classpath are part of an unnamed module 

D modular jars loaded from classpath are automatic modules

E if a package is defined in both the named module and the unnamed module,then the package in the unnamed module is ignored

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:CE
    模組路徑上是可以自動模組或是命名模組,因此A錯誤

    自動模組匯出所有套件,因此命名模組可以存取所有套件:但這些套件還是必須以requires指令 紀錄在模組紀錄中
     
    未命名模組會出現在類別路徑上

    在模組路徑上的可是自動模組或是命名模組
    E 正確會以命名模組為主


</div>

**↑↑↑**

---

### Q86

given:

``` java
 
     public static void main(String[] args) {
     	Path p1 = Path.of("mango");
     	p1.resolve("grape");
     	Path p2 = p1.resolve("guava");
     	System.out.println( p2 + " " + p1);
     }
```
what is the result of compiling and running this code?

A compiler error

B mango/guava mango/grape

C mango/guava grape

D mango/guava mango

E None of these

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:D
    
    Path型別是不可改變的immutable 因此行3 無法改變p1所指向的物件
    若未將p1指向新的物件的話 p1扔然指向 最初不可改變之物件 行3可以直接改變
    不影響 結果


</div>

**↑↑↑**

---

### Q87

``` java

    public static void main(String[] args) {
    	var sql = "SELECT * FROM Users";
    	try(var conn = DriverManager.getConnection(args[0]);var ps = conn.prepareStatement(sql)){
    		ResultSet rs = ps.____();
    		boolean b = ps.____();
    		int i = ps.____();
    	}
    }
```
which of the combinations can be filled in the blank in order to make the code complie?

A execute,executeUpdate,executeQuery

B executeUpdate,executeQuery,execute

C executeQuery,execute,executeUpdate

D executeUpdate,execute,executeQuery

E execute,executeQuery,executeUpdate

F executeQuery,execute,executeUpdate

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:C
    
    各個方法回傳
    executeQuery 回傳結果 型別為ResultSet

    executeUpDate 回傳影響筆數 型別為int

    execute 回傳執行的結果 true 為查詢 可取回ResultSet
    false 為更新資料 可以 用update取得 影響的筆數


</div>

**↑↑↑**

---

### Q88

which of the following are ture about annotations?

A annotation names are not case sensitive

B annotation always contains elements

C annotation can be applied to classes,methods,expressions,and annotations

D when using a marker annotation,parentheses are optional

E none of these

F all of these

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:CD
    
    12.1.2書
    標記標註型別 不包含任何元素,因此使用時可以不用括號(parentheses)所以D 選項正確 


</div>

**↑↑↑**

---

### Q89

which two statement are correct about try blocks?(choose two)

A try block can have more than one catch block

B a finally block in a try-with-resources statement executes before the resources declared are closed 

C a finally block must be immediately placed after the try or catch blocks are closed 

D a try block must have a catch block and a finally block

E catch blocks be ordered from generic to specific exception types


---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:AC
    
    D 錯誤 不一定要有

    E 錯誤 捕捉順序 由specific 到 generic 先捕捉特定例外 最後再處理一般的例外 



</div>

**↑↑↑**

---

### Q90

given:

1. stuff.properties:


	name =Nick
	age =30
	salary = 9999


2. stuff_CA.properties

    name=Jim
    age=27

3. Stuff_en.properties

    age=44

4. Stuff_en_CA.properties

    name=Alice

And:

``` java

     public static void main(String[] args) {
     	var CA = new Locale("en","CA");
     	Locale.setDefault(new Locale("en","US"));
     	var b = ResourceBundle.getBundle("Stuff",CA);
     	System.out.print(b.getString("name")+ "　");
     	System.out.print(b.getString("age")+" ");
     	System.out.print(b.getString("salary")); 
     }
```
what is the result of running this code if these property files are available?

A throws MissingResourseException

B Alice 44 9999

C Jim 27 9999

D Alice 30 9999

E something else

F does not compile

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:B
    
    找指定的語系檔 為stuff_en_ca.properties
    預設語系 stuff_en.properties
    語系設定檔案 為不帶語系的stuff.properties
    因此name 是Alice 往下找en.prop
    再往下找 .prop 找出所有檔案



</div>

**↑↑↑**

---