package course.com.bank.service.security;

import course.com.bank.exeception.DecryptionException;
import course.com.bank.exeception.EncryptionException;

public interface Encryption {
    String encrypt(String password) throws EncryptionException;

    String decrypt(String encryptedPassword) throws DecryptionException;
}
