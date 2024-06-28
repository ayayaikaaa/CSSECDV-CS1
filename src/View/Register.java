package View;


import Controller.SQLite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Model.User;

public class Register extends javax.swing.JPanel {

    static int strength = 0;
    static boolean usernameValid = false;
    public Frame frame;
    public SQLite sqlite;
    
    public Register() {
        initComponents();
    }
    
    public boolean isPassSame(){
        return passwordFld.getText().equals(confpassFld.getText());
    }

    public void clearRegisterFields() {
        usernameFld.setText(null);
        passwordFld.setText(null);
        confpassFld.setText(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sqlite = new SQLite();

        registerBtn = new javax.swing.JButton();
        passwordFld = new javax.swing.JPasswordField();
        usernameFld = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        confpassFld = new javax.swing.JPasswordField();
        backBtn = new javax.swing.JButton();
        passwordLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        confirmLabel = new javax.swing.JLabel();

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

        passwordFld.addKeyListener(new KeyListener() {


            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                strength = 0;
                String password = passwordFld.getText();

                strength = strength + checkLength(password);
                strength = strength + checkLowerCase(password);
                strength = strength + checkUpperCase(password);
                strength = strength + checkSpecial(password);
                strength = strength + checkNumerical(password);

                if(strength <= 0){
                    passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                    passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    passwordLabel.setText("PASSWORD EXCEEDS MAXIMUM 64 CHARACTERS OR IS BELOW 12 CHARACTERS");
                    passwordLabel.setToolTipText("");
                    passwordLabel.setForeground(Color.red);
                    registerBtn.setEnabled(false);
                }
                else if(strength <= 2){
                    passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                    passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    passwordLabel.setText("PASSWORD STRENGTH: WEAK");
                    passwordLabel.setToolTipText("");
                    passwordLabel.setForeground(Color.red);
                    registerBtn.setEnabled(false);
                }else if(strength <= 4){
                    passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                    passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    passwordLabel.setText("PASSWORD STRENGTH: MODERATE");
                    passwordLabel.setToolTipText("");
                    passwordLabel.setForeground(Color.yellow);
                    registerBtn.setEnabled(false);
                }else if(strength == 5 && usernameValid == true && confpassFld.getText().equals(passwordFld.getText())){
                    passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                    passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    passwordLabel.setText("PASSWORD STRENGTH: STRONG");
                    passwordLabel.setToolTipText("");
                    passwordLabel.setForeground(Color.green);
                    confirmLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                    confirmLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    confirmLabel.setText("");
                    confirmLabel.setToolTipText("");
                    confirmLabel.setForeground(Color.red);
                    registerBtn.setEnabled(true);
                }else if(strength == 5 && !confpassFld.getText().equals(passwordFld.getText())){
                    passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                    passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    passwordLabel.setText("PASSWORD STRENGTH: STRONG");
                    passwordLabel.setToolTipText("");
                    passwordLabel.setForeground(Color.green);
                    confirmLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                    confirmLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    confirmLabel.setText("PASSWORDS DO NOT MATCH");
                    confirmLabel.setToolTipText("");
                    confirmLabel.setForeground(Color.red);
                    registerBtn.setEnabled(false);
                }else{
                    passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                    passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    passwordLabel.setText("PASSWORD STRENGTH: STRONG");
                    passwordLabel.setToolTipText("");
                    passwordLabel.setForeground(Color.green);
                    confirmLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                    confirmLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    confirmLabel.setText("");
                    confirmLabel.setToolTipText("");
                    confirmLabel.setForeground(Color.red);
                    registerBtn.setEnabled(false);

                }
            }

        });

        usernameFld.setBackground(new java.awt.Color(240, 240, 240));
        usernameFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usernameFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "USERNAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        usernameFld.addKeyListener(new KeyListener() {


            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String name = usernameFld.getText();

                if (checkLengthName(name) == false) {
                    usernameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                    usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    usernameLabel.setText("USERNAME SHOULD BE AT LEAST 4 CHARACTERS LONG AND NOT EXCEED 16 CHARACTERS");
                    usernameLabel.setToolTipText("");
                    usernameLabel.setForeground(Color.red);
                    registerBtn.setEnabled(false);
                    usernameValid = false;
                }else if(checkAllowedChar(name) == false){
                    usernameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                    usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    usernameLabel.setText("ONLY ALPHABETICAL AND NUMERICAL CHARACTERS ALLOWED");
                    usernameLabel.setToolTipText("");
                    usernameLabel.setForeground(Color.red);
                    registerBtn.setEnabled(false);
                    usernameValid = false;
                }else if(strength == 5 && confpassFld.getText().equals(passwordFld.getText())){
                    usernameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                    usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    usernameLabel.setText("");
                    usernameLabel.setToolTipText("");
                    usernameLabel.setForeground(Color.black);
                    registerBtn.setEnabled(true);
                    usernameValid = true;
                }else{
                    usernameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                    usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    usernameLabel.setText("");
                    usernameLabel.setToolTipText("");
                    usernameLabel.setForeground(Color.black);
                    registerBtn.setEnabled(false);
                    usernameValid = true;
                }
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

        confpassFld.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(confpassFld.getText().equals(passwordFld.getText()) && usernameValid == true && strength == 5){
                    confirmLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                    confirmLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    confirmLabel.setText("");
                    confirmLabel.setToolTipText("");
                    confirmLabel.setForeground(Color.black);
                    registerBtn.setEnabled(true);
                } else if(confpassFld.getText().equals(passwordFld.getText())) {
                    confirmLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                    confirmLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    confirmLabel.setText("");
                    confirmLabel.setToolTipText("");
                    confirmLabel.setForeground(Color.black);
                    registerBtn.setEnabled(false);
                }else{
                    confirmLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                    confirmLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    confirmLabel.setText("PASSWORDS DO NOT MATCH");
                    confirmLabel.setToolTipText("");
                    confirmLabel.setForeground(Color.red);
                    registerBtn.setEnabled(false);
                }
            }
        });

        backBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backBtn.setText("<Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(200, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(usernameFld)
                                        .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(passwordFld, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(confirmLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(confpassFld, javax.swing.GroupLayout.Alignment.LEADING))
                                .addContainerGap(200, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backBtn)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backBtn)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(usernameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(passwordFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(confpassFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(confirmLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        if(sqlite.findUser(usernameFld.getText().toLowerCase()) == false) {
            frame.registerAction(usernameFld.getText().toLowerCase(), passwordFld.getText(), confpassFld.getText());
            frame.loginNav();
        }else{
            usernameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            usernameLabel.setText("USERNAME ALREADY EXISTS");
            usernameLabel.setToolTipText("");
            usernameLabel.setForeground(Color.red);
        }
    }//GEN-LAST:event_registerBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        clearRegisterFields();
        frame.loginNav();
    }//GEN-LAST:event_backBtnActionPerformed

    public int checkLength(String password){
        if(password.length() < 12){
            return -1000;
        }else if(password.length() > 64){
            return -1000;
        }else{
            return 1;
        }
    }

    public int checkLowerCase(String password){
        for(int x = 0; x < password.length(); x++){
            if(password.charAt(x) > 96 && password.charAt(x) < 123){
                return 1;
            }
        }
        return 0;
    }

    public int checkUpperCase(String password){
        for(int x = 0; x < password.length(); x++){
            if(password.charAt(x) > 64 && password.charAt(x) < 91){
                return 1;
            }
        }
        return 0;
    }

    public int checkSpecial(String password){
        for(int x = 0; x < password.length(); x++){
            if(password.charAt(x) > 31 && password.charAt(x) < 48 || password.charAt(x) > 57 && password.charAt(x) < 65 || password.charAt(x) > 90 && password.charAt(x) < 97 || password.charAt(x) > 122 && password.charAt(x) < 127){
                return 1;
            }
        }
        return 0;
    }

    public int checkNumerical(String password){
        for(int x = 0; x < password.length(); x++){
            if(password.charAt(x) > 47 && password.charAt(x) < 58){
                return 1;
            }
        }
        return 0;
    }

    public boolean checkLengthName(String name){
        if(name.length() < 4){
            return false;
        }else if(name.length() > 16){
            return false;
        }else{
            return true;
        }
    }

    public boolean checkAllowedChar(String name){
        for(int x = 0; x < name.length(); x++){
            if(name.charAt(x) > 31 && name.charAt(x) < 48 || name.charAt(x) > 57 && name.charAt(x) < 65 || name.charAt(x) > 90 && name.charAt(x) < 97 || name.charAt(x) > 122 && name.charAt(x) < 127){
                return false;
            }
        }
        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField confpassFld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField passwordFld;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField usernameFld;
    // End of variables declaration//GEN-END:variables

    private javax.swing.JLabel passwordLabel;

    private javax.swing.JLabel usernameLabel;

    private javax.swing.JLabel confirmLabel;
}
