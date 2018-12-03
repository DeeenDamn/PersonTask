/**
 * 
 */
package PersonTask.Sorter;

import java.util.Comparator;

import PersonTask.Person.Person;
import PersonTask.Repository.Repository;

/**
 * @author DENIS
 *
 */
public interface Sorter {	
	void sort(Repository rep, Comparator<Person> comp);
}
