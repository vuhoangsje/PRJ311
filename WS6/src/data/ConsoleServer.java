/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.ServerSocket;
import java.net.Socket;



/**
 *
 * @author vuhoa
 */
public class ConsoleServer extends javax.swing.JFrame implements  Runnable{
    ServerSocket srvSocket = null;
    BufferedReader br = null;
    Thread t;
    
    public ConsoleServer() {
        initComponents();
        this.setSize(600,300);
        int serverPort = Integer.parseInt(txtServerPort.getText());
        try {
            srvSocket = new ServerSocket(serverPort);
            this.lbMessage.setText("Mng. Server is running at the port");
        } catch (Exception e) {
        }
        t = new Thread (this);
        t.start();
    }   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ServerPanel = new javax.swing.JPanel();
        lbMessage = new javax.swing.JLabel();
        txtServerPort = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ServerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Sever Manager"));

        lbMessage.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lbMessage.setText("Port at:");

        txtServerPort.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        txtServerPort.setText("12340");
        txtServerPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServerPortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ServerPanelLayout = new javax.swing.GroupLayout(ServerPanel);
        ServerPanel.setLayout(ServerPanelLayout);
        ServerPanelLayout.setHorizontalGroup(
            ServerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServerPanelLayout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(txtServerPort, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addGap(184, 184, 184))
        );
        ServerPanelLayout.setVerticalGroup(
            ServerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServerPanelLayout.createSequentialGroup()
                .addGroup(ServerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtServerPort, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(lbMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1)
                    .addComponent(ServerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ServerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtServerPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServerPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServerPortActionPerformed

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
            java.util.logging.Logger.getLogger(ConsoleServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsoleServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsoleServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsoleServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsoleServer().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ServerPanel;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JTextField txtServerPort;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while(true){
            try {
                Socket aStaffSocket = srvSocket.accept();
                if (aStaffSocket != null) {
                    br = new BufferedReader(new InputStreamReader
                                            (aStaffSocket.getInputStream()));
                    String s = br.readLine();
                    int pos = s.indexOf(":");
                    String staffName = s.substring(pos + 1);
                    ChatPanel p = new ChatPanel(aStaffSocket, "Manager", staffName);
                    jTabbedPane1.add(staffName, p);
                    p.updateUI();
                }
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
