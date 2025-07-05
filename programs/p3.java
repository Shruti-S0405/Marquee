package Marquee.BinarySearch.programs;
import java.util.ArrayList;
import java.util.Scanner;
public class p3 {

    // 1 2 3 7 1 2 3 -> unpaired is 7
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        while(sc.hasNextInt()){
            arr.add(sc.nextInt());
        }
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int i: arr){
//            map.put(i, map.getOrDefault(i, 0)+1);
//        }
//        for(int i: map.keySet()){
//            if(!(map.get(i)>1)){
//                System.out.println(i);
//            }
//        }
        int res = 0;
        for(int i: arr) res ^= i;
        System.out.print(res);
    }
}
