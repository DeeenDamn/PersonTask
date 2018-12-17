/**
 * 
 */
package testapp;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import PersonTask.Checker.*;
import PersonTask.Compare.*;
import PersonTask.Person.Person;
import PersonTask.Repository.Repository;
import PersonTask.Sorter.*;

/**
 * class for test Repository
 * @author Kravchenko Denis
 */
public class RepositoryTest {
	private Repository rep;
	
	/**
	 * function which work before every @Test
	 */
	@Before
	public void begin() {
		rep = new Repository();
	}
	
	/**
	 * function which work after every @Test
	 */
	@After
	public void end() {
		rep = null;
	}
	
	/**
	 * test for add person as class
	 */
	@Test
	public void testAddPerson() {
		Person p = new Person(1, "surname name", "male", "11/09/2001");
		rep.add(p);
	}
	
	/**
	 * test for add person as fields
	 */
	@Test
	public void testAddPersonAsField() {
		rep.add("surnameb name", "male", "01/03/1999");
	}
	
	/**
	 * test for count
	 */
	@Test
	public void testCount() {
		Person p1 = new Person(1, "surnamea name", "female", "02/07/1968");
		Person p2 = new Person(2, "surname name", "female", "11/10/2001");
		rep.add(p1);
		rep.add(p2);
		int expected = 2;
		assertEquals(expected, rep.getCount());
	}
	
	/**
	 * test for sorter
	 */
	@Test
	public void testgetsorter() {
		Sorter isorter = new InsertSorter();
		rep.setSorter(isorter);
		Sorter expected = isorter;
		assertEquals(expected, rep.getSorter());
	}
	
	/**
	 * test for function which get Person by index
	 */
	@Test 
	public void testGet() {
		Person p1 = new Person(1, "surnamea name", "female", "02/07/1968");
		Person p2 = new Person(2, "surname name", "female", "11/10/2001");
		Person p3 = new Person(3, "surname name", "male", "11/09/2001");
		rep.add(p1);
		rep.add(p2);
		rep.add(p3);
		Person expected = p2;
		assertEquals(expected, rep.get(1));
	}
	
	/**
	 * test for set Person in Repository at index
	 */
	@Test
	public void testSet() {
		Person p1 = new Person(1, "surnamea name", "female", "02/07/1968");
		Person p2 = new Person(2, "surname name", "female", "11/10/2001");
		Person p3 = new Person(3, "surname name", "male", "11/09/2001");
		rep.add(p1);
		rep.add(p2);
		rep.add(p3);
		Person expected = p3;
		rep.set(1, expected);
		assertEquals(expected, rep.get(1));
	}
	
	/**
	 * test for checker by Fio
	 */
	@Test
	public void testCheckerByFIO() {
		System.out.println("check by FIO");
		Checker check = new PersonFIOChecker();
		Person p1 = new Person(1, "surnamea name", "female", "02/07/1968");
		Person p2 = new Person(2, "surname name", "female", "11/10/2001");
		Person p3 = new Person(3, "surname name", "male", "11/09/2001");
		rep.add(p1);
		rep.add(p2);
		rep.add(p3);
		Repository expected = new Repository();
		expected.add(rep.get(1));
		expected.add(rep.get(2));
		Repository actual = rep.find(check, "surname name");
		for (int i = 0 ; i < expected.getCount(); i++) {
			System.out.println(expected.get(i).print() + " <=> " + actual.get(i).print());
		}
		System.out.println("");
	}
	
	/**
	 * test for checker by Birthday
	 */
	@Test
	public void testCheckerByBirthday() {
		System.out.println("check by birthday");
		Checker check = new PersonBirthdayChecker();
		Person p1 = new Person(1, "surnamea name", "female", "02/07/1968");
		Person p2 = new Person(2, "surname name", "female", "11/10/2001");
		Person p3 = new Person(3, "surname name", "male", "11/09/2001");
		rep.add(p1);
		rep.add(p2);
		rep.add(p3);
		Repository expected = new Repository();
		expected.add(rep.get(0));
		Repository actual = rep.find(check, "02.07.1968");
		for (int i = 0 ; i < expected.getCount(); i++) {
			System.out.println(expected.get(i).print() + " <=> " + actual.get(i).print());
		}
		System.out.println("");
	}
	
	/**
	 * test for checker by Age
	 */
	@Test
	public void testCheckerByAge() {
		System.out.println("check by age");
		Checker check = new PersonAgeChecker();
		Person p1 = new Person(1, "surnamea name", "female", "02/07/1968");
		Person p2 = new Person(2, "surname name", "female", "11/10/2001");
		Person p3 = new Person(3, "surname name", "male", "11/09/2001");
		rep.add(p1);
		rep.add(p2);
		rep.add(p3);
		Repository expected = new Repository();
		expected.add(rep.get(1));
		expected.add(rep.get(2));
		Repository actual = rep.find(check, 17);
		for (int i = 0 ; i < expected.getCount(); i++) {
			System.out.println(expected.get(i).print() + " <=> " + actual.get(i).print());
		}
		System.out.println("");
	}
	
	/**
	 * test bubble sort by FIO
	 */
	@Test
	public void testsortBubbleFIO() {
		System.out.println("bubblesort at FIO");
		Person p1 = new Person(1, "surnameb name", "female", "02/07/1968");
		Person p2 = new Person(2, "asurname name", "female", "11/10/2001");
		Person p3 = new Person(3, "surnamea name", "male", "11/09/2001");
		rep.add(p1);
		rep.add(p2);
		rep.add(p3);
		Repository expected = new Repository();
		expected.add(p2);
		expected.add(p3);
		expected.add(p1);
		rep.sort(new ComparePersonName());
		for (int i = 0; i < expected.getCount(); i++) {
			System.out.println(expected.get(i).print() + "  <=>  " + rep.get(i).print());
		}
		System.out.println("");
	}
	
	/**
	 * test bubble sort by Age
	 */
	@Test
	public void testsortBubbleAge() {
		System.out.println("bubblesort at age");
		Person p1 = new Person(1, "surnameb name", "female", "02/07/1968");
		Person p2 = new Person(2, "asurname name", "female", "11/10/2000");
		Person p3 = new Person(3, "surnamea name", "male", "11/09/2001");
		rep.add(p1);
		rep.add(p2);
		rep.add(p3);
		Repository expected = new Repository();
		expected.add(p3);
		expected.add(p2);
		expected.add(p1);
		rep.sort(new ComparePersonAge());
		for (int i = 0; i < expected.getCount(); i++) {
			System.out.println(expected.get(i).print() + "  <=>  " + rep.get(i).print());
		}
		System.out.println("");
	}
	
	/**
	 * test bubble sort by Birthday
	 */
	@Test
	public void testsortBubbleBirthday() {
		System.out.println("bubblesort at birthday");
		Person p1 = new Person(1, "surnameb name", "female", "02/07/1968");
		Person p2 = new Person(2, "asurname name", "female", "07/10/2001");
		Person p3 = new Person(3, "surnamea name", "male", "11/09/2000");
		rep.add(p1);
		rep.add(p2);
		rep.add(p3);
		Repository expected = new Repository();
		expected.add(p1);
		expected.add(p2);
		expected.add(p3);
		rep.sort(new ComparePersonBirthday());
		for (int i = 0; i < expected.getCount(); i++) {
			System.out.println(expected.get(i).print() + "  <=>  " + rep.get(i).print());
		}
		System.out.println("");
	}
	
	/**
	 * test shaker sort by FIO
	 */
	@Test
	public void testsortShakerFIO() {
		System.out.println("shakersort at FIO");
		Sorter sorter = new ShakerSorter();
		Person p1 = new Person(1, "surnameb name", "female", "02/07/1968");
		Person p2 = new Person(2, "asurname name", "female", "11/10/2001");
		Person p3 = new Person(3, "surnamea name", "male", "11/09/2001");
		rep.add(p1);
		rep.add(p2);
		rep.add(p3);
		Repository expected = new Repository();
		expected.add(p2);
		expected.add(p3);
		expected.add(p1);
		rep.setSorter(sorter);
		rep.sort(new ComparePersonName());
		for (int i = 0; i < expected.getCount(); i++) {
			System.out.println(expected.get(i).print() + "  <=>  " + rep.get(i).print());
		}
		System.out.println("");
	}
	
	/**
	 * test shaker sort by Birthday
	 */
	@Test
	public void testsortShakerBirthday() {
		System.out.println("shakersort at birthday");
		Sorter sorter = new ShakerSorter();
		Person p1 = new Person(1, "surnameb name", "female", "02/07/1968");
		Person p2 = new Person(2, "asurname name", "female", "07/10/2001");
		Person p3 = new Person(3, "surnamea name", "male", "11/09/2000");
		rep.add(p1);
		rep.add(p2);
		rep.add(p3);
		Repository expected = new Repository();
		expected.add(p1);
		expected.add(p2);
		expected.add(p3);
		rep.setSorter(sorter);
		rep.sort(new ComparePersonBirthday());
		for (int i = 0; i < expected.getCount(); i++) {
			System.out.println(expected.get(i).print() + "  <=>  " + rep.get(i).print());
		}
		System.out.println("");
	}
	
	/**
	 * test shaker sort by Age
	 */
	@Test
	public void testsortShakerAge() {
		System.out.println("shakesort at age");
		Sorter sorter = new ShakerSorter();
		Person p1 = new Person(1, "surnameb name", "female", "02/07/1968");
		Person p2 = new Person(2, "asurname name", "female", "11/10/2000");
		Person p3 = new Person(3, "surnamea name", "male", "11/09/2001");
		rep.add(p1);
		rep.add(p2);
		rep.add(p3);
		Repository expected = new Repository();
		expected.add(p3);
		expected.add(p2);
		expected.add(p1);
		rep.setSorter(sorter);
		rep.sort(new ComparePersonAge());
		for (int i = 0; i < expected.getCount(); i++) {
			System.out.println(expected.get(i).print() + "  <=>  " + rep.get(i).print());
		}
		System.out.println("");
	}
	
	/**
	 * test insert sort by FIO
	 */
	@Test
	public void testsortInsertFIO() {
		System.out.println("insertsort at FIO");
		Sorter sorter = new InsertSorter();
		Person p1 = new Person(1, "surnameb name", "female", "02/07/1968");
		Person p2 = new Person(2, "asurname name", "female", "11/10/2001");
		Person p3 = new Person(3, "surnamea name", "male", "11/09/2001");
		rep.add(p1);
		rep.add(p2);
		rep.add(p3);
		Repository expected = new Repository();
		expected.add(p2);
		expected.add(p3);
		expected.add(p1);
		rep.setSorter(sorter);
		rep.sort(new ComparePersonName());
		for (int i = 0; i < expected.getCount(); i++) {
			System.out.println(expected.get(i).print() + "  <=>  " + rep.get(i).print());
		}
		System.out.println("");
	}
	
	/**
	 * test insert sort by Birthday
	 */
	@Test
	public void testsortInsertBirthday() {
		System.out.println("insertsort at birthday");
		Sorter sorter = new InsertSorter();
		Person p1 = new Person(1, "surnameb name", "female", "02/07/1968");
		Person p2 = new Person(2, "asurname name", "female", "07/10/2001");
		Person p3 = new Person(3, "surnamea name", "male", "11/09/2000");
		rep.add(p1);
		rep.add(p2);
		rep.add(p3);
		Repository expected = new Repository();
		expected.add(p1);
		expected.add(p2);
		expected.add(p3);
		rep.setSorter(sorter);
		rep.sort(new ComparePersonBirthday());
		for (int i = 0; i < expected.getCount(); i++) {
			System.out.println(expected.get(i).print() + "  <=>  " + rep.get(i).print());
		}
		System.out.println("");
	}
	
	/**
	 * test insert sort by Age
	 */
	@Test
	public void testsortInsertAge() {
		System.out.println("insertsort at age");
		Sorter sorter = new InsertSorter();
		Person p1 = new Person(1, "surnameb name", "female", "02/07/1968");
		Person p2 = new Person(2, "asurname name", "female", "11/10/2001");
		Person p3 = new Person(3, "surnamea name", "male", "11/09/2000");
		rep.add(p1);
		rep.add(p2);
		rep.add(p3);
		Repository expected = new Repository();
		expected.add(p2);
		expected.add(p3);
		expected.add(p1);
		rep.setSorter(sorter);
		rep.sort(new ComparePersonAge());
		for (int i = 0; i < expected.getCount(); i++) {
			System.out.println(expected.get(i).print() + "  <=>  " + rep.get(i).print());
		}
		System.out.println("");
	}
}
