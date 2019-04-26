package generator;

import java.lang.reflect.Parameter;
import java.util.Random;

public class RandomValue {

	public static Integer getAtRandom(final Parameter p){
		Random rand = new Random();
		if(p.getType() == int.class) {
			return rand.nextInt();
		}
		return null;
	}	
}
