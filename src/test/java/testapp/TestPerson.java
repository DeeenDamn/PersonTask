package testapp;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import PersonTask.Person.Person;

/**
 * tests for Person class
 * @author Kravchenko Denis
 */
public class TestPerson {
	private Person pers;
	
	/**
	 * function which work before every @Test
	 */
	@Before
	public void begin() {
		pers = new Person(100, "a", "male", "01/01/1890");
	}
	
	/**
	 * function which work after every @Test
	 */
	@After
	public void end() {
		pers = null;
	}	
	
	/**
	 * test for getAge
	 */
	@Test
	public void testAge() {
		int actual = pers.getAge();
		int expected = 128;
		assertEquals(actual, expected);
	}
	
	/**
	 * test for getBirtday
	 */
	@Test 
	public void testBirthday() {
		String actual = pers.getBirthday();
		String expected = "01.01.1890"; 
		assertEquals(actual, expected);
	}
}
