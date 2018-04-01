package lab3;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BFS {

    int[] distance;
    String[] colour;
    LinkedList[] parent = null;
    Queue<Integer> q = new ArrayDeque<Integer>();
    public int[] lengths(int source, LinkedList[] list) {
        distance = new int[list.length];
        colour = new String[list.length];
        parent = new LinkedList[list.length];
        for(int i = 0; i < list.length; i++){
              colour[i] = "white";
              distance[i] = 99999;
              parent[i] = null;
        }
        colour[source] = "grey";
        distance[source] = 0;
        parent[source] = null;
        q.add(source);
        while(q.isEmpty() == false){
             int u = q.poll();
             for(Node n = list[u].head.next; n!=null; n=n.next){
                      if(colour[(int)n.element]== "white"){
                            colour[(int)n.element] = "grey";
                            distance[(int)n.element] = distance[u] + 1;
                            parent[(int)n.element] = list[u];
                            q.add((int)n.element);
                      }
             }
             colour[u] = "black";
        }
        return distance;
    }

    

}
