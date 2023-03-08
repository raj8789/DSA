package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Graph1 {
    int V;
    ArrayList<ArrayList<Integer>> al=new ArrayList<ArrayList<Integer>>();
    public Graph1(int V)
    {
            this.V=V;
            for(int i=0;i<V;i++){
                al.add(new ArrayList<Integer>());
            }
    }
    public void createEdge(int src,int des){
        al.get(src).add(des);
        al.get(des).add(src);
    }
    public void dfs(int src,boolean vis[]){
        vis[src]=true;
        System.out.println(src+" ");
        for(Integer neighbor:al.get(src)){
            if(!vis[neighbor]){
                dfs(neighbor,vis);
            }
        }
    }
    public void bfs(int src,boolean vis[]){
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        stack.add(src);
        vis[src]=true;
        while(!stack.isEmpty()){
            int cur=stack.poll();
            System.out.print(cur+" ");
            for(Integer neighbor:al.get(cur)){
                if(!vis[neighbor]){
                    stack.add(neighbor);
                    vis[neighbor]=true;
                }
            }
        }
    }
    public void shortestPath(int src,boolean vis[],int dis[]){
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        stack.add(src);
        vis[src]=true;
        dis[src]=0;
        while(!stack.isEmpty()){
            int cur=stack.poll();
            for(Integer neighbor:al.get(cur)){
                if(!vis[neighbor]){
                    stack.add(neighbor);
                    vis[neighbor]=true;
                    dis[neighbor]=dis[cur]+1;
                }
            }
        }
    }
}
