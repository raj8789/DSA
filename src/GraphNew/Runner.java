package GraphNew;

public class Runner {
    public static void main(String[] args) {
        /*int V=5;
        Graph3 graph3=new Graph3(V);
        graph3.createEdge(0,1,2);
        graph3.createEdge(0,4,7);
        graph3.createEdge(0,2,1);
        graph3.createEdge(2,3,2);
        graph3.createEdge(3,4,2);
        graph3.createEdge(1,4,4);
        int ans[]= graph3.shortestPath();
        for(int e:ans){
            System.out.println(e);
        }*/
        int v=6;
        /*MinimumSpanningTree minimumSpanningTree=new MinimumSpanningTree(v);
        minimumSpanningTree.createEdge(0,1,1);
        minimumSpanningTree.createEdge(0,2,4);
        minimumSpanningTree.createEdge(1,2,2);
        minimumSpanningTree.createEdge(1,4,2);
        minimumSpanningTree.createEdge(1,3,5);
        minimumSpanningTree.createEdge(2,4,1);
        minimumSpanningTree.createEdge(4,5,2);
        minimumSpanningTree.createEdge(3,5,3);
        int ans=minimumSpanningTree.primsMST(0);
        System.out.println(ans);*/
        DijksTraAlgorithm dja=new DijksTraAlgorithm(v);
        dja.createEdge(0,1,1);
        dja.createEdge(0,2,4);
        dja.createEdge(1,2,2);
        dja.createEdge(1,4,2);
        dja.createEdge(1,3,5);
        dja.createEdge(2,4,1);
        dja.createEdge(4,5,2);
        dja.createEdge(3,5,3);
        int ans[]=dja.DijksImpl(0);
        for(int e:ans){
            System.out.print(e+"   ");
        }
    }
}
