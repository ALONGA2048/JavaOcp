### Q111

given:

``` java

    public static void main(String[] args) {
    	List<String> list1 = new ArrayList<>(List.of("Tiger","Lion","Human"));
    	List<String> list2 = new ArrayList<>(List.copyOf(list1));
    	list1.sort((String item1,String item2) -> item1.compareTo(item2));
    	list2.sort((String item1,String item2) -> item1.compareTo(item2));
    	System.out.println(list1.equals(list2));
    }
```
what is the result?

A a java.lang.UnsupportedOperationException is thrown

B true

C false

D A java.langNullPointerException is thrown

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:B
    
   如果直接用List.of建立則不可更改而報錯誤
   但用ArrayList包裹則可以


</div>

**↑↑↑**

---

### Q112

given:

``` java

    class Product{
    	double price;
    	public Product(double price){
    		this.price = price;
    	}
    	public double getPrice(){
    		return this.price;
    	}
    }
    class NoteBook extends Product{
    	public NoteBook(double price){
    		super(price);
    	}
    }
    class SmartPhone extends Product{
    	public SmartPhone (double price){
    		super(price);
    	}
    }
```

And:

``` java

     public class PriceChecker<T extends Product>{
     	private T product;
     	public PriceChecker(T product){
     		this.product = product;
     	}
        public boolean isPriceEqual(/* line 1*/ prod){
        	return this.product.getPrice() == prod.product.getPrice();
        }
        public static void main(String[] args) {
        	PriceChecker<NoteBook> a = new PriceChecker<>(new NoteBook(10.0));
        	PriceChecker<SmartPhone> b = new PriceChecker<>(new SmartPhone(9.0));
        	System.out.println(a.isPriceEqual(b));
        }
     }
```

what change will cause the code to compile successfully?

A insert PriceChecker<?> on line 1

B insert PriceChecler<T> on line 1

C insert PriceChecker<> on line 1

D insert PriceCheck<NoteBook> on line 1

E insert PriceCheck<SmartPhone extends Product> on line 1

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:A
    
   他想要比較Product以外的其他商品要是只用T則只能比較同一個類別的商品
   用<?> 則能輸入兩種不同商品


</div>

**↑↑↑**

---

### Q113

given:

``` java

    public class Exam{
    	public void writeTo(String filename){
	    		String[] arr = { "ABC" ,"abc","123"};
	    		//line 1
	    		for(String str:arr){
	    			ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
	    			fc.write(buffer);
	    		}
	    	 }catch(IOException e){
	    	 	e.printStackTrace();
	    	 }
    	}
    	public static void main(String[] args) {
    		 new Exam().write("file_to_path");
    	}
    }
```
you want to obtain the fileChammel fc on line 1. which code fragment will accomplish this?

A try(FileChannel fc = Channels.newChannel(new FileOutputStream(filename));){ 

B try(FileChannel fc =new FileOutputStream(filename).getChannel()){

C try(FileChannel fc =new FileOutputStream(new FileChannel(filename));){

D try(FileChannel fc =new FileChannel(new FileOutputStream(filename));){ 

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:B
    
   3.3 取得channl藥用getChannel方法


</div>

**↑↑↑**

---

### Q114

given:

``` java

    class Super {
        protected void write(Object obj){
            System.out.println(obj);
        }
        public final void write(Object... objects){
            for(Object object:objects){
                write(object);
            }
        }
        public void write(Collection collection){
            collection.forEach(System.out::print);
        }
    }
    class Sub extends Super{
        public void write(Object obj){
            System.out.println("[" + obj + "]");
        }
        public void write(Object... objects){
            for(Object object:objects){
                System.out.println("[" + objects + "]");
            }
        }
        public void write(Collection collection){
            write(collection.toArray());
        }
    }
```
why does this compilation fail?

A the method Sub.write(Object) does not call the method Super.write(object)

B the method Super.write(Object) is not accessible to Sub

C in method Super.write(Collection),System.out::println is an invalid java identifier

D the method write(Object) and the method write(Object...) are duplicates of each other

E the method Sub.write(Object...) cannot override the final method Super.write(Object)

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans:E
    
   A錯誤,和編譯失敗無關

   B錯誤,sub可以呼叫Super.write(object)

   C錯誤,System.out::println

   D 錯誤 此為overloading不會造成編譯失敗

   E 正確 無法override 父類別的final方法



</div>

**↑↑↑**

---

### Q115

given:

``` java

    //optionA
    float chechFloat(String s) throws IllegalArgumentException{
        return Float.parseFloat(s);
    }
    //optionB
    float checkFloat(String s,float min,float max) throws IllegalArgumentException{
        float f = Float.parseFloat(s);
        if(!Float.isFinite(f) || f<min || f>max){
            throws new IllegalArgumentException();
        }
        return f;
    }
    //optionC
    float checkFloatC(String s,float min,float max) throws IllegalArgumentException{
        float f = Float.parseFloat(s);
        if(f<min || f>max){
            throw new IllegalArgumentException();
        }
        return f;
    }
    //optionD
    float checkFloatD(String s,float min,float max) throws IllegalArgumentException{
        float f = Float.parseFloat(s);
        if(Float.isFinite(f) && f < min && f > max){
            throw new IllegalArgumentException();
        }
        return f;
    }
```
which method throws an exception for not-a-number and infinite input values

A optionA

B optionB

C optionC

D optionD

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans:B
    
   輸入是(not-a-number)或無限的浮點數時回傳false
   最後比較 !isFinite及其他上下限條件就拋出錯誤



</div>

**↑↑↑**

---

### Q116

there is a copyService API module that has the org.copyservice.spi.Copy interface. To use this service in a module,which module-info.java would be correct?

``` java

   //option A
   module CopyCosumner{
        requires CopyServiceAPI;
        uses org.Copyservice.spi.Copy;
   }
   //option B 
   module CopyConsumer{
     requires transitive org.copyservice.spi.Copy;
   }
   //option C
   module CopyConsumer{
      requires org.copyservice.spi.Copy;
   }
   //option D
   module CopyConsumer{
      uses CopyServiceAPI;
   }
```
---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans:A
    
    14.5.2建立服務模組



</div>

**↑↑↑**

---

### Q117

given:

``` java

    public static void main(String[] args) {
        List<Integer> intergers = List.of(11,12,13,14,15);
        int sum = intergers.stream().reduce(0,(n,m) -> n + m);//line 1

    }
```
you want to make the reduction operation parallelized. which two modifications will accomplish this by replace line 1

A int sumA = intergers.stream().iterate(0,a-> a.reduce(n m)-> n+m);

B int sumB = intergers.parallelStream().reduce(0,(n,m) -> n +m);

C int sumC = intergers.parallel().stream().reduce(0,(n,m) -> n +m);

D int sumD = intergers.stream().flatMap(a -> a.reduce(0,(n,m) -> n +m));

E int sumE = intergers.stream().parallel().reduce(0,(n,m)-> n+m);

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans:BE
    
    10.6.2
    Collection發動 使用parallelStream()方法
    Stream 發動平行化時 必須在尾端呼叫



</div>

**↑↑↑**

---

### Q118

A.

module com.company.clients{
    uses com.company.clients;
}

B.

module com.company.clients{
    requires com.company.clients;
}

C.

module com.company.client {
    exports com.company.clients.Client;
}

D.

module com.company.clients{
    exports com.company.clients;
}

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans:D
    
    在建立新套件時應該匯出套件




</div>

**↑↑↑**

---

### Q119

given:

``` java

    CREAtE TABLE Employee (
        ID INTEGER NOT NULL,
        NAME VARCHAR(40),
        PRIMARY KEY (ID)
    );
```

And:

``` java

    public static void main(String[] args) {
            String url = "jdbc:derby://localhost:1527/...";
            String username = "..";
            String password = "..";
            try(Coonection conn = DriverManager.getConnection(url,username,password);
                PreparedStatement stmt = conn.preparedStatement("INSERT into Employee values (?,?)");)
            {
                stmt.setInt(1,101);
                /*line 1*/
                stmt.executeUpdate();
            }
        }    
```
which statement inserted on line 1 sets NAME column to a NULL value?

A stmt.setNull(2,java.sql.Types.VARCHAR);

B stmt.setNull(2,String.class);

C stmt.setNull(2,null);

D stmt.setNull(2,java.lang.String);

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans : A
    
    setNull兩參數需填入int 而type.varchar正是定義好的int參數

</div>

**↑↑↑**

---

### Q120

you want to implement the java.io.Externalizable interface to the SerializableData class.

which method should be overridden?

A the readExternal and writeExternal method

B the readExternal method

C the writeExternal method

D nothing

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans : A
    
    改寫readExternal和writeExternal就可以自訂需序列化的欄位

</div>

**↑↑↑**

---