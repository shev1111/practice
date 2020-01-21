package course.lessons.task2;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciNumberTest {
    @Test
    public void findWithNoRecursionTest() {
        int actual = FibonacciNumber.findWithNoRecursion(9);
        assertEquals(34, actual);

    }

    @Test
    public void findWithRecursionTest() throws Exception {
        int actual = FibonacciNumber.findWithRecursion(9);
        assertEquals(34, actual);
    }

}