/**
 * 
 */
package PersonTask.Inject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import PersonTask.Person.Person;
import PersonTask.Repository.Repository;
import PersonTask.Sorter.BubbleSorter;
import PersonTask.Sorter.Sorter;

/**
 * class for setting fields
 * @author DENIS
 */
public class Injector{
	private static final Logger log = Logger.getLogger(Injector.class);


	/**
	 * function, which set sorter from config.properties
	 * @param instance of class contains sorter
	 */
	public void dosomething(Object obj) {
		log.info("set field with annotation @inject new value");
		Properties prop = new Properties();
			InputStream is;
			try {
				is = new FileInputStream("src/main/resources/config.properties");
				try {
					prop.load(is);
					Class<?> value;
					try {
						Class r = obj.getClass();
						Field[] field = r.getDeclaredFields();						
						for (int i=0; i< field.length; i++) {
							Annotation[] an = field[i].getAnnotations();
							if (field[i].isAnnotationPresent(Inject.class)) {
									value = Class.forName(prop.getProperty(field[i].getType().getName()));
									field[i].setAccessible(true); 
									try {
										field[i].set(obj, value.newInstance());
									} catch (Exception e) {
										log.error("can't set field " + field[i].getName() + " at " + value.getSimpleName());
										e.printStackTrace();
									} 
								}
						}
					} catch (ClassNotFoundException e) {
						log.error("class by name not found");
						e.printStackTrace();
					}
				} catch (IOException e) {
					log.error("can't load file");
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				log.error("config property not found");
				e.printStackTrace();
			}					
	}	
}
