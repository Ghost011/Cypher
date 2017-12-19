
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.JSpinner;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.DropMode;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;

public class dash extends JFrame implements ActionListener{

	int pX,pY;
	String gender;
	static String usr;
	 int Gender;
	 String onl;
	 JLabel online;
	 private JList list;
	 private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dash window = new dash();
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
	public dash() {
		initialize();
		getContentPane().setBackground(SystemColor.inactiveCaption);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		setUndecorated(true);
		setResizable(false);
		setSize(500,300);
		//setOpacity(0.8f);
		setLocationRelativeTo(null);
		setBackground(new Color(241,169,160));
		//.setOpaque(false);
		JPanel top_panel = new JPanel();
		top_panel.setBounds(0, 0, 500, 38);
		
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
		
		JLabel close = new JLabel("");
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
				JOptionPane.showMessageDialog(null, 
	        			"Developed by Aakash negi and Ishaan Kothidar \n Mini Project", 
	                    "Credits", 
	                    JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		});
		close.setIcon(new ImageIcon(dash.class.getResource("/Icons/cancel(1).png")));
		close.setBounds(470, 0, 29, 38);
		top_panel.add(close);
		
		JLabel minimize = new JLabel("");
		minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 setExtendedState(ICONIFIED);
			}

		});
		minimize.setIcon(new ImageIcon(dash.class.getResource("/Icons/12 (2).png")));
		minimize.setBounds(443, 0, 29, 38);
		top_panel.add(minimize);
		
		
		JLabel lblMychatV = new JLabel("Cypher v1.0");
		lblMychatV.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblMychatV.setBounds(10, 11, 95, 14);
		top_panel.add(lblMychatV);
		
	
		
		JLabel usrnm = new JLabel("");
		usrnm.setBounds(0, 107, 500, 45);
		getContentPane().add(usrnm);
		usrnm.setHorizontalAlignment(SwingConstants.CENTER);
		usrnm.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
	 usr = Login.s;
		usrnm.setText("WELCOME "+usr.toUpperCase());
		
		

		JButton btnLogout_1 = new JButton("Logout");
		btnLogout_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	database();
			}
		});
		btnLogout_1.setBounds(586, 49, 89, 23);
		getContentPane().add(btnLogout_1);
		
		JButton DM = new JButton("Happy Cyphering");
		DM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Server(8080);
				String a = Login.Username.getText();
				String address = "192.168.43.50";
								new ClientWindow(a,address,8080);
				setVisible(true);
				dispose();	
				ClientWindow.get();
			
			}
			
		});
		
		DM.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 15));
		DM.setBounds(38, 211, 436, 38);
		getContentPane().add(DM);
		
		JButton Logout = new JButton("Logout");
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame J =  new JFrame();
				 int output = JOptionPane.showConfirmDialog(J
			               , "Do you want to Logout ?"
			               ,"Logout"
			               ,JOptionPane.YES_OPTION,
			               JOptionPane.INFORMATION_MESSAGE);

			            if(output == JOptionPane.YES_OPTION){
			             chatapp c = new chatapp();
			             c.setVisible(true);
			             dispose();
			            } 
			             else if(output == JOptionPane.CANCEL_OPTION){
			              
			            }
			
			}
		});
		Logout.setBounds(401, 49, 89, 23);
		getContentPane().add(Logout);
	
	
	}
	
	private void login(String name, String address, int port) {
		new ServerMain(8080);
		dispose();
		new ClientWindow(name, address, port);}
	
	

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

}