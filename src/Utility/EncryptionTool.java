///**
// * Encryption Tool that uses AES and Base64 algorithm.
// * 
// * Includes various methods to decrypt a message encrypted with this tool.
// */
//package Utility;
//
//import java.security.SecureRandom;
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//import javax.crypto.KeyGenerator;
//import javax.crypto.Cipher;
//import java.util.Base64;
//import javax.crypto.spec.IvParameterSpec;
//
//public class EncryptionTool {
//    
//    /**
//     * Constructor
//     */
//    public EncryptionTool() {
//        this.key = this.generateKey();
//        this.iv = this.generateIv();
//    }
//    
//
//    /**
//     * Encrypts a message using AES Cipher algorithm and encoded
//     * into Base64 String.
//     * 
//     * Algorithm uses a key and initialization vector.
//     * 
//     * @param message
//     * @return String
//     * @throws Exception 
//     */
//    public String encryptMessage(String message) throws Exception {
//        return encrypt(message);
//    }
//    
//    /**
//     * Decrypts a a Base64 encoded String from the AES Cipher algorithm.
//     * 
//     * Hint: the correct key must be set with `setKey()` and
//     * the correct iv must be set with `setIv()`.
//     * 
//     * @param message
//     * @return String
//     * @throws Exception 
//     */
//    public String decryptMessage(String message) throws Exception {
//        return decrypt(message);
//    }
//    
//    /**
//     * 
//     * @param message
//     * @param key
//     * @param iv
//     * @return String
//     * @throws Exception 
//     */
//    public String decryptMessage(String message, String key, String iv) throws Exception {
//        this.setKey(key);
//        this.setIv(iv);
//        return decrypt(message);
//    }
//    
//    /**
//     * Returns the Base64 encoded String of the key contained in the 
//     * EncryptionTool instance.
//     * 
//     * Hint: run `setKey()` first if this current instance was not used to encrypt.
//     * 
//     * @return String
//     */
//    public String getKeyString() { return encodeBase64(key.getEncoded()); }
//    
//    /**
//     * Returns the Base64 encoded String of the key with provided array of
//     * encoded bytes of the SecretKey. 
//     * 
//     * Hint: pass as parameter `SecretKey.getEncoded()`
//     * 
//     * @param key
//     * @return String
//     */
//    public String getKeyString(byte[] key) { return encodeBase64(key); }
//    
//    /**
//     * Returns a SecretKey key provided the Base64 encoded string
//     * format of the key itself.
//     * 
//     * Hint: use `EncryptionTool.getKeyString()`
//     * 
//     * @param key
//     * @return SecretKey
//     */
//    public SecretKey getKey(String key) {
//        byte[] decodedKey = decodeBase64(key);
//        SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
//        return secretKey;
//    }
//    
//    /**
//     * Returns the key size. (128 by default).
//     * 
//     * @return int
//     */
//    public int getKeySize() { return KEY_SIZE; }
//    
//    /**
//     * Returns the Base64 encoded String of the IV contained in the 
//     * EncryptionTool instance.
//     * 
//     * @return int
//     */
//    public String getIvString() { return encodeBase64(iv.getIV()); }
//    
//    /**
//     * 
//     * @return IvParameterSpec
//     */
//    public IvParameterSpec getIv() { return iv; }
//    
//        /**
//     * Re-initializes the key stored in this EncryptionTool instance; Mainly
//     * if this instance is used for decrypting messages encrypted with the 
//     * EncryptionTool in the past.
//     * 
//     * Hint: use `getKey()`
//     * 
//     * @param key 
//     */
//    public void setKey(SecretKey key) { this.key = key; }
//    
//    /**
//     * 
//     * @param key 
//     */
//    public void setKey(byte[] key) { this.key = new SecretKeySpec(key, 0, key.length, "AES"); }
//    
//    /**
//     * 
//     * @param key 
//     */
//    public void setKey(String key) { this.setKey(decodeBase64(key)); }
//    
//    /**
//     * 
//     * @param iv 
//     */
//    public void setIv(IvParameterSpec iv) { this.iv = iv; }
//    
//    /**
//     * 
//     * @param iv 
//     */
//    public void setIv(byte[] iv) { this.iv = new IvParameterSpec(iv); }
//    
//    /**
//     * 
//     * @param iv 
//     */
//    public void setIv(String iv) { 
//        this.setIv(decodeBase64(iv)); 
//    }
//    
//    private String encrypt(String message) throws Exception {
//        byte[] messageBytes = message.getBytes() ;
//        encryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//        encryptionCipher.init(Cipher.ENCRYPT_MODE, key, iv);
//        byte[] cipherText = encryptionCipher.doFinal(messageBytes);
//        return encodeBase64(cipherText);
//    }
//    
//    private String decrypt(String encryptedMessage) throws Exception {
//        byte[] messageBytes = decodeBase64(encryptedMessage);
//        Cipher decryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//        decryptionCipher.init(Cipher.DECRYPT_MODE, key, iv);
//        byte[] decryptedBytes = decryptionCipher.doFinal(messageBytes);
//        return new String(decryptedBytes);
//    }
//    
//    private IvParameterSpec generateIv() {
//        byte[] iv = new byte[16];
//        new SecureRandom().nextBytes(iv);
//        return new IvParameterSpec(iv);
//    }
//    
//    private SecretKey generateKey() {
//        try {
//            KeyGenerator generator = KeyGenerator.getInstance("AES");
//            generator.init(KEY_SIZE);
//            return generator.generateKey();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return null;
//    }
//    
//    private String encodeBase64(byte[] encryptedBytes) { return Base64.getEncoder().encodeToString(encryptedBytes); }
//    
//    private byte[] decodeBase64(String encryptedMessage) { return Base64.getDecoder().decode(encryptedMessage); }
//    
//    private final int KEY_SIZE = 128;
//    private SecretKey key;
//    private IvParameterSpec iv;
//    private Cipher encryptionCipher;
//}
