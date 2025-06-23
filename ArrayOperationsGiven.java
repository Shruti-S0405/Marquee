package Marquee.BinarySearch;
import java.util.*;
public class ArrayOperationsGiven {
    int[] arr = new int[20];
    int index = -1;
    public boolean isFull(){
        return arr.length-1==index? true: false;
    }
    public boolean isEmpty(){
        return index==-1? true: false;
    }
    public boolean append(int n){
        if(!isFull()){
            arr[++index] = n;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean prepend(int n){
        if(!isFull()){
            if(isEmpty()) {
                arr[++index] = n;
                return true;
            }
            for(int i=index; i>=0; i--){
                arr[i+1] = arr[i];
            }
            arr[0] = n;
            index++;
            return true;
        }
        return false;
    }

    public boolean insert(int ind, int value){
        if(isFull() || ind<0 || ind>=arr.length){
            return false;
        }
        else{
            if(ind==0) prepend(value);
            else if(ind>index) append(value);
            else{
                for(int i=index; i>=ind; i--){
                    arr[i+1] = arr[i];
                }
                arr[ind] = value;
            }
            index++;
            return true;
        }
    }

    public boolean deleteFirst(){
        if(isEmpty()){
            return false;
        }
        else{
            for(int i=1; i<=index; i++){
                arr[i-1] = arr[i];
            }
            index--;
            return true;
        }
    }

    public boolean deleteLast(){
        if(isEmpty()){
            return false;
        }
        else{
            index--;
            return true;
        }
    }

    public void print(){
        if(isEmpty()){
            System.out.println("{}");
        }
        else{
            String str = "{ "+arr[0];
            for(int i=1; i<=index; i++){
                str += ","+arr[i];
            }
            System.out.println(str + " }");
        }
    }

    public static void main(String args[]){
        ArrayOperationsGiven a = new ArrayOperationsGiven();
        System.out.println(a.append(10));
        System.out.println(a.append(20));
        System.out.println(Arrays.toString(a.arr));
        System.out.println(a.prepend(40));
        System.out.println(Arrays.toString(a.arr));
        System.out.println(a.insert(2,100));
        System.out.println(Arrays.toString(a.arr));
        System.out.println(a.deleteFirst());
        System.out.println(Arrays.toString(a.arr));
        System.out.println(a.deleteLast());
        System.out.println(Arrays.toString(a.arr));

    }
}
