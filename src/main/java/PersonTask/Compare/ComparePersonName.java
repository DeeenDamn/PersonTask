/**
 * 
 */
package PersonTask.Compare;
import java.util.Comparator;

import PersonTask.Person.Person;

/**
 * @author DENIS
 *
 */
public class ComparePersonName implements Comparator<Person>{
	
	@Override
	public int compare(Person p1, Person p2) {
		return p1.getFIO().compareTo(p2.getFIO());
	}
}
