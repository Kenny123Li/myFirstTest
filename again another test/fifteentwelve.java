import java.util.*;
import java.io.*;
public class fifteentwelve
{
public static void main(String[] args)
{
    String filename = "speech.txt";
    Set<String> words = new TreeSet<>();
    String word = "";
    try(Scanner scan = new Scanner(new File(filename)))
    {
        while(scan.hasNext()){
        word = scan.next();
        word = clean(word);
        words.add(word);
       }
       System.out.println(words);
       System.out.println("Number of unique words: " +words.size());
        
    }
    catch(FileNotFoundException e)
    {
        System.out.println("Could not open file");
    }
}

public static String clean(String s)
{
    String r = s.toLowerCase();
    if (r.charAt(0) > 122 || r.charAt(0) < 97)
        r = r.substring(1);
    if (r.charAt(r.length()-1) > 122 || r.charAt(r.length()-1) < 97)
        r = r.substring(0,r.length()-1);
    return r;
}
}
