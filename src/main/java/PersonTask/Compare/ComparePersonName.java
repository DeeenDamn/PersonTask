/**
 * 
 */
package PersonTask.Compare;
import java.util.Comparator;

import org.apache.log4j.Logger;

import PersonTask.Person.Person;

/**
 * Class for compare Persons at FIO
 * @author Kravchenko Denis
 */
public class ComparePersonName implements Comparator<Person>{
	private static final Logger log = Logger.getLogger(ComparePersonName.class);
	
	/**
	 * function, which compare two Persons at FIO
	 * @param person 1
	 * @param person 2
	 * @return integer	
	 */
	@Override
	public int compare(Person p1, Person p2) {
		log.debug("compare Person1: " + p1.getFIO() + " with Person2:" + p2.getFIO() + " by FIO");
		return p1.getFIO().compareTo(p2.getFIO());
	}
}
