package Marquee.BinarySearch;
import java.util.*;

public class ArrayOperations {
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

    public boolean deleteAtIndex(int ind){
        if(isEmpty() || ind<0 || ind>=arr.length){
            return false;
        }
        else{
            if(ind>=index && ind<arr.length){
                deleteLast();
            }
            else if(ind==0){
                deleteFirst();
            }
            else{
                for(int i=ind+1; i<=index; i++){
                    arr[i-1] = arr[i];
                }
                index--;
            }
            return true;
        }
    }

    public boolean getValue(int ind){
        if(isEmpty() || ind<0 || ind> arr.length){
            return false;
        }
        else{
            System.out.println(arr[ind]);
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

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayOperations ao = new ArrayOperations();
        boolean flag=true;
        while(flag){
            System.out.println("What insertion Operations you want to perform \n " +
                    "0. Exit\n " +
                    "1. Append\n " +
                    "2. Prepend\n " +
                    "3. Insert\n " +
                    "4. Delete the first element\n " +
                    "5. Delete the last element\n " +
                    "6. Delete at specified condition\n" +
                    "7. Print the element in the given index\n"
            );
            int value = sc.nextInt();
            switch(value){
                case 0:
                    flag = false;
                    ao.print();
                    break;
                case 1: {
                    System.out.println("Enter the number to be inserted: ");
                    int n = sc.nextInt();
                    System.out.println(ao.append(n) ? "Append Sucessfull" : "Append not possible");
                    ao.print();
                    break;
                }
                case 2:{
                    System.out.println("Enter the number to be inserted: ");
                    int n = sc.nextInt();
                    System.out.println(ao.prepend(n)?"Prepend Sucessfull": "Prepend not possible");
                    ao.print();
                    break;
                }
                case 3:
                    System.out.println("Enter the number to be inserted: ");
                    int n = sc.nextInt();
                    System.out.println("Enter the index position: ");
                    int index = sc.nextInt();
                    System.out.println(ao.insert(index,n)?"Insertion Sucessfull": "Insertion not possible");
                    ao.print();
                    break;
                case 4:
                    System.out.println(ao.deleteFirst()?"Deletion Sucessfull": "Deletion not possible");
                    ao.print();
                    break;
                case 5:
                    System.out.println(ao.deleteLast()?"Deletion Sucessfull": "Deletion not possible");
                    ao.print();
                    break;
                case 6: {
                    System.out.println("Enter the index to be deleted");
                    int i = sc.nextInt();
                    System.out.println(ao.deleteAtIndex(i) ? "Deletion Sucessfull" : "Deletion not possible");
                    ao.print();
                    break;
                }
                case 7:
                    System.out.println("Enter the index of the element to be printed");
                    int i = sc.nextInt();
                    System.out.println(ao.getValue(i)?"Element found": -1);
                    ao.print();
                    break;
            }
        }
    }
}
