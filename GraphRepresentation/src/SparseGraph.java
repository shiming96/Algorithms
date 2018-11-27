import java.util.ArrayList;

public class SparseGraph implements Graph {

    //稀疏图   -   领接表

    private int n;  //节点数
    private int m;  //边数
    boolean isDirected; //是否为有向图
    private ArrayList<Integer>[] g;//图的具体数据

    public SparseGraph(int n, boolean isDirected) {
        assert n >= 0;
        this.n = n;
        this.m = 0; //初始化没有任何边
        this.isDirected = isDirected;
        // g初始化为n*n的布尔矩阵, 每一个g[i][j]均为false, 表示没有任和边
        // false为boolean型变量的默认值
        g = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<Integer>();
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
    public void addEdge(int v, int w) {
        assert v >=0 && v < n;
        assert w >=0 && w < n;

        g[v].add(w);
        if( v != w && !isDirected)  //不是自环边且无向
            g[w].add(v);

        m++;

    }

    public boolean hasEdge(int v, int w) {

        assert v >=0 && v < n;
        assert w >=0 && w < n;

        for (int i = 0; i < g[v].size(); i++) {
            if(g[v].get(i) == w)
                return true;
        }
        return false;

    }

    // 显示图的信息
    public void show(){

        for( int i = 0 ; i < n ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            for( int j = 0 ; j < g[i].size() ; j ++ )
                System.out.print(g[i].get(j) + "\t");
            System.out.println();
        }
    }

    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }


}
