### Q141

given:

``` java

    public static void main(String[] args) {
    	Locale locale = Locale.US;
    	//line 1
    	double currency = 9_00.00;
    	System.out.println(nf.format(currency));
    }
```
you want to display the value of currency as $900.00

which code inserted on line1 will achieve this?

A NumberFormat nf = NmuberFormat.getInstance(locale).getCurrency();

B NumberFormat nf = NmuberFormat.getCurrency(locale);

C NumberFormat nf = NmuberFormat.getCurrencyInstance(locale);

D NumberFormat nf = NmuberFormat.getInstance(locale);

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :C
    
    AB 編譯失敗
    D 成功但是沒有幣值
    C 才是唯一可以達成的方法

</div>

**↑↑↑**

---

### Q142

given:

``` java

    interface Worker{
    	public void doProcess();
    }
    class HardWorker implements Worker{
    	public void doProcess(){
    		System.out.println("working");
    	}
    }
    class LazyWorker implements Worker{
    	public void doProcess(){
    		System.out.println("sleeping");
    	}
    }
    public class Main<T extends Worker> extends Thread{
    	private List<T> list = new ArrayList<>();
    	public void addProcess(HardWorker w){
    		list.add(w);
    	}
    	public void run(){
    		list.forEach((p) -> p.doProcess());
    	}
    }
```
what needs to change to make these classes compile and still handle all types of interface Worker?

A replace Line 3 with public void addProcess(T w){ 

B replace line 1 with public class Main<T extends HardWorker> extends Thread { 

C replace line 3 with public void addProcess(Worker w)

D replace line 2 with private List<HardWorker> list = new ArrayList<>();

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :A
    
    因為list使用都是T型態且list.add其形態也只能是T 所以A 必須配合改動
    B 不能限制導致其他如LazyWorker不能使用
    C 其List為T 不能遮樣限制導致報錯誤
    D 強制竄改就失去用泛型的用意了
    

</div>

**↑↑↑**

---

### Q143

given:

``` java

    public class Test{
    	int a = 0;
    	int b = 0;
    	int c = 0;
    	public void setAC(int i){
    		a += b*i;
    		c -= b*i;
    	}
    	public void setB(int i){
    		b=i;
    	}
    }
```
which makes class Test thread safe?

A make setB synchronized

B Make Test synchronized

C make setAC and setB synchronized

D make setAC synchronized

E class Test is thread safe

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :C
    
    避免多執行緒同時修改a,b,c 必須在set方法都修飾
    

</div>

**↑↑↑**

---

### Q144

given codes and four options:

``` java
  
    public class Staff{
    	private String area;
    	private int salary;
    	public Staff(String area,int salary){
    		super();
    		this.area = area;
    		this.salary = salary;
    	}
    }
    //getter ,setter for eara ,salary
    public static void main(String[] args) {
    	Staff e1 = new Staff("A",1000);
    	Staff e2 = new Staff("A",500);
    	Staff e3 = new Staff("B",2000);
    	Staff e4 = new Staff("B",700);
    	List<Staff> roaster = Arrays.asList(e1,e2,e3,e4);
    	Predicate<Staff> pred = e -> e.getSalary() > 900;
    	Function<Staff,Optional<String>> fun = e-> Optional.ofNullable(e.getArea());
    	//option A
    	Map<Optional<String>,List<Staff>> ma = roster.stream()
    	 .filter(pred).collect(Collectors.groupingBy(pred));
    	//optionB
    	Map<String,List<Staff>> mb = roster.stream()
    	 .filter(pred).collect(Collectors.groupingBy(fun,Staff::getArea));
    	//optionC
    	 Map<List<Staff>,Optional<String>> mc = roster.stream()
    	 .collect(Collectors.groupingBy(fun,Collectors.filtering(pred,Collectors.toList() )));
    	//optionD
    	 Map<Optional<String>,List<Staff>> md = roster.stream()
    	 .collect(Collectors.groupingBy(Staff::getArea,Collectors.filtering(pred,Collectors.toList() )));
        //optionE
    	 Map<String,List<Staff>> me = roster.stream()
    	  .collect(Collectors.groupingBy(Staff::getArea,Collectors.filtering(pred,Collectors.toList() )));

    }
```
which two maps group all employees with a salary greater than 900 by Area

A optionA

B optionB

C optionC

D optionD

E optionE

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :CE
    
    AB 編譯失敗 因為groupBy參數錯誤

    C 正確D 錯誤 兩個為對照組
    

</div>

**↑↑↑**

---

### Q145

which module defines the foundation APIs of the java SE platform

A java.lang

B java.base

C java.se

D java.object

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :B
    
   base收錄舊版本的功能及基礎功能
    

</div>

**↑↑↑**

---

### Q146

given the context of data.txt

C

C++

Java

Js

Python

And:

``` java

    public static void main(String[] args) {
        String f = "data.txt";
        List<String> content = new ArrayList<>();
        try(Stream<String> stream = Files.lines(Paths.get(f))){
              content = stream
                       .filter(line -> !line.equalsIgnoreCase("JAVA"))
                       .map(String::toUpperCase)
                       .collect(Collectors.toList());
        }catch(IOException e){
        }
        content.forEach(System.out::println);
    }
```
what is the result?

A 
  C
  C++
  JS
  PYTHON
B
  JAVA
C
  C
  C++
  Js
  Python
D
  C
  C++
  JAVA
  JS
  PYTHON

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :A
    
   不分大小寫不符合JAVA的都留下
    

</div>

**↑↑↑**

---

### Q147

given:

``` java

    public static void main(String[] args) {
        List.of().stream()
              .peek(System.out::println)
              .collect(Collectors.toList());
    }
```

why would you choose to use a peek operation instead of a forEach operation on a Stream?

A remove an item from the beginning of the stream

B to process the current iteam and return void

C to process the current iteam and return a stream

D to remove an item from the end of the stream

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :C
    
   用來查看中間成員做的事情debug所以會去看過後不回傳東西(內部實現其實是Cosumer)
    

</div>

**↑↑↑**

---

### Q148

you organization provides a cloud server to your customer to run their java code

you are reviewing the changes for the next relese and you see this change in one of the config files:

Before:JAVA_OPTS="$JAVA_OPTS-Xms8g-Xms8g"

After:JAVA_OPTS="$JAVA_OPTS-Xms8g-Xms8g-novertify"

which is correct?

A you accept the change because -novertify is a standard option that has been supported since java1.0

B you reject the change because -Xms8g -Xms8g use too much system memory

C you accept the change because -novertify is neccessary for your code to run with the lastest version of java

D you reject the change because -novertify is a critical security risk

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :D
    
    -Xms8g是用來決定記憶體最小值為8g 第二個則決定最大值為8g
    -noverify則表示關閉java bytecode的驗證 可能導致jvm崩潰
    

</div>

**↑↑↑**

---

### Q149

given below code fragment and possible options

``` java

    public static void main(String[] args) {
        Integer i = 9;
        //optionA 
          Double a = i;
        //optionB
          Double b = Double.valueof(i);
        //optionC
          double c = Double.parseDouble(i);
        //optionD
          Double d = (Double) i;
        //optionE
          double e = i;
    }
```

which two option compiled?

A optionA

B optionB

C optionC

D optionD

E optionE

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :BE
    
    
    A,D 沒有繼承關西不可轉型
    C 只能是傳入String
    E 則可以自動轉為int 在與double自動配對時自動裝箱
    

</div>

**↑↑↑**

---

### Q150

given:

``` java

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            if(iterator.next() == 3){
                list.remove(3);
                System.out.println(iterator.next());
            }
        }
    }
```

what is the result?

A 1 2 3 4

B a java.util.CocurrentModificationException is thrown at run time

C 1 2 followed by an exceptiong

D 1 2 3 followed by an exception

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :B
    
    
    在第10行時先移除了index3的成員後又要 用.next()取得已刪除元素
    而拋出ConcurrentModificationException
    

</div>

**↑↑↑**

---

### Q151

given:

``` java

    public static void main(String[] args) {
        var list = new CopyOnWriteArrayList<>(List.of("1","2","3","4"));
        Runnable r = () ->{
            try{
                Thread.sleep(150);

            }catch(InterruptedException e){
                e.printStackTrace();
            }
            list.set(3,"four");
            System.out.print(list + " ");
        };
        Thread t = new Thread(r);
        t.start();
        list.forEach(s->{
            System.out.print(s+" ");
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        });
    }
```

what is the output?

A 1 2[1,2,3,4] 3 four

B 1 2[1,2,3,four] 3 4

C 1 2[1,2,3,four] 3 four

D 1 2[1,2,3,4] 3 4

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :B
    
    
    copyOnwrite可供同時讀與寫 剛好互不影響
    0 main->1
    100秒 main->2
    150 t->[1,2,3,four]
    200 main ->3
    300 main ->4
    

</div>

**↑↑↑**

---