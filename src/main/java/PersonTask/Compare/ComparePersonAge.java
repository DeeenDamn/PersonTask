/**
 * 
 */
package PersonTask.Compare;

import java.util.Comparator;

import PersonTask.Person.Person;

/**
 * @author DENIS
 *
 */
public class ComparePersonAge implements Comparator<Person>{
		
	@Override
	public int compare(Person p1, Person p2) {
		return Integer.compare(p1.getAge(), p2.getAge());
	}
}
