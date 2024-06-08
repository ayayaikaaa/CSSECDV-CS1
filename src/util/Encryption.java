/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/**
 *
 * @author Alain
 */
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
    
    /** Encrypts password
     * 
     * @param message
     * @return
     * @throws Exception 
     */
    public String encrypt_password(String message) throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(KEY_SIZE);
        key = generator.generateKey();
        return encrypt(message);
    }
    
    public String decrypt_password(String message) throws Exception {
        return decrypt(message);
    }
    
    /** Encrypts a message via AES
     * 
     * @param message
     * @return
     * @throws Exception 
     */
    private String encrypt(String message) throws Exception {
        // TODOs: No salting yet & use better Cipher methods
        byte[] messageBytes = message.getBytes() ;
        encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = encryptionCipher.doFinal(messageBytes);
        return encode(encryptedBytes);
    }
    
    private String decrypt(String encryptedMessage) throws Exception {
        // TODOs: No salting yet & use better Cipher methods
        byte[] messageBytes = decode(encryptedMessage);
        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(T_LEN, encryptionCipher.getIV());
        decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] decryptedBytes = decryptionCipher.doFinal(messageBytes);
        return new String(decryptedBytes);
    }
    
    private String encode(byte[] data) { return Base64.getEncoder().encodeToString(data); }
    
    private byte[] decode(String data) { return Base64.getDecoder().decode(data); }
    
}
