
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.JSpinner;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;

public class Signin extends JFrame implements ActionListener{

	int pX,pY;
	String gender;
	 JTextField Name;
	 JTextField Email;
	 JTextField Username;
	 int Gender;
	 private JTextField Age;
	 private final ButtonGroup buttonGroup = new ButtonGroup();
	 private JTextField Password;
	 JLabel email_patt;
	 JLabel pass_vall;
	 JLabel usrchk;
	JLabel chkemail;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signin window = new Signin();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Signin() {
		initialize();
		getContentPane().setBackground(SystemColor.inactiveCaption);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		setUndecorated(true);
		setResizable(false);
		setSize(700,500);
		//.setOpaque(false);
		JPanel top_panel = new JPanel();
		top_panel.setBounds(0, 0, 700, 38);
		setLocationRelativeTo(null);
		 addMouseListener(new MouseAdapter() {
             public void mousePressed(MouseEvent me) {
                 // Get x,y and store them
                 pX = me.getX();
                 pY = me.getY();

             }

              public void mouseDragged(MouseEvent me) {

                 setLocation(getLocation().x + me.getX() - pX,
                        getLocation().y + me.getY() - pY);
             }
         });

         addMouseMotionListener(new MouseMotionAdapter() {
             public void mouseDragged(MouseEvent me) {

                 setLocation(getLocation().x + me.getX() - pX,
                         getLocation().y + me.getY() - pY);
             }
         });
		getContentPane().setLayout(null);
		
		
		top_panel.setBackground(new Color(37,116,169));
		top_panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		getContentPane().add(top_panel);
		top_panel.setLayout(null);
		
		JLabel lblMychatV = new JLabel("Cypher v1.0");
		lblMychatV.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblMychatV.setBounds(10, 11, 95, 14);
		top_panel.add(lblMychatV);
		
		JLabel close = new JLabel("");
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
			
			
		});
		close.setIcon(new ImageIcon(Signin.class.getResource("/Icons/cancel(1).png")));
		close.setBounds(661, 0, 29, 38);
		top_panel.add(close);
		
		JLabel minimize = new JLabel("");
		minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 setExtendedState(ICONIFIED);
			}

		});
		minimize.setIcon(new ImageIcon(Signin.class.getResource("/Icons/12 (2).png")));
		minimize.setBounds(631, 0, 29, 38);
		top_panel.add(minimize);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Sitka Text", Font.BOLD, 19));
		lblName.setBounds(45, 162, 69, 14);
		getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Sitka Text", Font.BOLD, 19));
		lblEmail.setBounds(45, 206, 69, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Sitka Text", Font.BOLD, 19));
		lblUsername.setBounds(45, 252, 94, 14);
		getContentPane().add(lblUsername);
		
		Name = new JTextField();
		Name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				
			}
		});
		Name.setToolTipText("Please enter your first name");
		Name.setBounds(149, 157, 458, 26);
		getContentPane().add(Name);
		Name.setColumns(10);
		
		Email = new JTextField();
		Email.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			
			String Email_Pattern = "^[a-zA-Z.0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-z]{2,3}$";
			Pattern pattern = Pattern.compile(Email_Pattern);
			Matcher regexMatcher = pattern.matcher(Email.getText());
			if(!regexMatcher.matches())
			{
				email_patt.setIcon(new ImageIcon(Login.class.getResource("/Icons/cancel(1).png")));
				//.setText();
			}
			if(regexMatcher.matches())
			{
				email_patt.setIcon(new ImageIcon(Login.class.getResource("/Icons/check1.png")));
			}
			}
			
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				checkemail();
				
				
			}
		});
		Email.setToolTipText("e.g. abc@xyz.com");
		
		Email.setColumns(10);
		Email.setBounds(149, 201, 458, 26);
		getContentPane().add(Email);
		
		Username = new JTextField();
		Username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				checkUsr();
			}
		});
		Username.setToolTipText("First letter should be capital");
		Username.setColumns(10);
		Username.setBounds(149, 247, 458, 26);
		getContentPane().add(Username);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Sitka Text", Font.BOLD, 19));
		lblAge.setBounds(372, 350, 69, 19);
		getContentPane().add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Sitka Text", Font.BOLD, 19));
		lblGender.setBounds(45, 352, 69, 14);
		getContentPane().add(lblGender);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Sitka Text", Font.BOLD, 19));
		lblPassword.setBounds(45, 297, 105, 14);
		getContentPane().add(lblPassword);
		
		JRadioButton male = new JRadioButton("Male");
		buttonGroup.add(male);
		male.setBackground(SystemColor.inactiveCaption);
		male.setBounds(176, 343, 55, 23);
		getContentPane().add(male);
		
		JRadioButton Female = new JRadioButton("Female");
		buttonGroup.add(Female);
		Female.setBackground(SystemColor.inactiveCaption);
		Female.setBounds(233, 343, 94, 23);
		getContentPane().add(Female);
		
		ButtonGroup bg  = new ButtonGroup();
		bg.add(male);
		bg.add(Female);
		
		JLabel lblSignUp = new JLabel("Register");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setIcon(new ImageIcon(Signin.class.getResource("/Icons/add-people-interface-symbol-of-black-person-close-up-with-plus-sign-in-small-circle.png")));
		lblSignUp.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblSignUp.setBounds(10, 59, 680, 65);
		getContentPane().add(lblSignUp);
		
		Age = new JTextField();
		Age.setBounds(435, 347, 60, 26);
		getContentPane().add(Age);
		Age.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBackground(UIManager.getColor("Tree.selectionForeground"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String p = Password.getText();
			if(p.length()>8)
			{
				String Email_Pattern = "^[a-zA-Z.0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-z]{2,3}$";
				Pattern pattern = Pattern.compile(Email_Pattern);
				Matcher regexMatcher = pattern.matcher(Email.getText());
				if(regexMatcher.matches())
				{
				if(male.isSelected())
				{
					Gender = 1;
				}
				if(Female.isSelected())
				{
					Gender =0;
				} 
				
				
				database();
				}
				else
				{
					JOptionPane.showMessageDialog(null, 
		                    "Fields not filled correctly please ensure all details are correct", 
		                    "UnSucessful", 
		                    JOptionPane.WARNING_MESSAGE);
				}
			
			}
			else
				{
				JOptionPane.showMessageDialog(null, 
	                    "Please make sure you password has more than 8 characters for more security.", 
	                    "Unsucessful", 
	                    JOptionPane.WARNING_MESSAGE);
				}}
		});
		btnNewButton.setBounds(176, 412, 398, 38);
		getContentPane().add(btnNewButton);
		
		JLabel back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
					chatapp c = new chatapp();
					c.setVisible(true);
					dispose();
					
				
			}
		});
		back.setIcon(new ImageIcon(Signin.class.getResource("/Icons/back.png")));
		back.setBounds(10, 45, 37, 43);
		getContentPane().add(back);
		
		JList list = new JList();
		list.setBounds(356, 352, -29, 26);
		getContentPane().add(list);
		
		Password = new JTextField();
		Password.addKeyListener(new KeyAdapter() {
				@Override
			public void keyReleased(KeyEvent arg0) {
				String p = Password.getText();
				
				if(p.length()>=8)
				{
					pass_vall.setIcon(new ImageIcon(Login.class.getResource("/Icons/check1.png")));
				}
				else
				{
					pass_vall.setIcon(new ImageIcon(Login.class.getResource("/Icons/cancel(1).png")));
				}
			}
});
		
		Password.setColumns(10);
		Password.setBounds(149, 292, 458, 26);
		getContentPane().add(Password);
		
		email_patt = new JLabel();
		email_patt.setBounds(617, 192, 37, 43);
		getContentPane().add(email_patt);
		
		pass_vall = new JLabel("");
		pass_vall.setBounds(617, 281, 37, 50);
		getContentPane().add(pass_vall);
		
	usrchk = new JLabel("");
		usrchk.setBounds(149, 272, 458, 14);
		getContentPane().add(usrchk);
	 chkemail = new JLabel("");
		chkemail.setBounds(149, 227, 458, 14);
		getContentPane().add(chkemail);
		
	
		
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setResizable(false);
		setUndecorated(true);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void close() {
		JOptionPane.showMessageDialog(null, 
    			"Mini Project Developed by Aakash negi and Ishaan Kothidar \n                     ThankYou for using Cypher", 
                "Credits", 
                JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	void database()
	{
		String name = Name.getText();
		String email = Email.getText();
		String usr = Username.getText();
		String psw = Password.getText();
		String gen = null ;
		if(Gender==1)
		{
			gen="Male";
		}
		else if(Gender==0)
		{
			gen="Female";
			
		}
		int age=Integer.parseInt(Age.getText());
		
		try
		{
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.43.50/student","root","student");
			Statement stat = conn.createStatement();
			String sql = "insert into student (Name,Email,Username,Password,Gender,Age) values ('"+ name+"','"+email+"','"+usr+"','"+psw+"','"+gen+"','"+age+"')";
			
			stat.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, 
                    "Registered Sucessfully!!", 
                    "Sucessful", 
                    JOptionPane.INFORMATION_MESSAGE);
			chatapp ch = new chatapp();
			ch.setVisible(true);
			dispose();
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
	void checkUsr()
	{
		   Connection connection;
			
			String address = "192.168.43.50";
			
		    PreparedStatement ps;
		    try {
		        connection = DriverManager.getConnection("jdbc:mysql://192.168.43.50/student", "root", "student");
		        ps = connection.prepareStatement("SELECT `Username` FROM `student` WHERE `Username` = ?");
		        ps.setString(1, Username.getText());
		        
		        ResultSet result = ps.executeQuery();
		        if(!result.next()){
		        	        	 
		 			
					
					
		        }
		        else{
		        	Username.setBackground(Color.RED);
		        	usrchk.setText("Username already in use!!");
		        }
		    } catch (SQLException ex) {
		        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		    }
	}
	void checkemail()
	{
		   Connection connection;
			
			String address = "192.168.43.50";
			
		    PreparedStatement ps;
		    try {
		        connection = DriverManager.getConnection("jdbc:mysql://192.168.43.50/student", "root", "student");
		        ps = connection.prepareStatement("SELECT `Email` FROM `student` WHERE `Email` = ?");
		        ps.setString(1, Email.getText());
		        
		        ResultSet result = ps.executeQuery();
		        if(!result.next()){
		        	        	 
		 			
					
					
		        }
		        else{
		        	Email.setBackground(Color.RED);
		        	chkemail.setText("Email already in use!!");
		        }
		    } catch (SQLException ex) {
		        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		    }
	}
}
