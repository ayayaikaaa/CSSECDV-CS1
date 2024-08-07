package View;

import Controller.SQLite;
import Model.Product;
import Model.User;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author beepxD
 */
public class MgmtProduct extends javax.swing.JPanel {

    public SQLite sqlite;
    public DefaultTableModel tableModel;
    public int role;
    public String userName;
    
    public MgmtProduct(SQLite sqlite) {
        initComponents();
        this.sqlite = sqlite;
        tableModel = (DefaultTableModel)table.getModel();
        table.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));

//        UNCOMMENT TO DISABLE BUTTONS
//        purchaseBtn.setVisible(false);
//        addBtn.setVisible(false);
//        editBtn.setVisible(false);
//        deleteBtn.setVisible(false);
    }

    public void init(){
        //      CLEAR TABLE
        for(int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--){
            tableModel.removeRow(0);
        }
        
//      LOAD CONTENTS
        ArrayList<Product> products = sqlite.getProduct();
        for(int nCtr = 0; nCtr < products.size(); nCtr++){
            tableModel.addRow(new Object[]{
                products.get(nCtr).getName(), 
                products.get(nCtr).getStock(), 
                products.get(nCtr).getPrice()});
        }
    }

    public void setUser(String name){
        this.userName = name;
    }
    
    public void designer(JTextField component, String text){
        component.setSize(70, 600);
        component.setFont(new java.awt.Font("Tahoma", 0, 18));
        component.setBackground(new java.awt.Color(240, 240, 240));
        component.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        component.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), text, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12)));
    }
    
    /** ! TODO !
     * Controls the user privileges 
     * - which functions are available & restricted
     * - helps to manage history logs on purchase
     * 
     * @param userName
     * @param role 1 - Locked/Disabled, 2 - client, 3 - staff, 4 - manager,  5 - admin
     */
    public void setPrivileges(String userName, int role) {
        this.role = role;
        this.userName = userName;

        System.out.println(role);
        
        switch(this.role) {
            case 2:
                addBtn.setVisible(false);
                editBtn.setVisible(false);
                deleteBtn.setVisible(false);
                break;
            case 3:
                addBtn.setVisible(true);
                editBtn.setVisible(true);
                deleteBtn.setVisible(true);
                break;
            case 4:
                addBtn.setVisible(true);
                editBtn.setVisible(true);
                deleteBtn.setVisible(true);
                break;
            case 5:
                addBtn.setVisible(false);
                editBtn.setVisible(false);
                deleteBtn.setVisible(false);
                break;
            default:
                
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        purchaseBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        table.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Stock", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(24);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(1).setMaxWidth(100);
            table.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        purchaseBtn.setBackground(new java.awt.Color(255, 255, 255));
        purchaseBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        purchaseBtn.setText("PURCHASE");
        purchaseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseBtnActionPerformed(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(255, 255, 255));
        addBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addBtn.setText("ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        editBtn.setBackground(new java.awt.Color(255, 255, 255));
        editBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editBtn.setText("EDIT");
        editBtn.setToolTipText("");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(purchaseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(purchaseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void purchaseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            int productStock = Integer.parseInt(tableModel.getValueAt(table.getSelectedRow(), 1).toString());
            String productName = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
            //Product selectedProduct = sqlite.getProduct(productName);
            
            JTextField stockFld = new JTextField(Integer.toString(productStock));
            designer(stockFld, "PRODUCT STOCK");

            Object[] message = {
                "How many " + productName + " do you want to purchase?", stockFld
            };

            int result = JOptionPane.showConfirmDialog(null, message, "PURCHASE PRODUCT", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);

            if (result == JOptionPane.OK_OPTION) {
                System.out.println("Input: " + stockFld.getText());
                
                // Regex - Limit purchase amount to 99 max
                String regex = "^[1-9][0-9]{0,2}$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(stockFld.getText());
                boolean validPurchase = matcher.find();
                
                if (validPurchase) {
                    int purchaseAmt = Integer.parseInt(stockFld.getText());
                    
                    if (productStock - purchaseAmt >= 0) {
                        // Deduct stock in DB
                        sqlite.purchaseProduct(productName, purchaseAmt);
                        // Update history in DB
                        sqlite.addHistory(this.userName, productName, purchaseAmt, new Timestamp(System.currentTimeMillis()).toString());
                        System.out.println("Purchased!");
                        // reload
                        init();
                        
                        JOptionPane.showMessageDialog(this, "Purchased!", "", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        System.out.println("Purchase unsuccessful...");
                        JOptionPane.showMessageDialog(this, "Purchase amount is greater than current stock", "Purchase Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                } else {
                    System.out.println("Invalid Purchase Request.");
                    JOptionPane.showMessageDialog(this, "Only integers greater than 0 are allowed", "Purchase Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_purchaseBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        JTextField nameFld = new JTextField();
        JTextField stockFld = new JTextField();
        JTextField priceFld = new JTextField();

        designer(nameFld, "PRODUCT NAME");
        designer(stockFld, "PRODUCT STOCK");
        designer(priceFld, "PRODUCT PRICE");

        Object[] message = {
            "Insert New Product Details:", nameFld, stockFld, priceFld
        };

        int result = JOptionPane.showConfirmDialog(null, message, "ADD PRODUCT", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);

        if (result == JOptionPane.OK_OPTION) {
            //System.out.println(nameFld.getText());
            //System.out.println(stockFld.getText());
            //System.out.println(priceFld.getText());

            // Regex - Limit purchase amount to 99 max
            String regex = "^[a-zA-Z0-9 ]{3,63}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(nameFld.getText());
            boolean validProduct = matcher.find();

            // Regex - Limit purchase amount to 99 max
            String regex2 = "^[1-9][0-9]*$";
            Pattern pattern2 = Pattern.compile(regex2);
            Matcher matcher2 = pattern2.matcher(stockFld.getText());
            boolean validStock = matcher2.find();

            // Regex - Limit purchase amount to 99 max
            String regex3 = "^[1-9][0-9]*([.]\\d{1,2})?$";
            Pattern pattern3 = Pattern.compile(regex3);
            Matcher matcher3 = pattern3.matcher(priceFld.getText());
            boolean validPrice = matcher3.find();

                if (validProduct == true && validStock == true && validPrice == true) {
                    try{
                    if(Integer.parseInt(stockFld.getText()) > 1000){
                        JOptionPane.showMessageDialog(this, "Invalid stock amount, no greater than 1000", "", JOptionPane.INFORMATION_MESSAGE);
                    }else if(Float.parseFloat(priceFld.getText()) > 100000.00){
                        JOptionPane.showMessageDialog(this, "Invalid price, no greater than 100000", "", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        sqlite.addProduct(nameFld.getText(), Integer.parseInt(stockFld.getText()), Float.parseFloat(priceFld.getText()), this);
                        sqlite.addLogs("ADD", this.userName, "Added " + nameFld.getText() + " to products", new Timestamp(new Date().getTime()).toString());
                        init();
                    }}catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(this, "Invalid stock amount, no greater than 1000", "", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (validProduct == false) {
                    JOptionPane.showMessageDialog(this, "Invalid product name\nOnly alphanumeric characters are allowed\nMinimum of 4 and maximum of 64 characters", "", JOptionPane.INFORMATION_MESSAGE);
                } else if (validStock == false) {
                    JOptionPane.showMessageDialog(this, "Invalid stock amount, only positive integer values allowed", "", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid price, only positive integer or floating point with maximum of 2 decimal places allowed", "", JOptionPane.INFORMATION_MESSAGE);
                }
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            JTextField nameFld = new JTextField(tableModel.getValueAt(table.getSelectedRow(), 0) + "");
            JTextField stockFld = new JTextField(tableModel.getValueAt(table.getSelectedRow(), 1) + "");
            JTextField priceFld = new JTextField(tableModel.getValueAt(table.getSelectedRow(), 2) + "");

            designer(nameFld, "PRODUCT NAME");
            designer(stockFld, "PRODUCT STOCK");
            designer(priceFld, "PRODUCT PRICE");

            Object[] message = {
                "Edit Product Details:", nameFld, stockFld, priceFld
            };

            int id = sqlite.getProductID(nameFld.getText());

            int result = JOptionPane.showConfirmDialog(null, message, "EDIT PRODUCT", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);

            if (result == JOptionPane.OK_OPTION) {
                //System.out.println(nameFld.getText());
                //System.out.println(stockFld.getText());
                //System.out.println(priceFld.getText());

                // Regex - Limit purchase amount to 99 max
                String regex = "^[a-zA-Z0-9 ]{3,63}$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(nameFld.getText());
                boolean validProduct = matcher.find();

                // Regex - Limit purchase amount to 99 max
                String regex2 = "^[1-9][0-9]*$";
                Pattern pattern2 = Pattern.compile(regex2);
                Matcher matcher2 = pattern2.matcher(stockFld.getText());
                boolean validStock = matcher2.find();

                // Regex - Limit purchase amount to 99 max
                String regex3 = "^[1-9][0-9]*([.]\\d{1,2})?$";
                Pattern pattern3 = Pattern.compile(regex3);
                Matcher matcher3 = pattern3.matcher(priceFld.getText());
                boolean validPrice = matcher3.find();

                if (validProduct == true && validStock == true && validPrice == true) {
                    try{
                    if(Integer.parseInt(stockFld.getText()) > 1000){
                        JOptionPane.showMessageDialog(this, "Invalid stock amount, no greater than 1000", "", JOptionPane.INFORMATION_MESSAGE);
                    }else if(Float.parseFloat(priceFld.getText()) > 100000.00){
                        JOptionPane.showMessageDialog(this, "Invalid price, no greater than 100000", "", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        sqlite.editProduct(nameFld.getText(), Integer.parseInt(stockFld.getText()), Float.parseFloat(priceFld.getText()), this, id);
                        sqlite.addLogs("EDIT", this.userName, "Edited product number " + id + " in products", new Timestamp(new Date().getTime()).toString());
                        init();
                    }}catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(this, "Invalid stock amount, no greater than 1000", "", JOptionPane.INFORMATION_MESSAGE);
                    }

                } else if (validProduct == false) {
                    JOptionPane.showMessageDialog(this, "Invalid product name\nOnly alphanumeric characters are allowed\nMinimum of 4 and maximum of 64 characters", "", JOptionPane.INFORMATION_MESSAGE);
                } else if (validStock == false) {
                    JOptionPane.showMessageDialog(this, "Invalid stock amount, only positive integer values allowed", "", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid price, only positive integer or floating point with maximum of 2 decimal places allowed", "", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + tableModel.getValueAt(table.getSelectedRow(), 0) + "?", "DELETE PRODUCT", JOptionPane.YES_NO_OPTION);
            
            if (result == JOptionPane.YES_OPTION) {
                //System.out.println(tableModel.getValueAt(table.getSelectedRow(), 0));
                String name = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
                sqlite.deleteProduct(name);
                sqlite.addLogs("DELETE", this.userName, "Deleted " + name + " from products", new Timestamp(new Date().getTime()).toString());
                init();
                JOptionPane.showMessageDialog(this, "Product Deleted", "", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton purchaseBtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
