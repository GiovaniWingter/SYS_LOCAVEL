package br.com.lab.telas;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Button;
import javax.swing.ListSelectionModel;

import br.com.lab.bean.Funcionario;
import br.com.lab.dao.FuncionarioDao;
import br.com.lab.exception.DaoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class CadFuncionario extends JDialog {
	private FuncionarioDao funcDao = new FuncionarioDao();
	private static final long serialVersionUID = 1L;	
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_3;
	private JPasswordField passwordField_4;
	private JPasswordField passwordField_5;
	private JPasswordField passwordField_6;
	private JTable table;

	public CadFuncionario() throws DaoException {
		setTitle("Cadastro de Funcion\u00E1rios");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadFuncionario.class.getResource("/br/com/images/cadForm.jpg")));
		int width = 800;
        int height =600;
        setModal(true);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/3;
        setBounds(x,y,width,height);
        getContentPane().setLayout(null);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBounds(0, 0, 152, 562);
        getContentPane().add(buttonPanel);
        buttonPanel.setLayout(null);
        
        JPanel moldura = new JPanel();
        moldura.setBackground(Color.BLACK);
        moldura.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        moldura.setBounds(6, 9, 140, 143);
        buttonPanel.add(moldura);
        moldura.setLayout(null);
        
        JLabel label = new JLabel("");
        label.setBounds(6, 8, 128, 128);
        moldura.add(label);
        label.setIcon(new ImageIcon(CadFuncionario.class.getResource("/br/com/images/cadIcon.jpg")));
        
        final JPanel lista = new JPanel();
        lista.setBounds(152, 0, 632, 562);
        getContentPane().add(lista);
        lista.setLayout(null);
        
        JLabel lblFuncionriosCadastrados = new JLabel("Funcion\u00E1rios Cadastrados");
        lblFuncionriosCadastrados.setFont(new Font("Kalinga", Font.BOLD, 16));
        lblFuncionriosCadastrados.setHorizontalAlignment(SwingConstants.CENTER);
        lblFuncionriosCadastrados.setBackground(Color.WHITE);
        lblFuncionriosCadastrados.setBounds(10, 11, 612, 29);
        lista.add(lblFuncionriosCadastrados);
        


          
          Button Novo = new Button("Adicionar");
          
                  Novo.setBounds(27, 431, 70, 22);
                  lista.add(Novo);
                  
                  table = new JTable();
                  lista.add(table);
                  table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                  table.setModel(new DefaultTableModel(
                  	new Object[][] {
                  	},
                  	new String[] {
                  		"Matr\u00EDcula", "nome", "e-mail", "A\u00E7\u00E3o"
                  	}
                  	
                  )
                  { 
                	  /**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override 
                	  public boolean isCellEditable(int row, int col) 
                	  { 
                	  return false; 
                	  } 
                	  }
                  );
                  table.getColumnModel().getColumn(0).setPreferredWidth(55);
                  table.getColumnModel().getColumn(0).setMinWidth(55);
                  table.getColumnModel().getColumn(1).setPreferredWidth(250);
                  table.getColumnModel().getColumn(1).setMinWidth(250);
                  table.getColumnModel().getColumn(2).setPreferredWidth(150);
                  table.getColumnModel().getColumn(2).setMinWidth(150);
                  table.setBounds(25, 40, 600, 383);
                  
                  
                  lista.setVisible(true);
                  atualizaLista(table);
                  

        
        final JPanel formulario = new JPanel();
        formulario.setBounds(152, 0, 632, 562);
        getContentPane().add(formulario);
        formulario.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, null), "Dados pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setLayout(null);
        panel.setBounds(21, 35, 590, 288);
        formulario.add(panel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(333, 205, 94, 20);
        panel.add(passwordField);
        
        JLabel label_1 = new JLabel("Confimr a senha:");
        label_1.setHorizontalAlignment(SwingConstants.RIGHT);
        label_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
        label_1.setBounds(196, 205, 127, 18);
        panel.add(label_1);
        
        passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(92, 205, 94, 20);
        panel.add(passwordField_1);
        
        JLabel label_2 = new JLabel("Senha:");
        label_2.setHorizontalAlignment(SwingConstants.RIGHT);
        label_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
        label_2.setBounds(12, 205, 70, 18);
        panel.add(label_2);
        
        JLabel label_3 = new JLabel("Login:");
        label_3.setHorizontalAlignment(SwingConstants.RIGHT);
        label_3.setFont(new Font("Arial Black", Font.PLAIN, 12));
        label_3.setBounds(12, 176, 70, 18);
        panel.add(label_3);
        
        passwordField_2 = new JPasswordField();
        passwordField_2.setBounds(92, 176, 191, 20);
        panel.add(passwordField_2);
        
        JLabel label_4 = new JLabel("Sexo:");
        label_4.setHorizontalAlignment(SwingConstants.RIGHT);
        label_4.setFont(new Font("Arial Black", Font.PLAIN, 12));
        label_4.setBounds(12, 147, 70, 18);
        panel.add(label_4);
        
        JRadioButton radioButton = new JRadioButton("Masculino");
        radioButton.setSelected(true);
        radioButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
        radioButton.setBounds(93, 145, 109, 23);
        panel.add(radioButton);
        
        JRadioButton radioButton_1 = new JRadioButton("Feminino");
        radioButton_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
        radioButton_1.setBounds(198, 145, 109, 23);
        panel.add(radioButton_1);
        
        JLabel label_5 = new JLabel("CPF:");
        label_5.setHorizontalAlignment(SwingConstants.RIGHT);
        label_5.setFont(new Font("Arial Black", Font.PLAIN, 12));
        label_5.setBounds(12, 118, 70, 18);
        panel.add(label_5);
        
        passwordField_3 = new JPasswordField();
        passwordField_3.setBounds(92, 118, 132, 20);
        panel.add(passwordField_3);
        
        passwordField_4 = new JPasswordField();
        passwordField_4.setBounds(92, 89, 132, 20);
        panel.add(passwordField_4);
        
        JLabel label_6 = new JLabel("RG:");
        label_6.setHorizontalAlignment(SwingConstants.RIGHT);
        label_6.setFont(new Font("Arial Black", Font.PLAIN, 12));
        label_6.setBounds(12, 89, 70, 18);
        panel.add(label_6);
        
        JLabel label_7 = new JLabel("E-mail:");
        label_7.setHorizontalAlignment(SwingConstants.RIGHT);
        label_7.setFont(new Font("Arial Black", Font.PLAIN, 12));
        label_7.setBounds(12, 60, 70, 18);
        panel.add(label_7);
        
        passwordField_5 = new JPasswordField();
        passwordField_5.setBounds(92, 60, 227, 20);
        panel.add(passwordField_5);
        
        passwordField_6 = new JPasswordField();
        passwordField_6.setBounds(92, 31, 340, 20);
        panel.add(passwordField_6);
        
        JLabel label_8 = new JLabel("Nome:");
        label_8.setHorizontalAlignment(SwingConstants.RIGHT);
        label_8.setFont(new Font("Arial Black", Font.PLAIN, 12));
        label_8.setBounds(12, 31, 70, 18);
        panel.add(label_8);
        
        JButton button = new JButton("Salvar");
        button.setBounds(491, 254, 89, 23);
        panel.add(button);
        
        JButton button_1 = new JButton("Limpar");
        button_1.setBounds(392, 254, 89, 23);
        panel.add(button_1);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(21, 340, 89, 23);
        formulario.add(btnVoltar);
        formulario.setVisible(false);

        Novo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		lista.setVisible(false);
        		formulario.setVisible(true);
        		try {
                  			atualizaLista(table);
                  		} catch (DaoException e) {
                  			// TODO Auto-generated catch block
                  			e.printStackTrace();
                  		}
        	}
        });	
        
        btnVoltar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		lista.setVisible(true);
        		formulario.setVisible(false);        	
        	}
        });
	}
	
	public void atualizaLista(JTable lista) throws DaoException{
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0); 
		List<Funcionario> listaFunc  = new ArrayList<Funcionario>();
 		listaFunc = funcDao.consultarFuncionarios();
 		String dados[] = new String[4]; 
		for (Funcionario obj : listaFunc) {
			dados[0] = String.valueOf(obj.getId()) ;
			dados[1] = obj.getNome();
			dados[2] = obj.getCpf();
			dados[3] = obj.getRg();
			((DefaultTableModel) table.getModel()).addRow(dados); 
		} 
		table.repaint();
	}
}
