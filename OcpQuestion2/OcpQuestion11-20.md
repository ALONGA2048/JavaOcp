### Q11

given:

``` java

    public class Main{
    	public static void main(String[] args) {
    		Thread t1 = new Thread(new myThread());
    		Thread t2 = new Thread(new myThread());
    		Thread t3 = new Thread(new myThread());
    		t1.start();
    		t2.run();
    		t3.start();
    		t1.start();
    		System.out.println("done");
    		class MyThread implements Runnable{
    			@Override
    			public void run(){
    				System.out.println("running");
    			}
    		}

    	}
    }
```

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :A
   
   總共建立了兩個thread(不包含main的話)
   但是因為thread1重複start所以會抱錯(illegalThreadStateException)

</div>

**↑↑↑**

---

### Q12

which code fragment does a service use to load the service provider with a Print interface?

A Print print=con.service.Provider.getIntance();

B java.util.ServiceLoader<Print> loader = ServiceLoader.load(Print.class);

C java.util.ServiceLoader<Print> laoder = new java.util.ServiceLoader<>();

D Print print = new com.service.Provider.PrintImpl();

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :B
   
   

</div>

**↑↑↑**

---

### Q13

given:

``` java

    module ServiceAPI{
    	exports com.example.api;
    }
    module ServiceProvier{
    	requires ServiceAPI;
    	provides com.example.api with com.example.api.impl.ApiImpl;
    }
    module Consumer{
    	requires ServiceAPI;
    	uses com.example.api;
    }
```

which two statements are correct?(choose two)

A the serviceProvider module is the only module that,at run time,can provide the corn example.api API

B the placement of the com.example.api API ina separate module,ServiceAPI,makes it easy to install multiple providers modules

C the Consumer module should require the serviceProvider module.

D the serviceProvider module should export the com.example,api.impl package

E the serviceProvider module does not know the identity of a moudle (such as Consumer ) that uses the com.example.api API

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :BE

   A ServiceProvider 可以多個

   C consumer 應該指認識介面模組,不該綁定實作模組

   D 不須exports 要用provides 指令

   E 只需知道服務介面,服務實作不該知道用戶端

</div>

**↑↑↑**

---

### Q14

``` java

    public class Test{
          public static void main(String[] args) {
              Optional<String> value = createValue();
              String str = value.orElse("Default value as null");
              System.out.print(str);
          }
          static Optional<String> createValue(){
            String s = null;
            return Optional.ofNullable(s);
          }
    }
```

what is the output?

A null

B A NoSuchelementException is thrown at runtime

C default value as null

D A NullPointerException is thrown at runtime

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :C

   10.2.2 Optional常用方法


</div>

**↑↑↑**

---

### Q15

given:

``` java

    public static void main(String[] args) {
       String url = "...";
       String user = "...";
       String pwd = "...";
       try(Connection conn = DriverManager.getConnection(url,user,pwd);
           PreparedStatement ps = conn.preparedStatement("insert into EMP values (?,?,?)");){
           ps.setObject(1,101,JDBCType.INTERGER);
           ps.setObject(2,"SMITH",JDBCType.VARCHAR);
           ps.setObject(3,"IT",JDBCType.VARCHAR);
           ps.executeUpdate();
           ps.serInt(1,102);
           ps.setStirng(2,"Tim");
           ps.executeUpdate();
       }
       System.out.println("done");
       
    }
```

Assume url ,username,password are valid and the EMP table is defind appropriately

What does executing this code fragment do ?

A. insert two rows(101,'SMITH','IT') and (102,'JIM',NULL)

B  insert two rows(101,'SMITH','IT') and (102,'JIM','IT')

C  insert one rows(101,'JIM',NULL)

D  throws a SQLException

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :B

   設定的setObject會保留到下次的exe執行


</div>

**↑↑↑**

---

### Q16

given:

``` java

    public static void main(String[] args) {
       List list = List.of(new Wiget("A wiget",31.55),new Wiget("B wiget"),55.00,new Wiget("C Wiget",65.45));
       Stream stream = list.stream();
       stream.filter(a-> a.getPrice()>40.0).forEach(System.out::println);
    }
```
which two statements,independently,would allow this code to complie ? (choose two)

A  Replace line 5 with stream.filter(a-> a.getPrice() >40.00);

B Replace line 4 with List<Wiget> stream = list.stream();

C Replace line 5 with stream.filter((Wiget a)-> a.getPrice() >40.0)

D Replace line 4 with Stream<Wiget> stream = list.stream();

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :AD

   不知其泛型,不清楚lamda中的a是何種型態


</div>

**↑↑↑**

---

### Q17

given:

``` java

    public static void main(String[] args) {
       var inits = List.of(1,2,3,4,5);
       //line 1
       StringBulider sb = new StringBulider();
       for(int a: ints){
            sb.append(f.apply(a));
            sb.append(" ");

       }
       System.out.println(sb.toString());
    }
```
which statement on line 1 enables this code to compile ?

A. Function<Integer,Integer> f = n->nx2

B. Function<Integer> f = n->nx2

C. Function<int> f = n->nx2

D. Function<int,int> f = n->nx2

E. Function f = n->nx2

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :AD

   A Funtion要搭配輸入與輸出的型別


</div>

**↑↑↑**

---

### Q18

you want to find the first element that contains the character n. Which statement will accomplish this?

A String result =list.stream().filter(f->f.contains("n")).findAny();

B list.stream().filter(f->contains("n")).forEachOrdered(System.out::print);

C Optional<String> result = list.stream().filter(f->f.contains("n").findFirst());

D Optional<String> result = list.stream().anyMatch(f->f.contains("n"));


---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :C

   A 應回傳Optional<String>

   B 輸出所有含n字串

   D 只會回傳boolean


</div>

**↑↑↑**

---

### Q19

given:

``` java

    public class Exam{
          private final ReentrantLock lock = new ReentrantLock();
          private State state = new State();
          public void test() throws Exception{
             try{
               lock.lock();
               state.mutate();
             }finally{
               lock.unlock();
             }
          }
    }
    class State{
         public void mutate (){
             //some operation]
         }
    }
```
what is required to make the Exam class thread safe?

A No change is required

B Make the declartion of lock static

C Replace the lock constructor call with new ReentrantLock(true)

D Move the declaration of lock inside the test() method

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :A
   對State的改變
   Exam 只有一個ReetrantLock物件
   多個test方法時 只有取得物件並呼叫lock方法才能改變欄位值
   因此是為執行緒安全
  


</div>

**↑↑↑**

---

### Q20

given:

``` java

    public static void main(String[] args) {
       //optionA 
       Comparator comparatorA = new Comparator<?>(){
           public int compare(Integer i,Integer j){
                return i.compareTo(j);
           }
       }
       var  comparatorB = new Comparator<?>(){
           public int compare(Integer i,Integer j){
                return i.compareTo(j);
           }
       }
       Comparator<> comparatorC = new Comparator<Integer>(){
           public int compare(Integer i,Integer j){
                return i.compareTo(j);
           }
       }
       Comparator<Integer> comparatorD = new Comparator<>(){
           public int compare(Integer i,Integer j){
                return i.compareTo(j);
           }
       }
    }
```
what code fagment compiles ?

A optionA

B optionB

C optionC

D optionD

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
   ans :D
   
   面對泛型必須要在前面宣告其儲存型別後面可選可不選
   
  


</div>

**↑↑↑**

---