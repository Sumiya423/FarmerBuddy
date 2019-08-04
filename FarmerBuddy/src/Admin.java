import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;


public class Admin extends JFrame {

	private JPanel contentPane;
	private JTable Ftable;
	private JTable Atable;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTextField fTF;
	private JTextField aTF;
    private JComboBox farmerCB;
    private JComboBox adminCB;
    private JTextField userTF;
    private JTextField passTF;
    private JTextField contactTF;
    private JTextField timeTF;
    private JLabel lblPassword;
    private JLabel lblContact;
    private JLabel lblTime;
    private int F_ID = 0;
    private int A_ID = 0;
    private JButton UpdateBtnA;
    private JButton RefreshBtn;
    private JTextField AnameTF;
    private JTextField AuserTF;
    private JTextField ApassTF;
    private JTextField AemailTF;
    private JTextField AageTF;
    private JLabel lblNewLabel_1;
    private JLabel lblName;
    private JLabel lblPassword_1;
    private JLabel lblAge;
    private JLabel lblUser;
    private JLabel lblEmail;
    private JLabel lblAddress;
    private JTextField AcontactTF;
    private JLabel lblContact_1;
    private JLabel label;
    private JLabel label_1;
    private JButton resetBtn;
    private JComboBox AaddCB;
    private JButton addBtn;
    private JButton deleteBtn;
    private String u = "";
    private JLabel clockLabel;
    private JButton button;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Admin.class.getResource("/Image/administrator-icon.png")));
		setTitle("ADMIN PANEL");
		design();
		centerize();
		conn = SQLConnection.ConnecrDb();
		loadTableF();
		loadTableA();
		clock();
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
	
	
	private void loadTableF() {
		try {
			String query = "SELECT * FROM Farmerinfo";
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			Ftable.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void loadTableA() {
		try {
			String query = "SELECT * FROM Admininfo";
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			Atable.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void FsearchData() {
		try {
			String selection = (String) farmerCB.getSelectedItem();

			String query = "SELECT F_Username,F_Password,F_Contact,TimeUp FROM Farmerinfo WHERE "
					+ selection + " LIKE '" + fTF.getText() + "%' ";

			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			Ftable.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	private void AsearchData() {
		try {
			String selection = (String) adminCB.getSelectedItem();

			String query = "SELECT A_Name,A_Username,A_Password,A_Email,A_Age,A_Address,A_Contact FROM Admininfo WHERE "
					+ selection + " LIKE '" + aTF.getText() + "%' ";

			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			Atable.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void FloadToField() {
		try {
			int row = Ftable.getSelectedRow();
			String ID = (Ftable.getModel().getValueAt(row, 0)).toString();
			String query = "Select * FROM Farmerinfo WHERE F_ID ='" + ID + "'";
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();

			while (rs.next()) {
				F_ID = rs.getInt("F_ID");
				
				userTF.setText(rs.getString("F_Username"));
				passTF.setText(rs.getString("F_Password"));
				contactTF.setText(rs.getString("F_Contact"));
				timeTF.setText(rs.getString("TimeUp"));

				
				
				
			}
			pst.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void FupdateData() {
		try {

			String query = "UPDATE Farmerinfo SET F_Username ='" + userTF.getText() + "',F_Password ='" + passTF.getText() + "',F_Contact ='" + contactTF.getText() + "'WHERE F_ID='"+F_ID + "'";

			pst = conn.prepareStatement(query);
			pst.execute();

			JOptionPane.showMessageDialog(null, " Data Updated Successfully !");

			pst.close();
			AresetEverything();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void AresetEverything() {

		
		userTF.setText(null);
		passTF.setText(null);
		
		contactTF.setText(null);
		timeTF.setText(null);
		farmerCB.setSelectedItem(".");
		adminCB.setSelectedItem(".");
		fTF.setText(null);
		AnameTF.setText(null);
		AuserTF.setText(null);
		ApassTF.setText(null);
		AemailTF.setText(null);
		AageTF.setText(null);
		AcontactTF.setText(null);
		AaddCB.setSelectedItem(".");
		
		loadTableF();
		loadTableA();

	}
	
	
	private void AloadToField() {
		try {
			int row =Atable.getSelectedRow();
			String ID = (Atable.getModel().getValueAt(row, 0)).toString();
			String query = "Select * FROM Admininfo WHERE A_ID ='" + ID + "'";
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();

			while (rs.next()) {
				A_ID = rs.getInt("A_ID");

				AnameTF.setText(rs.getString("A_Name"));
				AuserTF.setText(rs.getString("A_Username"));
				ApassTF.setText(rs.getString("A_Password"));
				AemailTF.setText(rs.getString("A_Email"));
				
				
				AageTF.setText(rs.getString("A_Age"));
				AcontactTF.setText(rs.getString("A_Contact"));

				u = rs.getString("A_Address");
				if (u.equals("Dhaka")) {
					AaddCB.setSelectedItem("Dhaka");
				} else if (u.equals("Sylhet")) {
					AaddCB.setSelectedItem("Sylhet");
				} else if (u.equals("Khulna")) {
					AaddCB.setSelectedItem("Khulna");
				} else if (u.equals("Rajshahi")) {
					AaddCB.setSelectedItem("Rajshahi");
				} else if (u.equals("Barishal")) {
					AaddCB.setSelectedItem("Barishal");
				} else if (u.equals("Chittagong")) {
					AaddCB.setSelectedItem("Chittagong");
				} else {
					System.out.println("");
				}

			}
			pst.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private void AaddData() {
		try {
			String query = "INSERT INTO Admininfo(A_Name,A_Username,A_Password,A_Email,A_Age,A_Address,A_Contact) Values(?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(query);

			pst.setString(1, AnameTF.getText());
			pst.setString(2, AuserTF.getText());
			pst.setString(3, ApassTF.getText());
			pst.setString(4, AemailTF.getText());
			pst.setString(5, AageTF.getText());
			pst.setString(7, AcontactTF.getText());
			pst.setString(6, AaddCB.getSelectedItem().toString());

			pst.execute();
			pst.close();

			JOptionPane.showMessageDialog(null, " New Info Address");
			AresetEverything();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	private void AdeleteData() {
		try {
			int action = JOptionPane.showConfirmDialog(null, "Are You Sure to Delete?", "Delete",
					JOptionPane.YES_NO_CANCEL_OPTION);

			if (action == 0) {
				String query = " DELETE FROM Admininfo WHERE A_ID ='" + A_ID + "'";
				pst = conn.prepareStatement(query);
				pst.execute();

				JOptionPane.showMessageDialog(null, "Deleted Successfully !");

				pst.close();
				AresetEverything();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void clock() {

		Thread clock = new Thread() {
			public void run() {
				try {
					for (;;) {
						Calendar cal = new GregorianCalendar();
						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy   hh:mm:ss a");
						Date date = cal.getTime();
						String timeString = formatter.format(date);
						clockLabel.setText(timeString);
						sleep(1000);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		};
		clock.start();
	}



	private void design(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 119, 254, 101);
		contentPane.add(scrollPane);
		
		Ftable = new JTable();
		scrollPane.setViewportView(Ftable);
		Ftable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FloadToField();
			}
		});
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(274, 119, 404, 101);
		contentPane.add(scrollPane_1);
		
		Atable = new JTable();
		scrollPane_1.setViewportView(Atable);
		Atable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AloadToField();
			}
		});
		
		 farmerCB = new JComboBox();
		 farmerCB.setBackground(new Color(216, 191, 216));
		 farmerCB.setModel(new DefaultComboBoxModel(new String[] {".", "F_ID", "F_Username", "F_Password", "F_Contact"}));
		farmerCB.setBounds(10, 92, 115, 17);
		contentPane.add(farmerCB);
		
		fTF = new JTextField();
		fTF.setBackground(new Color(230, 230, 250));
		fTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				FsearchData();
			}
		});
		fTF.setColumns(10);
		fTF.setBounds(149, 91, 115, 17);
		contentPane.add(fTF);
		
		 adminCB = new JComboBox();
		 adminCB.setBackground(new Color(216, 191, 216));
		 adminCB.setModel(new DefaultComboBoxModel(new String[] {".", "A_ID", "A_Username", "A_Password", "A_Email", "A_Age", "A_Address", "A_Contact"}));
		adminCB.setBounds(334, 91, 115, 17);
		contentPane.add(adminCB);
		
		aTF = new JTextField();
		aTF.setBackground(new Color(230, 230, 250));
		aTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				AsearchData();
			}
		});
		aTF.setColumns(10);
		aTF.setBounds(520, 90, 136, 17);
		contentPane.add(aTF);
		
		JLabel lblNewLabel = new JLabel("Farmer Informations");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Script MT Bold", Font.PLAIN, 15));
		lblNewLabel.setBounds(64, 59, 148, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblAdminInformations = new JLabel("Admin Informations");
		lblAdminInformations.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminInformations.setForeground(Color.WHITE);
		lblAdminInformations.setFont(new Font("Script MT Bold", Font.PLAIN, 15));
		lblAdminInformations.setBounds(427, 58, 136, 22);
		contentPane.add(lblAdminInformations);
		
		addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AaddData();
			}
		});
		addBtn.setForeground(new Color(0, 139, 139));
		addBtn.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		addBtn.setBounds(595, 247, 83, 17);
		contentPane.add(addBtn);
		
		UpdateBtnA = new JButton("Update");
		UpdateBtnA.setForeground(new Color(0, 139, 139));
		UpdateBtnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FupdateData();
			}
		});
		UpdateBtnA.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		UpdateBtnA.setBounds(184, 247, 83, 17);
		contentPane.add(UpdateBtnA);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdeleteData();
			}
		});
		deleteBtn.setForeground(new Color(0, 139, 139));
		deleteBtn.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		deleteBtn.setBounds(595, 275, 83, 17);
		contentPane.add(deleteBtn);
		
		RefreshBtn = new JButton("Refresh");
		RefreshBtn.setIcon(null);
		RefreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AresetEverything();
			}
		});
		RefreshBtn.setForeground(new Color(0, 139, 139));
		RefreshBtn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		RefreshBtn.setBounds(184, 275, 83, 17);
		contentPane.add(RefreshBtn);
		
		JButton LogoutBtn = new JButton("Logout");
		LogoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mf = new MainFrame();
				mf.setVisible(true);
				dispose();
			}
		});
		LogoutBtn.setBackground(new Color(220, 20, 60));
		LogoutBtn.setHorizontalAlignment(SwingConstants.LEFT);
		LogoutBtn.setIcon(new ImageIcon(Admin.class.getResource("/Image/LOGOUT.png")));
		LogoutBtn.setForeground(new Color(255, 255, 255));
		LogoutBtn.setFont(new Font("Segoe UI Emoji", Font.BOLD, 13));
		LogoutBtn.setBounds(274, 401, 106, 28);
		contentPane.add(LogoutBtn);
		
		userTF = new JTextField();
		userTF.setColumns(10);
		userTF.setBounds(78, 246, 96, 20);
		contentPane.add(userTF);
		
		passTF = new JTextField();
		passTF.setColumns(10);
		passTF.setBounds(78, 274, 96, 20);
		contentPane.add(passTF);
		
		contactTF = new JTextField();
		contactTF.setColumns(10);
		contactTF.setBounds(78, 305, 96, 20);
		contentPane.add(contactTF);
		
		timeTF = new JTextField();
		timeTF.setColumns(10);
		timeTF.setBounds(78, 336, 96, 20);
		contentPane.add(timeTF);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblUsername.setBounds(10, 248, 58, 14);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblPassword.setBounds(10, 276, 58, 14);
		contentPane.add(lblPassword);
		
		lblContact = new JLabel("Contact");
		lblContact.setForeground(Color.WHITE);
		lblContact.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblContact.setBounds(10, 307, 58, 14);
		contentPane.add(lblContact);
		
		lblTime = new JLabel("Time");
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblTime.setBounds(10, 338, 58, 14);
		contentPane.add(lblTime);
		
		AnameTF = new JTextField();
		AnameTF.setColumns(10);
		AnameTF.setBounds(334, 246, 96, 20);
		contentPane.add(AnameTF);
		
		AuserTF = new JTextField();
		AuserTF.setColumns(10);
		AuserTF.setBounds(334, 274, 96, 20);
		contentPane.add(AuserTF);
		
		ApassTF = new JTextField();
		ApassTF.setColumns(10);
		ApassTF.setBounds(334, 305, 96, 20);
		contentPane.add(ApassTF);
		
		AemailTF = new JTextField();
		AemailTF.setColumns(10);
		AemailTF.setBounds(334, 336, 96, 20);
		contentPane.add(AemailTF);
		
		AageTF = new JTextField();
		AageTF.setColumns(10);
		AageTF.setBounds(489, 246, 96, 20);
		contentPane.add(AageTF);
		
		lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblName.setBounds(274, 248, 46, 14);
		contentPane.add(lblName);
		
		lblPassword_1 = new JLabel("Password");
		lblPassword_1.setForeground(Color.WHITE);
		lblPassword_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblPassword_1.setBounds(274, 307, 58, 14);
		contentPane.add(lblPassword_1);
		
		lblUser = new JLabel("User");
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblUser.setBounds(274, 276, 46, 14);
		contentPane.add(lblUser);
		
		lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblEmail.setBounds(274, 339, 46, 14);
		contentPane.add(lblEmail);
		
		lblAge = new JLabel("Age");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblAge.setBounds(440, 247, 37, 17);
		contentPane.add(lblAge);
		
		AaddCB = new JComboBox();
		AaddCB.setModel(new DefaultComboBoxModel(new String[] {".", "Dhaka", "Chittagong", "Rajshahi", "Sylhet", "Barishal", "Khulna"}));
		AaddCB.setBounds(490, 307, 95, 17);
		contentPane.add(AaddCB);
		
		lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblAddress.setBounds(440, 307, 50, 14);
		contentPane.add(lblAddress);
		
		AcontactTF = new JTextField();
		AcontactTF.setColumns(10);
		AcontactTF.setBounds(489, 274, 96, 20);
		contentPane.add(AcontactTF);
		
		lblContact_1 = new JLabel("Contact");
		lblContact_1.setForeground(Color.WHITE);
		lblContact_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblContact_1.setBounds(440, 277, 46, 14);
		contentPane.add(lblContact_1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Admin.class.getResource("/Image/farmer.png")));
		label.setBounds(116, 11, 58, 45);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Admin.class.getResource("/Image/Supervisor-icon.png")));
		label_1.setBounds(473, 11, 46, 45);
		contentPane.add(label_1);
		
		resetBtn = new JButton("Refresh");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		          AresetEverything();
			}
			
		});
		resetBtn.setForeground(new Color(0, 139, 139));
		resetBtn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		resetBtn.setBounds(595, 306, 83, 17);
		contentPane.add(resetBtn);
		
		clockLabel = new JLabel("CLOCK");
		clockLabel.setFont(new Font("Perpetua Titling MT", Font.BOLD, 15));
		clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clockLabel.setForeground(new Color(210, 180, 140));
		clockLabel.setBounds(244, 23, 170, 33);
		contentPane.add(clockLabel);
		
		button = new JButton("X");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(new Color(139, 69, 19));
		button.setBounds(652, 0, 52, 26);
		contentPane.add(button);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Admin.class.getResource("/Image/cool-abstract-background-\u2764-4k-hd-desktop-wallpaper-for-4k-ultra.jpg")));
		lblNewLabel_1.setBounds(0, 0, 704, 479);
		contentPane.add(lblNewLabel_1);
		
		setUndecorated(true);
	}
}
