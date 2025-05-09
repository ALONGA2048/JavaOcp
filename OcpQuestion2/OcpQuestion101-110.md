### Q101

which of the following aret ture about the shutting down of an ExecutorService?

A the shutdown() method is automaticlly called when all the tasks submitted to the thread executor are complete

B if a new task is submitted to an ExecuterService while it is shutting down,an exception is thrown

C the isShutDown() method stops all the tasks submitted to the thread executor

D the shutdown() method stops all the tasks submitted to the thread executor

E All of these

F none of these

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:BC
  
    ExecuterService.shutdown()被呼叫時 service會停止接收新的任務並且等待舊的任務完成
    A 錯誤 必須自己呼叫shutdown方法

    B 正確 不會接收新的任務並拋出Exception

    C 正確 當shutdown方法呼叫時 isshutdown就會回傳true

    D 錯誤,會等待任務執行完畢,才會關閉執行序池


</div>

**↑↑↑**

---

### Q102

given:

``` java

   public final class SecureClass{
   	    private String secret;
   	    public SecureClass(String secret){
   	    	this.secret = secret;
   	    }
   	    public String getSecret(){
   	    	return secret;
   	    }
   	    public void setSecret(String secret){
   	    	this.secret = secret;
   	    }
   }
```

which security best practice is taken care of in this class ?

A immutability

B limiting object creation

C restricting extensibility

D none of these

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:C
  
    使用final宣告類別可以避免被繼承而修改


</div>

**↑↑↑**

---

### Q103

which two commands are used to identify class and module dependencies?(choose two)

A jmod describe

B java Hello.java

C jdeps --list-deps

D jar --show-module-resolution

E java--show-module-resolution

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:CE
  
    13.5.5 jmod只用來處理JMOD檔案


</div>

**↑↑↑**

---

### Q104

given:

``` java

    public static void main(String[] args) {
    	var someDay = LocalDate.now()
    	              .with(WEDNESDAY)
    	              .getDayOfWeek();
    	switch (someDay){
    	case SUNDAY:
    	case SATURDAY:
    		System.out.print("Weekend");
    		break;
    	case MONDAY:
    	case FRIDAY:
    		System.out.print("Working");
    	default:
    		System.out.print("Unexpected");
    	}
    }
```
what is the result?

A workingUnexpected

B Unexpected

C TuesdayUnexpected

D the compilation fails

E WEDNSDAY

F Working

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:B
     localDate取得時間後可以用with取得該周的禮拜三時段 最後再用getDayOfWeek取得enum型態

    switch 支援enum但內部指定為星期三所以default

</div>

**↑↑↑**

---

### Q105

given:

``` java

    public static void main(String[] args) {
    	int i=10;
    	Supplier<Integer> myLambda = ()-> i;
    	i++;
    	System.out.println(myLambda.get());
    }
```
what is true?

A the code compile but does not print any result

B the code prints 10

C the code does not compile

D the code throws an exception at runtime

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:C
    第三行編譯失敗 若lamda使用區域變數,則區域變數需要是final或是值在區域內從未改變的final

</div>

**↑↑↑**

---

### Q106

which two statement are corrcect about modules in java?(choose two)

A java.base exports all of the java platforms core packages

B module-info.java can be placed in any folder inside module-path

C a module must be declared in module-info.java file

D module-info.java cannot be empty

E by default,modules can access each other as long as they run in the same folder

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:AC
    
    B module-info只能在 模型層的最外圍(根目錄底下 旁邊就是其描述的module package)
    C module內關悉跟權限也需要設定
    D 可以 會直接結束工作不產生class檔案
    E 無法命名模組存取權限依照info中存取

</div>

**↑↑↑**

---

### Q107

which two describe reason to modularize the JDK?(choose two)

A easier to understand the java language

B improves security and maintainability

C easier to expose implementation details

D improves application robustness

E easier to build a custom runtime linking application modules and JDK modules

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:BE
    
    C 模組化前更容易暴露實作細節

    D 和程式的穩固性比較無關


</div>

**↑↑↑**

---

### Q108

given:

``` java

    public class Employee{
    	 private String name;
    	 private String neighborhood;
    	 private LocalDate birthday;
    	 private int salary;
    	 //constructor ,getter,setters
    }
```

And:

``` java

   public static void main(String[] args) {
   	  Employee e1 = new Employee("A",1000);
   	  Employee e2 = new Employee("A",500);
   	  Employee e3 = new Employee("B",2000);
   	  Employee e4 = new Employee("B",700);
   	  List<Employee> emps = Arrays.asList(e1,e2,e3,e4);
   	  //optionA
   	  Map<String,Optional<Employee>> mA = emps.stream()
   	  .collect(Collectors.maxBy(Employee::getSalary,
   	      Collectors.groupingBy(Comparator.comparing(e-> e.getNeighborhood()))));
   	  //optionB
   	  Map<String,Optional<Employee>> mB = emps.stream()
   	  .collect(Collectors.groupingBy(Employee::getNeighborhood,
   	      Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
   	  //optionC
   	  Map<String,Optional<Employee>> mC = emps.stream()
   	      .collect( Collectors.groupingBy(e->e.getNeighborhood(),
   	                 Collectors.maxBy( (x,y) -> y.getSalary() - x.getSalary()  )) );
   	   //optionD
   	   Map<String,Optional<Employee>> mD = emps.stream()
   	      .collect(Collectors.maxBy( (x,y) -> y.getSalary() - x.getSalary()  ),
   	      	Collectors.groupingBy( Employee::getNeighborhood
   	                 ) );
   }
```
which code fragment makes a map contain the employee with the highest salary for each neighborhood?

A OptionA

B OptionB

C OptionC

D OptionD

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:B
    
    先以groupBy找出分組 之後再用max比較出其中的最高新水並寫入



</div>

**↑↑↑**

---

### Q109

given:

``` java

import java.util.function.Function;

public class LamdaLab{
	public static void main(String[] args) {
		Function myfun = x -> { return (Integer) x*3 ;};
		LamdaLab.printValue(myfun,4);
	}
	public static <T> void printValue(Function f,T num){
		System.out.println(f.apply(num));
	}
}
```
compiling lamdaLab.java gives this compiler warning:

Note:LamdaLab.java uses unchecked or unsafe operations

which two replacements done together remove this compiler warning?

A line4 with Function<Integer> myFun = x-> {return (Integer)x乘3;};

B line7 with public static void printValue(Function<Integer> f,int num);

C line7 with public static int printValue(Function<Integer,Integer> f,T num);

D line7 with public static <T> void printValue(Function<T,T> f,T num);

E line4 with Function<Integer,Integer> myfun = x-> {return (Integer)x乘3;};


---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:DE
    
    藥安全則要表明確切的輸入輸出型態
    且對應型別需要合理 如傳入的參數需和Function相同不然.apply會報錯誤



</div>

**↑↑↑**

---

### Q110

given below files and its contents:

1. MessageBundle.properties:
    account = account
    password = password
2. MessageBundle_ru.properties:
    account = yther wewe
    password = napord
3. MessageBundle_fr_FR.properties:
    account = Compte
    password = le mot de passe
And:

``` java

    public static void main(String[] args) {
    	Locale.setDefault(Locale.FRANCE);
    	var rb = ResourceBundle.getBundle("MessageBundle",new Locale("ru"));
    	System.out.println("Account = " + rb.getString("account"));
    	System.out.println("Password = " + rb.getString("Password"));
    }
```
what is the result?

A Account = yther wewe,Password=napord

B Account = Compte,Password = le mot de passe

C Account = account,Password = password

D the compilation fails

E A missingResourceException is thrown

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:A
    
    先使用getBundle定義再來使用 default 再來原始bundle最後才會拋出Exception



</div>

**↑↑↑**

---