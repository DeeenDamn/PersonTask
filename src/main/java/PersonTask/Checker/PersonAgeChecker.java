/**
 * 
 */
package PersonTask.Checker;

import PersonTask.Person.Person;

/**
 * Class for finding Persons at age
 * @author Kravchenko Denis
 */
public class PersonAgeChecker implements Checker {
	
	/**
	 * return true if Person with age = object exist
	 * @param person
	 * @param object
	 */
	@Override
	public Boolean check(Person p, Object o) {
		return Integer.valueOf(p.getAge()).equals(o);
	}

}
