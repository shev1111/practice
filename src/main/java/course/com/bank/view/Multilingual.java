package course.com.bank.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class Multilingual {
    private static ResourceBundle resource;
    private static Locale UKRAINE;
    static {
        resource = ResourceBundle.getBundle("messages_eng");
        UKRAINE = new Locale("ua","UA");
    }
    public static ResourceBundle getResource() {
        return resource;
    }

    public enum Language {
        UA, ENG
    }

    public static void switchLanguage(Language language) {
        switch (language) {
            case UA:
                resource = ResourceBundle.getBundle("messages_ua", UKRAINE, new UTF8Control());
                break;
            case ENG:
                resource = ResourceBundle.getBundle("messages_eng");
                break;
        }

    }
}
