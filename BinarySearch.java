package Marquee.BinarySearch;

import java.util.Scanner;
//Complexity -> O(log n )
// if the ele is at the mid -> O(1)
// if the ele present at the nested mids -> O(log n/2)
// else it is O(log n)
public class BinarySearch {
    public static void main(String[] args){
        System.out.println("Enter the key to search");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        System.out.println(binarySearch(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}, key)==true?"Key Found":"Key Not Found");
    }

    public static boolean binarySearch(int[] arr, int key){
        int left=0;
        int right=arr.length-1;
        int count = 0;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]==key){
                return true;
            }
            else if(key>arr[mid]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return false;
    }
}
