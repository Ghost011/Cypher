import java.awt.*;
	import java.awt.event.*;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import javax.swing.*;

	//import net.proteanit.sql.DbUtils;

public class View1  extends JFrame implements ActionListener
{int h,i;
JLabel sub[]=new JLabel[50];
JLabel at[]=new JLabel[50];
JLabel tt[]=new JLabel[50];
JLabel pc[]=new JLabel[50];
JLabel sb,ac,tc,per;	
JPanel vp;
JButton bck;
int o,oo;
	View1(){
		setLayout(null);
		setTitle("View1");
		setSize(1980,1000);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\1st phase\\books-2.png")));
		setBackground(Color.white);
		
		sb=new JLabel("SUBJECTS");
		sb.setFont(new Font("ARIAL", Font.BOLD, 20));
		sb.setBounds(100,100,700,40);
		//sb.setForeground(Color.RED);
		
		
		ac=new JLabel("ATTENDED CLASSES");
		ac.setFont(new Font("ARIAL", Font.BOLD, 20));
		ac.setBounds(300,100,700,40);
		//ac.setForeground(Color.RED);
		
		tc=new JLabel("TOTAL CLASSES");
		tc.setFont(new Font("ARIAL", Font.BOLD, 20));
		tc.setBounds(550,100,700,40);
		//tc.setForeground(Color.RED);
		
		per=new JLabel("PERCENTAGE");
		per.setFont(new Font("ARIAL", Font.BOLD, 20));
		per.setBounds(800,100,700,40);
		
		vp=new JPanel();
		vp.setLayout(null);
		vp.setBounds(150,200,800,900);	
		vp.setSize(1000,600);
		vp.setBorder(BorderFactory.createLineBorder(Color.black,5));
		
		
		try{
			ResultSet rst,rs1;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lets bunk","root","");
			Statement st = con.createStatement();	
			rst=st.executeQuery("select subno from register");
			while(rst.next())
			 {h= rst.getInt(1);}
			rs1=st.executeQuery("select * from subject");
			i=0;
			while(rs1.next()){
				 String s = rs1.getString("subname");
				sub[i]=new JLabel(s);
				sub[i].setFont(new Font("ARIAL", Font.PLAIN, 20));
				sub[i].setBounds(100,150+(50*i),300,40);
				vp.add(sub[i]);
				i++;
			}

			
		}
		catch(Exception ee){}
		
		bck=new JButton("BACK");
		bck.addActionListener(this);
		bck.setFont(new Font("ARIAL", Font.PLAIN, 20));
		bck.setBounds(300,150+(50*i),150,40);

		try{
			ResultSet ab;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lets bunk","root","");
			Statement st = con.createStatement();
			for(i=0;i<h;i++){
				ab=st.executeQuery("select sum(attended)from sub"+(i+1)+"");
				if(ab.first()){
					int o= ab.getInt(1);
					Integer O=new Integer(o);
				at[i]=new JLabel(O.toString());
				at[i].setFont(new Font("ARIAL", Font.PLAIN, 20));
				at[i].setBounds(350,150+(50*i),300,40);
				vp.add(at[i]);
				}
			}
			
		}catch(Exception ed){}
		
		try{
			ResultSet ab1;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lets bunk","root","");
			Statement st = con.createStatement();
			for(i=0;i<h;i++){
				ab1=st.executeQuery("select count(attended)from sub"+(i+1)+"");
				if(ab1.first()){
					int oo= ab1.getInt(1);
					Integer O=new Integer(oo);
				tt[i]=new JLabel(O.toString());
				tt[i].setFont(new Font("ARIAL", Font.PLAIN, 20));
				tt[i].setBounds(600,150+(50*i),300,40);
				vp.add(tt[i]);
				}
			}
			
		}catch(Exception ed){}
		
		for(i=0;i<h;i++){
			double a= Double.parseDouble(at[i].getText());
			double b= Double.parseDouble(tt[i].getText());
			double f=a/b;
			f=f*100;
			Double F=new Double(f);
			
			pc[i]=new JLabel(F.toString()+"%");
			pc[i].setFont(new Font("ARIAL", Font.PLAIN, 20));
			pc[i].setBounds(800,150+(50*i),300,40);
			vp.add(pc[i]);
		}		

		
	vp.add(per);
	vp.add(tc);
	vp.add(sb);
	vp.add(ac);
	vp.add(bck);
	add(vp);
	setVisible(true);
	}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			setVisible(false);
			new Main1();
		}
		
		public static void main(String[] args)
		{
			View1 M = new View1();
		}

	

	private void View() {
		// TODO Auto-generated method stub
		
	}


}
