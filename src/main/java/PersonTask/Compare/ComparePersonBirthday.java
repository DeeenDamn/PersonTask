package PersonTask.Compare;

import java.util.Comparator;

import PersonTask.Person.Person;

/**
 * Class for compare Persons at Birthday
 * @author Kravchenko Denis
 */
public class ComparePersonBirthday implements Comparator<Person>{
	
	/**
	 * function, which compare two Persons at Birthday
	 * @param person 1
	 * @param person 2
	 * @return integer	
	 */
	@Override
	public int compare(Person p1, Person p2) {
		return p1.getBirthday().compareTo(p2.getBirthday());
	}
	
	
	

}
