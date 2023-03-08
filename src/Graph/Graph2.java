package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph2 {
    int V;
    ArrayList<ArrayList<Integer>> al=new ArrayList<ArrayList<Integer>>();
    public Graph2(int V)
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
    public void createDirectedEdge(int src,int des){
        al.get(src).add(des);
    }
    public boolean isCyclePresent(int src,boolean vis[]){
        vis[src]=true;
        for(Integer neighbor: al.get(src)){
            if(!vis[neighbor]){
                if(isCyclePresent(neighbor,vis)){
                    return true;
                }
            }
            else if(neighbor!=src){
                return true;
            }
        }
        return false;
    }
    public void inDegree(int inDeg[]){
        for(int i=0;i<V;i++){
            for(int neighbor:al.get(i)){
                inDeg[neighbor]++;
            }
        }
    }

    public void outDeg(int outDeg[]){
        for(int i=0;i<V;i++){
            outDeg[i]=al.get(i).size();
        }
    }
    public void TopologicalSortUsingDFS(int src,boolean vis[]){
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                Dfs_forTopological(i,vis,stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    public void Dfs_forTopological(int src,boolean vis[],ArrayDeque<Integer> stack){
        vis[src]=true;
        for(Integer neighbor:al.get(src)){
            if(!vis[neighbor]){
                Dfs_forTopological(neighbor,vis,stack);
            }
        }
        stack.push(src);
    }
    public void kahnAlgorithmTopologicalSortBFS(int src,boolean vis[],int inDeg[]){
        inDegree(inDeg);
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDeg[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int cur=queue.poll();
            System.out.println(cur);
            for(Integer neighbor:al.get(cur))
            {
                inDeg[neighbor]--;
                if(inDeg[neighbor]==0){
                    queue.add(neighbor);
                }
            }
        }
    }
}
