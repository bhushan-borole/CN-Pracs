import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {

    class Edge{
        int src, dest;
        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    ArrayList<Edge> listEdges = new ArrayList<>();

    private final int inf = 999;
    private final int nil = 98;
    int [][] graph = new int[][]{
            /*0*/   {  0,   2, inf, inf, inf},
            /*1*/   {inf,   0,   7,  10, inf},
            /*2*/   {inf, inf,   0, inf, 3},
            /*3*/   {  5, inf,  11,   0, inf},
            /*4*/   {inf, inf, inf,   3, 0}
    };

    int d[] = new int[graph.length];
    int p[] = new int[graph.length];

    void init_edges(){

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph.length;j++){
                if(graph[i][j] != inf){
                    listEdges.add(new Edge(i, j));
                }
            }
        }

    }

    private void init_source(int src) {
        for(int i=0;i<d.length;i++){
            d[i] = inf;
            p[i] = nil;
        }
        d[src] = 0;
    }

    private void solve(int source){
        init_edges();
        init_source(source);

        //step 2
        for(int i=1; i < graph.length; i++){
            // V = graph.length, ie no of vertices
            for(int j=0; j < listEdges.size(); j++ ){
                int u = listEdges.get(j).src;
                int v = listEdges.get(j).dest;

                // RELAX
                if(d[v] > d[u] + graph[u][v]){
                    d[v] = d[u] + graph[u][v];
                    p[v] = d[u];
                }
            }
        }

        //step 3: check for negative cycles
        for(int j=0; j < listEdges.size(); j++){
            int u = listEdges.get(j).src;
            int v = listEdges.get(j).dest;

            // RELAX
            if(d[v] > d[u] + graph[u][v]){
                System.out.printf("Negative cycle at: u=%d, v=%d\n", u, v);
            }
        }

        System.out.println("D: " + Arrays.toString(d));
        System.out.println("P: " + Arrays.toString(p));
    }


    public static void main(String[] args) {
        new BellmanFord().solve(0);
    }
}