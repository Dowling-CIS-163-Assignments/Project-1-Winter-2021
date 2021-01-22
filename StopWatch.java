package project1GIVE_TO_STUDENTS;

import java.io.*;
import java.util.Scanner;

/*****************************************************************
 *   class description...
 *
 * THIS IS JUST STARTING CODE, MUCH HAS TO BE CHANGED.
 *
 * @author
 * @version
 */

public class StopWatch  {


	private int minutes;
	private int seconds;
	private int milliseconds;

	private static boolean suspend = false;

	public StopWatch() {
		// TODO: finish code
	}

	/******************************************************************
	 *
	 *  A constructor that accepts a string as a parameter with the
	 *  following format: "1:21:300" where 1 indicates minutes, 21
	 *  indicates seconds,  and 300 indicates milliseconds.  OR
	 *  the format "15:200" where the 15 indicates seconds, and
	 *  200 indicates milliseconds, OR the format “300” where
	 *  300 indicates milliseconds
	 *
	 * @param startTime is the input string the represents
	 * the starting time
	 * @throws IllegalArgumentException when the input string
	 * does not match the proper format (see description above)
	 */

	public StopWatch(String startTime) {
		if (startTime == null)
			throw new IllegalArgumentException();

		//TODO: finish code
	}

	public StopWatch(int minutes, int seconds, int milliseconds) {
		if (minutes < 0) 
			throw new IllegalArgumentException("constuctor with 3 params");

		if (seconds < 0)
			throw new IllegalArgumentException();

		//TODO: finish code - check milliseconds 
		//TODO: assign input parameters to instance variables


	}

	public StopWatch(StopWatch stopWatch) {
		if (stopWatch == null)
			throw new IllegalArgumentException();

		this.minutes = stopWatch.minutes;
		this.seconds = stopWatch.seconds;
		this.milliseconds = stopWatch.milliseconds;
	}

	public StopWatch(int seconds, int milliseconds) {
		// TODO: finish logic
	}


	public StopWatch(int milliseconds) {
		// TODO: finish logic
	}

	public int getMinutes() {
		// TODO: finish logic. Return value is just a placeholder

		return 0;
	}

	public void setMinutes(int minutes) {
		// TODO: finish logic
	}

	public int getSeconds() {
		// TODO: finish logic. Return value is just a placeholder

		return 0;
	}

	public void setSeconds(int seconds) {
		// TODO: finish logic
	}

	public int getMilliseconds() {
		// TODO: finish logic. Return value is just a placeholder

		return 0;
	}

	public void setMilliseconds(int milliseconds) {
		// TODO: finish logic
	}

	public boolean equals(Object object) {
		// TODO: finish logic. Return value is just a placeholder

		return false;
	}

	public static boolean equals(StopWatch stopWatch1, StopWatch stopWatch2) {
		// TODO: finish logic. Return value is just a placeholder

		return false;
	}

	public int compareTo(StopWatch other) {
		if (other == null)
			throw new IllegalArgumentException();

		// TODO: finish logic. Return value is just a placeholder

		return 0;
	}

	private static int convertToMilli(StopWatch stopWatch) {
		if (stopWatch == null)
			throw new IllegalArgumentException();

		// TODO: convert the stopWatch passed as input parameter into
		// milliseconds

		// Return value is just a placeholder
		return 0;
	}

	private void convertToStopWatch(int tempMilliseconds) {		
		minutes = tempMilliseconds / 60000;
		tempMilliseconds %= 60000;

		seconds = tempMilliseconds / 1000;
		tempMilliseconds %= 1000;

		milliseconds = tempMilliseconds;
	}

	public void inc() {
		// TODO: finish logic
	}

	public void add(int milliseconds) {		
		// TODO: finish logic
	}

	public void add(StopWatch stopWatch) {
		// TODO: finish logic
	}

	public void dec() {
		// TODO: finish logic
	}

	public void sub(int milliseconds) {
		// TODO: finish logic
	}

	public void sub(StopWatch stopWatch) {
		// TODO: finish logic
	}

	public String toString() {
		// TODO: finish logic. Return value is just a placeholder

		return "";
	}

	public void save(String filename) {
		if (filename == null)
			throw new IllegalArgumentException();

		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));

			// TODO: finish - write fields to file
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			out.close();
		}
	}


	public void load(String filename)  {
		if (filename == null)
			throw new IllegalArgumentException();

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filename));

			// TODO: read fields into instance variables
		}
		catch (FileNotFoundException e) {
			throw new IllegalArgumentException();
		}
		finally {
			scanner.close();
		}
	}

	public static void setSuspend(boolean suspend) {
		// TODO: finish logic
	}

	public static boolean isSuspended() {
		// TODO: finish logic. Return value is just a placeholder

		return false;
	}
}