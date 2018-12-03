package PersonTask.Checker;

import PersonTask.Person.Person;

public class PersonBirthdayChecker implements Checker {

	@Override
	public Boolean check(Person p, Object o) {
		return p.getBirthday().equals(o);
	}

}
