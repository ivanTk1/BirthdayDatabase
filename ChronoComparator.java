package for_proj3;
import java.util.Comparator;


public class ChronoComparator implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		
		Date date1 = p1.getDate();
        Date date2 = p2.getDate();
        
        int year1 = date1.getYear();
        Month month1 = date1.getMonth();
        int day1 = date1.getDay();
        
        int year2 = date2.getYear();
        Month month2 = date2.getMonth();
        int day2 = date2.getDay();

        if (year1 < year2) {
            return -1;
        } else if (year1 > year2) {
            return 1;
        } else {
            int monthCompare = month1.compareTo(month2);
            if (monthCompare != 0) {
                return monthCompare;
            } else {
                if (day1 < day2) {
                    return -1;
                } else if (day1 > day2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}