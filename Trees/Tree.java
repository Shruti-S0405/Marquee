package Marquee.BinarySearch.Trees;

import java.util.Scanner;

public class Tree {
    class Node{
        int val;
        Node[] arr;
        Node(int val){
            this.val= val;
        }
    }
    Node root;
    int size;
    Scanner sc = new Scanner(System.in);
    public void add(){
        System.out.println("Enter the value to be inserted into the node: ");
        root = new Node(sc.nextInt());
        size++;
        add(root);
    }

    public void add(Node parent){
        System.out.println("Do you want to add child nodes to the parent -: "+parent.val);
        char c = sc.next().toLowerCase().charAt(0);
        if(c=='y'){
            System.out.println("How many child node to be inserted?");
            int num = sc.nextInt();
            parent.arr = new Node[num];
            for(int i=0; i<num; i++){
                System.out.println("Enter the val to insert child node: ");
                parent.arr[i] = new Node(sc.nextInt());
                size++;
                add(parent.arr[i]);
            }
        }
    }

    public void display(){
        System.out.println(root.val);
        display(root, 0);

    }
    public void display(Node parent, int level){
        System.out.println(" ".repeat(level)+parent.val);
        if(parent.arr!=null){
            for(Node node: parent.arr){
                display(node, level+1);
            }
        }
        else{
            return;
        }
    }


    public static void main(String args[]){
        Tree tree = new Tree();
        tree.add();
        tree.display();
        System.out.println(tree.size);
    }

}
