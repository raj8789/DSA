package GraphNew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijksTraAlgorithm {
    int v;
    ArrayList<ArrayList<Edge>> al=new ArrayList<>();
    public DijksTraAlgorithm(int v){
        this.v=v;
        for(int i=0;i<v;i++){
            al.add(new ArrayList<Edge>());
        }
    }
    public void createEdge(int src,int dest,int weight){
        al.get(src).add(new Edge(dest,weight));
        al.get(dest).add(new Edge(src,weight));
    }
    public int[] DijksImpl(int src){
        boolean vis[]=new boolean[v];
        int dis[]=new int[v];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        Queue<Edge> queue=new PriorityQueue<Edge>();
        queue.add(new Edge(src,0));
        while (!queue.isEmpty()){
            Edge cur=queue.poll();
            if(vis[cur.vertex]){
                continue;
            }
            dis[cur.vertex]=cur.weight;
            vis[cur.vertex]=true;
            for(Edge neighbor:al.get(cur.vertex)){
                if(!vis[neighbor.vertex]){
                    if(dis[neighbor.vertex]>neighbor.weight+dis[cur.vertex]){
                        dis[neighbor.vertex]=neighbor.weight+dis[cur.vertex];
                        queue.add(new Edge(neighbor.vertex,dis[neighbor.vertex]));
                    }
                }
            }
        }
        return dis;
    }
}
