package student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class add extends JPanel implements ActionListener{
	  Connection con; //���ض����ݿ�����ӣ��Ự����
	  Statement sql; //����ִ�о�̬ SQL ��䲢�����������ɽ���Ķ���
	  JButton b1,b2;//����������ť
	  JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11;//������Ҫ���ı���
	  Box baseBox,bv1,bv2;//������������
	  ImageIcon groundIcon;
	  JLabel  label;
	  add(){
	   try{										//���������
	    Class.forName("com.mysql.jdbc.Driver");	//ͨ�� Class.forNameΪ���ݿ����ϵͳ����һ��JDBC��������
	    }
	   catch(ClassNotFoundException e){}		//�����������ʧ�� ����̨�׳��쳣
	    try{									//������������ɹ��� �������������ض����ݿ�
	     con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/text","root","123");
	     System.out.println("���ӳɹ�");
	     sql=con.createStatement();      //��ȡcon��Ա������ȡStatement����
	    }
	    catch(SQLException ee){}//�쳣�����
	    
	    //������岼�� Ϊ�߿򲼾�
	 
	   JPanel p1=new JPanel();//����һ�����Ķ���Ϊp1
	   JPanel p2=new JPanel();//����һ��������Ϊp2
		setLayout(new  BorderLayout());//����Ϊ�߿򲼾�
		
	 //������Ҫ������16�ֳ����ı���
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
	   //����������ť������������
	   b1=new JButton("¼��");  
	   b2=new JButton("����");
	 //��������ť��Ӽ�����
	   b1.addActionListener(this);
	   b2.addActionListener(this);
	   //��������ť��ӵ����p1
	   p1.add(b1);
	   p1.add(b2);
	   //����һ����ֱ����Ϊbv1
	   bv1=Box.createVerticalBox();
	   //����ǩ��ӵ�����bv1�кͽ����ɼ����Struts��ӵ�bv1��
	   bv1.add(new JLabel("ѧ��"));
	   bv1.add(Box.createVerticalStrut(8));
	   bv1.add(new JLabel("����"));
	   bv1.add(Box.createVerticalStrut(8));
	   bv1.add(new JLabel("ѧԺ"));
	   bv1.add(Box.createVerticalStrut(8));
	   bv1.add(new JLabel("�Ƿ�ȷ�ﻼ��"));
	   bv1.add(Box.createVerticalStrut(8));
	   bv1.add(new JLabel("�Ƿ����人"));
	   bv1.add(Box.createVerticalStrut(8));
	   bv1.add(new JLabel("�Ƿ��ں���"));
	   bv1.add(Box.createVerticalStrut(8));
	   bv1.add(new JLabel("�����Ƿ񵽴��人"));
	   bv1.add(Box.createVerticalStrut(8));
	   bv1.add(new JLabel("�����Ƿ񵽴����"));
	   bv1.add(Box.createVerticalStrut(8));
	   bv1.add(new JLabel("�Ƿ����人��Ա�Ӵ�"));
	   bv1.add(Box.createVerticalStrut(8));
	   bv1.add(new JLabel("�Ƿ��������Ա�Ӵ�"));
	   bv1.add(Box.createVerticalStrut(8));
	   bv1.add(new JLabel("ʱ��"));
	   bv1.add(Box.createVerticalStrut(8));
	   //���ı�����ӵ�����bv2�кͽ����ɼ����Struts��ӵ�bv2��
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
	   //����һ��ˮƽ������
	   baseBox=Box.createHorizontalBox();
	   //����ֱ������bv1,bv2��ӵ�ˮƽ������baseBox
	   baseBox.add(bv1);
	   baseBox.add(Box.createHorizontalStrut(10));
	   baseBox.add(bv2);
	   //�ٽ�ˮƽ������ӵ������
	   p2.add(baseBox);
	   add(p1,"South");
	   add(p2,"Center");
	   setSize(350,300);
	   setBackground(Color.pink);
	  }
	 
	public void actionPerformed(ActionEvent e){
	   if(e.getSource()==b1){
	    try{ insert();}
	    catch(SQLException ee){}
	    JOptionPane.showMessageDialog(this,"���������!","��ʾ�Ի���",JOptionPane.INFORMATION_MESSAGE);
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