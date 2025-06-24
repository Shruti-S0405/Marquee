
package Marquee.BinarySearch.LinkedList;
// Only the insertion at specific index and deletion at specific index is O(N)
// Deletion & Insertion at spec index is Linear Time Complexity
// All the other methods have Constant Time Complexity
class DoublyLinkedList{
    DoublyNode head;
    DoublyNode tail;
    int size;

    class DoublyNode {
        int val;
        DoublyNode next;
        DoublyNode prev;
        DoublyNode(int val){
            this.val = val;
        }
    }

    public boolean isEmpty(){
        return head==null && tail==null;
    }
    //O(1)
    public boolean append(int val){
        DoublyNode node = new DoublyNode(val);
        if(isEmpty()){
            head = tail = node;
        }
        else{
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }
    //O(1)
    public boolean prepend(int val){
        DoublyNode node = new DoublyNode(val);
        if(isEmpty()){
            head=tail=node;
        }
        else{
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
        return true;
    }
    //O(N)
    public boolean insert(int val, int ind){
        DoublyNode node = new DoublyNode(val);
        if(ind<0) return false;
        if(isEmpty()){
            head = tail = node;
        }
        else{
            if(ind==0) prepend(val);
            else if(ind>size-1) append(val);
            else{
                DoublyNode temp = head;
                int count = 0;
                while(count<(ind-1)) {
                    temp = temp.next;
                    count++;
                }
                node.prev = temp;
                node.next = temp.next;
                temp.next = node;
            }
        }
        size++;
        return true;
    }
    //O(1)
    public boolean deleteLast(){
        if(isEmpty()) return false;
        tail.prev.next = null;
        tail = tail.prev;
        size--;
        return true;

    }
    //O(1)
    public boolean deleteFirst(){
        if(isEmpty()) return false;
        head.next.prev = null;
        head = head.next;
        size--;
        return true;
    }
    //O(N)
    public boolean delete(int ind){
        if(isEmpty() || ind<0 || ind>=size){
            return false;
        }
        else{
            if(ind==0) deleteFirst();
            else if(ind==size-1) deleteLast();
            else {
                DoublyNode temp = head;
                int count = 0;
                while (count < (ind - 1)) {
                    temp = temp.next;
                    count++;
                }
//                Approach one
//                temp.next.next.prev = temp;
//                temp.next = temp.next.next;
//
//                Approach two
                temp.next = temp.next.next;
                temp.next.prev = temp;
            }
            size--;
            return true;
        }
    }
//    O(N)
    public void printList(){
        DoublyNode temp = head;
        while(temp!=null){
            System.out.print(temp.val);
            if(temp.next!=null) System.out.print("-->");
            temp = temp.next;
        }
    }

    public static void main(String[] args){
        DoublyLinkedList dl = new DoublyLinkedList();
        System.out.println();
        System.out.println("Append Operation");
        dl.append(10);
        dl.append(20);
        dl.append(30);
        dl.append(40);
        dl.printList();
        System.out.println();
        System.out.println("Prepend Operation");
        dl.prepend(5);
        dl.printList();
        System.out.println("\nInsert Operation");
        dl.insert(90,2);
        dl.printList();
        System.out.println("\nDelete First");
        dl.deleteFirst();
        dl.printList();
        System.out.println("\nDelete Last");
        dl.deleteLast();
        dl.printList();
        System.out.println("\nDelete at specified index");
        dl.delete(2);
        dl.printList();
    }
}

