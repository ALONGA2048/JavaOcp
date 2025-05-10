### Q121

given:

``` java

    class Item{
    	public String label;
    	public int num;
    	public Item(String name,int num){
    		this.label = name;
    		this.num = num;
    	}
    }
```

And:

``` java

    public static void main(String[] args) {
    	var items = List.of(new Item("iA",10),new  Item("iB",-6),new Item("IC",6));
    	//line 1
    	System.out.println("there is item for which the variable num < 0.");
    }
```

you want to examine the items list it contains an item for which the varible num <0

which code frament at line 1 acoomplish this?

A if(iteam.stream().filter(i->i.num < 0).findFirst().isPresent()){}

B if(iteam.stream().filter(i->i.num < 0).findAny()){}

C if(iteam.stream().allmatch(i->i.num > 0) < 0){}

D if(iteam.stream().anymatch(i->i.num < 0) < 0){}

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans : A
    
    是if所以必須是布林值 
    B 必須再呼叫isPresent確認是否存在
    C allMatch已經回傳布林值不須再加<0
    D 同上

</div>

**↑↑↑**

---

### Q122

given:

``` java

    public static void main(String[] args) {
    	String[] fruits = { "banana","polomo","blueBerry","orange"};
    	Comparator<<String> comp = (a,b) -> b.comapareTo(a);
    	Arrays.sort(fruits,comp);
    	System.out.println(Arrays.binarySearch(fruits,"orange",comp));

    }
```

what is the result?

A 2

B -1

C 1

D -3

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans : C
    
    b的compareTo是降幕排序從後面往前比較
    所以 順序是 polo oran blue bana
    用binSerach找orange位置會在index為1的位置

</div>

**↑↑↑**

---

### Q123

given:

``` java

    public static void main(String[] args) {
    	Consumer<String> csl = s -> System.out.print(s);
    	cs1.accept("cs1 accept");
    	Consumer<String> cs2 = s -> System.out.print(s);
    	cs2.accept("cs2 accept");
    	cs2.andThen(cs1).accept("after accept");
    	cs2.accept("cs2 accept again");
    }
```

what is the result?

A 

    cs1 accept

    cs2 accept

    and followed by an Exception

B 

    cs1 accept

    cs2 accept

    after accept

    cs1 accept

    cs2 accept again

C
  
    cs1 accept

    cs2 accept

    after accept

    cs2 accept again

D

    cs1 accept

    cs2 accept

    after accept

    after accept

    cs2 accept again

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans : D
    
    Consumer 開源碼如下
``` java
    @FunctionalInterface
    public interface Consumer<T>{
         void accept(T t);
         default Consumer<T> andThen(Consumer<? super T> after){
         	Objects.requireNonNull(after);
         	return(T t)->{
         		accept(t);
         		after.accept(t);
         	}
         }
    }
```
   因此呼叫andthen之後

   會先是cs2.accept() 再來呼叫default 的cs1.accept()方法

   之後再持續下去

</div>

**↑↑↑**

---

### Q124

given:

``` java

    public class Exam{
    	static Map<String,String> map = new HashMap<>();
    	static List<String> list = new ArrayList<>(List.of("Y","A","T","B"));
    	static String[] arr = { "you","are","the","best"};

    	static {
    		for(var i=0;i <list.size();i++){
    			map.put(list.get(i),arr[i]);

    		}
    	}
    	public static void main(String[] args) {
    		list.clear();
    		arr = new String[0];
    		System.out.println("keys:" + list.size() + ", Values:" + arr.length() + ", Map:" + map.size() );
    	}
    }
```

what is the result?

A Keys:4,Values:4,Map:0

B Keys:4,Values:4,Map:4

C the compilation fails

D Keys:0,Values:0,Map:4

E Keys:0,Values:0,Map:0

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans : D
    
    行11將list成員清空
    又將arr指向長度為0的字串陣列,但都不影響map


</div>

**↑↑↑**

---

### Q125

given:

``` java

    class Worker{
    	private boolean done = false;
    	public void consumeResource(Resource resource){
    		while(!resource.isReady()){
    			System.out.println("waiting for a resouce");
    			try{
    				Thread.sleep(1000);
    			}catch(InterruptedException e){
    				e.printStackTrace();
    			}
    		}
    		setDone(true);
    	}
    	public boolean isDone(){
    		return done;
    	}
    	public void setDone(boolean done){
    		this.done = done;
    	}
    }
```

And:

``` java

    class Resource{
    	boolean ready;
    	public boolean isReady(){
    		return ready;
    	}
    	public void isReady(boolean ready){
    		this.ready = ready;
    	}
    	public void processWork(Worker worker){
    		  System.out.println("occupied by a worker");
    	}
    }
```
And:

``` java

    public static void main(String[] args) {
    	Resource resource = new Resource();
    	Worker worker = new Worker();
    	Thread t1 = new Thread( () -> resource.processWork(worker));
    	Thread t2 = new Thread( () -> worker.consumeResource(resource));
    	t1.start();
    	t2.start();
    }
```
which situation will occur on code fragment execution?

A livelock

B deadlock

C race Codition

D starvation

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans : D
    
    starvation長時間無法取的共享資源就會發生
    resource未設定ready=true就會一直發生



</div>

**↑↑↑**

---

### Q126

given:

``` java

    public class Exam{
    	class E extends Exception{}
        class EE extends E {}
        class R extends RuntimeException{}
        public void m1() throws E{
        	throw new EE();
        }  
        public void m2() throws R{
        	throw new R();
        }
        public static void main(String[] args) {
        	try{
        		Exam t = new Exam();
        		t,m1();
        		t.m2();
        	}catch /* replaced*/{
        		System.out.println("error");
        	}
        }
    }
```
what change on /* replaced /* will make this code compile

A (E|R e).

B (E|EE R e).

C (E e).

D (R|E|EEｅ)

E (EE|E e)

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :AC
    
    Exception一定要捕捉
    Runtime可抓可不抓
    EE和E有繼承關西 不能同時出現在mutiple catch敘述

    B 語法錯誤
    DE EE和E又繼承關西無法被同時寫入



</div>

**↑↑↑**

---

### Q127

given:

``` java

    public static void main(String[] args) {
    	try{ 
	    	Path path = Paths.get("C:\\java11");
	    	//optionA
	    	BasicFileAttributes attributesA = Files.isDirectory(path);
	    	//optionB
	    	BasicFileAttributes attributesB = Files.getAttribute(path,"isDirectory");
	        //optionC
	        BasicFileAttributes attributesC = Files.readAttributes(path,BasicFileAttributes.class);
	        //optionD
	        BasicFileAttributes attributesD = Files.readAttributes(path,FilesAttributes,class);
	    }catch(IOException e){
	    	e.printStackTrace();
	    }

    }
```

you want to examime whether path is a directory.which option will accomplist this ?

A optionA

B optionB

C optionC

D optionD

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :C
    
    A 可以宣告成boolean就可以編譯通過
    B則要再強轉型態成boolean也可以通過



</div>

**↑↑↑**

---

### Q128

given:

``` java

    public static void main(String[] args) {
    	Integer[] arr = {1,2,3};
    	var list = Arrays.asList(arr);
    	UnaryOperator<Integer> uo = x -> x*4;
    	list.replaceAll(uo);
    	System.out.println(list);
    }
```
which can replace line 4?

A unaryOperator<Integer> uo = (var x)->(x乘4)

B unaryOperator<Integer> uo = var x->{ return x乘4;};

C unaryOperator<Integer> uo =  x ->{ return x乘4;};

D unaryOperator<Integer> uo = (int x)-> x乘4;

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :AC
    
    輸入輸出型態可以相同
    AC 可以 B 要再加括弧
    D 型態要再改成Integer



</div>

**↑↑↑**

---

### Q129

given:

``` java

    public class Exam{
    	@MyField(type = MyField.Type.STRING,name = "name");
    	private String z;
    	@MyField(type = MyField.Type.NUMBER)
    	private int x;
    	@MyField(type = MyField.Type.NUMBER)
    	private int y;
    }
```

And:

``` java

  //optionA
  @Taget(ElementType.FIELD)
  @interface MyField{
  	   String name() default "";
  	   enum Type{
  	   	   NUMBER,STRING,BOOLEAN;
  	   }
  	   Type type();
  }
  //optionB
  @interface MyField{
  	   String name() ;
  	   enum Type{
  	   	   NUMBER,STRING,BOOLEAN;
  	   }
  	   Type type();
  }
  //optionC
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.METHOD)
  @interface MyField{
  	   String name() default "";
  	   enum Type{
  	   	   NUMBER,STRING,BOOLEAN;
  	   }
  	   Type type();
  }
```
what is the correct definition of the MyField annotation that makes the Exam class compile?

A optionA

B optionB

C optionC

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :A
    
    @myfield是用來標註欄位的 且可知name有預設值
    因此B 要加default
    C 要改成ElementType field



</div>

**↑↑↑**

---

### Q130

some organization makes funlib.jar avalible to your cloud customers,while working on a code clean up project for funlib.jar,you see this method by customers:

``` java

    public void myService(String hostname,String portNumber) throws IOException{
    	this.transportSocket = new Socket(hostname,portNumber);
    }
```
what security measures should be addded to this method so that it meets the requirements for a customer accessible method?

A insert this code before the call to new Socket:

    hostName = new String(hostName);
    portNumber = new String(portNumber);
B create a method that validates the hostName and portNumber parmeters before opening the socket

C make myservice private

D enclose the call to new Socket in an AccessController.doPrivileged block.

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :D
    
    可以確保客戶可以存取但是要加驗證控管



</div>

**↑↑↑**

---