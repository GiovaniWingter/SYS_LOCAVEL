package br.com.lab.telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.border.LineBorder;

public class SplashScreen extends JWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JProgressBar progressBar = new JProgressBar();
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public SplashScreen() {
        int width = 355;
        int height =235;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 225));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		progressBar.setBounds(0, 210, 349, 19);
		
		
		panel.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 349, 210);
		lblNewLabel.setIcon(new ImageIcon(SplashScreen.class.getResource("/br/com/images/splash.png")));
		panel.add(lblNewLabel);
		setContentPane(contentPane);
		progressBar.setBorderPainted(false);
		progressBar.setString("");
		progressBar.setMinimum(0);
		progressBar.setMaximum(500000);
		progressBar.setIndeterminate(false);
		progressBar.setBackground(Color.white);
		progressBar.setForeground(Color.darkGray);
		progressBar.setStringPainted(true);
		progressBar.setFont(new java.awt.Font("Helvetica", 1, 12));
		
		
	}

	public void initSplash(){
		this.setVisible(true);
	}
	
	public void setProgresso(int i) {
		progressBar.setValue(i);
		progressBar.setString("Carregando...  "+i/5000+"%");		
	}
	
	public void  fechaSplash() {
		this.dispose();
	}
}