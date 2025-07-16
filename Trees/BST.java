//package Marquee.BinarySearch.Trees;
//
//public class BST {
//    class Node{
//        int val;
//        Node left;
//        Node right;
//        Node(int val){
//            this.val = val;
//        }
//    }
//    Node root;
//    int size;
//
//    public void add(int val){
//        root = add(root, val);
//    }
//
//    public Node add(Node node, int val){
//        if(node==null){
//            return new Node(val);
//        }
//        if(val>node.val){
//            node.right = add(node.right, val);
//        }
//        if(val<node.val){
//            node.left = add(node.left, val);
//        }
//        return node;
//    }
//
//    public void display(){
//        display(root, 0);
//    }
//
//    public void display(Node node, int level){
//        if(node == null){
//            return;
//        }
//        display(node.left,level+1);
//        System.out.println("    ".repeat(level>=1?level-1:level)+(level>=1?"|--->":"") + node.val);
//        display(node.right, level+1);
//    }
//
//    //In-Order traversal
//    public void inOrder(){
//        inOrder(root);
//    }
//
//    public void inOrder(Node node){
//        if(node.left!=null){
//            inOrder(node.left);
//        }
//        System.out.print(node.val+" ");
//        if(node.right!=null){
//            inOrder(node.right);
//        }
//    }
//
//    public boolean contains(int val){
//        return contains(root, val);
//    }
//
//    public boolean contains(Node node, int val){
//        if (node.val == val) {
//            return true;
//        }
//        if(node.left != null) contains(node.left, val);
//        if(node.right != null) contains(node.right, val);
//        return false;
//    }
//
//    public void delete(int val){
//        root = delete(root, val);
//    }
//
//    public Node delete(Node root, int key) {
//        if (root == null) return null;
//
//        if (key < root.val) {
//            root.left = delete(root.left, key);
//        } else if (key > root.val) {
//            root.right = delete(root.right, key);
//        } else {
//            // Node with only one child or no child
//            if (root.left == null) return root.right;
//            else if (root.right == null) return root.left;
//
//            // Node with two children: Get inorder successor (smallest in the right subtree)
//            Node min = findMin(root.right);
//            root.val = min.val;
//
//            // Delete the inorder successor
//            root.right = delete(root.right, min.val);
//        }
//
//        return root;
//    }
//
//    private Node findMin(Node node) {
//        while (node.left != null) {
//            node = node.left;
//        }
//        return node;
//    }
//
//    public static void main(String args[]){
//        BST bst = new BST();
//        bst.add(10);
//        bst.add(7);
//        bst.add(20);
//        bst.add(1);
//        bst.add(4);
//        bst.add(15);
//        bst.add(12);
//        bst.display();
//        System.out.println("\nInorder");
//        bst.inOrder();
//        System.out.println(bst.contains(100));
//        bst.delete(7);
//        System.out.println("\nInorder");
//        bst.inOrder();
//        bst.display();
//
//    }
//}
