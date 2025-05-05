
### Q41

A company has an existing sales application using a java 8 jar file containing packages:

exam.company.customers;

exam.company.customer.orders;

exam.company.customer.info;

exam.company.sales;

exam.company.leads;

exam.company.closed;

exam.company.orders;

exam.company.orders.pending;

exam.company.orders.shipped;

To modularize this jar file into three modules,customer,sales,and orders,which module-info.java would br correct?

A.

module exam.company.customer{
	opens exam.company.customer;
}

module exam.company.sales{
	opens exam,company.sales;
}

module exam.company.orders{
	open exam.company.orders;
}

B.

module exam.company.customer{
	exports exam.company.customer;
}

module exam.company.sales{
	exports exam,company.sales;
}

module exam.company.orders{
	exports exam.company.orders;
}

C.

module exam.company.customer{
	requires exam.company.customer;
}

module exam.company.sales{
	requires exam,company.sales;
}

module exam.company.orders{
	requires exam.company.orders;
}

D.

module exam.company.customer{
	provides exam.company.customer;
}

module exam.company.sales{
	provides exam,company.sales;
}

module exam.company.orders{
	provides exam.company.orders;
}

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : B

    用戶端不能出錯必須用exports公開之後再用requires綁定使用其資料
    
</div>

**↑↑↑**

---

### Q42

given:

``` java

    public static void main(String[] args) {
    	String p = "test\\projects\\a-project\\..\\..\\final-project";
    	Path normalized = Paths.get(p).normalize();
    	System.out.print(normalized);
    }
```

what is the result?

A test\final-project

B test\projects\a-project\final-project

C test\\projects\\a-project\\..\\..\\final-project

D test\projects\a-project\..\..\final-project

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : A

    "\\" 是字串顯示方式 正常來說會轉換成"/"來避免攏長

    而..是代表返回上一頁 因此正常取代"\\"->"\"後再將返回鍵省略

    就變成test\final-project

</div>

**↑↑↑**

---

### Q43

given:

``` java 

    public static void main(String[] args) {
    	Consumer c = msg -> System.out::println;
    	c.accept("hello world");
    }
```
This code results in a compilation error.

which code should be inserted on line 1 for a successful compilcation?

A Consumer c = msg->{ return System.out.print(msg);};

B Consumer c = var arg -> {System.out.print(arg);};

C Consumer c = (String args) -> System.out.print(args);

D Consumer c = System.out::print;

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : D

    A,B沒有括弧

   C 在未指定泛型的情況下是Object的型別所以應該改成
   (Object arg)-> System.out.print(arg);

   或是先指定<String>這樣就可以執行了

</div>

**↑↑↑**

---

### Q44

``` java

    public static void main(String[] args) {
    	int arr[][] = {{5,12},{10,14},{9,3}};
    	long count = Stream.of(arr)
    	             .flatMapToInt(IntStream::of)
    	             .map(n->n+1)
    	             .filter(n->(n%2==0))
    	             .peek(System.out::print)
    	             .count();
    	System.out.println(" "+count);
    }
```

what is the result?

A 6910 3

B 10126 3

C 3

D 6104 3

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : D

   使用flatMapToInt()轉成IntStream後為5,12,10,14,9,3
   經過5 map(n->n+1)方法後 加一成為 6,13,11,15,10,4
   filter後 成6,10,4
   因此peek會輸出6104 行9會輸出3
   要是有終端操作peek就會執行其運作就是依照流水流程先經過peek後再執行count直到整條跑完

</div>

**↑↑↑**

---

### Q45

which is a proper JDBC URL?

A jdbc.mysql.com://localhost:3306/mydb

B http://localhost.mysql.com:3306/mydb

C http://localhost.mysql.jdbc:3306/mydb

D jdbc:mysql://localhost:3306/mydb

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : D

   jdbc之檔案格式皆為 jdbc:開頭

</div>

**↑↑↑**

---

### Q46

given:

``` java

    public class SerializeLab implements Serializable{
    	 String msg;
    	 LacalDateTime created;
    	 transient LacalDateTime upDated;
    	 SerializeLab(String message){
    	 	this.msg = message;
    	 	this.created = LocalDateTime.now();
    	 }
    	 private void readObject(ObjectInputStream in){
    	 	try{
    	 		in.defaultReadObject();
    	 		this.updated = LocalDateTime.now();
    	 	}catch(Exception e){
    	 		e.printStackTrace();
    	 	}
    	 }
    }
```
when is the readObject() method called ?

A before this  object is deserialized

B after this object is deserialized

C before this object is serialized

D the method is never called

E after this object is serialized

---

### Q45

which is a proper JDBC URL?

A jdbc.mysql.com://localhost:3306/mydb

B http://localhost.mysql.com:3306/mydb

C http://localhost.mysql.jdbc:3306/mydb

D jdbc:mysql://localhost:3306/mydb

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : B
   
   15.4.3 見詳解

</div>

**↑↑↑**

---

### Q47

given:

``` java

    static void sort(int[] arr){
    	int n = arr.length;
    	for(int j=1;j<n;j++){
    		int tmp = arr[j];
    		int i=j-1;j;
    		while((i>-1) && (arr[i] >tmp)){
    			arr[i+1] =arr[i];
    			i--;
    		}
    		arr[i+1] = temp;
    	}
    }
 ```

 After which line can we insert assert (i<0|| arr[i] <= arr[i+1]); to verify that the arr array is partially sorted

 A after line 8

 B after line 6

 C after line 5

 D after line 10

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : D
   
   最佳驗證時機是在for迴圈每個loop 結束的時候 執行時也不會拋出AssertionError


</div>

**↑↑↑**

---

### Q48

given:

``` java

    public static void main(String[] args) {
    	List<String> l1 = new ArrayList<>();
    	l1.add("X");
    	l1.add("Y");
    	List<String> l2 = List.copyOf(l1);
    	l2.add("z");
    	List<List<String>> l3 = List.of(l1,l2);
    	System.out.println(l3);
    }
```
what is the result?

A [[X,Y],[X,Y]]

B an exception is thrown at run time.

C [[X,Y],[X,Y,Z]]

D [[X,Y,Z],[X,Y,Z]]

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : B
   
   of所創造出來的陣列都是不可改動的固定陣列



</div>

**↑↑↑**

---

### Q49

given:

``` java

    public class Secret{
    	String[] items;
    	public Secret(String[] items){
    		this.items = items;
    	}
    	public String[] getNames(){
             return items;
    	}
    }
```

which three actions implements java SE security guidelines?(choose three)

A change line 7 to return names.clone();

B change line 4 to this.names = names.clone();

C change the getNames() method name to get$Names()

D change line 6 to public synchronized String[] getNames(){ 

E change line 2 to private final String[] names;

F change line 3 to private Secret(String[] names){ 

G change line 2 to protected volatile String[] names.

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : ABE
   
   安全的撰寫方式便是使欄位為final private

   並回傳值都用clone方法取得避免被修改



</div>

**↑↑↑**

---

### Q50

given:

``` java

    public static void main(String[] args) {
    	Integer[] arr = {2,1,5,4,3};
    	List<Integer> list = new ArrayList<>(Arrays.asList(arr));
    	list.parallelStream().forEach(element -> System.out.print(element + " "));

    }
```

which two are correct(choose two)

A the output will be exactly 2 1 5 4 3

B the program prints 1 4 2 3 5,but the order is unpredictable

C Replacing forEach() with forEachOrdered() the program prints 2 1 5 4 3,but the order is unpredictable.

D replacing forEach() with forEachOrdered(), the program prints 1 2 5 4 3

E replacing forEach() with forEachOrdered(), the program prints 2 1 5 4 3

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : BE 
   
   parallel可以使stream平行處理因此forEach輸出是任意的順序

   所以想按照順序可以呼叫forEachOrdered() 但效能較低



</div>

**↑↑↑**

---
