

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField nameTF;
	private JPasswordField passTF;

	int xx, xy;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTextField contactTF;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setUndecorated(true);
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

	/*
	 * private void farmerRegister() {
	 * 
	 * try { String query =
	 * "INSERT INTO Farmerinfo(A_Name,A_Username,A_Password,A_Email,A_Age,A_Address,A_Contact) Values(?,?,?,?,?,?,?)"
	 * ; pst = conn.prepareStatement(query);
	 * 
	 * pst.setString(1, AnameTF.getText()); pst.setString(2, AuserTF.getText());
	 * pst.setString(3, ApassTF.getText()); pst.setString(4, AemailTF.getText());
	 * pst.setString(5, AageTF.getText()); pst.setString(7, AcontactTF.getText());
	 * pst.setString(6, AaddCB.getSelectedItem().toString());
	 * 
	 * pst.execute(); pst.close();
	 * 
	 * JOptionPane.showMessageDialog(null, " New Info Address"); AresetEverything();
	 * 
	 * } catch (Exception e) { e.printStackTrace();
	 * 
	 * } }
	 */
	public Home() {
		design();
		centerize();
		conn = SQLConnection.ConnecrDb();
	}
	
	
	private void centerize() {
		Dimension screenSize, frameSize;
		int x,y;
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameSize = getSize();
		x= (screenSize.width- frameSize.width)/2;
		y= (screenSize.height- frameSize.height)/2;
		setLocation(x,y);
		
	}
	
	private void Sign() {
		try {
			String query = "INSERT INTO Farmerinfo(F_UserName,F_Password,F_Contact) Values(?,?,?)";
			pst = conn.prepareStatement(query);

			pst.setString(1, nameTF.getText());
			pst.setString(2, passTF.getText());
			pst.setString(3, contactTF.getText());
			/*
			 * if (rdbtnNewRadioButton.isSelected()) { v =
			 * rdbtnNewRadioButton.getText().toString(); } else if
			 * (rdbtnNewRadioButton_1.isSelected()) { v =
			 * rdbtnNewRadioButton_1.getText().toString(); } else {
			 * JOptionPane.showMessageDialog(null, "Select Massage");
			 * 
			 * }
			 */
			

			pst.execute();
			pst.close();

			JOptionPane.showMessageDialog(null, " Signup Successful!");

			MainFrame main = new MainFrame();
			main.setVisible(true);
			dispose();
			

		} catch (Exception e) {

		}
	}
	
	private void design(){
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 102, 102));
		panel.setBounds(0, 0, 312, 490);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sign in to");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBounds(70, 286, 158, 40);
		panel.add(lblNewLabel);

		JLabel label = new JLabel("");

		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				xx = e.getX();
				xy = e.getY();
			}
		});
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {

				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				Home.this.setLocation(x - xx, y - xy);
			}
		});
		label.setBounds(0, 0, 312, 275);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(Home.class.getResource("/Files/agriculture.gif")));
		panel.add(label);

		JLabel lblWeGotYou = new JLabel("....We got you....");
		lblWeGotYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeGotYou.setForeground(new Color(240, 248, 255));
		lblWeGotYou.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		lblWeGotYou.setBounds(81, 364, 151, 22);
		panel.add(lblWeGotYou);

		JLabel lblNewLabel_1 = new JLabel("Stay with us");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(106, 337, 97, 22);
		panel.add(lblNewLabel_1);

		Button button = new Button("SignUp");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sign();
				
				//farmerRegister();
			}
		});
		button.setForeground(new Color(0, 0, 0));
		button.setBackground(new Color(32, 178, 170));
		button.setBounds(467, 329, 114, 36);
		contentPane.add(button);

		nameTF = new JTextField();
		nameTF.setBounds(395, 83, 283, 36);
		contentPane.add(nameTF);
		nameTF.setColumns(10);

		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(new Color(192, 192, 192));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(395, 58, 114, 14);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(new Color(192, 192, 192));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(395, 145, 96, 14);
		contentPane.add(lblPassword);

		JLabel lblRepeatPassword = new JLabel("CONTACT");
		lblRepeatPassword.setForeground(new Color(192, 192, 192));
		lblRepeatPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRepeatPassword.setBounds(395, 233, 133, 14);
		contentPane.add(lblRepeatPassword);

		passTF = new JPasswordField();
		passTF.setBounds(395, 170, 283, 36);
		contentPane.add(passTF);

		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				System.exit(0);
			}
		});
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(new Color(241, 57, 83));
		lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_close.setBounds(691, 0, 37, 27);
		contentPane.add(lbl_close);
		
		contactTF = new JTextField();
		contactTF.setBounds(395, 258, 283, 36);
		contentPane.add(contactTF);
		contactTF.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(47, 79, 79));
		panel_1.setBounds(313, 0, 416, 476);
		contentPane.add(panel_1);
		setUndecorated(true);

	}
}
