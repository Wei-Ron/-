package student;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class StudentAdd extends JFrame implements ActionListener{
  Connection con; //与特定数据库的连接（会话）。
  Statement sql; //用于执行静态 SQL 语句并返回它所生成结果的对象。
  JButton b1,b2,b3;//定义两个按钮
  JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11;//定义需要的文本框
  Box baseBox,bv1,bv2;//创建三个容器
  ImageIcon groundIcon;
  JLabel  label;
  JPanel p1=new JPanel();//定义一个面板的对象为p1
  JPanel p2=new JPanel();//定义一个面板对象为p2
  JPanel p3=new JPanel();//定义一个面板对象为p3
  
  
  StudentAdd(){
   try{										//错误处理机制
    Class.forName("com.mysql.jdbc.Driver");	//通过 Class.forName为数据库管理系统加载一个JDBC驱动程序。
    }
   catch(ClassNotFoundException e){}		//如果加载驱动失败 控制台抛出异常
    try{									//如果加载驱动成功， 调用驱动连接特定数据库
     con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/text","root","123");
     System.out.println("连接成功");
     sql=con.createStatement();  //调取con成员方法获取Statement对象
    }
    catch(SQLException ee){}//异常处理块
   
 
	ImageIcon background = new ImageIcon("src/2.jpg");
	label=new JLabel(background);
	this.getLayeredPane().setLayout(null);
	label.setBounds(0, 0, 800,650);
	this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
	
	
 //定义需要个数的16字长的文本框
   tf1=new JTextField(16);
   tf2=new JTextField(16);
   tf3=new JTextField(16);
   tf4=new JTextField(16);
   tf5=new JTextField(16);
   tf6=new JTextField(16);
   tf7=new JTextField(16);
   tf8=new JTextField(16);
   tf9=new JTextField(16);
   tf10=new JTextField(16);
   tf11=new JTextField(16);
   //定义两个按钮，并给予名称
   b1=new JButton("录入");  
   b2=new JButton("重置");
   b3=new JButton("退出");
 //给两个按钮添加监视器
   b1.addActionListener(this);
   b2.addActionListener(this);
   b3.addActionListener(this);
  p2.add(b1);
  p2.add(b2);
  p2.add(b3);
   //创建一个垂直容器为bv1
   bv1=Box.createVerticalBox();
   //将标签添加到容器bv1中和将不可见组件Struts添加到bv1中
   bv1.add(new JLabel("学号"));
   bv1.add(Box.createVerticalStrut(8));
   bv1.add(new JLabel("姓名"));
   bv1.add(Box.createVerticalStrut(8));
   bv1.add(new JLabel("学院"));
   bv1.add(Box.createVerticalStrut(8));
   bv1.add(new JLabel("是否确诊患病"));
   bv1.add(Box.createVerticalStrut(8));
   bv1.add(new JLabel("是否在武汉"));
   bv1.add(Box.createVerticalStrut(8));
   bv1.add(new JLabel("是否在湖北"));
   bv1.add(Box.createVerticalStrut(8));
   bv1.add(new JLabel("近期是否到达武汉"));
   bv1.add(Box.createVerticalStrut(8));
   bv1.add(new JLabel("近期是否到达湖北"));
   bv1.add(Box.createVerticalStrut(8));
   bv1.add(new JLabel("是否与武汉人员接触"));
   bv1.add(Box.createVerticalStrut(8));
   bv1.add(new JLabel("是否与湖北人员接触"));
   bv1.add(Box.createVerticalStrut(8));
   bv1.add(new JLabel("时间"));
   bv1.add(Box.createVerticalStrut(8));
   //将文本框添加到容器bv2中和将不可见组件Struts添加到bv2中
   bv2=Box.createVerticalBox();
   bv2.add(tf1);
   bv2.add(Box.createVerticalStrut(8));
   bv2.add(tf2);
   bv2.add(Box.createVerticalStrut(8));
   bv2.add(tf3);
   bv2.add(Box.createVerticalStrut(8));
   bv2.add(tf4);
   bv2.add(Box.createVerticalStrut(8));
   bv2.add(tf5);
   bv2.add(Box.createVerticalStrut(8));
   bv2.add(tf6);
   bv2.add(Box.createVerticalStrut(8));
   bv2.add(tf7);
   bv2.add(Box.createVerticalStrut(8));
   bv2.add(tf8);
   bv2.add(Box.createVerticalStrut(8));
   bv2.add(tf9);
   bv2.add(Box.createVerticalStrut(8));
   bv2.add(tf10);
   bv2.add(Box.createVerticalStrut(8));
   bv2.add(tf11);
   bv2.add(Box.createVerticalStrut(8));
   //创建一个水平箱容器
   baseBox=Box.createHorizontalBox();
   //将垂直箱容器bv1,bv2添加到水平箱容器baseBox
   baseBox.add(bv1);
   baseBox.add(Box.createHorizontalStrut(10));
   baseBox.add(bv2);
   //再将水平容器添加到面板中
  
this.getContentPane().setLayout(new FlowLayout());
JPanel p1=(JPanel)this.getContentPane();
p1.add(baseBox);
p1.add(p2);
p1.setOpaque(false);
setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
this.setSize(800,700);
this.setVisible(true);
  }

public void actionPerformed(ActionEvent e){
   if(e.getSource()==b1){
    try{ insert();}
    catch(SQLException ee){}
    JOptionPane.showMessageDialog(this,"数据已入库!","提示对话框",JOptionPane.INFORMATION_MESSAGE);
   }
   else if(e.getSource()==b2){
       tf1.setText(" ");
       tf2.setText(" ");
       tf3.setText(" ");
       tf4.setText(" ");
       tf5.setText(" ");
       tf6.setText(" ");
       tf7.setText(" ");
       tf8.setText(" ");
       tf9.setText(" ");
       tf10.setText(" ");
       tf11.setText(" ");
   }
   else {
	   System.exit(0);
}
  }
  public void insert() throws SQLException{
   String s1="'"+tf1.getText().trim()+"'";
   String s2="'"+tf2.getText().trim()+"'";
   String s3="'"+tf3.getText().trim()+"'";
   String s4="'"+tf4.getText().trim()+"'";
   String s5="'"+tf5.getText().trim()+"'";
   String s6="'"+tf6.getText().trim()+"'";
   String s7="'"+tf7.getText().trim()+"'";
   String s8="'"+tf8.getText().trim()+"'";
   String s9="'"+tf9.getText().trim()+"'";
   String s10="'"+tf10.getText().trim()+"'";
   String s11="'"+tf11.getText().trim()+"'";
   
    con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/text","root","123");
   
    String temp="insert into message values ("+s1+","+s2+","+s3+","+s4+","+s5+","+s6+","+s7+","+s8+","+s9+","+s10+","+s11+")";
    sql.executeUpdate(temp);
   con.close();
  }
}


