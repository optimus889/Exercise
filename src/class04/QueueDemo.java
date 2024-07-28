package class04;

//        牌组中的每张卡牌都对应有一个唯一的整数。你可以按你想要的顺序对这套卡片进行排序。
//
//        最初，这些卡牌在牌组里是正面朝下的（即，未显示状态）。
//
//        现在，重复执行以下步骤，直到显示所有卡牌为止：
//
//        从牌组顶部抽一张牌，显示它，然后将其从牌组中移出。
//        如果牌组中仍有牌，则将下一张处于牌组顶部的牌放在牌组的底部。
//        如果仍有未显示的牌，那么返回步骤 1。否则，停止行动。

//        返回能以递增顺序显示卡牌的牌组顺序。
//
//        答案中的第一张牌被认为处于牌堆顶部。

//          {17, 13, 11, 2, 3, 5, 7}          {2, 13, 3, 11, 5, 17, 7}


import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class QueueDemo {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        for (int i : deck) {
            System.out.print(i + " ");
        }

        Queue<Integer> indexQueue = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            indexQueue.offer(i);
        }

        for (int i : indexQueue) {
            System.out.print(i + " ");
        }

        int[] result = new int[deck.length];

        for (int card : deck) {
            result[indexQueue.poll()] = card;
            if (!indexQueue.isEmpty()) {
                indexQueue.offer(indexQueue.poll());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 测试用例
        test(new int[]{17, 13, 11, 2, 3, 5, 7}, new int[]{2, 13, 3, 11, 5, 17, 7});
        test(new int[]{1, 1000}, new int[]{1, 1000});
        test(new int[]{1, 6, 2, 10, 3, 7, 4, 8, 5, 9}, new int[]{1, 6, 2, 10, 3, 7, 4, 9, 5, 8});
    }

    private static void test(int[] input, int[] expected) {
        QueueDemo solution = new QueueDemo();
        int[] result = solution.deckRevealedIncreasing(input);
        if (Arrays.equals(result, expected)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail: Expected " + Arrays.toString(expected) + ", but got " + Arrays.toString(result));
        }
    }
}
