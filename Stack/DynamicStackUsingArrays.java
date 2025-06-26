package Marquee.BinarySearch.Stack;

public class DynamicStackUsingArrays {
    int[] stack = new int[5];
    int top = -1;

    public boolean isEmpty(){
        if(top==-1) return true;
        return false;
    }

    public boolean isFull(){
        if(top==stack.length-1){
            return true;
        }
        return false;
    }

    public boolean push(int val){
        if(isFull()) {
            int[] newStack = new int[stack.length+stack.length];
            for(int i=0; i<top; i++){
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
        top++;
        stack[top] = val;
        return true;
    }

    public boolean pop(){
        if(isEmpty()) return false;

        top = top-1;
        if(top+1<=stack.length/2){
            int[] newStack = new int[stack.length/2];
            for(int i=0; i<top; i++){
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
        return true;
    }

    public void displayStack(){
        System.out.print("[ "+ stack[0]);
        for(int i=0; i<top; i++){
            System.out.print(", "+ stack[i]);
        }
        System.out.print(" ]");
    }

    public static void main(String[] args){
        StackImplementationUsingArrays std = new StackImplementationUsingArrays();
        std.displayStack();
        std.push(10);
        std.push(20);
        std.push(30);
        std.push(90);
        std.push(100);
        std.push(45);
        std.pop();
        std.pop();
        std.displayStack();
        System.out.println("\nLength of the stack");
        System.out.println(std.stack.length);

    }
}
