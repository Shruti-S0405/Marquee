package Marquee.BinarySearch.HashTable;

public class HashTableImplementation {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    Node arr[] = new Node[10];
    int size;

    public int hashFunction(int key){
        return key%arr.length;
    }

    public boolean insert(int key){
        if(arr[hashFunction(key)]!=null){
            Node temp = arr[hashFunction(key)];
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new Node(key);
        }
        else arr[hashFunction(key)] = new Node(key);
        size++;
        return true;
    }

    public void display(){
        if(size==0) {
            System.out.println("[]");
            return;
        }
        for(Node n: arr){
            if(n!=null){
                while(n!=null){
                    System.out.print(n.val+" ");
                    n = n.next;
                }
            }
        }
    }

    public boolean contains(int key){
        if(arr[hashFunction(key)].val==key){
            return true;
        }
        else{
            Node temp = arr[hashFunction(key)];
            while(temp!=null){
                if(temp.val==key){
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }
    }

    public boolean delete(int key){
        if(contains(key)){
            int index = hashFunction(key);
            Node temp = arr[index];
            if(temp.val==key){
                temp=temp.next;
                arr[index] = temp;
            }
            else{
                Node prev = null;
                while(temp.val!=key){
                    prev = temp;
                    temp = temp.next;
                }
                prev.next = temp.next;
            }
            size--;
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        HashTableImplementation ht = new HashTableImplementation();
        ht.display();
        ht.insert(10);
        ht.insert(20);
        ht.insert(30);
        ht.display();
        System.out.println(ht.contains(15));
    }

}
