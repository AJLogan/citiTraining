package ibmLayeredApp;

import java.sql.Time;
import java.util.Date;

public class IBM {
	private Date tdate;
	private Time ttime;
	private float openpr;
	private float highpr;
	private float lowpr;
	private float closepr;
	private int volume;
	private float tradeRange;

	public IBM(Date tdate, Time ttime, float openpr, float highpr, float lowpr,
			float closepr, int volume, float tradeRange) {
		super();
		this.tdate = tdate;
		this.ttime = ttime;
		this.openpr = openpr;
		this.highpr = highpr;
		this.lowpr = lowpr;
		this.closepr = closepr;
		this.volume = volume;
		this.tradeRange = tradeRange;
	}

	// Getters and Setters
	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	public Date getTtime() {
		return ttime;
	}

	public void setTtime(Time ttime) {
		this.ttime = ttime;
	}

	public float getOpenpr() {
		return openpr;
	}

	public void setOpenpr(float openpr) {
		this.openpr = openpr;
	}

	public float getHighpr() {
		return highpr;
	}

	public void setHighpr(float highpr) {
		this.highpr = highpr;
	}

	public float getLowpr() {
		return lowpr;
	}

	public void setLowpr(float lowpr) {
		this.lowpr = lowpr;
	}

	public float getClosepr() {
		return closepr;
	}

	public void setClosepr(float closepr) {
		this.closepr = closepr;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public float getTradeRange() {
		return tradeRange;
	}

	public void setTradeRange(float tradeRange) {
		this.tradeRange = tradeRange;
	}

	@Override
	public String toString() {
		return "IBMData [tdate=" + tdate + ", ttime=" + ttime + ", openpr="
				+ openpr + ", highpr=" + highpr + ", lowpr=" + lowpr
				+ ", closepr=" + closepr + ", volume=" + volume + "]";
	}

}
