package PersonTask.Sorter;

import java.util.Comparator;

import PersonTask.Person.Person;
import PersonTask.Repository.Repository;

public class ShakerSorter implements Sorter{

	@Override
	public void sort(Repository rep, Comparator<Person> comp) {
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
			for(int i=right; i>left; i--) {
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
