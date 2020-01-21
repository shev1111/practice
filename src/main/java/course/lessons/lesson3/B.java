package course.lessons.lesson3;

public class B {
    private static void validate(){
        try {
            throw new RuntimeException("try");
        }finally {
            throw new RuntimeException("finally");
        }
    }
}
