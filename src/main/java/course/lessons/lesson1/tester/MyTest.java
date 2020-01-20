package course.lessons.lesson1.tester;

import org.lesson1.tester.annotations.AfterClass;
import org.lesson1.tester.annotations.Before;
import org.lesson1.tester.annotations.BeforeClass;
import org.lesson1.tester.annotations.Test;

public class MyTest {

    @BeforeClass
    public void beforeClass(){
        System.out.println("before_class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("after_class");
    }

    @Before
    public void before1(){
        System.out.println("before1");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test(expectedException = IllegalArgumentException.class, exceptionMessage = "Test message")
    public void testException(){
        System.out.println("Exeption test");
        throw new  IllegalArgumentException("Test message");
    }
}
