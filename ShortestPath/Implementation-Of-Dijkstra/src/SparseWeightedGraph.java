import java.util.Vector;

public class SparseWeightedGraph<Weight extends Number & Comparable> implements  WeightedGraph {

    //稀疏图   -   领接表

    private int n;  //节点数
    private int m;  //边数
    boolean isDirected; //是否为有向图
    private Vector<Edge<Weight>>[] g;//图的具体数据

    public SparseWeightedGraph(int n, boolean isDirected) {
        assert n >= 0;
        this.n = n;
        this.m = 0; //初始化没有任何边
        this.isDirected = isDirected;
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        g = (Vector<Edge<Weight>>[]) new Vector[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Vector<Edge<Weight>>();
        }
    }

    //返回节点个数
    public int V() {
        return n;
    }

    //返回边的个数
    public int E() {
        return m;
    }

    // 向图中添加一个边
    public void addEdge(Edge e) {
        assert e.V() >= 0 && e.V() < n ;
        assert e.W() >= 0 && e.W() < n ;

        g[e.V()].add(new Edge(e));
        if(e.V() != e.W() && !isDirected)
            g[e.W()].add(new Edge(e.W(),e.V(),e.wt()));

        m++;

    }

    // 验证图中是否有从v到w的边
    public boolean hasEdge(int v, int w) {

        assert v >=0 && v < n;
        assert w >=0 && w < n;

        for (int i = 0; i < g[v].size(); i++) {
            if(g[v].elementAt(i).other(v) == w)
                return true;
        }
        return false;

    }

    // 显示图的信息
    public void show(){

        for( int i = 0 ; i < n ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            for( int j = 0 ; j < g[i].size() ; j ++ ) {
                Edge e = g[i].elementAt(j);
                System.out.print("( to:" + e.other(i) + ",wt:" + e.wt() + ")\t");
            }
            System.out.println();
        }
    }
    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;

        return g[v];
    }


}
