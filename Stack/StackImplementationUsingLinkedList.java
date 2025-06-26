package Marquee.BinarySearch.Stack;

public class StackImplementationUsingLinkedList {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
        }
    }

    Node top;
    int size = -1;

    public boolean isEmpty(){
        if(size==-1) return true;
        return false;
    }

    public boolean push(int val){
        Node node = new Node(val);
        if(isEmpty()){
            top = node;
        }
        else{
            node.next = top;
            top = node;
        }
        size++;
        return true;
    }

    public boolean pop(){
        if(isEmpty()){
            return false;
        }
        else{
            top = top.next;
            size--;
            return true;
        }
    }

    public int peek(){
        if(isEmpty()) return -1;
        else{
            return top.val;
        }
    }

    public void displayStack(){
        Node temp = top;
        while(temp!=null){
            if(temp.next==null){
                System.out.print(temp.val);
            }
            else{
                System.out.print(temp.val);
                System.out.print("-->");
            }
            temp = temp.next;
        }

    }

    public static void main(String args[]){
        StackImplementationUsingLinkedList stl = new StackImplementationUsingLinkedList();
        System.out.println(stl.push(10)?"\nPush operation success":"\nPush Operation not possible");
        stl.displayStack();
        System.out.println(stl.push(20)?"\nPush Operation Success":"\nPush Operation not possible");
        stl.displayStack();
        System.out.println(stl.push(30)?"\nPush Operation Success":"\nPush Operation not possible");
        stl.displayStack();
        System.out.println(stl.pop()?"\nPopped an element out of stack :(":"\nPop Operation not possible");
        stl.displayStack();
        System.out.println("\nThe peek of the stack is printed");
        System.out.println(stl.peek());
        stl.pop();
        stl.pop();
        System.out.println(stl.isEmpty()?"\nStack is empty":"\nStack is not Empty");
        stl.displayStack();
    }
}
