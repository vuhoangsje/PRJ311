/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import entity.Product;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ProductService;


/**
 *
 * @author natton
 */
public class ProductTable extends javax.swing.JFrame {
    Vector<String> headers = new Vector();
    Vector data = new Vector();
    boolean addNew = true;
    boolean changed = false;
    ProductService productService = new ProductService();
    
    public ProductTable() {
        initComponents();
        headers.add("ID");
        headers.add("Name");
        headers.add("Price");
        loadData();
        DefaultTableModel defaultModel;
        defaultModel = (DefaultTableModel) tblProduct.getModel();
        defaultModel.setDataVector(data, headers);
    }
    
    void loadData() {
        try {
            Vector<Product> list = productService.getAllProdut();
            Collections.sort(list);
            for (Product pro : list) {
                Vector row = new Vector();
                row.add(pro.getID());
                row.add(pro.getName());
                row.add(pro.getPrice());
                data.add(row);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(6, 0, 375, 275);

        jLabel1.setText("Code");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(387, 84, 33, 24);

        jLabel2.setText("Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(387, 126, 36, 24);

        jLabel3.setText("Price");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(387, 162, 30, 26);
        getContentPane().add(txtID);
        txtID.setBounds(444, 84, 160, 24);

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName);
        txtName.setBounds(444, 126, 160, 24);

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        getContentPane().add(txtPrice);
        txtPrice.setBounds(444, 162, 160, 24);

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        getContentPane().add(btnNew);
        btnNew.setBounds(6, 305, 55, 32);

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemove);
        btnRemove.setBounds(534, 305, 76, 32);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave);
        btnSave.setBounds(140, 305, 58, 32);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit);
        btnExit.setBounds(408, 305, 51, 32);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtID.setText("");
        txtID.requestFocus();
        txtName.setText("");
        txtPrice.setText("0");
        addNew = true;
        txtID.setEditable(true);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int ID = Integer.parseInt(txtID.getText());
        String name = txtName.getText();
        float price = Float.parseFloat(txtPrice.getText());
        Product pro = new Product(ID, name, price);
        if(addNew){
            try {
                if (productService.getProductByID(ID) != null) {
                JOptionPane.showMessageDialog(this, "This ID is duplicated");
                return;
                }
                if(ID < 100 || ID > 99999){
                    JOptionPane.showMessageDialog(this, "The product ID is between 3 and 5 digit");
                    return ;
                }
                if (name.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Procduct name cannot blank");
                    return;
                }
                if (price == 0){
                    JOptionPane.showMessageDialog(this, "Price cannot smaller than 0");
                    return;
                }
                Product existedEmp = productService.getProductByID(ID);
                if (existedEmp == null) {
                    productService.insertProduct(pro);
                    Vector row = new Vector();
                    row.add(ID);
                    row.add(name);
                    row.add(price);
                    data.add(row);
                }else {
                    JOptionPane.showMessageDialog(this, "Duplicated code");
                }
            }catch (Exception e){
               e.printStackTrace();
            }
    }
        tblProduct.updateUI();
        changed = true;
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
          
        int r = JOptionPane.showConfirmDialog(this, "Are you sure?",
                                        "remove?", JOptionPane.YES_OPTION);
        if (r == JOptionPane.YES_OPTION) {
            int selectedIndex = tblProduct.getSelectedRow();
            if (selectedIndex >= 0) {
                try {
                    String ID = tblProduct.getValueAt(selectedIndex, 0).toString();
                    productService.removeProduct(ID);
                    data.remove(selectedIndex);
                    tblProduct.updateUI();
                    changed = true;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }        
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        if (changed) {
            int r = JOptionPane.showConfirmDialog(this, "Do you want to save data to file?", "Save to file?", JOptionPane.YES_NO_CANCEL_OPTION);
            if (r == JOptionPane.YES_OPTION) {
                
                System.exit(0);
            } else if (r == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else {
            int r = JOptionPane.showConfirmDialog(this, "Are you sure?", 
                "Exit?", JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        int selectedRow = tblProduct.getSelectedRow();
      
        String ID = tblProduct.getValueAt(selectedRow, 0).toString();
        String name = tblProduct.getValueAt(selectedRow, 1).toString();
        String price = tblProduct.getValueAt(selectedRow, 2).toString();
        System.out.println(ID);
        txtID.setText(ID);
        txtName.setText(name);
        txtPrice.setText(price);
        txtID.setEditable(false);
        addNew = false;
    }//GEN-LAST:event_tblProductMouseClicked

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                ProductTable e = new ProductTable();
                e.setSize(650,399);
                e.setVisible(true);
                //new ProductTable().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
