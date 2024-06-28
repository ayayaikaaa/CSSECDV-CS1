package View;


import Controller.SQLite;

import javax.swing.*;
import java.awt.*;
import Utility.Encryption;
import java.util.logging.Logger;
import java.util.logging.Level;
import Model.User;


public class Register extends javax.swing.JPanel {

    static int strength = 0;
    static boolean usernameValid = false;
    public Frame frame;
    private Encryption encryption = new Encryption();
    public SQLite sqlite;
    
    public Register() {
        initComponents();
    }
    
    public void clearRegisterFields() {
        usernameFld.setText(null);
        passwordFld.setText(null);
        confpassFld.setText(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents                          
    private void initComponents() {

        registerBtn = new javax.swing.JButton();
        passwordFld = new javax.swing.JPasswordField();
        usernameFld = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        confpassFld = new javax.swing.JPasswordField();
        backBtn = new javax.swing.JButton();
        passwordLabel = new javax.swing.JLabel();
        confpassLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();

        registerBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        registerBtn.setText("REGISTER");
        registerBtn.setEnabled(false);
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        passwordFld.setBackground(new java.awt.Color(240, 240, 240));
        passwordFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        passwordFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordFldKeyReleased(evt);
            }
        });

        usernameFld.setBackground(new java.awt.Color(240, 240, 240));
        usernameFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usernameFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "USERNAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        usernameFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usernameFldKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        confpassFld.setBackground(new java.awt.Color(240, 240, 240));
        confpassFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        confpassFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        confpassFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "CONFIRM PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        confpassFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                confpassFldKeyReleased(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backBtn.setText("<Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        confpassLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(198, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordFld, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confpassFld)
                    .addComponent(confpassLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usernameFld, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(usernameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confpassFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confpassLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        if(!frame.main.sqlite.findUser(usernameFld.getText())){
            //frame.registerAction(usernameFld.getText(), passwordFld.getText(), confpassFld.getText());
            JOptionPane.showMessageDialog(this, "Registration Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearRegisterFields();
            passwordLabel.setText("");
            confpassLabel.setText("");
            registerBtn.setEnabled(false);
            frame.loginNav();
        } else {
            JOptionPane.showMessageDialog(this, "Registration Failed", "Error", JOptionPane.ERROR_MESSAGE);
            clearRegisterFields();
            passwordLabel.setText("");
            confpassLabel.setText("");

//        if(isPassSame()){
//            try {
//                System.out.println("Password:");
//                String encryptedPass = encrypt(passwordFld.getText());
//                System.out.println(encryptedPass);
//                System.out.println(decrypt(encryptedPass));

//                frame.registerAction(usernameFld.getText(), encrypt(passwordFld.getText()), encrypt(confpassFld.getText()));
//                clearRegisterFields();
//                frame.loginNav();
//            } catch (Exception e) { Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, e); }
//        } else {
//            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_registerBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        clearRegisterFields();
        passwordLabel.setText("");
        confpassLabel.setText("");
        registerBtn.setEnabled(false);
        frame.loginNav();
    }//GEN-LAST:event_backBtnActionPerformed

    private void passwordFldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFldKeyReleased
        if(!passwordFld.getText().equals("")) checkPassStrength();
        else passwordLabel.setText("");
        
        if (isPassSame()) {
            if (isUsernameValid()){
                confpassLabel.setText("Passwords MATCH");
                confpassLabel.setForeground(Color.GREEN);
                registerBtn.setEnabled(true);
            } else {
                confpassLabel.setText("Passwords MATCH but username is INVALID");
                confpassLabel.setForeground(Color.RED);
                registerBtn.setEnabled(false);
            }
        } else {
            confpassLabel.setText("Passwords DO NOT MATCH");
            confpassLabel.setForeground(Color.RED);
            registerBtn.setEnabled(false);
        }
    }//GEN-LAST:event_passwordFldKeyReleased

    private void confpassFldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confpassFldKeyReleased
        if(confpassFld.getText().equals("")){
            confpassLabel.setText("");
        } else if (isPassSame() && isUsernameValid()){
            confpassLabel.setText("Passwords MATCH");
            confpassLabel.setForeground(Color.GREEN);
            registerBtn.setEnabled(true);
        } else if (isPassSame() && !isUsernameValid()){
            confpassLabel.setText("Passwords MATCH but username is INVALID");
            confpassLabel.setForeground(Color.RED);
            registerBtn.setEnabled(false);
        }  else{
            confpassLabel.setText("Passwords DO NOT MATCH");
            confpassLabel.setForeground(Color.RED);
            registerBtn.setEnabled(false);
        }
    }//GEN-LAST:event_confpassFldKeyReleased

    private void usernameFldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameFldKeyReleased
        if(!usernameFld.getText().equals("")) isUsernameValid();
        else usernameLabel.setText("");
        
        if (isUsernameValid()) {
            if (!passwordFld.getText().equals("") && isPassSame()){
                confpassLabel.setText("Passwords MATCH");
                confpassLabel.setForeground(Color.GREEN);
                registerBtn.setEnabled(true);
            }
        } else {
            if (!passwordFld.getText().equals("") && isPassSame()){
                confpassLabel.setText("Passwords MATCH but username is INVALID");
                confpassLabel.setForeground(Color.RED);
                registerBtn.setEnabled(false);
            }
        }
    }//GEN-LAST:event_usernameFldKeyReleased
    
    public boolean checkUsernameValidity(String username){
        if(username.length() < 4 || username.length() > 16) return false;
        
        for(int x = 0; x < username.length(); x++){
            if(username.charAt(x) > 31 && username.charAt(x) < 48 || 
                    username.charAt(x) > 57 && username.charAt(x) < 65 || 
                    username.charAt(x) > 90 && username.charAt(x) < 97 || 
                    username.charAt(x) > 122 && username.charAt(x) < 127){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isUsernameValid(){
        if(!checkUsernameValidity(usernameFld.getText())){
            if (usernameFld.getText().length() < 4) usernameLabel.setText("Username BELOW MINIMUM requirement of 4 characters");
            else if (usernameFld.getText().length() > 16) usernameLabel.setText("Username EXCEEDS MAXIMUM of 16 characters");
            else {
                usernameLabel.setText("Username CONTAINS NON-ALPHANUMERIC characters");
            }
            usernameLabel.setForeground(Color.RED);
        } else {
            usernameLabel.setText("");
            return true;
        }
        
        return false;
    }
    
    public int getPassStrength(String password){
        int strength = 0;
        boolean checkLower = false, checkUpper = false, checkSpecial = false, checkNumerical = false;
        
        // Check Length
        if(password.length() < 12 || password.length() > 64) return -1;
        else strength += 1;
        
        // Check Lower Case
        for(int x = 0; x < password.length(); x++){
            if(password.charAt(x) > 96 && password.charAt(x) < 123){
                strength += 1;
                checkLower = true;
                break;
            }
        }
        
        // Check Upper Case
        for(int x = 0; x < password.length(); x++){
            if(password.charAt(x) > 64 && password.charAt(x) < 91){
                strength += 1;
                checkUpper = true;
                break;
            }
        }
        
        // Check Special
        for(int x = 0; x < password.length(); x++){
            if(password.charAt(x) > 31 && password.charAt(x) < 48 || password.charAt(x) > 57 && password.charAt(x) < 65 || password.charAt(x) > 90 && password.charAt(x) < 97 || password.charAt(x) > 122 && password.charAt(x) < 127){
                strength += 1;
                checkSpecial = true;
                break;
            }
        }
        
        // Check Numerical
        for(int x = 0; x < password.length(); x++){
            if(password.charAt(x) > 47 && password.charAt(x) < 58){
                strength += 1;
                checkNumerical = true;
                break;
            }
        }
        
        String hint = "";
        if(!checkLower) hint += "Must at least have 1 LOWER CASE character.<br>";
        if(!checkUpper) hint += "Must at least have 1 UPPER CASE character.<br>";
        if(!checkSpecial) hint += "Must at least have 1 SPECIAL character.<br>";
        if(!checkNumerical) hint += "Must at least have 1 NUMERICAL character.<br><br>";
        
        passwordLabel.setText("<html>" + hint);
        
        return strength;
    }
    
    public void checkPassStrength(){
        int currentStrength = getPassStrength(passwordFld.getText());
        
        if(currentStrength <= 0){
            if (passwordFld.getText().length() < 12)
                passwordLabel.setText("Password BELOW MINIMUM requirement of 12 characters");
            else if(passwordFld.getText().length() > 64)
                passwordLabel.setText("Password EXCEEDS MAXIMUM of 64 characters");
            passwordLabel.setForeground(Color.RED);
        } else if(currentStrength <= 2){
            passwordLabel.setText(passwordLabel.getText() + "Current Password Strength: WEAK</html>");
            passwordLabel.setForeground(Color.RED);
        } else if(currentStrength <= 4){
            passwordLabel.setText(passwordLabel.getText() + "Current Password Strength: MODERATE</html>");
            passwordLabel.setForeground(Color.ORANGE);
        } else if(currentStrength == 5){
            passwordLabel.setText(passwordLabel.getText() + "Current Password Strength: STRONG</html>");
            passwordLabel.setForeground(Color.GREEN);
        }       
    }
    
    public boolean isPassSame(){
        return confpassFld.getText().equals(passwordFld.getText());
    }
    
    private String encrypt(String message) throws Exception {
        return encryption.encryptPassword(message);
    }
    
    private String decrypt(String message) throws Exception {
        return encryption.decryptPassword(message);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField confpassFld;
    private javax.swing.JLabel confpassLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField passwordFld;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField usernameFld;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
