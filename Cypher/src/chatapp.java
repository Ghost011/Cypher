
import javax.swing.*;
import java.awt.event.*;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class chatapp extends JFrame implements ActionListener{

	int pX,pY;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chatapp window = new chatapp();
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
	public chatapp() {
		getContentPane().setBackground(UIManager.getColor("CheckBox.light"));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		setUndecorated(true);
		setResizable(false);
		setSize(700,500);
		getContentPane().setLayout(null);
		//.setOpaque(false);
		JPanel top_panel = new JPanel();
		
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
		
		
		top_panel.setBackground(new Color(102, 153, 204));
		top_panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		top_panel.setBounds(0, 0, 700, 38);
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
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME");
		lblNewLabel_1.setFont(new Font("Sitka Banner", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_1.setBounds(0, 35, 700, 72);
		getContentPane().add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(357, 118, 13, 350);
		getContentPane().add(separator);
		
		JLabel lblNewHereJoin = new JLabel("New here Join us !!");
		lblNewHereJoin.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblNewHereJoin.setBounds(29, 118, 226, 58);
		getContentPane().add(lblNewHereJoin);
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				Signin s = new Signin();
				s.setVisible(true);
				dispose();
				
			}
			
		});
		btnNewButton.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		btnNewButton.setBackground(UIManager.getColor("ToggleButton.shadow"));
		btnNewButton.setFont(new Font("Sitka Display", Font.BOLD, 16));
		btnNewButton.setBounds(29, 232, 318, 47);
		getContentPane().add(btnNewButton);
		
		JButton btnSignIn = new JButton("Login");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Login s = new Login();
				s.setVisible(true);
				dispose();
				
			}
		});
		btnSignIn.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		btnSignIn.setBackground(UIManager.getColor("Button.shadow"));
		btnSignIn.setFont(new Font("Sitka Display", Font.BOLD, 16));
		btnSignIn.setBounds(372, 232, 318, 47);
		getContentPane().add(btnSignIn);
		
		JLabel lblClickTheButton = new JLabel("Click the button below to sign up");
		lblClickTheButton.setForeground(new Color(0, 0, 255));
		lblClickTheButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClickTheButton.setBounds(29, 189, 242, 32);
		getContentPane().add(lblClickTheButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 306, 317, 2);
		getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(373, 306, 317, 2);
		getContentPane().add(separator_2);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setBounds(159, 311, 46, 14);
		getContentPane().add(lblOr);
		
		JLabel label = new JLabel("OR");
		label.setBounds(511, 311, 46, 14);
		getContentPane().add(label);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				commingsoon();
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(chatapp.class.getResource("/Icons/facebook(1).png")));
		lblNewLabel_2.setBounds(107, 396, 40, 38);
		getContentPane().add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(chatapp.class.getResource("/Icons/twitter(1).png")));
		lblNewLabel_3.setBounds(150, 396, 46, 38);
		getContentPane().add(lblNewLabel_3);
		

		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				commingsoon();
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(chatapp.class.getResource("/Icons/skype.png")));
		lblNewLabel_4.setBounds(192, 396, 46, 38);
		getContentPane().add(lblNewLabel_4);
		

		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				commingsoon();
			}
		});
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(chatapp.class.getResource("/Icons/facebook(1).png")));
		label_1.setBounds(463, 396, 40, 38);
		getContentPane().add(label_1);
		

		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				commingsoon();
			}
		});
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(chatapp.class.getResource("/Icons/skype.png")));
		label_2.setBounds(544, 396, 46, 38);
		getContentPane().add(label_2);
		
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				commingsoon();
			}
		});
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(chatapp.class.getResource("/Icons/twitter(1).png")));
		label_3.setBounds(501, 396, 46, 38);
		getContentPane().add(label_3);
		
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				commingsoon();
			}
		});
		
		JLabel lblSignUpWith = new JLabel("Sign up with -");
		lblSignUpWith.setForeground(Color.BLUE);
		lblSignUpWith.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSignUpWith.setBounds(29, 353, 242, 32);
		getContentPane().add(lblSignUpWith);
		
		JLabel lblSignInWith = new JLabel("Login with -");
		lblSignInWith.setForeground(Color.BLUE);
		lblSignInWith.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSignInWith.setBounds(380, 353, 242, 32);
		getContentPane().add(lblSignInWith);
		
		JLabel lblAlreadyAMember = new JLabel("Already a member ?");
		lblAlreadyAMember.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblAlreadyAMember.setBounds(380, 118, 226, 58);
		getContentPane().add(lblAlreadyAMember);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(chatapp.class.getResource("/Icons/elegant-man-saluting(1).png")));
		lblNewLabel.setBounds(217, 35, 66, 72);
		getContentPane().add(lblNewLabel);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	void commingsoon()
	{
		JOptionPane.showConfirmDialog(null
	               , "Our developer team is currently working on this ,Please wait for our next version update ThankYou!!"
	               ,"Comming Soon!!"
	               ,
	               JOptionPane.PLAIN_MESSAGE);
	
	}
	
	void close() {
		JOptionPane.showMessageDialog(null, 
    			"Mini Project Developed by Aakash negi and Ishaan Kothidar \n                     ThankYou for using Cypher", 
                "Credits", 
                JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

	}