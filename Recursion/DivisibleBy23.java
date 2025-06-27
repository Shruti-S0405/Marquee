package Marquee.BinarySearch.Recursion;

public class DivisibleBy23 {
    public static void main(String[] args){
        int n = 25;
        print(n);
    }

    public static void print(int n){
        if(n==1){
            return;
        }
        if(n%2==0 && n%3==0){
            System.out.println(n);
        }
    }
}
