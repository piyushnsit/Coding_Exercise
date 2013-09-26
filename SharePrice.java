//Data structure class to store company name along with its share price and month, year detail

public class SharePrice {

	private String comp;
	private String year;
	private String month;
	private int value;
	
	public SharePrice(String comp, String year, String month, int value)
	{
		this.comp = comp;
		this.year = year;
		this.month = month;
		this.value = value;		
	}
	
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		comp = comp;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String toString()
	{
		return this.comp + ":" + this.month + "'" + this.year + ":" + this.value;
	}
}
