/**
 * 
 */
package PersonTask.Sorter;

import java.util.Comparator;

import org.apache.log4j.Logger;

import PersonTask.Person.Person;
import PersonTask.Repository.Repository;

/**
 * Class for sort Persons in repository with bubblesort
 * @author Kravchenko Denis
 */
public class BubbleSorter implements Sorter {
	private static Logger log = Logger.getLogger(BubbleSorter.class);
	
	/**
	 * function, which sort Persons in repository by some comparator
	 * @param repository
	 * @param comparator	
	 */
	@Override
	public void sort(Repository rep, Comparator<Person> comp) {
		log.info("sort Repository with BubbleSorter by " + comp.toString());
		for (int i = rep.getCount() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comp.compare(rep.get(j), rep.get(j + 1)) > 0) {
                    Person tmp = rep.get(j);
                    rep.set(j, rep.get(j + 1));
                    rep.set(j + 1, tmp);
                }
            }
        }		
	}

}
