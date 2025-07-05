import java.io.*;
import java.util.*;
public class p8 {
    public static void main(String[] args) {
        int[] arr = new int[]{16,17,4,3,5,2};
        System.out.println(leaders(arr));
    }
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        if(arr==null || arr.length==0) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        // for(int i=0; i<arr.length-1; i++){
        //     int max = arr[i];
        //     for(int j=i+1; j<arr.length; j++){
        //         if(arr[j]>max){
        //             max = arr[j];
        //         }
        //     }
        //     if(arr[i]==max){
        //         res.add(max);
        //     }
        // }
        // res.add(arr[arr.length-1]);
        
        int max = arr[arr.length-1];
        res.add(max);
        for(int i=arr.length-2; i>=0; i--){
            if(arr[i]>max){
                max = arr[i];
                res.add(max);
            }
        }
        return res;
    }    
}
