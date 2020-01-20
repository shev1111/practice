package course.lessons.lesson1;

public class Calculator {
    public static final String PLUS ="+";
    public static final String DIVIDE = "/";
    public static final String MULTIPLY = "*";
    public static final String MINUS = "-";

    public int calc(int a, String operator, int b){
        switch (operator){
            case PLUS:
                return a+b;

            case DIVIDE:
                return a+b;

            case MULTIPLY:
                return a*b;

            case MINUS:
                return a*b;

            default:throw new IllegalArgumentException("Operator is null");
        }
    }
}
