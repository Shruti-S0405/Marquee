package Marquee.BinarySearch.Stack;

public class StackImplementationUsingArrays {
    int[] stack = new int[20];
    int top = -1;

    public boolean push(int val){
        if(isFull()) return false;
        top++;
        stack[top] = val;
        return true;
    }

    public boolean isFull(){
        return top==stack.length-1;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean pop(){
        if(isEmpty()) return false;
        top=top-1;
        return true;
    }

    public int peek(){
        if(isEmpty()) return -1;
        return stack[top];
    }

    public void displayStack(){
        System.out.print(stack[0]);
        for(int i=1; i<=top; i++){
            System.out.print(", "+stack[i]);
        }
    }

    public static void main(String args[]){
        StackImplementationUsingArrays st = new StackImplementationUsingArrays();
        System.out.println(st.push(10)?"\nPush operation success":"\nPush Operation not possible");
        st.displayStack();
        System.out.println(st.push(20)?"\nPush Operation Success":"\nPush Operation not possible");
        st.displayStack();
        System.out.println(st.push(30)?"\nPush Operation Success":"\nPush Operation not possible");
        st.displayStack();
        System.out.println(st.pop()?"\nPopped an element out of stack :(":"\nPop Operation not possible");
        st.displayStack();
        System.out.println("\nThe peek of the stack is printed");
        System.out.println(st.peek());
        st.pop();
        st.pop();
        System.out.println(st.isEmpty()?"\nStack is empty":"\nStack is not Empty");
        st.displayStack();
        System.out.println(st.isFull()?"\nStack is full":"\nStack is not full");
        st.displayStack();
    }
}
