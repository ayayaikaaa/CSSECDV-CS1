
package Controller;

import Model.History;
//import Model.Keys;
import Model.Logs;
import Model.Product;
import Model.User;
import Utility.EncryptionToolV2;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLite {
    private final int maxAttempts = 3;
    private final int lockoutDuration = 60000; // 1 minute in milliseconds
    private final int disabledCountThreshold = 3;


    public int DEBUG_MODE = 0;
    String driverURL = "jdbc:sqlite:" + "database.db";
    //public EncryptionTool encryption;
    public EncryptionToolV2 encryption;

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
                + " locked INTEGER DEFAULT 0,\n"
                + " lockout_time INTEGER DEFAULT 0,\n"
                + " disabled_count INTEGER DEFAULT 0,\n" 
                + " email TEXT UNIQUE\n"
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
                + " attempt_time INTEGER NOT NULL,\n"
                + " disableCounter INTEGER\n"
                + ");";

        //executeUpdate(sql);
        try (Connection conn = DriverManager.getConnection(driverURL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table loginAttempt in database.db created.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
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
    
    public void dropLoginAttemptsTable() {
        String sql = "DROP TABLE IF EXISTS login_attempts;";

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
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }

    public void addLogs(String event, String username, String desc, String timestamp) {
        String sql = "INSERT INTO logs(event,username,desc,timestamp) VALUES(?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the parameters
            pstmt.setString(1, event);
            pstmt.setString(2, username);
            pstmt.setString(3, desc);
            pstmt.setString(4, timestamp);

            pstmt.executeUpdate();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }

    public void resetPassword(String email, String newPassword) {
        // SQL to update password based on email
        String sqlUpdatePassword = "UPDATE users SET password = ? WHERE email = ?";
        String sqlSelectUserIdAndUsername = "SELECT id, username FROM users WHERE email = ?";
        String encryptedPass = "";
        int userId = -1;
        String username = "";

        try {
            EncryptionToolV2 encryption = new EncryptionToolV2(); // Create an instance of your EncryptionTool
            encryptedPass = encryption.hashToBase64(encryption.hash(newPassword)); // Encrypt the new password
        } catch (Exception ex) {
            System.out.print(ex); // Handle encryption exceptions (you might want to log or throw)
        }

        try (Connection conn = DriverManager.getConnection(driverURL)) {
            // Retrieve userId and username based on email
            try (PreparedStatement pstmtSelect = conn.prepareStatement(sqlSelectUserIdAndUsername)) {
                pstmtSelect.setString(1, email);
                try (ResultSet rs = pstmtSelect.executeQuery()) {
                    if (rs.next()) {
                        userId = rs.getInt("id");
                        username = rs.getString("username");
                    } else {
                        throw new SQLException("No user found with email: " + email);
                    }
                }
            }

            // Check if the username is 'admin' or 'manager'
            if ("admin".equalsIgnoreCase(username) || "manager".equalsIgnoreCase(username)) {
                System.out.println("Password update not allowed for user with username: " + username);
                return;
            }

            // Set parameters for the prepared statement
            try (PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdatePassword)) {
                pstmtUpdate.setString(1, encryptedPass); // Set encrypted password
                pstmtUpdate.setString(2, email); // Set email

                int rowsUpdated = pstmtUpdate.executeUpdate(); // Execute the update

                if (rowsUpdated > 0) {
                    System.out.println("Password updated successfully for email: " + email);
                } else {
                    throw new SQLException("Password update failed for email: " + email);
                }
            }

            System.out.println("userid: " + userId);

            SQLite sqlite = new SQLite();
            //sqlite.editKey(userId, key, iv);
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }

    public void addUser(String username, String password) {
        String sql = "INSERT INTO users(username,password,email) VALUES(?, ?, NULL)";
        String encryptedPass = "";
        int userId = -1;
        String key = "";
        String iv = "";
        try {
            encryption = new EncryptionToolV2();
            encryptedPass = encryption.hashToBase64(encryption.hash(password));
        } catch (Exception ex) {
            System.out.print(ex);
        }

        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // Error Handling
            if (encryptedPass.isEmpty() && key.isEmpty() && iv.isEmpty()) {
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

    public void addUser(String username, String password, int role, String email) {
        String sql = "INSERT INTO users(username,password,role,email) VALUES(?, ?, ?, ?)";
        String encryptedPass = "";
        int userId = -1;
        String key = "";
        String iv = "";
        try {
            encryption = new EncryptionToolV2();
            encryptedPass = encryption.hashToBase64(encryption.hash(password));
        } catch (Exception ex) {
            System.out.print(ex);
        }

        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // Error Handling
            if (encryptedPass.isEmpty() && key.isEmpty() && iv.isEmpty()) {
                throw new SQLException("User creation failed.");
            }

            pstmt.setString(1, username);
            pstmt.setString(2, encryptedPass);
            pstmt.setInt(3, role);
            pstmt.setString(4, email);
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
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, userId);
            pstmt.setString(2, key);
            pstmt.setString(3, iv);
            pstmt.executeUpdate();

        } catch (Exception ex) {
            System.out.print(ex);
        }
    }


    public ArrayList<History> getHistory() {
        String sql = "SELECT id, username, name, stock, timestamp FROM history";
        ArrayList<History> histories = new ArrayList<History>();

        try (Connection conn = DriverManager.getConnection(driverURL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

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

    public ArrayList<Logs> getLogs() {
        String sql = "SELECT id, event, username, desc, timestamp FROM logs";
        ArrayList<Logs> logs = new ArrayList<Logs>();

        try (Connection conn = DriverManager.getConnection(driverURL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

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

    public ArrayList<Product> getProduct() {
        String sql = "SELECT id, name, stock, price FROM product";
        ArrayList<Product> products = new ArrayList<Product>();

        try (Connection conn = DriverManager.getConnection(driverURL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

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

    public ArrayList<User> getUsers() {
        String sql = "SELECT id, username, password, role, locked, email FROM users";
        ArrayList<User> users = new ArrayList<User>();

        try (Connection conn = DriverManager.getConnection(driverURL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                users.add(new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("role"),
                        rs.getInt("locked"),
                        rs.getString("email")));

            }
        } catch (Exception ex) {
        }
        return users;
    }

    private void recordLoginAttempt(String username) {
        String sql = "INSERT INTO login_attempts(username, attempt_time) VALUES(?, ?)";
        executeUpdateWithRetry(sql, username, System.currentTimeMillis());
    }
    
    public int getLockoutCount(String username) {
        String sql = "SELECT COUNT(*) as count FROM login_attempts WHERE username = ? AND attempt_time > ?";
        int count = 0;
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setLong(2, System.currentTimeMillis() - lockoutDuration);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count;
    }

    private void updateDisabledCount(String username, int increment) {
        String sql = "UPDATE users SET disabled_count = disabled_count + ? WHERE username = ?";
        executeUpdateWithRetry(sql, increment, username);
    }

    public void lockUser(String username) {
        int lockoutCount = getLockoutCount(username);
        int disabledCount = getDisabledCount(username);
        System.out.println(lockoutCount >=maxAttempts);
        if(lockoutCount >=maxAttempts){
            //System.out.println("OKAY");
            if (disabledCount < disabledCountThreshold) {
                //System.out.println("OKAY2");
                disabledCount++;
                updateDisabledCount(username, 1); // Increment the disabledCount
            }
            if (disabledCount >= disabledCountThreshold) {
                //System.out.println("OKAY3");
                String sqlUpdateRole = "UPDATE users SET role = 1 WHERE username = ?";
                executeUpdateWithRetry(sqlUpdateRole, username);
                System.out.println("User " + username + " has been permanently locked.");
            } else {
                if (lockoutCount >= maxAttempts) {
                    String sqlUpdateLock = "UPDATE users SET locked = 1, lockout_time = ? WHERE username = ?";
                    executeUpdateWithRetry(sqlUpdateLock, System.currentTimeMillis(), username);
                    System.out.println("User " + username + " has been temporarily locked.");
                    System.out.println("Disable: " + disabledCount + ";" + "LockoutCount: " + lockoutCount);
                }
            }
        }
    }

    public void lockUserAdmin(String username){
        String sqlUpdateLock = "UPDATE users SET locked = 1, lockout_time = ? WHERE username = ?";
        executeUpdateWithRetry(sqlUpdateLock, System.currentTimeMillis(), username);
        System.out.println("User " + username + " has been temporarily locked.");
    }

    private int getDisabledCount(String username) {
        String sql = "SELECT disabled_count FROM users WHERE username = ?";
        int count = 0;
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt("disabled_count");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count;
    }
    
    public void unlockUser(String username) {
        String sql = "UPDATE users SET locked = 0 WHERE username = ?";
        executeUpdateWithRetry(sql, username);
        //System.out.println("RESET");
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

    private void resetLoginAttempts(String username) {
        String sql = "DELETE FROM login_attempts WHERE username = ?";
        executeUpdateWithRetry(sql, username);
        unlockUser(username);
    }

    private boolean isUserLocked(String username) {
        String sql = "SELECT locked, lockout_time, role FROM users WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int locked = rs.getInt("locked");
                long lockoutTime = rs.getLong("lockout_time");
                int role = rs.getInt("role");

                if (role == 1) {
                    return true; // Permanently locked
                }
                if (locked == 1 && System.currentTimeMillis() < lockoutTime + lockoutDuration) {
                    return true;
                } else if (locked == 1) {
                    //unlockUser(username);
                    //System.out.println("OKAT");
                    return false;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean authenticateUser(String username, String password) {
        try {
            if (isUserLocked(username)) {
                System.out.println("User is currently locked.");
                return false;
            }
            
            if (!findUser(username)) {
                System.out.println("User invalid.");
                return false;
            }         

            User user = getUser(username);
                    if (user.getRole() == 1) {
                        System.out.println("User account is disabled.");
                        return false;
                    }
                    encryption = new EncryptionToolV2();
                    String storedHashedPassword = user.getPassword();
                    String convert = encryption.base64ToHash(storedHashedPassword);
                    if (encryption.verify(password, convert)) {
                        resetLoginAttempts(username);
                        updateDisabledCount(username, -getDisabledCount(username)); // Reset disabled count
                        return true;
                    } else {
                        recordLoginAttempt(username);
                        unlockUser(username);
                        int lockoutCount = getLockoutCount(username);
                        System.out.println(lockoutCount);
                        if (lockoutCount >= maxAttempts) {
                            lockUser(username);
                        }

                        return false;
                    }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean checkEmail(String email) {
        ArrayList<User> users = getUsers();

        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true; // Return true if email found
            }
        }
        return false; // Return false if email not found
    }

    public Product getProduct(String name) {
        String sql = "SELECT name, stock, price FROM product WHERE name='" + name + "';";
        Product product = null;
        try (Connection conn = DriverManager.getConnection(driverURL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
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

    public boolean findUser(String username) {
        String sql = "SELECT COUNT(*) as count FROM users WHERE username= ?";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            if (rs.getInt("Count") > 0) return true;
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return false;
    }

    public String findKey(int userId) {
        String sql = "SELECT * FROM keys WHERE userId = ?";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();
            if (!rs.getString("key").isEmpty()) {
                return rs.getString("key");
            } else throw new SQLException("Retrieval failed, String empty.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return "";
    }

    public String findKeyIV(int userId) {
        String sql = "SELECT * FROM keys WHERE userId = ?";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();
            if (!rs.getString("iv").isEmpty()) {
                return rs.getString("iv");
            } else throw new SQLException("Retrieval failed, String empty.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return "";
    }

    public User getUser(String username) {
        String sql = "SELECT * FROM users WHERE username='" + username + "';";
        User user = null;
        try (Connection conn = DriverManager.getConnection(driverURL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            user = new User(rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getInt("role"),
                    rs.getInt("locked"),
                    rs.getString("email"));
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return user;
    }

    public void updateRole(String username, int newRole) {
        String sql = "UPDATE users SET Role = ? WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the parameters
            pstmt.setInt(1, newRole);
            pstmt.setString(2, username);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void purchaseProduct(String name, int amount) {
        String sql = "UPDATE product SET stock = stock - ? WHERE name = ?";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the parameters
            pstmt.setInt(1, amount);
            pstmt.setString(2, name);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteUser(String username) {
        String sql = "DELETE FROM users WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateLock(String username, int state) {
        String sql = "UPDATE users SET locked = ? WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the parameters
            pstmt.setInt(1, state);
            pstmt.setString(2, username);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void adminChangePassword(String username, String newPassword) {
        // SQL to update password based on email
        String sqlUpdatePassword = "UPDATE users SET password = ? WHERE username = ?";
        String sql = "SELECT * FROM users WHERE username = ?";
        String encryptedPass = "";
        int userId = -1;

        try {
            EncryptionToolV2 encryption = new EncryptionToolV2(); // Create an instance of your EncryptionTool
            encryptedPass = encryption.hashToBase64(encryption.hash(newPassword)); // Encrypt the new password
        } catch (Exception ex) {
            System.out.print(ex); // Handle encryption exceptions (you might want to log or throw)
        }

        try (Connection conn = DriverManager.getConnection(driverURL)) {

            try (PreparedStatement pstmtSelect = conn.prepareStatement(sql)) {
                pstmtSelect.setString(1, username);
                try (ResultSet rs = pstmtSelect.executeQuery()) {
                    if (rs.next()) {
                        userId = rs.getInt("id");
                    } else {
                        throw new SQLException("No user found with username: " + username);
                    }
                }
            }


            // Set parameters for the prepared statement
            try (PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdatePassword)) {
                pstmtUpdate.setString(1, encryptedPass); // Set encrypted password
                pstmtUpdate.setString(2, username); // Set username

                int rowsUpdated = pstmtUpdate.executeUpdate(); // Execute the update

                if (rowsUpdated > 0) {
                    System.out.println("Password updated successfully for user: " + username);
                } else {
                    throw new SQLException("Password update failed for user: " + username);
                }
            }

            System.out.println("userid: " + userId);

            SQLite sqlite = new SQLite();
            //sqlite.editKey(userId, key, iv);
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }

    public void addProduct(String name, int stock, float price, Component component) {
        String sql = "INSERT INTO product (name, stock, price) VALUES (?, ?, ?);";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the parameters
            pstmt.setString(1, name);
            pstmt.setInt(2, stock);
            pstmt.setFloat(3, price);

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(component, "Product added", "", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(component, "Product name already exists!", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void addProductTest(String name, int stock, float price) {
        String sql = "INSERT INTO product (name, stock, price) VALUES (?, ?, ?);";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the parameters
            pstmt.setString(1, name);
            pstmt.setInt(2, stock);
            pstmt.setFloat(3, price);

            pstmt.executeUpdate();

            //JOptionPane.showMessageDialog(component, "Product added", "", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //JOptionPane.showMessageDialog(component, "Product name already exists!", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void editProduct(String name, int stock, float price, Component component, int id) {
        String sql = "UPDATE product SET name = ?, stock = ?, price = ? WHERE id = ?;";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the parameters
            pstmt.setString(1, name);
            pstmt.setInt(2, stock);
            pstmt.setFloat(3, price);
            pstmt.setFloat(4, id);

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(component, "Product edited", "", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(component, "Product name already exists!", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public int getProductID(String name) {
        String sql = "SELECT id FROM product WHERE name='" + name + "';";
        try (Connection conn = DriverManager.getConnection(driverURL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            return Integer.parseInt(rs.getString("id"));

        } catch (Exception ex) {
            System.out.print(ex);
        }
        return -1;
    }

    public void deleteProduct(String name) {
        String sql = "DELETE FROM product WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editLogs(String event, String username, String desc, String time, int id) {
        String sql = "UPDATE logs SET event = ?, username = ?, desc = ?, timestamp = ? WHERE id = ?;";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the parameters
            pstmt.setString(1, event);
            pstmt.setString(2, username);
            pstmt.setString(3, desc);
            pstmt.setString(4, time);
            pstmt.setInt(5, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void clearLogs() {
        String sql = "DELETE FROM logs;";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the parameters

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}