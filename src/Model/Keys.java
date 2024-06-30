package Model;

public class Keys {
    private int userId;
    // Vars below must be stored in Base64 String format
    private String key;
    private String iv;

    public Keys(String key, String iv){
        this.key = key;
        this.iv = iv;
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public String getKey() {
        return key;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
    
    public String getIv() {
        return iv;
    }
    
    public void setIv(String iv) {
        this.iv = iv;
    }
}
