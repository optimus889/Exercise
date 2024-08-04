package extra.lab9;
/*
在讲座中，我们使用邻接列表实现了 Prim 算法。
使用帮助程序，使用加权图的邻接矩阵实现算法上一个练习的方法。
*/
import java.util.Arrays;

public class PrimAlgorithm {
    private static final double INF = Double.POSITIVE_INFINITY;

    // 使用 Prim 算法找到最小生成树
    public static void primMST(Double[][] graph) {
        int V = graph.length;
        boolean[] inMST = new boolean[V]; // 标记顶点是否在最小生成树中
        double[] key = new double[V]; // 存储顶点到 MST 的最小边权值
        int[] parent = new int[V]; // 存储最小生成树中的父节点

        // 初始化所有顶点的键值为正无穷，并将父节点设为 -1
        Arrays.fill(key, INF);
        Arrays.fill(parent, -1);

        // 从第一个顶点开始
        key[0] = 0;

        for (int count = 0; count < V - 1; count++) {
            // 选择键值最小且未包含在 MST 中的顶点
            int u = minKey(key, inMST);
            inMST[u] = true; // 将选定的顶点包含在 MST 中

            // 更新与选定顶点相邻的顶点的键值
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != INF && !inMST[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // 打印最小生成树
        printMST(parent, graph);
    }

    // 选择键值最小且未包含在 MST 中的顶点
    private static int minKey(double[] key, boolean[] inMST) {
        double min = INF;
        int minIndex = -1;

        for (int v = 0; v < key.length; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // 打印最小生成树
    private static void printMST(int[] parent, Double[][] graph) {
        System.out.println("边   权重");
        for (int i = 1; i < graph.length; i++) {
            System.out.println(parent[i] + " - " + i + "  " + graph[i][parent[i]]);
        }
    }

    // 测试程序
    public static void main(String[] args) {
        WeightedGraph1 graph = new WeightedGraph1 (5);
        graph.addEdge(0, 1, 2.5);
        graph.addEdge(0, 3, 1.2);
        graph.addEdge(1, 2, 3.8);
        graph.addEdge(2, 3, 2.2);
        graph.addEdge(3, 4, 4.0);

        Double[][] adjacencyMatrix = graph.getAdjacentMatrix();
        System.out.println("邻接矩阵：");
        graph.printAdjacencyMatrix();

        System.out.println("\n最小生成树：");
        primMST(adjacencyMatrix);
    }
}

class WeightedGraph1 {
    private int V; // 顶点数
    private Double[][] adjacencyMatrix; // 邻接矩阵

    // 构造函数
    public WeightedGraph1(int V) {
        this.V = V;
        adjacencyMatrix = new Double[V][V];
        for (int i = 0; i < V; i++) {
            Arrays.fill(adjacencyMatrix[i], Double.POSITIVE_INFINITY); // 初始化为正无穷，表示没有边
        }
    }

    // 添加边
    public void addEdge(int u, int v, double weight) {
        adjacencyMatrix[u][v] = weight;
        adjacencyMatrix[v][u] = weight; // 对于无向图，边是对称的
    }

    // 获取邻接矩阵
    public Double[][] getAdjacentMatrix() {
        return adjacencyMatrix;
    }

    // 打印邻接矩阵
    public void printAdjacencyMatrix() {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adjacencyMatrix[i][j] == Double.POSITIVE_INFINITY) {
                    System.out.print("INF ");
                } else {
                    System.out.printf("%.2f ", adjacencyMatrix[i][j]);
                }
            }
            System.out.println();
        }
    }
}
