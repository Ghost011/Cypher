import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JFrame{

int pX,pY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
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
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		setBounds(100, 100, 450, 300);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(700,500);
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
		
		
		top_panel.setBackground(new Color(102, 153, 204));
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
				JOptionPane.showMessageDialog(null, 
	        			"Developed by Aakash negi and Ishaan Kothidar \n Mini Project", 
	                    "Credits", 
	                    JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		});
		
		close.setIcon(new ImageIcon(chatapp.class.getResource("/Icons/cancel(1).png")));
		close.setBounds(661, 0, 29, 38);
		top_panel.add(close);
		
		JLabel minimize = new JLabel("");
		minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 setExtendedState(ICONIFIED);
			}
			

		});
		minimize.setIcon(new ImageIcon(chatapp.class.getResource("/Icons/12 (2).png")));
		minimize.setBounds(631, 0, 29, 38);
		top_panel.add(minimize);
		
		JLabel lblNewLabel = new JLabel("ADMINISTRATOR");
		lblNewLabel.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 20));
		lblNewLabel.setBounds(257, 41, 156, 32);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 93, 600, 357);
		getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setText("    "+"Name"+" \t\t"+"Email"+" \t\t\t"+"Username\n\n");
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int output = JOptionPane.showConfirmDialog(null
			               , "Do you want to Logout ?"
			               ,"Logout"
			               ,JOptionPane.YES_OPTION,
			               JOptionPane.INFORMATION_MESSAGE);

			            if(output == JOptionPane.YES_OPTION){
			            
			             chatapp c = new chatapp();
			             c.setVisible(true);
			             
			         
			             
			             dispose();
			}
			}});
		btnLogout.setBounds(578, 50, 89, 23);
		getContentPane().add(btnLogout);
		
		JButton btnEditUsersDetails = new JButton("Edit USers Details");
		btnEditUsersDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			edit e = new edit();
			e.setVisible(true);
			
			}
		});
		btnEditUsersDetails.setBounds(245, 461, 144, 23);
		getContentPane().add(btnEditUsersDetails);
		
	
		
		 Connection connection;
			
			String g="Male";
			
		    PreparedStatement ps;
		    try {
		        connection = DriverManager.getConnection("jdbc:mysql://192.168.43.50/student", "root", "student");
		        ps = connection.prepareStatement("SELECT * FROM student");
		      // ps.setString(1, dash.usr);
		        
		        ResultSet result = ps.executeQuery();
		        while(result.next()){
		        	
		        	 
		        	textArea.append("   -"+result.getString("Name")+"  \t\t"+result.getString("Email")+" \t\t"+result.getString("Username")+"\n\n");
		        }
		       
		    } catch (SQLException ex) {
		        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		    }
		
		
		
	}
	void close() {
		JOptionPane.showMessageDialog(null, 
    			"Mini Project Developed by Aakash negi and Ishaan Kothidar \n                     ThankYou for using Cypher", 
                "Credits", 
                JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	static void get()
	{
		
	}
}
