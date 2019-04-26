package domain;

public class Foo {
	
	public static double divide(int x, int y) {
		if(y == 0)
			throw new IllegalArgumentException();
		return x/y;
	}
}
