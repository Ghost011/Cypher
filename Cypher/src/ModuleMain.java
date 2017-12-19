import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;
import javax.swing.*;
public class ModuleMain extends JFrame implements ActionListener
{
	public static int a,x=5;
	JLabel W,W1,L1,L2,L3,L4,L5,L6,L7;
	JTextField T1,T2,T3,T4,T5;
	JButton Log;
	JPanel P;
	ModuleMain()
	{
		setLayout(null);
		setTitle("LETS BUNK!!!!!");
		setSize(1980,1000);
		
		setResizable(false);
		setBackground(Color.BLACK);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\1st phase\\1.jpg")));
		
		
		P=new JPanel();
		P.setLayout(null);
		P.setBounds(150,200,800,900);	
		P.setSize(800,600);
		P.setBorder(BorderFactory.createLineBorder(Color.blue,5));
		P.setBackground(Color.BLACK);
		
		W1=new JLabel("");
		W1.setFont(new Font("ARIAL", Font.ITALIC, 20));
		W1.setBounds(150,550,700,40);
		W1.setForeground(Color.RED);
		
		L7=new JLabel("");
		L7.setFont(new Font("ARIAL", Font.ITALIC, 20));
		L7.setBounds(150,550,700,40);
		L7.setForeground(Color.RED);
	
		
		W=new JLabel("Welcome Students keep the record for your Daily bunks");
		W.setFont(new Font("ARIAL", Font.BOLD, 25));
		W.setBounds(100,50,700,40);
		W.setForeground(Color.BLUE);
		
		L1=new JLabel("Enter Your Name");
		L1.setFont(new Font("ARIAL", Font.PLAIN, 20));
		L1.setBounds(100,130,300,40);
		L1.setForeground(Color.BLUE);
		
		L2=new JLabel("Enter University Name");
		L2.setFont(new Font("ARIAL", Font.PLAIN, 20));
		L2.setBounds(100,190,300,40);
		L2.setForeground(Color.BLUE);
		
		T1=new JTextField(16);
		T1.setFont(new Font("ARIAL", Font.PLAIN, 20));
		T1.setBounds(350,130,300,40);
		
		T2=new JTextField(16);
		T2.setFont(new Font("ARIAL", Font.PLAIN, 20));
		T2.setBounds(350,190,300,40);
		
		T3=new JTextField(4);
		T3.setFont(new Font("ARIAL", Font.PLAIN, 20));
		T3.setBounds(350,250,300,40);
		
		L3=new JLabel("Enter Your Course");
		L3.setFont(new Font("ARIAL", Font.PLAIN, 20));
		L3.setBounds(100,250,300,40);
		L3.setForeground(Color.BLUE);	
		
		L4=new JLabel("Enter No. Of subjects");
		L4.setFont(new Font("ARIAL", Font.PLAIN, 20));
		L4.setBounds(100,310,300,40);
		L4.setForeground(Color.BLUE);
		
		T4=new JTextField(16);
		T4.setFont(new Font("ARIAL", Font.PLAIN, 20));
		T4.setBounds(350,310,300,40);
		
		L5=new JLabel("Max No.of classes a Day");
		L5.setFont(new Font("ARIAL", Font.PLAIN, 20));
		L5.setBounds(100,370,300,40);
		L5.setForeground(Color.BLUE);
		
		T5=new JTextField(16);
		T5.setFont(new Font("ARIAL", Font.PLAIN, 20));
		T5.setBounds(350,370,300,40);
		
		L6=new JLabel("(max 8)");
		L6.setFont(new Font("ARIAL", Font.PLAIN, 17));
		L6.setBounds(680,310,300,40);
		L6.setForeground(Color.red);
		
		
		Log=new JButton("LETS BUNK");
		Log.addActionListener(this);
		Log.setFont(new Font("ARIAL", Font.PLAIN, 20));
		Log.setBounds(280,480,150,40);
		
		//setBounds(50,50,200,200);
		//setBackground(Color.blue);
		
		P.add(W);
		P.add(L1);
		P.add(T1);
		P.add(L2);
		P.add(T2);
		P.add(L3);
		P.add(T3);
		P.add(L4);
		P.add(T4);
		P.add(L5);
		P.add(T5);
		P.add(L6);
		P.add(Log);
		P.add(W1);
		P.add(L7);
		add(P);
	
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(T1.getText().equals("")|T2.getText().equals("")|T3.getText().equals("")|T4.getText().equals("")|T5.getText().equals(""))
		W1.setText("All Fields are mandatory");
		else {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lets bunk","root","");
			Statement st = con.createStatement();
			int rs=st.executeUpdate("insert into register values('"+T1.getText()+"','"+T2.getText()+"','"+T3.getText()+"',"+ T4.getText()+ ")");
			
			x=Integer.parseInt(T4.getText());
			if(x>8){L7.setText("subjects limit exceeds");}
			else{
			this.setVisible(false);
			new Third(x).setVisible(true);
			a= Integer.parseInt(T5.getText());
			}
			con.close();
			}
		catch(Exception ex){JOptionPane.showMessageDialog(null, ex.getMessage());}
			
		}

	}


public static void main(String args[])
{
	ModuleMain M = new ModuleMain();
}
}
