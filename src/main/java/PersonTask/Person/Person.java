package PersonTask.Person;

/**
 * Hello world!
 *
 */
import org.joda.time.*;

/**
 * @author DENIS
 *
 */
public class Person {
	private int id;
	private String FIO;
	private String sex;
	private LocalDate birthday;
	private int age;

	public void setId(int id){
		this.id = id;
    }
	
	public int getId(){
		return id;
	}

	public void setFIO(String name) {
		this.FIO = name;
	}
	
	public String getFIO() {
		return FIO;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getSex() {
		return sex;
	}
	
	private LocalDate StrToDate(String date) {
		String[] arr = date.split("/");
		return new LocalDate(Integer.parseInt(arr[2]), Integer.parseInt(arr[1]), Integer.parseInt(arr[0]));
	}
	
	public String getBirthday() {
		return this.birthday.toString("MM.dd.yyyy");
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void growUp() {
		int a = Years.yearsBetween(this.birthday, new LocalDate()).getYears();
		if (a > this.age) {
			this.age = a;
		}
	}
	
	public Person(int id, String name, String sex, String day) {
		this.id = id;
		this.FIO = name;
		this.sex = sex;
		this.birthday = StrToDate(day);
		this.age = Years.yearsBetween(this.birthday, new LocalDate()).getYears();
	}
}

