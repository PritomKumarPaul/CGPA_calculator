package cgpa.calculator;

import cgpa.calculator.Home;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Signup extends javax.swing.JFrame {

    /**
     * Creates new form Signup
     */
    Connection con;

    public Signup() {
        initComponents();
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/student_Info", "pritom", "190204018");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    void update11() {
        try {
            String un = jTextFieldUsername.getText();
            String sql = "INSERT INTO PRITOM.INFO11 (USERNAME) VALUES ('" + un + "')";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void update12() {
        try {
            String un = jTextFieldUsername.getText();
            String sql = "INSERT INTO PRITOM.INFO12 (USERNAME) VALUES ('" + un + "')";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void update21() {
        try {
            String un = jTextFieldUsername.getText();
            String sql = "INSERT INTO PRITOM.INFO21 (USERNAME) VALUES ('" + un + "')";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void update22() {
        try {
            String un = jTextFieldUsername.getText();
            String sql = "INSERT INTO PRITOM.INFO22 (USERNAME) VALUES ('" + un + "')";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void update31() {
        try {
            String un = jTextFieldUsername.getText();
            String sql = "INSERT INTO PRITOM.INFO31 (USERNAME) VALUES ('" + un + "')";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void update32() {
        try {
            String un = jTextFieldUsername.getText();
            String sql = "INSERT INTO PRITOM.INFO32 (USERNAME) VALUES ('" + un + "')";
            Statement st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void update41() {
        try {
            String un = jTextFieldUsername.getText();
            String sql = "INSERT INTO PRITOM.INFO41 (USERNAME) VALUES ('" + un + "')";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void update42() {
        try {
            String un = jTextFieldUsername.getText();
            String sql = "INSERT INTO PRITOM.INFO42 (USERNAME) VALUES ('" + un + "')";
            //String sql = "INSERT INTO PRITOM.INFO42 (USERNAME, CSE1101, CSE1102, CSE1108, HUM1107, HUM1108, PHY1115, PHY1116, MATH1115, CHEM1115, CGPA, INSERTED) VALUES ('" + un + "', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'No')";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabelPassword = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jLabelRe = new javax.swing.JLabel();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jTextFieldUsername = new javax.swing.JTextField();
        jPasswordFieldRe = new javax.swing.JPasswordField();
        jLabelName = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabelHave = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign Up");
        setLocation(new java.awt.Point(700, 300));

        jLabelPassword.setText("Password:");

        jLabelUsername.setText("Username(ID):");

        jLabelRe.setText("Re-Enter Password:");

        jPasswordFieldRe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldReActionPerformed(evt);
            }
        });

        jLabelName.setText("Name:");

        jButton1.setText("Sign up");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelHave.setText("Already have an account?");

        jButton2.setBackground(new java.awt.Color(255, 51, 0));
        jButton2.setText("Click here");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Semester:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1.1", "1.2", "2.1", "2.2", "3.1", "3.2", "4.1", "4.2" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelHave, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelRe, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                        .addComponent(jLabelUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                    .addComponent(jTextFieldUsername)
                                    .addComponent(jPasswordFieldPassword)
                                    .addComponent(jPasswordFieldRe)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jButton1)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordFieldRe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHave, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordFieldReActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldReActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldReActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jTextFieldName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Name can't be empty!", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else if (jTextFieldUsername.getText().length() != 9) {
            JOptionPane.showMessageDialog(null, "Username should be valid student id!", "Error", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldUsername.setText("");
        } else if (jTextFieldUsername.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Username can't be empty!", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else if (jPasswordFieldPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Password can't be empty!", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else if (!(jPasswordFieldPassword.getText().equals(jPasswordFieldRe.getText()))) {
            jPasswordFieldRe.setText("");
            JOptionPane.showMessageDialog(null, "Re-entered password doesn't match!", "Error", JOptionPane.INFORMATION_MESSAGE);
        } 
         else {
            int f=0;
            try {
                int x = Integer.parseInt(jTextFieldUsername.getText());
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(null, "Username should be valid student id!", "Error", JOptionPane.INFORMATION_MESSAGE);
                jTextFieldUsername.setText("");
                f=1;
            }
            if(f==0)
            {
                 try {
                // TODO add your handling code here:
                String username = jTextFieldUsername.getText();
                String sql = "SELECT * FROM PRITOM.STUDENT WHERE USER_NAME = '" + username + "'";
                Statement st = con.createStatement();
                //row = st.executeUpdate(sql);
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Username already exists", "Error", JOptionPane.INFORMATION_MESSAGE);
                    jTextFieldUsername.setText("");

                    //jPasswordFieldPassword.setText("");
                    //jPasswordFieldRe.setText("");
                } else {
                    String un = jTextFieldUsername.getText();
                    String pw = jPasswordFieldPassword.getText();
                    String n = jTextFieldName.getText();
                    String s = jComboBox1.getSelectedItem().toString();
                    sql = "INSERT INTO PRITOM.STUDENT (USER_NAME, PASSWORD, \"NAME\", SEMESTER) VALUES ('" + un + "', '" + pw + "', '" + n + "', '" + s + "')";
                    st = con.createStatement();
                    int row;
                    row = st.executeUpdate(sql);
                    if (s.equals("1.1")) {
                        update11();
                    } else if (s.equals("1.2")) {
                        update11();
                        update12();
                    } else if (s.equals("2.1")) {
                        update11();
                        update12();
                        update21();
                    } else if (s.equals("2.2")) {
                        update11();
                        update12();
                        update21();
                        update22();
                    } else if (s.equals("3.1")) {
                        update11();
                        update12();
                        update21();
                        update22();
                        update31();
                    } else if (s.equals("3.2")) {
                        update11();
                        update12();
                        update21();
                        update22();
                        update31();
                        update32();
                    } else if (s.equals("4.1")) {
                        update11();
                        update12();
                        update21();
                        update22();
                        update31();
                        update32();
                        update41();
                    } else if (s.equals("4.2")) {
                        update11();
                        update12();
                        update21();
                        update22();
                        update31();
                        update32();
                        update41();
                        update42();
                    }
                    JOptionPane.showMessageDialog(null, "Sign up was succesful. Row inserted = " + row, "SignUp", JOptionPane.INFORMATION_MESSAGE);
                    jTextFieldUsername.setText("");
                    jPasswordFieldPassword.setText("");
                    jTextFieldName.setText("");
                    jPasswordFieldRe.setText("");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
                jTextFieldUsername.setText("");
                jPasswordFieldPassword.setText("");
            }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        Home hm = new Home();
        hm.show();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelHave;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelRe;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JPasswordField jPasswordFieldRe;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
