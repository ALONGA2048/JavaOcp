### Q61

A bookstore sales are represented by a list of Sale objects populated with the name of the reader and the books they purchased

``` java

   class Sale{
   	  private String reader;
   	  private List<Book> books;
   	  //constructor,setter and getter
   }
```
give a list of sale object,saleList,which code fragment creates a list of total sales for each reader in ascending oreder

``` java

   public static void main(String[] args) {
   	   List<Book> book1 = List.of(new book("bookA",100),new book("bookB",200));

   	   List<Book> book2 = List.of(new book("bookC",300),new book("bookD",250));

   	   List<Sale> saleList = List.of(new book("bill",book1),new book("jim",book2));


   }
```

``` java

   //option A:
   List<String> totalByUserA = saleList.stream();
               .collect(flatMapping(t->t.getbooks().stream()
               	,groupingBy(Sale::getReader,summingDouble(Book::getPrice)
              )))
              .entrySet().stream()
              .sorted(Comparator.comparing(Entry::getValue)
              .collect(mapping(e-> e.getKey() + " " + e.getValue(),Collectors.toList()));
   //option B:
   List<String> totalByUserB = saleList.stream();
               .collect(groupingBy(Sale::getReader,
               	flatMapping(t->t.getbooks().stream(),
                summingDouble(Book::getPrice)
              )))
              .entrySet().stream()
              .sorted(Comparator.comparing(Entry::getValue)
              .collect(mapping(e-> e.getKey() + " " + e.getValue(),Collectors.toList()));
    //option C:
   List<String> totalByUserC = saleList.stream();
               .collect(groupingBy(Sale::getReader,
               	flatMapping(t->t.getbooks().stream(),
                summingDouble(Book::getPrice)
              )))
              .entrySet().stream()
              .sorted(Comparator.comparing(Entry::getValue)
              .collect(mapping(e-> e.getKey() + " " + e.getValue(),Collectors.toList()));
     //option D:
   List<String> totalByUserD = saleList.stream();
               .collect(flatMapping(t->t.getbooks().stream()
               	,groupingBy(Sale::getReader,summingDouble(Book::getPrice)
              )))
              .sorted(Comparator.comparing(Entry::getValue)
              .collect(mapping(e-> e.getKey() + " " + e.getValue(),Collectors.toList()));
```

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :C
   
   要將書籍總費用用昇幕排序需對List依序處理

   Collectors.groupingBy() 依照reader:String分類

   Collectors.flatMapping() 將books:List<Book> 攤平

   	A,D 無法應先groupBy再flatMapping
   	B,C差再 呼叫Stream.sorted需要先轉乘stream型態

</div>

**↑↑↑**

---

### Q62

which two safely validate inputs?(choose two)

A delegate numeric range checking of values to the database

B Accept only vaild characters and input values

C use trusted domain-specific libraries to validate inputs

D Assume inputs values,as needed,to pass validation

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans :BC
   
   A 數值範圍檢查應交給使用者介面進行,非委託給資料庫檢查

   D 已經被驗證不用再做檢查

   E 不應該擅自修改使用者資料

</div>

**↑↑↑**

---

### Q63

given:

``` java

    static void setSessionUser(Connection con,String username) throws Exception{
         Statement stmt = con.createStatement();
         String sql = <STATEMENT>;
         stmt.execute(sql);
    }
```
X) "SET SESSION AUTHOZATION" + username

Y) "SET SESSION AUTHOZATION" + stmt.enquoteIdentifer(username)

is x or y the correct replacement for <STATEMENT> and why?

A X,because it sends exactly the value of username provided by the calling code

B Y,because enquoting values provided by the calling code prevents SQL injection

C X and Y are funtionally equivalent

D X,because it is unnecessary to enclose identifiers in quotes

E Y,because all values provided by the calling code should be enquoted

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : A
   
  正確的說法是：Y 的意圖對（要防注入），但用錯了方法

   enquoteIdentifier() 是錯方法，應該用 enquoteLiteral()

   所以在這題給定條件下，只能選 A
  C 兩者不相同

  D 需要加識別符號或括號

  E 概念對但是Y本身方法錯誤

</div>

**↑↑↑**

---

### Q64

which three annotation uses are valid?(choose three)

A Funtion<String,String> a = (@NonNull x) -> x.toUpperCase();

B var b = "hello" + (@Internal) "World";

C Funtion<String,String> c = (var @NonNull x) -> x.toUpperCase();

D Funtion<String,String> d = (@NonNull var x) -> x.toUpperCase();

E var e = (@NonNull String) str;

F var f = new @Internal SomeObject();

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : DEF
   
   在lamda表示內使用標籤需要 (@NoNull String x) -> x.toUpperCase()
                           (@NoNull var x) ->x.toUpperCase()
   B 不可將字串轉為標註型別

</div>

**↑↑↑**

---

### Q65

given:

``` java

    public static void main(String[] args) {
       final List<String> fruits = List.of("orange","apple","banana","blueberry");
       final List<String> types = List.of("juice","pie","ice","cookie");
       var is = IntStream
               .range(0,Math.min(fruits.size(),types.size()))
               .mapToObj((i) -> fruits.get(i) + " " + types.get(i) + " ");
       is.forEach(System.out::print);
    }
```
what is the result?

A orange juice

B the compilation fails

C orange juice apple pie banana ice bluebarry cookie

D the program prints nothing

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : C
   
   range(包含,不包含)


</div>

**↑↑↑**

---

### Q66

which interface in the java.util.function package can return a primitive type?

A ToDoubleFuntion

B Supplier

C BiFuntion

D LongConsumer

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   ans : A
   
   A 只能回傳Double


</div>

**↑↑↑**

---

### Q67

given:

``` java

    public static void main(String[] args) {
       Locale.setDefault(Locale.ENGLISH);
       LocaleDate d1 = LocaleDate.of(2022,4,7);
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern(/* insert code here*/);
       System.out.println(dtf.format(d1));
    }
```
which pattern formats the date as "thursday 7th of april 2022"

A "eeee dd+"th of"+ MMM yyyy"

B "eeee dd'th of' MMM yyyy"

C "eeee d+"th of" + MMMM yyyy"

D "eeee d'th of' MMMM yyyy"

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">
 
   Ans:D

   需要以單括號夾帶字否則無法通過編譯

   dd 是自動補零 d才顯示單數

   完整月份年分樣式則需要輸入完整的4碼樣式

</div>

**↑↑↑**

---

### Q68

given:

``` java

    public static void main(String[] args) {
       //optionA
       List<? super Short> a = new ArrayList<Number>();
       //optionB
       List<? super Number> b = new ArrayList<Integer>();
       //optionC
       List<? extends Number> c = new ArrayList<Byte>();
       //optionD
       List<? extends Number> d = new ArrayList<Object>();
       //optionE
       List<? super Float> e = new ArrayList<Double>();
    }
```

which two statements independently compile(choose two)

A optionA

B optionB

C optionC

D optionD

E optionE

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   Ans :AC

   super則為 其類別的父類別
   extends則為 其類別的子類別


</div>

**↑↑↑**

---

### Q69

given:

``` java

    public static void main(String[] args) {
       Path source = Paths.get("/somePath/p/a.txt");
       Path target = Paths.get("/somePath");
       Files.move(source,target); //line 1
       Files.move(source); //line2

    }
```

Assuming the source file and target folder exist,what is the result ?

A java.nio.file.FileAlreadyExistsException is thrown on line 1

B java.nio.file.NoSuchFileException is thrown on line2

C one copy of /somePath/p/a.txt is moved to the /somePath directory and /somePath/p/a.txt is deleted

D a.txt is renamed somePath

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   Ans :A

   其會複製a.txt移動 到/目錄 並且命名為somePath但是因為檔案存在而拋出Exception


</div>

**↑↑↑**

---

### Q70

given:

``` java

    public static void main(String[] args) {
       List<String> longList = List.of("hello","java","duke");
       List<String> shortList = new ArrayList<>();
       //optionA
       longList.stream()
               .filter( w-> w.indexOf('e') != -1)
               .parallel()
               .forEach( w-> shortList.add(w));
      //optionB
      longList.parallelStream()
              .filter(w-> w.indexOf('e')!=-1)
             .forEach( w-> shortList.add(w));
      //optionC
      shortList = 
         longList.stream()
               .filter( w-> w.indexOf('e') != -1)
               .parallel()
               .collect(Collectors.toList());
      //optionD
      shortList = 
         longList.stream()
               .filter( w-> w.indexOf('e') != -1)
               .parallel()
               .collect(shortList);
    }
```
which code fragment correctly formx a short list of words containing the letter "e" ?

A optionA

B optionB

C optionC

D optionD

---

### 解答

**↓↓↓** 

<div style="background-color: black; color: black;" onmouseover="this.style.color='white'" onmouseout="this.style.color='black'">

   Ans :C

   都可以寫入shortList但考量題目correctly form a short list
   用collect方法創建一個list比較符合題意

</div>

**↑↑↑**

---