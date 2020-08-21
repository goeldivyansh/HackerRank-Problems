import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int Q;
        Scanner sc = new Scanner(System.in);
        Q = sc.nextInt();
        String S = "";
        Stack<String> stack = new Stack<String>(); 

        for(int i=0;i<Q;i++)
        {
            int t;
            t = sc.nextInt();

            if(t==1)
            {
				//Scan String W
                String W = sc.nextLine();
                //Push String to the stack
                stack.push(S);
                //Append String W to the end of S
                S = S + W;
            }
            else
            if(t==2)
            {
				//Scan k
				int k;
                k = sc.nextInt();
                //Push String to the stack
                stack.push(S);
                //Delete k characters from last of string                 
                S = S.substring(0,S.length()-k);
            }
            else
            if(t==3)
            {
                //Print kth character of string 
                int k;
                k = sc.nextInt();
                System.out.println(S.charAt(k-1));         
            }
            else
            if(t==4)
            {
                //Undo last operation
                S = stack.peek();
                stack.pop();
            }
        }
        sc.close();
    }
}
