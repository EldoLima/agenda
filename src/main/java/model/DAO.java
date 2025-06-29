package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
	// módulo de conexão

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "9840";

	private Connection conectar() {
		Connection conn = null;
		try {
			getClass().forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return conn;
	}

	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome, fone, email) values (?,?,?)";
		try {
			Connection conn = conectar();
			PreparedStatement pstm = conn.prepareStatement(create);
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getFone());
			pstm.setString(3, contato.getEmail());
			pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*
	 * public void testeConexao() { try { Connection conn = conectar();
	 * System.out.println(conn); conn.close(); } catch (Exception e) {
	 * System.out.println(e); System.out.println("Não conectou"); } }
	 */

}
