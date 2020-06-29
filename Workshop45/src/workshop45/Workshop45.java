/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop45;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author vuhoa
 */
public class Workshop45 extends JFrame{
    JTree depTree;
    JButton btnDeptNew;
    JButton btnDeptSave;
    JButton btnSaveFile;
    JButton btnDeptRemove;
    JButton btnEmpNew;
    JButton btnEmpSave;
    JButton btnEmpRemove;
    JButton btnExit;
    JPanel paneDept;
    JPanel paneEmp;
    JPanel bottomPanel;
    JPanel infoPanel;
    JTextField txtDeptCode;
    JTextField txtDeptName;
    JTextField txtEmpCode;
    JTextField txtEmpName;
    JTextField txtEmpSalary;
    JLabel lbDeptCode;
    JLabel lbDeptName;
    JLabel lbEmpCode;
    JLabel lbEmpName;
    JLabel lbEmpSalary;
    String fileName = "departments.txt" ;
    DefaultMutableTreeNode root;
    DefaultMutableTreeNode curDeptNode;
    DefaultMutableTreeNode curEmpNode;
    boolean addNewDept = true;
    boolean addNewEmp = true;
    boolean changed = false;
    
    public Workshop45(){
        initComponent();
        root = (DefaultMutableTreeNode) depTree.getModel().getRoot();
        loadData();
        TreePath path = new TreePath(root);
        depTree.expandPath(path);
    }
    void initComponent() {
        depTree = new JTree();
        depTree.setPreferredSize(new Dimension(230,500));
        depTree.setBorder(new TitledBorder("Department tree"));
        DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode("Departments");
        depTree.setModel(new DefaultTreeModel(treeNode));
        depTree.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                depTreeMouseClicked(evt);
            }
        });
        
        lbDeptCode = new JLabel("Code");
        lbDeptCode.setPreferredSize(new Dimension(40,20));
        txtDeptCode = new JTextField();
        txtDeptCode.setPreferredSize(new Dimension(120, 20));
        
        lbDeptName = new JLabel("Name");
        lbDeptName.setPreferredSize(new Dimension(40, 20));
        txtDeptName = new JTextField();
        txtDeptName.setPreferredSize(new Dimension(120, 20));
        
        btnDeptNew = new JButton("New");
        btnDeptNew.setPreferredSize(new Dimension(60, 20));
        btnDeptNew.setMargin(new Insets(0, 0, 0, 0));
        btnDeptNew.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnDeptNewActionPerformed(evt);
            }
        });
        btnDeptSave = new JButton("Save");
        btnDeptSave.setPreferredSize(new Dimension(60, 20));
        btnDeptSave.setMargin(new Insets(0, 0, 0, 0));
        btnDeptSave.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnDeptSaveActionPerformed(evt);
            }
        });
        btnDeptRemove = new JButton("Remove");
        btnDeptRemove.setPreferredSize(new Dimension(60, 20));
        btnDeptRemove.setMargin(new Insets(0, 0, 0, 0));
        btnDeptRemove.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnDeptRemoveActionPerformed(evt);
            }
        });
        
        paneDept = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 30));
        paneDept.setPreferredSize(new Dimension(230,250));
        paneDept.setBorder(new TitledBorder("Department"));
        paneDept.add(lbDeptCode);
        paneDept.add(txtDeptCode);
        paneDept.add(lbDeptName);
        paneDept.add(txtDeptName);
        paneDept.add(btnDeptNew);
        paneDept.add(btnDeptSave);
        paneDept.add(btnDeptRemove);
                
        
        lbEmpCode = new JLabel("Code");
        lbEmpCode.setPreferredSize(new Dimension(40, 20));
        txtEmpCode = new JTextField();
        txtEmpCode.setPreferredSize(new Dimension(120, 20));
        
        lbEmpName = new JLabel("Name");
        lbEmpName.setPreferredSize(new Dimension(40, 20));
        txtEmpName = new JTextField();
        txtEmpName.setPreferredSize(new Dimension(120, 20));
        
        lbEmpSalary = new JLabel("Salary");
        lbEmpSalary.setPreferredSize(new Dimension(40, 20));
        txtEmpSalary = new JTextField();
        txtEmpSalary.setPreferredSize(new Dimension(120, 20));
        
        btnEmpNew = new JButton("New");
        btnEmpNew.setPreferredSize(new Dimension(60, 20));
        btnEmpNew.setMargin(new Insets(0, 0, 0, 0));
        btnEmpNew.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnEmpNewActionPerformed(evt);
            }          
        });
        
        btnEmpSave = new JButton("Save");
        btnEmpSave.setPreferredSize(new Dimension(60, 20));
        btnEmpSave.setMargin(new Insets(0, 0, 0, 0));
        btnEmpSave.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnEmpSaveActionPerformed(evt);
                }  
        });
        
        btnEmpRemove = new JButton("Remove");   
        btnEmpRemove.setPreferredSize(new Dimension(60, 20));
        btnEmpRemove.setMargin(new Insets(0, 0, 0, 0));
        btnEmpRemove.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnEmpRemoveActionPerformed(evt);
            }
        });
        
        paneEmp = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 30));
        paneEmp.setPreferredSize(new Dimension(230, 250));
        paneEmp.setBorder(new TitledBorder("Employees"));
        paneEmp.add(lbEmpCode);
        paneEmp.add(txtEmpCode);
        paneEmp.add(lbEmpName);
        paneEmp.add(txtEmpName);
        paneEmp.add(lbEmpSalary);
        paneEmp.add(txtEmpSalary);
        paneEmp.add(btnEmpNew);
        paneEmp.add(btnEmpSave);
        paneEmp.add(btnEmpRemove);
        
        infoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        infoPanel.setPreferredSize(new Dimension(230, 500));
        infoPanel.add(paneDept);
        infoPanel.add(paneEmp);
        
        btnSaveFile = new JButton("Save file");
        btnSaveFile.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnSaveFileActionPerformed(evt);
            }
        });   
        
        btnExit = new JButton("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        bottomPanel.setPreferredSize(new Dimension(460, 100));
        bottomPanel.add(btnSaveFile);
        bottomPanel.add(btnExit);
        
        
        Container c = getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        c.add(depTree);
        c.add(infoPanel);
        c.add(bottomPanel);
    }
    private void loadData() {
        try {
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                boolean isDept = line.charAt(line.length() - 1) == ':';
                StringTokenizer stk = new StringTokenizer(line, "-:,");
                String code = stk.nextToken();
                String name = stk.nextToken();
                if (isDept) {
                    Departments dept = new Departments(code, name);
                    curDeptNode = new DefaultMutableTreeNode(dept);
                    root.add(curDeptNode);
                } else {
                    int salary = Integer.parseInt(stk.nextToken().trim());
                    Employees emp = new Employees(code, name, salary);
                    curEmpNode = new DefaultMutableTreeNode(emp);
                    curDeptNode.add(curEmpNode);
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void viewDeptAndEmp() {
        Departments curDep = null;
        Employees curEmp = null;
        if (curDeptNode != null) {
            curDep = (Departments) curDeptNode.getUserObject();
            txtDeptCode.setText(curDep.getCode());
            txtDeptName.setText(curDep.getName());

        } else {
            txtDeptCode.setText("");
            txtDeptName.setText("");
        }
        if (curEmpNode != null) {
            curEmp = (Employees) curEmpNode.getUserObject();
            txtEmpCode.setText(curEmp.getCode());
            txtEmpName.setText(curEmp.getName());
            txtEmpSalary.setText(Integer.toString(curEmp.getSalary()));
        } else {
            txtEmpCode.setText("");
            txtEmpName.setText("");
            txtEmpSalary.setText("");
        }
        txtDeptCode.setEditable(false);
        txtEmpCode.setEditable(false);

    }
    private void depTreeMouseClicked(java.awt.event.MouseEvent evt){
        //turn offf the on-tree editing mode
        depTree.cancelEditing();
        TreePath path = depTree.getSelectionPath();
        if (path == null){
            return;
        }
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) (path.getLastPathComponent());
        Object selectedObj = selectedNode.getUserObject();
        if (selectedNode == root){
            this.curDeptNode = this.curEmpNode = null;
        }else {
            if (selectedObj instanceof Departments){
                this.curDeptNode = selectedNode;
                this.curEmpNode = null;
            }else if (selectedObj instanceof Employees) {
                this.curEmpNode = selectedNode;
                curDeptNode = (DefaultMutableTreeNode) (selectedNode.getParent());
                }
        }
        viewDeptAndEmp();
        addNewDept = addNewEmp = false;
    }
    
    
    private void btnDeptNewActionPerformed(java.awt.event.ActionEvent evt){
        addNewDept = true;
        txtDeptCode.setText("");
        txtDeptName.setText("");
        txtEmpCode.setText("");
        txtEmpName.setText("");
        txtEmpSalary.setText("");
        txtDeptCode.setEditable(true);
    }
    private void btnDeptRemoveActionPerformed(java.awt.event.ActionEvent evt){
        if (addNewDept ){
            return;
        }
        if (this.curDeptNode.getChildCount() > 0){
            String msg = "Remove all employee before deleting a department";
            JOptionPane.showMessageDialog(this, msg);
        }else{
            int response = JOptionPane.showConfirmDialog(this, "Are you sure?", "Remove", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION){
                root.remove(this.curDeptNode);
                curDeptNode = curEmpNode = null;
//                btnDeptNewActionPerformed(evt);
                depTree.updateUI();
                changed = true;
            }
        }
    }
    private void btnDeptSaveActionPerformed(java.awt.event.ActionEvent evt){
      String code = txtDeptCode.getText().trim().toUpperCase();
        String name = txtDeptName.getText().trim();
        Departments dept = new Departments();
        try {
            dept.validate(code, name);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }
        if (addNewDept) {
            root.add(new DefaultMutableTreeNode(dept));
        } else {
            Departments oldDept = ((Departments) curDeptNode.getUserObject());
            try {
                oldDept.setName(name);
            } catch (Exception e) {
            }
        }
        btnDeptNewActionPerformed(evt);
        changed = true;
        depTree.updateUI();  
    }
    private void btnEmpNewActionPerformed(ActionEvent evt) {
        addNewEmp = true;
        txtEmpCode.setText("");
        txtEmpName.setText("");
        txtEmpSalary.setText("");
        txtEmpCode.setEditable(true);
    }
    private void btnEmpSaveActionPerformed(ActionEvent evt) {
        String code = txtEmpCode.getText().trim();
        String name = txtEmpName.getText().trim();
        String salary = txtEmpSalary.getText().trim();
        Employees emp = new Employees();
        try {
            emp.validate(code, name, salary);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        if (addNewEmp == true){
            curDeptNode.add(new DefaultMutableTreeNode(emp));
        }else {
            
            Employees oldEmp = ((Employees) curEmpNode.getUserObject());
            try{
                emp.setName(name);
                emp.setSalary(salary);
            }catch (Exception e){
            }
        }
        btnEmpNewActionPerformed(evt);
        depTree.updateUI();
        addNewEmp= false;
        changed = true;
    }
    private void btnEmpRemoveActionPerformed(ActionEvent evt) {
        if (addNewEmp){
            return;
        }
        if (curEmpNode != null){
            int response = JOptionPane.showConfirmDialog(this, "Are you sure?", "Remove employee", JOptionPane.YES_NO_OPTION);
            if(response == JOptionPane.YES_OPTION){
                curDeptNode.remove(curEmpNode);
                curEmpNode = null;
                btnEmpNewActionPerformed(evt);
                depTree.updateUI();
                }
            }
        }
    private void btnSaveFileActionPerformed(ActionEvent evt){
        if(root.getChildCount() == 0){
            return;      
        }
        String s;
        try{
            PrintWriter pr = new PrintWriter(fileName);
            Enumeration depts = root.children();
            while (depts.hasMoreElements()){
                DefaultMutableTreeNode depNode = (DefaultMutableTreeNode)
                        depts.nextElement();
                Departments dept = (Departments)(depNode.getUserObject());
                s = dept.getCode() + "-" + dept.getName() + ":";
                pr.println(s);
                Enumeration emps = depNode.children();
                while (emps.hasMoreElements()){
                    DefaultMutableTreeNode empNode = (DefaultMutableTreeNode) emps.nextElement();
                    Employees emp = (Employees) empNode.getUserObject();
                    s = emp.getCode() + "," + emp.getName() + "," + emp.getSalary();
                    pr.println(s);
                }
            }
            pr.close();
            JOptionPane.showMessageDialog(this, "Saved to the file");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void btnExitActionPerformed(ActionEvent evt) {
        if (changed) {
            int r = JOptionPane.showConfirmDialog(this, "Do you want to save?", "Exit?", JOptionPane.YES_NO_CANCEL_OPTION);
            if (r == JOptionPane.YES_OPTION) {
                btnSaveFileActionPerformed(evt);
                System.exit(0);
            } else if (r == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else {
            int r = JOptionPane.showConfirmDialog(this, "Are you sure?", "Exit?", JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Workshop45 ws = new Workshop45();
                ws.setSize(470,600);
                ws.setDefaultCloseOperation(EXIT_ON_CLOSE);
                ws.setResizable(false);
                ws.setVisible(true);}
        });
        
    }
}
