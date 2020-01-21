package course.lessons.task2;

import org.junit.Test;
import java.math.BigInteger;
import static org.junit.Assert.assertEquals;

public class FactorialTest {

    @Test
    public void calculateFactorialTest() {
        BigInteger factorial = Factorial.calculate("6");
        assertEquals(new BigInteger("720"), factorial);
    }

}