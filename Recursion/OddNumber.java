package Marquee.BinarySearch.Recursion;

public class OddNumber {
    public static void main(String[] args){
        int n = 25;
        print(n);
    }

    public static void print(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        print(n-2);
        System.out.println(n);
    }
}
