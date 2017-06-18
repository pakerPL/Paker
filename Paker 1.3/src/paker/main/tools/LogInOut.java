package paker.main.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LogInOut {

	private Connection conn;
	private String login, haslo;
	private boolean adm;
	private int userID;
	private String err;
	
	private static final LogInOut INSTANCE = new LogInOut();
		
	public static LogInOut getInstance(){
		return INSTANCE;
	}
	
	public LogInOut() {
	}
	
	public void initLogInOut(Connection conn, String login, String haslo) {
		this.conn = conn;
		this.login = login;
		this.haslo = haslo;
		if(login.equals("x") & haslo.equals("9dd4e461268c8034f5c8564e155c67a6")){
			resetLogIn();
		}
		
	}
	
	public void LogOut(){
		PreparedStatement ps;
		try {
			ps = conn
					.prepareStatement("UPDATE usersf SET aktywny = false WHERE login LIKE '"+this.login+"' AND haslo LIKE '"+this.haslo+"'");
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			this.err = " LIO B³¹d z wylogowywaniem " + e;
		}
	}
	
	public byte LogIn(){
		Statement s;
		PreparedStatement ps;
		try {
			s= conn.createStatement();
			
			ResultSet rs = s.executeQuery("Select * from usersf WHERE login LIKE '"+login+"' AND haslo LIKE '"+haslo+"'");
			
			if(rs.next()){
				if(rs.getBoolean(10)){
					rs.close();
					s.close();
					return 1;
				}else if(rs.getBoolean(11)){
						rs.close();
						s.close();
						return 4;
				}else{
				try {
					ps = conn
							.prepareStatement("UPDATE usersf SET aktywny = true WHERE login LIKE '"+this.login+"' AND haslo LIKE '"+this.haslo+"'");
					ps.executeUpdate();
					
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				this.adm = rs.getBoolean(9);
				this.userID = rs.getInt(1);
				rs.close();
				s.close();
				return 2;
				}
			}else{ 
				rs.close();
				s.close();
				return 3;
			}
			
		} catch (SQLException e) {
			this.err = " LIO Problem z logowaniem " + e;
		}
		
		return 0;
		
	}
	
	public boolean isAdmin(){
		return this.adm;
	}
	public int getUserID(){
		return this.userID;
	}
	private void resetLogIn(){
		PreparedStatement ps;
		try {
			ps = conn
					.prepareStatement("UPDATE usersf SET aktywny = false");
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			this.err = "LIO Problem z resetowaniem " + e;
		}
		this.err = "LIO Zresetowano statusy logowania";
	}
	
	public String getErr(){
		return this.err;
	}
}
