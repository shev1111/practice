package course.lessons.lesson3.example2;

public class MayInterfaceImpl implements MyInterface {

    @Override
    public void method() {

    }
}
class Main{
    public static void main(String[] args) {
        MyInterface myInterface = new MayInterfaceImpl();
        myInterface.method();
    }
}
