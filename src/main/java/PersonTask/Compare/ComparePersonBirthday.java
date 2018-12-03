package PersonTask.Compare;

import java.util.Comparator;

import PersonTask.Person.Person;

public class ComparePersonBirthday implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2) {
		return p1.getBirthday().compareTo(p2.getBirthday());
	}
	
	
	

}
