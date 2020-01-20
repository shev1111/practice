package course.lessons.lesson1.tester;

import org.lesson1.tester.annotations.AfterClass;
import org.lesson1.tester.annotations.Before;
import org.lesson1.tester.annotations.BeforeClass;
import org.lesson1.tester.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class TestRunner {
    void run(Class<?> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> constructor = clazz.getConstructor();
        Object object = constructor.newInstance();
        Method[] methods = clazz.getDeclaredMethods();

        List<Method> testMethods = getMethodByAnnotation(Test.class, methods);
        List<Method> beforeMethods = getMethodByAnnotation(Before.class, methods);
        List<Method> beforeClassMethods = getMethodByAnnotation(BeforeClass.class, methods);
        List<Method> afterClassMethods = getMethodByAnnotation(AfterClass.class, methods);

        invokeMethods(object, beforeClassMethods);

        for (Method testMethod:testMethods) {

            invokeMethods(object, beforeMethods);

            runTestMethods(object, testMethod);
        }

        invokeMethods(object, afterClassMethods);
    }

    private void runTestMethods(Object object, Method testMethod) {
        Test testAnnotation = testMethod.getAnnotation(Test.class);
        Class<? extends Throwable> expectedException = testAnnotation.expectedException();
        String exceptionMessage = testAnnotation.exceptionMessage();

        try {
            testMethod.invoke(object);
        } catch (Exception e) {
            if(e.getCause().getClass().isAssignableFrom(expectedException)) System.out.println("Exception type passed test");
            if(e.getCause().toString().contains(exceptionMessage)) System.out.println("Exception message passed test");
        }
    }

    private void invokeMethods(Object object, List<Method> methods) throws IllegalAccessException, InvocationTargetException {
        for (Method method:methods) {
            method.invoke(object);
        }
    }

    private List<Method> getMethodByAnnotation(Class<? extends Annotation> annotation, Method[] methods) {
        List<Method> tempMethods = new ArrayList<>();
        for (Method method:methods) {
            if(method.isAnnotationPresent(annotation)){
                tempMethods.add(method);
            }
        }
            return tempMethods;
    }
}
