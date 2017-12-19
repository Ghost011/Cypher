import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
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

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

public class edit extends JFrame {

	int pX,pY;
	private JTextField usr;
	ButtonGroup bg;
	JRadioButton Update,Delete;
	JComboBox comboBox;
	String k;
	JTextField Values;
	
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edit window = new edit();
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
	public edit() {
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
		setVisible(true);
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
		
		usr = new JTextField();
		usr.setBounds(284, 280, 250, 20);
		getContentPane().add(usr);
		usr.setColumns(10);
		usr.setVisible(false);
		
		JLabel lusr = new JLabel("UserName :");
		lusr.setBounds(130, 283, 101, 14);
		getContentPane().add(lusr);
		lusr.setVisible(false);
		
		String s[] = {"Select the field","Name","Email","Username","Password"};
		 comboBox = new JComboBox(s);
		comboBox.setBounds(284, 161, 250, 20);
		getContentPane().add(comboBox);
		
		JButton btnExecute = new JButton("Execute");
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				database();
			}
		});
		btnExecute.setBounds(301, 424, 168, 23);
		getContentPane().add(btnExecute);
		
		Values = new JTextField();
		Values.setBounds(285, 332, 249, 20);
		getContentPane().add(Values);
		Values.setColumns(10);
		Values.setVisible(false);
		
		JLabel lblChanges = new JLabel("Values");
		lblChanges.setBounds(130, 335, 46, 14);
		getContentPane().add(lblChanges);
		lblChanges.setVisible(false);
		
		JLabel lblFields = new JLabel("Fields     :");
		lblFields.setBounds(130, 164, 66, 14);
		getContentPane().add(lblFields);
		JRadioButton Update = new JRadioButton("Update");
		Update.setActionCommand("Update");
		Update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lusr.setVisible(true);
				usr.setVisible(true);
				lblChanges.setVisible(true);
				Values.setVisible(true);
				
				
				
			}
		});
		
		Update.setBounds(284, 220, 101, 23);
		getContentPane().add(Update);
		
		 Delete = new JRadioButton("Delete");
		
		Delete.setBounds(422, 220, 94, 23);
		getContentPane().add(Delete);
		Delete.setActionCommand("Delete");
		Delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lusr.setVisible(true);
				usr.setVisible(true);
				lblChanges.setVisible(true);
				Values.setVisible(true);
			}
		});
		
		ButtonGroup bg  = new ButtonGroup();
		
		bg.add(Update);
		bg.add(Delete);
		
		
	}
	void close() {
		JOptionPane.showMessageDialog(null, 
    			"Mini Project Developed by Aakash negi and Ishaan Kothidar \n                     ThankYou for using Cypher", 
                "Credits", 
                JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	void database()
	{
	//	k = bg.getSelection();
		
		String a = usr.getText();
		
			
			try
			{
				Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.43.50/student","root","student");
				Statement stat = conn.createStatement();
				
				String name = usr.getText();
				Object u = comboBox.getSelectedItem();
				String v = Values.getText();
				String sql = "update student set 'Email'= '"+v+"' where Username = '"+name+"'";
				
				stat.executeUpdate(sql);
				System.out.println("Sucess!!");
				
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}

		
	//	}
		
		
		
		
		
	}
}
