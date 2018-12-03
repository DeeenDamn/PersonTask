package PersonTask.Checker;

import PersonTask.Person.Person;

public class PersonFIOChecker implements Checker {

	@Override
	public Boolean check(Person p, Object o) {
		return p.getFIO().equals(o);		
	}

}
