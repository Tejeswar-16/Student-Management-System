import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.*;

class Student
{
    String url,un,pw;

    JFrame mainframe;
    JPanel p1,p2;
    JLabel lbltitle,lblrno,lblname,lblcgpa,lbldrno,lblurno,lblyr,lbldept,lbldh,lblftu,lblnewdata;
    JTextField txtrno,txtname,txtcgpa,txtdrno,txtupdate,txturno,txtdept,txtnewdata;
    JButton btnAdd,btnDelete,btnUpdate,btnClear,btnd,btnu;
    JComboBox<String> cbyr,cbdh,cbdata;
    JTable table;
    DefaultTableModel model;
    JScrollPane scrollPane;
    int c=0;

    Student()
    {
        mainframe = new JFrame("Student App");
        mainframe.setLayout(null);
        mainframe.setVisible(true);
        mainframe.setSize(1600,1080);
        mainframe.getContentPane().setBackground(new Color(0,80,100));
        mainframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(50,50,700,800);
        p1.setBackground(new Color(176,156,217));
        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(800,50,700,800);
        p2.setBackground(new Color(255,223,186));

        mainframe.add(p1);
        mainframe.add(p2);

        lbltitle = new JLabel("STUDENT MANAGEMENT SYSTEM");
        lbltitle.setFont(new Font("times new roman",Font.BOLD,30));
        lbltitle.setForeground(Color.WHITE);
        lbltitle.setBounds(510,0,600,50);
        mainframe.add(lbltitle);

        lblrno = new JLabel("Register Number");
        lblrno.setFont(new Font("times new roman",Font.BOLD,20));
        lblrno.setBounds(50,45,150,50);
        p1.add(lblrno);

        txtrno = new JTextField();
        txtrno.setFont(new Font("times new roman",Font.PLAIN,20));
        txtrno.setBounds(270,50,300,40);
        p1.add(txtrno);

        lblname = new JLabel("Name");
        lblname.setFont(new Font("times new roman",Font.BOLD,20));
        lblname.setBounds(50,95,150,50);
        p1.add(lblname);

        txtname = new JTextField();
        txtname.setFont(new Font("times new roman",Font.PLAIN,20));
        txtname.setBounds(270,100,300,40);
        p1.add(txtname);

        lblyr = new JLabel("Year");
        lblyr.setFont(new Font("times new roman",Font.BOLD,20));
        lblyr.setBounds(50,145,150,50);
        p1.add(lblyr);

        String year[] = {"Select","I year","II year","III year","IV year"};
        cbyr = new JComboBox<>(year);
        cbyr.setFont(new Font("times new roman",Font.PLAIN,20));
        cbyr.setBounds(270,150,300,40);
        p1.add(cbyr);

        lblcgpa = new JLabel("CGPA");
        lblcgpa.setFont(new Font("times new roman",Font.BOLD,20));
        lblcgpa.setBounds(50,195,150,50);
        p1.add(lblcgpa);

        txtcgpa = new JTextField();
        txtcgpa.setFont(new Font("times new roman",Font.PLAIN,20));
        txtcgpa.setBounds(270,200,300,40);
        p1.add(txtcgpa);

        lbldept = new JLabel("Department");
        lbldept.setFont(new Font("times new roman",Font.BOLD,20));
        lbldept.setBounds(50,245,150,50);
        p1.add(lbldept);

        txtdept = new JTextField();
        txtdept.setFont(new Font("times new roman",Font.PLAIN,20));
        txtdept.setBounds(270,250,300,40);
        p1.add(txtdept);

        lbldh = new JLabel("Status");
        lbldh.setFont(new Font("times new roman",Font.BOLD,20));
        lbldh.setBounds(50,295,150,50);
        p1.add(lbldh);

        String dh[] = {"Select","Dayscholar","Hosteler"};
        cbdh = new JComboBox<>(dh);
        cbdh.setFont(new Font("times new roman",Font.PLAIN,20));
        cbdh.setBounds(270,300,300,40);
        p1.add(cbdh);

        btnAdd =  new JButton("Add");
        btnAdd.setBounds(50,370,120,40);
        btnAdd.setFont(new Font("times new roman",Font.BOLD,20));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p1.add(btnAdd);

        btnDelete =  new JButton("Delete");
        btnDelete.setBounds(200,370,120,40);
        btnDelete.setFont(new Font("times new roman",Font.BOLD,20));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p1.add(btnDelete);

        btnUpdate =  new JButton("Update");
        btnUpdate.setBounds(350,370,120,40);
        btnUpdate.setFont(new Font("times new roman",Font.BOLD,20));
        btnUpdate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p1.add(btnUpdate);

        btnClear =  new JButton("Clear");
        btnClear.setBounds(500,370,120,40);
        btnClear.setFont(new Font("times new roman",Font.BOLD,20));
        btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p1.add(btnClear);

        lbldrno = new JLabel("Register Number to be deleted");
        lbldrno.setBounds(50,450,390,40);
        lbldrno.setFont(new Font("times new roman",Font.BOLD,20));
        p1.add(lbldrno);
        lbldrno.setVisible(false);

        txtdrno = new JTextField();
        txtdrno.setBounds(350,450,300,40);
        txtdrno.setFont(new Font("times new roman",Font.PLAIN,20));
        p1.add(txtdrno);
        txtdrno.setVisible(false);

        btnd =  new JButton("Delete");
        btnd.setBounds(240,520,120,35);
        btnd.setFont(new Font("times new roman",Font.BOLD,20));
        btnd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p1.add(btnd);
        btnd.setVisible(false);

        lblurno = new JLabel("Register Number to be Updated");
        lblurno.setBounds(50,450,390,40);
        lblurno.setFont(new Font("times new roman",Font.BOLD,20));
        p1.add(lblurno);
        lblurno.setVisible(false);

        txturno = new JTextField();
        txturno.setBounds(350,450,300,40);
        txturno.setFont(new Font("times new roman",Font.PLAIN,20));
        p1.add(txturno);
        txturno.setVisible(false);

        txtupdate =  new JTextField();
        txtupdate.setBounds(240,400,120,35);
        txtupdate.setFont(new Font("times new roman",Font.PLAIN,20));
        p1.add(txtupdate);
        txtupdate.setVisible(false);

        lblftu = new JLabel("Field to be Updated");
        lblftu.setBounds(50,500,390,40);
        lblftu.setFont(new Font("times new roman",Font.BOLD,20));
        p1.add(lblftu);
        lblftu.setVisible(false);

        String[] data = {"Select","Register Number","Name","Year","CGPA","Department","Status"};
        cbdata = new JComboBox<>(data);
        cbdata.setBounds(350,500,300,40);
        cbdata.setFont(new Font("times new roman",Font.PLAIN,20));
        p1.add(cbdata);
        cbdata.setVisible(false);

        btnu =  new JButton("Update");
        btnu.setBounds(240,620,120,35);
        btnu.setFont(new Font("times new roman",Font.BOLD,20));
        btnu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p1.add(btnu);
        btnu.setVisible(false);

        model = new DefaultTableModel();
        model.addColumn("Register No");
        model.addColumn("Name");
        model.addColumn("Year");
        model.addColumn("CGPA");
        model.addColumn("Department");
        model.addColumn("Status");
        table = new JTable(model);
        table.setFont(new Font("times new roman",Font.PLAIN,20));
        table.setForeground(Color.YELLOW);
        table.setRowHeight(30);
        table.setBackground(new Color(0,0,128));
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20,20,657,757);
        p2.add(scrollPane);

        mainframe.revalidate();
        mainframe.repaint();

        url = "jdbc:mysql://localhost:3306/sms";
        un = "root";
        pw = "!Sairam@123";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, un, pw);
            String qry2 = "select * from student";
            PreparedStatement pstmt2 = con.prepareStatement(qry2);
            ResultSet rs1 = pstmt2.executeQuery();

            while (rs1.next())
            {
                int drn = rs1.getInt("register_number");
                String dname = rs1.getString("name");
                String dyear = rs1.getString("year");
                double dcgpa = rs1.getDouble("cgpa");
                String ddept = rs1.getString("dept");
                String dstatus = rs1.getString("status");
                model.addRow(new Object[]{drn, dname, dyear, dcgpa, ddept, dstatus});
            }
        }
        catch (Exception e){}

        mainframe.revalidate();
        mainframe.repaint();
    }

    public void printData()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, un, pw);

            String qry2 = "select * from student";
            PreparedStatement pstmt2 = con.prepareStatement(qry2);
            ResultSet rs1 = pstmt2.executeQuery();

            model.setRowCount(0);
            while (rs1.next()) {
                int rn = rs1.getInt("register_number");
                String name = rs1.getString("name");
                String year = rs1.getString("year");
                double cgpa = rs1.getDouble("cgpa");
                String dept = rs1.getString("dept");
                String status = rs1.getString("status");
                model.addRow(new Object[]{rn, name, year, cgpa, dept, status});
            }
        }
        catch (Exception ex){}
    }

    public boolean isValidDigit(String str)
    {
        char[] c = str.toCharArray();
        for (int i=0;i<c.length;i++)
        {
            if (c[i]<'0' || c[i]>'9')
                return false;
        }
        return true;
    }

    public boolean isValidCGPA(String str)
    {
        int count=0;
        char[] c = str.toCharArray();
        for (char value : c) {
            if (value == '.') {
                count++;
                if (count > 1)
                    return false;
            } else if (value < '0' || value > '9')
                return false;
        }
        return true;
    }

    public void addData()
    {
        btnAdd.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                lblurno.setVisible(false);
                txturno.setVisible(false);
                btnu.setVisible(false);
                cbdata.setVisible(false);
                lbldrno.setVisible(false);
                txtdrno.setVisible(false);
                btnd.setVisible(false);
                lblftu.setVisible(false);
                try
                {
                    String strregno = txtrno.getText();
                    String strname = txtname.getText();
                    String stryear = cbyr.getSelectedItem().toString();
                    String strcgpa = txtcgpa.getText();
                    String strdept = txtdept.getText();
                    String strstatus = cbdh.getSelectedItem().toString();

                    if (strregno.isEmpty() || strname.isEmpty() || stryear.equals("Select") || strcgpa.isEmpty() || strdept.isEmpty() || strstatus.equals("Select")) {
                        JOptionPane.showMessageDialog(mainframe, "All fields are mandatory");
                        return;
                    }
                    if (strregno.length()!=9 || !isValidDigit(strregno)) {
                        JOptionPane.showMessageDialog(mainframe, "Invalid Register Number");
                        txtrno.setText("");
                        return;
                    }
                    if (strcgpa.length()>6 || !isValidCGPA(strcgpa)) {
                        JOptionPane.showMessageDialog(mainframe, "Invalid CGPA");
                        txtcgpa.setText("");
                        return;
                    }

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, un, pw);
                    String qry1 = "insert into student values (?,?,?,?,?,?)";
                    PreparedStatement pstmt1 = con.prepareStatement(qry1);
                    pstmt1.setInt(1, Integer.parseInt(strregno));
                    pstmt1.setString(2, strname);
                    pstmt1.setString(3, stryear);
                    pstmt1.setDouble(4, Double.parseDouble(strcgpa));
                    pstmt1.setString(5, strdept);
                    pstmt1.setString(6, strstatus);
                    int c1 = pstmt1.executeUpdate();
                    JOptionPane.showMessageDialog(mainframe, "Added Successfully");
                    txtrno.setText("");
                    txtname.setText("");
                    txtcgpa.setText("");
                    txtdept.setText("");
                    cbyr.setSelectedItem("Select");
                    cbdh.setSelectedItem("Select");

                    printData();
                }
                catch (Exception e) {}
            }
        });
    }

    public void clearData()
    {
        btnClear.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtrno.setText("");
                txtname.setText("");
                txtcgpa.setText("");
                txtdept.setText("");
                cbyr.setSelectedItem("Select");
                cbdh.setSelectedItem("Select");
                lbldrno.setVisible(false);
                txtdrno.setVisible(false);
                btnd.setVisible(false);
                btnu.setVisible(false);
                txtupdate.setVisible(false);
                lblurno.setVisible(false);
                txturno.setVisible(false);
                lblurno.setVisible(false);
                txturno.setVisible(false);
                btnu.setVisible(false);
                cbdata.setVisible(false);
                lblftu.setVisible(false);
            }
        });
    }

    public  void updateData()
    {
        btnUpdate.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                lblurno.setVisible(true);
                txturno.setVisible(true);
                btnu.setVisible(true);
                cbdata.setVisible(true);
                lblftu.setVisible(true);
                lbldrno.setVisible(false);
                txtdrno.setVisible(false);
                btnd.setVisible(false);

                cbdata.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        c++;
                        if (c!=1)
                        {
                            lblnewdata.setVisible(false);
                            txtnewdata.setVisible(false);
                        }
                        String field = cbdata.getSelectedItem().toString();
                        if (field.equals("Select"))
                            JOptionPane.showMessageDialog(mainframe, "Choose the field to be updated");
                        else {
                            lblnewdata = new JLabel("New " + field);
                            lblnewdata.setBounds(50, 550, 390, 40);
                            lblnewdata.setFont(new Font("times new roman", Font.BOLD, 20));
                            p1.add(lblnewdata);

                            txtnewdata = new JTextField();
                            txtnewdata.setBounds(350, 550, 300, 40);
                            txtnewdata.setFont(new Font("times new roman", Font.PLAIN, 20));
                            p1.add(txtnewdata);

                            p1.revalidate();
                            p1.repaint();
                        }
                    }
                });
                btnu.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            String str="";
                            String data = cbdata.getSelectedItem().toString();
                            if (data.equals("Register Number"))
                                str+="register_number";
                            else if (data.equals("Name"))
                                str+="name";
                            else if (data.equals("Year"))
                                str+="year";
                            else if (data.equals("CGPA"))
                                str+="cgpa";
                            else if (data.equals("Department"))
                                str+="dept";
                            else if (data.equals("Status"))
                                str+="status";

                            String updateregno = txturno.getText().toString();
                            String newdata = txtnewdata.getText().toString();

                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con = DriverManager.getConnection(url,un,pw);
                            String qry4 = "update student set "+str+" = ? where register_number = ?";
                            PreparedStatement pstmt4 = con.prepareStatement(qry4);
                            pstmt4.setString(1,newdata);
                            pstmt4.setInt(2,Integer.parseInt(updateregno));
                            int c4 = pstmt4.executeUpdate();
                            JOptionPane.showMessageDialog(mainframe,"Updated Successfully");
                            txtnewdata.setText("");txturno.setText("");cbdata.setSelectedItem("Select");
                            printData();
                        }
                        catch (Exception ex){}
                    }
                });
            }
        });
    }

    public  void deleteData()
    {
        btnDelete.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                lbldrno.setVisible(true);
                txtdrno.setVisible(true);
                btnd.setVisible(true);
                lblurno.setVisible(false);
                txturno.setVisible(false);
                btnu.setVisible(false);
                lblftu.setVisible(false);
                cbdata.setVisible(false);

                btnd.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                                String regno = txtdrno.getText();
                                if (txtdrno.getText().toString().equals(""))
                                    JOptionPane.showMessageDialog(mainframe,"Register Number is mandatory");
                                else {
                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                    Connection con = DriverManager.getConnection(url, un, pw);
                                    int result = JOptionPane.showConfirmDialog(mainframe, "Are you sure? Deleted data cannot be retrieved");
                                    if (result == 0) {
                                        String qry3 = "delete from student where register_number = ?";
                                        PreparedStatement pstmt3 = con.prepareStatement(qry3);
                                        pstmt3.setInt(1, Integer.parseInt(regno));
                                        int c2 = pstmt3.executeUpdate();
                                        if (c2 > 0)
                                            JOptionPane.showMessageDialog(mainframe, "Deleted Successfully");
                                        else
                                            JOptionPane.showMessageDialog(mainframe, "Register Number not found");
                                        printData();
                                        txtdrno.setText("");
                                    } else if (result == 1 || result == 2) {
                                        JOptionPane.showMessageDialog(mainframe, "Cancelled");
                                    }
                                }
                        }
                        catch (Exception ex){}
                    }
                });
            }
        });
    }
}
class StudentApp
{
    public static void  main (String[] args)
    {
        Student s = new Student();
        s.addData();
        s.clearData();
        s.updateData();
        s.deleteData();
    }
}
