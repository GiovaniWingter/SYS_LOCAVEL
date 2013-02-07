package br.com.lab.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import br.com.lab.exception.DaoException;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args)  throws PropertyVetoException, ClassNotFoundException, SQLException{
								
					SplashScreen teste = new SplashScreen();
					teste.initSplash();
					
			        for (int i = 0; i < 500000; i++){  
			           System.out.println(i);  
			           teste.setProgresso(i);
			        }				
					
			        Principal frame = new Principal();
					frame.setVisible(true);
					teste.fechaSplash();					
					Login login = new Login();
					login.setVisible(true);
	}
	
	/**
	 * Create the frame.
	 */
	public Principal() {
		super("SYSLOCA Renta a car Inc.");
        //for (int i = 0; i < 500; i++){  
        //    System.out.println(i);      
        //}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 1000;
        int height =600;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);
        this.setExtendedState(Principal.MAXIMIZED_BOTH); 
        
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/br/com/images/camaro.jpg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		JMenuItem mntmUsurios = new JMenuItem("Usu\u00E1rios");
		mnCadastros.add(mntmUsurios);

		JMenuItem mntmFuncionrios = new JMenuItem("Funcion\u00E1rios");
		mnCadastros.add(mntmFuncionrios);
		mntmFuncionrios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CadFuncionario cadFunc;
				try {
					cadFunc = new CadFuncionario();
					cadFunc.setVisible(true);
				} catch (DaoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});		
		JMenuItem mntmVeculos = new JMenuItem("Ve\u00EDculos");
		mnCadastros.add(mntmVeculos);
		
		JMenuItem mntmPreos = new JMenuItem("Pre\u00E7os");
		mnCadastros.add(mntmPreos);
		
		JMenu mnReservas = new JMenu("Reservas");
		menuBar.add(mnReservas);
		
		JMenuItem mntmNovaReserva = new JMenuItem("Nova Reserva");
		mnReservas.add(mntmNovaReserva);
		
		JMenuItem mntmCancelarReserva = new JMenuItem("Cancelar Reserva");
		mnReservas.add(mntmCancelarReserva);
		
		JMenuItem mntmConsultarReservas = new JMenuItem("Consultar Reservas");
		mnReservas.add(mntmConsultarReservas);
		
		JMenu mnLocao = new JMenu("Loca\u00E7\u00E3o");
		menuBar.add(mnLocao);
		
		JMenuItem mntmNovaLocaao = new JMenuItem("Nova loca\u00E7ao");
		mnLocao.add(mntmNovaLocaao);
		
		JMenuItem mntmConsultarLocaes = new JMenuItem("Consultar Loca\u00E7\u00F5es");
		mnLocao.add(mntmConsultarLocaes);
		
		JMenuItem mntmFinalizarLocao = new JMenuItem("Finalizar Loca\u00E7\u00E3o");
		mnLocao.add(mntmFinalizarLocao);
		
		JMenu mnSobre = new JMenu("Ajuda");
		menuBar.add(mnSobre);
		
		JMenuItem mntmAjuda = new JMenuItem("Ajuda (F1)");
		mnSobre.add(mntmAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnSobre.add(mntmSobre);
		
	}

}
