

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
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
	
	private void design(){
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_Form login = new Login_Form();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setIcon(new ImageIcon(MainFrame.class.getResource("/Files/icons8-workspace-50.png")));
		btnNewButton.setToolTipText("");
		btnNewButton.setBackground(new Color(218, 165, 32));
		btnNewButton.setBounds(331, 99, 158, 59);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(218, 165, 32));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setIcon(new ImageIcon(MainFrame.class.getResource("/Files/icons8-add-user-male-50.png")));
		btnNewButton_1.setBounds(331, 215, 158, 59);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(153, 0, 51));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/Files/67790384_917847821901529_2930508241064427520_n.png")));
		lblNewLabel.setBounds(20, 26, 189, 208);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(47, 79, 79));
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(0, 283, 231, 123);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("All Your Needs Are Here !");
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(240, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 21, 211, 45);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("....Get Started....");
		lblNewLabel_3.setForeground(new Color(218, 165, 32));
		lblNewLabel_3.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(20, 54, 178, 41);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MainFrame.class.getResource("/Image/line_horizontal_light_color-680270.jpg!d.jpg")));
		lblNewLabel_1.setBackground(new Color(153, 0, 51));
		lblNewLabel_1.setBounds(0, 0, 231, 284);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setForeground(new Color(192, 192, 192));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin a = new AdminLogin();
				a.setVisible(true);
				
			}
		});
		btnAdmin.setBackground(new Color(0, 128, 128));
		btnAdmin.setBounds(506, 372, 76, 23);
		contentPane.add(btnAdmin);
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnX.setForeground(new Color(240, 255, 255));
		btnX.setBackground(new Color(0, 0, 0));
		btnX.setBounds(546, 0, 46, 23);
		contentPane.add(btnX);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainFrame.class.getResource("/Image/12963N535ZT0-11O8.jpg")));
		label.setBounds(232, 0, 360, 406);
		contentPane.add(label);
	 	setUndecorated(true);
		
	}
}
