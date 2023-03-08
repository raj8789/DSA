package GraphNew;

import java.util.*;

public class MinimumSpanningTree {
    int V;

    ArrayList<ArrayList<Edge>> al=new ArrayList<ArrayList<Edge>>();

    public MinimumSpanningTree(int V)
    {
        this.V=V;
        for(int i=0;i<V;i++){
            al.add(new ArrayList<Edge>());
        }
    }
    public void createEdge(int src,int des,int weight)
    {
        al.get(src).add(new Edge(des,weight));
        al.get(des).add(new Edge(src,weight));
    }
    public int  primsMST(int src){
        boolean vis[]=new boolean[V];
        int dis[]=new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        int ans=0;
        Queue<Edge> queue=new PriorityQueue<Edge>();
        queue.add(new Edge(src,0));
        while(!queue.isEmpty()){
            Edge cur=queue.poll();
            if(vis[cur.vertex]){
                continue;
            }
            vis[cur.vertex]=true;
            ans+=cur.weight;
            for(Edge neighbor: al.get(cur.vertex)){
                if(!vis[neighbor.vertex]){
                    if(dis[neighbor.vertex]>neighbor.weight){
                        dis[neighbor.vertex]= neighbor.weight;
                        queue.add(new Edge(neighbor.vertex,dis[neighbor.vertex]));
                    }
                }
            }
        }
        for(Integer e:dis){
            System.out.print(e+"   ");
        }
        return ans;
    }
}
