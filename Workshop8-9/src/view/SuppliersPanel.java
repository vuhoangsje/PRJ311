
package view;

import java.util.Vector;
import service.*;
import entity.*;
import javax.swing.JOptionPane;
import javax.swing.JSpinner.DefaultEditor;


public class SuppliersPanel extends javax.swing.JPanel {

    TableModel<Supplier> model;
    boolean addNew = true;
    boolean changed = false;
    SupplierService supplierService = new SupplierService();
    ItemService itemService = new ItemService();

    public SuppliersPanel() {
        initComponents();
        String[] headers = {"Code", "Name", "Address", "Colloborating"};
        int[] indexes = {0, 1, 2, 3};
        model = new SupplierTableModel(headers, indexes, (int) spnMaxPage.getValue());
        tblSupplier.setModel(model);
        boxColl.setSelected(false);
        loadData();
        updatePage();
        ((DefaultEditor) spnMaxPage.getEditor()).getTextField().setEditable(false);
    }

    void loadData() {
        try {
            Vector<Supplier> list = supplierService.getAllSupplier();
            for (Supplier sup : list) {
                model.getData().add(sup);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePage() {
        if (model.getMaxPage() == -1) {
            txtPage.setText("1/1");
            btnPreviousPage.setEnabled(false);
            btnNextPage.setEnabled(false);
            return;
        }
        txtPage.setText(String.format("%d/%d", model.getCurrentPage() + 1, model.getMaxPage() + 1));
        if (model.getCurrentPage() == 0) {
            btnPreviousPage.setEnabled(false);
        } else {
            btnPreviousPage.setEnabled(true);
        }
        if (model.getCurrentPage() == model.getMaxPage()) {
            btnNextPage.setEnabled(false);
        } else {
            btnNextPage.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        boxColl = new javax.swing.JCheckBox();
        txtCode = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSupplier = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnPreviousPage = new javax.swing.JButton();
        btnNextPage = new javax.swing.JButton();
        txtPage = new javax.swing.JTextField();
        spnMaxPage = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        javax.swing.JButton btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Supplier Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel1.setText("Code");

        jLabel2.setText("Name");

        jLabel3.setText("Address");

        jLabel4.setText("Colloborating");

        boxColl.setSelected(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName)
                            .addComponent(txtCode)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(boxColl)
                        .addGap(0, 97, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtAddress)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(boxColl))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        tblSupplier.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSupplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSupplier);

        btnPreviousPage.setText("Previous page");
        btnPreviousPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousPageActionPerformed(evt);
            }
        });

        btnNextPage.setText("Next page");
        btnNextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextPageActionPerformed(evt);
            }
        });

        spnMaxPage.setModel(new javax.swing.SpinnerNumberModel(5, 1, 20, 1));
        spnMaxPage.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnMaxPageStateChanged(evt);
            }
        });

        jLabel5.setText("Max row");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPreviousPage)
                .addGap(48, 48, 48)
                .addComponent(txtPage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btnNextPage)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spnMaxPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPreviousPage)
                    .addComponent(btnNextPage)
                    .addComponent(txtPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnMaxPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.setToolTipText("");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRemove)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnSave)
                    .addComponent(btnRemove))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSupplierMouseClicked
        int index = model.getIndex(tblSupplier.getSelectedRow());
        Supplier sup = new Supplier();
        try { // catch out of range (blank row)
            sup = model.getData().get(index);
        } catch (Exception e) {
            btnNewActionPerformed(null);
            return;
        }
        txtCode.setText(sup.getCode());
        txtCode.setEnabled(false);
        txtName.setText(sup.getName());
        txtAddress.setText(sup.getAddress());
        boxColl.setSelected(sup.isColloboration());
        addNew = false;
    }//GEN-LAST:event_tblSupplierMouseClicked

    private void btnNextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextPageActionPerformed
        model.setCurrentPage(model.getCurrentPage() + 1);
        updatePage();
        btnNewActionPerformed(null);
        tblSupplier.updateUI();
    }//GEN-LAST:event_btnNextPageActionPerformed

    private void btnPreviousPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousPageActionPerformed
        model.setCurrentPage(model.getCurrentPage() - 1);
        updatePage();
        btnNewActionPerformed(null);
        tblSupplier.updateUI();
    }//GEN-LAST:event_btnPreviousPageActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        if (addNew) //fix mouse click on blank row then click remove
        {
            return;
        }
        try {
            if (itemService.getQuantiveBySupCode(txtCode.getText()) != 0) {
                JOptionPane.showMessageDialog(this, "Cannot remove while having items belong to");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int r = JOptionPane.showConfirmDialog(this, "Are you sure?", "remove?", JOptionPane.YES_OPTION);
        if (r == JOptionPane.YES_OPTION) {
            try {
                if (supplierService.getSupplierByCode(txtCode.getText()) == null) {
                    JOptionPane.showMessageDialog(this, "Something wrong with database! Please restart program");
                    return;
                }
                supplierService.removeSupplier(txtCode.getText());
                int index = model.getIndex(tblSupplier.getSelectedRow());
                model.getData().remove(index);
                btnNewActionPerformed(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        changed = true;
        updatePage();
        tblSupplier.updateUI();
        btnNewActionPerformed(null);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtCode.setText("");
        txtCode.setEnabled(true);
        txtName.setText("");
        txtAddress.setText("");
        boxColl.setSelected(false);
        addNew = true;
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String code = txtCode.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        boolean colloborating = boxColl.isSelected();
        Supplier sup = new Supplier(code, name, address, colloborating);
        try {
            if (supplierService.getSupplierByCode(code) != null) {
                JOptionPane.showMessageDialog(this, "This code is already exists");
                return;
            }
            if (addNew) {
                supplierService.insertSupplier(sup);
                model.getData().add(sup);
            } else {
                supplierService.updateSupplier(sup);
                int pos = model.getIndex(tblSupplier.getSelectedRow());
                model.getData().set(pos, sup);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        changed = true;
        updatePage();
        tblSupplier.updateUI();
        btnNewActionPerformed(null);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void spnMaxPageStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnMaxPageStateChanged
        model.setMaxRow((int) spnMaxPage.getValue());
        updatePage();
        tblSupplier.updateUI();
    }//GEN-LAST:event_spnMaxPageStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boxColl;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNextPage;
    private javax.swing.JButton btnPreviousPage;
    private javax.swing.JButton btnRemove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnMaxPage;
    private javax.swing.JTable tblSupplier;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPage;
    // End of variables declaration//GEN-END:variables
}
