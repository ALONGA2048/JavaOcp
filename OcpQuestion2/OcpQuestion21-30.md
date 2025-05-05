### Q21

given:

``` java

    public static void main(String[] args) {
    	//optionA
    	    var ra = new Random();
    	    new DoubleStream(ra::nextDouble).limit(100).forEach(System.out::println);
    	//optionb
    	    DounleStream.generate(Random::nextDouble).limit(100).forEach(System.out::println);
    	//optionC
    	    DounleStream.generate(Random.nextDouble).limit(100).forEach(System.out::println);
    	//optionD
    	    var rd = new Random();
    	    DoubleStream.generate(rd::nextDouble).limit(100).forEach(System.out::println);

    }
```
---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :D

   要先建立Random物件才可以使用nextDouble方法
   在建立後可以呈上100次的隨機數最後在各別印出來


</div>

**↑↑↑**

---

### Q22

you are working on a funtional bug in a tool used by your development organization. In you investigation,you find that the tool is executed with a security policy file containing this grant:

``` java

     grant codeBase "flie:$(mylib.home)/j2se/home/mylib.jar"{
     	permission /java.Security.AllPremission;
     }
````

what action should you take?

A nothing because it is an interantional tool and not exposed to the public

B Remove the Grant because it is excessive

C Nothing,because it is not related to the bug you are investigating

D file a security bug against the tool referencing the excessive permission granted

E Nothing,because listing just the required permissions would be an ongoing maintenance challenge

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :D

   可執行的jar檔案含有funtional bug卻又被賦予grand最高權限ALLPremission有危險性
   所以應該列為security bug並找出解決方案
   


</div>

**↑↑↑**

---

### Q23

given an application with a main module that has this module-info.java file:

``` java

    module main{
      exports country;
      uses country.CountryDetails;
    }
```

which two is true?

A a moudule provideing an implementation of country.CountryDetails can be compiled and added without recompiling
the main module.

B a module providing an implemetation of country.CountryDetails must have a requires main;
derective in its module-info.java file.

C An implementation of country.countryDetails can bee added to the main module

D to compile without an error,the application must have at least one module in the module
source path that provides an implementation of country.CountryDetails

E to run without an error,the application must have at least one module in the module path
that provides an implementation of country.CountryDetails

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :AE

   A main應只相依 服務介面,服務實作修改與main無關

   B 服務實作 不該相依 服務使用者

   C 一般設計不會把服務實作 與服務使用者合併

   D 使用者模組只要具備 服務介面模組 就能通過編譯 再具備 服務實作模組 則可讓程式碼正常運行
   


</div>

**↑↑↑**

---

### Q24

given:

``` java

     public static void main(String[] args) {
        var ns = List.of(0,1,2,3,4,5,6,7,8,9);
        // optionA
           double avgA = ns.stream().parallel().averagingDouble(a->a);
        // optionB
           double avgB = ns.parallelStream().mapToInt(m->m).average().getAsDouble();
        // optionC
           double avgC = ns.stream().mapToInt(i->i).average().parallel();
        // optionD
           double avgD = ns.stream().average().getAsDouble();
        // optionE
           double avgE = ns.stream().collect(Collectors.averagingDouble(n->n));

     }
```

which options will calcurate the average of numbers? choose two

A optionA

B optionB

C optionC

D optionD

E optionE

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :BE

   A averagingDouble是Collection型別的方法

   B 正確 使用average方法必須先轉成intStream流

   C parallal是stream流方法 不能接optionalDouble

   D 錯誤stream流不能接average()方法

   E 在collect方法中才能使用averaging方法

</div>

**↑↑↑**

---

### Q25

given:

``` java

    public static void main(String[] args) {
       final Striing INPUT_FILE = "...";
       try{
          //line 1
           lines.map(l->l.toUpperCase()).forEach(line ->{
                try{
                     Files.write(Paths.get("OUTPUT_FILE"),
                     line.getBytes(),
                     StandardOpenOption.CREATE);
                }catch(Exception e){

                }
           });
       }catch(Exception e){
         e.printStackTrace();
       }
    }
```

which code inserted on line 1 will obtain the stream object on reading the file?

A var lines = Files.lines(Paths.get(INPUT_FILE));

B Stream lines = Files.readAllLines(Paths.get(INPUT_FILE));

C var lines = Files.readAllLines(Paths.get(INPUT_FILE));

D Stream<String> lines = Files.lines(INPUT_FILE);

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : A

    1. lines 需要是stream型態 才能呼叫map()方法 
    
    2. 方法.readAllLines()回傳List<String>型態 所以bc無法通過

    3. lines需要傳入Path不能傳入String 會報錯誤


</div>

**↑↑↑**

---

### Q26

given:

``` java

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(InputStreamReader(System.in))){
             System.out.println("Input String: "+ br.readline());
        }catch(IOException e){
           e.printStackTrace();
        }
    }
```

which is true?

A.System.out is the standard output stream.The steam is open only when System.out is called.

B. System.in cannot reassign the other stream.

C. System.out is an instance of java.io.OutputStream by Default

D. System.in is the standard input stream.The stream is already open.

## 翻譯

A. System.out 是標準輸出串流。這個串流只有在呼叫 System.out 時才會開啟

B. System.in 不能重新指派為其他串流。

C. C. System.out 預設是 java.io.OutputStream 的實例。

D. System.in 是標準輸入串流。這個串流在程式啟動時就已經開啟

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : D

    1. 在程式碼啟動時就自動啟動
   
    2. in可以被指派為其他串流

    3. 預設為printStream實例 和outputStream是間接實例

</div>

**↑↑↑**

---

### Q27

given:

``` java

    public class Employee{
         private String name;
         private LocalDate birthday;
         public Employee(String name,LocateDate birthday){
            super();
            this.name = name;
            this.birthday = birthday;
         }
         public String getName(){
                return name;
         }
         public LocateDate getBirthday(){
            return birthday;
         }
    } 
```

And:

``` java

    public static void main(String[] args) {
       List<Employee> emps = List.of(
             new Employee("B", LocalDate.of(1987,12,1)),
             new Employee("A",LocateDate.of(1988,12,1)),
             new Employee("C",LocateDate.of(1990,12,1))
       );
       Predicate<Employee> y = e -> e.getBirthday().isBefore(IsoChronology.INSTANCE.date(1989,1,1));

       //optionA
       Set<String> sA = emps.stream()
           .collect(Collectors.partitioningBy(y))
           .get(true)
           .stream()
           .map(Employee::getName)
           .collect(Collectors.toCollection(TreeSet::new));

       //optionB
       Set<String> sB = emps.stream();
           .collect(Collectors.partitioningBy(y))
           .get(true)
           .map(Employee::getName)
           .collect(Collectors.toCollection(TreeSet::new));
      //optionC
      Set<String> sC = emps.stream()
           .collect(Collectors.partitioningBy(y,
                       Collectors.mapping(Employee::getName,Collectors.toSet())));
      //optionD
      Set<String> sD = emps.stream()
          .collect(Collectors.partitioningBy(y,
                     Collectors.groupingBy(Employee::getName,Collectors.toCollection(TreeSet::new))));

    }
```

which option makes the set contain the names of all employees born before januart 1,1989

A OptionA

B OptionB

C OptionC

D OptionD

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : A

    10.4.3 Collectors API

    1. B差在沒有呼叫stream()方法
   
    2. C選項 應回傳Map<Boolean,Set<String>>型態

    3. 依Collectors.groupingBy()以name屬性做第二次分類,並將結果排成集合物件TreeSet,這題應回傳Map<Boolean,Set<String>>型態
    且Employee必須實作Comparable介面


</div>

**↑↑↑**

### Q28

given:

``` java

    class Employee{
        private String name;
        private double salary;
        public Employee(String name,double salary){
             super();
             this.name = name;
             this.salary = salary;

        }
        public String getName(){
             return name;
        }
        public double getSalary() {
             return salary;
        }
    }
```

And:

``` java 

    public static void main(String[] args) {
       List<Employee> list = List.of(new Employee("Jim",80000.0),new Employee("Duke",100000.0));
       double starts = 0.0;
       double ratio = 1.0;
       BinaryOperator<Double> bo = (a,b) -> a+b;
       //line 1
       double s = list.stream().map(e->e.getSalary()*ratio).reduce(starts,bo);
       System.out.println("Total Salary= "+ s);

    }
```

And 4 options:

``` java

    //optionA
    double a = list.stream().map(e-> e.getSalary * ratio).reduce(bo)
    .ifPresent(p->p.doubleValue());
    //optionB
    double b = list.stream().mapToDouble(e->e.getSalary()*ratio).sum();

    //optionC
    double c = list.stream().map(Employee::getSalary*ratio).reduce(bo).orElse(0.0);

    //optionD
    double d = list.stream().mapToDouble(e-> e.getSalary()* ratio).reduce(starts,bo);
```
which option is equivalent to line 1

A optionA

B optionB

C optionC

D optionD

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : A

    

    1. A編譯失敗ifPresent()是void 無回傳
   
    2. C編譯失敗,因為map(Employee::getSalary*ratio)語法錯誤

    3. D編譯失敗因為使用MapToDouble 第二傳入參數應為DoubleBinarayOperator 非BinanryOperator


</div>

**↑↑↑**

---

### Q29

which interface in java.util.funtion package will return a void return type?

A. Supply

B. Predicate

C. Funtion

D. consumer

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : D

    A. 提供者 不用接受資料直接回傳要提供的資料

    B. 判斷者 輸入資料用來判斷資料並且回傳boolean
   
    C. 轉換者 用來輸入資料經過操作後吐出想要的東西

    D. 執行者 將收到的資料進行處理或操作沒有要回傳東西



</div>

**↑↑↑**

---

### Q30

given:

``` java

    public class SomeResoures{
       //...
    }
```
you want to use the SomeResourse class in a try-with-resourse statement.which change will accomplish this?

A Extend AutoCloseable and override the close() method

B implements AutoCloseable and override the autoClose() method

C Extend AutoCloseable and ovrride the autoClose() method

D implement AutoCloseable and override the close() method

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : D

    AuotClose只有close方法 且在try-catch結束時會自動執行close()方法
    
</div>

**↑↑↑**

---
