package Marquee.BinarySearch.Graphs;

import java.util.LinkedList;

public class AdjacencyList
{
    java.util.LinkedList<String> nodes; //Inline import statements
    java.util.LinkedList<java.util.LinkedList<String>> neighbors;

    public AdjacencyList(java.util.LinkedList<String> nodes)
    {
        this.nodes = nodes;
        neighbors = new java.util.LinkedList<>();
        for(int i=0; i<nodes.size(); i++)
        {
            neighbors.add(new LinkedList<>());
        }
    }

    public void add(int i, int j){
        String first = nodes.get(i);
        String second = nodes.get(j);

        neighbors.get(i).add(second);
        neighbors.get(j).add(first);
    }

    public void display()
    {
        for(int i=0; i<nodes.size(); i++){
            System.out.print(nodes.get(i)+" : ");
            java.util.LinkedList<String> ne = neighbors.get(i);
            if(ne!=null){
                for(int j=0; j<ne.size(); j++){
                    System.out.print(ne.get(j)+(j+1==ne.size()?"":"-->"));
                }
                System.out.println();
            }
        }
    }

    public static void main(String args[]){
        java.util.LinkedList<String> li = new LinkedList<>();
        li.add("A");
        li.add("B");
        li.add("C");
        li.add("D");
        li.add("E");
        AdjacencyList al = new AdjacencyList(li);
        al.add(0, 1);
        al.add(0, 3);
        al.add(1,2);
        al.add(1,4);
        al.add(3,4);
        al.add(2,4);
        al.display();
    }
}
