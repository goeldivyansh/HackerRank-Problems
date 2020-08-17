import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s) {

        int ans=0;
        int f=0,l=s.length()-1;
        while(f<l)
        {
            if(s.charAt(f) < s.charAt(l))
            {
                ans = ans + (int)s.charAt(l) - (int)s.charAt(f);
            }
            else
            if(s.charAt(l) < s.charAt(f))
            {
                ans = ans + (int)s.charAt(f) - (int)s.charAt(l);
            }
            f++;
            l--;
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = theLoveLetterMystery(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
