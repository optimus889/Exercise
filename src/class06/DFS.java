package class06;

import java.util.*;


// 定义图类
class Graph {
    private final int vertices; // 图的顶点数
    private final LinkedList<Integer>[] adjacencyList; // 邻接表

    // 构造函数
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // 添加边的方法
    public void addEdge(int from, int to) {
        adjacencyList[from].add(to);
    }

    // 深度优先遍历的递归方法
    private void DFSUtil(int vertex, boolean[] visited) {
        // 标记当前顶点为已访问
        visited[vertex] = true;
        System.out.print(vertex + " ");

        // 递归访问所有相邻顶点
        for (int adjacent : adjacencyList[vertex]) {
//            if (!visited[adjacent]) {
            if (!visited[adjacent]) {
                DFSUtil(adjacent, visited);
            }
        }
    }

    // 深度优先遍历的方法
    public void DFS(int startVertex) {
        // 创建一个布尔数组来标记顶点是否被访问过
        boolean[] visited = new boolean[vertices];

        // 从指定的顶点开始进行DFS
        DFSUtil(startVertex, visited);
    }

    public static void main(String[] args) {
        // 创建一个图对象，包含4个顶点
        Graph graph = new Graph(4);

        // 添加边到图中
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        // 从顶点2开始进行深度优先遍历
        System.out.println("从顶点2开始进行深度优先遍历：");
        graph.DFS(2);
    }
}

