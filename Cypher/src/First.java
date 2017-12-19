import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class First extends JFrame implements ActionListener{
	JLabel W,W2;
	JPanel P;
	JButton GO;
	
	First()
	{
		getContentPane().setLayout(null);
		setTitle("Welcome");
		setSize(1500,1000);
		setResizable(false);
		setLocationRelativeTo(null);
		JLabel label = new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\1st phase\\www.jpg"));
		label.setBackground(Color.LIGHT_GRAY);
		setContentPane(label);	
		setBackground(Color.WHITE);
		
		P=new JPanel();
		P.setLayout(null);
		P.setBounds(300,100,800,900);	
		P.setSize(700,500);
		P.setBorder(BorderFactory.createLineBorder(Color.BLACK,7));
		P.setBackground(Color.GRAY);
		
		W=new JLabel("Welcome Students");
		W.setFont(new Font("ARIAL", Font.BOLD, 40));
		W.setBounds(180,60,700,40);
		//W.setForeground(Color.WHITE);
				
		W2=new JLabel("Please setup your profile to bunk securely");
		W2.setFont(new Font("ARIAL", Font.BOLD, 30));
		W2.setBounds(80,150,700,40);
		//W2.setForeground(Color.WHITE);
		
		GO=new JButton("GO");
		GO.addActionListener(this);
		GO.setFont(new Font("ARIAL", Font.BOLD, 20));
		GO.setBounds(201,358,300,40);
		
		
		//setBounds(50,50,200,200);
		//setBackground(Color.blue);
		
		P.add(W);
		P.add(W2);
		P.add(GO);
		getContentPane().add(P);
		
	
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//ResultSet rs=stmt.executeQuery("select * from emp");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lets bunk","root","student");
			Statement st = con.createStatement();
			
			ResultSet rs =st.executeQuery("select * from register");	
			if(rs.first())
			{Main1 m1=new Main1();}
			else
			{ModuleMain B = new ModuleMain();}
		}
		catch(Exception ee){
			JOptionPane.showMessageDialog(null, ee.getMessage());
		}
		
		this.setVisible(false);
	}
public static void main(String args[])
{
	int a;
	First M = new First();
}
}