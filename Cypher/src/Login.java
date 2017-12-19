
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
import javax.print.DocFlavor.URL;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.DropMode;



import Icons.*;
public class Login extends JFrame implements ActionListener{
	static String s;
	static int onln;
	int pX,pY;
	String gender;
	 static JTextField Username;
	 int Gender;
	 JLabel usr_chk ;
	 JLabel pss_chk; 
	 
	 private final ButtonGroup buttonGroup = new ButtonGroup();
	 private JPasswordField Password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
		getContentPane().setBackground(SystemColor.inactiveCaption);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		setUndecorated(true);
		setResizable(false);
		setSize(700,500);
		setBackground(new Color(241,169,160));
		//.setOpaque(false);
		JPanel top_panel = new JPanel();
		top_panel.setBounds(0, 0, 700, 38);
		
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
		
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				
			            Password.setEchoChar((char)0);
			            label.setIcon(new ImageIcon(Login.class.getResource("/Icons/hide.png")));
			} 
			@Override
			public void mouseExited(MouseEvent e) {
				
			    Password.setEchoChar('*');
			    label.setIcon(new ImageIcon(Login.class.getResource("/Icons/view.png")));
			}
		});
		label.setIcon(new ImageIcon(Login.class.getResource("/Icons/view.png")));
		label.setBounds(594, 325, 30, 26);
		getContentPane().add(label);
		top_panel.setBackground(new Color(37,116,169));
		top_panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		getContentPane().add(top_panel);
		top_panel.setLayout(null);
		setLocationRelativeTo(null);
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
		//java.net.URL imageUrl = this.getClass().getResource("cancel(1).png");
		close.setIcon(new ImageIcon(Login.class.getResource("/Icons/cancel(1).png")));
		close.setBounds(661, 0, 29, 38);
		top_panel.add(close);
		
		JLabel minimize = new JLabel("");
		minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 setExtendedState(ICONIFIED);
			}

		});
		minimize.setIcon(new ImageIcon(Login.class.getResource("/Icons/12 (2).png")));
		minimize.setBounds(631, 0, 29, 38);
		top_panel.add(minimize);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Sitka Text", Font.BOLD, 19));
		lblUsername.setBounds(45, 273, 94, 14);
		getContentPane().add(lblUsername);
		
		Username = new JTextField();
		Username.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				check();
				if(Username.getText().equals("Admin"))
				{
					usr_chk.setIcon(new ImageIcon(Login.class.getResource("/Icons/check1.png")));
				}
			}
		});
		
	
		Username.setColumns(10);
		Username.setBounds(176, 268, 413, 26);
		getContentPane().add(Username);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Sitka Text", Font.BOLD, 19));
		lblPassword.setBounds(45, 333, 105, 14);
		getContentPane().add(lblPassword);
		
		ButtonGroup bg  = new ButtonGroup();
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(UIManager.getColor("Tree.selectionForeground"));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent arg0) {
				if(Username.getText().equals("Admin"))
				{
					if(Password.getText().equals("Administrator"))
					{
						JOptionPane.showMessageDialog(null, 
								"Welcome Admin !!", 
			                    "Sucessful", 
			                    JOptionPane.INFORMATION_MESSAGE);
						Admin c = new Admin();
					c.setVisible(true);
					dispose();
					}
				}
				else {
				if(Password==null)
				{
					JOptionPane.showMessageDialog(null, 
								"Please enter your Username !!", 
			                    "Unsucessful", 
			                    JOptionPane.INFORMATION_MESSAGE);
				
				}
				else {
						database();
					 }
			}
			}
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
		back.setIcon(new ImageIcon(Login.class.getResource("/Icons/back.png")));
		back.setBounds(10, 45, 37, 43);
		getContentPane().add(back);
		
		JList list = new JList();
		list.setBounds(356, 352, -29, 26);
		getContentPane().add(list);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Icons/login.png")));
		lblNewLabel_1.setBounds(282, 81, 164, 128);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(0, 222, 700, 14);
		getContentPane().add(lblLogin);
		
		Password = new JPasswordField();
		Password.setBounds(176, 325, 413, 26);
		getContentPane().add(Password);
		
		usr_chk= new JLabel("");
		usr_chk.setBounds(600, 262, 46, 38);
		getContentPane().add(usr_chk);
		
		pss_chk = new JLabel("");
		pss_chk.setBounds(600, 325, 46, 26);
		getContentPane().add(pss_chk);
		
		
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setResizable(false);
		setUndecorated(true);
		setBounds(100, 100, 450, 300);
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
	{	   Connection connection;
	String name = Username.getText();
	String address = "192.168.43.50";
	
    PreparedStatement ps;
    try {
        connection = DriverManager.getConnection("jdbc:mysql://192.168.43.50/student", "root", "student");
        ps = connection.prepareStatement("SELECT `Username`, `Password` FROM `student` WHERE `Username` = ? AND `Password` = ?");
        ps.setString(1, Username.getText());
        ps.setString(2, String.valueOf(Password.getPassword()));
        ResultSet result = ps.executeQuery();
        if(result.next()){
        	
        	char[] psw = Password.getPassword();
			JOptionPane.showMessageDialog(null, 
					"Sucessful", 
                    "Sucessful", 
                    JOptionPane.INFORMATION_MESSAGE);
			s=name;
			
			test();
			
			
			
			
        }
        else{
        	char[] psw = Password.getPassword();
			JOptionPane.showMessageDialog(null, 
					"Unsucessful", 
                    "Unsucessful", 
                    JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}    
	void test()
	{
		dash d = new dash();
		d.setVisible(true);
		 dispose();
	}
	
	void main()
	{
		
	}
	/*
	}*/
	void check()
	{
		   Connection connection;
			
			String address = "192.168.43.50";
			
		    PreparedStatement ps;
		    try {
		        connection = DriverManager.getConnection("jdbc:mysql://192.168.43.50/student", "root", "student");
		        ps = connection.prepareStatement("SELECT `Username`, `Password` FROM `student` WHERE `Username` = ?");
		       ps.setString(1, Username.getText());
		        
		        ResultSet result = ps.executeQuery();
		        if(!result.next()){
		        	 usr_chk.setIcon(new ImageIcon(Login.class.getResource("/Icons/cancel(1).png")));
		        	 
		 			
					
					
		        }
		        else{
		        	usr_chk.setIcon(new ImageIcon(Login.class.getResource("/Icons/check1.png")));
		        }
		    } catch (SQLException ex) {
		        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		    }
	}}



