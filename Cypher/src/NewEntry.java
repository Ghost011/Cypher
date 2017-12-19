import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

//import org.jdatepicker.impl.JDatePanelImpl;
//import org.jdatepicker.impl.JDatePickerImpl;
//import org.jdatepicker.impl.UtilDateModel;

import java.util.*;
public class NewEntry extends JFrame implements ActionListener
{	public static String str2[]=new String[10];
	int i,h;
	int y=ModuleMain.x;
	JCheckBox rb[]=new JCheckBox[50];
	JCheckBox cb[]=new JCheckBox[50];
	JButton bck;
	JPanel p1,p2;
	JLabel jl,jl2,jl1;
	JButton b1,b2;
	JTextField j;
	int xx=0;
	NewEntry(String ss)
	{super(ss);
		setLayout(null);
		setTitle("NEW ENTRY");
		setSize(1980,1000);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\1st phase\\student-subject-choices-stem-drift-bobbed.jpg")));
				
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(150,50,800,900);	
		p1.setSize(600,800);
		p1.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(1050,50,800,900);	
		p2.setSize(600,800);
		p2.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		jl1=new JLabel("ENTER DATE");
		jl1.setFont(new Font("ARIAL", Font.PLAIN, 20));
		jl1.setBounds(120,50,400,40);
		
		j=new JTextField(16);
		j.setFont(new Font("ARIAL", Font.PLAIN, 20));
		j.setBounds(290,50,200,40);
		
		jl=new JLabel("PLEASE SELECT TODAYS LECTURES");
		jl.setFont(new Font("ARIAL", Font.PLAIN, 20));
		jl.setBounds(120,100,400,40);
		//jl.setForeground(Color.red);
		
		jl2=new JLabel("PLEASE SELECT ATTENDED LECTURES");
		jl2.setFont(new Font("ARIAL", Font.PLAIN, 20));
		jl2.setBounds(80,100,400,40);
		
		bck=new JButton("BACK");
		bck.addActionListener(this);
		bck.setFont(new Font("ARIAL", Font.PLAIN, 20));
		bck.setBounds(850,630,150,40);
		
		add(bck);
		p1.add(jl1);
		p1.add(j);
		p1.add(jl);
		p2.add(jl2);
		
		for(i=0;i<y;i++)
		{
			ResultSet rs,rs1;
			 i=0;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lets bunk","root","");
				Statement st = con.createStatement();	
				 rs=st.executeQuery("select * from subject");
				 while(rs.next()){
					 String s = rs.getString("subname");
						rb[i]=new JCheckBox(s);
						rb[i].setActionCommand(rb[i].getText());
						rb[i].setFont(new Font("ARIAL", Font.ITALIC, 17));
						rb[i].addActionListener(this);
						rb[i].setBounds(100,150+(50*i),300,40);
						p1.add(rb[i]);
						i++;
				 }
		
				 rs=st.executeQuery("select subno from register");
				 xx=rs.getInt(1);
				 
				 //con.close();
				 }catch(Exception e){
						//JOptionPane.showMessageDialog(null, e.getMessage());
					}	

		}
		b1=new JButton("INSERT");
		b1.addActionListener(this);
		b1.setFont(new Font("ARIAL", Font.PLAIN, 20));
		b1.setBounds(200,600,150,40);
		p1.add(b1);
		
		b2=new JButton("SUBMIT");
		b2.addActionListener(this);
		b2.setFont(new Font("ARIAL", Font.PLAIN, 20));
		b2.setBounds(200,600,150,40);
		p2.add(b2);
		
	add(p1);
	add(p2);
	setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ar) 
	{
		ResultSet rst;

		if(ar.getSource()==bck){
			this.setVisible(false);
			new Main1();
		}
		
		else
			{try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lets bunk","root","");
			Statement st = con.createStatement();	
			 rst=st.executeQuery("select subno from register");
			while(rst.next())
			 {h= rst.getInt(1);}
			// System.out.print(h);
			con.close();
			} 
		
		catch(Exception ee){JOptionPane.showMessageDialog(null, ee.getMessage());}
		
		if(ar.getSource()==b1){
			if(j.getText().equals("")){
				JOptionPane.showMessageDialog(NewEntry.this,"Please enter a valid date","Coded Message",JOptionPane.INFORMATION_MESSAGE);
			}
			else{
		for(i=0;i<h;i++)
			{//System.out.print("abc");
			cb[i]=new JCheckBox(rb[i].getActionCommand());
			cb[i].setFont(new Font("ARIAL", Font.ITALIC, 17));
			cb[i].addActionListener(this);
			cb[i].setBounds(200,150+(50*i),300,40);	
			
			if(rb[i].isSelected())
			{  
			 
			p2.add(cb[i]);
			}
			/*else{
				
			}*/
		}
		
	
		
	}
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lets bunk","root","");
		Statement st1 = con.createStatement();
		if(ar.getSource()==b2){		
		for(i=0;i<h;i++){
			
			
				if(cb[i].isSelected())
				{
					int r= st1.executeUpdate("insert into sub"+(i+1)+"(date,attended) values('"+j.getText()+"',1)");
				}
				else
				{
					
				int r= st1.executeUpdate("insert into sub"+(i+1)+"(date,attended) values('"+j.getText()+"',0)");
								
				}
					
			
			
		}
		JOptionPane.showMessageDialog(NewEntry.this,"Successfully Updated","Coded Message",JOptionPane.INFORMATION_MESSAGE);							
		this.setVisible(false);
		Main1 mmm=new Main1();	
		}
		}catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());
		}
		}
	
	}		
		

public static void main(String args[]){
	NewEntry ne=new NewEntry("a");

}
}
