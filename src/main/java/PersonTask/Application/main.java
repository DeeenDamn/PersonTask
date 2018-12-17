/**
 * 
 */
package PersonTask.Application;

import PersonTask.Repository.Repository;
import PersonTask.Sorter.InsertSorter;

import java.util.Comparator;

import org.apache.log4j.Logger;

import PersonTask.Checker.Checker;
import PersonTask.Checker.PersonFIOChecker;
import PersonTask.Compare.*;
import PersonTask.Person.Person;

/**
 * @author DENIS
 *
 */
public class main {
	private static final Logger log = Logger.getLogger(main.class);

	/**
	 * Class for application
	 * @param args
	 */
	public static void main(String[] args) {
		log.info("start application");
		Comparator<Person> a = new ComparePersonAge();
		Checker f = new PersonFIOChecker();
		Repository r = new Repository();
		r.add("a", "male", "01/01/1890");
		r.add("b", "female", "01/02/1992");
		r.add("c", "male", "01/04/1994");
		r.add("d", "female", "01/08/1998");
		r.add("a", "female", "02/08/1978");
		r.add("a", "male", "01/09/1965");
		r.add("a", "female", "21/12/2000");
		r.delete(2);
		
		System.out.println(a.compare(r.get(1), r.get(2)));
		for (int i=0; i < r.getCount(); i++)
			System.out.println(r.get(i).print());
		r.sort(a);
		System.out.println();
		for (int i=0; i < r.getCount(); i++)
			System.out.println(r.get(i).print());
		r = r.find(f, "a");
		System.out.println();
		for (int i=0; i < r.getCount(); i++)
			System.out.println(r.get(i).print());
	}

}