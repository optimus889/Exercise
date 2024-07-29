package class04;

//有一堆石头，每块石头的重量都是正整数。
//
//每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
//
//如果 x == y，那么两块石头都会被完全粉碎；
//如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
//最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
import java.util.PriorityQueue;
import java.util.Collections;

public class PriorityQueueDemo {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);
        }
            while (maxHeap.size() > 1) {
                int y = maxHeap.poll();
                int x = maxHeap.poll();

                if (x != y) {
                    maxHeap.add(y - x);
                }
            }
                return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        PriorityQueueDemo solution = new PriorityQueueDemo();
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println("Last remaining stone weight: " + solution.lastStoneWeight(stones));
    }
}
