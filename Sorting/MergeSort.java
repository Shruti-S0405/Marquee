package Marquee.BinarySearch.Sorting;
import java.util.*;

public class MergeSort {
    public static void main(String[] args){
        int[] arr = {9, 3, 4, 2, 1, 7, 8};
        divideMerge(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void divideMerge(int[] arr){
        if(arr.length==1) return;
        int mid = arr.length/2;
        int[] left = new int[mid];
        int[] right = new int[arr.length-mid];
        for(int i=0; i<arr.length; i++){
            if(i<left.length) left[i] = arr[i];
            else right[i-mid] = arr[i];
        }
        divideMerge(left);
        divideMerge(right);
        merge(arr, left, right);
    }
    public static void merge(int[] arr, int[] left, int[] right){
        int i=0, j=0, k=0;
        while(i<left.length && j< right.length){
            if(left[i]<right[j]){
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = right[j++];
            }
        }
        while(i<left.length){
            arr[k++] = left[i++];
        }
        while(j< right.length){
            arr[k++] = right[j++];
        }
    }
}
