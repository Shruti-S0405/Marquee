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
        System.out.print("Root node val: ");
        root = new Node(sc.nextInt());
        size++;
        add(root);
    }

    public void add(Node parent){
        System.out.print("Left node of y/n"+parent.val);
        char ch = sc.next().toLowerCase().charAt(0);
        if(ch=='y'){
            System.out.print("Val of"+parent.val);
            Node left = new Node(sc.nextInt());
            parent.left = left;
            size++;
            add(parent.left);
        }
        System.out.print("right node of y/n"+parent.val);
        char c = sc.next().toLowerCase().charAt(0);
        if(c=='y'){
            System.out.print("Val of"+parent.val);
            Node right = new Node(sc.nextInt());
            parent.right = right;
            size++;
            add(parent.right);
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
        inOrder(root);
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
    Queue<Node> queue = new LinkedList<>();
    public void levelOrder() {
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.peek();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            System.out.print(node.val + " ");
            queue.remove();
        }
    }

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

        System.out.println("Level-Order Binary Tree Traversal");
        System.out.println("---------------------------------");
        bt.levelOrder();
        System.out.println("---------------------------------");


    }
}
