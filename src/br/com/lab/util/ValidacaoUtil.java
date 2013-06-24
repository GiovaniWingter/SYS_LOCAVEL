package br.com.lab.util;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ValidacaoUtil {
	
	public static boolean textFieldVazio(JTextField componente){
		if(componente.getText().equals("")){
			return false;			
		}else{			
			return true;
		}
	}
	
	public static boolean textFieldsIguais(JTextField componente1,JTextField componente2){
		if(componente1.getText().equals(componente2.getText())){
			return false;			
		}else{
			return true;
		}
	}
	
	public static boolean passwordsIguais(JPasswordField componente1,JPasswordField componente2){
		String campo1 = new String(componente1.getPassword()); 
		String campo2 = new String(componente2.getPassword());		
		if(campo1.equals(campo2)){
			return true;			
		}else{
			return false;
		}
	}
	
}
