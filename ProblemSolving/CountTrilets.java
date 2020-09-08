import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        long count=0;
        long l = arr.size();
        
        Map <Long,Integer> m = new HashMap<Long,Integer>();
        
        for(int i=0;i<arr.size();i++)
        {
            //Map with Uniqe numbers and their frequency.
            if(m.containsValue(arr.get(i)))
                m.put(arr.get(i), m.get(arr.get(i)) + 1);
            else
                m.put(arr.get(i),1);
        }
            
        
        long n = arr.size();
        if(r==1)
        {
            for(Map.Entry<Long,Integer> entry : m.entrySet())
            {
                long k1 = entry.getKey();
                long val = entry.getValue();
                if(val>2)
                {
                    count = count + val*(val-1)*(val-2)/6;
                }
            }
        }
        else
        {
            for(Map.Entry<Long,Integer> entry : m.entrySet())
            {
                long k1 = entry.getKey();
                long val = entry.getValue();
                long k2 = k1*r;
                long k3 = k1*r*r;
                if(m.containsKey(k2) && m.containsKey(k3))
                {
                    count = count + val*m.get(k2)*m.get(k3);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr.add(arrItem);
        }

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


















// Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Integer> map=new HashMap<Long, Integer>();
        int l = arr.size();
        long triplets = 0;
        //Create a map with unique numbers in arr as key and its frequency as value
        for(int i = 0; i < l; i++) {
            if (map.containsKey(arr.get(i))) {
                map.put(arr.get(i), map.get(arr.get(i)) + 1);
            } else {
                map.put(arr.get(i), 1);
            }
        }
        
        /*
            If ratio is 1, arr is {2,2,2,2,2,2,2,2,2,2}.. 2 is 10 times than map will be 
            {(2, 10)}, where 2 is key and 10 is value than answer will be Nc3 (10c3),                using permutations and combinations.. select '2' three times from 10 items               which can be done in 10c3 ways
        */
        if (r == 1) {
            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                long key = entry.getKey();
                long val = entry.getValue();
                System.out.println("Key is: " + key);
                System.out.println("Value is: " + val);
                if (val > 2) {
                    //here applying formula for Nc3
                    triplets = triplets + (val * (val - 1) * (val - 2))/6;
                }
            }   
        } else {
            /*
                eg. 2,4,4,8,8,16,24,24,24 and r is 2
                map will be {(2,1), (4,2), (8,2), (16,1), (24,3)}
                iterate for every key,value pair in the map
                first time (2,1), key is 2.. now check for 2*r(4) and 2*r*r(8) in map
                if present means triplet found.. now we need to calculate how many                       triplets can be formed with these 3 values.. that will be                                multiplication of values of these 3 keys in map... 2 is 1 time, 4 is 2                   times, 8 is 2 times... no. of triplets = 1*2*2=4
            */
            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                long key1 = entry.getKey();
                long val = entry.getValue();
                long key2 = key1 * r;
                long key3 = key2 * r;

                if(map.containsKey(key2) && map.containsKey(key3)) {
                    triplets = triplets + (val * map.get(key2) * map.get(key3));
                }
            } 
        }
        return triplets;
    }