package PersonTask.Person;

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
	private int age;
	
	/**
	 * set field id
	 * @param id
	 */
	public void setId(int id){
		this.id = id;
    }
	
	/**
	 * get field id
	 * @return id
	 */
	public int getId(){
		return id;
	}
	
	/**
	 * set field FIO
	 * @param name
	 */
	public void setFIO(String name) {
		this.FIO = name;
	}
	
	/**
	 * get field FIO
	 * @return FIO
	 */
	public String getFIO() {
		return FIO;
	}
	
	/**
	 * set field Sex
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	/**
	 * get field sex
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}
	
	/**
	 * set field birthday
	 * @param date (String)
	 * @return Birthday (LocalDate)
	 */
	private LocalDate StrToDate(String date) {
		String[] arr = date.split("/");
		return new LocalDate(Integer.parseInt(arr[2]), Integer.parseInt(arr[1]), Integer.parseInt(arr[0]));
	}
	
	/**
	 * get field Birthday
	 * @return Birthday
	 */
	public String getBirthday() {
		return this.birthday.toString("MM.dd.yyyy");
	}
	
	/**
	 * get field age
	 * @return age
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * update field age 
	 */
	public void growUp() {
		int a = Years.yearsBetween(this.birthday, new LocalDate()).getYears();
		if (a > this.age) {
			this.age = a;
		}
	}
	
	/**
	 * constructor Person
	 * @param id
	 * @param name
	 * @param sex
	 * @param day
	 */
	public Person(int id, String name, String sex, String day) {
		this.id = id;
		this.FIO = name;
		this.sex = sex;
		this.birthday = StrToDate(day);
		this.age = Years.yearsBetween(this.birthday, new LocalDate()).getYears();
	}
}

