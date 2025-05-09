### Q91

given:

``` java

    enum WeatherType{
    	WED,DRY
    }
```
And:

``` java

    @Document
    public @interface Weather{                 //line1
    	 String description() default "";      //line2
    	 boolean sunny() = "true";             //line3
    	 public WeatherType weatherType();     //line4
    	 private static final int temperature = 25; //line5

    }
```
which of the following lines in this code do not compile?(choose all that apply)

A line1

B line2

C line3

D line4

E line5

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:CE
    
    12.2 建立自定義標註型別
    C 改成 boolean sunny() default "true";
    可以編譯
    標註型別的屬性完素 修飾詞 只能是public abstract 欄位只能是public static final
    E 必須要移除private 改成publc

</div>

**↑↑↑**

---

### Q92

given:

``` java

    public static void main(String[] args) {
    	List<Integer> list = List.of();
    	list.add(0,-1);
    	list.add(0,-2);
    	list.add(0,-3);
    	System.out.println(list);
    }
```

what is the output?

A the compilation fails

B [-1,-2,-3]

C [-3,-2,-1]

D a runtime exception is thrown

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:D
    
   List.of方法會建立不可變動的list 所以再編譯時期可以通過
   但在執行時期想要輸入則會拋出 UnsupportedOperationException


</div>

**↑↑↑**

---

### Q93

which ccommend line runs the main class com.exam.Main from the Module com.example

A java --module-path mods com.example/com.exam.Main

B java -classpath com.example.jar com.exam.Main

C java --module-path mods -m com.example/com.exam.Main

D java -classpath com.example.jar m com.example/com.exam.Main

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:C
   使用--module-path 指定模組路徑
   用--module 或-m 指定執行的 (模組名稱/類別名稱)


</div>

**↑↑↑**

---

### Q94

given:

``` java

public class Test{
	static Map<String,String> map = new HashMap<>();
	static List<String> keys = new ArrayList<>(List.of("1","2","3","4"));
	static String[] values = { "alpha","beta","gamma","delta"};
	static{
		for(var i=0; i<keys.size();i++){
			map.put(keys.get(i),values[i]);
		}
	}
	public static void main(String[] args) {
		keys.clear();
		values = new String[0];
		System.out.println("Map: "+ map.size() + "keys: " +keys.size() + " values: " +values.length);

	}
}
```
what is the result ?

A Map: 0 Keys: 0 Values: 0

B the compilcation fails

C Map: 4 Keys: 4 Values: 4

D Map: 4 Keys: 0 Values: 0

E Map: 0 Keys: 4 Values: 4

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:D

    main第一行清空keys的內容
    values 指向了空陣列


</div>

**↑↑↑**

---

### Q95

given:

``` java

    class Super{
    	private Collection collection;
    	public void set(Collection collection){
    		this.collection = collection;
    	}
    }
    class Sub extends Super {
    	public void set(Map<String,String> map){
    		super.set(map); //line1
    	}
    }
```
which two lines can replace line 1 so that the sub class compiles(choose two)

A map.forEach((k,v)-> set(v));

B set(map.values());

C super.set(List<String> map);

D super.set(map.values());

E set(map);

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:BD

    父類別 set跟子類別set不是覆寫關西 因為Map不屬於Collection
    介面Map<k,v> 的values()方法可以取出所有的值成為Collection<v> 因此B和D可以通過編譯
    E也可以通過編譯但執行時會造成無窮迴圈 所以排除


</div>

**↑↑↑**

---

### Q96

given:

``` java

    public class Exam{
    	public static void main(String[] args) {
    		try{
    			mod();
    		}//line1
    	}
    	static void mod() throws IOException,ArrayIndexOutOfBoundsException{
    		if(false){
    			throw new FileNotFoundException();
    		}else{
    			throw new ArrayIndexOutOfBoundsException();
    		}
    	}
    }
```

what must be added in line 1 to compile this class?

A catch(IOException e){}

B catch(FileNotFoundException | ArrayIndexOutOfBoundsException e){}

C catch(FileNotFoundException | IOException e){}

D catch(ArrayIndexOutOfBoundsException e) {} catch(FileNotFoundException ){}

E catch(FileNotFoundException ){} catch(IndexOutOfBoundsException e){}


---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:A

    因為ArrayIndex是 uncheckException 所以line 1只要捕捉IOException就好 且不可以是子類別



</div>

**↑↑↑**

---

### Q97

given:

``` java

    public class Both<T>{
    	final BiFunction<T,T,Boolean> validator;
    	T one = null;
    	T other = null;
    	private Both(){
    		validator = null;

    	}
    	Both(BiFunction<T,T,Boolean> v,T x,T,y){
    		validator = v;
    		set(x,y);
    	}
    	void set(T x,T y){
    		if(!validator.apply(x,y))
    			throw new IllegalArgumentException();
    		setOne(x);
    		setOther(y);
    	}
    	void setOne(T x){
    		one = x;
    	}
    	void setOther(T y){
    		other = y;
    	}
    	final boolean isVaild(){
    		return validator.apply(one,other);
    	}
    }
```
it is required that if b instanceof Both then b.isValid() return true.

which is the smallest set of visibility changes to ensure this requirement is met?

A setOne() and setOther must be protected

B one and other must be private

C isVaild() must be public 

D one,other,setOne() and setOther() must be private

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:D

    避免物件成員被異動或修改
    需要將欄位設為private 更動欄位的方法也是



</div>

**↑↑↑**

---

### Q98

given:

``` java

    class Super{
    	public <T> Collection<T> run(Collection<T> arg){
    		return null;
    	}
    	class Sub extends Super{
    		//....
    	}
    }
```
which two statement are true if the method is added to Sub(choose two)

A public Collection<String> run(Collection<String> ard){...} overrides Super.run()

B public<T>Collection<T>run(Stream<T> arg){...} overloads Super.run().

C public <T>List<T> run(Collection<T> arg){...} overrides Super.run()

D public<T>Collection<T>run(Collection<T> arg){...} overloads Super.run().

E public<T>Collection<T>walk(Collection<T> arg){...} overloads Super.run().

F public<T>Iterable<T>run(Collection<T> arg){...} overrides Super.run().

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:BC
  
    B 方法名稱相同且參數不同是overload
    C 方法簽名相同 回傳子類別是override
    D 是overload
    E 方法名稱不同完全不一樣
    A 編譯失敗 NameClash



</div>

**↑↑↑**

---

### Q99

given:

``` java

    public static void main(String[] args) {
    	String[] fruitArr = {"Banana" ,"Orange", "Grape","Lemon" ,"Blackberries","watermelon"};
    	var fruitList = new ArrayList<>(Arrays.asList(fruitArr));
    	fruitList.sort((var a,var b)-> -a.compareTo(b));
    	fruitList.forEach(System.out::print);
    }
```
what is the result?

A watermelonOrangeLemonGrapeBlackberriesBanana

B nothing

C BananaBlackberriesGrapeLemonOrangeWatermelon

D BlackberriesBananaGrapeLemonOrangeWatermelon

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:A
  
    以sort 比較每個字的開頭並反向排列再印出來


</div>

**↑↑↑**

---

### Q100

given:

``` java

    for(int i=1;i<5;++i){
    	System.out.print(i);
    }
```
And:

``` java

 public static void main(String[] args) {
 	//optionA
 	Stream<Integer> streamA = Stream.iterate(1, n->n<=5,n ->n+2);
 	streamA.forEach(System.out::print);
 	//optionB
 	Stream<Integer> streamB = Stream.iterate(1, n-> n<5,n ->n+1);
 	streamA.forEach(System.out::print);
 	//optionC
 	Stream<Integer> streamC = Stream.iterate(1; n->n< 5;n ->n+1);
 	streamA.forEach(System.out::print);
    //optionD
    Stream.iterate(1,n->n<=5,n->n+1).forEach(System.out::print());
    //optionE
    Stream.iterate(1;n->n<=5;n->n+1).forEach(System.out::print());
    

 }
```
which of the preceding produces the same result as the given fo loop?

A optionA

B optionB

C optionC

D optionD

E optionE

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
	   
    Ans:B
  
    C,E編譯失敗不能使用分號
    A +2錯誤
    D 超出範圍+1


</div>

**↑↑↑**

---