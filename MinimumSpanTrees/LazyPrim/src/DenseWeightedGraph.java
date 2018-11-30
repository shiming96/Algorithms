import java.util.Vector;

public class DenseWeightedGraph<Weight extends Number & Comparable>
        implements WeightedGraph {

    //稠密图   -   领接矩阵

    private int n;  //节点数
    private int m;  //边数
    boolean isDirected; //是否为有向图
    private Edge<Weight>[][] g;  //图的具体数据

    public DenseWeightedGraph(int n, boolean isDirected) {
        assert n >= 0;
        this.n = n;
        this.m = 0; //初始化没有任何边
        this.isDirected = isDirected;
        // g初始化为n*n的布尔矩阵, 每一个g[i][j]均为false, 表示没有任和边
        // false为boolean型变量的默认值
        g = new Edge[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = null;
            }
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
        assert e.V() >=0 && e.V() < n;
        assert e.W() >=0 && e.W() < n;

        if(hasEdge(e.V(), e.W()))
            return;

        g[e.V()][e.W()] = new Edge(e);
        if(e.V() != e.W() && !isDirected)
            g[e.W()][e.V()] = new Edge(e.W(),e.V(),e.wt());

        m++;
    }

    // 显示图的信息
    public void show(){

        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ ) {
                if (g[i][j] != null)
                    System.out.print(g[i][j].wt() + "\t");
                else
                    System.out.print("NULL\t");
            }
            System.out.println();
        }
    }

    public boolean hasEdge(int v, int w) {

        assert v >=0 && v < n;
        assert w >=0 && w < n;
        return g[v][w] != null;
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Edge<Weight>> adjV = new Vector<Edge<Weight>>();
        for(int i = 0 ; i < n ; i ++ )
            if( g[v][i] != null )
                adjV.add( g[v][i] );
        return adjV;
    }

}
