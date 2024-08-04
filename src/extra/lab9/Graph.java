package extra.lab9;
/*
如果图形的顶点可以分为两个不相交的集合，使得同一集合中的顶点之间不存在边。
编写一个方法来检测图形是否为二分图：使用 BFS 的公共布尔值 isBipartite（）。
*/
import java.util.*;

public class Graph {
    private int V; // 顶点数
    private LinkedList<Integer>[] adj; // 邻接表

    // 构造函数
    public Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // 添加边
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // 无向图
    }

    // 使用 BFS 检查图是否为二分图
    public boolean isBipartite() {
        int[] color = new int[V];
        Arrays.fill(color, -1); // 初始化所有顶点为未染色状态

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) { // 如果顶点未染色
                if (!bfsCheck(i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfsCheck(int src, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        color[src] = 0; // 将源顶点染为颜色 0

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : adj[u]) {
                if (color[v] == -1) { // 如果顶点未染色
                    color[v] = 1 - color[u]; // 将其染成与 u 不同的颜色
                    queue.add(v);
                } else if (color[v] == color[u]) { // 如果顶点已染色且与 u 颜色相同
                    return false;
                }
            }
        }
        return true;
    }

    // 测试程序
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        if (g.isBipartite()) {
            System.out.println("图是二分图");
        } else {
            System.out.println("图不是二分图");
        }

        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 3);
        g2.addEdge(2, 4);
        g2.addEdge(3, 4);

        if (g2.isBipartite()) {
            System.out.println("图是二分图");
        } else {
            System.out.println("图不是二分图");
        }
    }
}
