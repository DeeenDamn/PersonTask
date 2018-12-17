package PersonTask.Sorter;

import java.util.Comparator;

import org.apache.log4j.Logger;

import PersonTask.Person.Person;
import PersonTask.Repository.Repository;

/**
 * Class for sort Persons in repository with shackersort
 * @author Kravchenko Denis
 */
public class ShakerSorter implements Sorter{
	private static final Logger log = Logger.getLogger(ShakerSorter.class);
	
	/**
	 * function, which sort Persons in repository by some comparator
	 * @param repository
	 * @param comparator	
	 */
	@Override
	public void sort(Repository rep, Comparator<Person> comp) {
		log.info("sort Repository with ShakerSorter by " + comp.toString());
		int left = 0;
		int right = rep.getCount() - 1;
		do {
			for(int i=left; i<right; i++) {
				if (comp.compare(rep.get(i), rep.get(i + 1)) > 0) {
                    Person tmp = rep.get(i);
                    rep.set(i, rep.get(i + 1));
                    rep.set(i + 1, tmp);
                }
			}
			right--;
			for(int i=right; i>=left; i--) {
				if (comp.compare(rep.get(i), rep.get(i + 1)) > 0) {
                    Person tmp = rep.get(i);
                    rep.set(i, rep.get(i + 1));
                    rep.set(i + 1, tmp);
                }
			}
			left++;
		}while(left < right);
	}

}
