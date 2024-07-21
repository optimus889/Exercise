package class01;

import java.util.HashSet;
import java.util.Set;

//学生投票系统
public class Exercise03 {
    private static final int max = 10;
    private static int count;
    private static Set<Exercise03>voters = new HashSet<Exercise03>();
    private String name;
    private String answer;

    public Exercise03(String name){
        this.name = name;
    }

    public void vote(String answer){
        if (count == max){
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
        for (Exercise03 voter: voters){
            System.out.println(voter.name+"意见"+voter.answer);
        }
    }

    public static void main(String[] args) {
        Exercise03 Tom = new Exercise03("Tom");
        Exercise03 Jack = new Exercise03("Jack");
        Exercise03 Mike = new Exercise03("Mike");

        Tom.vote("yes");
        Tom.vote("no");
        Jack.vote("yes");
        Mike.vote("no");

        printVoterResult();
    }
}
