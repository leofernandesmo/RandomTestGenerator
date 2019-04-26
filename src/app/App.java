package app;

import java.lang.reflect.InvocationTargetException;

import domain.Foo;
import generator.Generator;

public class App {
	public static void main(String[] args) {
		try {
			Generator.generate(Foo.class, 5);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
