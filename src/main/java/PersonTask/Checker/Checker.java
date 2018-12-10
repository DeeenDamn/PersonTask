/**
 * 
 */
package PersonTask.Checker;

import PersonTask.Person.Person;

/**
 * interface for find some Persons at same object
 * @author DENIS
 */
public interface Checker {
	
	/**
	 * function, which return true if Person has field = object
	 * @param person
	 * @param object
	 * @return boolean
	 */
	Boolean check(Person p, Object o);

}
