### Q71

given:

jdeps -jdkinternals C:\somePath\jar\classes.jar

which describes the expected output?

A jdeps lists the module dependencies and the package names of all referenced JDK
  internal APIs.If any are found,the suggested replacements are output in the console.

B jdeps outputs an error message that the -jdkinterals option requires ethier the -summary or the -verbose options to output to the console

C the -jdkinternals option analyzes all classes in jar and print all class-level dependencies

D the-jdkinternals option analyzes all classes in the .jar for class-level dependencies on JDK internal APIs. if any are found,the results with suggested replacements are output in the console

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   Ans :D

   jdeps用來分析內部程式碼的依賴關析
   -jdkinternals會分析有沒有jdk非公開api
   如.sun* 他會列出這些違規用法有時提供建議替代方案
   A 不會列出模組依賴她是找API內部依賴關西

   B 這個指令可以獨自使用

   C 不是所有依賴而是對internal API的依賴

</div>

**↑↑↑**

---

### Q72

given:

``` java

    public static void main(String[] args) {
    	List list = new ArrayList<>();
    	list.add("hello");
    	list.add("world");
    	output(list);
    	private static void output(List<String>... lists){
    		for(List<String> l : lists){
    			System.out.print(l);
    		}
    	}
    }
 ```
 which annotation should be used to remove warnings from compilation?

 A @SuppressWarnings on the main and output methods

 B @SuppressWarnings("unchecked") on main and @SafeVarargs on the output method.

 C @SuppressWarnings("rawtypes") on main and @SafeVarargs on the output method

 D @SuppressWarnings("all") on the main and output methods

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   Ans :D

   12.5.4書
   警告 rawtypes->未指定泛型
   警告 unchecked -> 在rawtypes中操作屬於未確認的操作
   safeVarargs 能在private static final使用不會被覆寫 且轉型沒有出錯
   總共需要unchecked rawtypes 和 varargs 警告

   D 可以壓制所有安全警告



</div>

**↑↑↑**

---

given:

``` java

    public static void main(String[] args) {
    	/* line 1*/
    	List<String> fruits = new ArrayList<>(List.of("cherry","lemon","banana"));
    	fruits.replaceAll(function);
    }
 ```
 And:

 ``` java
     //optionA
     Function function = String::toUpperCase;
     //optionB
     UnaryOperator function = s -> s.toUpperCase();
     //optionC
     UnaryOperator<String> function = String::toUpperCase;
     //optionD
     Function<String> function = m -> m.toUpperCase();
```
which option on line1 enables this code fragment to complie?

A optionA

B optionB

C optionC

D optionD

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   Ans :C

   replaceAll傳入的參數是UnaryOperator
   且須綁定泛型



</div>

**↑↑↑**

---

which of the following statements are true about the finally block?

A a finally block is required when there are no catch blocks in a try-with-resources statement

B more then one finally blocks can be defined with a regular try statement 

C a finally block cannot be used with a try-with-resources statement

D in a try-with-resources statement,any catch or finally block is run after the resources declared have been closed

E A finally block is required in order to make sure all resources are closed in a try-with-resources statement

F if an exception is thrown from the finally block,the remaining part of the finally block will not be executed

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   Ans :DF

   使用try-wth-resource會自動關閉物件參考,所以不需要一定存在finally區塊

   B 錯誤只允許存在1個finally區塊

   資源會優先關閉之後才執行catch和finally區塊

   且要是在try拋出例外時會直接停止而不執行finally區塊



</div>

**↑↑↑**

---

### Q75

given:

``` java

    interface MyApi{ //line 1 
          public void checkValue() throws IllegalArgumentException;//line 2
          public boolean isValueANumber(Object val){
          	   //implementation
          }
    }
```

which two changes need to be made to make this class compile ?(choose two)

A change line 1 to an abstract class

B change line2 access modifier to protected

C change line1 to a class

D change line 1 to extend java.lang.AutoCloseAble

E change line 2 to an abstract method

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   Ans :AE

   


</div>

**↑↑↑**

---

### Q76

which two modules include APIs in thr java SE Specification(choose two)

A java.logging

B java.desktop

C javafx

D jdk.httpServer

E java.jarTool

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
  
  Ans:AE
  Java SE（Standard Edition）是 Java 平台的核心，包括 JDK 的標準 API

  其命名都為java.開頭
    java.base

	java.logging

	java.desktop

	java.sql

	java.xml 等等
	   


</div>

**↑↑↑**

---

given:

``` java

    public class Exam{
    	private int num = 1;
    	private int div = 0;
    	public void divideNumber(){
    		try{
    			num=num/div;
    			System.out.println("calculation done!");
    		}catch (ArithmeticException ae){
    			num=100;
    		}catch(Exception e){
    			num=200;
    		}finally{
    			num=300;
    		}
    		System.out.println(num);
    	}
    	public static void main(String[] args) {
    		Exam test = new Exam();
    		test.divideNumber();
    	}
    }
```

what is the output?

A 300

B calculation done !

C 200

D 100

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

    Ans:A 
    finally最終都會執行
	   


</div>

**↑↑↑**

---

### Q78

which two statement are true about the modular JDK(choose two)

A the foundational APIs of the java SE Platform are found in the java.base module.

B An application must be structured as modules in order to run on the modular JDK

C it is possible but undesirable to configure modules' exports from the command line.

D APIs are deprecated more aggressively because the JDK has been modularized

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

    Ans:AC
    
    B 錯誤 自動化模組就不需要
    C 可以使用指令--add-exports
    D 模組化與API被禁用(deprecated)沒關西
	   


</div>

**↑↑↑**

---

### Q79

given:

``` java

    public static void main(String[] args) {
    	int[] array1 = {2,4,6,8,10};
    	int[] array2 = {2,4,8,6,10};
    	int output1 = Arrays.mismatch(array1,array2);
    	int output2 = Arrays.compare(array1,array2);
    	System.out.println(output1 + " " +  output2);
    }
```
what is the result?

A -1,2

B 2,-1

C 2,3

D 3,0


---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

    Ans:B
    
    mismatch會依序找出兩個不一致的成員並回傳第一個的index若都相同則回傳-1
    compare則會回傳是否包含相同成員和順序
    若均相同則回傳0
    若第一大於第二陣列則回傳正數
    若第一小於第二陣列則回傳負數
	   


</div>

**↑↑↑**

---

### Q80

given:

``` java

    public class Exam{
    	  private static void method1(){
    	  	System.out.print("a");
    	  	if(false){
    	  		throw new IndexOutOfBoundsException;
    	  	}
    	  }
    	  private static void method2() throws FileNotFoundException{
    	  	 System.out.print("b");
    	  	 if(true){
    	  	 	 throw new FileNotFoundException();
    	  	 }
    	  }
    }
    public static void main(String[] args) {
    	try{
    		method1();
    		method2();

    	}catch(IOException e){
    		System.out.print("c");
    		return ;
    	}finally{
    		System.out.print("d");
    	}
    	System.out.print("f");
    }
```

what is the result?

A the compilation fails

B abdf

C abd

D adf

E abcd

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

    Ans:E
    
    20會中斷程式碼 不會進行到第24行
	   


</div>

**↑↑↑**

---