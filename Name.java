package for_proj3;

import java.util.Objects;
import java.io.Serializable;

public class Name implements Serializable, Comparable<Person>{

	private String first = "";
	private String middle = "";
	private String last = "";
	
	public Name(String first, String middle, String last) {
		super();
		this.first = first;
		this.middle = middle;
		this.last = last;
	}

	public Name(String first, String last) {
		super();
		this.first = first;
		this.last = last;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	@Override
	public int hashCode() {
		return Objects.hash(first, last, middle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		return Objects.equals(first, other.first) && Objects.equals(last, other.last)
				&& Objects.equals(middle, other.middle);
	}

	@Override
	public String toString() {
		if(this.middle.equals("")) {
			return first + " " + last;
		}else {
			return first + " " + middle + " " + last;
		}
	}

	
	// FIX THIS
	
	public int compareTo(Name name) {
        return this.toString().compareTo(name.toString());

	}

	@Override
	public int compareTo(Person o) {
		return this.toString().compareTo(o.toString());
	}
	
	
	
}
