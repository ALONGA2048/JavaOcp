import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Tester {
    static int test =666;
    public static void main(String[] args) throws IOException {
        //如果指定Integer那不能用int 表示
        FuntionAbleExample example = (Integer a,Integer b)->System.out.println("override successful");
        // FuntionAbleExample example2 = (var a,var b)->System.out.println("override int successful");
        // FuntionAbleExample example3 = (String a,int b)->System.out.println("override var successful");
        // FuntionAbleExample.printer();
        // example.print("1", 2);
        // example2.print("2", 0);
        // example3.print("3", 2);
        // new Tester().method();
        char[] charRead = new char[218]; 
        String[] test = {"110","220","300","900","jane","jack","Stringer"};
        List<String> listTest = new ArrayList<>();
        for(String tes:test){
            listTest.add(tes);
        }
        UnaryOperator<Integer> u = i-> {return i*2;};

        Stream.of(test).forEach(System.out::println);
        System.out.println("-------");
        Stream.of(test).peek(System.out::println).forEach(System.out::println);
        System.out.println("-------");
        Optional<String> anser = appendToStringOptional(charRead);
        try {
            anser.get();
        } catch (NoSuchElementException e) {
            System.out.println("沒東西存在");
        } //stream如同水龍頭 可以讓成員逐一流出成為stream的成員  
        listTest.stream().filter(str->str.equals("110")).forEach(System.out::println);
                //    filter可以對每個成員進行表達式內部處理 true則繼續false則不繼續   forEach對每個成員進行以下的動作
        System.out.println("----");
        listTest.stream().sorted(String::compareTo).forEach(System.out::println);
        String tes1,test2;
        
        listTest.stream().sorted((s1,s2)-> s1.compareTo(s2) * -1).forEach(s-> System.out.print(s+","));
    }   
    @SuppressWarnings("resource")
    public static Optional<String> appendToStringOptional(char[] chars) throws IOException{
       
        FileReader reader = new FileReader("source.txt");
        int length = reader.read(chars);
        
        if(length==-1){
            return Optional.empty();
        }
        reader.close();
        
        return Optional.of(String.valueOf(chars));
    }
   


    
}
