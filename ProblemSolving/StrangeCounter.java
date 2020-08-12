import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the strangeCounter function below.
    // static long strangeCounter(long t) {
    //     long v = 3,time=1,prevTime=0;
    //     while(time < t)
    //     {
    //         prevTime = time;
    //         time = time+v;  
    //         v = v*2;
    //     }

    //     if(time == t ) return v;
    //     else 
    //     if(time-t <= t-prevTime)
    //     {
    //         v = 0;
    //         while(time!=t)
    //         {
    //             v++;
    //             time--;
    //         }
    //     }
    //     else
    //     if(time-t > t-prevTime)
    //     {
    //         time = time/2;
    //         while(time!=t)
    //         {
    //             v--;
    //             time++;
    //         }
    //     }
    //     return v;
    // }

        static long strangeCounter(long t) {
        long v = 3,time=1,prevTime=1,x=0;
        while(time < t)
        {
            prevTime = time;
            time = time+v;  
            v = v*2;
        }
        if(time == t ) 
            return v;
        else
        {
            x = t - prevTime;
            v = v/2;
            v = v-x;
        }
        return v;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
