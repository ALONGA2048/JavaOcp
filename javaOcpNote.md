
# Java 運作原理
Java 程式碼可以在任何純文字檔下書寫，但若想將其轉化成有效的程式，則需透過 `javac` 轉換成中立的位元碼 (`.class`)，才能在 Java 虛擬機 (JVM) 上執行。不同平台的 JVM 允許 Java 程式碼在多種環境中運行。

Java 執行環境 (JRE) 包含 JVM 和相關的 library，負責 Java 程式的運行。
Java 開發工具包 (JDK) 則包含 JRE 及開發工具，如 `javac`、`jar` 等。

**編譯與執行 Java 程式：**
```sh
javac 檔名.java  # 編譯成 .class 檔案
java 檔名         # 執行編譯後的 .class 檔案
jar -cfe 檔案.jar 主類別 其他.class # 打包 JAR
java -jar 檔案.jar  # 執行 JAR
```

# 物件導向分析
Java 透過 `class` (類別) 來定義物件，描述其屬性與行為。類別是一種模型，可以透過 `new` 關鍵字產生多個物件。

- **靜態 (static) vs 非靜態 (non-static)**
  - **物件 (non-static)**：每次 `new` 都會創建新的物件，各自擁有獨立的變數。
  - **類別 (static)**：從頭到尾只有一份，所有物件共享。

# Java 命名規則
- **變數與方法**：駝峰命名法 (camelCase)
- **類別名稱**：首字母大寫 (PascalCase)
- **常數**：使用 `final` 限制變數不可變

# Java 基本數據類型
- **基本型別**：`byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean`
- **包裝類別**：`Byte`, `Short`, `Integer`, `Long`, `Float`, `Double`, `Character`, `Boolean`
- **字串 (`String`)**：不可變，使用 `concat()` 會生成新的字串
- **可變字串 (`StringBuilder`)**：可變，提供 `toString()` 轉換

# Java 運算符
**隱式轉換與強制轉換**
- `byte < short < int < long < float < double`
- `char` 運算時會先轉 `int`
- `int` 轉 `double` 可隱式轉換，反之需 `(int) doubleValue`

**算術運算**
- `+` 號運算時若有字串則進行字串拼接

**三元運算子**
```java
int a = (b > c) ? b : c;
```

# 陣列與集合框架
Java 陣列是固定大小的，而集合框架 (Collections Framework) 提供更靈活的數據結構：
- `List`：可變長度，有序，如 `ArrayList`, `LinkedList`
- `Set`：不允許重複元素，如 `HashSet`, `TreeSet`
- `Queue`：FIFO 結構，如 `LinkedList`, `PriorityQueue`
- `Map`：鍵值對映射，如 `HashMap`, `TreeMap`

```java
List<String> list = new ArrayList<>();
list.add("Java");
list.add("Python");
list.remove("Python");
System.out.println(list.get(0));
```

# 方法與記憶體管理
**記憶體區域：**
- **全域區 (`static`)**：儲存 `static` 變數
- **堆疊 (`stack`)**：儲存基本類型與方法內變數
- **堆積 (`heap`)**：儲存 `new` 出來的物件

**方法類型：**
- **物件方法**：需 `new` 物件才能呼叫
- **類別方法 (`static`)**：可直接 `ClassName.methodName()` 呼叫

# 繼承與介面
**繼承 (`extends`)**
- 子類別繼承父類別所有屬性與方法
- 可透過 `@Override` 覆寫方法

**介面 (`interface`)**
- 允許多重實作 (`implements`)
- 所有方法預設為 `public abstract`

```java
interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Bark");
    }
}
```

# 多型 (Polymorphism)
多型允許同一方法適用於不同類別：
- **方法覆寫 (Override)**：子類別重新定義父類別的方法
- **方法重載 (Overload)**：同一類別中定義相同名稱但參數不同的方法
- **父類引用指向子類對象**

```java
Animal myDog = new Dog();
myDog.makeSound(); // Bark
```

# 枚舉 (Enum)
枚舉是一組固定常數的集合，避免使用魔數：

```java
enum Day {
    MONDAY, TUESDAY, WEDNESDAY;
}

Day today = Day.MONDAY;
System.out.println(today);
```

# 集合框架 (Collections Framework)
Java 集合框架提供了強大的數據結構，主要包含 `List`、`Set`、`Queue`、`Map`，並有對應的實作類別。

```java
Map<String, Integer> map = new HashMap<>();
map.put("Alice", 25);
map.put("Bob", 30);
System.out.println(map.get("Alice"));
```
---

# 例外與斷言

- Checked Exception Java在編譯時期直接發生的錯誤或強制要求處理的異常(如:格式寫錯,缺少標點符號)
``` java
    //修正前
    FilrReader file = new FilrReader("test.txt"); //可能會產生FileNotFoundException 系統會直接報錯要求處理

    //修正法1(使用try-catch)
    try {
    FileReader file = new FileReader("test.txt");
    } catch (FileNotFoundException e) {
        System.out.println("檔案不存在！");
    }

    //修正法2(用 throws 讓異常向上拋出，交給呼叫者處理 在方法拋給main(方法呼叫者))
    public void readFile() throws FileNotFoundException {
    FileReader file = new FileReader("test.txt");
    }

```

- Unchecked Exception 程式碼在執行期間才發生的錯誤 無法預知的錯誤(如:輸入格式錯誤,資源開啟關閉錯誤)
    這些錯誤會被歸類在Runtime Exception 跟 Error

# try-catch語法

為了也防範執行期間的錯誤 避免因錯誤而使程式全部癱瘓 可以使用此語法

```  java
    try{
        //要檢查的執行程式碼區塊
    }catch(Exception e){ //要抓到的錯誤類別 ex:要抓型別錯誤可以抓Intput mismatch

        //要是抓到錯誤後要執行的解決方式

    }
```
在try抓到catch的錯誤後回直接跳出執行catch區塊之後直接繼續執行try下面的程式碼

---   

# 輸入與輸出 (I/O)

資料在一個個獨立檔案跟電腦總需要移動或修改 因此有java.io的類別協助我們讀取寫入不同的資料及轉換 其中也有File類別能直接管理目錄及檔案 使其新增修改刪除
下面介紹各式功能的API

1. 處理串流的類別

    | 方向\內容  | 位元(byte)  | 字元(Char)  |
    |--------   |--------|--------|
    | 輸入java  | InputStream  | Reader  |
    | 輸出java  | OutputStream  | Writer |

   也有許多不同功能的類別如:BufferedReader,FilterReader,PrintWriter

   可以自由切換來達到目的

2. 處理檔案跟目錄
   
   java.io.File 可以查詢目錄並在指定位置新增修改檔案或資料夾

3. 主控台的IO 
   
    | 欄位      | 欄位型別  | 功能  |
    |--------   |--------|--------|
    | System.in | printStream  | 將訊息輸出到主控台上  |
    | System.out  | inputStream  | 由主控台接受鍵盤或其他來源的輸入 |
    | System.err  | printStream  | 也是輸出訊息到主控台但只會輸出錯誤訊息和異常 |

---

