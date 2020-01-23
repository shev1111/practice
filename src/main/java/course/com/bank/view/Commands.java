package course.com.bank.view;

public interface Commands {

    String UA = "-ua";
    String ENG = "-eng";
    String CMD_FIND_ALL_USERS = "-find_all_users (\\d{1,3})";
    String CMD_FIND_BY_ID = "-find_by_id (\\d{1,3})";
    String CMD_FIND_BY_EMAIL = "-find_by_email ";
    String CMD_QUIT = "-quit";
}
