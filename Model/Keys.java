package Model;

public class Keys {
    private int id;     // PK
    private int userId; // FK
    // Vars below must be stored in Base64 String format
    private String key;
    private String iv;
    

    public Keys(int userId, String key, String iv){
        this.userId = userId;
        this.key = key;
        this.iv = iv;
    }
    
    public Keys(int id, int userId, String key, String iv){
        this.id = id;
        this.userId = userId;
        this.key = key;
        this.iv = iv;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
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
