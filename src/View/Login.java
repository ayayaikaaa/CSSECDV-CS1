
package View;

import Controller.SQLite;
import javax.swing.JOptionPane;
import Model.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Login extends javax.swing.JPanel {
    
    private static final long LOCKOUT_DURATION = 60000; // 1 minute in milliseconds
    private static Map<String, Long> lockoutMap = new HashMap<>();
    
    public Frame frame;
    
    public Login() {
        initComponents();
    }
    
    public void clearLoginFields() {
        EMAIL.setText(null);
        passwordFld.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        EMAIL = new javax.swing.JTextField();
        passwordFld = new javax.swing.JPasswordField();
        registerBtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();
        forgotBtn = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(767, 473));
        setMinimumSize(new java.awt.Dimension(767, 473));
        setPreferredSize(new java.awt.Dimension(767, 473));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        EMAIL.setBackground(new java.awt.Color(240, 240, 240));
        EMAIL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EMAIL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EMAIL.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "USERNAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        EMAIL.setMaximumSize(new java.awt.Dimension(64, 45));
        EMAIL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EMAILActionPerformed(evt);
            }
        });
        EMAIL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EMAILKeyReleased(evt);
            }
        });

        passwordFld.setBackground(new java.awt.Color(240, 240, 240));
        passwordFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        passwordFld.setMaximumSize(new java.awt.Dimension(64, 45));
        passwordFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordFldKeyReleased(evt);
            }
        });

        registerBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        registerBtn.setText("REGISTER");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        loginBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        loginBtn.setText("LOGIN");
        loginBtn.setEnabled(false);
        loginBtn.setMaximumSize(new java.awt.Dimension(154, 36));
        loginBtn.setMinimumSize(new java.awt.Dimension(154, 36));
        loginBtn.setPreferredSize(new java.awt.Dimension(154, 36));
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        forgotBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        forgotBtn.setText("FORGOT PASSWORD");
        forgotBtn.setMaximumSize(new java.awt.Dimension(154, 36));
        forgotBtn.setMinimumSize(new java.awt.Dimension(154, 36));
        forgotBtn.setPreferredSize(new java.awt.Dimension(154, 36));
        forgotBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(forgotBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(EMAIL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(138, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(forgotBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        String username = EMAIL.getText();
        String password = new String(passwordFld.getText());

        if (frame.authenticate(username, password)) {
            clearLoginFields();
            SQLite sql = new SQLite();
            frame.mainNav(sql.getUser(username)); // Navigate to main application
        } else {
            // Check if the user is locked out
            ArrayList<User> users = frame.main.sqlite.getUsers();
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    if (user.getRole() == 1) {
                        JOptionPane.showMessageDialog(this, "Account disabled. Contact admin for support.", "Account Disabled", JOptionPane.ERROR_MESSAGE);
                        return;
                    } else if (user.getLocked() == 1) {
                        JOptionPane.showMessageDialog(this, "Account temporarily locked due to multiple incorrect login attempts. Try again later.", "Login Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
            // Handle incorrect login credentials
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        clearLoginFields();
        frame.registerNav();
    }//GEN-LAST:event_registerBtnActionPerformed

    private void forgotBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotBtnActionPerformed
        clearLoginFields();
        frame.emailNav();
    }//GEN-LAST:event_forgotBtnActionPerformed

    private void EMAILActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EMAILActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EMAILActionPerformed

    private void passwordFldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFldKeyReleased
        if(EMAIL.getText().equals("") || passwordFld.getText().equals("")) loginBtn.setEnabled(false);
        else loginBtn.setEnabled(true);
    }//GEN-LAST:event_passwordFldKeyReleased

    private void EMAILKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EMAILKeyReleased
        if(EMAIL.getText().equals("") || passwordFld.getText().equals("")) loginBtn.setEnabled(false);
        else loginBtn.setEnabled(true);
    }//GEN-LAST:event_EMAILKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EMAIL;
    private javax.swing.JButton forgotBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JTextField passwordFld;
    private javax.swing.JButton registerBtn;
    // End of variables declaration//GEN-END:variables
}
