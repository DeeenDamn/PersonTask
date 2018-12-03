/**
 * 
 */
package PersonTask.Repository;
import java.util.Comparator;

import PersonTask.Checker.Checker;
import PersonTask.Person.Person;
import PersonTask.Sorter.BubbleSorter;
import PersonTask.Sorter.Sorter;

/**
 * @author DENIS
 *
 */
public class Repository {
		
		private Person[] list;
		private Sorter sorter = new BubbleSorter();
		private int id = 1;
		private int count = 0;
		
		public int getCount() {
			return count;
		}
		
		public Repository() {
			
		}
		
		public Repository(Person[] list, int count) {
			this.list = list;
			this.count = count;
		}
		
		public Repository(Sorter sorter) {
			this.list = new Person[0];
			this.sorter = sorter;
			this.count = 0;
		}
		
		public void add(Person p) {
			Person[] arr = new Person[count + 1];
			for (int i = 0; i < count; i++) { 
					arr[i] = list[i];
			}
			arr[count] = p;
			this.list = arr;	
			this.count++;
			this.id++;
		}
		
		public void add(String name, String sex, String day) {
			Person[] arr = new Person[count + 1];
			for (int i = 0; i < count; i++) { 
					arr[i] = list[i];
			}
			arr[count] = new Person(id, name, sex, day);
			this.list = arr;	
			this.count++;
			this.id++;
		}
		
		public void delete(int index) {
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
		
		public Person get(int index) {
			for (int i = 0; i < count; i++) {
				if (i == index) {
					return list[i];
				}
			}
			return null;
		}
		
		public void set(int j, Person p) {
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
		
		public String print(int index) {
			Person res = get(index);
			return res.getId() + " " + res.getFIO() + " " + res.getSex() + " " + res.getAge() + " " + res.getBirthday();
		}

		public void setSorter(Sorter sorter) {
			this.sorter = sorter;
		}
		
		public Sorter getSorter() {
			return sorter;
		}
		
		public void sort(Comparator<Person> comparator) {
	        sorter.sort(this, comparator);
	    }
		
		public Repository find(Checker f, Object o) {
			Repository res = new Repository();
			for (int i=0; i< count; i++) {
				if (f.check(this.get(i), o)){
					res.add(this.get(i));
				}
			}
			return res;
		}
	}

