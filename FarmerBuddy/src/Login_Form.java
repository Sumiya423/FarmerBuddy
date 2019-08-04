

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Login_Form extends JFrame {

	private JPanel contentPane;
	
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public static String welcomeName = "";
	
	private JPasswordField passwordField;
	private JTextField usernameField;

	private int parameterIndex;
	private JLabel lblNewLabel_1;
	private JButton btnLogin ;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Form  frame = new Login_Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login_Form() {
		conn = SQLConnection.ConnecrDb();
		setResizable(false);
		setTitle("Login Page");
		design();
		centerize();
		
		
	}
	
	public void centerize() {
		Dimension screenSize,frameSize;
		int x,y;
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameSize = getSize();
		x = (screenSize.width - frameSize.width) / 2;
		y = (screenSize.height - frameSize.height)/2;
		setLocation(x,y);
	}
	private void login() {
		try {
			String query = "SELECT * FROM Farmerinfo WHERE F_Username = ? AND F_Password = ?";
			
			pst = conn.prepareStatement(query);
			
			pst.setString(1, usernameField.getText());
			pst.setString(2, passwordField.getText());
			
			rs = pst.executeQuery();
						
				if(rs.next())
				{
					welcomeName = rs.getString("F_Username");
					
					JOptionPane.showMessageDialog(null, "Successfully Loged in");
					Consultations c = new Consultations();
					c.setVisible(true);
					dispose();
				
				
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong username or password");
				}
				
				pst.close();
				rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private String TimexText() {
		// TODO Auto-generated method stub
		return null;
	}
	



	private void design(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 456);
		contentPane = new JPanel();

	
		contentPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.setBackground(SystemColor.windowText);
		btnNewButton.setForeground(SystemColor.info);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usernameField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter Username");
				}
				else if(passwordField.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Enter Password");
					}
				else {
				login();
				}
			}
		});
		btnNewButton.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		btnNewButton.setBounds(289, 334, 138, 44);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(BorderFactory.createEmptyBorder());
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(Color.BLACK);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setToolTipText("Password");
		passwordField.setBounds(199, 238, 228, 29);
		contentPane.add(passwordField);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(93, 159, 77, 19);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(93, 243, 73, 19);
		contentPane.add(lblPassword);
		
		usernameField = new JTextField();
		
		usernameField.setBorder(BorderFactory.createEmptyBorder());
		usernameField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		usernameField.setForeground(Color.WHITE);
		usernameField.setBackground(Color.BLACK);
		usernameField.setFont(new Font("Tahoma", Font.BOLD, 15));
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setBounds(199, 154, 228, 29);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JButton btnExit = new JButton("X");
		btnExit.setBorderPainted(false);
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(new Color(0, 102, 153));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBounds(554, 0, 56, 36);
		contentPane.add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(SystemColor.window);
		separator.setBounds(199, 184, 228, 19);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.window);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(199, 271, 228, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login_Form.class.getResource("/Files/Typeform-Blog-BlackFriday-Cover-AskAwesomely.jpg")));
		
		lblNewLabel.setBounds(10, 107, 572, 338);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login_Form.class.getResource("/Files/WhiteUser_96px.png")));
		lblNewLabel_1.setBounds(250, 7, 96, 96);
		contentPane.add(lblNewLabel_1);
		setUndecorated(true);


	}
}
