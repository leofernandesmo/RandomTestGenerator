package domain;
import org.junit.Test;

import junit.framework.TestCase;

public class FooTest extends TestCase {

	@Test
	public void test0() {
		double value = Foo.divide(3, 2);
		assertEquals(1.0, value, 0.01D);
	}

	@Test
	public void test1() {
		try {
			Foo.divide(0, 0);
			fail("Expected exception");
		} catch (IllegalArgumentException iae) {
		}
	}
}
