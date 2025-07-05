package Marquee.BinarySearch.programs;
import java.io.*;
import java.security.Key;
import java.util.*;
public class p1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
//        HashMap<Character, Integer> map = new HashMap<>();
//        for(char c: str.toCharArray()){
//            map.put(c, map.getOrDefault(c, 0)+1);
//        }
//        for(char c: map.keySet()){
//            System.out.print(c+""+map.get(c));
//        }
        StringBuffer sb = new StringBuffer();
        int count =1;
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == str.charAt(i-1)){
                count++;
            }
            else{
                sb.append(str.charAt(i-1)).append(count);
                count = 1;
            }
        }
        sb.append(str.charAt(str.length()-1)).append(count);
        System.out.println(sb);
    }
}
