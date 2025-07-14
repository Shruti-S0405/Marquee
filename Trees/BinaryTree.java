package Marquee.BinarySearch.Trees;
import java.util.*;
class BinaryTree {
    class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }

    Node root;
    int size;
    Scanner sc = new Scanner(System.in);
    public void add(){
        System.out.print("Enter the value for the root node: ");
        root = new Node(sc.nextInt());
        size++;
        add(root);
    }

    public void add(Node parent){
        System.out.print("Do u want to enter the right node?");
        char c = sc.next().toLowerCase().charAt(0);
        if(c=='y'){
            System.out.print("Enter the right node val: ");
            Node right = new Node(sc.nextInt());
            parent.right = right;
            size++;
            add(parent.right);
        }
        System.out.print("Do you want to enter the left node?");
        char ch = sc.next().toLowerCase().charAt(0);
        if(ch=='y'){
            System.out.print("Enter the left node val");
            Node left = new Node(sc.nextInt());
            parent.left = left;
            size++;
            add(parent.left);
        }
    }
    //Pre-Order traversal
    public void preOrder(){
        preOrder(root);
    }

    public void preOrder(Node node){
        System.out.print(node.val+" ");
        if(node.left!=null){
            preOrder(node.left);
        }
        if(node.right!=null){
            preOrder(node.right);
        }
    }

    //In-Order traversal
    public void inOrder(){
        preOrder(root);
    }

    public void inOrder(Node node){
        if(node.left!=null){
            inOrder(node.left);
        }
        System.out.print(node.val+" ");
        if(node.right!=null){
            inOrder(node.right);
        }
    }

    //Post Order Traversal
    public void postOrder(){
        postOrder(root);
    }

    public void postOrder(Node node){
        if(node.left!=null){
            postOrder(node.left);
        }
        if(node.right!=null){
            postOrder(node.right);
        }
        System.out.print(node.val+" ");
    }

    //Level Order Traversal
    

    public void display(){
        display(root, 0);
    }

    //Helper function it is
    public void display(Node parent, int level){
        if(parent.left!=null) display(parent.left, level+1);
        System.out.println("  ".repeat(level)+parent.val+"|");
        if(parent.right!=null) display(parent.right, level+1);
    }

    public static void main(String args[]){
        BinaryTree bt = new BinaryTree();
        bt.add();
        bt.display();

        System.out.println("Pre-Order Binary Tree Traversal");
        System.out.println("---------------------------------");
        bt.preOrder();
        System.out.println("---------------------------------");

        System.out.println("In-Order Binary Tree Traversal");
        System.out.println("---------------------------------");
        bt.inOrder();
        System.out.println("---------------------------------");

        System.out.println("Post-Order Binary Tree Traversal");
        System.out.println("---------------------------------");
        bt.postOrder();
        System.out.println("---------------------------------");
    }
}
