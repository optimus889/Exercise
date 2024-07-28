package class04;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 这个类代表一个连接的管道网络。
 * <p>
 * 每个管道都有一个唯一的ID（一个整数），由添加管道到网络的顺序定义；也就是说，第一根管道添加的ID为0，下一根为1，以此类推。移除管道不会改变下一个被添加的管道的ID。
 * <p>
 * 连接是有方向性的：每个管道可以有0到3个进入的连接，和0到3个输出的连接。
 * <p>
 * 新管道添加到网络中时，带有一个进入或输出连接。这是添加连接到网络的唯一方式。（注意因此，网络中将永远不包含循环。）
 * <p>
 * 第一级：完成下面的所有类方法。你必须在这个java文件中完成你的实现。但是，如果这对你的解决方案有帮助，你可以（实际上也鼓励你）在这个类中定义嵌套类。
 * <p>
 * 第二级：实现 addFrom、addTo、remove 和 nSources 方法。
 */
public class HashDemo{

    private static class Pipe{
        int id;
        Set<Integer> incoming = new HashSet<>();
        Set<Integer> outgoing = new HashSet<>();

        Pipe(int id){
            this.id = id;
        }
    }

    private int nextId = 0;
    private Map<Integer, Pipe> pipes = new HashMap<>();
    private Set<Integer> removePipes = new HashSet<>();

    public HashDemo() {
    }
    /**
     * 添加一个管道到网络中。新管道没有任何连接。
     * 该方法应返回新管道的ID。
     */
    public int add() {
        Pipe newPipe = new Pipe(nextId);
        pipes.put(nextId, newPipe);
        return nextId++;
    }
    /**
     * 添加一个管道到网络中，并从网络中已存在的管道处获得一个进入的连接，如果这不违反任何网络规则的话：
     * - 管道 fromPipeId 必须是网络中已存在的（之前添加过且未被移除）；
     * - 管道 fromPipeId 最多只能有2个已存在的输出连接。
     * <p>
     * 如果添加新管道会违反这些规则，则方法不应添加管道，并返回 -1。否则，方法应更新网络并返回新管道的ID。
     */
    public int addFrom(int fromPipeId) {
        if(pipes.containsKey(fromPipeId)&&removePipes.contains(fromPipeId)) {
            return -1;
        }
        Pipe fromPipe = pipes.get(fromPipeId);
        if(fromPipe.outgoing.size() >= 2) {
            return -1;
        }
        Pipe newPipe = new Pipe(nextId);
        newPipe.incoming.add(fromPipeId);
        newPipe.outgoing.add(nextId);
        pipes.put(nextId, newPipe);
        return nextId++;
    }
    /**
     * 添加一个管道到网络中，并向网络中已存在的管道处设置一个输出连接，如果这不违反任何网络规则的话：
     * - 管道 toPipeId 必须是网络中已存在的（之前添加过且未被移除）；
     * - 管道 toPipeId 最多只能有2个已存在的进入连接。
     * <p>
     * 如果添加新管道会违反这些规则，则方法不应添加管道，并返回 -1。否则，方法应更新网络并返回新管道的ID。
     */
    public int addTo(int toPipeId) {
        if(!pipes.containsKey(toPipeId)&&removePipes.add(toPipeId)) {
        return -1;
        }
        Pipe toPipe = pipes.get(toPipeId);
        if(toPipe.incoming.size() >= 2) {
            return -1;
        }
        Pipe newPipe = new Pipe(nextId);
        newPipe.outgoing.add(toPipeId);
        newPipe.incoming.add(nextId);
        pipes.put(nextId, newPipe);
        return nextId++;
    }
    /**
     * 从网络中移除一个管道。这也会移除所有到该管道和从该管道出发的连接（但不会移除它所连接的管道）。
     * <p>
     * 如果管道ID在网络中不存在（未被添加或已被移除），则方法不应执行任何操作。
     */
    public void remove(int pipeId) {
        if(!pipes.containsKey(pipeId)||removePipes.add(pipeId)) {
            return;
        }
        Pipe pipe = pipes.get(pipeId);
        for(int incomingId : pipe.incoming) {
            pipes.get(incomingId).outgoing.remove(pipeId);
        }
        for(int outgoingId : pipe.outgoing) {
            pipes.get(outgoingId).incoming.remove(pipeId);
        }
        removePipes.add(pipeId);
        pipes.remove(pipeId);
    }
    /**
     * 返回网络中源的数量。
     * <p>
     * 源是指没有进入连接的管道。
     */
    public int nSources() {
        int count = 0;
        for(Pipe pipe : pipes.values()) {
            if(pipe.incoming.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 创建一个测试实例
        SourcesTest testInstance = new SourcesTest();

        // 执行测试方法
        testInstance.testAdd();
        testInstance.testAddFrom();
        testInstance.testAddTo();
        testInstance.testRemove();
        testInstance.testSources();
    }
}

class SourcesTest {

    public void testAdd() {
        HashDemo n = new HashDemo();
        int id = n.add();
        assertEqual(0, id, "testAdd: id of first pipe added != 0");
        id = n.addFrom(0);
        assertEqual(1, id, "testAdd: id of second pipe added != 1");
        id = n.addTo(0);
        assertEqual(2, id, "testAdd: id of third pipe added != 2");
    }

    public void testAddFrom() {
        HashDemo n = new HashDemo();
        int id = n.add();
        assertEqual(0, id, "testAdd: id of first pipe added != 0");
        id = n.addFrom(0);
        assertEqual(1, id, "testAdd: id of second pipe added != 1");
        id = n.addFrom(0);
        assertEqual(2, id, "testAdd: id of third pipe added != 2");
        id = n.addFrom(0);
        assertEqual(3, id, "testAdd: id of fourth pipe added != 3");
        // can't add a fourth outgoing pipe from 0
        id = n.addFrom(0);
        assertEqual(-1, id, "testAdd: invalid addFrom != -1");
    }

    public void testAddTo() {
       HashDemo n = new HashDemo();
        int id = n.add();
        assertEqual(0, id, "testAdd: id of first pipe added != 0");
        id = n.addTo(0);
        assertEqual(1, id, "testAdd: id of second pipe added != 1");
        id = n.addTo(0);
        assertEqual(2, id, "testAdd: id of third pipe added != 2");
        id = n.addTo(0);
        assertEqual(3, id, "testAdd: id of fourth pipe added != 3");
        // can't add a fourth incoming pipe to 0
        id = n.addTo(0);
        assertEqual(-1, id, "testAdd: invalid addTo != -1");
    }

    public void testRemove() {
        HashDemo n = new HashDemo();
        int id = n.add();
        assertEqual(0, id, "testRemove: id of first pipe added != 0");
        id = n.addFrom(0);
        assertEqual(1, id, "testRemove: id of second pipe added != 1");
        id = n.addTo(0);
        assertEqual(2, id, "testRemove: id of third pipe added != 2");
        n.remove(0);
        id = n.addFrom(0);
        assertEqual(-1, id, "testRemove: addFrom with invalid arg != -1");
        id = n.addTo(0);
        assertEqual(-1, id, "testRemove: addTo with invalid arg != -1");
        id = n.addFrom(1);
        assertEqual(3, id, "testRemove: id of fourth pipe added != 3");
        id = n.addTo(2);
        assertEqual(4, id, "testRemove: id of fifth pipe added != 4");
    }

    public void testSources() {
        testCounts1(3);
        testCounts2(3);
    }

    static int intPow(int a, int b) {
        int r = 1;
        while (b > 0) {
            r = r * a;
            b -= 1;
        }
        return r;
    }

    static void testCounts1(int k) {
        int n2 = intPow(2, k - 1);
        HashDemo n = new HashDemo();
        int id = n.add();
        for (int i = 0; i < n2 - 1; i++) {
            n.addFrom(i);
            n.addFrom(i);
        }
        assertEqual(1, n.nSources(), "incorrect number of sources");
        for (int i = 0; i < n2 - 1; i++) {
            n.remove(i);
            assertEqual(2 + i, n.nSources(), "incorrect number of sources");
        }
    }

    static void testCounts2(int k) {
        int n2 = intPow(2, k - 1);
        HashDemo n = new HashDemo();
        int id = n.add();
        for (int i = 0; i < n2 - 1; i++) {
            n.addTo(i);
            n.addTo(i);
        }
        assertEqual(n2, n.nSources(), "incorrect number of sources");
    }

    // 模拟 assertEquals 方法
    private static void assertEqual(int expected, int actual, String message) {
        if (expected != actual) {
            System.out.println("Fail: " + message + " Expected " + expected + ", but got " + actual);
        } else {
            System.out.println("Pass: " + message);
        }
    }
}