package Marquee.BinarySearch.programs;
import java.util.*;
public class p4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = new String[sc.nextInt()];
        int max = -1;
        String maxWord = "";
        for(int i=0; i<str.length; i++){
            String s = sc.next();
            str[i] = s;
            if(s.length()>max && s.length()%2!=0){
                max = s.length();
                maxWord = s;
            }
        }
        System.out.println(max==-1? "Better Luck Next Time :)": maxWord);
    }
}
