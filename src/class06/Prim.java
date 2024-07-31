package class06;

import java.util.*;

// 定义边类
class PrimEdge implements Comparable<PrimEdge> {
    int from; // 边的起点
    int to;   // 边的终点
    int weight; // 边的权重

    // 构造函数
    public PrimEdge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    // 比较边的权重，用于优先队列
    @Override
    public int compareTo(PrimEdge other) {
        return this.weight - other.weight;
    }
}

// 定义图类
class PrimGraph {
    private final int vertices; // 图的顶点数
    private final List<List<PrimEdge>> adjacencyList; // 邻接表

    // 构造函数
    public PrimGraph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new LinkedList<>());
        }
    }

    // 添加边的方法
    public void addEdge(int from, int to, int weight) {
        adjacencyList.get(from).add(new PrimEdge(from, to, weight));
        adjacencyList.get(to).add(new PrimEdge(to, from, weight)); // 无向图需要添加双向边
    }

    // 普里姆算法
    public void primMST() {
        // 创建一个布尔数组来标记顶点是否被包含在最小生成树中
        boolean[] inMST = new boolean[vertices];

        // 使用优先队列来存储边，按权重从小到大排序
        PriorityQueue<PrimEdge> pq = new PriorityQueue<>();

        // 从第一个顶点开始，添加所有相邻的边到优先队列
        inMST[0] = true;
        for (PrimEdge edge : adjacencyList.get(0)) {
            pq.add(edge);
        }

        // 存储最小生成树的边
        List<PrimEdge> mst = new ArrayList<>();

        while (!pq.isEmpty()) {
            // 取出权重最小的边
            PrimEdge edge = pq.poll();

            // 如果边的终点已包含在最小生成树中，则跳过
            if (inMST[edge.to]) {
                continue;
            }

            // 将边添加到最小生成树
            mst.add(edge);
            inMST[edge.to] = true;

            // 添加新的顶点连接的所有边到优先队列
            for (PrimEdge nextEdge : adjacencyList.get(edge.to)) {
                if (!inMST[nextEdge.to]) {
                    pq.add(nextEdge);
                }
            }
        }

        // 打印最小生成树
        System.out.println("最小生成树的边:");
        for (PrimEdge e : mst) {
            System.out.println(e.from + " -- " + e.to + " == " + e.weight);
        }
    }

    public static void main(String[] args) {
        // 创建一个图对象，包含5个顶点
        PrimGraph graph = new PrimGraph(5);

        // 添加边到图中
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        // 运行普里姆算法并输出最小生成树
        graph.primMST();
    }
}
