package Marquee.BinarySearch.ReverseLinkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = next;
    }
}

class Main{
    //O(N)
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;

        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public void printList(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val);
            if(temp.next!=null){
                System.out.print("-->");
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(9);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);

        System.out.println("Original List: ");
        Main m = new Main();
        m.printList(head);

        ListNode revList = m.reverseList(head);
        System.out.println("Reversed List: ");
        m.printList(revList);
    }
}