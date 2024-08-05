//LAST MODIFIED 12/07/2024 10:12PM
package Controller;


import Model.History;
import Model.Keys;
import Model.Logs;
import Model.Product;
import Model.User;
import Utility.EncryptionTool;
import View.Frame;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



public class Main {
    
    public SQLite sqlite;
    
    public static void main(String[] args) {
        new Main().init();
    }
    
    public void init(){
        // Initialize a driver object
        sqlite = new SQLite();

        // Create a database
        sqlite.createNewDatabase();
        
        // Drop users table if needed
        sqlite.dropHistoryTable();
        sqlite.dropLogsTable();
        sqlite.dropProductTable();
        sqlite.dropUserTable();
        sqlite.dropKeysTable();
        
        // Create users table if not exist
        sqlite.createHistoryTable();
        sqlite.createLogsTable();
        sqlite.createProductTable();
        sqlite.createUserTable();
        sqlite.createKeysTable();
        sqlite.createLoginAttemptsTable();
        
        // Add sample history
        sqlite.addHistory("admin", "Antivirus", 1, "2019-04-03 14:30:00.000");
        sqlite.addHistory("manager", "Firewall", 1, "2019-04-03 14:30:01.000");
        sqlite.addHistory("staff", "Scanner", 1, "2019-04-03 14:30:02.000");
        
        // Add sample logs
        sqlite.addLogs("NOTICE", "admin", "User creation successful", new Timestamp(new Date().getTime()).toString());
        sqlite.addLogs("NOTICE", "manager", "User creation successful", new Timestamp(new Date().getTime()).toString());
        sqlite.addLogs("NOTICE", "admin", "User creation successful", new Timestamp(new Date().getTime()).toString());
        
        // Add sample product
        sqlite.addProduct("Antivirus", 5, 500.0);
        sqlite.addProduct("Firewall", 3, 1000.0);
        sqlite.addProduct("Scanner", 10, 100.0);

        // Add sample users
        sqlite.addUser("admin", "1234" , 5, "cssecdevadm@gmail.com");
        sqlite.addUser("staff", "1234", 3, "cssecdevmanager@gmail.com");
//        sqlite.addUser("staff", "qwerty1234", 3);
        sqlite.addUser("client1", "qwerty1234", 2, "matthew_adrian_u_chua@dlsu.edu.ph");
//        sqlite.addUser("client2", "qwerty1234", 2);
        
        
//        // Get histories
//        ArrayList<History> histories = sqlite.getHistory();
//        for(int nCtr = 0; nCtr < histories.size(); nCtr++){
//            System.out.println("===== History " + histories.get(nCtr).getId() + " =====");
//            System.out.println(" Username: " + histories.get(nCtr).getUsername());
//            System.out.println(" Name: " + histories.get(nCtr).getName());
//            System.out.println(" Stock: " + histories.get(nCtr).getStock());
//            System.out.println(" Timestamp: " + histories.get(nCtr).getTimestamp());
//        }
//        
//        // Get logs
//        ArrayList<Logs> logs = sqlite.getLogs();
//        for(int nCtr = 0; nCtr < logs.size(); nCtr++){
//            System.out.println("===== Logs " + logs.get(nCtr).getId() + " =====");
//            System.out.println(" Username: " + logs.get(nCtr).getEvent());
//            System.out.println(" Password: " + logs.get(nCtr).getUsername());
//            System.out.println(" Role: " + logs.get(nCtr).getDesc());
//            System.out.println(" Timestamp: " + logs.get(nCtr).getTimestamp());
//        }
//        
//        // Get products
//        ArrayList<Product> products = sqlite.getProduct();
//        for(int nCtr = 0; nCtr < products.size(); nCtr++){
//            System.out.println("===== Product " + products.get(nCtr).getId() + " =====");
//            System.out.println(" Name: " + products.get(nCtr).getName());
//            System.out.println(" Stock: " + products.get(nCtr).getStock());
//            System.out.println(" Price: " + products.get(nCtr).getPrice());
//        }

        // Get users
        ArrayList<User> users = sqlite.getUsers();
        for(int nCtr = 0; nCtr < users.size(); nCtr++){
            System.out.println("===== User " + users.get(nCtr).getId() + " =====");
            System.out.println(" Username: " + users.get(nCtr).getUsername());
            System.out.println(" Password: " + users.get(nCtr).getPassword());
            System.out.println(" Role: " + users.get(nCtr).getRole());
            System.out.println(" Locked: " + users.get(nCtr).getLocked());
        }
        
        // Get keys
        ArrayList<Keys> keys = sqlite.getKeys();
        for(int nCtr = 0; nCtr < keys.size(); nCtr++){
            System.out.println("===== Keys " + keys.get(nCtr).getId() + " =====");
            System.out.println(" UserID: " + keys.get(nCtr).getUserId());
            System.out.println(" Key: " + keys.get(nCtr).getKey());
            System.out.println(" IV: " + keys.get(nCtr).getIv());
        }

//       // Debug Decryption
//        try {
//            //ArrayList<User> users = sqlite.getUsers();
//            User user = users.get(0);
//            String username = user.getUsername();
//            String password = user.getPassword();
//            System.out.println("==== Debugging ====");
//            System.out.println(" Username: " + username);
//            System.out.println(" Password: " + password);
//            
//            String sKey, sIv;
//            try (Scanner scanIn = new Scanner(System.in)) {
//                System.out.print(" Enter Key: ");
//                sKey = scanIn.nextLine();
//                System.out.print(" Enter IV: ");
//                sIv = scanIn.nextLine();
//            }
//            EncryptionTool encrypt = new EncryptionTool();
//            encrypt.setKey(sKey);
//            encrypt.setIv(sIv);
//            
//            System.out.println(" Decoded Password: " + encrypt.decryptMessage(password));
//            System.out.println("END");
//        } catch (Exception e) {
//            System.out.println(e);
//            System.exit(1);
//        }
        
        // Initialize User Interface
        Frame frame = new Frame();
        frame.init(this);
    }
    
}