/**Encryption Tool that uses BCrypt with salt and provides functionality to encode/decode
 * with Base64 algorithm.
 * 
 */
package Utility;

import Utility.org.mindrot.jbcrypt.BCrypt;
import java.util.Base64;

public class EncryptionToolV2 {
    
    public EncryptionToolV2() {}
    
    public String hash(String message) {
        String salt = BCrypt.gensalt(workload);
        String hashed = BCrypt.hashpw(message, salt);
        return hashed;
    }
    
    public boolean verify(String plaintext, String hash) {
        boolean is_verified = false;
        if(null == hash || !hash.startsWith("$2a"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        is_verified = BCrypt.checkpw(plaintext, hash);
        return is_verified;
    }
    
    public String hashToBase64(String hash) {
        byte[] hashBytes = hash.getBytes();
        return encodeBase64(hashBytes);
    }
    
    public String base64ToHash(String encoding) {
        return new String(decodeBase64(encoding));
    }
    
    private String encodeBase64(byte[] encryptedBytes) { return Base64.getEncoder().encodeToString(encryptedBytes); }
    
    private byte[] decodeBase64(String encryptedMessage) { return Base64.getDecoder().decode(encryptedMessage); }
    
    // Variables Declaration
    private final int workload = 12;
    //
}
