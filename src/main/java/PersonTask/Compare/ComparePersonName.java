/**
 * 
 */
package PersonTask.Compare;
import java.util.Comparator;

import PersonTask.Person.Person;

/**
 * Class for compare Persons at FIO
 * @author Kravchenko Denis
 */
public class ComparePersonName implements Comparator<Person>{
	
	/**
	 * function, which compare two Persons at FIO
	 * @param person 1
	 * @param person 2
	 * @return integer	
	 */
	@Override
	public int compare(Person p1, Person p2) {
		return p1.getFIO().compareTo(p2.getFIO());
	}
}
