

import java.awt.Color;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultCaret;


import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;

public class ClientWindow extends JFrame implements Runnable {
	//private static final long serialVersionUID = 1L;
	int pX,pY;
	private JPanel contentPane;
	private JTextField txtMessage;
	static JTextArea history;
	private DefaultCaret caret;
	private Thread run, listen;
	private Client client;

	private boolean running = false;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmOnlineUsers;
	private JMenuItem mntmExit;

	private OnlineUsers users;
	private JScrollPane scrollPane;
	public static JList<String> list;

	public ClientWindow(String name, String address, int port)  {
		
		getContentPane().setBackground(SystemColor.inactiveCaption);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		setResizable(false);
		setSize(745,540);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setBackground(new Color(241,169,160));
		setVisible(true);
		
		//.setOpaque(false);
				JPanel top_panel = new JPanel();
				top_panel.setBounds(0, 0, 745, 38);
				
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
				
					JButton btnLogout = new JButton("Logout");
					btnLogout.setBounds(635, 51, 90, 23);
					btnLogout.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JFrame J =  new JFrame();
							 int output = JOptionPane.showConfirmDialog(J
						               , "Do you want to Logout ?"
						               ,"Logout"
						               ,JOptionPane.YES_OPTION,
						               JOptionPane.INFORMATION_MESSAGE);

						            if(output == JOptionPane.YES_OPTION){
						            	database();
						             chatapp c = new chatapp();
						             c.setVisible(true);
						             
						         
						             
						             dispose();
						             String disconnect = "/d/" + client.getID() + "/e/";
										send(disconnect, false);
										running = false;
										client.close();
						            }
						             else if(output == JOptionPane.CANCEL_OPTION){
						              
						            }
						
						}
					});
					getContentPane().add(btnLogout);
					
					JLabel usrnm = new JLabel("");
					usrnm.setBounds(20, 49, 290, 26);
					usrnm.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
					getContentPane().add(usrnm);
					
					usrnm.setText(dash.usr.toUpperCase());
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
					close.setIcon(new ImageIcon(ClientWindow.class.getResource("/Icons/cancel(1).png")));
					close.setBounds(716, 0, 29, 38);
					top_panel.add(close);
					

					JLabel minimize = new JLabel("");
					minimize.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							
							 setExtendedState(ICONIFIED);
						}

					});
					minimize.setIcon(new ImageIcon(ClientWindow.class.getResource("/Icons/12 (2).png")));
					minimize.setBounds(686, 0, 29, 38);
					top_panel.add(minimize);
					
					
					top_panel.setBackground(new Color(37,116,169));
					top_panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
					getContentPane().add(top_panel);
					top_panel.setLayout(null);
					setLocationRelativeTo(null);
					JLabel lblMychatV = new JLabel("Cypher v1.0");
					lblMychatV.setFont(new Font("Sitka Text", Font.BOLD, 15));
					lblMychatV.setBounds(10, 11, 95, 14);
					top_panel.add(lblMychatV);
					
					
					
					
		client = new Client(name, address, port);
		boolean connect = client.openConnection(address);
		if (!connect) {
			System.err.println("Connection failed!");
			console("Connection failed!");
		}
		//createWindow();
		
		//console("Welcome "+ name+ " to " + address + ":" + port  );
		String connection = "/c/" + name + "/e/";
		client.send(connection.getBytes());
		users = new OnlineUsers();
		running = true;
		run = new Thread(this, "Running");
		run.start();
	}
	{
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		history = new JTextArea();
		history.setEditable(false);
		JScrollPane scroll = new JScrollPane(history);
		scroll.setBounds(20, 75, 600, 400);
		caret = (DefaultCaret) history.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		contentPane.setLayout(null);
		contentPane.add(scroll);

		txtMessage = new JTextField();
		txtMessage.setBounds(20, 485, 530, 40);
		txtMessage.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					send(txtMessage.getText(), true);
				}
			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(635, 75, 90, 450);
		contentPane.add(scrollPane);
		
		list = new JList<String>();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				int a =  client.getID();
			}
		});
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"ALL"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		list.setSelectedIndex(0);
		scrollPane.setViewportView(list);
		contentPane.add(txtMessage);
		txtMessage.setColumns(10);

		JButton btnSend = new JButton("Send");
		btnSend.setBounds(555, 485, 70, 40);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				send(txtMessage.getText(), true);
			}
		});
		contentPane.add(btnSend);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				String disconnect = "/d/" + client.getID() + "/e/";
				send(disconnect, false);
				running = false;
				client.close();
			}
		});

		txtMessage.requestFocusInWindow();
	}

	public void run() {
		listen();
	}

	private void send(String message, boolean text) {
		String a=client.getName();
		
		
		if (message.equals("") || message.equals(" ")) return;
		if (text) {
			message ="  " + a.toUpperCase() + "\t:     " + message;
			message = "/m/" + message + "/e/";
			txtMessage.setText("");
		}
		client.send(message.getBytes());
	}

	public void listen() {
		listen = new Thread("Listen") {
			public void run() {
				while (running) {
					String message = client.receive();
					if (message.startsWith("/c/")) {
						client.setID(Integer.parseInt(message.split("/c/|/e/")[1]));
						//console("Enjoy chatting !! Your chat ID: " + client.getID());
					} else if (message.startsWith("/m/")) {
						String text = message.substring(3);
						text = text.split("/e/")[0];
						console(text);
					} else if (message.startsWith("/i/")) {
						String text = "/i/" + client.getID() + "/e/";
						send(text, false);
					} else if (message.startsWith("/u/")) {
						String[] u = message.split("/u/|/n/|/e/");
						users.update(Arrays.copyOfRange(u, 1, u.length - 1));
						update(Arrays.copyOfRange(u, 1, u.length - 1));
					}
				}
			}
		};
		listen.start();
	}

	public void console(String message) {
		history.append(message + "\n");
		history.setCaretPosition(history.getDocument().getLength());
	}
	
	public void update(String[] users) {
		list.setListData(users);
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
		
		try
		{
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.43.50/student","root","student");
			Statement stat = conn.createStatement();
			String a = history.getText();
			String name = dash.usr;
			String sql = "update student set history = '"+history.getText()+"' where Username = '"+name+"'";
			
			stat.executeUpdate(sql);
			System.out.println("");
			
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
	static void get()
	{
		 Connection connection;
			
		
			String name = dash.usr;
		    PreparedStatement ps;
		    try {
		        connection = DriverManager.getConnection("jdbc:mysql://192.168.43.50/student", "root", "student");
		        ps = connection.prepareStatement("SELECT history FROM student WHERE Username = '"+name+"'");
		      // ps.setString(1, dash.usr);
		        
		        ResultSet result = ps.executeQuery();
		        if(!result.next()){
		        	
		        	// history.setText(result.getString("history"));
		 			
		        	JOptionPane.showMessageDialog(null, 
		        			"Unsucessful", 
		                    "Unsucessful", 
		                    JOptionPane.INFORMATION_MESSAGE);
		        }
		        else{
		        	
		   history.append(result.getString("history"));

		        	
		        }
		    } catch (SQLException ex) {
		        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		    }
	}

}
