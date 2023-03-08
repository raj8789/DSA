package GraphNew;

public class Edge implements Comparable<Edge>{
    int vertex;
    int weight;
    public Edge(int vertex,int weight){
        this.vertex=vertex;
        this.weight=weight;
    }
    public Edge(){
    }
    @Override
    public int compareTo(Edge o) {
        return this.weight-o.weight;
    }
}
