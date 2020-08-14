import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gridChallenge function below.
    static String gridChallenge(String[] grid) {

        int i,j,l,n = grid.length;
        // for(i=0;i<n;i++)
        // {
        //     Arrays.sort(grid[i]);
        // }

        for(i=0;i<n;i++)
        {
            char[] chars = grid[i].toCharArray();
            Arrays.sort(chars);
            grid[i] = new String(chars);
        }
        
        l = grid[0].length();

        for(i=0;i<l;i++)
        {
            for(j=0;j<n-1;j++)
            {
                if(grid[j].charAt(i) > grid[j+1].charAt(i))
                    return "NO";
            }
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] grid = new String[n];

            for (int i = 0; i < n; i++) {
                String gridItem = scanner.nextLine();
                grid[i] = gridItem;
            }

            String result = gridChallenge(grid);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
