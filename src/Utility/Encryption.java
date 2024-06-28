
package Utility;

//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
import java.util.Base64;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
//import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class Encryption {
    
    private SecretKey key;
    private int KEY_SIZE;
    private int T_LEN;
    private Cipher encryptionCipher;
    
    public Encryption(int KEY_SIZE, int T_LEN) {
        this.KEY_SIZE = KEY_SIZE;
        this.T_LEN = T_LEN;
    }
    
    public Encryption() {
        this(128, 128); //default
    }
    
    public String encryptPassword(String password) throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(KEY_SIZE);
        key = generator.generateKey();
        return encrypt(password);
    }
    
    public String decryptPassword(String password) throws Exception {
        return decrypt(password);
    }
    
    private String encrypt(String password) throws Exception {
        // TODOs: No salting yet & use better Cipher methods
        byte[] passwordBytes = password.getBytes() ;
        encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = encryptionCipher.doFinal(passwordBytes);
        return encode(encryptedBytes);
    }
    
    private String decrypt(String encryptedPassword) throws Exception {
        // TODOs: No salting yet & use better Cipher methods
        byte[] passwordBytes = decode(encryptedPassword);
        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(T_LEN, encryptionCipher.getIV());
        decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] decryptedBytes = decryptionCipher.doFinal(passwordBytes);
        return new String(decryptedBytes);
    }
    
    private String encode(byte[] encryptedBytes) { return Base64.getEncoder().encodeToString(encryptedBytes); }
    
    private byte[] decode(String encryptedPassword) { return Base64.getDecoder().decode(encryptedPassword); }
}
