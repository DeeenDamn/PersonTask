package PersonTask.Person;

import org.apache.log4j.Logger;
import org.joda.time.*;

/**
 * Class Person with fields: id, FIO, sex, Birthday and age
 * @author Kravchenko Denis
 */
public class Person {
	/**
	 * fields
	 */
	private int id;
	private String FIO;
	private String sex;
	private LocalDate birthday;
	private static final Logger log = Logger.getLogger(Person.class);
	
	/**
	 * set field id
	 * @param id
	 */
	public void setId(int id){
		log.debug("get Person's id");
		this.id = id;
    }
	
	/**
	 * get field id
	 * @return id
	 */
	public int getId(){
		log.debug("set Person's id");
		return id;
	}
	
	/**
	 * set field FIO
	 * @param name
	 */
	public void setFIO(String name) {
		log.debug("set Person's FIO");
		this.FIO = name;
	}
	
	/**
	 * get field FIO
	 * @return FIO
	 */
	public String getFIO() {
		log.debug("get Person's FIO");
		return FIO;
	}
	
	/**
	 * set field Sex
	 * @param sex
	 */
	public void setSex(String sex) {
		log.debug("set Person's sex");
		this.sex = sex;
	}
	
	/**
	 * get field sex
	 * @return sex
	 */
	public String getSex() {
		log.debug("get Person's sex");
		return sex;
	}
	
	/**
	 * set field birthday
	 * @param date (String)
	 * @return Birthday (LocalDate)
	 */
	private LocalDate StrToDate(String date) {
		log.debug("convert birthday to String");
		String[] arr = date.split("/");
		return new LocalDate(Integer.parseInt(arr[2]), Integer.parseInt(arr[1]), Integer.parseInt(arr[0]));
	}
	
	/**
	 * get field Birthday
	 * @return Birthday
	 */
	public String getBirthday() {
		log.debug("get Person's birthday");
		return this.birthday.toString("dd.MM.yyyy");
	}
	
	/**
	 * get age by Birthday//надо было исправить
	 * @return age
	 */
	public int getAge() {
		log.debug("get Person's age");
		return Years.yearsBetween(this.birthday, new LocalDate()).getYears();
	}

	/**
	 * constructor Person
	 * @param id
	 * @param name
	 * @param sex
	 * @param day
	 */
	public Person(int id, String name, String sex, String day) {
		log.debug("init Person");
		this.id = id;
		this.FIO = name;
		this.sex = sex;
		this.birthday = StrToDate(day);
	}
	
	/**
	 * function, which print Person's fields
	 * @return string
	 */
	public String print() {
		log.debug("print Person " + getId() + " " + getFIO());
		return getId() + " " + getFIO() + " " + getSex() + " " + getAge() + " " + getBirthday();
	}
}

