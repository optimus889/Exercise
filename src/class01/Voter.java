package class01;

import java.util.HashSet;
import java.util.Set;

//学生投票系统
public class Voter {
    private static final int MAX_COUNT = 100;
    private static int count;
    private static final Set<Voter>voters = new HashSet<>();
    private final String name;
    private String answer;

    public Voter(String name){
        this.name = name;
    }

    public void vote(String answer){
        if (count == MAX_COUNT){
            System.out.println("投票结束。");
        }
        if (voters.contains(this)){
            System.out.println("请勿重复投票。");
        }else {
            this.answer = answer;
            count++;
            voters.add(this);
            System.out.println("感谢你的投票。");
        }
    }

    public static void printVoterResult(){
        System.out.println("投票学生人数："+ count);
        System.out.println("投票结果：");
        for (Voter voter: voters){
            System.out.println(voter.name+"意见"+voter.answer);
        }
    }

    public static void main(String[] args) {
        Voter Tom = new Voter("Tom");
        Voter Jack = new Voter("Jack");
        Voter Mike = new Voter("Mike");

        Tom.vote("yes");
        Tom.vote("no");
        Jack.vote("yes");
        Mike.vote("no");

        printVoterResult();
    }
}
