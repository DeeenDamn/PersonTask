package PersonTask.Checker;

import org.apache.log4j.Logger;

import PersonTask.Person.Person;

/**
 * Class for finding Persons at FIO
 * @author Kravchenko Denis
 */
public class PersonFIOChecker implements Checker {
	private static final Logger log = Logger.getLogger(PersonFIOChecker.class);
	
	/**
	 * return true if Person with FIO = object exist
	 * @param person
	 * @param object
	 */
	@Override
	public Boolean check(Person p, Object o) {
		log.info("check Person " + p.getFIO() + " with " + o.toString());
		return p.getFIO().equals(o);		
	}

}
