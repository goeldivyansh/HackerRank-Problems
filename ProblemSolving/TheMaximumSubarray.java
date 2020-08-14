import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxSubarray function below.
    static int max(int[] a) {
        int m = a[0];
        for(int i=1;i<a.length;i++)
        {
            if(m<a[i]) m = a[i];
        }
        return m;
    }


    static int[] maxSubarray(int[] a) {
        int[] ans = new int[2];
        int i,j,s=0,f=0;
        int l = a.length;
        ans[0] = 0;
        ans[1] = 0;

        //Contiguous Sum    
        int allNeg = 1;

        for(i=0;i<l;i++)
        {
            if(a[i] >0)
            {
                allNeg = 0;
                ans[1] = ans[1] + a[i];
            }
        }
        if(allNeg == 1) 
        {
            ans[0] = max(a);
            ans[1] = ans[0];
            return ans;
        }
        
        //SubArray Sum
        for(i=0;i<l;i++)
        {
            s = s + a[i];
            if(s<0) s = 0;
            if(f<s) f = s;
        }
        ans[0] = f;
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = maxSubarray(arr);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
