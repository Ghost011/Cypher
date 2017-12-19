import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.util.*;
public class Third extends JFrame implements ActionListener
{
	static int i,nn;
	public static String str[]=new String[10];
	JTextField T[]= new JTextField[50];
	
	Third(int nw)
	{
		nn=nw;
		setLayout(null);
	setTitle("ENTER SUBJECTS");
	setSize(1980,1000);
	setResizable(false);
	JLabel m[]=new JLabel[nw];
	JButton B; 
	JLabel A;
	JScrollPane sp;
	JPanel P;
	
	P=new JPanel();
	P.setLayout(null);
	P.setBounds(150,200,800,900);	
	P.setSize(800,600);
	P.setBorder(BorderFactory.createLineBorder(Color.black,5));
	//P.setBackground(Color.BLACK);
	setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\1st phase\\student-subject-choices-stem-drift-bobbed.jpg")));
	
	A=new JLabel("PLEASE ENTER THE NAME OF YOUR SUBJECTS");
	A.setFont(new Font("ARIAL", Font.PLAIN, 20));
	A.setBounds(150,30,700,40);
	
	P.add(A);
	
	sp=new JScrollPane(P);//,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	sp.setBounds(150,200,800,900);	
	sp.setSize(800,600);
	
	for(i=0;i<nw;i++)
	{
	m[i]=new JLabel("subject "+(i+1));
	m[i].setFont(new Font("ARIAL", Font.PLAIN, 20));
	m[i].setBounds(150,100+(50*i),300,40);
	
	T[i]=new JTextField(16);
	T[i].setFont(new Font("ARIAL", Font.PLAIN, 20));
	T[i].setBounds(300,100+(50*i),300,40);
	
	P.add(m[i]);
	P.add(T[i]);
	
	}
	B=new JButton("LETS BUNK");
	B.addActionListener(this);
	B.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	B.setBounds(150,120+(50*i),300,40);
	P.add(B);
	add(sp);
	setVisible(true);
	}
public static void main(String args[])
{
	
}

	@Override
	public void actionPerformed(ActionEvent a) {

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lets bunk","root","");
			Statement st = con.createStatement();
			
			for(i=0;i<nn;i++)
			{
				int rs=st.executeUpdate("insert into subject(subname) values('"+T[i].getText()+"')");
				
			}
			
			Main1 m1=new Main1();
						
			con.close();
			}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		this.setVisible(false);
		
		//TimeTable Mm=new TimeTable(ModuleMain.a);// TODO Auto-generated method stub
		
	}
	
}
