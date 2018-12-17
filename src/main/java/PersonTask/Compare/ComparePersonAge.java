/**
 * 
 */
package PersonTask.Compare;

import java.util.Comparator;

import org.apache.log4j.Logger;

import PersonTask.Person.Person;

/**
 * Class for compare Persons at age
 * @author Kravchenko Denis
 */
public class ComparePersonAge implements Comparator<Person>{
	private static final Logger log = Logger.getLogger(ComparePersonAge.class);
	
	/**
	 * function, which compare two Persons at age
	 * @param person 1
	 * @param person 2
	 * @return integer	
	 */
	@Override
	public int compare(Person p1, Person p2) {
		log.debug("compare Person1: " + p1.getAge() + " with Person2:" + p2.getAge() + " by age");
		return Integer.compare(p1.getAge(), p2.getAge());
	}
}
