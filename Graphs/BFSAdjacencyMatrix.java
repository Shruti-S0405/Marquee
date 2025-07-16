package Marquee.BinarySearch.Graphs;

import java.util.LinkedList;
//Level By Level
//Breadth First Search
public class BFSAdjacencyMatrix
{
    Value[] nodes;
    int[][] matrix;

    static class Value
    {
        String val;
        int index;
        Value(String val, int index)
        {
            this.val = val;
            this.index = index;
        }
    }

    BFSAdjacencyMatrix(Value[] nodes)
    {
        this.nodes = nodes;
        matrix = new int[nodes.length][nodes.length];
    }

    public void add(int i, int j)
    {
        matrix[i][j] = 1;
        matrix[j][i] = 1;
    }

    public Value[] getNeighbors(Value val)
    {
        Value[] neighbors = new Value[nodes.length];
        int i=0;
        for(int k=0; k< nodes.length; k++)
        {
            if(matrix[val.index][k]==1)
            {
                neighbors[i++] = nodes[k];
            }
        }
        return neighbors;
    }

    public void breadthFirstSearch()
    {
        LinkedList<Value> queue = new LinkedList<>();
        queue.addLast(nodes[0]);
        int[] isVisited = new int[nodes.length];
        isVisited[0] = 1;
        while(!queue.isEmpty())
        {
            Value cur = queue.removeFirst();
            for(Value val: getNeighbors(cur))
            {
                if(val!=null && isVisited[val.index]==0)
                {
                    queue.addLast(val);
                    isVisited[val.index] = 1;
                }
            }
            System.out.print(cur.val+" ");
        }
    }



    public void display(){
        System.out.print("    ");
        for(Value node: nodes){
            System.out.print(node.val+" ");
        }
        System.out.println();
        for(int i=0; i<matrix.length; i++){
            System.out.print(nodes[i].val+" : ");
            for(int j: matrix[i]){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[])
    {
        Value[] nodes = {
            new Value("A",0),
            new Value("B",1),
            new Value("C", 2),
            new Value("D",3),
            new Value("E", 4),
        };

        BFSAdjacencyMatrix bfs = new BFSAdjacencyMatrix(nodes);
        bfs.add(0,1);
        bfs.add(0,2);
        bfs.add(0, 3);
        bfs.add(1,4);
        bfs.add(3,2);
        bfs.add(3,4);
        bfs.display();
        bfs.breadthFirstSearch();
        System.out.println();
    }
}
