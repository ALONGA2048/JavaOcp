### Q51


given below files and its contents

1. MessageBundle.properties:

message=Hello

2. MessageBundle_en.properties:

message=Hello(en)

3. MessageBundle_US.properties:

message=Hello(US)

4. MessageBundle_en_US.properties:

message=Hello(en_US)

5. MessageBundle_zh_TW.properties:

message=Hello(zh_TW)

And:

``` java

    public static void main(String[] args) {
    	Locale.setDefault(Locale.TRADITIONAL_CHINESE);
    	Locale locale = new Locale.Builder().setLanguage("en").build();
    	ResourceBundle rb = ResourceBundle.getBundle("MessageBundle",locale);
    	System.out.println(rb.getString("message"));
    }
```
which file will display the content on executing the code fragment?

A. MessageBundle_en_US.properties

B. MessageBundle_en.properties

C. MessageBundle_zh_TW.properties

D. MessageBundle_US.properties

E. MessageBundle.properties

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : B
   
   由setLanguage("en") 只會使用en.properties
   不存在的話則會先使用default的zh_tw再沒有就用通用的.properties再沒有就報錯


</div>

**↑↑↑**

---

### Q52

given:

``` java

    public static void main(String[] args) {
    	var list = List.of(1,2,3,4,5,6,7,8);
    	Optional<Integer> output = list.stream();
    	        .filter(i -> i % 3 !=0)
    	        .reduce((x,y) -> x + y );
    	output.ifPresent(System.out::println); //line1

    }
```

which is true about line 1

A if the value is not present,a NoSuchElementException is thrown at runtime

B it always executes the System.out::println statement

C if the value is not present,a NullPointerException is thrown at runtime

D if the value is not present,nothing is done

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : D
   
   ifPresent那會執行否則不會做任何事情

</div>

**↑↑↑**

---

### Q53

given:

``` java

    public static void main(String[] args) {
        List<String> l1 = new LinkedList<>();
        Set<String> s1 = new HashSet<>();
        String[] v = {"x","y","z","x","y"};
        for(String s:v){
            l1.add(s);
            s1.add(s);
        }
        System.out.print(s1.size() + " " + l1.size() + " ");
        List<String> l2 = new LinkedList<>(l1);
        Set<String> s2 = new HashSet<>(s1);
        System.out.print(s2.size() +" "+  l2.size() +" ");
    }
```

what is the result?

A 3 5 3 3

B 3 3 3 3

C 3 5 3 5

D 5 5 3 3

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : C
   
   set紀錄重複的會不紀錄但也不會報錯,List則可以因為是陣列

</div>

**↑↑↑**

---

### Q54

given:

``` java

    class Employee{
        private String name;
        private String localty;
        //constructor,getter,setters
    }
```
And :

``` java

    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("x","x"));
        empList.add(new Employee("y","y"));
        empList.add(new Employee("z","x"));
        //option A:
        long countA = empList.stream()
                     .map(Employee::getLocality)
                     .distinct()
                     .count();
        //optionB
        long countB = empList.stream()
                     .map(e-> e.getLocality())
                     .count();
        // optionC
        long countC = empList.stream()
                     .map(e->e.getLocality())
                     .collect(Collectors.toSet())
                     .count();
        // option D
        long countD = empList.stream()
                     .filter(Employee::getLocality)
                     .distinct()
                     .count();
    }
```
which option will print the number of unique locatites from the emplist list ?

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : A
   
   A 會回傳Stream<String> 再取得數目

   B 未使用distinct()(可以去除重複項) 無法過濾重複的 locality值

   C 會回傳Set<String> 要長度則要呼叫.size方法

   D 應該把filter 改成map

</div>

**↑↑↑**

---

### Q55


given:

``` java

   class Employee{
         int age;
         String name;
         //constructor ,getter,setter
   }
```
And:

``` java

    public static void main(String[] args) {
        List<Employee> emplist = new ArrayList(List.of(new Employee(54,"Tom"),new Employee(50,"Amber"),new Employee(50,"Peter")));
        empList.sort(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName).reversed());
        empList.forEach(e-> System.out.print(" "+ e.getName()) );
        
    }
``` 

what will be the result?

A Amber Tom Peter

B Tom Amber Peter

C Amber Peter Tom

D Tom Peter Amber

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : D
   
   先以age比較

   age相同時則改以name 比較

   最後再將順序結果顛倒

</div>

**↑↑↑**

---

### Q56

which three guidelines are used to protect confidential information?(choose three)

A limit access to objects holding confidential information

B clearly identify and label confidential information

C Manage confidentical and other information uniformly

D transparent;y handle information to improve diagnostics

E treat user input as normal information

F validate input before storing confidential information

G encapsulate confidentical information

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : AFG
   
   B 不應清楚識別和標記機密資訊,以免暴露給有心人士

   C 不應將機密資訊和其他資訊一致型管理

   D 不應透明的處理資訊

   E 不應把使用者輸入當成一般的資訊

</div>

**↑↑↑**

---

### Q57

given:

``` java

    public static void main(String[] args) {
        try(Reader r1 = new FileReader("f1.txt");
            Reader r2 = new FileReader("f2.txt");
            Reader r3 = new FileReader("f3.txt");
        ){
        }catch(Exception e){
            e.printStrackTrace();
        }
        //line 1
        System.out.println("Finished");
    }
```
when run all three files exist,what is the state of each reader on line 1?

A all three readers are still open

B all three readers have been closed

C the compilcation fails

D only the reader1 has been closed

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :B
   
   try with resourse在try執行結束後會自動關閉

</div>

**↑↑↑**

---

### Q58

given:

``` java

    var pool = Executors.newFixedThreadPool(5);
    Future result = pool.submit(()-> 1);
```

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :D
   
   方法submit 的簽名
   <T> Future<T> submit(Callable<T> task);

</div>

**↑↑↑**

---

### Q59

which two statements set the default locale used for formatting number,currency,and percentagers?(choose two)

A Locale.setDefault(Locale.Category.FORMAT,"zh-CN");

B Locale.setDefault(Locale.Category.FORMAT,Locale.CANADA_FRENCH);

C Locale.setDefault(Locale.TRADITIONAL_CHINISE);

D Locale.setDefault("en_CA");

E Locale.setDefault("es",Locale.US);

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :BC
   
   其方法兩個簽名為setDefault(Locale.Category,Locale)
   跟setDefault(Locale)

</div>

**↑↑↑**

---

### Q60

given:

``` java

    public class Secure implements Serializable{
        private String data;
        public Secure(String data){
             this.data = data;
        }
    }
```

which two are secure serialization of these objects?(choose three)

A define the serialPersistentFields array field 

B declare fields transient

C implement only readResolve to replace the instance with  a serial proxy and not writeReplace

D Make the lass abstract

E implement only writeReplace to replace the instance with a serial proxy and not readResolve

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :AE
   
   B 不進行序列化
   D 無關序列化
   C 反序列化

   1. declare sensitive fields transient

   2. definr the serialPersistentFields array field appropriately

   3. implement writeObject and use ObjectOutputStream.putField selectvely

   4. implement writeReplace to replace the instance with a serial proxy

   5. implement the Externalizable interface


    A   ✅   明確定義要序列化的欄位，避免洩漏敏感資料
    B   ❌   不能標記敏感欄位為 transient，防止被序列化
    C   ❌   只用 readResolve 無法防止資料被寫出
    D   ❌   抽象類別與序列化安全無關
    E   ✅   用 writeReplace 可以用安全代理取代原始物件，防止洩漏


</div>

**↑↑↑**

---