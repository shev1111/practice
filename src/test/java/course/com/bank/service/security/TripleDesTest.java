package course.com.bank.service.security;

import org.junit.Test;
import org.junit.BeforeClass;
import course.com.bank.exeception.DecryptionException;
import course.com.bank.exeception.EncryptionException;


import static org.junit.Assert.*;

public class TripleDesTest {
    private static TripleDes tripleDes;
    private static String password = "password";

    @BeforeClass
    public static void init() throws EncryptionException {
        tripleDes = new TripleDes();
    }

    @Test
    public void encryptDecryptTest() throws EncryptionException, DecryptionException {
        System.out.println(tripleDes.encrypt(password));
        assertEquals(password, tripleDes.decrypt(tripleDes.encrypt(password)));
    }

}