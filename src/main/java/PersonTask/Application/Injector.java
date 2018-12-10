/**
 * 
 */
package PersonTask.Application;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author DENIS
 *
 */
public class Injector{
	
	public void dosomething() {
		try {
			Class<?> r = Class.forName("Repository.Repository");
			Field[] field = r.getDeclaredFields();
			for (int i=0; i< field.length; i++) {
				Annotation[] an = field[i].getAnnotations();
				for(int j=0; j< an.length; j++) {
					if (an[j].equals("")) {
						
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
