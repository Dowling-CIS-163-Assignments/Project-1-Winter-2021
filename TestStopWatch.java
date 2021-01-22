package project1GIVE_TO_STUDENTS;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStopWatch {

	/**
	 * The following are simple random JUnit test cases...
	 * Create many, many more that shows that your code is functioning
	 * correctly.
	 */

	@Test
	public void testDefaultConstructor() {
		StopWatch s = new StopWatch();
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 0);
	}

	@Test
	public void testConstructor3Parameters() {
		StopWatch s = new StopWatch(2, 3, 4);
		assertTrue(s.getMinutes() == 2);
		assertTrue(s.getSeconds() == 3);
		assertTrue(s.getMilliseconds() == 4);
	}

	// Testing for an exception; can only test for 1 at a time;
	// no lines of code after "new StopWatch(-2, 3, 4);" will be run
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersNegMinute() {
		new StopWatch(-2, 3, 4);
	}

	// Testing for an exception; can only test for 1 at a time;
	// no lines of code after "new StopWatch(2, -3, 4);" will be run
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersNegSecond() {
		new StopWatch(2, -3, 4);
	}

	// Testing for an exception; can only test for 1 at a time;
	// no lines of code after "new StopWatch(2, 3, -4);" will be run
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersNegMillisecond() {
		new StopWatch(2, 3, -4);
	}

	// Testing for exceptions; testing all 3 at the same time
	@Test
	public void testConstructor3ParametersNegInput() {
		try {
			new StopWatch(-2, 3, 4);
		}
		catch (IllegalArgumentException e) {
			assertTrue(e != null);
		}

		try {
			new StopWatch(2, -3, 4);
		}
		catch (IllegalArgumentException e) {
			assertTrue(e != null);
		}

		try {
			new StopWatch(2, 3, -4);
		}
		catch (IllegalArgumentException e) {
			assertTrue(e != null);
		}
	}

	// Testing for an exception; no lines of code after
	// "new StopWatch(12,67,14);" will be run
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3LargeSecond() {
		new StopWatch(12,67,14);
	}

	@Test
	public void testToString() {
		StopWatch s = new StopWatch(5,10,300);
		assertEquals(s.toString(),"5:10:300");

		s = new StopWatch("20:10:8");
		assertEquals(s.toString(),"20:10:008");

		s = new StopWatch("20:8");
		assertEquals(s.toString(),"0:20:008");

		s = new StopWatch("8");
		assertEquals(s.toString(),"0:00:008");
	}

	// Testing for an exception; no lines of code after
	// "new Stopwatch(-2);" will be run
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor1ParameterNeg() {
		new StopWatch(-2);
	}

	// Testing for an exception; no lines of code after
	// "new Stopwatch("-59:-23");" will be run
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorString2ParameterAllNeg() {
		new StopWatch("-59:-23");
	}

	// Testing for an exception; no lines of code after
	// "new Stopwatch("2:-2");" will be run
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorString2ParameterNegMilli() {
		new StopWatch("2:-2");
	}

	// Testing for an exception; no lines of code after
	// "new Stopwatch("a");" will be run
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorString1ParameterAlphaInput() {
		new StopWatch("a");
	}

	@Test
	public void testAddInt() {
		StopWatch s = new StopWatch(5,59,300);
		s.add(2000);
		assertEquals (s.toString(),"6:01:300");
	}

	@Test
	public void testAddStopWatch() {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(2,2,300);
		s1.add(s2);
		assertEquals (s1.toString(),"8:01:600");
	}

	@Test
	public void testInc() {
		StopWatch s = new StopWatch("8:01:600");
		for (int i = 0; i < 60000; i++)
			s.inc();
		assertEquals (s.toString(),"9:01:600");
	}


	@Test
	public void testEquals() {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(6,01,200);
		StopWatch s3 = new StopWatch(5,59,300);

		assertFalse(s1.equals(s2));
		assertTrue (s1.equals(s3));
	}

	@Test
	public void testCompareTo() {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(6,01,200);
		StopWatch s3 = new StopWatch(5,50,200);
		StopWatch s4 = new StopWatch(5,59,300);

		assertTrue (s2.compareTo(s1) > 0);
		assertTrue (s3.compareTo(s1) < 0);
		assertTrue (s1.compareTo(s4) == 0);
	}

	@Test
	public void testLoadSave () {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(5,59,300);

		s1.save("file1");
		s1 = new StopWatch();  // resets to zero

		s1.load("file1");
		assertTrue(s1.equals(s2));
	}

	@Test
	public void testNoMutateOnSuspend() {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(5,59,300);

		StopWatch.setSuspend(true);
		s1.add(1000);
		assertTrue (s1.equals(s2));
		StopWatch.setSuspend(false);
	}
}