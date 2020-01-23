package course.com.bank.service.security;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import course.com.bank.exeception.EncryptionException;
import org.apache.commons.codec.binary.Base64;
public class TripleDes implements Encryption {

    private static final String DES_EDE_ENCRYPTION_SCHEME = "DESede";
    private static final String ENCRYPTION_KEY = "AStcRwAAACA3RitUARQp9QQ8EaTfUgK/bqBboma7WYl2VmdNMoFKtQ";
    private Cipher cipher;
    private SecretKey key;

    public TripleDes() {
        try {
            byte[] arrayBytes = ENCRYPTION_KEY.getBytes(StandardCharsets.UTF_8);
            KeySpec keySpec = new DESedeKeySpec(arrayBytes);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES_EDE_ENCRYPTION_SCHEME);
            cipher = Cipher.getInstance(DES_EDE_ENCRYPTION_SCHEME);
            key = keyFactory.generateSecret(keySpec);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeySpecException e) {
            throw new EncryptionException(e.getMessage());
        }
    }

    @Override
    public String encrypt(String password) throws EncryptionException {
        String encryptedString;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = password.getBytes(StandardCharsets.UTF_8);
            byte[] encryptedText = cipher.doFinal(plainText);
            encryptedString = new String(Base64.encodeBase64(encryptedText));
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            throw new EncryptionException(e.getMessage());
        }
        return encryptedString;
    }

}
