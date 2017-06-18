package paker.main.tools;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	private String sciecha[] = new String[3];
	private int h, w;
	private String dir;
	private String fileName = "Logi/LOG" + new DzisiejszaData().plik() + ".txt";
	private BufferedReader bf;
	private FileReader fr;
	private String message; 
	Connection conn = null;
	private static final ConnectDB INSTANCE = new ConnectDB();
	
	public static ConnectDB getIsnstance(){
		return INSTANCE;
	}
	
	private void getConf(BufferedReader bf) {
		String tmp;
		this.sciecha[0] = "jdbc:postgresql://";
		
		
		try {
			while ((tmp = bf.readLine()) != null) {
				if (!tmp.isEmpty()) {
					if (tmp.charAt(0) != '#') {
						if (tmp.charAt(0) == 'l' & tmp.charAt(1) == ':') {
							this.sciecha[1] = tmp.substring(2);
						} else if (tmp.charAt(0) == 'n' & tmp.charAt(1) == ':') {
							this.sciecha[0] = this.sciecha[0].concat(tmp
									.substring(2));
						} else if (tmp.charAt(0) == 'w' & tmp.charAt(1) == ':') {
							this.h = Integer.parseInt(tmp.substring(2));
						} else if (tmp.charAt(0) == 's' & tmp.charAt(1) == ':') {
							this.w = Integer.parseInt(tmp.substring(2));
						} else if (tmp.charAt(0) == 'd' & tmp.charAt(1) == ':') {
							this.dir = tmp.substring(2);
						} else if (tmp.charAt(0) == 'h' & tmp.charAt(1) == ':'){
							this.sciecha[0] = this.sciecha[0].concat(tmp.substring(2) + "/");
						} 
					}
				}
			}
			this.sciecha[2] = "postklop12";//"zaq1234rfv";
		} catch (IOException e) {
			this.message = "B³¹d odczytu pliku konfiguracymichajnego";
			
		}
	}
	
	public ConnectDB() {
		
		File conf = new File("silownia.conf");
		File log = new File(fileName);
		try {
			fr = new FileReader(conf);
			bf = new BufferedReader(fr);
			getConf(bf);
			this.message = "Wczytano plik konfiguracyjny";
		} catch (FileNotFoundException e1) {
			this.message = "Brak pliku konfiguracyjnego";
		}
		
		try {
			conn = DriverManager.getConnection(sciecha[0], sciecha[1],
					sciecha[2]);
			this.message =  "Po³¹czono z baz¹ danych";
		} catch (SQLException e) {
		this.message = "B³¹d z pol¹czeniem bazy danych";
			e.printStackTrace();
		}
	}
	
	public String getMssg(){
		return this.message;
	}
	
	public void setMssg(String tmp){
		this.message = tmp;
	}
	
	public Connection getConn(){
		return this.conn;
	}
	
}
