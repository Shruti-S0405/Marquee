package Marquee.BinarySearch.HashTable;

import java.nio.charset.CharacterCodingException;

public class GenericHashTable<T> {
    class Node<T>{
        T val;
        Node<T> next;
        Node(T val){
            this.val = val;
        }
    }
    Node<T> arr[] = new Node[10];
    int size = -1;

    //%size logic can't be used for the genreric class
    // We need to use hashCode() to get the unique int value
    public int hashFunction(T key){
        if(key==null) return 0;
        return key.hashCode()% arr.length;
    }

    public boolean insert(T key){
        //Resizing in the hashtable
        //The logic to resize the hashtable
        if((double)size/arr.length>0.75){
            Node<T> newArr[] = new Node[(int)(arr.length*1.5)];
            Node<T> oldArr[] = arr;
            arr = newArr;
            size = 0;
            for(int i=0; i<oldArr.length; i++){
                Node<T> temp = oldArr[i];
                while(temp!=null){
                    insert(temp.val);
                    temp=temp.next;
                }
            }
        }

        int hashValue = hashFunction(key);
        Node<T> node = new Node(key);
        Node<T> temp = arr[hashValue];
        if(arr[hashValue]==null){
            arr[hashValue] = node;
        }
        else{
            while(true){
                if(temp.val==null||key==null? temp.val==key: temp.val.equals(key)){
                    return false; // Duplicate element found
                }
                if(temp.next==null){
                    temp.next=node;
                    break;
                }
                temp=temp.next;
            }
        }
        size++;
        return true;
    }

    public boolean delete(T key){
        int index = hashFunction(key);
        Node<T> temp = arr[index];

        // handle empty chain
        if(temp == null){
            return false;
        }

        // handle deleting head node
        if(temp.val==null || key==null ? temp.val==key : temp.val.equals(key)){
            arr[index] = temp.next;
            size--;
            return true;
        }

        // handle deleting beyond head
        Node<T> prev = temp;
        temp = temp.next;
        while(temp != null){
            if(temp.val==null || key==null ? temp.val==key : temp.val.equals(key)){
                prev.next = temp.next;
                size--;
                return true;
            }
            prev = temp;
            temp = temp.next;
        }

        return false; // key not found
    }


    public boolean contains(T key){

        int index = hashFunction(key);
        if(arr[index]==null) return false;
        Node<T> temp = arr[index];
        while(true){
            if(temp.val==null|| key==null? temp.val==key: temp.val.equals(key)){
                return true;
            }
            if(temp.next==null) return false;
            temp=temp.next;
        }
    }

    public void display(){
        if(size==0) {
            System.out.println("[]");
            return;
        }
        for(Node<T> n: arr){
            if(n!=null){
                while(n!=null){
                    System.out.print(n.val+" ");
                    n = n.next;
                }
            }
        }
    }
    public static void main(String args[]){
        GenericHashTable gt = new GenericHashTable();
        gt.insert(12);
        gt.insert(13);
        gt.insert(12);
        gt.insert(null);
        gt.insert("Hello");
        gt.insert("Hola");
        gt.display();
    }
}
