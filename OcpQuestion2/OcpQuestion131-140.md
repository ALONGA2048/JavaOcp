### Q131

given:

``` java

    public class Exam{
    	public static String convert(int x){
    		if(x%15 ==0) return "Exam";
    		else if (x%3 == 0) return "Exam";
    		else if (x%5 == 0) return "Exam";
    		else return Integer.toString(x);
    	}
    	public static void main(String[] args) {
    		for(int i=1;i<16;i++){
    			System.out.print(convert(i));
    		}
    	}
    }
```
which code frament replace the for statement ?

A IntStream.rangeClosed(1,15).map(Exam::convert).forEach(System.out::println);

B IntStream.range(1,15).map(Exam::convert).forEach(System.out::println);

C IntStream.rangeClose(1,15).mapToObj(Exam::convert).forEach(System.out::println);

D IntSteam.range(1,15).mapToObj(Exam::convert).forEach(System.out::println);

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :C
    
    AB 都編譯失敗因為exam.convert 輸出的是String 要是使用map則導入導出都為int 如果是toObj則可以是任意型別
    而rangeClose則是可以含最後一個數 range則不會




</div>

**↑↑↑**

---

### Q132

given:

``` java

    //optionA
    new Comparator<String>(){
    	public int compare(String str1,String st2){
    		 return str1.compareTo(st2);
    	}
    }
    //optionB
    class ComparatorB implements Comparator{
    	public boolean compare(Object o1,Object o2){
    		return o1.equals(o2);
    	}
    }
    //optionC
    class ComparatorC implements Comparator{
    	 @Override
    	 public int compare(String st1,String st2){
    	 	 return str1.length() - str2.length();
    	 }
    }
    //optionD
    new Comparator<String>(){
    	 public int compareTo(String str1,String str2){
    	 	return str1.compareTo(str2);
    	 }
    }
```
which code fragment represent a vaild Comparator implementation

A optionA

B optionB

C optionC

D optionD

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :A
    
    A 有匿名類別指定String所以可以通過
    B 回傳值限定為int或其子類別
    C 未指定其泛型正常來說型別應為object 但其為String
    D 其可實作方法為compare compareTo是Comparable的方法

</div>

**↑↑↑**

---

### Q113

given:

``` java

    public static void main(String[] args) {
    	List<String> fruits = List.of("grape","orange","banana","lemon");
    	Stream<String> s1 = fruits.stream();
    	Stream<String> s2 = s1.peek(i-> System.out.print(i + " "));
    	System.out.println("-----");
    	Stream<String> s3 = s2.sorted();
    	Stream<String> s4 = s3.peek(i-> System.out.print(i + " "));
    	System.out.println("-----");
    	String sf = s4.collect(Collectors.joining(","));
    }
```

what is the output?

A 
   grape orange banana lemon

   "-----"

   banana grape lemon orange

   "-----"

B
   "-----"

   grape orange banana lemon

   "-----"

   banana grape lemon orange

C
  "-----"

  "-----"

D

  "-----"

  "-----"

  grape orange banana lemon banana grape lemon orange

E

  grape orange banana lemon banana grape lemon orange

  "-----"

  "-----"

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :D
    
    peek只會在有終端方法的時候實作 sorted則不會

</div>

**↑↑↑**

---

### Q134

given:

``` java

    public static void main(String[] args) {
    	String[] fruitName = { "apple" , "grape" ,"orange" , "banana" , "lemon"};
    	var fruits = new ArrayList<>(Arrays.asList(fruitName));
    	fruits.sort((var a,var b) -> a.compareTo(b));
    	fruits.forEach(System.out::println);
    }
```

what is the result?

A 

   orange

   lemon

   grape

   banana

   apple
B

   apple

   banana

   grape

   lemon

   orange
C
  nothing

D 
  apple

  lemon

  grape

  banana

  orange

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :B
    
    有升幕,若是將b.compareTo(a)的話則為降幕排序


</div>

**↑↑↑**

---

### Q135

given:

``` java

    public static void main(String[] args) {
    	var fruits = List.of("grape","orange","banana","lemon");
    	//line 1
    	fruits.forEach(funtion);
    }
```

which statement on line 1 enables this code to compile ?

A Function<String,String> function = x-> x.substring(0,2);

B Supplier<String> function = ()->fruits.get(0);

C Predicate<String> function = a-> a.equals("banana");

D Consumer<String> function = (String f) -> {System.out.println(f);};

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :D
    
    forEach這個方法接受Consumer方法其他沒接受(以語意來說也合理 終端方法當然需要可以實作者 而不是其他功能


</div>

**↑↑↑**

---

### Q136

given:

``` java

    public class Test{
    	public static void main(String[] args) {
    		System.out.println("Result: " + convert("p").get());

    	}
    	private static Optional<Integer> convert(String s){
    		try{
    			return Optional.of(Integer.parseInt(s));
    		}catch(Exception e){
    			return Optional.empty();
    		}
    	}
    }
```

what is the result?

A Result:

B java.util.NoSuchElementException is thrown at runtime.

C the compilcation fails

D Result:p

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :B
    
    因為不是數字參數所以錯誤回傳Optional.empty() 但對其使用get則會引發 NoSuchElementException 


</div>

**↑↑↑**

---

### Q137

given:

``` java

    public static void main(String[] args) {
    	char[] charArray = new char[128];
    	try(FileReader reader = new FileReader("File_with_path")){
    		//line 1
    		System.out.println(String.valueOf(charArray));
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
```

you want to read data through the reader object

which statement inserted on line 1 will achieve this?

A reader.read(charArray)

B reader.readLine();

C charArray = reader.read();

D charArray.read();

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :A
    書3.1.2
    
    讀入時要呼叫read方法其傳入參數可以char陣列才能取的其讀取的全部char


</div>

**↑↑↑**

---

### Q138

given:

``` java

    public static void main(String[] args) {
    	var fruits = List.of("grape","orange","banana","lemon");
    	Optional<String> fru = fruits.stream().filter(f-> f.contains("n")).findAny(); //line1
    	System.out.println(fru.get());
    }
```

you replace the code on line 1 to use ParallelStream which is correct?

A the complication fails

B the code will produce the same result

C a java.util.NoSuchElementException is thrown at runtime

D the code may produce a different result 

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :D
    
    
    多執行續平行處理可能會使結果不一樣


</div>

**↑↑↑**

---

### Q139

given:

``` java

    public class Exam{
    	public static String alpha = "alpha";
    	protected Stream beta = "beta";
    	private final String delta;
    	public Exam(String s){
    		delta = alpha +s;
    	}
    	public String mod(){
    		return beta +=delta;
    	}
    }
```
which change would make Foo more secure?

A public String beta = "beta";

B protected final String beta = "beta";

C public static final String alpha = "alpha";

D private String delta;

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :C
    
    
   A 放寬權限不會比較安全
   B beta 改為final 不能修改導致編譯錯誤
   D 會導致被竄改的風險


</div>

**↑↑↑**

---

### Q140

given:

``` java

   @interface Resource{
   	    String[] value();
   }
```

Examine this code fragment:

/* loc1 /* class Test{....}

which2 annotations may be applied at Loc1 in the code frament

A @Resource()

B @Resource("s1")

C @Resource({"s1","s2"})

D @Resource

E @Resource(value = { {} })

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
       
    Ans :BC
    
    value 為必要元素所以AD編譯失敗
    且標註型別屬性步允許2維陣列 所以E編譯失敗
    若陣列 單一元素則可以省列大括號 如果是兩個以上的元素則必須使用大括號

</div>

**↑↑↑**

---
