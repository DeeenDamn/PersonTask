package PersonTask.Sorter;

import java.util.Comparator;

import org.apache.log4j.Logger;

import PersonTask.Person.Person;
import PersonTask.Repository.Repository;

/**
 * Class for sort Persons in repository with insertsort
 * @author Kravchenko Denis
 */
public class InsertSorter implements Sorter {
	private static final Logger log = Logger.getLogger(InsertSorter.class);
	
	/**
	 * function, which sort Persons in repository by some comparator
	 * @param repository
	 * @param comparator	
	 */
	@Override
	public void sort(Repository rep, Comparator<Person> comp) {
		log.info("sort Repository with InsertSorter by " + comp.toString());
		for (int i = 1; i < rep.getCount(); i++) {
            int j;
            Person tmp = rep.get(i);
            for (j = i - 1; j >= 0; j--) {
                if (comp.compare(rep.get(j),tmp) < 0) {
                    break;
                }
                rep.set(j + 1, rep.get(j));
            }
            rep.set(j + 1, tmp);
        }
    }

}
