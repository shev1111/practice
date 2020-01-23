package course.com.bank.service.security;

import org.junit.Test;
import course.com.bank.exeception.EncryptionException;

import static org.junit.Assert.*;

public class TripleDesTest {
    private static final TripleDes tripleDes = new TripleDes();
    private static final String PASSWORD = "password@01A";
    private static final String ENCRYPTED_PASSWORD = "y7c8avhnFMIAl+63EyHP+Q==";


    @Test
    public void encryptTest() throws EncryptionException {
        System.out.println(tripleDes.encrypt(PASSWORD));
        assertEquals(ENCRYPTED_PASSWORD, tripleDes.encrypt(PASSWORD));
    }

}