package paker.main.tools;

import java.util.Calendar;

public class DzisiejszaData {

	private Calendar cal = Calendar.getInstance();

	private int d;
	private int m;
	private int r;
	private int godz;
	private int minu;
	private int seku;

	public DzisiejszaData() {
		d = cal.get(Calendar.DAY_OF_MONTH);
		m = cal.get(Calendar.MONTH) + 1;
		r = cal.get(Calendar.YEAR);
		godz = cal.get(Calendar.HOUR_OF_DAY);
		minu = cal.get(Calendar.MINUTE);
		seku = cal.get(Calendar.SECOND);
	}

	@Override
	public String toString() {
		return prefiks(d) + "-" + prefiks(m) + "-" + r + " " + prefiks(godz)
				+ ":" + prefiks(minu) + ":" + prefiks(seku);
	}
	public String plik(){
		return " "+r +"-"+ m +"-"+ d +" "+ godz + prefiks(minu);
	}

	public String dataToData() {
		return r + "-" + prefiks(m) + "-" + prefiks(d) + " " + prefiks(godz)
				+ ":" + prefiks(minu) + ":" + prefiks(seku);
	}

	private String prefiks(int l) {
		if (l < 10 & l >= 0)
			return "0" + l;
		else
			return Integer.toString(l);
	}

	public String czas() {
		return prefiks(godz) + ":" + prefiks(minu) + ":" + prefiks(seku);
	}

	public String data() {
		return r + "-" + prefiks(m) + "-" + prefiks(d);
	}

	public void setDay(int d) {
		int dp = this.d;

		if (this.m <= 7) {
			if (this.m % 2 == 1) {
				if ((dp + d) > 31) {
					dp = (dp + d) - 31;
					setMon(1);
				} else
					dp += d;
			} else if (this.m % 2 == 0) {
				if (this.m == 2) {
					if (this.r % 4 == 0) {
						if ((dp + d) > 29) {
							dp = (dp + d) - 29;
							setMon(1);
						} else
							dp += d;
					} else if (this.r % 4 != 0) {
						if ((dp + d) > 28) {
							dp = (dp + d) - 28;
							setMon(1);
						} else
							dp += d;
					}
				} else if ((dp + d) > 30) {
					dp = (dp + d) - 30;
					setMon(1);
				} else
					dp += d;
			}
		} else if (this.m > 7) {
			if (this.m % 2 == 0) {
				if ((dp + d) > 31) {
					dp = (dp + d) - 31;
					setMon(1);
				} else
					dp += d;
			} else if (this.m % 2 == 1) {
				if ((dp + d) > 30) {
					dp = (dp + d) - 30;
					setMon(1);
				} else
					dp += d;
			}
		}
		this.d = dp;
	}
	
	public void absoluteSetDay(int d){
		this.d = d;
	}
	
	public void setDayFirsWeek(){
		int ro = cal.get(Calendar.DAY_OF_WEEK);
		ro -=1;
		if(ro==0) ro=7;
		setDay(1 - ro);
	}

	public void setMon(int m) {
		int mp = this.m;
		if(this.m == 1 & this.d > 28){
			this.d = 28;
			mp=2;
		}else 
		if((mp + m)>12){
			mp = 1;
			setYer(1);
		} else mp += m;
		this.m = mp;
	}

	public void setYer(int r) {
		this.r += r;
	}
	
	public int getDay(){
		return this.d;
	}
	
	public int getMonth(){
		return this.m;
	}
	
	public int getYear(){
		return this.r;
	}

}