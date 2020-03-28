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

	//定义登录界面的组件
	JButton jb1,jb2,jb3=null;
	JRadioButton jrb1,jrb2=null;
	JPanel jp1,jp2,jp3,jp4,jp5=null;
    JTextField jtf=null;
	JLabel jlb1,jlb2,jlb3=null;
	JPasswordField jpf=null;
	ButtonGroup bg=null;	
	JLabel label;
	ImageIcon background;
	
	//菜单项
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
	//构造函数
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
		
		 //创建组件
		jb1=new JButton("登录");
		jb2=new JButton("重置");
		jb3=new JButton("退出");
		//设置监听
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		
		jmb=new JMenuBar(); //JMenuBar指菜单栏
		jm=new JMenu("选项"); //JMenu是菜单栏中的选项栏
		jmi1=new JMenuItem("开始"); //JMenuItem指选项栏中的选项
		jmi2=new JMenuItem("退出系统");
		jm.add(jmi1);
		jm.add(jmi2);
		jmb.add(jm);
		
		background=new ImageIcon("src/1.jpg");
		label=new JLabel(background);
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		jp5=(JPanel)this.getContentPane();
		jp5.setOpaque(false);
		jp5.setLayout(new FlowLayout());

		jrb1=new JRadioButton("管理员",true);
		jrb2=new JRadioButton("用户");
		bg=new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);

		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();				
		
		jlb1=new JLabel("用户名：");
		jlb2=new JLabel("密    码：");
		jlb3=new JLabel("权    限：");
		
		jtf=new JTextField(10);
		jpf=new JPasswordField(10);
		//加入到JPanel中
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
		
		//加入JFrame中

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		
		
		//设置布局管理器
		this.getLayeredPane().setLayout(null);
		//给窗口设置标题
		this.setTitle("疫情信息管理系统");
		//设置窗体大小
		this.setSize(350,300);
		//设置窗体初始位置
		this.setLocation(200, 150);
		//设置当关闭窗口时，保证JVM也退出
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//显示窗体
		this.setVisible(true);
		this.setResizable(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand()=="退出")
		{
			System.exit(0);
		}else if(e.getActionCommand()=="登录")
		{
			if(!jtf.getText().isEmpty() && !jpf.getText().isEmpty())
			{
				//当点击登录按钮时，首先与数据库建立连接
				//如果选中教师登录
				if(jrb1.isSelected())
				{
					try {
						querytea();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//首先判断是否存在该用户，即是否得到了密码
					if(pwd ==null)
					{
                         this.clear();
					}else
					{
						//调用登录方法
						this.tealogin();
					}
				}else if(jrb2.isSelected()) //学生在登录系统
				{
 				try {
					querystu();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					//首先判断是否存在该用户，即是否得到了密码
					if(pwd ==null)
					{
                         this.clear();
					}else
					{
						//调用登录方法
						this.stulogin();
					}
				   
				}
			}else if(jtf.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"请输入用户名","提示消息",JOptionPane.WARNING_MESSAGE);
			    this.clear();
			}else if(jpf.getText().isEmpty())	
			{
				JOptionPane.showMessageDialog(null,"请输入密码","提示消息",JOptionPane.WARNING_MESSAGE);
			    this.clear();
			}
		}else if(e.getActionCommand()=="重置")
		{
			this.clear();
		}			
		
	}
				
		//清空文本框和密码框
	public	void clear()
		{
			jtf.setText("");
			jpf.setText("");
		}
		    //学生登录判断方法
			public void stulogin()
			{
				if(pwd.equals(jpf.getText()))
				{
//					System.out.println("登录成功");
					JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);
					this.clear();
					//关闭当前界面
					 dispose();
					 //创建一个新界面
					StudentAdd user = new StudentAdd();		
				}else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(jtf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);
				}else
				{
					JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
				    //清空输入框
					this.clear();
				}
			}
			
			//教师登录判断方法
			public void tealogin()
			{
				if(pwd.equals(jpf.getText()))
				{
//					System.out.println("登录成功");
					 JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);
					 this.clear();	
					//关闭当前界面
					 dispose();
					 //创建一个新界面，适用于教师来管理学生
					 StudentManagement stuM = new StudentManagement();
						stuM.setVisible(true);
						stuM.addWindowListener(new WindowAdapter(){
							public void windowClosing(WindowEvent e){
								System.exit(0);
							}
							});	 					
				}else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(jtf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);
				}else
				{
					JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
				    //清空输入框
					this.clear();
				}
			}
			
			public void querytea() throws SQLException{
			
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/text","root","123");
			
				ResultSet rs = sql.executeQuery("SELECT* FROM text.into WHERE  name='管理员'");	
				if (rs.next()) {
					// 将教师的用户名和密码取出
					userword = rs.getString(3);
					pwd = rs.getString(4);
					System.out.println("成功获取到密码和用户名from数据库");
					System.out.println(userword + "\t" + pwd + "\t");
					
					//调用登录方法
				
				}else
				{
					JOptionPane.showMessageDialog(null, "没有此用户，请重新输入！", "提示消息", JOptionPane.WARNING_MESSAGE);
				    
				}
		
}
public void querystu() throws SQLException{
	
	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/text","root","123");

	ResultSet rs = sql.executeQuery("SELECT* FROM text.into WHERE  name='用户'");	
	if (rs.next()) {
		userword = rs.getString(3);
		pwd = rs.getString(4);
		System.out.println("成功获取到密码和用户名from数据库");
		System.out.println(userword + "\t" + pwd + "\t");
		
		//调用登录方法
	
	}else
	{
		JOptionPane.showMessageDialog(null, "没有此用户，请重新输入！", "提示消息", JOptionPane.WARNING_MESSAGE);
	    
	}

}}
 
	
	

		
