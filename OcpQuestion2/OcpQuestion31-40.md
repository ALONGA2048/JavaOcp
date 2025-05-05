### Q31

given:

``` java

	@Target(ElementTpye.METHOD)
	@Retention(RetentionPolicy.RUNTIME)

	public @interface BookInfo{
		String author() default "";
		String date();
		String[] comments() default{};
		
			
	}
```

And:

``` java

    //optionA
    @BookInfo(date = "1-1-2022",comments={null})
    class ClassA{
    	public void func(){
    	}

    }
    //optionB
    class ClassB{
    	@BookInfo(date = "1-1-2022",comments = "good")
    	public void func(){}

    }
    //optionC
    class ClassC{
    	@BookInfo
    	public void func(){
    	}

    }
    //optionD
    @BookInfo(date = "1-1-2022")
    class ClassD{
    	public void func(){
    	}

    }
    //optionE
    class ClassE{
    	@BookInfo(date="1-1-2022",comments="good",author = "duke")
    	public void func(){}
    }
```
which two options are correct(choose two)

A optionA

B optionB

C optionC

D optionD

E optionE

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : BE

   標籤要設在class內部 且沒有DEFAULT的值一定要做不然會報錯
    
</div>

**↑↑↑**

---

### Q32

given:

``` java

    public static void main(String[] args) {
    	try{
    		Path path = Path.get("/test/myfile.txt");
    		boolean result = Files.deleteIfExists(path);
    		if(result)
    			System.out.println(path + " is deleted.");
            else 
            	System.out.print(path + "is not deleted");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
```
Assume the file on path does not exist. what is the result?

A the compilation fails

B Prints: /test/myFile.txt is not deleted

C Exception

D Prints: /test/myFile.txt is deleted.

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : B
   
   檔案沒被刪除所以回傳false 因此印出not deleted

</div>

**↑↑↑**

---

### Q33

given:

``` java

    class Person implements /*line 1*/{
    	 private String name;
    	 Person(String name ){
    	 	this.name = name;
    	 	
    	 }
    	 //line2
    }
```
And

``` java

    public static void main(String[] args) {
    	Person[] people = {new Person("joe"),new Person("jim"),new Person("john")};
    	Arrays.sort(people);
    	for(Person p: people){
    		System.out.println(p.name);
    	}    
    }
````
you want to code the produce this output

john
joe
jim

which code fragment should be inserted on line 1 and line2 to produce the output?

A.

line 1: Comparator<Person>

line 2:
public int compare(Person p1,Person p2){
	return p1.name.compare(p2.name);
}

B.

line 1: Comparable<Person>

line 2:
public int compareTo(Person person){
	return person.name.compareTo(this.name);
}

C.

line 1: Comparable<Person>

line 2:
public int compare(Person p1,Person p2){
	return p1.name.compare(p2.name);
}

D.

line 1: Comparator<Person>

line 2:
public int compare(Person person){
	return person.name.compare(this.name);
}

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : B
   
   sort方法是使用compareTo方法(且只能傳入一個參數)

   再來就是使用comparetor 中的compare方法(可以傳入兩個參數)

</div>

**↑↑↑**

---

### Q34

given:

``` java

    class CustType<T>{
    	public <T> int count(T[] arr,T elem){
    		int count = 0;
    		for(T e: arr){
    			if(e.equals(elem))
    				++count;
    		}
    		return count;
    	}
    }
```

And:

``` java

    public class Test extends CustType{
    	public static void main(String[] args) {
    		String[] words = {"blackberry","orange","apple","grape"};
    		Integer[] numbers = {1,2,3,4,5};
    		CustType type = new CustType();
    		CustType<String> CusType = new CustType<>();
    		System.out.println(CusType.count(words,"apple"));
    		System.out.println(type.count(words,"apple"));
    		System.out.println(type.count(numbers,"3"));
    	}
    }
```

what is the result?

A a nullPointerException is thrown at run time

B the compliation fails

C 1
  1
  1

D 1

E a classCastException is thrown in runtime

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : C
   
   1.不使用泛型也不影響編譯
   2.泛型未指定型態則以object型態處理,執行時期扔然可以取得正確型態


</div>

**↑↑↑**

---

### Q35

which statement about a funtional interface is true?

A it must defined with the public access modifier

B it must be annotated with @FuntionalInterface

C it is declared with a single abstract method

D it is declared with a single default method

E it cannot have any private method and static methods

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : C
   
   A 也可以是default

   B 不一定要加 但可以透過標籤讓編譯器檢查

   C,D 主要的核心規定就是只能有一個抽象方法

   E 可以有static和private方法

</div>

**↑↑↑**

---

### Q36

given:

``` java

    public class Test {
    	public static void main(String[] args) {
    		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
    			System.out.print("Key in");
    			String data = br.readline();
    			System.out.print("Echo: "+ data);
    		}catch(IOException e){
    			e.printStackTrace();
    		}
    	}
    }
```

And the commend:

java Test HelloWorld

what is the result?

A key in:Echo:

B Key in: helloworld Echo:helloworld

C Key in:
  then block until any input comes from System.in

D key in:
  Echo: hello world

E A nullPointerException is thrown at runtime

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : C
   
   在指令列提供的字串會變成main方法的參數與System.in無關
   因此console會等待使用者提供輸入

</div>

**↑↑↑**

---

### Q37

given:

``` java

    public static void main(String[] args) {
    	//optionA
    	Runnable rA = "Message"->System.out.print();
    	//optionB
    	Runnable rB = ()-> System.out::print;
    	//optionC
    	Runnable rC = ()->{
    		System.out.print("Message");
    	};
    	//optionD
    	Runnable rD = ->System.out.print("Message");
    	//optionE
    	Runnable rE = {System.out.print("Message")};

    }
```
which option is correct?


---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : C
   
   A 括弧要加

   B 不能使用參照方法(是void)

   D 括弧要加

   E 括弧箭頭要加

   ps: 參照方法是省略單輸入的方法 如System.out::println === x->System.out.println(x)
   

</div>

**↑↑↑**

---

### Q38

given:

``` java

    public static void main(String[] args) {
        List<String> list = Arrays.asList("grape","orange","banana");
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = c1.andThen(x-> System.out.println(":" + x,toUpperCase()));
        list.forEach(c2);
    }
```

what is the output?

A :GRAPE:ORANGE:BANANAgrapeorangebanana

B :GRAPE:ORANGE:BANANA

C GRAPE:grapeORANGE:orangeBANANA:banana

D grape:GRAPEorange:ORANGEbanana:BANANA

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : E
   
   先從list的foreach 將每個字串實作
   方法則是先執行c1接andthenc2的延伸方法

</div>

**↑↑↑**

---

### Q39

given:

``` java

    class CommonException /* line 1 */ {
        public CommonException(String s){
            super(s);
        }
    }
    class SpecificException /* line 2*/ {
        public SpecificException(String s){
            super(s);
        }
    }
``` 

And:

``` java

    public class Main{
        public static void stuff() throws CommonException{
            try{
                throw new RuntimeException("SomeThing is wrong");
            }catch (Exception e){
                throw new SpecificException(e.getMessage());
            }
        }
        public static void main(String[] args) {
            try{
                Main.stuff();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
```

which option should you choose to enable the code to print Something wrong?

A Add extends CommonException on line1
  Add extends Exception on line 2

B Add extends SpecificException on line 1
  Add extends CommonException on line 2

C Add extends Exception on line 1
  Add extends Exception on line 2

D Add extends Exception on line 1
  Add extends CommonException on line 2

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : D
   
   CommonException 必須是SpecificException 的父類別且兩者都是Exception

</div>

**↑↑↑**

---

### Q40

given:

```   java

    public static void main(String[] args) {
        List<Reader> readers = new ArrayList<>();
        File indexFile = new File("file-list.txt");
        try(BufferedReader indexReader = 
                new BufferedReader(new FileReader(indexFile))){
            for(String file = indexFile.readline();
              file !=null;
              file=indexReader.readline()){
                BufferedReader dataReader = 
                new BufferedReader(new FileReader(new File(file));//line 1
                readers.add(dataReader);//line2
                dataProcessing(dataReader);//line3

            }
        }catch(IOException e){
        }finally{
            for(Reader r:readers){
                try{
                    r.close();
                }catch(IOException ex){}
                //line4
            }
        }
    }
    private static void dataProcessing(BufferedReader dataReader){
         //...
    }
```
what will secure this code from a protentical Denial of Service condition?

A After line4,add indexReader.close().

B on line3,enclose dataProcessing(dataReader) with try with resources

C After line3,add dataReader.close().

D on line 1,use try with resources when opening each dataReader.

E before line1,check the size of indexfile to make sure it does not exceed a threshold.

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : E
   
   a到d沒需要 兩個reader都會關閉
   
   E 可以限制indexfile大小避免迴圈資源處理過多


</div>

**↑↑↑**

---
