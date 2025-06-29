package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	//módulo de conexão
	
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
	
	/*
	 * public void testeConexao() { try { Connection conn = conectar();
	 * System.out.println(conn); conn.close(); } catch (Exception e) {
	 * System.out.println(e); System.out.println("Não conectou"); } }
	 */

}
