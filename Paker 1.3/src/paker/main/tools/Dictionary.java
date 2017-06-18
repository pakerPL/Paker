package paker.main.tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
	
	private List<String> slownikKl = new ArrayList<String>();
	private String err, err2;
	
	public Dictionary(Connection conn, String tableName, int howManyData) {
		Statement s;
		String command;
		int hMD;
		
		String returning; 
		if(tableName.equals("klient")){
			command = "SELECT * FROM "+tableName+ " WHERE zabl = false ORDER BY id ASC";
		}else if(tableName.equals("typ_karnetu") || tableName.equals("grupa")){
			command = "SELECT id, nazwa_wlasna FROM "+tableName+ " WHERE wuzytku = true ORDER BY id ASC";
		}else{
			command = "SELECT * FROM "+tableName + " ORDER BY id ASC";
		}
		
		try {
			s=conn.createStatement();
			ResultSet rs = s.executeQuery(command);
			
			while(rs.next()){
				int i = 3;
				returning = rs.getInt(1) + ". " + rs.getString(2);
				for(hMD= howManyData; hMD>0; hMD--){
					returning = returning.concat(" " + rs.getString(i));
					i++;
				}
				
				slownikKl.add(returning);
			}
			rs.close();
						
			s.close();
			
		} catch (SQLException e) {
			this.err = "Problem z pobraniem s這wnik闚";
			this.err2 = " DI Problem z pobraniem s這wnik闚 " + e;
			}
		
	}
	
	public Dictionary(Connection conn, String tableName, String filtr) {
		Statement s;
		String command;
		if(tableName.equals("klient")){
			command = "SELECT * FROM "+tableName+ " WHERE zabl = false AND nazwisko LIKE '"+filtr+"%'";
			try {
				s=conn.createStatement();
				ResultSet rs = s.executeQuery(command);
				
				while(rs.next()){
					slownikKl.add(rs.getInt(1) + ". " + rs.getString(2) + " " + rs.getString(3));
				}
				rs.close();
							
				s.close();
				
			} catch (SQLException e) {
				this.err = "Problem z pobraniem s這wnik闚";
				this.err2 = " DI Problem z pobraniem s這wnik闚 " + e;
				}
			
		}else if(tableName.equals("typ_karnetu")){
			command = "SELECT id, nazwa_wlasna FROM "+tableName+ " WHERE wuzytku = true AND grupa = (select grupa from klient where id = "+filtr+") ORDER BY id ASC;";
			try {
				s=conn.createStatement();
				ResultSet rs = s.executeQuery(command);
				
				
				while(rs.next()){
					slownikKl.add(rs.getInt(1) + ". " + rs.getString(2));
				}
				rs.close();
							
				s.close();
				
			} catch (SQLException e) {
				this.err = "Problem z pobraniem s這wnik闚";
				this.err2 = " DI Problem z pobraniem s這wnik闚 " + e;
				}
			
		}else if(tableName.equals("karnety2")){
			command = "SELECT id, nazwa_wlasna FROM typ_karnetu WHERE wuzytku = true AND grupa = "+filtr+" ORDER BY id ASC;";
			try {
				s=conn.createStatement();
				ResultSet rs = s.executeQuery(command);
				
				while(rs.next()){
					slownikKl.add(rs.getInt(1) + ". " + rs.getString(2));
				}
				rs.close();
							
				s.close();
				
			} catch (SQLException e) {
				this.err = "Problem z pobraniem s這wnik闚";
				this.err2 = " DI Problem z pobraniem s這wnik闚 " + e;
				}
			
		}else if (tableName.equals("cena_wejscia")){
			command = "SELECT nazwa_wejscia FROM cena_wejscia WHERE aktualne = TRUE";
		try {
			s=conn.createStatement();
			ResultSet rs = s.executeQuery(command);
			
			while(rs.next()){
				slownikKl.add(rs.getString(1));
			}
			rs.close();
						
			s.close();
			
		} catch (SQLException e) {
			System.out.println(command);
			this.err = "Problem z pobraniem s這wnik闚";
			this.err2 = " DI Problem z pobraniem s這wnik闚 " + e;
		}
		}else command = "SELECT * FROM "+tableName;
		
		
	}
	
	
	public String getClDictionry(int i){
		if(i < slownikKl.size()){
		return slownikKl.get(i);
		}else return "full";
	}
	
	public String mss(){
		return this.err;
	}
	public String logErr(){
		return this.err2;
	}
}
