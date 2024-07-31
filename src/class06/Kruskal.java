package class06;

import java.util.*;

// 定义边类
class KruskalEdge implements Comparable<KruskalEdge> {
    int from; // 边的起点
    int to;   // 边的终点
    int weight; // 边的权重

    // 构造函数
    public KruskalEdge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    // 比较边的权重，用于排序
    @Override
    public int compareTo(KruskalEdge other) {
        return this.weight - other.weight;
    }
}

// 定义图类
class KruskalGraph {
    private final int vertices; // 图的顶点数
    private final List<KruskalEdge> edges; // 图的边列表

    // 构造函数
    public KruskalGraph(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    // 添加边的方法
    public void addEdge(int from, int to, int weight) {
        edges.add(new KruskalEdge(from, to, weight));
    }

    // 查找顶点的根节点
    private int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    // 联合两个子集
    private void union(int[] parent, int[] rank, int root1, int root2) {
        if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }
    }

    // 克鲁斯卡尔算法
    public void kruskalMST() {
        // 存储最小生成树的边
        List<KruskalEdge> result = new ArrayList<>();

        // 对所有边按权重从小到大排序
        Collections.sort(edges);

        // 创建并初始化父节点和秩数组
        int[] parent = new int[vertices];
        int[] rank = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // 处理边，直到树包含所有顶点
        for (KruskalEdge edge : edges) {
            int root1 = find(parent, edge.from);
            int root2 = find(parent, edge.to);

            // 如果边的两个顶点不形成环，则将边添加到结果中
            if (root1 != root2) {
                result.add(edge);
                union(parent, rank, root1, root2);
            }
        }

        // 打印最小生成树
        System.out.println("最小生成树的边:");
        for (KruskalEdge edge : result) {
            System.out.println(edge.from + " -- " + edge.to + " == " + edge.weight);
        }
    }

    public static void main(String[] args) {
        // 创建一个图对象，包含6个顶点
        KruskalGraph graph = new KruskalGraph(6);

        // 添加边到图中
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 0, 4);
        graph.addEdge(2, 0, 4);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 3);
        graph.addEdge(2, 5, 2);
        graph.addEdge(2, 4, 4);
        graph.addEdge(3, 2, 3);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 2, 4);
        graph.addEdge(4, 3, 3);
        graph.addEdge(5, 2, 2);
        graph.addEdge(5, 4, 3);

        // 运行克鲁斯卡尔算法并输出最小生成树
        graph.kruskalMST();
    }
}

