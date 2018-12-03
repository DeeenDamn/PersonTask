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
public class BubbleSorter implements Sorter {

	@Override
	public void sort(Repository rep, Comparator<Person> comp) {
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
