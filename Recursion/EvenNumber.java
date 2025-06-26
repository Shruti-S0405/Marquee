package Marquee.BinarySearch.Recursion;

public class EvenNumber {
    public static void main(String args[]){
        //To print the first 5 natural numbers
        int n = 25;
        print(n%2==0?n:n-1);
    }
    public static void print(int n){
        if(n==2){
            System.out.println(n);
            return;
        }
        print(n-2);
        System.out.println(n);
    }
}
