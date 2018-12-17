package PersonTask.Compare;

import java.util.Comparator;

import org.apache.log4j.Logger;

import PersonTask.Person.Person;

/**
 * Class for compare Persons at Birthday
 * @author Kravchenko Denis
 */
public class ComparePersonBirthday implements Comparator<Person>{
	private static final Logger log = Logger.getLogger(ComparePersonBirthday.class);
	
	/**
	 * function, which compare two Persons at Birthday
	 * @param person 1
	 * @param person 2
	 * @return integer	
	 */
	@Override
	public int compare(Person p1, Person p2) {
		log.debug("compare Person1: " + p1.getBirthday() + " with Person2:" + p2.getBirthday() + " by Birthday");
		return p1.getBirthday().compareTo(p2.getBirthday());
	}
	
	
	

}
