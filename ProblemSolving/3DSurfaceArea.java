import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the surfaceArea function below.
    static int surfaceArea(int[][] A) {

        int r = A.length;
        int c = A[0].length;
        int[][] B = new int[r+2][c+2];
        int i,j,area = 2*r*c;

        for(i=0;i<r+2;i++)
        {
            for(j=0;j<c+2;j++)
            {
                if(i==0 || j==0 || i==r+1 || j==c+1)  B[i][j] = 0;
                else B[i][j] = A[i-1][j-1];
            }
        }

        for(i=1;i<=r;i++)
        {
            for(j=1;j<=c;j++)
            {
                if(B[i][j] - B[i-1][j] > 0) area = area + B[i][j] - B[i-1][j];
                if(B[i][j] - B[i][j-1] > 0) area = area + B[i][j] - B[i][j-1];
                if(B[i][j] - B[i][j+1] > 0) area = area + B[i][j] - B[i][j+1];
                if(B[i][j] - B[i+1][j] > 0) area = area + B[i][j] - B[i+1][j];
            }
        }
        return area;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
