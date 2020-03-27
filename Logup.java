package student;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.sql.*;

public class Logup extends JFrame implements ActionListener {

	//�����¼��������
	JButton jb1,jb2,jb3=null;
	JRadioButton jrb1,jrb2=null;
	JPanel jp1,jp2,jp3,jp4,jp5=null;
    JTextField jtf=null;
	JLabel jlb1,jlb2,jlb3=null;
	JPasswordField jpf=null;
	ButtonGroup bg=null;	
	JLabel label;
	ImageIcon background;
	
	//�˵���
	JMenuBar jmb=null;	
	JMenu jm=null;
	JMenuItem jmi1,jmi2=null;
	Connection con;
	Statement sql;
	static String userword;
	static String pwd;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logup  ms=new Logup();
		
						
	}
	//���캯��
	public Logup()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e){}
		try{
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/text","root","123");
			sql = con.createStatement();
		}
		catch(SQLException ee){}
		
		 //�������
		jb1=new JButton("��¼");
		jb2=new JButton("����");
		jb3=new JButton("�˳�");
		//���ü���
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		
		jmb=new JMenuBar(); //JMenuBarָ�˵���
		jm=new JMenu("ѡ��"); //JMenu�ǲ˵����е�ѡ����
		jmi1=new JMenuItem("��ʼ"); //JMenuItemָѡ�����е�ѡ��
		jmi2=new JMenuItem("�˳�ϵͳ");
		jm.add(jmi1);
		jm.add(jmi2);
		jmb.add(jm);
		
		background=new ImageIcon("src/1.jpg");
		label=new JLabel(background);
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		jp5=(JPanel)this.getContentPane();
		jp5.setOpaque(false);
		jp5.setLayout(new FlowLayout());

		jrb1=new JRadioButton("����Ա",true);
		jrb2=new JRadioButton("�û�");
		bg=new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);

		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();				
		
		jlb1=new JLabel("�û�����");
		jlb2=new JLabel("��    �룺");
		jlb3=new JLabel("Ȩ    �ޣ�");
		
		jtf=new JTextField(10);
		jpf=new JPasswordField(10);
		//���뵽JPanel��
		jp1.add(jlb1);
		jp1.add(jtf);
		
		jp2.add(jlb2);
		jp2.add(jpf);
		
		jp3.add(jlb3);
		jp3.add(jrb1);
		jp3.add(jrb2);
		
		jp4.add(jb1);
		jp4.add(jb2);
		jp4.add(jb3);
		
		//����JFrame��

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		
		
		//���ò��ֹ�����
		this.getLayeredPane().setLayout(null);
		//���������ñ���
		this.setTitle("������Ϣ����ϵͳ");
		//���ô����С
		this.setSize(350,300);
		//���ô����ʼλ��
		this.setLocation(200, 150);
		//���õ��رմ���ʱ����֤JVMҲ�˳�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//��ʾ����
		this.setVisible(true);
		this.setResizable(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand()=="�˳�")
		{
			System.exit(0);
		}else if(e.getActionCommand()=="��¼")
		{
			if(!jtf.getText().isEmpty() && !jpf.getText().isEmpty())
			{
				//�������¼��ťʱ�����������ݿ⽨������
				//���ѡ�н�ʦ��¼
				if(jrb1.isSelected())
				{
					try {
						querytea();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//�����ж��Ƿ���ڸ��û������Ƿ�õ�������
					if(pwd ==null)
					{
                         this.clear();
					}else
					{
						//���õ�¼����
						this.tealogin();
					}
				}else if(jrb2.isSelected()) //ѧ���ڵ�¼ϵͳ
				{
 				try {
					querystu();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					//�����ж��Ƿ���ڸ��û������Ƿ�õ�������
					if(pwd ==null)
					{
                         this.clear();
					}else
					{
						//���õ�¼����
						this.stulogin();
					}
				   
				}
			}else if(jtf.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"�������û���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			    this.clear();
			}else if(jpf.getText().isEmpty())	
			{
				JOptionPane.showMessageDialog(null,"����������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			    this.clear();
			}
		}else if(e.getActionCommand()=="����")
		{
			this.clear();
		}			
		
	}
				
		//����ı���������
	public	void clear()
		{
			jtf.setText("");
			jpf.setText("");
		}
		    //ѧ����¼�жϷ���
			public void stulogin()
			{
				if(pwd.equals(jpf.getText()))
				{
//					System.out.println("��¼�ɹ�");
					JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
					this.clear();
					//�رյ�ǰ����
					 dispose();
					 //����һ���½���
					StudentAdd user = new StudentAdd();		
				}else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(jtf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else
				{
					JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
				    //��������
					this.clear();
				}
			}
			
			//��ʦ��¼�жϷ���
			public void tealogin()
			{
				if(pwd.equals(jpf.getText()))
				{
//					System.out.println("��¼�ɹ�");
					 JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
					 this.clear();	
					//�رյ�ǰ����
					 dispose();
					 //����һ���½��棬�����ڽ�ʦ������ѧ��
					 StudentManagement stuM = new StudentManagement();
						stuM.setVisible(true);
						stuM.addWindowListener(new WindowAdapter(){
							public void windowClosing(WindowEvent e){
								System.exit(0);
							}
							});	 					
				}else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(jtf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else
				{
					JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
				    //��������
					this.clear();
				}
			}
			
			public void querytea() throws SQLException{
			
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/text","root","123");
			
				ResultSet rs = sql.executeQuery("SELECT* FROM text.into WHERE  name='����Ա'");	
				if (rs.next()) {
					// ����ʦ���û���������ȡ��
					userword = rs.getString(3);
					pwd = rs.getString(4);
					System.out.println("�ɹ���ȡ��������û���from���ݿ�");
					System.out.println(userword + "\t" + pwd + "\t");
					
					//���õ�¼����
				
				}else
				{
					JOptionPane.showMessageDialog(null, "û�д��û������������룡", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				    
				}
		
}
public void querystu() throws SQLException{
	
	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/text","root","123");

	ResultSet rs = sql.executeQuery("SELECT* FROM text.into WHERE  name='�û�'");	
	if (rs.next()) {
		userword = rs.getString(3);
		pwd = rs.getString(4);
		System.out.println("�ɹ���ȡ��������û���from���ݿ�");
		System.out.println(userword + "\t" + pwd + "\t");
		
		//���õ�¼����
	
	}else
	{
		JOptionPane.showMessageDialog(null, "û�д��û������������룡", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
	    
	}

}}
 
	
	

		
