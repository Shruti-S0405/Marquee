package Marquee.BinarySearch.Trees;

public class SBBinaryTree {
    class Node{
        int val;
        int height;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
        }
    }
    Node root;
    int size;

    public int height(Node node){
        return node==null? -1: node.height;
    }

    public void add(int val){
        root = add(root, val);
    }
    //Inserting the node in the form of binary search tree
    public Node add(Node node, int val){
        if(node==null){
            size++;
            return new Node(val);
        }
        if(node.val>val) node.left=add(node.left, val);
        if(node.val<val) node.right = add(node.right, val);
        node.height = Math.max(height(node.left),height(node.right))+1;
        //return node; //Every time we send the node to the parent we need to check
                    // whether the particular node is balanced or not
        return rotate(node);

    }

    public Node rotate(Node node){
        //It means we need to perform right rotation
        if(height(node.left)-height(node.right)>1){
            //Before check the other condition
            if(height(node.left.left)-height(node.left.right)>0){
                return rightRotate(node);
            }
            else{
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        //Left Rotation
        if(height(node.right)-height(node.left)>1){
            //Before check the other condition
            if(height(node.right.right)-height(node.right.left)>0){
                return leftRotate(node);
            }
            else{
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    public Node rightRotate(Node node){
        Node mid = node.left;
        Node rc = mid.right;
        mid.right = node;
        node.left = rc;
        node.height = Math.max(height(node.left),height(node.right))+1;
        mid.height = Math.max(height(mid.left),height(mid.right))+1;
        return mid;
    }

    public Node leftRotate(Node node){
        Node mid = node.right;
        Node lc = mid.left;
        mid.left = node;
        node.right = lc;
        node.height = Math.max(height(node.left),height(node.right))+1;
        mid.height = Math.max(height(mid.left),height(mid.right))+1;
        return mid;
    }

    public void display(){
        display(root, 0);
    }

    public void display(Node node, int level){
        if(node==null){
            return;
        }
        display(node.right, level+1);
        System.out.println("|  ".repeat(level)+(level>=1?"|--":"")+node.val+","+node.height);
        display(node.left, level+1);
    }

    public static void main(String args[]){
        SBBinaryTree sb = new SBBinaryTree();
        sb.add(10);
        sb.add(7);
//        sb.add(5);
        sb.add(15);
        sb.add(4);
        sb.add(3);
//        sb.add(1);
        sb.display();
    }
}
