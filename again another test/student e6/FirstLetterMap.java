import java.util.*;
import java.io.*;
/**
   Read all words from a file and add them to a map
   whose keys are the first letters of the words and
   whose values are sets of words that start with
   that same letter.
   Then print out the word sets in alphabetical order.
   Use the Java 8 merge() feature.
*/
public class FirstLetterMap
{
   public static void main(String[] args)
   {
      String filename = "test1.txt";

      try (Scanner in = new Scanner(new File(filename)))
      {

         // Create your map here
         Map<Character, String> wordcount = new TreeMap<>();

         while (in.hasNext())
         {
            String word = clean(in.next());
            Character c = word.charAt(0);

            // Update the map here
            // Use the Java 8 merge method
            wordcount.merge(c, word, (String :: concat));//i sure do understand what's going on here
           
            wordcount.merge(c, //key to look up
                            new TreeSet<String>(Arrays.asList(word)), //default value if not found
                            (oldValue, NewValue) -> //function expression to convert old value to new value
                            {
                                oldValue.add(word);
                                return oldValue;
                            });
         }

         // Print the map here in this form
         // a: [a, able, aardvark]
         for (Character key : wordcount.keySet())
         {
             System.out.println(key+": ["+wordcount.get(key)+"]");
            }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Cannot open: " + filename);
      }
   }

   public static String clean(String s)
   {
      String r = "";
      for (int i = 0; i < s.length(); i++)
      {
         char c = s.charAt(i);
         if (Character.isLetter(c))
         {
            r = r + c;
         }
      }
      return r.toLowerCase();
   }

}
