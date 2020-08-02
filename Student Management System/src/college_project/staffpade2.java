/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package college_project;

import com.sun.glass.events.KeyEvent;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Rajesh
 */
public class staffpade2 extends javax.swing.JFrame {

    /**
     * Creates new form staffpade2
     */
    public staffpade2() {
        initComponents();
        displaydata4();
        displaydata5();
        resetvalues_score();
        displaystaff();
    }

   

    public void displaydata4() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useTimezone=true&&serverTimezone=UTC", "root", " ")) {
                String sql = "select score.stud_id as Roll_No,score.eng as English,score.math as Math,score.sci as Science,score.his as History,"
                        + "score.geo as Geography,score.comp as Computer,score.total as Total,score.avg as Average,score.grade as Grade from"
                        + " student.score LEFT JOIN student.student on score.stud_id = student.student.s_id ";
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                t4.setModel(DbUtils.resultSetToTableModel(rs));
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Unknown ID");
        }
    }

    public void displaydata5() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useTimezone=true&&serverTimezone=UTC", "root", " ")) {
                String sql = "select s_id as ID, s_name as NAME,surname as Surname,s_phone as Mobile_no,s_blood as Blood_group from student";
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();

                t5.setModel(DbUtils.resultSetToTableModel(rs));
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void resetvalues_score() {
        jcourse.setSelectedItem("");
        jname.setText("");
        jsurname.setText("");
        stud_id.setText("");
        eng.setText("");
        math.setText("");
        sci.setText("");
        his.setText("");
        geo.setText("");
        comp.setText("");
        jtotal.setText("");
        jper.setText("");
        jgrade.setText("");
        txttrans.setText("");
    }

    public void datasearch() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useTimezone=true&&serverTimezone=UTC", "root", " ")) {
                String sql = "select * from student where s_id='" + ss_id.getText() + "'";
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                t5.setModel(DbUtils.resultSetToTableModel(rs));

            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Not Record Found");
        }
    }

    public void displaystaff() {
        mail.setText(staffpage.mainmail.getText());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useTimezone=true&&serverTimezone=UTC", "root", "")) {
                String sql = "Select * from staff where t_mail=?";
                PreparedStatement ptst = conn.prepareStatement(sql);
                ptst.setString(1, mail.getText());

                ResultSet rs = ptst.executeQuery();
                if (rs.next()) {
                    name.setText(rs.getString("t_name"));
                    t_id.setText(rs.getString("t_id"));
                    phone.setText(rs.getString("t_phone"));
                    mail.setText(rs.getString("t_mail"));
                } else {
                    JOptionPane.showMessageDialog(null, "Record not Found for " + name.getText());
                }

            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
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

        jDialog1 = new javax.swing.JDialog();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        profile = new javax.swing.JButton();
        student = new javax.swing.JButton();
        manage_score = new javax.swing.JButton();
        returnmain = new javax.swing.JButton();
        home2 = new javax.swing.JButton();
        hide = new javax.swing.JPanel();
        b3 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        staff_hello = new javax.swing.JTextField();
        view_profile = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        staffupdate = new javax.swing.JButton();
        t_id = new javax.swing.JLabel();
        view_stud = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t5 = new javax.swing.JTable();
        ss = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        sortid = new javax.swing.JButton();
        sortname = new javax.swing.JButton();
        ss_id = new javax.swing.JTextField();
        ss_reset = new javax.swing.JButton();
        stud_report = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jname = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        t4 = new javax.swing.JTable();
        transcript = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jcourse = new javax.swing.JComboBox<>();
        marks_delete = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jsurname = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jtotal = new javax.swing.JTextField();
        jper = new javax.swing.JTextField();
        jgrade = new javax.swing.JTextField();
        eng = new javax.swing.JTextField();
        sci = new javax.swing.JTextField();
        comp = new javax.swing.JTextField();
        geo = new javax.swing.JTextField();
        his = new javax.swing.JTextField();
        math = new javax.swing.JTextField();
        reportcard = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txttrans = new javax.swing.JTextArea();
        marks_update = new javax.swing.JButton();
        jsearch = new javax.swing.JButton();
        stud_id = new javax.swing.JTextField();

        jDialog1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        profile.setBackground(new java.awt.Color(0, 102, 102));
        profile.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        profile.setForeground(new java.awt.Color(255, 255, 255));
        profile.setText("Update Profile");
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });

        student.setBackground(new java.awt.Color(0, 102, 102));
        student.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        student.setForeground(new java.awt.Color(255, 255, 255));
        student.setText("View Student");
        student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentActionPerformed(evt);
            }
        });

        manage_score.setBackground(new java.awt.Color(0, 102, 102));
        manage_score.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        manage_score.setForeground(new java.awt.Color(255, 255, 255));
        manage_score.setText("Manage Score");
        manage_score.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manage_scoreActionPerformed(evt);
            }
        });

        returnmain.setBackground(new java.awt.Color(0, 102, 102));
        returnmain.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        returnmain.setForeground(new java.awt.Color(255, 255, 255));
        returnmain.setText("Back");
        returnmain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnmainActionPerformed(evt);
            }
        });

        home2.setBackground(new java.awt.Color(0, 102, 102));
        home2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        home2.setForeground(new java.awt.Color(255, 255, 255));
        home2.setText("Home");
        home2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                home2FocusGained(evt);
            }
        });
        home2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(manage_score, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(student, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(returnmain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(home2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(home2)
                .addGap(124, 124, 124)
                .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(manage_score, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(student, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addComponent(returnmain, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 220, 680));

        hide.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout hideLayout = new javax.swing.GroupLayout(hide);
        hide.setLayout(hideLayout);
        hideLayout.setHorizontalGroup(
            hideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        hideLayout.setVerticalGroup(
            hideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 1000, 40));

        b3.setBackground(new java.awt.Color(255, 255, 255));
        b3.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel3FocusGained(evt);
            }
        });

        staff_hello.setEditable(false);
        staff_hello.setBackground(new java.awt.Color(255, 255, 255));
        staff_hello.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        staff_hello.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        staff_hello.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                staff_helloFocusGained(evt);
            }
        });
        staff_hello.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_helloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(staff_hello, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(staff_hello, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(297, Short.MAX_VALUE))
        );

        b3.addTab("tab4", jPanel3);

        view_profile.setBackground(new java.awt.Color(255, 255, 255));

        jLabel33.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("ID :");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Name :");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Phone No :");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Email :");

        name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        phone.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });
        phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneKeyTyped(evt);
            }
        });

        mail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailActionPerformed(evt);
            }
        });

        staffupdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        staffupdate.setText("Update");
        staffupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffupdateActionPerformed(evt);
            }
        });

        t_id.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout view_profileLayout = new javax.swing.GroupLayout(view_profile);
        view_profile.setLayout(view_profileLayout);
        view_profileLayout.setHorizontalGroup(
            view_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(view_profileLayout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addGroup(view_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(view_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(staffupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mail)
                    .addComponent(phone)
                    .addComponent(name)
                    .addComponent(t_id, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(388, Short.MAX_VALUE))
        );
        view_profileLayout.setVerticalGroup(
            view_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(view_profileLayout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addGroup(view_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel33)
                    .addComponent(t_id, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(view_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(view_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(view_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(staffupdate)
                .addContainerGap(238, Short.MAX_VALUE))
        );

        b3.addTab("tab1", view_profile);

        view_stud.setBackground(new java.awt.Color(255, 255, 255));

        t5.setAutoCreateRowSorter(true);
        t5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t5.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(t5);

        ss.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ss.setText("Search");
        ss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Search by ID :");

        sortid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sortid.setText("Sort by ID");
        sortid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortidActionPerformed(evt);
            }
        });

        sortname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sortname.setText("Sort by Name");
        sortname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortnameActionPerformed(evt);
            }
        });

        ss_id.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ss_reset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ss_reset.setText("Reset");
        ss_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ss_resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout view_studLayout = new javax.swing.GroupLayout(view_stud);
        view_stud.setLayout(view_studLayout);
        view_studLayout.setHorizontalGroup(
            view_studLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(view_studLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(view_studLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(view_studLayout.createSequentialGroup()
                        .addGroup(view_studLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
                            .addGroup(view_studLayout.createSequentialGroup()
                                .addComponent(sortid)
                                .addGap(28, 28, 28)
                                .addComponent(sortname)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(view_studLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ss_id, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(ss, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ss_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        view_studLayout.setVerticalGroup(
            view_studLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, view_studLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(view_studLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ss_id, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ss, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(view_studLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(ss_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(view_studLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sortid, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(sortname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        b3.addTab("tab3", view_stud);

        stud_report.setBackground(new java.awt.Color(255, 255, 255));
        stud_report.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("Student ID :");
        stud_report.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 31, -1, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setText("Science :");
        stud_report.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 85, -1, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setText("Name :");
        stud_report.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 74, -1, -1));

        jname.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnameActionPerformed(evt);
            }
        });
        stud_report.add(jname, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 71, 96, -1));

        t4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "English", "Math", "Science", "History", "Geography", "Computer", "Total", "Average", "Grade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(t4);

        stud_report.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 420, 957, 113));

        transcript.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        transcript.setForeground(new java.awt.Color(51, 51, 51));
        transcript.setText("Report");
        transcript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transcriptActionPerformed(evt);
            }
        });
        stud_report.add(transcript, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, -1, -1));

        btnreset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnreset.setForeground(new java.awt.Color(51, 51, 51));
        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        stud_report.add(btnreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 560, 100, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("English :");
        stud_report.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 16, -1, -1));

        jcourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CO1G", "CO2G", "CO3G", "CO4G", " " }));
        jcourse.setToolTipText("");
        jcourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcourseActionPerformed(evt);
            }
        });
        stud_report.add(jcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 186, 96, -1));

        marks_delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        marks_delete.setForeground(new java.awt.Color(51, 51, 51));
        marks_delete.setText("Delete");
        marks_delete.setToolTipText("");
        marks_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marks_deleteActionPerformed(evt);
            }
        });
        stud_report.add(marks_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 560, 103, -1));

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel13.setText("Surname:");
        stud_report.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 124, -1, 16));

        jsurname.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jsurname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsurnameActionPerformed(evt);
            }
        });
        stud_report.add(jsurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 120, 96, -1));

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel14.setText("Course_id :");
        stud_report.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 187, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setText("Math :");
        stud_report.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 49, -1, -1));

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel19.setText("History :");
        stud_report.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 123, -1, -1));

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel20.setText("Geography :");
        stud_report.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 166, -1, -1));

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel21.setText("Computer :");
        stud_report.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 209, -1, -1));
        stud_report.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 238, 614, 14));

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel22.setText("Total out of 600 :");
        stud_report.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 262, -1, -1));

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel23.setText("Average :");
        stud_report.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 309, -1, 16));

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel24.setText("Grade :");
        stud_report.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 359, -1, -1));

        jtotal.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtotalActionPerformed(evt);
            }
        });
        stud_report.add(jtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 259, 96, -1));

        jper.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jperActionPerformed(evt);
            }
        });
        stud_report.add(jper, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 305, 96, -1));

        jgrade.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jgrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jgradeActionPerformed(evt);
            }
        });
        stud_report.add(jgrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 356, 96, -1));

        eng.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        eng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engActionPerformed(evt);
            }
        });
        eng.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                engKeyTyped(evt);
            }
        });
        stud_report.add(eng, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 13, 96, -1));

        sci.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        sci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sciActionPerformed(evt);
            }
        });
        sci.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sciKeyTyped(evt);
            }
        });
        stud_report.add(sci, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 82, 96, -1));

        comp.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        comp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compActionPerformed(evt);
            }
        });
        comp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                compKeyTyped(evt);
            }
        });
        stud_report.add(comp, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 206, 96, -1));

        geo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        geo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geoActionPerformed(evt);
            }
        });
        geo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                geoKeyTyped(evt);
            }
        });
        stud_report.add(geo, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 163, 96, -1));

        his.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        his.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hisActionPerformed(evt);
            }
        });
        his.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hisKeyTyped(evt);
            }
        });
        stud_report.add(his, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 120, 96, -1));

        math.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        math.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mathActionPerformed(evt);
            }
        });
        math.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mathKeyTyped(evt);
            }
        });
        stud_report.add(math, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 50, 96, -1));

        reportcard.setBackground(new java.awt.Color(255, 255, 255));
        reportcard.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3), "RESULT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 14), new java.awt.Color(51, 51, 51))); // NOI18N

        txttrans.setBackground(new java.awt.Color(237, 237, 237));
        txttrans.setColumns(20);
        txttrans.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        txttrans.setRows(5);
        jScrollPane4.setViewportView(txttrans);

        javax.swing.GroupLayout reportcardLayout = new javax.swing.GroupLayout(reportcard);
        reportcard.setLayout(reportcardLayout);
        reportcardLayout.setHorizontalGroup(
            reportcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportcardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addContainerGap())
        );
        reportcardLayout.setVerticalGroup(
            reportcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportcardLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addContainerGap())
        );

        stud_report.add(reportcard, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 0, -1, -1));

        marks_update.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        marks_update.setForeground(new java.awt.Color(51, 51, 51));
        marks_update.setText("Update");
        marks_update.setToolTipText("");
        marks_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marks_updateActionPerformed(evt);
            }
        });
        stud_report.add(marks_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 560, 109, -1));

        jsearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jsearch.setForeground(new java.awt.Color(51, 51, 51));
        jsearch.setText("Search");
        jsearch.setToolTipText("");
        jsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsearchActionPerformed(evt);
            }
        });
        stud_report.add(jsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 560, 122, -1));

        stud_id.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        stud_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                stud_idFocusLost(evt);
            }
        });
        stud_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stud_idActionPerformed(evt);
            }
        });
        stud_report.add(stud_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 90, -1));

        b3.addTab("tab2", stud_report);

        jPanel1.add(b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 1000, 670));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 13, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void returnmainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnmainActionPerformed
        // TODO add your handling code here:
        mainpage o = new mainpage();
        o.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_returnmainActionPerformed

    private void mathKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mathKeyTyped
        // TODO add your handling code here:
        char iNumber = evt.getKeyChar();
        if (!(Character.isDigit(iNumber))
                || (iNumber == KeyEvent.VK_BACKSPACE)
                || (iNumber == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_mathKeyTyped

    private void mathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mathActionPerformed

    private void hisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hisKeyTyped
        // TODO add your handling code here:
        char iNumber = evt.getKeyChar();
        if (!(Character.isDigit(iNumber))
                || (iNumber == KeyEvent.VK_BACKSPACE)
                || (iNumber == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_hisKeyTyped

    private void hisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hisActionPerformed

    private void geoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_geoKeyTyped
        // TODO add your handling code here:
        char iNumber = evt.getKeyChar();
        if (!(Character.isDigit(iNumber))
                || (iNumber == KeyEvent.VK_BACKSPACE)
                || (iNumber == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_geoKeyTyped

    private void geoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_geoActionPerformed

    private void compKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_compKeyTyped
        // TODO add your handling code here:
        char iNumber = evt.getKeyChar();
        if (!(Character.isDigit(iNumber))
                || (iNumber == KeyEvent.VK_BACKSPACE)
                || (iNumber == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_compKeyTyped

    private void compActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compActionPerformed

    private void sciKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sciKeyTyped
        // TODO add your handling code here:
        char iNumber = evt.getKeyChar();
        if (!(Character.isDigit(iNumber))
                || (iNumber == KeyEvent.VK_BACKSPACE)
                || (iNumber == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_sciKeyTyped

    private void sciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sciActionPerformed

    private void engKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_engKeyTyped
        // TODO add your handling code here:
        char iNumber = evt.getKeyChar();
        if (!(Character.isDigit(iNumber))
                || (iNumber == KeyEvent.VK_BACKSPACE)
                || (iNumber == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_engKeyTyped

    private void engActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_engActionPerformed

    private void jgradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jgradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jgradeActionPerformed

    private void jperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jperActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jperActionPerformed

    private void jtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtotalActionPerformed

    private void jsurnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsurnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jsurnameActionPerformed

    private void marks_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marks_deleteActionPerformed
        // TODO add your handling code here:

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useTimezone=true&&serverTimezone=UTC", "root", "")) {
                String sql = "Delete from score where stud_id='" + stud_id.getText() + "'";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Deleted data Successfully for " + jname.getText());
                resetvalues_score();
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Check the Data you have entered");
        }
        displaydata4();

    }//GEN-LAST:event_marks_deleteActionPerformed

    private void jcourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcourseActionPerformed
//        jcourse.revalidate();
    }//GEN-LAST:event_jcourseActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        resetvalues_score();
    }//GEN-LAST:event_btnresetActionPerformed

    private void transcriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transcriptActionPerformed
        // TODO add your handling code here:
             double[] R = new double[14];

        R[0] = Double.parseDouble(eng.getText());
        R[1] = Double.parseDouble(math.getText());
        R[2] = Double.parseDouble(sci.getText());
        R[3] = Double.parseDouble(his.getText());
        R[4] = Double.parseDouble(geo.getText());
        R[5] = Double.parseDouble(comp.getText());

        R[8] = (R[0] + R[1] + R[2] + R[3] + R[4] + R[5]) / 6;
        R[9] = R[0] + R[1] + R[2] + R[3] + R[4] + R[5];

        String Average = String.format("%.0f", R[8]);
        jper.setText(Average);

        String Total = String.format("%.0f", R[9]);
        jtotal.setText(Total);

        if (R[9] >= 500) {
            jgrade.setText("A");
        } else if (R[9] >= 400) {
            jgrade.setText("B");
        } else if (R[9] >= 300) {
            jgrade.setText("C");
        } else if (R[9] >= 200) {
            jgrade.setText("D");
        } else {
            jgrade.setText("F");
        }
        
        
        txttrans.setText("Report Card       " + jcourse.getSelectedItem()
                + "\n========================\n"
                + jname.getText() + " " + jsurname.getText() + " | ID: " + stud_id.getText()
                + "\n========================\n"
                + "English:\t" + eng.getText()
                + "\nMath:\t\t" + math.getText()
                + "\nScience:\t" + sci.getText()
                + "\nHistory:\t" + his.getText()
                + "\nGeography:\t" + geo.getText()
                + "\nComputer:\t" + comp.getText()
                + "\n========================"
                + "\nTotal:\t\t" + jtotal.getText()
                + "\nAverage:\t" + jper.getText()
                + "\nGrade:\t\t" + jgrade.getText()
        );

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useTimezone=true&&serverTimezone=UTC", "root", "")) {
                String sql = "insert into score values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ptst = conn.prepareStatement(sql);
                String td;
                td = jcourse.getSelectedItem().toString();
                ptst.setString(1, td);
                ptst.setInt(2, Integer.parseInt(stud_id.getText()));
                ptst.setString(3, jname.getText());
                ptst.setString(4, jsurname.getText());
                ptst.setInt(5, Integer.parseInt(eng.getText()));
                ptst.setInt(6, Integer.parseInt(math.getText()));
                ptst.setInt(7, Integer.parseInt(sci.getText()));
                ptst.setInt(8, Integer.parseInt(his.getText()));
                ptst.setInt(9, Integer.parseInt(geo.getText()));
                ptst.setInt(10, Integer.parseInt(comp.getText()));
                ptst.setInt(11, Integer.parseInt(jtotal.getText()));
                ptst.setInt(12, Integer.parseInt(jper.getText()));
                ptst.setString(13, jgrade.getText());

                ptst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data is Recorded Successfully");
                conn.close();

            } catch (SQLException ex) {
                Logger.getLogger(staffpade2.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(staffpade2.class.getName()).log(Level.SEVERE, null, ex);
        }
        displaydata4();
    }//GEN-LAST:event_transcriptActionPerformed

    private void jnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jnameActionPerformed

    private void sortnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortnameActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useTimezone=true&&serverTimezone=UTC", "root", "")) {
                String sq = "select s_id as ID, s_name as NAME,surname as Surname,s_phone as Mobile_no,s_blood as Blood_group from student ORDER BY s_name, surname";
                PreparedStatement pst = conn.prepareStatement(sq);
                ResultSet rs = pst.executeQuery();
                t5.setModel(DbUtils.resultSetToTableModel(rs));
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_sortnameActionPerformed

    private void sortidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortidActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useTimezone=true&&serverTimezone=UTC", "root", "")) {
                String sql = "select s_id as ID, s_name as NAME,surname as Surname,s_phone as Mobile_no,s_blood as Blood_group from student order by s_id";
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                t5.setModel(DbUtils.resultSetToTableModel(rs));
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_sortidActionPerformed

    private void staffupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffupdateActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useTimezone=true&&serverTimezone=UTC", "root", "")) {
                t_id.setEnabled(false);
                String sql = "Update staff set t_name= '" + name.getText() + "',t_mail= '" + mail.getText() + "',t_phone= '" + phone.getText() + "'  where t_id='" + t_id.getText() + "'";
                
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Updated data Successfully added in database for " + name.getText());
                
                displaystaff();
           
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_staffupdateActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void marks_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marks_updateActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useTimezone=true&&serverTimezone=UTC", "root", "")) {
                t_id.setEnabled(false);
               String td;
                td = jcourse.getSelectedItem().toString();
                String sql = "Update score set course_id= '" + td+ "',name= '" + jname.getText() + "', surname= '" + jsurname.getText() + "', eng= '" + eng.getText() + "', math= '" + math.getText() + "'"
                        + ",sci= '" + sci.getText() + "', his= '" + his.getText() + "',geo= '" + geo.getText() + "', comp= '" + comp.getText() +  "'"
                         + ",total= '" + jtotal.getText() + "', grade= '" + jgrade.getText() + "',avg= '" + jper.getText() + "'"
                        + " where stud_id='" + stud_id.getText() + "'";

                PreparedStatement pst = conn.prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Updated data Successfully added in database for " + jname.getText());

                displaydata4();
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Check the Data you have entered");
        }
    }//GEN-LAST:event_marks_updateActionPerformed

    private void jsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsearchActionPerformed
        // TODO add your handling code here: try{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useTimezone=true&&serverTimezone=UTC", "root", "")) {
                String sql = "Select * from score where stud_id=?";
                PreparedStatement ptst = conn.prepareStatement(sql);
                ptst.setInt(1, Integer.parseInt(stud_id.getText()));

                ResultSet rs = ptst.executeQuery();
                if (rs.next()) {
                    jname.setText(rs.getString("name"));
                    jsurname.setText(rs.getString("surname"));
                    jcourse.setSelectedItem(rs.getString("course_id"));
                    eng.setText(rs.getString("eng"));
                    math.setText(rs.getString("math"));
                    sci.setText(rs.getString("sci"));
                    his.setText(rs.getString("his"));
                    geo.setText(rs.getString("geo"));
                    comp.setText(rs.getString("comp"));
                    jtotal.setText(rs.getString("total"));
                    jper.setText(rs.getString("avg"));
                    jgrade.setText(rs.getString("grade"));
                } else {
                    JOptionPane.showMessageDialog(null, "Record not Found for ");
                }

            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Check the Data you have entered");
        }
        displaydata4();
    }//GEN-LAST:event_jsearchActionPerformed

    private void ssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssActionPerformed
        datasearch();
    }//GEN-LAST:event_ssActionPerformed

    private void ss_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ss_resetActionPerformed
        // TODO add your handling code here:
        displaydata5();
    }//GEN-LAST:event_ss_resetActionPerformed

    private void jPanel3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel3FocusGained

    }//GEN-LAST:event_jPanel3FocusGained

    private void staff_helloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_helloActionPerformed

    }//GEN-LAST:event_staff_helloActionPerformed

    private void staff_helloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_staff_helloFocusGained
        // TODO add your handling code here:
        b3.setSelectedIndex(0);
        mail.setText(staffpage.mainmail.getText());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useTimezone=true&&serverTimezone=UTC", "root", "")) {
                String sql = "Select * from staff where t_mail=?";
                PreparedStatement ptst = conn.prepareStatement(sql);
                ptst.setString(1, mail.getText());

                ResultSet rs = ptst.executeQuery();
                if (rs.next()) {
                    staff_hello.setText("Great to see you again, " + rs.getString("t_name"));
                } else {
                    JOptionPane.showMessageDialog(null, "Record not Found for " + name.getText());
                }

            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_staff_helloFocusGained

    private void home2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_home2FocusGained
        // TODO add your handling code here:
        b3.setSelectedIndex(0);
        mail.setText(staffpage.mainmail.getText());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useTimezone=true&&serverTimezone=UTC", "root", "")) {
                String sql = "Select * from staff where t_mail=?";
                PreparedStatement ptst = conn.prepareStatement(sql);
                ptst.setString(1, mail.getText());

                ResultSet rs = ptst.executeQuery();
                if (rs.next()) {
                    staff_hello.setText("Great to see you again, " + rs.getString("t_name"));
                } else {
                    JOptionPane.showMessageDialog(null, "Record not Found for " + name.getText());
                }

            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_home2FocusGained

    private void home2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home2ActionPerformed

    }//GEN-LAST:event_home2ActionPerformed

    private void studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentActionPerformed
        // TODO add your handling code here:
        b3.repaint();
        b3.setSelectedIndex(2);
    }//GEN-LAST:event_studentActionPerformed

    private void manage_scoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manage_scoreActionPerformed
        // TODO add your handling code here
        b3.revalidate();
        b3.setSelectedIndex(3);
    }//GEN-LAST:event_manage_scoreActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
        // TODO add your handling code here:
        b3.setSelectedIndex(1);
        displaystaff();
    }//GEN-LAST:event_profileActionPerformed

    private void stud_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stud_idActionPerformed

    }//GEN-LAST:event_stud_idActionPerformed

    private void stud_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stud_idFocusLost
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useTimezone=true&&serverTimezone=UTC", "root", "")) {
                String sql = "Select * from student where s_id=?";
                PreparedStatement ptst = conn.prepareStatement(sql);
                ptst.setInt(1, Integer.parseInt(stud_id.getText()));

                ResultSet rs = ptst.executeQuery();
                if (rs.next()) {
                    jname.setText(rs.getString("s_name"));
                    jsurname.setText(rs.getString("surname"));
                } else {
                    JOptionPane.showMessageDialog(null, "Record not Found for " + stud_id.getText());
                }

            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Check the Data you have entered");
        }
    }//GEN-LAST:event_stud_idFocusLost

    private void mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailActionPerformed

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void phoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneKeyTyped
        // TODO add your handling code here:
          char iNumber = evt.getKeyChar();
        if (!(Character.isDigit(iNumber))
                || (iNumber == KeyEvent.VK_BACKSPACE)
                || (iNumber == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        String pn = phone.getText();
        int length = pn.length();
        char c = evt.getKeyChar();
        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9')
        {
            if(length<10){
                phone.setEditable(true);
            }
            else
            {
                phone.setEditable(false);  
            }
            
         }else{
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACKSPACE   || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE )
            {
                phone.setEditable(true);
            }   else
            {
                phone.setEditable(true);  
            }
           }
        
    }//GEN-LAST:event_phoneKeyTyped

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
            java.util.logging.Logger.getLogger(staffpade2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(staffpade2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(staffpade2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(staffpade2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new staffpade2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane b3;
    private javax.swing.JButton btnreset;
    private javax.swing.JTextField comp;
    private javax.swing.JTextField eng;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JTextField geo;
    private javax.swing.JPanel hide;
    private javax.swing.JTextField his;
    private javax.swing.JButton home2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JComboBox<String> jcourse;
    private javax.swing.JTextField jgrade;
    private javax.swing.JTextField jname;
    private javax.swing.JTextField jper;
    private javax.swing.JButton jsearch;
    private javax.swing.JTextField jsurname;
    private javax.swing.JTextField jtotal;
    private javax.swing.JTextField mail;
    private javax.swing.JButton manage_score;
    private javax.swing.JButton marks_delete;
    private javax.swing.JButton marks_update;
    private javax.swing.JTextField math;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone;
    private javax.swing.JButton profile;
    private javax.swing.JPanel reportcard;
    private javax.swing.JButton returnmain;
    private javax.swing.JTextField sci;
    private javax.swing.JButton sortid;
    private javax.swing.JButton sortname;
    private javax.swing.JButton ss;
    private javax.swing.JTextField ss_id;
    private javax.swing.JButton ss_reset;
    private javax.swing.JTextField staff_hello;
    private javax.swing.JButton staffupdate;
    private javax.swing.JTextField stud_id;
    private javax.swing.JPanel stud_report;
    private javax.swing.JButton student;
    private javax.swing.JTable t4;
    private javax.swing.JTable t5;
    private javax.swing.JLabel t_id;
    private javax.swing.JButton transcript;
    private javax.swing.JTextArea txttrans;
    private javax.swing.JPanel view_profile;
    private javax.swing.JPanel view_stud;
    // End of variables declaration//GEN-END:variables
}
