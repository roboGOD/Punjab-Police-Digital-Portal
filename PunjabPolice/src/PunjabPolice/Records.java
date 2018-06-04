/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PunjabPolice;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.TreeSet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JTable.AUTO_RESIZE_OFF;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author roboGOD
 */
public class Records extends javax.swing.JFrame {

    /**
     * Creates new form senCtzRec
     */
    DefaultTableModel M1 = new DefaultTableModel();
    boolean x=true;
    String rec;
    String name;
    String gender;
    String spouse ;
    String contact;
    String s = "";
    java.util.Date dob;
    java.util.Date dor;
    
    public void dateChooser() {
        if(null == jDateChooser1.getDate()) {
            removeRows();
            getDataBase();
        } else {
            removeRows();
            java.util.Date rawDate = jDateChooser1.getDate();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/punjabpolice","root","");
                Statement st =con.createStatement();
                ResultSet rs = st.executeQuery(s);
                int i =0;
                while(rs.next()){
                    int n;
                    java.util.Date cDate;
                    switch (rec) {
                        case "senior_ctz":
                            cDate = rs.getDate("dor");
                            break;
                        case "missing_persons":
                            cDate = rs.getDate("missing_date");
                            break;
                        case "mobile_theft":
                            cDate = rs.getDate("theft_date");
                            break;
                        case "vehicle_theft":
                            cDate = rs.getDate("theft_date");
                            break;
                        default:
                            cDate = new java.util.Date();
                            break;
                    }
                    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                    String fcDate = f.format(cDate);
                    String frawDate = f.format(rawDate);
                    if(fcDate.equals(frawDate)) {
                        switch (rec) {
                            case "senior_ctz":
                                name = rs.getString("name");
                                gender = rs.getString("gender");
                                spouse = rs.getString("spouse");
                                contact = rs.getString("contact");
                                dob = rs.getDate("dob");
                                dor = rs.getDate("dor");
                                i++;
                                x = false;
                                M1.addRow(new Object[]{i,name,gender,dob,spouse,dor,contact});
                                break;
                            case "missing_persons":
                                String firstname =  rs.getString("first_name");
                                String lastname = rs.getString("last_name");
                                gender = rs.getString("gender");
                                float height;
                                height = rs.getFloat("height");
                                int weight;
                                weight = rs.getInt("weight");
                                String id_marks = rs.getString("id_marks");
                                String missing_loc = rs.getString("missing_location");
                                String religion = rs.getString("religion");
                                String district = rs.getString("district");
                                dob = rs.getDate("dob");
                                java.util.Date dom = rs.getDate("missing_date");
                                i++;
                                x = false;
                                M1.addRow(new Object[]{i,(firstname+" "+lastname),gender,dob,height,weight,id_marks,dom,missing_loc,religion,district});
                                break;
                            case "mobile_theft":
                                int sno = rs.getInt("serial_no");
                                String fname=rs.getString("first_name");
                                String lname=rs.getString("last_name");;
                                java.util.Date dob = rs.getDate("dob");
                                String gname = rs.getString("father_husband_name");
                                String address = rs.getString("address");
                                String mobcomp = rs.getString("mobile_comp");
                                String mobmodel = rs.getString("mobile_model");
                                String imei = rs.getString("IMEI_no");
                                String sim = rs.getString("sim_comp");
                                String lostmob = rs.getString("mob_no");
                                dom = rs.getDate("theft_date");
                                String lostloc = rs.getString("theft_location");
                                String contact = rs.getString("contact");
                                x=false;
                                M1.addRow(new Object[]{sno,fname,lname,gname,dob,address,mobcomp,mobmodel,imei,sim,lostmob,dom,lostloc,contact});
                                break;
                            case "vehicle_theft":
                                sno = rs.getInt("serial_no");
                                fname=rs.getString("first_name");
                                lname=rs.getString("last_name");;
                                dob = rs.getDate("dob");
                                gname = rs.getString("father_husband_name");
                                address = rs.getString("address");
                                String vehtype = rs.getString("vehicle_type");
                                String vehcomp = rs.getString("vehicle_comp");
                                String vehmodel = rs.getString("vehicle_model");
                                String vehcolor = rs.getString("vehicle_color");
                                String lcno = rs.getString("license_plate_no");
                                String vehid = rs.getString("vehicle_id_no");
                                dom = rs.getDate("theft_date");
                                lostloc = rs.getString("theft_location");
                                contact = rs.getString("contact");
                                x = false;
                                M1.addRow(new Object[]{sno,fname,lname,gname,dob,address,vehtype,vehcomp,vehmodel,vehcolor,lcno,vehid,dom,lostloc,contact});
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "rec MisMatch Error!!","Error",JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                    }
                    else {
                        if(x)
                            removeRows();
                    }
                }
                x = true;
            }
            catch(ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e,"Error!",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void nameChooser() {
        if("".equals(jTextField1.getText())) {
            removeRows();
            getDataBase();
        } else {
            removeRows();
            String rawName = jTextField1.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/punjabpolice","root","");
                Statement st =con.createStatement();
                ResultSet rs = st.executeQuery(s);
                int i =0;
                while(rs.next()){
                    String cName;
                    int n;
                    switch (rec) {
                        case "senior_ctz":
                            cName = rs.getString("name")+"                     ";
                            break;
                        case "missing_persons":
                            cName = rs.getString("first_name")+" "+rs.getString("last_name")+"         ";
                            break;
                        case "vehicle_theft" :
                            cName = rs.getString("first_name")+" "+rs.getString("last_name")+"          ";
                            break;
                        case "mobile_theft" :
                            cName = rs.getString("first_name")+" "+rs.getString("last_name")+"           ";
                            break;
                        default:
                            cName = "";
                            break;
                    }
                    n = rawName.length();
                    cName = cName.substring(0,n);
                    if(cName.compareToIgnoreCase(rawName) == 0) {
                        switch (rec) {
                            case "senior_ctz":
                                name = rs.getString("name");
                                gender = rs.getString("gender");
                                spouse = rs.getString("spouse");
                                contact = rs.getString("contact");
                                dob = rs.getDate("dob");
                                dor = rs.getDate("dor");
                                i++;
                                x = false;
                                M1.addRow(new Object[]{i,name,gender,dob,spouse,dor,contact});
                                break;
                            case "missing_persons":
                                String firstname =  rs.getString("first_name");
                                String lastname = rs.getString("last_name");
                                gender = rs.getString("gender");
                                float height;
                                height = rs.getFloat("height");
                                int weight;
                                weight = rs.getInt("weight");
                                String id_marks = rs.getString("id_marks");
                                String missing_loc = rs.getString("missing_location");
                                String religion = rs.getString("religion");
                                String district = rs.getString("district");
                                dob = rs.getDate("dob");
                                java.util.Date dom = rs.getDate("missing_date");
                                i++;
                                x = false;
                                M1.addRow(new Object[]{i,(firstname+" "+lastname),gender,dob,height,weight,id_marks,dom,missing_loc,religion,district});
                                break;
                            case "vehicle_theft" :
                                int sno = rs.getInt("serial_no");
                                String fname=rs.getString("first_name");
                                String lname=rs.getString("last_name");;
                                java.util.Date dob = rs.getDate("dob");
                                String gname = rs.getString("father_husband_name");
                                String address = rs.getString("address");
                                String vehtype = rs.getString("vehicle_type");
                                String vehcomp = rs.getString("vehicle_comp");
                                String vehmodel = rs.getString("vehicle_model");
                                String vehcolor = rs.getString("vehicle_color");
                                String lcno = rs.getString("license_plate_no");
                                String vehid = rs.getString("vehicle_id_no");
                                dom = rs.getDate("theft_date");
                                String lostloc = rs.getString("theft_location");
                                String contact = rs.getString("contact");
                                x = false;
                                M1.addRow(new Object[]{sno,fname,lname,gname,dob,address,vehtype,vehcomp,vehmodel,vehcolor,lcno,vehid,dom,lostloc,contact});
                                break;
                            case "mobile_theft":
                                sno = rs.getInt("serial_no");
                                fname=rs.getString("first_name");
                                lname=rs.getString("last_name");;
                                dob = rs.getDate("dob");
                                gname = rs.getString("father_husband_name");
                                address = rs.getString("address");
                                String mobcomp = rs.getString("mobile_comp");
                                String mobmodel = rs.getString("mobile_model");
                                String imei = rs.getString("IMEI_no");
                                String sim = rs.getString("sim_comp");
                                String lostmob = rs.getString("mob_no");
                                dom = rs.getDate("theft_date");
                                lostloc = rs.getString("theft_location");
                                contact = rs.getString("contact");
                                x = false;
                                M1.addRow(new Object[]{sno,fname,lname,gname,dob,address,mobcomp,mobmodel,imei,sim,lostmob,dom,lostloc,contact});
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "rec MisMatch Error!!","Error!",JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                     }
                    else {
                        if(x)
                            removeRows();
                    }
                }
                x = true;
            }
            catch(ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e,"Error!",JOptionPane.ERROR_MESSAGE);
            }
        }  
    }
    
    public final void setInitials(String recSet) {
         jPanel1.setVisible(false);
        jTextField1.setEnabled(false);
        jDateChooser1.setEnabled(false);
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        
        getRootPane().setDefaultButton(jButton2);
        
        jTable1.setAutoResizeMode(AUTO_RESIZE_OFF);
        
         rec = recSet;
        switch (rec) {
            case "senior_ctz":
                {
                    String[] columns = {"S. No.","Name","Gender","DoB","Spouse","DoR","Contact"};
                    M1.setColumnIdentifiers(columns);
                      jTable1.getColumn("Name").setPreferredWidth(130);
                      jTable1.getColumn("Contact").setPreferredWidth(130);
                      jTable1.getColumn("S. No.").setPreferredWidth(50);
                      jTable1.getColumn("Spouse").setPreferredWidth(130);
        
                    s = "select * from senior_citizen";
                    jLabel1.setText("Senior Citizen Records Are As Follows :-");
                    jMenuItem2.setText("Date of Retirement");
                    break;
                }
            case "missing_persons":
                {
                    String[] columns = {"S. No.","Name","Gender","DoB","Height","Weight","Identification Marks","Missing Date","Last Seen Location","Religion","District"};
                    M1.setColumnIdentifiers(columns);
                    jTable1.getColumn("S. No.").setPreferredWidth(50);
                    jTable1.getColumn("Name").setPreferredWidth(130);
                    jTable1.getColumn("Height").setPreferredWidth(60);
                    jTable1.getColumn("Weight").setPreferredWidth(60);
                    jTable1.getColumn("Identification Marks").setPreferredWidth(130);
                    jTable1.getColumn("Missing Date").setPreferredWidth(100);
                    jTable1.getColumn("Last Seen Location").setPreferredWidth(100);
                    jTable1.getColumn("Religion").setPreferredWidth(70);
                    jTable1.getColumn("District").setPreferredWidth(70);
                    
                    s = "select * from missing_persons";
                    jLabel1.setText("Missing Person Records Are As Follows :-");
                    jMenuItem2.setText("Missing Date");
                    break;
                }
            case "vehicle_theft":
            {
                    String[] columns = {"S. No.","First Name","Last Name","Father/Husband Name","DoB","Address","Vehicle Type","Vehicle Company","Vehicle Model","Vehicle Color","License Plate #","Vehicle ID #","Theft Date","Theft Location","Contact"};
                     M1.setColumnIdentifiers(columns);
                    
                    jTable1.getColumn("S. No.").setPreferredWidth(50);
                    jTable1.getColumn("First Name").setPreferredWidth(90);
                    jTable1.getColumn("Last Name").setPreferredWidth(90);
                    jTable1.getColumn("Father/Husband Name").setPreferredWidth(140);
                    jTable1.getColumn("DoB").setPreferredWidth(75);
                    jTable1.getColumn("Address").setPreferredWidth(150);
                    jTable1.getColumn("Vehicle Type").setPreferredWidth(100);
                    jTable1.getColumn("Vehicle Company").setPreferredWidth(110);
                    jTable1.getColumn("Vehicle Model").setPreferredWidth(110);
                    jTable1.getColumn("Vehicle Color").setPreferredWidth(110);
                    jTable1.getColumn("License Plate #").setPreferredWidth(120);
                    jTable1.getColumn("Vehicle ID #").setPreferredWidth(135);
                    jTable1.getColumn("Theft Date").setPreferredWidth(75);
                    jTable1.getColumn("Theft Location").setPreferredWidth(140);
                    jTable1.getColumn("Contact").setPreferredWidth(110);
                    
                    //jTable1.getTableHeader().setPreferredSize(new Dimension(jTable1.getColumnModel().getTotalColumnWidth(),50));
                    
                    s = "select * from vehicle_theft";
                    jLabel1.setText("Vehicle Theft Records Are As Follows :-");
                    jMenuItem2.setText("Theft/Missing Date");
                    break;
            }
            case "mobile_theft":
            {
                    String[] columns = {"S. No.","First Name","Last Name","Father/Husband Name","DoB","Address","Mobile Name","Mobile Model","IMEI","SIM Company","Lost Phone No.","Theft Date","Theft Location","Contact"};
                    M1.setColumnIdentifiers(columns);
                    jTable1.getColumn("S. No.").setPreferredWidth(50);
                    jTable1.getColumn("First Name").setPreferredWidth(90);
                    jTable1.getColumn("Last Name").setPreferredWidth(90);
                    jTable1.getColumn("Father/Husband Name").setPreferredWidth(140);
                    jTable1.getColumn("DoB").setPreferredWidth(75);
                    jTable1.getColumn("Address").setPreferredWidth(150);
                    jTable1.getColumn("Mobile Name").setPreferredWidth(85);
                    jTable1.getColumn("Mobile Model").setPreferredWidth(85);
                    jTable1.getColumn("IMEI").setPreferredWidth(135);
                    jTable1.getColumn("SIM Company").setPreferredWidth(110);
                    jTable1.getColumn("Lost Phone No.").setPreferredWidth(110);
                    jTable1.getColumn("Theft Date").setPreferredWidth(75);
                    jTable1.getColumn("Theft Location").setPreferredWidth(140);
                    jTable1.getColumn("Contact").setPreferredWidth(110);
                     
                   // jTable1.getTableHeader().setPreferredSize(new Dimension(jTable1.getColumnModel().getTotalColumnWidth(),32));
                    
                    s = "select * from mobile_theft";
                    jLabel1.setText("Mobile Theft Records Are As Follows :-");
                    jMenuItem2.setText("Theft/Missing Date");
                    break;
            }
            default:
                JOptionPane.showMessageDialog(null, "'rec' Value No Match Found :: Error!!","Error!",JOptionPane.ERROR_MESSAGE);
                break;
        }
        jTable1.setModel(M1);
    }
    
    public final void getDataBase() {
        try{
          Class.forName("com.mysql.jdbc.Driver");  
          Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/punjabpolice","root","");
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(s);
          int i = 0;
          if(null == rec)
              JOptionPane.showMessageDialog(null, "'rec' Value No Match Found :: Error!!","Error!",JOptionPane.ERROR_MESSAGE);
          else switch (rec) {
                case "senior_ctz":
                    while(rs.next()){
                        name = rs.getString("name");
                        gender = rs.getString("gender");
                        spouse = rs.getString("spouse");
                        contact = rs.getString("contact");
                        dob = rs.getDate("dob");
                        dor = rs.getDate("dor");
                        i++;
                        M1.addRow(new Object[]{i,name,gender,dob,spouse,dor,contact});
                    }       break;
                case "missing_persons":
                    while(rs.next()){
                        String firstname =  rs.getString("first_name");
                        String lastname = rs.getString("last_name");
                        gender = rs.getString("gender");
                        float height;
                        height = rs.getFloat("height");
                        int weight;
                        weight = rs.getInt("weight");
                        String id_marks = rs.getString("id_marks");
                        String missing_loc = rs.getString("missing_location");
                        String religion = rs.getString("religion");
                        String district = rs.getString("district");
                        dob = rs.getDate("dob");
                        java.util.Date dom = rs.getDate("missing_date");
                        i++;
                        M1.addRow(new Object[]{i,(firstname+" "+lastname),gender,dob,height,weight,id_marks,dom,missing_loc,religion,district});
                    }     break;
                case "vehicle_theft":
                    while(rs.next()){
                                int sno = rs.getInt("serial_no");
                                String fname=rs.getString("first_name");
                                String lname=rs.getString("last_name");;
                                java.util.Date dob = rs.getDate("dob");
                                String gname = rs.getString("father_husband_name");
                                String address = rs.getString("address");
                                String vehtype = rs.getString("vehicle_type");
                                String vehcomp = rs.getString("vehicle_comp");
                                String vehmodel = rs.getString("vehicle_model");
                                String vehcolor = rs.getString("vehicle_color");
                                String lcno = rs.getString("license_plate_no");
                                String vehid = rs.getString("vehicle_id_no");
                                java.util.Date dom = rs.getDate("theft_date");
                                String lostloc = rs.getString("theft_location");
                                String contact = rs.getString("contact");
                                M1.addRow(new Object[]{sno,fname,lname,gname,dob,address,vehtype,vehcomp,vehmodel,vehcolor,lcno,vehid,dom,lostloc,contact});
                    } break;
                case "mobile_theft":
                    while(rs.next()){
                                int sno = rs.getInt("serial_no");
                                String fname=rs.getString("first_name");
                                String lname=rs.getString("last_name");;
                                java.util.Date dob = rs.getDate("dob");
                                String gname = rs.getString("father_husband_name");
                                String address = rs.getString("address");
                                String mobcomp = rs.getString("mobile_comp");
                                String mobmodel = rs.getString("mobile_model");
                                String imei = rs.getString("IMEI_no");
                                String sim = rs.getString("sim_comp");
                                String lostmob = rs.getString("mob_no");
                                java.util.Date dom = rs.getDate("theft_date");
                                String lostloc = rs.getString("theft_location");
                                String contact = rs.getString("contact");
                                M1.addRow(new Object[]{sno,fname,lname,gname,dob,address,mobcomp,mobmodel,imei,sim,lostmob,dom,lostloc,contact});
                    } break;                   
                default:
                    JOptionPane.showMessageDialog(null, "'rec' Value No Match Found :: Error!!","Error!",JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Records(String recSet) {
        initComponents();
        setLocationRelativeTo(null);
        setInitials(recSet);
        getDataBase();
    }
    
    public void removeRows() {
        int row_count = M1.getRowCount();
        //for(int k =0 ; k<row_count-1;k++)
        //    M1.removeRow(k);
        while(row_count != 0) {
            M1.removeRow(row_count-1);
            row_count -= 1;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jMenuItem1.setText("Name");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Date");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setText("Date of Birth");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Records");
        setResizable(false);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setModel(M1);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Search Records");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("By Date");
        jRadioButton2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton2ItemStateChanged(evt);
            }
        });

        jRadioButton1.setText("By Name");
        jRadioButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton1ItemStateChanged(evt);
            }
        });

        jDateChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jDateChooser1MouseReleased(evt);
            }
        });
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jTextField1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField1InputMethodTextChanged(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextField1PropertyChange(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jRadioButton2)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Sort By");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton6)
                        .addComponent(jButton5))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new HomeScreen().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jPanel1.setVisible(true);
        jRadioButton1.setSelected(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField1InputMethodTextChanged

    }//GEN-LAST:event_jTextField1InputMethodTextChanged

    private void jTextField1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextField1PropertyChange
        
    }//GEN-LAST:event_jTextField1PropertyChange

    private void jRadioButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton1ItemStateChanged
        if(jRadioButton1.isSelected())       
            jTextField1.setEnabled(true);
        else
            jTextField1.setEnabled(false);
    }//GEN-LAST:event_jRadioButton1ItemStateChanged

    private void jRadioButton2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton2ItemStateChanged
        if(jRadioButton2.isSelected())
            jDateChooser1.setEnabled(true);
        else
            jDateChooser1.setEnabled(false);
    }//GEN-LAST:event_jRadioButton2ItemStateChanged

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        nameChooser();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        if(jRadioButton2.isSelected())
            dateChooser();
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        removeRows();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        removeRows();
        getDataBase();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jDateChooser1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseReleased

    }//GEN-LAST:event_jDateChooser1MouseReleased

    private void jDateChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        jPopupMenu1.show(jButton6,20,10);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here: Sort by name
        removeRows();
        TreeSet<String> T1 = new TreeSet<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/punjabpolice","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(s);
            String temp4;
            while(rs.next()){
                switch (rec) {
                    case "senior_ctz":
                        temp4 = rs.getString("name");
                        T1.add(temp4);
                        break;
                    case "missing_persons":
                        temp4 = rs.getString("first_name")+" "+rs.getString("last_name");
                        T1.add(temp4);
                        break;
                    case "mobile_theft":
                        temp4 = rs.getString("first_name")+" "+rs.getString("last_name");
                        T1.add(temp4);
                        break;
                     case "vehicle_theft":
                        temp4 = rs.getString("first_name")+" "+rs.getString("last_name");
                        T1.add(temp4);
                        break;   
                    default:
                        JOptionPane.showMessageDialog(null, "'rec' Value No Match Found :: Error!!","Error!",JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
            for (Iterator<String> it = T1.iterator(); it.hasNext();) {    
                rs = st.executeQuery(s);
                String temp = it.next();
                int ii;
                switch (rec) {
                case "senior_ctz":
                    while(rs.next()){
                        temp4 = rs.getString("name");
                        if(temp4.equals(temp)) {
                            name = rs.getString("name");
                            gender = rs.getString("gender");
                            spouse = rs.getString("spouse");
                            contact = rs.getString("contact");
                            dob = rs.getDate("dob");
                            dor = rs.getDate("dor");
                            ii = rs.getInt("serial_no");
                            M1.addRow(new Object[]{ii,name,gender,dob,spouse,dor,contact});
                        }
                    }       break;
                case "missing_persons":
                    while(rs.next()){
                        temp4 = rs.getString("first_name")+" "+rs.getString("last_name");
                        if(temp4.equals(temp)) {
                            String firstname =  rs.getString("first_name");
                            String lastname = rs.getString("last_name");
                            gender = rs.getString("gender");
                            float height;
                            height = rs.getFloat("height");
                            int weight;
                            weight = rs.getInt("weight");
                            String id_marks = rs.getString("id_marks");
                            String missing_loc = rs.getString("missing_location");
                            String religion = rs.getString("religion");
                            String district = rs.getString("district");
                            dob = rs.getDate("dob");
                            java.util.Date dom = rs.getDate("missing_date");
                            ii = rs.getInt("serial_no");
                            M1.addRow(new Object[]{ii,(firstname+" "+lastname),gender,dob,height,weight,id_marks,dom,missing_loc,religion,district});
                    } 
                    }break;
                case "vehicle_theft":
                    while(rs.next()){
                        temp4= rs.getString("first_name")+" "+rs.getString("last_name");
                        if(temp4.equals(temp)){
                            int sno = rs.getInt("serial_no");
                                String fname=rs.getString("first_name");
                                String lname=rs.getString("last_name");;
                                java.util.Date dob = rs.getDate("dob");
                                String gname = rs.getString("father_husband_name");
                                String address = rs.getString("address");
                                String vehtype = rs.getString("vehicle_type");
                                String vehcomp = rs.getString("vehicle_comp");
                                String vehmodel = rs.getString("vehicle_model");
                                String vehcolor = rs.getString("vehicle_color");
                                String lcno = rs.getString("license_plate_no");
                                String vehid = rs.getString("vehicle_id_no");
                                java.util.Date dom = rs.getDate("theft_date");
                                String lostloc = rs.getString("theft_location");
                                String contact = rs.getString("contact");
                                M1.addRow(new Object[]{sno,fname,lname,gname,dob,address,vehtype,vehcomp,vehmodel,vehcolor,lcno,vehid,dom,lostloc,contact});
                        }
                    }
                    break;
                case "mobile_theft":
                    while(rs.next()){
                        temp4= rs.getString("first_name")+" "+rs.getString("last_name");
                        if(temp4.equals(temp)){
                                 int sno = rs.getInt("serial_no");
                                String fname=rs.getString("first_name");
                                String lname=rs.getString("last_name");;
                                java.util.Date dob = rs.getDate("dob");
                                String gname = rs.getString("father_husband_name");
                                String address = rs.getString("address");
                                String mobcomp = rs.getString("mobile_comp");
                                String mobmodel = rs.getString("mobile_model");
                                String imei = rs.getString("IMEI_no");
                                String sim = rs.getString("sim_comp");
                                String lostmob = rs.getString("mob_no");
                                java.util.Date dom = rs.getDate("theft_date");
                                String lostloc = rs.getString("theft_location");
                                String contact = rs.getString("contact");
                                M1.addRow(new Object[]{sno,fname,lname,gname,dob,address,mobcomp,mobmodel,imei,sim,lostmob,dom,lostloc,contact});
                        }
                    }
                    break;
                    default:
                    JOptionPane.showMessageDialog(null, "'rec' Value No Match Found :: Error!!","Error!",JOptionPane.ERROR_MESSAGE);
                    break;
                    }
                }
            }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e,"Error!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int ll= M1.getRowCount();
        removeRows();
        TreeSet<java.util.Date> T1 = new TreeSet<>();
        java.util.Date unsDate ;
        java.util.Date sDate;
        java.util.Date tempDate;
        String ssDate;
        String sunsDate;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/punjabpolice","root","");
            Statement st = con.createStatement();
            ResultSet rs1 = st.executeQuery(s);
            while(rs1.next()){
                switch (rec) {
                    case "senior_ctz":
                        tempDate = rs1.getDate("dor");
                         T1.add(tempDate);
                        break;
                    case "missing_persons":
                        tempDate = rs1.getDate("missing_date");
                         T1.add(tempDate);
                        break;
                    case "mobile_theft":
                        tempDate = rs1.getDate("theft_date");
                        T1.add(tempDate);
                        break;
                    case "vehicle_theft":
                        tempDate = rs1.getDate("theft_date");
                        T1.add(tempDate);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "'rec' Value No Match Found :: Error!!","Error!",JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
            for(Iterator itr=T1.iterator() ; itr.hasNext();) {
                ssDate = String.valueOf(itr.next());
                rs1 = st.executeQuery(s);
                int ii;
                switch (rec) {
                case "senior_ctz":
                    while(rs1.next()){
                    unsDate = rs1.getDate("dor");
                    sunsDate = f.format(unsDate);
                        if(sunsDate.equals(ssDate)) {
                            name = rs1.getString("name");
                            gender = rs1.getString("gender");
                            spouse = rs1.getString("spouse");
                            contact = rs1.getString("contact");
                            dob = rs1.getDate("dob");
                            dor = rs1.getDate("dor");
                            ii = rs1.getInt("serial_no");
                            M1.addRow(new Object[]{ii,name,gender,dob,spouse,dor,contact});
                        }
                    }       break;
                case "missing_persons":
                    while(rs1.next()){
                      unsDate = rs1.getDate("missing_date");
                      sunsDate = f.format(unsDate);
                        if(sunsDate.equals(ssDate)) {
                            String firstname =  rs1.getString("first_name");
                            String lastname = rs1.getString("last_name");
                            gender = rs1.getString("gender");
                            float height;
                            height = rs1.getFloat("height");
                            int weight;
                            weight = rs1.getInt("weight");
                            String id_marks = rs1.getString("id_marks");
                            String missing_loc = rs1.getString("missing_location");
                            String religion = rs1.getString("religion");
                            String district = rs1.getString("district");
                            dob = rs1.getDate("dob");
                            java.util.Date dom = rs1.getDate("missing_date");
                            ii = rs1.getInt("serial_no");
                            M1.addRow(new Object[]{ii,(firstname+" "+lastname),gender,dob,height,weight,id_marks,dom,missing_loc,religion,district});
                    } 
                    }break;
                case "vehicle_theft":
                    while(rs1.next()){
                        unsDate = rs1.getDate("theft_date");
                        sunsDate = f.format(unsDate);
                        if(sunsDate.equals(ssDate)){
                                int sno = rs1.getInt("serial_no");
                                String fname=rs1.getString("first_name");
                                String lname=rs1.getString("last_name");;
                                java.util.Date dob = rs1.getDate("dob");
                                String gname = rs1.getString("father_husband_name");
                                String address = rs1.getString("address");
                                String vehtype = rs1.getString("vehicle_type");
                                String vehcomp = rs1.getString("vehicle_comp");
                                String vehmodel = rs1.getString("vehicle_model");
                                String vehcolor = rs1.getString("vehicle_color");
                                String lcno = rs1.getString("license_plate_no");
                                String vehid = rs1.getString("vehicle_id_no");
                                java.util.Date dom = rs1.getDate("theft_date");
                                String lostloc = rs1.getString("theft_location");
                                String contact = rs1.getString("contact");
                                M1.addRow(new Object[]{sno,fname,lname,gname,dob,address,vehtype,vehcomp,vehmodel,vehcolor,lcno,vehid,dom,lostloc,contact});
                        }
                    }break;
                case "mobile_theft":
                    while(rs1.next()){
                        unsDate = rs1.getDate("theft_date");
                        sunsDate = f.format(unsDate);
                        if(sunsDate.equals(ssDate)){
                                int sno = rs1.getInt("serial_no");
                                String fname=rs1.getString("first_name");
                                String lname=rs1.getString("last_name");;
                                java.util.Date dob = rs1.getDate("dob");
                                String gname = rs1.getString("father_husband_name");
                                String address = rs1.getString("address");
                                String mobcomp = rs1.getString("mobile_comp");
                                String mobmodel = rs1.getString("mobile_model");
                                String imei = rs1.getString("IMEI_no");
                                String sim = rs1.getString("sim_comp");
                                String lostmob = rs1.getString("mob_no");
                                java.util.Date dom = rs1.getDate("theft_date");
                                String lostloc = rs1.getString("theft_location");
                                String contact = rs1.getString("contact");
                                M1.addRow(new Object[]{sno,fname,lname,gname,dob,address,mobcomp,mobmodel,imei,sim,lostmob,dom,lostloc,contact});
                        }
                    }break;
                    default:
                    JOptionPane.showMessageDialog(null, "'rec' Value No Match Found :: Error!!","Error!",JOptionPane.ERROR_MESSAGE);
                    break;
                    }
                }
            }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e,"Error!",JOptionPane.ERROR_MESSAGE);
        }  
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here: Sort By Dob
        int ll= M1.getRowCount();
        removeRows();
        TreeSet<java.util.Date> T1 = new TreeSet<>();
        java.util.Date unsDate ;
        java.util.Date sDate;
        java.util.Date tempDate;
        String ssDate;
        String sunsDate;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/punjabpolice","root","");
            Statement st = con.createStatement();
            ResultSet rs1 = st.executeQuery(s);
            while(rs1.next()){
                        tempDate = rs1.getDate("dob");
                         T1.add(tempDate);
            }
            for(Iterator itr=T1.iterator() ; itr.hasNext();) {
                ssDate = String.valueOf(itr.next());
                rs1 = st.executeQuery(s);
                int ii;
                switch (rec) {
                case "senior_ctz":
                    while(rs1.next()){
                    unsDate = rs1.getDate("dob");
                    sunsDate = f.format(unsDate);
                        if(sunsDate.equals(ssDate)) {
                            name = rs1.getString("name");
                            gender = rs1.getString("gender");
                            spouse = rs1.getString("spouse");
                            contact = rs1.getString("contact");
                            dob = rs1.getDate("dob");
                            dor = rs1.getDate("dor");
                            ii = rs1.getInt("serial_no");
                            M1.addRow(new Object[]{ii,name,gender,dob,spouse,dor,contact});
                        }
                    }       break;
                case "missing_persons":
                    while(rs1.next()){
                      unsDate = rs1.getDate("dob");
                      sunsDate = f.format(unsDate);
                        if(sunsDate.equals(ssDate)) {
                            String firstname =  rs1.getString("first_name");
                            String lastname = rs1.getString("last_name");
                            gender = rs1.getString("gender");
                            float height;
                            height = rs1.getFloat("height");
                            int weight;
                            weight = rs1.getInt("weight");
                            String id_marks = rs1.getString("id_marks");
                            String missing_loc = rs1.getString("missing_location");
                            String religion = rs1.getString("religion");
                            String district = rs1.getString("district");
                            dob = rs1.getDate("dob");
                            java.util.Date dom = rs1.getDate("missing_date");
                            ii = rs1.getInt("serial_no");
                            M1.addRow(new Object[]{ii,(firstname+" "+lastname),gender,dob,height,weight,id_marks,dom,missing_loc,religion,district});
                    } 
                    }break;
               case "vehicle_theft":
                    while(rs1.next()){
                        unsDate = rs1.getDate("dob");
                        sunsDate = f.format(unsDate);
                        if(sunsDate.equals(ssDate)){
                                int sno = rs1.getInt("serial_no");
                                String fname=rs1.getString("first_name");
                                String lname=rs1.getString("last_name");;
                                java.util.Date dob = rs1.getDate("dob");
                                String gname = rs1.getString("father_husband_name");
                                String address = rs1.getString("address");
                                String vehtype = rs1.getString("vehicle_type");
                                String vehcomp = rs1.getString("vehicle_comp");
                                String vehmodel = rs1.getString("vehicle_model");
                                String vehcolor = rs1.getString("vehicle_color");
                                String lcno = rs1.getString("license_plate_no");
                                String vehid = rs1.getString("vehicle_id_no");
                                java.util.Date dom = rs1.getDate("theft_date");
                                String lostloc = rs1.getString("theft_location");
                                String contact = rs1.getString("contact");
                                M1.addRow(new Object[]{sno,fname,lname,gname,dob,address,vehtype,vehcomp,vehmodel,vehcolor,lcno,vehid,dom,lostloc,contact});
                        }
                    }break;
                case "mobile_theft":
                    while(rs1.next()){
                        unsDate = rs1.getDate("dob");
                        sunsDate = f.format(unsDate);
                        if(sunsDate.equals(ssDate)){
                                int sno = rs1.getInt("serial_no");
                                String fname=rs1.getString("first_name");
                                String lname=rs1.getString("last_name");;
                                java.util.Date dob = rs1.getDate("dob");
                                String gname = rs1.getString("father_husband_name");
                                String address = rs1.getString("address");
                                String mobcomp = rs1.getString("mobile_comp");
                                String mobmodel = rs1.getString("mobile_model");
                                String imei = rs1.getString("IMEI_no");
                                String sim = rs1.getString("sim_comp");
                                String lostmob = rs1.getString("mob_no");
                                java.util.Date dom = rs1.getDate("theft_date");
                                String lostloc = rs1.getString("theft_location");
                                String contact = rs1.getString("contact");
                                M1.addRow(new Object[]{sno,fname,lname,gname,dob,address,mobcomp,mobmodel,imei,sim,lostmob,dom,lostloc,contact});
                        }
                    }break;
                    default:
                    JOptionPane.showMessageDialog(null, "'rec' Value No Match Found :: Error!!","Error!",JOptionPane.ERROR_MESSAGE);
                    break;
                    }
                }
            }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e,"Error!",JOptionPane.ERROR_MESSAGE);
        }  
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Records("Something").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
