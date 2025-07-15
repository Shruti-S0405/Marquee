package Marquee.BinarySearch.Graphs;

import java.util.LinkedList;

public class AdjacencyList2
{
    static class Value
    {
        String val;
        LinkedList<String> neighbors;
        Value(String val)
        {
            this.val = val;
            neighbors = new LinkedList<>();
        }
    }
    LinkedList<Value> nodeList;

    AdjacencyList2(LinkedList<Value> nodeList){
        this.nodeList = nodeList;
    }

    public void add(int i, int j)
    {
        //In this method each time get() method is called
//        String first = nodeList.get(i).val;
//        String second = nodeList.get(j).val;
//        nodeList.get(i).neighbors.add(second);
//        nodeList.get(j).neighbors.add(first);

        Value f = nodeList.get(i);
        Value s = nodeList.get(j);
        f.neighbors.add(s.val);
        s.neighbors.add(f.val);
    }

    public void display()
    {
        for(Value v: nodeList)
        {
            System.out.print(v.val+" : ");
            for(int i=0; i<v.neighbors.size()-1; i++)
            {
                System.out.print(v.neighbors.get(i) + "--->");
            }
            System.out.print(v.neighbors.get(v.neighbors.size()-1));
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        LinkedList<Value> li = new LinkedList<>();
        li.add(new Value("A"));
        li.add(new Value("B"));
        li.add(new Value("C"));
        li.add(new Value("D"));
        li.add(new Value("E"));

        AdjacencyList2 al = new AdjacencyList2(li);
        al.add(0,1);
        al.add(0,3);
        al.add(1,2);
        al.add(1,4);
        al.add(3,4);
        al.add(2,4);
        al.display();
    }
}
