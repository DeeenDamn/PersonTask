package PersonTask.Checker;

import PersonTask.Person.Person;

/**
 * Class for finding Persons at birthday
 * @author Kravchenko Denis
 */
public class PersonBirthdayChecker implements Checker {
	
	/**
	 * return true if Person with Birthday = object exist
	 * @param person
	 * @param object
	 */
	@Override
	public Boolean check(Person p, Object o) {
		return p.getBirthday().equals(o);
	}

}
