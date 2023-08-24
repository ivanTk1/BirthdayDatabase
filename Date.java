package for_proj3;

import java.io.Serializable;
import java.util.Objects;

public class Date implements Serializable {

    //private static final long serialVersionUID = 1L;
	private Month month;
	private int day;
	private int year;
	
	public Date(Month month, int day, int year) {
		super();
		if(Month.isValidDay(month, day) && (year > -1)) {
			
			this.month = month;
			this.day = day;
			this.year = year;
	    	}else {
	    		throw new IllegalArgumentException("Date in invalid Please try again");
	    		}
	}
	

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		if(Month.isValidDay(month, this.day)  && (this.year > -1)) {
			this.month = month;
		}else {
    		throw new IllegalArgumentException("Date in invalid Please try again");
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if(Month.isValidDay(this.month, day) && (this.year > -1)) {
			this.day = day;
		}else {
    		throw new IllegalArgumentException("Date in invalid Please try again");
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if(Month.isValidDay(this.month, day) && year > -1) {
			this.year = year;
		}else {
    		throw new IllegalArgumentException("Date in invalid Please try again");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(day, month, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		return day == other.day && month == other.month && year == other.year;
	}

	@Override
	public String toString() {
		return month + " " + day + ", " + year ;
	}
	
	/*NOTES:
	 * is iterable implimented correctly in Linked list?
	 *  need help writing the sortChronol method in PersonList.
	 * 
	 */
	
	
	
	
	
}
