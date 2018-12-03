/**
 * 
 */
package PersonTask.Checker;

import PersonTask.Person.Person;

/**
 * @author DENIS
 *
 */
public class PersonAgeChecker implements Checker {

	@Override
	public Boolean check(Person p, Object o) {
		return Integer.valueOf(p.getAge()).equals(o);
	}

}
