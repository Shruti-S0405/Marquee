package Marquee.BinarySearch.programs;

import java.util.Scanner;

public class p5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String regex = "[A-Za-z][A-Za-z0-9_]{7,29}";
        System.out.println(str.matches(regex));
//        System.out.println(isValid(str)? "Valid": "Invalid");
    }
//    public static boolean isValid(String str){
//        if(!Character.isLetterOrDigit(str.charAt(0)) || str.length()>30 || str.length()<8) return false;
//        else{
//            for(int i=1; i<str.length(); i++){
//                if(!Character.isLetterOrDigit(str.charAt(i)) || !str.charAt(i)=='_') return false;
//            }
//        }
//        return true;
//    }
}
