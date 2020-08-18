import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
   
    String s = Integer.toString(year); 
    
    if(year == 1918)
        return "26.09."+s; 
    if(year<1917)
    {
        if(year%4 == 0)
        {
            //yes
            return "12.09."+s;
        }
        else 
        {
            //No
            return "13.09."+s;
        
        }
    }
    else 
    {
        if(year%400 == 0)
        {
            //yes
            return "12.09."+s;

        }
        else if(year%100 == 0)
        {
            //no
            return "13.09."+s;
        }
        else if(year%4 == 0)
        {
            //yes
            return "12.09."+s;

        }
        else 
        {
            //No
            return "13.09."+s;
        }
    }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
