

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Splash extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash frame = new Splash();
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
	public Splash() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Splash.class.getResource("/Image/Farmer-icon.png")));
		design();
		tm.restart();
		welcomeMusic();
		centerize();
	}
	
	
	
	
	
	Timer tm = new Timer(90, this);
	int time =0;
	private JProgressBar progressBar;
	private JTextField txtFarmingBuddy;
	
	public void actionPerformed(ActionEvent e) {
		if(time != 100) {
			time++;
			progressBar.setValue(time);
		
		}else {
			tm.stop();
			//JOptionPane.showMessageDialog(null, "Done");
			MainFrame mf = new MainFrame();
			mf.setVisible(true);
			dispose();
			
		}
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
	
	private void welcomeMusic() {
		try {
			Clip c = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(Splash.class.getResource("/Files/start.wav"));
			c.open(inputStream);
			c.start();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void design(){
		setTitle("Farmer Buddy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.BLACK);
		label.setBackground(Color.BLACK);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Splash.class.getResource("/Files/giphy.gif")));
		label.setBounds(81, 147, 486, 271);
		contentPane.add(label);
		
		progressBar = new JProgressBar();
		progressBar.setBackground(SystemColor.controlHighlight);
		progressBar.setForeground(new Color(0, 255, 255));
		progressBar.setBounds(0, 547, 648, 9);
		contentPane.add(progressBar);
		
		txtFarmingBuddy = new JTextField();
		txtFarmingBuddy.setForeground(new Color(0, 255, 255));
		txtFarmingBuddy.setHorizontalAlignment(SwingConstants.CENTER);
		txtFarmingBuddy.setBackground(new Color(0, 128, 128));
		txtFarmingBuddy.setEditable(false);
		txtFarmingBuddy.setText("Farmer Buddy");
		txtFarmingBuddy.setFont(new Font("Kristen ITC", Font.BOLD, 37));
		txtFarmingBuddy.setBounds(81, 22, 486, 97);
		contentPane.add(txtFarmingBuddy);
		txtFarmingBuddy.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Splash.class.getResource("/Image/Leaves-Green-Plant-Wallpaper-1024x1024.jpg")));
		label_1.setBounds(0, 0, 648, 567);
		contentPane.add(label_1);
   	    setUndecorated(true);
	}
}