package PersonTask.Checker;

import PersonTask.Person.Person;

/**
 * Class for finding Persons at FIO
 * @author Kravchenko Denis
 */
public class PersonFIOChecker implements Checker {
	
	/**
	 * return true if Person with FIO = object exist
	 * @param person
	 * @param object
	 */
	@Override
	public Boolean check(Person p, Object o) {
		return p.getFIO().equals(o);		
	}

}
