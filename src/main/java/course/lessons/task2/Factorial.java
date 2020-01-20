package course.lessons.task2;

import java.math.BigInteger;
import java.util.logging.SocketHandler;

public class Factorial {
    static BigInteger calculate (String number){
        BigInteger bigIntegerNumber = new BigInteger(number);
        BigInteger factorial = BigInteger.ONE;

        for (BigInteger index = BigInteger.valueOf(1);
             index.compareTo(bigIntegerNumber) <= 0;
             index = index.add(BigInteger.ONE))
        {
            factorial = factorial.multiply(index);
        }

        return factorial;
    }
}
