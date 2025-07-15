package Marquee.BinarySearch.Graphs;
import java.util.*;

//Graph Implementation using Arrays -> Adjacency Matrix
class GraphImplementation {
    String[] nodes;
    int[][] matrix;

    GraphImplementation(String[] nodes){
        this.nodes = nodes;
        matrix = new int[nodes.length][nodes.length];
    }

    public void add(int i, int j){
        //To handle the edge cases
        if(i>=matrix.length || j>=matrix.length || i<0 || j<0){
            System.out.println("Invalid Input!");
        }
        //If edge present 1
        else{
            matrix[i][j] = 1;
            matrix[j][i] = 1;
        }
    }

    public void delete(int i, int j){
        //To handle edge cases
        if(i>=matrix.length || j>=matrix.length || i<0 || j<0) System.out.println("Invalid Input");
        //If edge not found
        else if(matrix[i][j]==0) System.out.println("Edge not found!");
        //If found delete
        else{
            matrix[i][j] = 0;
            matrix[j][i] = 0;
        }
    }

    public void display(){
        System.out.print("    ");
        for(String str: nodes){
            System.out.print(str+" ");
        }
        System.out.println();
        for(int i=0; i<matrix.length; i++){
            System.out.print(nodes[i]+" : ");
            for(int j: matrix[i]){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        String[] str = new String[]{
                "A", "B","C","D","E"
        };
        GraphImplementation gi = new GraphImplementation(str);
        gi.add(0,1);
        gi.add(0, 3);
        gi.add(1,2);
        gi.add(1,4);
        gi.add(2,4);
        gi.add(3,4);
        gi.display();

        System.out.println("-------------------");
        System.out.println("After deleting the edge: ");
        System.out.println("-------------------");
        gi.delete(8,9);
        gi.display();
    }
}
