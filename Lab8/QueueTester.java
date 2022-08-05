import java.io.PrintStream;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class QueueTester {
	public static int score;
	public static PrintStream out;
	public static PrintStream err;
	public static int testNumber;
	
public static void main(String[] args)
{
	score = 0;
	out = System.out;
	err = System.out;
	testNumber = 1;
	addTest(8);  // Depends on toString
	removeTest(8);   // Depends on addTest
	peekTest(5);  // Depends on removeTest
	elementTest(5);  // Depends on removeTest
	clearTest(5);  // Depends on addTest
	sizeTest(5);   // Depends on removeTest and clearTest
	emptyTest(4);  // Depends on removeTest and clearTest
	
	out.println("The below score assumes correct submission and that you obtained full style points.  Your actual score may be up to 20 points fewer.");
	out.println("Completed " + (testNumber-1) + " out of " + (testNumber-1) + " Tests for a total score of: 40 (no crashes) + 20 (submission and style) + " + score + " (from tests) = " + (60+score));
	}

public static int addTest(int pnts)
{
	String result = "[Apple, Banana, Carrot, Durian]";
	Queue<String> s = new Queue<String>();
	try {
		s.add("Apple");
		s.add("Banana");
		s.add("Carrot");
		s.add("Durian");
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: addTest-");
		e.printStackTrace();
	}
	return eval(s, result, pnts, "add");
}

public static int elementTest(int pnts)
{
	Queue<String> q = new Queue<String>();
	String comment = "";
	try {
		boolean correct = true;
		try {
			q.element();
			comment = "Failed to throw NoSuchElementException when empty";
			correct = false;
		}
		catch(NoSuchElementException e) {
			
		}
		q.add("Apple");
		q.add("Banana");
		q.add("Carrot");
		q.add("Durian");
		String temp = q.element();
		if(!("Apple".equals(temp)))
		{
			comment = "Expected \"Apple\" but got \"" + temp + "\"";
			correct = false;
		}
		q.remove();
		temp = q.element();
		if(!("Banana".equals(temp)))
		{
			comment = "Expected \"Banana\" but got \"" + temp + "\"";
			correct = false;
		}
		return disp(correct, pnts, "element", comment);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: elementTest-");
		e.printStackTrace();
	}
	return disp(false, pnts, "element", comment);
	
}

public static int removeTest(int pnts)
{
	Queue<String> q = new Queue<String>();
	String comment = "";
	String result = "[Durian]";
	try {
		boolean correct = true;
		try {
			q.remove();
			comment = "Failed to throw NoSuchElementException when empty";
			correct = false;
		}
		catch(NoSuchElementException e) {
			
		}
		q.add("Apple");
		q.add("Banana");
		q.add("Carrot");
		q.add("Durian");
		String temp = q.remove();
		if(!("Apple".equals(temp)))
		{
			comment = "Expected \"Apple\" but got \"" + temp + "\"";
			correct = false;
		}
		q.remove();
		temp = q.remove();
		if(!("Carrot".equals(temp)))
		{
			comment = "Expected \"Carrot\" but got \"" + temp + "\"";
			correct = false;
		}
		if(!correct)
			return disp(correct, pnts, "remove", comment);
		return eval(q, result, pnts, "remove");
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: popTest-");
		e.printStackTrace();
	}
	return disp(false, pnts, "pop", comment);
}

public static int emptyTest(int pnts)
{
	String comment = "";
	Queue<String> q = new Queue<String>();
	try {
		boolean correct = true;
		if(!q.isEmpty())
		{
			correct = false;
			comment = "New stack isn't empty";
		}
	q.add("Apple");
		if(q.isEmpty())
		{
			correct = false;
			comment = "Filled stack is empty";
		}
		q.clear();
		if(!q.isEmpty())
		{
			correct = false;
			comment = "Cleared stack isn't empty";
		}
		q.add("Banana");
		q.remove();
		if(!q.isEmpty())
		{
			correct = false;
			comment = "Popped stack isn't empty";
		}
	return disp(correct, pnts, "empty", comment);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: emptyTest-");
		e.printStackTrace();
	}
	return disp(false, pnts, "empty", comment);
}

public static int sizeTest(int pnts)
{
	String comment = "";
	Queue<String> q = new Queue<String>();
	try {
		boolean correct = true;
	q.add("Apple");
	q.add("Banana");
	q.add("Carrot");
	q.add("Durian");
	q.remove();
	if(!(q.size() == 3))
	{
	correct = false;
	comment = "List of size 3 says it has a size of " + q.size();
	}
	q.clear();
	if(!(q.size() == 0))
	{
		correct = false;
		comment = "List of size 0 says it has a size of " + q.size() + " after clear";
	}
	return disp(correct, pnts, "size", comment);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: sizeTest-");
		e.printStackTrace();
	}
	return disp(false, pnts, "size", comment);
}

public static int clearTest(int pnts)
{
	String result = "[Carrot]";
	Queue<String> q = new Queue<String>();
	try {
	q.add("Apple");
	q.add("Banana");
	q.clear();
	q.add("Carrot");
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: clearTest-");
		e.printStackTrace();
	}
	return eval(q, result, pnts, "clear");
}


public static int peekTest(int pnts)
{
	Queue<String> q = new Queue<String>();
	String comment = "";
	try {
		boolean correct = true;
		try {
			String value = q.peek();
			if(value != null)
			{
				comment = "Failed to return null when peeking on empty queue.";
				correct = false;
			}
		}
		catch(NoSuchElementException e) {
			comment = "Threw NoSuchElementException instead of returning null when empty";
			correct = false;
		}
		catch(Exception e)
		{
			err.println("-ERROR IN: peekTest-");
			correct = false;
			e.printStackTrace();
		}
		q.add("Apple");
		q.add("Banana");
		q.add("Carrot");
		q.add("Durian");
		String temp = q.peek();
		if(!("Apple".equals(temp)))
		{
			comment = "Expected \"Apple\" but got \"" + temp + "\"";
			correct = false;
		}
		q.remove();
		temp = q.peek();
		if(!("Banana".equals(temp)))
		{
			comment = "Expected \"Banana\" but got \"" + temp + "\"";
			correct = false;
		}
		return disp(correct, pnts, "peek", comment);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: peekTest-");
		e.printStackTrace();
	}
	return disp(false, pnts, "peek", comment);
	
}

public static int eval(Queue<String> s, String result, int pnts, String test)
{
	testNumber++;
	try {
	boolean equal = result.equals(s.toString());
	String output = "TEST " + (testNumber-1) + ") " + test + " -> ";
	if(!equal)
		output += ">>>FAILURE<<< (" + "0/" + pnts + ")";
	else
		output += "---SUCCESS--- (" + pnts + "/" + pnts + ")";
	output += " EXPECTED: \"" + result + "\" == YOURS: \"" + s + "\"  ";
	out.println(output);
	if(equal)
	{
		score += pnts;
		return pnts;
	}
	else
		return 0;
	}
	catch(Exception e) {
		out.println("TEST " + (testNumber-1) + ") " + test + " -> " + ">>>FAILURE<<< (0/" + pnts + ") Error in evaluating String");
		return 0;
	}
}

public static int disp(boolean equal, int pnts, String test, String comment) {
	String output = "TEST " + testNumber + ") " + test + " -> ";
	if(!equal)
		output += ">>>FAILURE<<< (" + "0/" + pnts + ")";
	else
		output += "---SUCCESS--- (" + pnts + "/" + pnts + ")";
	output += " " + comment;
	out.println(output);
	testNumber++;
	if(equal)
	{
		score += pnts;
		return pnts;
	}
	else
		return 0;
}

}