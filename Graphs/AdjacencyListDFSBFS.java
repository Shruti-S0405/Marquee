package Marquee.BinarySearch.Graphs;

import java.util.LinkedList;

public class AdjacencyListDFSBFS
{
    static class Value
    {
        String val;
        LinkedList<Value> neighbors;
        int index;
        Value(String val, int index)
        {
            this.val = val;
            this.index = index;
            neighbors = new LinkedList<>();
        }
    }

    LinkedList<Value> nodeList;
    AdjacencyListDFSBFS(LinkedList<Value> nodeList)
    {
        this.nodeList = nodeList;
    }

    public void add(int i, int j)
    {
        Value f = nodeList.get(i);
        Value s = nodeList.get(j);
        f.neighbors.add(s);
        s.neighbors.add(f);
    }

    public void depthFirstSearch()
    {
        LinkedList<Value> stack = new LinkedList<>();
        stack.addLast(nodeList.get(0));
        int[] isVisited = new int[nodeList.size()];
        isVisited[0] = 1;
        while(!stack.isEmpty())
        {
            Value cur = stack.removeLast();
            for(Value val: cur.neighbors)
            {
                if(isVisited[val.index]==0)
                {
                    stack.addLast(val);
                    isVisited[val.index] = 1;
                }
            }
            System.out.print(cur.val+" ");
        }
    }

    public void display()
    {
        for(Value v: nodeList)
        {
            System.out.print(v.val+" : ");
            for(int i=0; i<v.neighbors.size()-1; i++)
            {
                System.out.print(v.neighbors.get(i).val + "--->");
            }
            System.out.print(v.neighbors.get(v.neighbors.size()-1).val);
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        LinkedList<Value> li = new LinkedList<>();
        li.add(new Value("A", 0));
        li.add(new Value("B",1));
        li.add(new Value("C", 2));
        li.add(new Value("D",3));
        li.add(new Value("E", 4));

        AdjacencyListDFSBFS al = new AdjacencyListDFSBFS(li);
        al.add(0,1);
        al.add(0,2);
        al.add(0, 3);
        al.add(1,4);
        al.add(3,2);
        al.add(3,4);
        al.display();
        al.depthFirstSearch();
    }
}
