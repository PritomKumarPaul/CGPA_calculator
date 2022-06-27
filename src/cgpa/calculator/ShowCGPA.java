/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgpa.calculator;

/**
 *
 * @author User
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ShowCGPA extends javax.swing.JFrame {

    Connection con;

    /**
     * Creates new form ShowCGPA
     */
    public ShowCGPA() {
        initComponents();
    }

    public ShowCGPA(String username) {
        initComponents();
        jLabel3.setText(username);
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/student_Info", "pritom", "190204018");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);

        }
        try {
            // TODO add your handling code here:
            String sql = "SELECT * FROM PRITOM.STUDENT WHERE USER_NAME = '" + jLabel3.getText() + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String x = rs.getString("SEMESTER");
                if (x.equals("1.1")) {
                    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1.1"}));

                } else if (x.equals("1.2")) {
                    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1.1", "1.2"}));

                } else if (x.equals("2.1")) {
                    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1.1", "1.2", "2.1"}));

                } else if (x.equals("2.2")) {
                    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1.1", "1.2", "2.1", "2.2"}));

                } else if (x.equals("3.1")) {
                    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1.1", "1.2", "2.1", "2.2", "3.1"}));

                } else if (x.equals("3.2")) {
                    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1.1", "1.2", "2.1", "2.2", "3.1", "3.2"}));

                } else if (x.equals("4.1")) {
                    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1.1", "1.2", "2.1", "2.2", "3.1", "3.2", "4.1"}));

                } else if (x.equals("4.2")) {
                    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1.1", "1.2", "2.1", "2.2", "3.1", "3.2", "4.1", "4.2"}));

                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Wrong Username or Password", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        try {
            // TODO add your handling code here:
            String un = jLabel3.getText();
            String sqlx = "SELECT * FROM PRITOM.STUDENT WHERE USER_NAME = '" + un + "'";
            Statement stx = con.createStatement();
            ResultSet rsx = stx.executeQuery(sqlx);
            rsx.next();
            double cgpa=0;
            double s=0;
            String s11 = rsx.getString("GPA11");
            String s12 = rsx.getString("GPA12");
            String s21 = rsx.getString("GPA21");
            String s22 = rsx.getString("GPA22");
            String s31 = rsx.getString("GPA31");
            String s32 = rsx.getString("GPA32");
            String s41 = rsx.getString("GPA41");
            String s42 = rsx.getString("GPA42");
            if(s11 != null)
            {
                cgpa=(cgpa*s)+(Double.parseDouble(s11)*20.25)/(s+20.25);
                s=s+20.25;
                System.out.println(cgpa);
            }
            if(s12!=(null))
            {
                cgpa=((cgpa*s)+(Double.parseDouble(s12)*20.25))/(s+20.25);
                s=s+20.25;
                System.out.println(cgpa);
            }
            if(s21!=(null))
            {
                cgpa=((cgpa*s)+(Double.parseDouble(s21)*20.25))/(s+20.25);
                s=s+20.25;
                System.out.println(cgpa);
            }
            if(s22!=(null))
            {
                cgpa=((cgpa*s)+(Double.parseDouble(s22)*20.25))/(s+20.25);
                s=s+20.25;
                System.out.println(cgpa);
            }
            if(s31!=(null))
            {
                cgpa=((cgpa*s)+(Double.parseDouble(s31)*18.75))/(s+18.75);
                s=s+18.75;
                System.out.println(cgpa);
            }
            if(s32!=(null))
            {
                cgpa=((cgpa*s)+(Double.parseDouble(s32)*18.75))/(s+18.75);
                s=s+18.75;
                System.out.println(cgpa);
            }
            if(s41!=(null))
            {
                cgpa=((cgpa*s)+(Double.parseDouble(s41)*18.75))/(s+18.75);
                s=s+18.75;
                System.out.println(cgpa);
            }
            if(s42!=(null))
            {
                cgpa=((cgpa*s)+(Double.parseDouble(s42)*18))/(s+18);
                s=s+18;
                System.out.println(cgpa);
            }
            jCGO.setText(String.format("%.4f", cgpa));
            
            //if(rsx.getString(""))
            sqlx = "UPDATE PRITOM.STUDENT SET \"CGPA\" = " + cgpa + " WHERE USER_NAME = '" + username + "'";
            stx = con.createStatement();
            stx.executeUpdate(sqlx);
            sqlx = "UPDATE PRITOM.STUDENT SET \"CREDIT\" = " + s + " WHERE USER_NAME = '" + username + "'";
            stx = con.createStatement();
            stx.executeUpdate(sqlx);
            String sql = "SELECT * FROM PRITOM.INFO11 WHERE USERNAME = '" + un + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String in = rs.getString("INSERTED");
                if (in == null) {
                    JOptionPane.showMessageDialog(null, "No records inserted", "1.1 INFO", JOptionPane.INFORMATION_MESSAGE);
                    jLabelSub1.setText("CSE1101");
                    jLabelGrade1.setText("No data");
                    jLabelSub2.setText("CSE1102");
                    jLabelGrade2.setText("No data");
                    jLabelSub3.setText("CSE1108");
                    jLabelGrade3.setText("No data");
                    jLabelSub4.setText("PHY1115");
                    jLabelGrade4.setText("No data");
                    jLabelSub5.setText("PHY1116");
                    jLabelGrade5.setText("No data");
                    jLabelSub6.setText("MATH1115");
                    jLabelGrade6.setText("No data");
                    jLabelSub7.setText("CHEM1115");
                    jLabelGrade7.setText("No data");
                    jLabelSub8.setText("HUM1107");
                    jLabelGrade8.setText("No data");
                    jLabelSub9.setText("HUM1108");
                    jLabelGrade9.setText("No data");
                    jLabelSub10.setText("");
                    jLabelGrade10.setText("");
                    jLabelGPA.setText("GPA");
                    jLabelCG.setText("Not inserted");
                } else {
                    jLabelSub1.setText("CSE1101");
                    jLabelGrade1.setText(rs.getString("CSE1101"));
                    jLabelSub2.setText("CSE1102");
                    jLabelGrade2.setText(rs.getString("CSE1102"));
                    jLabelSub3.setText("CSE1108");
                    jLabelGrade3.setText(rs.getString("CSE1108"));
                    jLabelSub4.setText("PHY1115");
                    jLabelGrade4.setText(rs.getString("PHY1115"));
                    jLabelSub5.setText("PHY1116");
                    jLabelGrade5.setText(rs.getString("PHY1116"));
                    jLabelSub6.setText("MATH1115");
                    jLabelGrade6.setText(rs.getString("MATH1115"));
                    jLabelSub7.setText("CHEM1115");
                    jLabelGrade7.setText(rs.getString("CHEM1115"));
                    jLabelSub8.setText("HUM1107");
                    jLabelGrade8.setText(rs.getString("HUM1107"));
                    jLabelSub9.setText("HUM1108");
                    jLabelGrade9.setText(rs.getString("HUM1108"));
                    jLabelSub10.setText("");
                    jLabelGrade10.setText("");
                    jLabelGPA.setText("GPA");
                    jLabelCG.setText(rs.getString("CGPA"));
                    JOptionPane.showMessageDialog(null, "Data found", "Error", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
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

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabelSub1 = new javax.swing.JLabel();
        jLabelSub2 = new javax.swing.JLabel();
        jLabelSub3 = new javax.swing.JLabel();
        jLabelSub4 = new javax.swing.JLabel();
        jLabelSub5 = new javax.swing.JLabel();
        jLabelSub6 = new javax.swing.JLabel();
        jLabelSub7 = new javax.swing.JLabel();
        jLabelSub8 = new javax.swing.JLabel();
        jLabelSub9 = new javax.swing.JLabel();
        jLabelSub10 = new javax.swing.JLabel();
        jLabelGrade1 = new javax.swing.JLabel();
        jLabelGrade2 = new javax.swing.JLabel();
        jLabelGrade3 = new javax.swing.JLabel();
        jLabelGrade4 = new javax.swing.JLabel();
        jLabelGrade5 = new javax.swing.JLabel();
        jLabelGrade6 = new javax.swing.JLabel();
        jLabelGrade7 = new javax.swing.JLabel();
        jLabelGrade8 = new javax.swing.JLabel();
        jLabelGrade9 = new javax.swing.JLabel();
        jLabelGrade10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelGPA = new javax.swing.JLabel();
        jLabelCG = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelCGPA = new javax.swing.JLabel();
        jCGO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Show Result");
        setLocation(new java.awt.Point(700, 300));

        jLabel1.setText("Select Semester:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1.1", "1.2", "2.1", "2.2", "3.1", "3.2", "4.1", "4.2" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabelSub1.setText("1");

        jLabelSub2.setText("1");

        jLabelSub3.setText("1");

        jLabelSub4.setText("1");

        jLabelSub5.setText("1");

        jLabelSub6.setText("1");

        jLabelSub7.setText("1");

        jLabelSub8.setText("1");

        jLabelSub9.setText("1");

        jLabelSub10.setText("1");

        jLabelGrade1.setText("A+");

        jLabelGrade2.setText("A+");

        jLabelGrade3.setText("A+");

        jLabelGrade4.setText("A+");

        jLabelGrade5.setText("A+");

        jLabelGrade6.setText("A+");

        jLabelGrade7.setText("A+");

        jLabelGrade8.setText("A+");

        jLabelGrade9.setText("A+");

        jLabelGrade10.setText("A+");

        jLabel3.setText("Usename");

        jLabelGPA.setText("GPA");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelCGPA.setText("CGPA:");

        jCGO.setText("4.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelSub1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabelSub2, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                        .addComponent(jLabelSub3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelSub4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelSub5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelSub6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelSub7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelSub8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelSub9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelSub10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(73, 73, 73)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabelGrade1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                        .addComponent(jLabelGrade2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelGrade3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelGrade4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelGrade5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelGrade6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelGrade7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelGrade8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelGrade9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelGrade10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelGPA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelCGPA, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCGO, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCG, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSub1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGrade1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSub2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGrade2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSub3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGrade3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSub4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGrade4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSub5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGrade5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSub6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGrade6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSub7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGrade7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSub8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGrade8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSub9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGrade9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSub10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGrade10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelGPA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelCGPA, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCGO, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:

        if (jComboBox1.getSelectedItem().toString().equals("1.1")) {
            try {
                // TODO add your handling code here:
                String username = jLabel3.getText();
                String sql = "SELECT * FROM PRITOM.INFO11 WHERE USERNAME = '" + username + "'";
                Statement st = con.createStatement();
                //row = st.executeUpdate(sql);
                ResultSet rs = st.executeQuery(sql);
                //System.out.println(row);
                rs.next();
                String ins = rs.getString("INSERTED");
                if (ins == null) {
                    jLabelSub1.setText("CSE1101");
                    jLabelGrade1.setText("Not inserted");
                    jLabelSub2.setText("CSE1102");
                    jLabelGrade2.setText("Not inserted");
                    jLabelSub3.setText("CSE1108");
                    jLabelGrade3.setText("Not inserted");
                    jLabelSub4.setText("PHY1115");
                    jLabelGrade4.setText("Not inserted");
                    jLabelSub5.setText("PHY1116");
                    jLabelGrade5.setText("Not inserted");
                    jLabelSub6.setText("MATH1115");
                    jLabelGrade6.setText("Not inserted");
                    jLabelSub7.setText("CHEM1115");
                    jLabelGrade7.setText("Not inserted");
                    jLabelSub8.setText("HUM1107");
                    jLabelGrade8.setText("Not inserted");
                    jLabelSub9.setText("HUM1108");
                    jLabelGrade9.setText("Not inserted");
                    jLabelSub10.setText("");
                    jLabelGrade10.setText("");
                    jLabelGPA.setText("GPA");
                    jLabelCG.setText("Not inserted");
                    JOptionPane.showMessageDialog(null, "No records inserted", "Error", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "DATA FOUND", "1.1 INFO", JOptionPane.INFORMATION_MESSAGE);
                    jLabelSub1.setText("CSE1101");
                    jLabelGrade1.setText(rs.getString("CSE1101"));
                    jLabelSub2.setText("CSE1102");
                    jLabelGrade2.setText(rs.getString("CSE1102"));
                    jLabelSub3.setText("CSE1108");
                    jLabelGrade3.setText(rs.getString("CSE1108"));
                    jLabelSub4.setText("PHY1115");
                    jLabelGrade4.setText(rs.getString("PHY1115"));
                    jLabelSub5.setText("PHY1116");
                    jLabelGrade5.setText(rs.getString("PHY1116"));
                    jLabelSub6.setText("MATH1115");
                    jLabelGrade6.setText(rs.getString("MATH1115"));
                    jLabelSub7.setText("CHEM1115");
                    jLabelGrade7.setText(rs.getString("CHEM1115"));
                    jLabelSub8.setText("HUM1107");
                    jLabelGrade8.setText(rs.getString("HUM1107"));
                    jLabelSub9.setText("HUM1108");
                    jLabelGrade9.setText(rs.getString("HUM1108"));
                    jLabelSub10.setText("");
                    jLabelGrade10.setText("");
                    jLabelGPA.setText("GPA");
                    jLabelCG.setText(rs.getString("CGPA"));

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (jComboBox1.getSelectedItem().toString().equals("1.2")) {
            try {
                // TODO add your handling code here:
                String username = jLabel3.getText();
                String sql = "SELECT * FROM PRITOM.INFO12 WHERE USERNAME = '" + username + "'";
                Statement st = con.createStatement();
                //row = st.executeUpdate(sql);
                ResultSet rs = st.executeQuery(sql);
                //System.out.println(row);
                rs.next();
                String ins = rs.getString("INSERTED");
                if (ins == null) {

                    jLabelSub1.setText("CSE1203");
                    jLabelGrade1.setText("Not inserted");
                    jLabelSub2.setText("CSE1205");
                    jLabelGrade2.setText("Not inserted");
                    jLabelSub3.setText("CSE1241");
                    jLabelGrade3.setText("Not inserted");
                    jLabelSub4.setText("CSE1219");
                    jLabelGrade4.setText("Not inserted");
                    jLabelSub5.setText("ME1211");
                    jLabelGrade5.setText("Not inserted");
                    jLabelSub6.setText("CSE1200");
                    jLabelGrade6.setText("Not inserted");
                    jLabelSub7.setText("CSE1206");
                    jLabelGrade7.setText("Not inserted");
                    jLabelSub8.setText("EEE1242");
                    jLabelGrade8.setText("Not inserted");
                    jLabelSub9.setText("ME1214");
                    jLabelGrade9.setText("Not inserted");
                    jLabelSub10.setText("");
                    jLabelGrade10.setText("");
                    jLabelGPA.setText("GPA");
                    jLabelCG.setText("Not inserted");
                    JOptionPane.showMessageDialog(null, "No records inserted", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "DATA FOUND", "1.2 INFO", JOptionPane.INFORMATION_MESSAGE);
                    jLabelSub1.setText("CSE1203");
                    jLabelGrade1.setText(rs.getString("CSE1203"));
                    jLabelSub2.setText("CSE1205");
                    jLabelGrade2.setText(rs.getString("CSE1205"));
                    jLabelSub3.setText("EEE1241");
                    jLabelGrade3.setText(rs.getString("EEE1241"));
                    jLabelSub4.setText("MATH1219");
                    jLabelGrade4.setText(rs.getString("MATH1219"));
                    jLabelSub5.setText("ME1211");
                    jLabelGrade5.setText(rs.getString("ME1211"));
                    jLabelSub6.setText("CSE1200");
                    jLabelGrade6.setText(rs.getString("CSE1200"));
                    jLabelSub7.setText("CSE1206");
                    jLabelGrade7.setText(rs.getString("CSE1206"));
                    jLabelSub8.setText("EEE1242");
                    jLabelGrade8.setText(rs.getString("EEE1242"));
                    jLabelSub9.setText("ME1214");
                    jLabelGrade9.setText(rs.getString("ME1214"));
                    jLabelSub10.setText("");
                    jLabelGrade10.setText("");
                    jLabelGPA.setText("GPA");
                    jLabelCG.setText(rs.getString("CGPA"));
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (jComboBox1.getSelectedItem().toString().equals("2.1")) {
            try {
                // TODO add your handling code here:
                String username = jLabel3.getText();
                String sql = "SELECT * FROM PRITOM.INFO21 WHERE USERNAME = '" + username + "'";
                Statement st = con.createStatement();
                //row = st.executeUpdate(sql);
                ResultSet rs = st.executeQuery(sql);
                //System.out.println(row);
                rs.next();
                String ins = rs.getString("INSERTED");
                if (ins == null) {

                    jLabelSub1.setText("CSE2100");
                    jLabelGrade1.setText("Not inserted");
                    jLabelSub2.setText("CSE2103");
                    jLabelGrade2.setText("Not inserted");
                    jLabelSub3.setText("CSE2104");
                    jLabelGrade3.setText("Not inserted");
                    jLabelSub4.setText("CSE2105");
                    jLabelGrade4.setText("Not inserted");
                    jLabelSub5.setText("CSE2106");
                    jLabelGrade5.setText("Not inserted");
                    jLabelSub6.setText("EEE2142");
                    jLabelGrade6.setText("Not inserted");
                    jLabelSub7.setText("EEE2141");
                    jLabelGrade7.setText("Not inserted");
                    jLabelSub8.setText("HUM2109");
                    jLabelGrade8.setText("Not inserted");
                    jLabelSub9.setText("MATH2101");
                    jLabelGrade9.setText("Not inserted");
                    jLabelSub10.setText("");
                    jLabelGrade10.setText("");
                    jLabelGPA.setText("GPA");
                    jLabelCG.setText("Not inserted");
                    JOptionPane.showMessageDialog(null, "No records inserted", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else {

                    JOptionPane.showMessageDialog(null, "DATA FOUND", "2.1 INFO", JOptionPane.INFORMATION_MESSAGE);
                    jLabelSub1.setText("CSE2100");
                    jLabelGrade1.setText(rs.getString("CSE2100"));
                    jLabelSub2.setText("CSE2103");
                    jLabelGrade2.setText(rs.getString("CSE2103"));
                    jLabelSub3.setText("CSE2104");
                    jLabelGrade3.setText(rs.getString("CSE2104"));
                    jLabelSub4.setText("CSE2105");
                    jLabelGrade4.setText(rs.getString("CSE2105"));
                    jLabelSub5.setText("CSE2106");
                    jLabelGrade5.setText(rs.getString("CSE2106"));
                    jLabelSub6.setText("EEE2142");
                    jLabelGrade6.setText(rs.getString("EEE2142"));
                    jLabelSub7.setText("EEE2141");
                    jLabelGrade7.setText(rs.getString("EEE2142"));
                    jLabelSub8.setText("HUM2109");
                    jLabelGrade8.setText(rs.getString("HUM2109"));
                    jLabelSub9.setText("MATH2101");
                    jLabelGrade9.setText(rs.getString("MATH2101"));
                    jLabelSub10.setText("");
                    jLabelGrade10.setText("");
                    jLabelGPA.setText("GPA");
                    jLabelCG.setText(rs.getString("CGPA"));
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (jComboBox1.getSelectedItem().toString().equals("2.2")) {
            try {
                // TODO add your handling code here:
                String username = jLabel3.getText();
                String sql = "SELECT * FROM PRITOM.INFO22 WHERE USERNAME = '" + username + "'";
                Statement st = con.createStatement();
                //row = st.executeUpdate(sql);
                ResultSet rs = st.executeQuery(sql);
                //System.out.println(row);
                rs.next();
                String ins = rs.getString("INSERTED");
                if (ins == null) {
                    jLabelSub1.setText("CSE2201");
                    jLabelGrade1.setText("Not inserted");
                    jLabelSub2.setText("CSE2207");
                    jLabelGrade2.setText("Not inserted");
                    jLabelSub3.setText("CSE2209");
                    jLabelGrade3.setText("Not inserted");
                    jLabelSub4.setText("CSE2213");
                    jLabelGrade4.setText("Not inserted");
                    jLabelSub5.setText("MATH2203");
                    jLabelGrade5.setText("Not inserted");
                    jLabelSub6.setText("CSE2208");
                    jLabelGrade6.setText("Not inserted");
                    jLabelSub7.setText("CSE2214");
                    jLabelGrade7.setText("Not inserted");
                    jLabelSub8.setText("CSE2200");
                    jLabelGrade8.setText("Not inserted");
                    jLabelSub9.setText("CSE2202");
                    jLabelGrade9.setText("Not inserted");
                    jLabelSub10.setText("CSE2210");
                    jLabelGrade10.setText("Not inserted");
                    jLabelGPA.setText("GPA");
                    jLabelCG.setText("Not inserted");
                    JOptionPane.showMessageDialog(null, "No records inserted", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else {

                    JOptionPane.showMessageDialog(null, "DATA FOUND", "2.2 INFO", JOptionPane.INFORMATION_MESSAGE);
                    jLabelSub1.setText("CSE2201");
                    jLabelGrade1.setText(rs.getString("CSE2201"));
                    jLabelSub2.setText("CSE2207");
                    jLabelGrade2.setText(rs.getString("CSE2207"));
                    jLabelSub3.setText("CSE2209");
                    jLabelGrade3.setText(rs.getString("CSE2209"));
                    jLabelSub4.setText("CSE2213");
                    jLabelGrade4.setText(rs.getString("CSE2213"));
                    jLabelSub5.setText("MATH2203");
                    jLabelGrade5.setText(rs.getString("MATH2203"));
                    jLabelSub6.setText("CSE2208");
                    jLabelGrade6.setText(rs.getString("CSE2208"));
                    jLabelSub7.setText("CSE2214");
                    jLabelGrade7.setText(rs.getString("CSE2214"));
                    jLabelSub8.setText("CSE2200");
                    jLabelGrade8.setText(rs.getString("CSE2200"));
                    jLabelSub9.setText("CSE2202");
                    jLabelGrade9.setText(rs.getString("CSE2202"));
                    jLabelSub10.setText("CSE2210");
                    jLabelGrade10.setText(rs.getString("CSE2210"));
                    jLabelGPA.setText("GPA");
                    jLabelCG.setText(rs.getString("CGPA"));

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (jComboBox1.getSelectedItem().toString().equals("3.1")) {
            try {
                // TODO add your handling code here:
                String username = jLabel3.getText();
                String sql = "SELECT * FROM PRITOM.INFO31 WHERE USERNAME = '" + username + "'";
                Statement st = con.createStatement();
                //row = st.executeUpdate(sql);
                ResultSet rs = st.executeQuery(sql);
                //System.out.println(row);
                rs.next();
                String ins = rs.getString("INSERTED");
                if (ins == null) {
                    jLabelSub1.setText("CSE3101");
                    jLabelGrade1.setText("Not inserted");
                    jLabelSub2.setText("CSE3103");
                    jLabelGrade2.setText("Not inserted");
                    jLabelSub3.setText("CSE3107");
                    jLabelGrade3.setText("Not inserted");
                    jLabelSub4.setText("CSE3109");
                    jLabelGrade4.setText("Not inserted");
                    jLabelSub5.setText("HUM3115");
                    jLabelGrade5.setText("Not inserted");
                    jLabelSub6.setText("CSE3104");
                    jLabelGrade6.setText("Not inserted");
                    jLabelSub7.setText("CSE3100");
                    jLabelGrade7.setText("Not inserted");
                    jLabelSub8.setText("CSE3108");
                    jLabelGrade8.setText("Not inserted");
                    jLabelSub9.setText("CSE3110");
                    jLabelGrade9.setText("Not inserted");
                    jLabelSub10.setText("");
                    jLabelGrade10.setText("");
                    jLabelGPA.setText("GPA");
                    jLabelCG.setText("Not inserted");
                    JOptionPane.showMessageDialog(null, "No records inserted", "Error", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "DATA FOUND", "3.1 INFO", JOptionPane.INFORMATION_MESSAGE);
                    jLabelSub1.setText("CSE3101");
                    jLabelGrade1.setText(rs.getString("CSE3101"));
                    jLabelSub2.setText("CSE3103");
                    jLabelGrade2.setText(rs.getString("CSE3103"));
                    jLabelSub3.setText("CSE3107");
                    jLabelGrade3.setText(rs.getString("CSE3107"));
                    jLabelSub4.setText("CSE3109");
                    jLabelGrade4.setText(rs.getString("CSE3109"));
                    jLabelSub5.setText("HUM3115");
                    jLabelGrade5.setText(rs.getString("HUM3115"));
                    jLabelSub6.setText("CSE3104");
                    jLabelGrade6.setText(rs.getString("CSE3104"));
                    jLabelSub7.setText("CSE3100");
                    jLabelGrade7.setText(rs.getString("CSE3100"));
                    jLabelSub8.setText("CSE3108");
                    jLabelGrade8.setText(rs.getString("CSE3108"));
                    jLabelSub9.setText("CSE3110");
                    jLabelGrade9.setText(rs.getString("CSE3110"));
                    jLabelSub10.setText("");
                    jLabelGrade10.setText("");
                    jLabelGPA.setText("GPA");
                    jLabelCG.setText(rs.getString("CGPA"));

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (jComboBox1.getSelectedItem().toString().equals("3.2")) {
            try {
                // TODO add your handling code here:
                String username = jLabel3.getText();
                String sql = "SELECT * FROM PRITOM.INFO32 WHERE USERNAME = '" + username + "'";
                Statement st = con.createStatement();
                //row = st.executeUpdate(sql);
                ResultSet rs = st.executeQuery(sql);
                //System.out.println(row);
                rs.next();
                String ins = rs.getString("INSERTED");
                if (ins == null) {

                    jLabelSub1.setText("CSE3211");
                    jLabelGrade1.setText("Not inserted");
                    jLabelSub2.setText("CSE3213");
                    jLabelGrade2.setText("Not inserted");
                    jLabelSub3.setText("CSE3215");
                    jLabelGrade3.setText("Not inserted");
                    jLabelSub4.setText("CSE3223");
                    jLabelGrade4.setText("Not inserted");
                    jLabelSub5.setText("HUM3207");
                    jLabelGrade5.setText("Not inserted");
                    jLabelSub6.setText("CSE3214");
                    jLabelGrade6.setText("Not inserted");
                    jLabelSub7.setText("CSE3200");
                    jLabelGrade7.setText("Not inserted");
                    jLabelSub8.setText("CSE3216");
                    jLabelGrade8.setText("Not inserted");
                    jLabelSub9.setText("CSE3224");
                    jLabelGrade9.setText("Not inserted");
                    jLabelSub10.setText("");
                    jLabelGrade10.setText("");
                    jLabelGPA.setText("GPA");
                    jLabelCG.setText("Not inserted");
                    JOptionPane.showMessageDialog(null, "No records inserted", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "DATA FOUND", "3.2 INFO", JOptionPane.INFORMATION_MESSAGE);
                    jLabelSub1.setText("CSE3211");
                    jLabelGrade1.setText(rs.getString("CSE3211"));
                    jLabelSub2.setText("CSE3213");
                    jLabelGrade2.setText(rs.getString("CSE3213"));
                    jLabelSub3.setText("CSE3215");
                    jLabelGrade3.setText(rs.getString("CSE3215"));
                    jLabelSub4.setText("CSE3223");
                    jLabelGrade4.setText(rs.getString("CSE3223"));
                    jLabelSub5.setText("HUM3207");
                    jLabelGrade5.setText(rs.getString("HUM3207"));
                    jLabelSub6.setText("CSE3214");
                    jLabelGrade6.setText(rs.getString("CSE3214"));
                    jLabelSub7.setText("CSE3200");
                    jLabelGrade7.setText(rs.getString("CSE3200"));
                    jLabelSub8.setText("CSE3216");
                    jLabelGrade8.setText(rs.getString("CSE3216"));
                    jLabelSub9.setText("CSE3224");
                    jLabelGrade9.setText(rs.getString("CSE3224"));
                    jLabelSub10.setText("");
                    jLabelGrade10.setText("");
                    jLabelGPA.setText("GPA");
                    jLabelCG.setText(rs.getString("CGPA"));
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (jComboBox1.getSelectedItem().toString().equals("4.1")) {
            try {
                // TODO add your handling code here:
                String username = jLabel3.getText();
                String sql = "SELECT * FROM PRITOM.INFO41 WHERE USERNAME = '" + username + "'";
                Statement st = con.createStatement();
                //row = st.executeUpdate(sql);
                ResultSet rs = st.executeQuery(sql);
                //System.out.println(row);
                rs.next();
                String ins = rs.getString("INSERTED");
                if (ins == null) {
                    jLabelSub1.setText("CSE4101");
                    jLabelGrade1.setText("Not inserted");
                    jLabelSub2.setText("CSE4107");
                    jLabelGrade2.setText("Not inserted");
                    jLabelSub3.setText("CSE4125");
                    jLabelGrade3.setText("Not inserted");
                    jLabelSub4.setText("CSE4129");
                    jLabelGrade4.setText("Not inserted");
                    jLabelSub5.setText("IPE4111");
                    jLabelGrade5.setText("Not inserted");
                    jLabelSub6.setText("CSE4102");
                    jLabelGrade6.setText("Not inserted");
                    jLabelSub7.setText("CSE4108");
                    jLabelGrade7.setText("Not inserted");
                    jLabelSub8.setText("CSE4126");
                    jLabelGrade8.setText("Not inserted");
                    jLabelSub9.setText("CSE4130");
                    jLabelGrade9.setText("Not inserted");
                    jLabelSub10.setText("");
                    jLabelGrade10.setText("");
                    jLabelGPA.setText("GPA");
                    jLabelCG.setText("Not inserted");
                    JOptionPane.showMessageDialog(null, "No records inserted", "Error", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "DATA FOUND", "4.1 INFO", JOptionPane.INFORMATION_MESSAGE);
                    jLabelSub1.setText("CSE4101");
                    jLabelGrade1.setText(rs.getString("CSE4101"));
                    jLabelSub2.setText("CSE4107");
                    jLabelGrade2.setText(rs.getString("CSE4107"));
                    jLabelSub3.setText("CSE4125");
                    jLabelGrade3.setText(rs.getString("CSE4125"));
                    jLabelSub4.setText("CSE4129");
                    jLabelGrade4.setText(rs.getString("CSE4129"));
                    jLabelSub5.setText("IPE4111");
                    jLabelGrade5.setText(rs.getString("IPE4111"));
                    jLabelSub6.setText("CSE4102");
                    jLabelGrade6.setText(rs.getString("CSE4102"));
                    jLabelSub7.setText("CSE4108");
                    jLabelGrade7.setText(rs.getString("CSE4108"));
                    jLabelSub8.setText("CSE4126");
                    jLabelGrade8.setText(rs.getString("CSE4126"));
                    jLabelSub9.setText("CSE4130");
                    jLabelGrade9.setText(rs.getString("CSE4130"));
                    jLabelSub10.setText("");
                    jLabelGrade10.setText("");
                    jLabelGPA.setText("GPA");
                    jLabelCG.setText(rs.getString("CGPA"));

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (jComboBox1.getSelectedItem().toString().equals("4.2")) {
            try {
                // TODO add your handling code here:
                String username = jLabel3.getText();
                String sql = "SELECT * FROM PRITOM.INFO42 WHERE USERNAME = '" + username + "'";
                Statement st = con.createStatement();
                //row = st.executeUpdate(sql);
                ResultSet rs = st.executeQuery(sql);
                //System.out.println(row);
                rs.next();
                String ins = rs.getString("INSERTED");
                if (ins == null) {
                    jLabelSub1.setText("CSE4203");
                    jLabelGrade1.setText("Not inserted");
                    jLabelSub2.setText("CSE4213");
                    jLabelGrade2.setText("Not inserted");
                    jLabelSub3.setText("CSE4227");
                    jLabelGrade3.setText("Not inserted");
                    jLabelSub4.setText("CSE4237");
                    jLabelGrade4.setText("Not inserted");
                    jLabelSub5.setText("CSE4255");
                    jLabelGrade5.setText("Not inserted");
                    jLabelSub6.setText("CSE4204");
                    jLabelGrade6.setText("Not inserted");
                    jLabelSub7.setText("CSE4214");
                    jLabelGrade7.setText("Not inserted");
                    jLabelSub8.setText("CSE4228");
                    jLabelGrade8.setText("Not inserted");
                    jLabelSub9.setText("CSE4238");
                    jLabelGrade9.setText("Not inserted");
                    jLabelSub10.setText("");
                    jLabelGrade10.setText("");
                    jLabelGPA.setText("GPA");
                    jLabelCG.setText("Not inserted");
                    JOptionPane.showMessageDialog(null, "No records inserted", "Error", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "DATA FOUND", "4.2 INFO", JOptionPane.INFORMATION_MESSAGE);
                    jLabelSub1.setText("CSE4203");
                    jLabelGrade1.setText(rs.getString("CSE4203"));
                    jLabelSub2.setText("CSE4213");
                    jLabelGrade2.setText(rs.getString("CSE4213"));
                    jLabelSub3.setText("CSE4227");
                    jLabelGrade3.setText(rs.getString("CSE4227"));
                    jLabelSub4.setText("CSE4237");
                    jLabelGrade4.setText(rs.getString("CSE4237"));
                    jLabelSub5.setText("CSE4255");
                    jLabelGrade5.setText(rs.getString("CSE4255"));
                    jLabelSub6.setText("CSE4204");
                    jLabelGrade6.setText(rs.getString("CSE4204"));
                    jLabelSub7.setText("CSE4214");
                    jLabelGrade7.setText(rs.getString("CSE4214"));
                    jLabelSub8.setText("CSE4228");
                    jLabelGrade8.setText(rs.getString("CSE4228"));
                    jLabelSub9.setText("CSE4238");
                    jLabelGrade9.setText(rs.getString("CSE4238"));
                    jLabelSub10.setText("");
                    jLabelGrade10.setText("");
                    jLabelGPA.setText("GPA");
                    jLabelCG.setText(rs.getString("CGPA"));

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            String username = jLabel3.getText();
            String sql = "SELECT * FROM PRITOM.STUDENT WHERE USER_NAME = '" + username + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                //JOptionPane.showMessageDialog(null, "Signed in succesfully", "Sign in", JOptionPane.INFORMATION_MESSAGE);

                String x = rs.getString("NAME");
                dispose();
                Welcome wc = new Welcome(x, username);
                wc.show();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowCGPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ShowCGPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowCGPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowCGPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowCGPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowCGPA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jCGO;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCG;
    private javax.swing.JLabel jLabelCGPA;
    private javax.swing.JLabel jLabelGPA;
    private javax.swing.JLabel jLabelGrade1;
    private javax.swing.JLabel jLabelGrade10;
    private javax.swing.JLabel jLabelGrade2;
    private javax.swing.JLabel jLabelGrade3;
    private javax.swing.JLabel jLabelGrade4;
    private javax.swing.JLabel jLabelGrade5;
    private javax.swing.JLabel jLabelGrade6;
    private javax.swing.JLabel jLabelGrade7;
    private javax.swing.JLabel jLabelGrade8;
    private javax.swing.JLabel jLabelGrade9;
    private javax.swing.JLabel jLabelSub1;
    private javax.swing.JLabel jLabelSub10;
    private javax.swing.JLabel jLabelSub2;
    private javax.swing.JLabel jLabelSub3;
    private javax.swing.JLabel jLabelSub4;
    private javax.swing.JLabel jLabelSub5;
    private javax.swing.JLabel jLabelSub6;
    private javax.swing.JLabel jLabelSub7;
    private javax.swing.JLabel jLabelSub8;
    private javax.swing.JLabel jLabelSub9;
    // End of variables declaration//GEN-END:variables
}
