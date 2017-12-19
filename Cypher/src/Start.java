import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;

public class Start extends JFrame{
	private JTextField textField;
	private JTextField textField_1;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
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
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 450, 300);
		setUndecorated(true);
		setSize(600,500);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("List.foreground"), null));
		panel_1.setBackground(UIManager.getColor("Button.disabledForeground"));
		panel_1.setBounds(118, 128, 390, 237);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 20));
		lblUsername.setBounds(28, 81, 96, 14);
		panel_1.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 20));
		lblPassword.setBounds(28, 125, 96, 14);
		panel_1.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(134, 79, 227, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(134, 123, 227, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLogin = new JLabel("LOGIN ");
		lblLogin.setIcon(new ImageIcon(Start.class.getResource("/Icons/log-in.png")));
		lblLogin.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 25));
		lblLogin.setForeground(UIManager.getColor("Menu.foreground"));
		lblLogin.setBounds(151, 24, 118, 35);
		panel_1.add(lblLogin);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setIcon(new ImageIcon(Start.class.getResource("/Icons/key(1).png")));
		btnNewButton.setBounds(162, 170, 101, 23);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel =new JLabel("");
		lblNewLabel.setBounds(0, 0, 390, 237);
		panel_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 600, 500);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, 
		    			"Mini Project Developed by Aakash negi and Ishaan Kothidar \n                     ThankYou for using Cypher", 
		                "Credits", 
		                JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
				
			}
		});
		label_1.setBounds(566, 8, 24, 39);
		panel.add(label_1);
		label_1.setIcon(new ImageIcon(Start.class.getResource("/Icons/cancel(1).png")));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Negi_Jr\\Desktop\\Icons\\wallppr\\12.png"));
		label.setBounds(0, 0, 600, 500);
		panel.add(label);
	}
}
