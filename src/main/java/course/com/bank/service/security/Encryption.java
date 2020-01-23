package course.com.bank.service.security;

import course.com.bank.exeception.EncryptionException;

public interface Encryption {
    String encrypt(String password) throws EncryptionException;
}
