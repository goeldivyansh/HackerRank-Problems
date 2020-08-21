import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jimOrders function below.

    static int indOfMinimum(int[] t)
    {
        int i,min = t[0];
        int ind = 0;
        for(i=1;i<t.length;i++)
        {
            if(t[i] < min)
            {
                min = t[i];
                ind = i;
            }
        }
        t[ind] = 2000001;
        return ind;
    }
    static int[] jimOrders(int[][] orders) {

    int n = orders.length;
    int[] time = new int[n];
    int[] ans = new int[n];
    int i=0;
    for(i=0;i<n;i++)
    {
        time[i] = orders[i][0] + orders[i][1];
    }        
   
    for(i=0;i<n;i++)
    {
        ans[i] = indOfMinimum(time)+1;
    }
    return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        int[] result = jimOrders(orders);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
