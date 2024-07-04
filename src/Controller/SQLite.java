package Controller;

import Model.History;
import Model.Keys;
import Model.Logs;
import Model.Product;
import Model.User;
import Utility.EncryptionTool;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLite {
    
    public int DEBUG_MODE = 0;
    String driverURL = "jdbc:sqlite:" + "database.db";
    public EncryptionTool encryption;
    
    public void createNewDatabase() {
        try (Connection conn = DriverManager.getConnection(driverURL)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Database database.db created.");
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void createHistoryTable() {
        String sql = "CREATE TABLE IF NOT EXISTS history (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " username TEXT NOT NULL,\n"
            + " name TEXT NOT NULL,\n"
            + " stock INTEGER DEFAULT 0,\n"
            + " timestamp TEXT NOT NULL\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table history in database.db created.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void createLogsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS logs (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " event TEXT NOT NULL,\n"
            + " username TEXT NOT NULL,\n"
            + " desc TEXT NOT NULL,\n"
            + " timestamp TEXT NOT NULL\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table logs in database.db created.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
     
    public void createProductTable() {
        String sql = "CREATE TABLE IF NOT EXISTS product (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " name TEXT NOT NULL UNIQUE,\n"
            + " stock INTEGER DEFAULT 0,\n"
            + " price REAL DEFAULT 0.00\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table product in database.db created.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
     
    public void createUserTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " username TEXT NOT NULL UNIQUE,\n"
            + " password TEXT NOT NULL,\n"
            + " role INTEGER DEFAULT 2,\n"
            + " locked INTEGER DEFAULT 0\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table users in database.db created.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void createKeysTable() {
        String sql = "CREATE TABLE IF NOT EXISTS keys (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " userId INTEGER NOT NULL,\n"
            + " key TEXT NOT NULL,\n"
            + " iv TEXT NOT NULL,\n"
            + " FOREIGN KEY (userId) REFERENCES users(id)\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table keys in database.db created.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void createLoginAttemptsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS login_attempts (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " username TEXT NOT NULL,\n"
            + " attempt_time INTEGER NOT NULL\n"
            + ");";

        executeUpdate(sql);
    }

    
    public void dropHistoryTable() {
        String sql = "DROP TABLE IF EXISTS history;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table history in database.db dropped.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void dropLogsTable() {
        String sql = "DROP TABLE IF EXISTS logs;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table logs in database.db dropped.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void dropProductTable() {
        String sql = "DROP TABLE IF EXISTS product;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table product in database.db dropped.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void dropUserTable() {
        String sql = "DROP TABLE IF EXISTS users;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table users in database.db dropped.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void dropKeysTable() {
        String sql = "DROP TABLE IF EXISTS keys;";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table keys in database.db dropped.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void addHistory(String username, String name, int stock, String timestamp) {
        String sql = "INSERT INTO history(username,name,stock,timestamp) VALUES('" + username + "','" + name + "','" + stock + "','" + timestamp + "')";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void addLogs(String event, String username, String desc, String timestamp) {
        String sql = "INSERT INTO logs(event,username,desc,timestamp) VALUES('" + event + "','" + username + "','" + desc + "','" + timestamp + "')";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void addProduct(String name, int stock, double price) {
        String sql = "INSERT INTO product(name,stock,price) VALUES('" + name + "','" + stock + "','" + price + "')";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void addUser(String username, String password) {
        String sql = "INSERT INTO users(username,password) VALUES(?, ?)";
        String encryptedPass = "";
        int userId = -1;
        String key = "";
        String iv = "";
        try {
            encryption = new EncryptionTool();
            encryptedPass = encryption.encryptMessage(password);
            key = encryption.getKeyString();
            iv = encryption.getIvString();
        } catch (Exception ex) {
            System.out.print(ex);
        }
        
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            // Error Handling
            if(encryptedPass.isEmpty() && key.isEmpty() && iv.isEmpty()) {
                throw new SQLException("User creation failed.");
            } 
//      PREPARED STATEMENT EXAMPLE
            pstmt.setString(1, username);
            pstmt.setString(2, encryptedPass);
            pstmt.executeUpdate();
            
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    userId = generatedKeys.getInt(1);
                } else throw new SQLException("User creation failed.");
            }
            
            SQLite sqlite = new SQLite();
            sqlite.addKeys(userId, key, iv);
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void addUser(String username, String password, int role) {
        String sql = "INSERT INTO users(username,password,role) VALUES(?, ?, ?)";
        String encryptedPass = "";
        int userId = -1;
        String key = "";
        String iv = "";
        try {
            encryption = new EncryptionTool();
            encryptedPass = encryption.encryptMessage(password);
            key = encryption.getKeyString();
            iv = encryption.getIvString();
        } catch (Exception ex) {
            System.out.print(ex);
        }
        
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // Error Handling
            if(encryptedPass.isEmpty() && key.isEmpty() && iv.isEmpty()) {
                throw new SQLException("User creation failed.");
            } 
            
            pstmt.setString(1, username);
            pstmt.setString(2, encryptedPass);
            pstmt.setInt(3, role);
            pstmt.executeUpdate();
            
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    userId = generatedKeys.getInt(1);
                } else throw new SQLException("User creation failed.");
            }
            
            SQLite sqlite = new SQLite();
            sqlite.addKeys(userId, key, iv);
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void addKeys(int userId, String key, String iv) {
        //String sql = "INSERT INTO keys(userId, key, iv) VALUES('" + userId + "','" + key + "','" + iv + "')";
        String sql = "INSERT INTO keys(userId, key, iv) VALUES(?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
            pstmt.setInt(1, userId);
            pstmt.setString(2, key);
            pstmt.setString(3, iv);
            pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    
    public ArrayList<History> getHistory(){
        String sql = "SELECT id, username, name, stock, timestamp FROM history";
        ArrayList<History> histories = new ArrayList<History>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                histories.add(new History(rs.getInt("id"),
                                   rs.getString("username"),
                                   rs.getString("name"),
                                   rs.getInt("stock"),
                                   rs.getString("timestamp")));
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return histories;
    }
    
    public ArrayList<Logs> getLogs(){
        String sql = "SELECT id, event, username, desc, timestamp FROM logs";
        ArrayList<Logs> logs = new ArrayList<Logs>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                logs.add(new Logs(rs.getInt("id"),
                                   rs.getString("event"),
                                   rs.getString("username"),
                                   rs.getString("desc"),
                                   rs.getString("timestamp")));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return logs;
    }
    
    public ArrayList<Product> getProduct(){
        String sql = "SELECT id, name, stock, price FROM product";
        ArrayList<Product> products = new ArrayList<Product>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                products.add(new Product(rs.getInt("id"),
                                   rs.getString("name"),
                                   rs.getInt("stock"),
                                   rs.getFloat("price")));
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return products;
    }
    
    public ArrayList<User> getUsers(){
        String sql = "SELECT id, username, password, role, locked FROM users";
        ArrayList<User> users = new ArrayList<User>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                users.add(new User(rs.getInt("id"),
                                   rs.getString("username"),
                                   rs.getString("password"),
                                   rs.getInt("role"),
                                   rs.getInt("locked")));
            }
        } catch (Exception ex) {}
        return users;
    }

    private void recordLoginAttempt(String username) {
        String sql = "INSERT INTO login_attempts(username, attempt_time) VALUES(?, ?)";
        executeUpdateWithRetry(sql, username, System.currentTimeMillis());
    }

    private int getLoginAttempts(String username) {
        String sql = "SELECT COUNT(*) as count FROM login_attempts WHERE username = ? AND attempt_time > ?";
        int maxAttemptsWindow = 60000; // 1 minute in milliseconds
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setLong(2, System.currentTimeMillis() - maxAttemptsWindow);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("count");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    private long getLastAttemptTime(String username) {
        String sql = "SELECT MAX(attempt_time) as last_attempt FROM login_attempts WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getLong("last_attempt");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    private void lockUser(String username) {
        String sql = "UPDATE users SET locked = 1 WHERE username = ?";
        executeUpdateWithRetry(sql, username);
    }

    private void unlockUser(String username) {
        String sql = "UPDATE users SET locked = 0 WHERE username = ?";
        executeUpdateWithRetry(sql, username);
    }

    private void clearLoginAttempts(String username) {
        String sql = "DELETE FROM login_attempts WHERE username = ?";
        executeUpdateWithRetry(sql, username);
    }

    private void executeUpdateWithRetry(String sql, Object... params) {
        for (int i = 0; i < 3; i++) { // Retry up to 3 times
            try (Connection conn = DriverManager.getConnection(driverURL);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                for (int j = 0; j < params.length; j++) {
                    pstmt.setObject(j + 1, params[j]);
                }
                pstmt.executeUpdate();
                return;
            } catch (SQLException e) {
                if (e.getErrorCode() == 5) { // SQLITE_BUSY
                    try {
                        Thread.sleep(100); // Wait for 100 ms before retrying
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    private void executeUpdate(String sql) {
        try (Connection conn = DriverManager.getConnection(driverURL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
    public boolean authenticateUser(String username, String password) {
        ArrayList<User> users = getUsers();
        int maxAttempts = 3;
        int lockoutDuration = 60000; // 1 minute in milliseconds

        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement("SELECT locked FROM users WHERE username = ?")) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int locked = rs.getInt("locked");
                if (locked == 1) {
                    // Check if lockout duration has passed
                    long lastAttemptTime = getLastAttemptTime(username);
                    if (System.currentTimeMillis() - lastAttemptTime > lockoutDuration) {
                        // Unlock the user
                        unlockUser(username);
                    } else {
                        return false;
                    }
                }
            }

            // Track login attempts
            int attempts = getLoginAttempts(username);
            if (attempts >= maxAttempts) {
                lockUser(username);
                return false;
            }

            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    int userId = user.getId();
                    String key = this.findKey(userId);
                    String iv = this.findKeyIV(userId);
                    encryption.setKey(key);
                    encryption.setIv(iv);
                    String decryptedPassword = encryption.decryptMessage(user.getPassword());
                    if (decryptedPassword.equals(password)) {
                        clearLoginAttempts(username);
                        return true;
                    }
                    break;
                }
            }

            recordLoginAttempt(username);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public ArrayList<Keys> getKeys(){
        String sql = "SELECT id, userId, key, iv FROM keys";
        ArrayList<Keys> keys = new ArrayList<Keys>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                keys.add(new Keys(rs.getInt("id"),
                                  rs.getInt("userId"),
                                  rs.getString("key"),
                                  rs.getString("iv")));
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return keys;
    }
    
    public Product getProduct(String name){
        String sql = "SELECT name, stock, price FROM product WHERE name='" + name + "';";
        Product product = null;
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            product = new Product(rs.getString("name"),
                                   rs.getInt("stock"),
                                   rs.getFloat("price"));
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return product;
    }
    
    public void removeUser(String username) {
        String sql = "DELETE FROM users WHERE username='" + username + "';";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("User " + username + " has been deleted.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void removeKeys(int userId) {
        String sql = "DELETE FROM keys WHERE userId='" + userId + "';";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Keys of user " + userId + " has been deleted.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public boolean findUser(String username){
        String sql = "SELECT COUNT(*) as count FROM users WHERE username= ?";
        try (Connection conn = DriverManager.getConnection(driverURL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            if(rs.getInt("Count") > 0) return true;
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return false;
    }
    
    public String findKey(int userId){
        String sql = "SELECT * FROM keys WHERE userId = ?";
        try (Connection conn = DriverManager.getConnection(driverURL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();
            if(!rs.getString("key").isEmpty()) {
                return rs.getString("key");
            } else throw new SQLException("Retrieval failed, String empty.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return "";
    }
    
    public String findKeyIV(int userId){
        String sql = "SELECT * FROM keys WHERE userId = ?";
        try (Connection conn = DriverManager.getConnection(driverURL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();
            if(!rs.getString("iv").isEmpty()) {
                return rs.getString("iv");
            } else throw new SQLException("Retrieval failed, String empty.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return "";
    }
}