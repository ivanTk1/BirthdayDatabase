package for_proj3;

import java.util.Objects;
import java.io.Serializable;

public class Person implements Comparable<Person>, Serializable {

	private Name name;
	private Date date;
	private static int numPeople = 0;
	
	public Person(Name name, Date date) {
		super();
		this.name = name;
		this.date = date;
		numPeople++;
	}

	public Person(String first, String last, Month month, int day, int year) {
		super();
		Name name = new Name(first, last);
		Date date = new Date(month, day, year);
		this.name = name;
		this.date = date;
		numPeople++;
	}

	public Name getName() {
		return name;
	}


	public Date getDate() {
		return date;
	}

	public static int getNumPeople() {
		return numPeople;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(date, other.date) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return name.toString() + ", " + date.toString();
	}
	
	@Override
    public int compareTo(Person otherPerson) {
		int toReturn;
		toReturn = this.getName().getLast().compareTo(otherPerson.getName().getLast());
		if(toReturn == 0) {
			toReturn = this.getName().getFirst().compareTo(otherPerson.getName().getFirst());
		}
		return toReturn;
    }
	
}

	
	
	
	
	

