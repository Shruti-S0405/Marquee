package LinkedList;

public class CircularSinglyLinkedList {
    Node head;
    Node tail;
    int size;

    public boolean isEmpty(){
        return size==0? true: false;
    }

    public boolean append(int val){
        return insert(size,val);
    }

    public boolean prepend(int val){
        return insert(0, val);
    }

    public boolean insert(int ind, int val){
        if(ind<0){
            return false;
        }
        Node node = new Node(val);
        if(isEmpty()){
            head = tail = node;
            node.next = head; //node.next = tail both are correct
        }
        else if(ind==0){
            node.next = head; // that node will become the head then the tail shd point head ie., the new node.
            head = node;
            tail.next = head;
        }
        else if(ind>size-1){
            tail.next = node;
            tail = node; // make the new node as tail
            node.next = head; // tail.next=head is also correct. Basically last points to first
        }
        else{
            Node temp = head;
            for(int i=0; i<(ind-1); i++){
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
        size++;
        return true;
    }

    public boolean delete(int ind){
        if(isEmpty() || ind<0 || ind>size-1) return false;
        if(head==tail) head = tail = null;
        else if(ind==0){
            head = head.next;
            tail.next = head;
        }
        else if(ind==size-1){
            Node temp = head;
            while(temp.next.next!=head || temp.next!=tail){
                temp = temp.next;
            }
            tail=temp;
            tail.next = head;
        }
        else{
            Node temp = head;
            int count = 0;
            while(count<ind-1){
                temp = temp.next;
                count++;
            }
            temp.next = temp.next.next;
        }
        size--;
        return true;
    }

    public boolean deleteFirst(){
        return delete(0);
    }

    public boolean deleteLast(){
        return delete(size-1);
    }

    public int getVal(int ind){
        if(isEmpty() || ind<0 || ind>size-1){
            return -1;
        }
        int count = 0;
        Node temp = head;
        while(count<=ind){
            temp = temp.next;
        }
        return temp.val;
    }

    public void display(){
        if(isEmpty()) System.out.println("{}");
        else{
            System.out.println("{");
            Node temp = head;
            int count = 0;
            while(count<size){ //use do while with temp.next!=head
                System.out.println(temp.val+" ");
                temp = temp.next;
                count++;
            }
            System.out.println("}");
        }
    }

    public static void main(String args[]){
        CircularSinglyLinkedList cl = new CircularSinglyLinkedList();

    }

}
