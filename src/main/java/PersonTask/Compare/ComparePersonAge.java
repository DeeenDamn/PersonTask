/**
 * 
 */
package PersonTask.Compare;

import java.util.Comparator;

import PersonTask.Person.Person;

/**
 * Class for compare Persons at age
 * @author Kravchenko Denis
 */
public class ComparePersonAge implements Comparator<Person>{
	
	/**
	 * function, which compare two Persons at age
	 * @param person 1
	 * @param person 2
	 * @return integer	
	 */
	@Override
	public int compare(Person p1, Person p2) {
		return Integer.compare(p1.getAge(), p2.getAge());
	}
}
