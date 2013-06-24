package br.com.lab.util;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class MascaraUtil {

	public static MaskFormatter setMascara(String mascara){  
	    MaskFormatter mask = null;  
	    try{  
	        mask = new MaskFormatter(mascara);                        
	        }catch(java.text.ParseException ex){}  
	    return mask;  
	} 
	
	public static  JFormattedTextField hideMascara(JFormattedTextField txt){  
	    try{  
	       txt.setFormatterFactory(null);                        
	        }catch(Exception ex){
	        	JOptionPane.showMessageDialog(null, "Erro ao formatar dados!");
	        }  
	    return txt;  
	}
}
