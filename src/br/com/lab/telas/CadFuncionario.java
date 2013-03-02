package br.com.lab.telas;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.Button;
import javax.swing.ListSelectionModel;

import br.com.lab.bean.Funcionario;
import br.com.lab.dao.FuncionarioDao;
import br.com.lab.exception.DaoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class CadFuncionario extends JDialog {
    final JPanel lista = new JPanel();
    final JPanel formulario = new JPanel();
    final JRadioButton radioButton = new JRadioButton("Masculino");
    JRadioButton radioButton_1 = new JRadioButton("Feminino");
	private FuncionarioDao funcDao = new FuncionarioDao();
	private static final long serialVersionUID = 1L;	
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
          Novo.setBounds(10, 530, 70, 22);
          lista.add(Novo);                                    
          lista.setVisible(true);       
          table = new JTable();
          table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = table.getSelectedRow();
				int coluna = table.getSelectedColumn();
				String matricula = (String) table.getValueAt(linha,0);
				Integer mat = Integer.parseInt(matricula); 
				if(coluna == 4){
					int opcao;
					opcao = JOptionPane.showConfirmDialog(null,"Deseja excluir o registro de matricula: "+matricula ,"Cuidado!!",JOptionPane.YES_NO_OPTION);				
					   if(opcao == JOptionPane.YES_OPTION){  
						   try {
							funcDao.excluirFuncionarios(mat);
							atualizaLista(table);
						} catch (DaoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
					   }
				}
				if (coluna == 3){
					Funcionario objFunc = new Funcionario();

					try {
						objFunc = funcDao.consultarFuncionarioID(mat);
						atualizaFormulario(objFunc);
					} catch (DaoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				
			}
		});
          
          
          
          table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          table.setModel(new DefaultTableModel(
        		  new Object[][] {
                  	},
                  	new String[] {
                  		"Matr\u00EDcula", "nome", "e-mail", "Editar","Excluir"
                  	}
                  	
                  )
                  { 
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
                  table.setBounds(39, 175, 530, 232);
                  atualizaLista(table);
                  
                  
                  JScrollPane scrollPane = new JScrollPane();
                  scrollPane.setBounds(20, 51, 602, 473);
                  lista.add(scrollPane);
   
                  scrollPane.setViewportView(table);
                  

                  

                  

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
                  
                  JLabel lblConfirmarASenha = new JLabel("Confirmar a senha:");
                  lblConfirmarASenha.setHorizontalAlignment(SwingConstants.RIGHT);
                  lblConfirmarASenha.setFont(new Font("Arial Black", Font.PLAIN, 12));
                  lblConfirmarASenha.setBounds(196, 205, 127, 18);
                  panel.add(lblConfirmarASenha);
                  
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
                  
                  JLabel label_4 = new JLabel("Sexo:");
                  label_4.setHorizontalAlignment(SwingConstants.RIGHT);
                  label_4.setFont(new Font("Arial Black", Font.PLAIN, 12));
                  label_4.setBounds(12, 147, 70, 18);
                  panel.add(label_4);
                  

                  radioButton.setSelected(true);
                  radioButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
                  radioButton.setBounds(93, 145, 109, 23);
                  panel.add(radioButton);
                  

                  radioButton_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
                  radioButton_1.setBounds(198, 145, 109, 23);
                  panel.add(radioButton_1);
                  
                  ButtonGroup grupo = new ButtonGroup();  
                  grupo.add(radioButton);  
                  grupo.add(radioButton_1); 
                  
                  JLabel label_5 = new JLabel("CPF:");
                  label_5.setHorizontalAlignment(SwingConstants.RIGHT);
                  label_5.setFont(new Font("Arial Black", Font.PLAIN, 12));
                  label_5.setBounds(12, 118, 70, 18);
                  panel.add(label_5);
                  
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
                  
                  JLabel label_8 = new JLabel("Nome:");
                  label_8.setHorizontalAlignment(SwingConstants.RIGHT);
                  label_8.setFont(new Font("Arial Black", Font.PLAIN, 12));
                  label_8.setBounds(12, 31, 70, 18);
                  panel.add(label_8);
                  
                  JButton button = new JButton("Salvar");
                  button.setBounds(491, 254, 89, 23);
                  panel.add(button);
                  
                  button.addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent arg0) {
					  String sexo = "";
					  String senha = new String(passwordField.getPassword()); 
					  String cSenha = new String(passwordField_1.getPassword());
					  if(radioButton.isSelected()){
						  sexo = "M";
					  }else{
						  sexo = "F";						  
					  }
						if(senha.equals(cSenha)){
							Funcionario obj = new Funcionario();
							
							obj.setCpf(textField_2.getText());
							obj.setEmail(textField_1.getText());
							obj.setLogin(textField_4.getText());
							obj.setNome(textField.getText());
							obj.setRg(textField_3.getText());
							obj.setSenha(cSenha);
							obj.setSexo(sexo);
							FuncionarioDao objDAO = new FuncionarioDao();
							try {
								
								if(textField_5.getText().equals("")){
									objDAO.inserirFuncionarios(obj);
									JOptionPane.showMessageDialog(formulario, "Dados salvos com sucesso!");									
								}else{
									Integer matr = Integer.parseInt(textField_5.getText()); 
									obj.setId(matr);
									objDAO.atualizarFuncionario(obj);
									JOptionPane.showMessageDialog(formulario, "Dados atualizados com sucesso!");
								}								
								atualizaLista(table);
							} catch (DaoException e) {
								e.printStackTrace();
							}

						}else{
							JOptionPane.showMessageDialog(formulario, "Os campos senha e confirme a senha devem ter o mesmo conteúdo!");
						}
					  
					}
				});
                  
                  JButton button_1 = new JButton("Limpar");
                  button_1.setBounds(392, 254, 89, 23);
                  panel.add(button_1);
                  button_1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						limpaFormulario();
						
					}
				});
                  
                  textField = new JTextField();
                  textField.setBounds(92, 31, 335, 20);
                  panel.add(textField);
                  textField.setColumns(10);
                  
                  textField_1 = new JTextField();
                  textField_1.setBounds(92, 60, 335, 20);
                  panel.add(textField_1);
                  textField_1.setColumns(10);
                  
                  textField_2 = new JTextField();
                  textField_2.setBounds(92, 89, 127, 20);
                  panel.add(textField_2);
                  textField_2.setColumns(10);
                  
                  textField_3 = new JTextField();
                  textField_3.setBounds(92, 118, 127, 20);
                  panel.add(textField_3);
                  textField_3.setColumns(10);
                  
                  textField_4 = new JTextField();
                  textField_4.setBounds(92, 174, 190, 20);
                  panel.add(textField_4);
                  textField_4.setColumns(10);
                  
                  textField_5 = new JTextField();
                  textField_5.setVisible(false);
                  textField_5.setText("");
                  panel.add(textField_5);
                  
                  JButton btnVoltar = new JButton("Voltar");
                  btnVoltar.setBounds(21, 340, 89, 23);
                  formulario.add(btnVoltar);
                  formulario.setVisible(false);
                  
                  btnVoltar.addActionListener(new ActionListener() {
                  	public void actionPerformed(ActionEvent arg0) {
                  		lista.setVisible(true);
                  		formulario.setVisible(false);        	
                  	}
                  });

        Novo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		lista.setVisible(false);
        		formulario.setVisible(true);
        		limpaFormulario();
        		try {
                  			atualizaLista(table);
                  		} catch (DaoException e) {
                  			// TODO Auto-generated catch block
                  			e.printStackTrace();
                  		}
        	}
        });	
	}
	
	public void atualizaLista(JTable lista) throws DaoException{
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();

        ImageIcon editar = new ImageIcon(CadFuncionario.class.getResource("/br/com/images/editar.gif"));  
        ImageIcon excluir = new ImageIcon(CadFuncionario.class.getResource("/br/com/images/icon_excluir.png"));

		TableColumnModel columnModel = table.getColumnModel();
		
		JTableRenderer renderer = new JTableRenderer();
		JTableRenderer renderer1 = new JTableRenderer();		
		
		renderer.setValue(editar);
		renderer.setHorizontalAlignment(JLabel.CENTER);
		columnModel.getColumn(3).setCellRenderer(renderer);
		
		renderer1.setValue(excluir);
		renderer1.setHorizontalAlignment(JLabel.CENTER);
		columnModel.getColumn(4).setCellRenderer(renderer1);

        dtm.setRowCount(0); 
		List<Funcionario> listaFunc  = new ArrayList<Funcionario>();
 		listaFunc = funcDao.consultarFuncionarios();
 		String dados[] = new String[3]; 
		for (Funcionario obj : listaFunc) {
			dados[0] = String.valueOf(obj.getId()) ;
			dados[1] = obj.getNome();
			dados[2] = obj.getEmail();
			((DefaultTableModel) table.getModel()).addRow(dados); 
		} 
		table.repaint();
	}

	public class JTableRenderer extends DefaultTableCellRenderer {
		private static final long serialVersionUID = 1L;

		protected void setValue(Object value) {
			if (value instanceof ImageIcon) {
				if (value != null) {
					ImageIcon d = (ImageIcon) value;
					setIcon(d);
				}
			} else {
				super.setValue(value);
			}
		}
	}	

	public void atualizaFormulario(Funcionario objFunc){
		textField_2.setText(objFunc.getCpf());
		textField_1.setText(objFunc.getEmail());
		textField_4.setText(objFunc.getLogin());
		textField.setText(objFunc.getNome());
		textField_3.setText(objFunc.getRg());
		passwordField.setText("");
		passwordField_1.setText("");
		Integer matr = objFunc.getId();
		textField_5.setText(matr.toString());
		if(objFunc.getSexo().equals("F")){
			radioButton_1.setSelected(true);
		}else{
			radioButton.setSelected(true);
		}
		lista.setVisible(false);
		formulario.setVisible(true);
	}
	
	public void limpaFormulario(){
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		passwordField.setText("");
		passwordField_1.setText("");
		radioButton.setSelected(true);
	}
}

