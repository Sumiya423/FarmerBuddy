import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Crops extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crops frame = new Crops();
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
	public Crops() {
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
		setTitle("Crops & Soil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setForeground(new Color(0, 0, 128));
		tabbedPane_1.setBounds(55, 78, 426, 274);
		contentPane.add(tabbedPane_1);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setForeground(new Color(0, 139, 139));
		tabbedPane_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		tabbedPane_1.addTab("SOIL", null, tabbedPane_2, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_2.addTab("Loam Soil", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Crops.class.getResource("/Image/Screenshot (96).png")));
		lblNewLabel_2.setBounds(192, 24, 200, 169);
		panel_5.add(lblNewLabel_2);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(Crops.class.getResource("/Image/loam.jpg")));
		label_9.setBounds(26, 46, 155, 121);
		panel_5.add(label_9);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Crops.class.getResource("/Image/line_horizontal_light_color-680270.jpg!d.jpg")));
		label_3.setBounds(0, 0, 416, 217);
		panel_5.add(label_3);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_2.addTab("Clay Soil", null, panel_6, null);
		panel_6.setLayout(null);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Crops.class.getResource("/Image/Screenshot (94).png")));
		label_5.setBounds(189, 23, 200, 169);
		panel_6.add(label_5);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Crops.class.getResource("/Image/clay.jpg")));
		label_8.setBounds(24, 47, 155, 121);
		panel_6.add(label_8);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Crops.class.getResource("/Image/line_horizontal_light_color-680270.jpg!d.jpg")));
		label_4.setBounds(0, 0, 416, 217);
		panel_6.add(label_4);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_2.addTab("Sandy Soil", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Crops.class.getResource("/Image/Screenshot (95).png")));
		label_7.setBounds(194, 21, 200, 169);
		panel_4.add(label_7);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Crops.class.getResource("/Image/sandy.jpg")));
		lblNewLabel_3.setBounds(22, 47, 155, 121);
		panel_4.add(lblNewLabel_3);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(0, 0, 416, 217);
		panel_4.add(label_6);
		label_6.setIcon(new ImageIcon(Crops.class.getResource("/Image/line_horizontal_light_color-680270.jpg!d.jpg")));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(46, 139, 87));
		tabbedPane.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		tabbedPane_1.addTab("CROPS", null, tabbedPane, null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Paddy", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Crops.class.getResource("/Image/paddy2.jpg")));
		lblNewLabel_4.setBounds(24, 40, 166, 144);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Crops.class.getResource("/Image/bk.png")));
		lblNewLabel_1.setBounds(0, 0, 416, 217);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Wheat", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(Crops.class.getResource("/Image/wheat.jpg")));
		label_10.setBounds(26, 38, 171, 138);
		panel_1.add(label_10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Crops.class.getResource("/Image/bk.png")));
		label.setBounds(0, 0, 416, 217);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Pea", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(Crops.class.getResource("/Image/dal.jpg")));
		label_11.setBounds(27, 37, 166, 138);
		panel_2.add(label_11);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Crops.class.getResource("/Image/bk.png")));
		label_1.setBounds(0, 0, 416, 217);
		panel_2.add(label_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Vegetables", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(Crops.class.getResource("/Image/vegetable.jpg")));
		label_12.setBounds(27, 45, 166, 132);
		panel_3.add(label_12);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Crops.class.getResource("/Image/bk.png")));
		label_2.setBounds(0, 0, 416, 217);
		panel_3.add(label_2);
		
		JLabel lblCropsSoil = new JLabel("Crops & Soil Informations");
		lblCropsSoil.setFont(new Font("Castellar", Font.BOLD, 17));
		lblCropsSoil.setForeground(new Color(255, 255, 255));
		lblCropsSoil.setHorizontalAlignment(SwingConstants.CENTER);
		lblCropsSoil.setBounds(106, 29, 334, 38);
		contentPane.add(lblCropsSoil);
		
		JButton btnNewButton = new JButton("< Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultations con = new Consultations();
				con.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setBounds(436, 402, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Crops.class.getResource("/Image/makro-pshenica-rozh-pole-macro-4579.jpg")));
		lblNewLabel.setBounds(0, 0, 535, 436);
		contentPane.add(lblNewLabel);
		setUndecorated(true);
	}
}
