package PersonTask.Sorter;

import java.util.Comparator;

import PersonTask.Person.Person;
import PersonTask.Repository.Repository;

public class InsertSorter implements Sorter {

	@Override
	public void sort(Repository rep, Comparator<Person> comp) {
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
