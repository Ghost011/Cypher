import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;
import java.util.*;

public class Main1 extends JFrame implements ActionListener
{JPanel P;
JButton B,B1,B2;
JLabel L1;
Main1()
{
	setLayout(null);
	setTitle("LETS BUNK!!!!!");
	setSize(1980,1000);
	setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\1st phase\\books-2.png")));
	setBackground(Color.white);
	
	P=new JPanel();
	P.setBounds(500,300,800,600);	
	P.setSize(500,500);
	P.setBackground(Color.gray);
	P.setBorder(BorderFactory.createLineBorder(Color.black,5));
	P.setLayout(null);
	
	B=new JButton("New Entry");
	B.addActionListener(this);
	B.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	B.setBounds(150,150,200,40);
	
	B1=new JButton("Check Attendence");
	B1.addActionListener(this);
	B1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	B1.setBounds(150,250,200,40);
	
	B2=new JButton("Semester End");
	B2.addActionListener(this);
	B2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	B2.setBounds(150,350,200,40);
	
	P.add(B);
	P.add(B1);
	P.add(B2);
	add(P);
	
	setVisible(true);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO AClass.forName("com.mysql.jdbc.Driver");
		
		try
		{	if(e.getSource()==B2)
			{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lets bunk","root","");
			Statement st = con.createStatement();
			int rs=st.executeUpdate("TRUNCATE register");
			int rs2=st.executeUpdate("TRUNCATE sub2");
			int rs3=st.executeUpdate("TRUNCATE sub1");
			int rs4=st.executeUpdate("TRUNCATE sub3");
			int rs5=st.executeUpdate("TRUNCATE sub4");
			int rs6=st.executeUpdate("TRUNCATE sub5");
			int rs7=st.executeUpdate("TRUNCATE sub6");
			int rs8=st.executeUpdate("TRUNCATE sub7");
			int rs9=st.executeUpdate("TRUNCATE sub7");
			int rs0=st.executeUpdate("TRUNCATE sub8");
			st.executeUpdate("TRUNCATE subject");
			this.setVisible(false);
			new First().setVisible(true);
			
			
			con.close();
			}
			if(e.getSource()==B)
			{
				//NewEntry n = new NewEntry();
			}
			if(e.getSource()==B1){
				View1 v=new View1();
			}
			this.setVisible(false);
		}
		catch(Exception e1){}
		
	}
	public static void main(String args[]){
		Main1 n=new Main1();
	}
}
