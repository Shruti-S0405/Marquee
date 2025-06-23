package LinkedList;

public class SinglyLinkedList {
    Node head;
    Node tail;
    int size;

    public boolean isEmpty(){
        return size==0? true:false;
    }

    public int size(){
        return size;
    }

    public boolean prepend(int val){
        Node node = new Node(val);
        if(isEmpty()) head = tail = node;
        else{
            node.next = head;
            head = node;
        }
        size++;
        return true;
    }

    public boolean append(int val){
        Node node = new Node(val);
        if(isEmpty()) head=tail=node;
        else {
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    public boolean insert(int val, int ind){
        if(ind<0) return false;
        if(ind==0) prepend(val);
        else if(ind>=size-1) append(val);
        else{
            Node temp = head;
            for(int i=0; i<(ind-1); i++){
                temp = temp.next;
            }
            Node node = new Node(val);
            node.next = temp.next;
            temp.next = node;
        }
        size++;
        return true;
    }

    public boolean deleteFirst(){
        if(isEmpty()) return false;
        else{
            if(size==1){
                head = tail = null;
            }
            else{
                head = head.next;
            }
        }
        size--;
        return true;
    }

    public boolean deleteLast(){
        if(isEmpty()) return false;
        if(size==1){
            head = tail = null;
        }
        else{
            Node temp = head;
            while(temp.next!=tail){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        size--;
        return true;
    }

    public boolean delete(int ind){
        if(isEmpty() || ind<0 || ind>=size) return false;
        if(ind==0) deleteFirst();
        else if(ind==size-1) deleteLast();
        else{
            Node temp = head;
//            for(int i=0; i<(ind-1); i++){
//                temp = temp.next;
//            }
            int count = 0;
            while(count<ind-1){
                count++;
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        size--;
        return true;
    }

    public boolean getVal(int ind){
        if(isEmpty() || ind<0 || ind>=size) return false;
        Node temp = head;
        for(int i=0; i<ind; i++){
            temp = temp.next;
        }
        System.out.println("\n"+temp.val);
        return true;
    }

    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val);
            if(temp.next != null){
                System.out.print("-->");
            }
            temp = temp.next;
        }
    }



    public static void main(String args[]){
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.append(10);
        sl.append(20);
        sl.append(30);
        sl.insert(40,0);
        sl.insert(80,2);
        sl.insert(70,7);
        sl.delete(3);
        sl.display();
        System.out.println();
        sl.getVal(2);
    }
}

