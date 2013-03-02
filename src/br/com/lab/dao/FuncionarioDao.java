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

	private static final String EXCLUIR_FUNCIONARIO = 
			"delete from funcionario where idfuncionario = ?";
	
	private static final String INSERIR_FUNCIONARIO =
			"insert into funcionario(nome_funcionario, sexo,cpf_funcionario, "+
			"rg_funcionario, email_funcionario, login_funcionario, senha_funcionario) " +
			"values (?,?,?,?,?,?,?)";
	
	private static final String ATUALIZAR_FUNCIONARIO =
			"update funcionario set " +
			"nome_funcionario = ?, " +
			"sexo = ?, " +
			"cpf_funcionario = ?, " +
			"rg_funcionario = ?, " +
			"email_funcionario = ?, " +
			"login_funcionario = ?, " +
			"senha_funcionario = ? " +
			"where idfuncionario = ? ";
	
	private static final String VALIDAR_LOGIN_SENHA = 
		"select "+
			"count(idFuncionario) as total " +
		"from "+
			"funcionario f "+
		"where "+
			"f.login_funcionario = ? and " +
			"f.senha_funcionario = ?";
	
	private static final  String CONSULTA_FUNCIONARIOS =
			"select * from funcionario order by nome_funcionario";
	
	private static final  String CONSULTA_FUNCIONARIO_ID = 
			"select * from funcionario where idfuncionario = ?";
	
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

	public Funcionario consultarFuncionarioID(int idFunc) throws DaoException{		
		Funcionario objFunc = new Funcionario();
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(CONSULTA_FUNCIONARIO_ID);
			statement.setInt(1, idFunc);
			result = statement.executeQuery();
			while (result.next()) {
				objFunc.setId(result.getInt(1));
				objFunc.setNome(result.getString(2));
				objFunc.setSexo(result.getString(3));
				objFunc.setCpf(result.getString(4));
				objFunc.setRg(result.getString(5));
				objFunc.setEmail(result.getString(6));
				objFunc.setLogin(result.getString(7));
				objFunc.setSenha(result.getString(8));
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return objFunc;		
	}

	public boolean inserirFuncionarios(Funcionario obj) throws DaoException{		
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(INSERIR_FUNCIONARIO);
			statement.setString(1, obj.getNome());
			statement.setString(2, obj.getSexo());
			statement.setString(3, obj.getCpf());
			statement.setString(4, obj.getRg());
			statement.setString(5, obj.getEmail());
			statement.setString(6, obj.getLogin());
			statement.setString(7, obj.getSenha());
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return true;		
	}
	
	public boolean atualizarFuncionario(Funcionario objFunc) throws DaoException{		
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(ATUALIZAR_FUNCIONARIO);
			statement.setString(1, objFunc.getNome());
			statement.setString(2, objFunc.getSexo());
			statement.setString(3, objFunc.getCpf());
			statement.setString(4, objFunc.getRg());
			statement.setString(5, objFunc.getEmail());
			statement.setString(6, objFunc.getLogin());
			statement.setString(7, objFunc.getSenha());			
			statement.setInt(8,objFunc.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return true;		
	}

	public boolean excluirFuncionarios(int idFuncioanrio) throws DaoException{		
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(EXCLUIR_FUNCIONARIO);
			statement.setInt(1, idFuncioanrio);
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return true;		
	}
}