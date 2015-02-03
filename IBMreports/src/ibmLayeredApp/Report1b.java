package ibmLayeredApp;

import java.sql.Time;
import java.util.Date;

public class Report1b {

	private Date tdate;
	private Time min_time;
	private Time max_time;
	private float max_price;
	private float min_price;

	public Report1b(Date tdate, Time min_time, Time max_time, float max_price,
			float min_price) {
		super();
		this.tdate = tdate;
		this.min_time = min_time;
		this.max_time = max_time;
		this.max_price = max_price;
		this.min_price = min_price;
	}

	// Getters / Setters
	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	public Time getMin_time() {
		return min_time;
	}

	public void setMin_time(Time min_time) {
		this.min_time = min_time;
	}

	public Time getMax_time() {
		return max_time;
	}

	public void setMax_time(Time max_time) {
		this.max_time = max_time;
	}

	public float getMax_price() {
		return max_price;
	}

	public void setMax_price(float max_price) {
		this.max_price = max_price;
	}

	public float getMin_price() {
		return min_price;
	}

	public void setMin_price(float min_price) {
		this.min_price = min_price;
	}

	@Override
	public String toString() {
		return "report2 [tdate=" + tdate + ", min_time=" + min_time
				+ ", max_time=" + max_time + ", max_price=" + max_price
				+ ", min_price=" + min_price + "]";
	}

}
