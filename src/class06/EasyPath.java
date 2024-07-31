package class06;

import java.util.*;

// 定义图的边类


// 定义图类
class EasyPathGraph {
    private final int vertices; // 图的顶点数
    private final LinkedList<Integer>[] adjacencyList; // 邻接表

    // 构造函数
    public EasyPathGraph(int vertices) {
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

    // 输出两个顶点之间的所有简单路径的方法
    public void printAllPaths(int startVertex, int endVertex) {
        // 创建一个布尔数组来标记顶点是否被访问过
        boolean[] visited = new boolean[vertices];

        // 存储当前路径
        ArrayList<Integer> path = new ArrayList<>();

        // 调用递归的辅助方法来找到所有路径
        printAllPathsUtil(startVertex, endVertex, visited, path);
    }

    // 递归的辅助方法，用于找到所有路径
    private void printAllPathsUtil(Integer u, Integer d, boolean[] visited, List<Integer> localPathList) {
        // 标记当前顶点为已访问
        visited[u] = true;

        // 将当前顶点添加到路径
        localPathList.add(u);

        // 如果当前顶点是目标顶点，打印路径
        if (u.equals(d)) {
            System.out.println(localPathList);
        } else {
            // 如果当前顶点不是目标顶点，递归访问所有相邻顶点
            for (Integer i : adjacencyList[u]) {
                if (!visited[i]) {
                    printAllPathsUtil(i, d, visited, localPathList);
                }
            }
        }

        // 移除当前顶点并将其标记为未访问，以便下一个路径使用
        localPathList.remove(u);
        visited[u] = false;
    }

    public static void main(String[] args) {
        // 创建一个图对象，包含5个顶点
        EasyPathGraph graph = new EasyPathGraph(5);

        // 添加边到图中
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);

        // 输出从顶点0到顶点4的所有简单路径
        System.out.println("从顶点0到顶点4的所有简单路径：");
        graph.printAllPaths(0, 4);
    }
}

