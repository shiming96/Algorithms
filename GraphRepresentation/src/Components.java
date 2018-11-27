public class Components {

    //求无权图的联通分量

    Graph G;    //图的引用
    private boolean[] visited;  //记录dfs的过程中节点是否被访问
    private int ccount; //记录联通分量个数
    private int[] id;   // 每个节点所对应的联通分量标记   相连节点Id相同

    public Components(Graph graph) {

        G = graph;
        visited = new boolean[G.V()];
        id = new int[G.V()];
        ccount = 0;

        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            id[i] = -1;
        }
        
        //求图的联通分量
        for (int i = 0; i < G.V(); i++) {
            if(!visited[i]) {
                dfs(i); //深度优先遍历
                ccount++;   //没遍历的节点在另外一个联通分量
            }
        }
    }

    //深度优先遍历
    private void dfs(int v) {

        visited[v] = true;
        id[v] = ccount;

        for (int i : G.adj(v)) {
            if(!visited[i])
                dfs(i);
        }


    }

    //返回图的联通分量个数
    public int count() {
        return ccount;
    }

    public boolean isConnected(int v, int w) {
        assert v >= 0 && v < G.V();
        assert w >= 0 && w < G.V();

        return id[v] == id[w];

    }




}
