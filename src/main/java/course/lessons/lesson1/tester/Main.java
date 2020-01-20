package course.lessons.lesson1.tester;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        TestRunner runner = new TestRunner();
        runner.run(MyTest.class);
    }
}
