import Graph.Graph1;
import Graph.Graph2;
public class MainClass {
    public static void main(String[] args) {
        int v=6;
        /*Graph1 graph1=new Graph1(v);
        graph1.createEdge(0,1);
        graph1.createEdge(0,2);
        graph1.createEdge(1,4);
        graph1.createEdge(2,4);
        graph1.createEdge(2,3);
        graph1.createEdge(3,4);
        graph1.createEdge(4,5);
        graph1.createEdge(3,6);
        graph1.createEdge(5,6);
        graph1.createEdge(5,7);
        graph1.createEdge(6,7);
        graph1.createEdge(7,8);
        graph1.createEdge(8,9);*/
        boolean vis[]=new boolean[v];
        int dis[]=new int[v];
        int count=0;
        //graph1.dfs(0,vis);
        //graph1.bfs(0,vis);
        /*for(int i=0;i<v;i++){ //count no of component in a graph
            if(!vis[i]){
                count++;
                graph1.bfs(i,vis);
            }
        }*/
        //System.out.println("No Of Component "+count);
        /*graph1.shortestPath(0,vis,dis);
        for(int e:dis){
            System.out.print(e+" ");
        }*/
         Graph2 graph2=new Graph2(v);
       /*  graph2.createEdge(0,1);
         graph2.createEdge(1,3);
         graph2.createEdge(2,3);
         graph2.createEdge(3,5);
         graph2.createEdge(5,2);
         graph2.createEdge(0,4);
        System.out.println(graph2.isCyclePresent(0,vis));*/
        /*int indeg[]=new int[v];
        int outDeg[]=new int[v];
        graph2.createDirectedEdge(0,1);
        graph2.createDirectedEdge(1,3);
        graph2.createDirectedEdge(1,2);
        graph2.createDirectedEdge(0,2);
        graph2.createDirectedEdge(2,3);
        graph2.inDegree(indeg);
        graph2.outDeg(outDeg);
        for (int e:indeg){
            System.out.println(e+" ");
        }
        System.out.println("*********************");
        for (int e:outDeg){
            System.out.println(e+" ");
        }*/
        graph2.createDirectedEdge(0,1);
        graph2.createDirectedEdge(1,3);
        graph2.createDirectedEdge(0,2);
        graph2.createDirectedEdge(1,2);
        graph2.createDirectedEdge(3,5);
        graph2.createDirectedEdge(4,5);
        graph2.createDirectedEdge(3,4);
        //graph2.TopologicalSortUsingDFS(0,vis);
        graph2.kahnAlgorithmTopologicalSortBFS(0,vis,dis);
    }
}