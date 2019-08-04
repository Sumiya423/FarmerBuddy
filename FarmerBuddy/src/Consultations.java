import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Consultations extends JFrame {

	private JPanel contentPane;
	private JTextField txtYourNeeds;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultations frame = new Consultations();
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
	public Consultations() {
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
		setBackground(new Color(0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Consultations.class.getResource("/Image/Farmer needs.png")));
		setTitle("FAMER NEEDS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Crops & Soil Informations");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton.setIcon(new ImageIcon(Consultations.class.getResource("/Image/crop-icon.png")));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Crops c= new Crops();
				c.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(218, 165, 32));
		btnNewButton.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		btnNewButton.setBounds(87, 104, 276, 40);
		contentPane.add(btnNewButton);
		
		JButton btnWeatherInformations = new JButton("Weather Informations");
		btnWeatherInformations.setHorizontalAlignment(SwingConstants.LEADING);
		btnWeatherInformations.setIcon(new ImageIcon(Consultations.class.getResource("/Image/Status-weather-showers-day-icon1.png")));
		btnWeatherInformations.setBackground(new Color(0, 0, 0));
		btnWeatherInformations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Weather w= new Weather();
				w.setVisible(true);
				
			}
		});
		btnWeatherInformations.setForeground(new Color(218, 165, 32));
		btnWeatherInformations.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		btnWeatherInformations.setBounds(87, 155, 276, 40);
		contentPane.add(btnWeatherInformations);
		
		JButton btnSell = new JButton("Sell");
		btnSell.setHorizontalAlignment(SwingConstants.LEADING);
		btnSell.setIcon(new ImageIcon(Consultations.class.getResource("/Image/payment-icon.png")));
		btnSell.setBackground(new Color(0, 0, 0));
		btnSell.setForeground(new Color(218, 165, 32));
		btnSell.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		btnSell.setBounds(87, 206, 276, 40);
		contentPane.add(btnSell);
		
		JLabel lblNewLabel = new JLabel("Hi Farmer Buddies !  !");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Script MT Bold", Font.BOLD, 19));
		lblNewLabel.setBounds(107, 33, 222, 29);
		contentPane.add(lblNewLabel);
		
		txtYourNeeds = new JTextField();
		txtYourNeeds.setForeground(new Color(0, 0, 0));
		txtYourNeeds.setBackground(new Color(218, 165, 32));
		txtYourNeeds.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 13));
		txtYourNeeds.setHorizontalAlignment(SwingConstants.CENTER);
		txtYourNeeds.setText("Your NEEDS");
		txtYourNeeds.setBounds(166, 73, 116, 20);
		contentPane.add(txtYourNeeds);
		txtYourNeeds.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("X");
		btnNewButton_1.setBackground(new Color(102, 205, 170));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(406, 0, 48, 29);
		contentPane.add(btnNewButton_1);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Consultations.class.getResource("/Image/grass-field-green-wallpaper-preview.jpg")));
		lblNewLabel_1.setBounds(0, 0, 454, 369);
		contentPane.add(lblNewLabel_1);
		setUndecorated(true);
	}
}
