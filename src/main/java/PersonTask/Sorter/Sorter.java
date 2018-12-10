/**
 * 
 */
package PersonTask.Sorter;

import java.util.Comparator;

import PersonTask.Person.Person;
import PersonTask.Repository.Repository;

/**
 * interface for sorting Persons in repository
 * @author DENIS
 */
public interface Sorter {	
	
	/**
	 * function, which sort Persons in repository 
	 * @param person
	 * @param object
	 * @return boolean
	 */
	void sort(Repository rep, Comparator<Person> comp);
}
