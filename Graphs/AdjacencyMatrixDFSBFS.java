package Marquee.BinarySearch.Graphs;

import java.util.LinkedList;

public class AdjacencyMatrixDFSBFS {
    //Implementation of graph using matrix
    //Implemented BFS and DFS


    BFSAdjacencyMatrix.Value[] nodes;
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

    BFSAdjacencyMatrix(BFSAdjacencyMatrix.Value[] nodes)
    {
        this.nodes = nodes;
        matrix = new int[nodes.length][nodes.length];
    }

    public void add(int i, int j)
    {
        matrix[i][j] = 1;
        matrix[j][i] = 1;
    }

    public BFSAdjacencyMatrix.Value[] getNeighbors(BFSAdjacencyMatrix.Value val)
    {
        BFSAdjacencyMatrix.Value[] neighbors = new BFSAdjacencyMatrix.Value[nodes.length];
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
        LinkedList<BFSAdjacencyMatrix.Value> queue = new LinkedList<>();
        queue.addLast(nodes[0]);
        int[] isVisited = new int[nodes.length];
        isVisited[0] = 1;
        while(!queue.isEmpty())
        {
            BFSAdjacencyMatrix.Value cur = queue.removeFirst();
            for(BFSAdjacencyMatrix.Value val: getNeighbors(cur))
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
        for(BFSAdjacencyMatrix.Value node: nodes){
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
        BFSAdjacencyMatrix.Value[] nodes = {
                new BFSAdjacencyMatrix.Value("A",0),
                new BFSAdjacencyMatrix.Value("B",1),
                new BFSAdjacencyMatrix.Value("C", 2),
                new BFSAdjacencyMatrix.Value("D",3),
                new BFSAdjacencyMatrix.Value("E", 4),
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
