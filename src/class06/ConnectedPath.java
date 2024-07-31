package class06;

import java.util.*;


// 定义图类
class ConnectedPathGraph {
    private final int vertices; // 图的顶点数
    private final LinkedList<Integer>[] adjacencyList; // 邻接表

    // 构造函数
    public ConnectedPathGraph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // 添加边的方法
    public void addEdge(int from, int to) {
        adjacencyList[from].add(to);
        adjacencyList[to].add(from); // 无向图需要添加双向边
    }

    // 深度优先遍历的递归方法
    private void DFSUtil(int vertex, boolean[] visited) {
        // 标记当前顶点为已访问
        visited[vertex] = true;

        // 递归访问所有相邻顶点
        for (int adjacent : adjacencyList[vertex]) {
            if (!visited[adjacent]) {
                DFSUtil(adjacent, visited);
            }
        }
    }

    // 计算连通分量数量的方法
    public int countConnectedComponents() {
        // 创建一个布尔数组来标记顶点是否被访问过
        boolean[] visited = new boolean[vertices];
        int count = 0;

        // 遍历所有顶点
        for (int i = 0; i < vertices; i++) {
            // 如果顶点未被访问，则从该顶点开始进行DFS，并增加连通分量计数
            if (!visited[i]) {
                DFSUtil(i, visited);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 创建一个图对象，包含6个顶点
        ConnectedPathGraph graph = new ConnectedPathGraph(6);

        // 添加边到图中
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        // 计算并打印连通分量数量
        int connectedComponents = graph.countConnectedComponents();
        System.out.println("图的连通分量数量：" + connectedComponents);
    }
}
