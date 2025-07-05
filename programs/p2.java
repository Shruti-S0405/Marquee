package Marquee.BinarySearch.programs;
import java.io.*;
import java.util.*;
public class p2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            arr.add(n);
            max = n>max? n: max;
        }
        for(int i: arr){
            System.out.println(fibValue(i, max));
        }
    }
    public static long fibValue(int ind, int max){
        long[] fib = new long[max+1];
        fib[0] = 0;
        if(max>0) fib[1] = 1;
        for(int i=2; i<fib.length; i++){
            fib[i] = fib[i-1]+fib[i-2];
        }
        return fib[ind];
    }


}
