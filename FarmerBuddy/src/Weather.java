import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Weather extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Weather frame = new Weather();
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
	public Weather() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Weather.class.getResource("/Image/Status-weather-showers-day-icon1.png")));
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
		setTitle("WEATHER UPDATE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Click Here to Know The Weather Update :)");
		btnNewButton.setBackground(new Color(220, 20, 60));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() > 0) {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						try {
							URI uri = new URI("https://www.accuweather.com/en/bd/dhaka/28143/weather-forecast/28143");
							desktop.browse(uri);
						} catch (IOException ex) {
							ex.printStackTrace();
						} catch (URISyntaxException ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		});

		btnNewButton.setForeground(new Color(224, 255, 255));
		btnNewButton.setFont(new Font("Colonna MT", Font.BOLD, 15));
		btnNewButton.setBounds(0, 275, 450, 25);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("< Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultations con = new Consultations();
				con.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(100, 149, 237));
		btnBack.setBounds(369, 234, 81, 17);
		contentPane.add(btnBack);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Weather.class.getResource("/Image/Status-weather-showers-day-icon.png")));
		lblNewLabel.setBounds(80, 0, 334, 237);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Weather.class.getResource("/Image/bk.png")));
		label.setForeground(new Color(0, 206, 209));
		label.setBackground(new Color(0, 206, 209));
		label.setBounds(0, 0, 450, 278);
		contentPane.add(label);
		setUndecorated(true);
	}

}
