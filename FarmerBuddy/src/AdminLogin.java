import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.DropMode;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField UserTF;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JLabel lblNewLabel;
	public static String welcomeName = "";
	private JCheckBox chckbxImNotA ;

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JPasswordField PassTF;
	private JButton btnNewButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		conn = SQLConnection.ConnecrDb();
		design();
		centerize();
	}
	
	private void centerize() {
		Dimension screenSize, frameSize;
		int x, y;
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameSize = getSize();
		x = (screenSize.width - frameSize.width) / 2;
		y = (screenSize.height - frameSize.height) / 2;
		setLocation(x, y);

	}
	
	private void Alogin() {

		try {

			String query = "SELECT * FROM Admininfo WHERE A_Username = ? AND A_Password = ?";

			pst = conn.prepareStatement(query);

			pst.setString(1, UserTF.getText());
			pst.setString(2, PassTF.getText());

			rs = pst.executeQuery();

			if (rs.next()) {

				welcomeName = rs.getString("A_Name");

				if (chckbxImNotA.isSelected()) {
					// JOptionPane.showMessageDialog(null, "login Successful!");
					Admin a = new Admin();
					a.setVisible(true);
					dispose();

				} else {
					JOptionPane.showMessageDialog(null, "Prove You Are Not a Robot...");

				}

			} else {
				if (chckbxImNotA.isSelected()) {
					JOptionPane.showMessageDialog(null, "login Failed!");
					dispose();

				} else {
					JOptionPane.showMessageDialog(null, "Prove You Are Not a Robot...");

				}
			}

			pst.close();
			rs.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	
	private void design(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminLogin.class.getResource("/Image/Process-Accept-icon.png")));
		setTitle("ADMIN LOGIN PAGE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		UserTF = new JTextField();
		UserTF.setBackground(new Color(224, 255, 255));
		UserTF.setColumns(10);
		UserTF.setBounds(219, 89, 114, 20);
		contentPane.add(UserTF);
		
		lblUsername = new JLabel("UserName");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Perpetua Titling MT", Font.BOLD, 11));
		lblUsername.setIcon(new ImageIcon(AdminLogin.class.getResource("/Image/man-icon.png")));
		lblUsername.setBounds(110, 88, 99, 26);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Perpetua Titling MT", Font.BOLD, 11));
		lblPassword.setIcon(new ImageIcon(AdminLogin.class.getResource("/Image/Apps-preferences-desktop-user-password-icon.png")));
		lblPassword.setBounds(110, 125, 99, 26);
		contentPane.add(lblPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(218, 165, 32));
		btnLogin.setBackground(new Color(0, 0, 0));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (UserTF.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter Username !");
				} else if (PassTF.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter Password To Continue !");
				} else {
					Alogin();
				}
			}
		});
		btnLogin.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		btnLogin.setBounds(219, 216, 86, 20);
		contentPane.add(btnLogin);
		
		PassTF = new JPasswordField();
		PassTF.setBackground(new Color(224, 255, 255));
		PassTF.setBounds(219, 126, 114, 20);
		contentPane.add(PassTF);
		
		chckbxImNotA = new JCheckBox("I'm Not A Robot :)");
		chckbxImNotA.setFont(new Font("Segoe UI Symbol", Font.BOLD, 11));
		chckbxImNotA.setForeground(new Color(0, 0, 0));
		chckbxImNotA.setBackground(new Color(218, 165, 32));
		chckbxImNotA.setBounds(219, 168, 114, 23);
		contentPane.add(chckbxImNotA);
		
		btnNewButton = new JButton("X");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(139, 69, 19));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(397, 0, 52, 26);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminLogin.class.getResource("/Image/cool-abstract-background-\u2764-4k-hd-desktop-wallpaper-for-4k-ultra.jpg")));
		lblNewLabel.setBounds(0, 0, 449, 317);
		contentPane.add(lblNewLabel);
		setUndecorated(true);
	}
}
