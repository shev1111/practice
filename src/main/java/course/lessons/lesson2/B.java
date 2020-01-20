package course.lessons.lesson2;

import java.util.Objects;

public final class B {

    private final String description;
    private final A a;

    public B(String description, A a) {
        this.description = description;
        this.a = copyA(a);
    }

    private A copyA(A a) {
        return (Objects.isNull(a)) ? null : new A(a.getAnInt());
    }

    public String getDescription() {
        return description;
    }

    public A getA() {
        return copyA(a);
    }

    @Override
    public String toString() {
        return "B{" +
                "description='" + description + '\'' +
                ", a=" + a +
                '}';
    }
}
