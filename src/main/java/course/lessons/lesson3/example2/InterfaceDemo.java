package course.lessons.lesson3.example2;

public class InterfaceDemo {
    public static void main(String[] args) {

        MyInterface myInterface = new MyInterface() {
            @Override
            public void method() {
                System.out.println("anonymous");
            }
        };
        myInterface.method();

        MyInterface lambda = ()-> System.out.println("anonymous");

        OneParameterInterface<String> oneParameterInterface = message -> System.out.println(message.isEmpty());

        TwoParameterIntrface twoParameterIntrface = (message, n) -> {
            for (int i = 0; i <n ; i++) {
                System.out.println(message);
            }
        };
    }
}
