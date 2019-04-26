package generator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import domain.Foo;

public class Generator {

	public static void generate(final Class<?> klass, final int n)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (Method m : klass.getDeclaredMethods()) {
			for (int i = 0; i < n; i++) {
				List<Object> randomInputs = Arrays
						.asList(m.getParameters())
						.stream()
						.map(RandomValue::getAtRandom)
						.collect(Collectors.toList());
				Object res = m.invoke(null, randomInputs.toArray());
				List<String> parameters = randomInputs
						.stream()
						.map(Object::toString)
						.collect(Collectors.toList());
				outputJUnitTest(m, parameters, res, i);
			}
		}
	}

	private static void outputJUnitTest(final Method m, final List<String> randomInputs, final Object res, final int i) {
		System.out.println("@Test public void test" + i + "(){");
		System.out.println("assertEquals("+res+", "+m.getName()+"("+String.join(",", randomInputs)+"));)");
		System.out.println("}");
	}
	
	public static void main(final String[] args) throws Exception {
		Generator.generate(Foo.class, 10);
	}

}
