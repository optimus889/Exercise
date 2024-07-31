package class06;

import java.util.*;

// 定义图的边类

// 定义图类
class BFSGraph {
    private final int vertices; // 图的顶点数
    private final LinkedList<Integer>[] adjacencyList; // 邻接表

    // 构造函数
    public BFSGraph(int vertices) {
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

    // 广度优先遍历的方法
    public void BFS(int startVertex) {
        // 创建一个布尔数组来标记顶点是否被访问过
        boolean[] visited = new boolean[vertices];

        // 创建一个队列来进行BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // 标记起始顶点为已访问并入队
        visited[startVertex] = true;
        //
        queue.add(startVertex);

        while (queue.size() != 0) {
            // 从队列中取出一个顶点
            startVertex = queue.poll();
            System.out.print(startVertex + " ");

            // 获取所有相邻顶点，如果未被访问过则标记为已访问并入队
            for (int adjacent : adjacencyList[startVertex]) {
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    queue.add(adjacent);
                }
            }
        }

    }

    public static void main(String[] args) {
        // 创建一个图对象，包含4个顶点
        BFSGraph graph = new BFSGraph(4);

        // 添加边到图中
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        // 从顶点2开始进行广度优先遍历
        System.out.println("从顶点2开始进行广度优先遍历：");
        graph.BFS(2);
    }
}
