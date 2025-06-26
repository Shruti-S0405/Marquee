package Marquee.BinarySearch.Recursion;

public class RecursionOfNaturalNumbers {
    public static void main(String args[]){
        //To print the first 5 natural numbers
        int n = 5;
        print(n);
    }
    public static void print(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        print(n-1);
        System.out.println(n);
    }
}


