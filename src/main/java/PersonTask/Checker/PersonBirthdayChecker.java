package PersonTask.Checker;



import org.apache.log4j.Logger;

import PersonTask.Person.Person;

/**
 * Class for finding Persons at birthday
 * @author Kravchenko Denis
 */
public class PersonBirthdayChecker implements Checker {
	private static final Logger log = Logger.getLogger(PersonBirthdayChecker.class);
	/**
	 * return true if Person with Birthday = object exist
	 * @param person
	 * @param object
	 */
	@Override
	public Boolean check(Person p, Object o) {
		log.info("check Person " + p.getBirthday() + " with " + o.toString());
		return p.getBirthday().equals(o);
	}

}
