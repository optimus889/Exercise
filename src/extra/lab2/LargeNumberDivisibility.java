package extra.lab2;
/*
Write a function that prints the first 10 numbers with 50 decimal digits that are divisible by 2 or 3
*/
import java.math.BigInteger;

public class LargeNumberDivisibility {
    public static void main(String[] args) {
        BigInteger start = new BigInteger("1" + "0".repeat(49));
        int count = 0;

        while (count < 10) {
            if (start.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO) ||
                    start.mod(BigInteger.valueOf(3)).equals(BigInteger.ZERO)) {
                System.out.println(start);
                count++;
            }
            start = start.add(BigInteger.ONE);
        }
    }
}
