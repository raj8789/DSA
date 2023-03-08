package GraphNew;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Graph3{ // this Creates weighted graph and helps to find the shortest path
    ArrayList<ArrayList<Pair>> adj;
    int V;
    public Graph3(int V){
        this.V=V;
        adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Pair>());
        }
    }
    public void createEdge(int src,int dest,int weight){
        adj.get(src).add(new Pair(dest,weight));
    }
    public ArrayDeque<Integer> topologicalSortImpl(){
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i])
            dfsImpl(i,stack,vis);
        }
        return  stack;
    }
    public void dfsImpl(int src,ArrayDeque<Integer> stack,boolean vis[]){
        vis[src]=true;
        for(Pair neighbor:adj.get(src)){
            if(!vis[neighbor.vertex]){
                dfsImpl(neighbor.vertex,stack,vis);
            }
        }
        stack.push(src);
    }
    public int[] shortestPath(){
        ArrayDeque<Integer> stack=topologicalSortImpl();
        int []path=new int[V];
        Arrays.fill(path,Integer.MAX_VALUE);
        if(!stack.isEmpty())
        {
            path[stack.peek()]=0;
        }
        while(!stack.isEmpty())
        {
            int cur=stack.poll();
            for(Pair neighbor:adj.get(cur))
            {
                if(path[neighbor.vertex]>path[cur]+ neighbor.weight)
                {
                    path[neighbor.vertex]=path[cur] + neighbor.weight;
                }
            }
        }
        return path;
    }
}
class Pair
{
    int vertex;
    int weight;
    public Pair(int vertex,int weight){
        this.vertex=vertex;
        this.weight=weight;
    }
}
