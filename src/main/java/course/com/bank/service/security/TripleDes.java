package course.com.bank.service.security;


import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import course.com.bank.exeception.DecryptionException;
import course.com.bank.exeception.EncryptionException;
import org.apache.commons.codec.binary.Base64;

public class TripleDes implements Encryption {

    private static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private Cipher cipher;
    private SecretKey key;

    public TripleDes() {
        String myEncryptionKey = "lladscuschcrbojvbcvjccIGcIKHccGIcDWSGsaclndsj";
        try {
           byte[] arrayBytes = myEncryptionKey.getBytes(StandardCharsets.UTF_8);
            KeySpec keySpec = new DESedeKeySpec(arrayBytes);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DESEDE_ENCRYPTION_SCHEME);
            cipher = Cipher.getInstance(DESEDE_ENCRYPTION_SCHEME);
            key = keyFactory.generateSecret(keySpec);
        } catch (
                InvalidKeyException |
                NoSuchAlgorithmException | NoSuchPaddingException |
                InvalidKeySpecException e) {
            e.printStackTrace();
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
        } catch (InvalidKeyException |
                IllegalBlockSizeException |
                BadPaddingException e) {
            throw new EncryptionException(e.getMessage());
        }

        return encryptedString;
    }

    @Override
    public String decrypt(String encryptedPassword) throws DecryptionException {
        String decryptedText;

        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.decodeBase64(encryptedPassword);
            byte[] plainText = cipher.doFinal(encryptedText);
            decryptedText= new String(plainText);
        } catch (InvalidKeyException |
                IllegalBlockSizeException |
                BadPaddingException e) {
            throw new DecryptionException(e.getMessage());
        }

        return decryptedText;
    }
}
