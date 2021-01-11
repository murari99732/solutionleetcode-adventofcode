
/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class Testclass {
    public static void main(String args[] ) throws Exception {
   

        
       // Writing output to STDOUT

        //Scanner
    	
        Scanner s = new Scanner(System.in);
        
        String name = s.nextLine();                 // Reading input from STDIN
       // Writing output to STDOUT
    
   

         Testclass obj = new Testclass();

 
         String[] lines = name.split("\\n");

    System.out.println(obj.reverseWordsStringBuilder(lines[0]));

    }
     public String reverseWordsStringBuilder(String str) {

    StringBuilder finalStr = new StringBuilder();
    StringBuilder tempStr = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);

      if (c == ' ') {
        finalStr.insert(0, tempStr).insert(0, " ");
        tempStr.setLength(0);
      } else {
        tempStr.append(c);
      }
    }

    finalStr.insert(0, tempStr);

    return finalStr.toString();
  }
}

