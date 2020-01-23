package course.lessons.lesson4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Calculator {
    private static final Map<String, BiFunction<Integer,Integer,Integer>> operatorToOperation = new HashMap<>();

    static {
        operatorToOperation.put("+", Integer::sum);
        operatorToOperation.put("-", (a,b) -> a-b);
    }

    public int calculate(int a, String operator, int b){

        return operatorToOperation.get("+").apply(a,b);
    }
}