/**
 * 
 */
package PersonTask.Repository;
import java.util.Comparator;

import org.apache.log4j.Logger;

import PersonTask.Inject.Inject;
import PersonTask.Inject.Injector;
import PersonTask.Checker.Checker;
import PersonTask.Person.Person;
import PersonTask.Sorter.BubbleSorter;
import PersonTask.Sorter.Sorter;

/**
 * Class Repository with list of Person
 * @author Kravchenko Denis
 */
public class Repository {
		
		/**
		 * fields
		 */
		private Person[] list;
		private int id = 1;
		private int count = 0;
		@Inject
		private Sorter sorter = null;
		private static final Logger log = Logger.getLogger(Repository.class);
		
		/**
		 * get count of Person in Repository
		 * @return count
		 */
		public int getCount() {
			log.info("get Repository's count");
			return this.count;
		}
		
		/**
		 * Empty constructor
		 */
		public Repository() {
			log.info("init empty Repository");
			this.list = new Person[0];
			this.count = 0;
			new Injector().dosomething(this);
		}
		
		/**
		 * Constructor for same Persons
		 * @param list
		 * @param count
		 */
		public Repository(Person[] list, int count) {
			log.info("init Repository with some Persons");
			this.list = list;
			this.count = count;
			new Injector().dosomething(this);
		}
		
		/**
		 * Constructor with some Sorter
		 * @param sorter
		 */
		public Repository(Sorter sorter) {
			log.info("init empty Repository with sorter");
			this.list = new Person[0];
			this.sorter = sorter;
			this.count = 0;
			//new Injector().dosomething(this);
		}
		
		/**
		 * function, which add Person
		 * @param person
		 */
		public void add(Person p) {
			log.debug("add Person in Repository as Person "+ p.getId());
			Person[] arr = new Person[count + 1];
			for (int i = 0; i < count; i++) { 
					arr[i] = list[i];
			}
			arr[count] = p;
			this.list = arr;	
			this.count++;
			this.id++;
		}
		
		/**
		 * function, which add Person as Person's field
		 * @param name
		 * @param sex
		 * @param day
		 */
		public void add(String name, String sex, String day) {
			log.debug("add Person in Repository as fields " + count);
			Person[] arr = new Person[count + 1];
			for (int i = 0; i < count; i++) { 
					arr[i] = list[i];
			}
			arr[count] = new Person(id, name, sex, day);
			this.list = arr;	
			this.count++;
			this.id++;
		}
		
		/**
		 * function, which delete Person by index
		 * @param index
		 */
		public void delete(int index) {
			log.info("delete Person from Repository by index " + index);
			this.count--;
			int j = 0;
			if (count > 0) {
				Person[] arr = new Person[count];
				for (int i = 0; i < count + 1; i++) {
					if (i != index) {
						arr[j] = list[i];
						j++;
					}
				}
				this.list = arr;
			}
		}
		
		/**
		 * function, which return Person at index
		 * @param index
		 * @return person
		 */
		public Person get(int index) {
			log.debug("get Person from Repository at index " + index);
			for (int i = 0; i < count; i++) {
				if (i == index) {
					return list[i];
				}
			}
			return null;
		}
		
		/**
		 * function, which add Person at some index
		 * @param index
		 * @param person
		 */
		public void set(int j, Person p) {
			log.debug("set Person in Repository at index " + j + " " + p.getId());
			Person[] arr = this.list;
			this.list = new Person[0];
			count=0;
			for (int i = 0; i < arr.length; i++) {
				if (j == i) {
					add(p);
				}
				if (arr[i].getId() != p.getId()) {
					add(arr[i]);
				}
			}	
		}
		
		/**
		 * function, which set Sorter 
		 * @param sorter
		 */
		public void setSorter(Sorter sorter) {
			log.info("set sorter to " + sorter.toString());
			this.sorter = sorter;
		}
		
		/**
		 * function, which return Sorter
		 * @return sorter
		 */
		public Sorter getSorter() {
			log.info("get sorter");
			return this.sorter;
		}
		
		/**
		 * function, which sort Repository of Persons
		 * @param comparator
		 */
		public void sort(Comparator<Person> comparator) {
			log.info("sort Repository  with " + sorter.toString() + " by " + comparator.toString());
	        sorter.sort(this, comparator);
	    }
		
		/**
		 * function, which find same Persons at some object
		 * @param checker
		 * @param object
		 * @return Repository
		 */
		public Repository find(Checker f, Object o) {
			log.debug("find Persons by " + o.toString() + " and " + f.toString());
			Repository res = new Repository();
			for (int i=0; i< count; i++) {
				if (f.check(this.get(i), o)){
					res.add(this.get(i));
				}
			}
			return res;
		}
	}

