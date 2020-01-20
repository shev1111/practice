package course.lessons.lesson2;

public class Main {
    public static void main(String[] args) {
        A a = new A (100);
        final B b  = new B("Desc", a);

        System.out.println(b);

        a.setAnInt(200);

        System.out.println(b);

        final A a1 = b.getA();
        a1.setAnInt(300);
    }
}
