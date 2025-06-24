package Marquee.BinarySearch;


public class MidValueInLinkedList {
    Node head;
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    public int getMidValue(Node head){
        if(head==null) return -1;
                  //Brute Force O(N+N)
//                int count = 0;
//                Node temp = head;
//                while(temp!=null){
//                    count++;
//                    temp = temp.next;
//                }
//                temp = head;
//                for(int i=0; i<(count/2)-1; i++){
//                    temp=temp.next;
//                }
//                return temp.val;


        // Optimized Approach-> 2 Pointer
        // p1 -> moves 1 step at a time
        // p2 -> moves 2 step at a time
        Node p1 = head;
        Node p2 = head;
        while(p2!=null && p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }
        return p1.val;

    }

    public static void main(String args[]){
        MidValueInLinkedList ml = new MidValueInLinkedList();
        Node head = new Node(1);
        head.next = new Node(9);
        head.next.next = new Node(4);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(2);

        System.out.println("Mid value of the linked List is ");
        System.out.println(ml.getMidValue(head));
    }
}
