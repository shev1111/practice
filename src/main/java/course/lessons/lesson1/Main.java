package course.lessons.lesson1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        final A a = new A();
        final Class<A> aClass = A.class;
        final Constructor<A> constructor = aClass.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        final A a = constructor.newInstance(1);
        Method method = aClass.getDeclaredMethod("method");
        //a.method();
        method.setAccessible(true);
        Object invoke = method.invoke(a);
        Method method1 = aClass.getDeclaredMethod("staticmethod");
        method1.setAccessible(true);
        Object invoke1 = method1.invoke(a);
        //A.staticmethod();
    }

}

class A {
    int i;
    /*private A() {

    }*/

    private A(int i) {
        this.i = i;
    }

    private void method(){
        System.out.println("Non static method");
    }

    private static void staticmethod(){
        System.out.println("Static method");
    }
}
