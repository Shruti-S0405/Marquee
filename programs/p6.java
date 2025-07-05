package Marquee.BinarySearch.programs;
import java.util.*;
public class p6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        char ch = 87;
        String hexa = "";
        while(num>0){
            int n = num%16;
            if(num%16 >9){
                ch += n;
                hexa = ch + hexa;
            }
            else{
                hexa = n + hexa;
            }
            num /= 16;
            ch = 87;
        }
        System.out.println(hexa);
    }
}
