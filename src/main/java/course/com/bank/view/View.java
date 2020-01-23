package course.com.bank.view;

import java.util.Collection;

public class View {
    public static final String SELECT_LANGUAGE = "Select language \\ Оберіть мову:\n" +
            "Enter '-eng' or '-ua' \\ Введіть '-eng' чи '-ua'\n";
    public static final String SEPARATOR =    "=============================\n";


    public void print(String msg) {
        System.out.print(msg);
    }

    public void println(String msg) {
        System.out.println(msg);
    }

    public void printErr(String msg){
        System.err.println(msg);
    }

    public void printCollection(Collection<?> c) {
        for (Object o : c) {
            System.out.println(o);
        }
    }

}
