package extra.lab9;
/*
创建一个名为 getAdjacentMatrix（） 的辅助方法以生成邻接矩阵
加权图的表示形式。
使用双精度的 2D 数组：Double[][].
*/
import java.util.Arrays;

public class WeightedGraph {
    private int V; // 顶点数
    private Double[][] adjacencyMatrix; // 邻接矩阵

    // 构造函数
    public WeightedGraph(int V) {
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

    // 测试程序
    public static void main(String[] args) {
        WeightedGraph1 graph = new WeightedGraph1 (5);
        graph.addEdge(0, 1, 2.5);
        graph.addEdge(0, 3, 1.2);
        graph.addEdge(1, 2, 3.8);
        graph.addEdge(2, 3, 2.2);
        graph.addEdge(3, 4, 4.0);

        // 获取并打印邻接矩阵
        Double[][] adjacencyMatrix = graph.getAdjacentMatrix();
        System.out.println("邻接矩阵：");
        graph.printAdjacencyMatrix();
    }
}