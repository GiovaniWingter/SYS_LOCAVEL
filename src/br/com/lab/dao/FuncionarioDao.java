package br.com.lab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.lab.exception.DaoException;
import br.com.lab.util.DbUtil;
import br.com.lab.bean.Funcionario;

public class FuncionarioDao {

	private static final String VALIDAR_LOGIN_SENHA = 
		"select "+
			"count(idFuncionario) as total " +
		"from "+
			"funcionario f "+
		"where "+
			"f.login_funcionario = ? and " +
			"f.senha_funcionario = ?";
	
	private String CONSULTA_FUNCIONARIOS = "select * from funcionario order by nome_funcionario";
	
	public boolean getAutenticacao(String nome, String senha) throws DaoException {
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		int numReg = 0;
		boolean autenticado = false;
		try {
			
			statement = conn.prepareStatement(VALIDAR_LOGIN_SENHA);
			statement.setString(1, nome);
			statement.setString(2, senha);
			result = statement.executeQuery();
			if (result.next()) {
				numReg = result.getInt("total");
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		if(numReg != 0){
			return autenticado = true;
		}else{
			return autenticado;			
		}
	}		

	
	public List<Funcionario> consultarFuncionarios() throws DaoException{		
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Funcionario> listaFunc = new ArrayList<Funcionario>();
		try {
			statement = conn.prepareStatement(CONSULTA_FUNCIONARIOS);
			result = statement.executeQuery();
			while (result.next()) {
				Funcionario objFunc = new Funcionario();
				objFunc.setId(result.getInt(1));
				objFunc.setNome(result.getString(2));
				objFunc.setSexo(result.getString(3));
				objFunc.setCpf(result.getString(4));
				objFunc.setRg(result.getString(5));
				objFunc.setEmail(result.getString(6));
				objFunc.setLogin(result.getString(7));
				objFunc.setSenha(result.getString(8));
				listaFunc.add(objFunc);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return listaFunc;		
	}
}