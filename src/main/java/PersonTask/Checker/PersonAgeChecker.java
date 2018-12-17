/**
 * 
 */
package PersonTask.Checker;

import org.apache.log4j.Logger;

import PersonTask.Person.Person;

/**
 * Class for finding Persons at age
 * @author Kravchenko Denis
 */
public class PersonAgeChecker implements Checker {
	private static final Logger log = Logger.getLogger(PersonAgeChecker.class);
	/**
	 * return true if Person with age = object exist
	 * @param person
	 * @param object
	 */
	@Override
	public Boolean check(Person p, Object o) {
		log.info("check Person " + p.getAge() + " with " + o.toString());
		return Integer.valueOf(p.getAge()).equals(o);
	}

}
