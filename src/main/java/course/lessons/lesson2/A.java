package course.lessons.lesson2;

public class A {
    int anInt;

    public A(int anInt) {
        this.anInt = anInt;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public String toString() {
        return "A{" +
                "anInt=" + anInt +
                '}';
    }
}
