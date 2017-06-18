package paker.main.tools;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PassInBaseDB {

	private String[] data = new String[20];
	
	private int r,g,b,grupa, typ;
	
	private String err, err2;
	
	private boolean hang;
	private String hangDate;
	
	public PassInBaseDB(Connection conn, String id) {
		Statement s;
		
		try {
			s = conn.createStatement();
			ResultSet rs = s
					.executeQuery("SELECT * FROM pass_in_base where idkarnet='" + id
							+ "' AND klid IS NOT NULL");
		
			while (rs.next()) {
				for (int i = 0; i < data.length-2; i++) {
					data[i] = rs.getString(i + 1);
				}
				r=rs.getInt(19);
				g=rs.getInt(20);
				b=rs.getInt(21);
				data[18] = fitnes(rs.getString(22));
				data[19] = fitnes(rs.getString(23));
				grupa = rs.getInt(24);
				typ = rs.getInt(25);
				hang = rs.getBoolean(26);
				hangDate = rs.getString(27);
				
			}
			rs.close();
		} catch (SQLException e) {
			this.err = "Nie uda³o siê pobraæ karnetu";
			this.err2 = " IPDB Nie uda³o siê pobraæ karnetu " + e;
		}
		sprawdzacz(conn, id);
}
	
	private void sprawdzacz(Connection conn, String id){
		Statement s;
		try {
			s = conn.createStatement();
			ResultSet rs = s.executeQuery("select data_waznosci - current_date, aktywnosc from karnet where idkarnet = '"+id+"'");
			if(rs.next()){
				if(rs.getBoolean(2)){
				if(rs.getInt(1) <= 3){					
				}
			}
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private String fitnes(String data){
		if(data.equals("-1")){
			return "N/A";
			
		}else return data;
	}
	
	public int getRed(){
		return this.r;
	}
	
	public int getGreen(){
		return this.g;
	}
	
	public int getBlue(){
		return this.b;
	}
	
	public int getIdGrupa(){
		return this.grupa;
	}
	
	public int getIdType(){
		return this.typ;
	}
	
	public String getMss() {
		return this.err;
	}

	public String logErr() {
		return this.err2;
	}
	
	public String getData(int i){
		return data[i];
	}
	
	public boolean isHang(){
		return this.hang;
	}
	
	public String getHangDate(){
		return this.hangDate.substring(0, 10);
	}
}
