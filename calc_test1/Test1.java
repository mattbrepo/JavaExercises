import java.util.*;

public class Test1
{
	private static int[] a = new int[10];

	public static void main(String[] args)
	{
		boolean debug = true;
		long startTime = System.nanoTime();
		test1();
		verifyTest("test1", startTime, debug);
		startTime = System.nanoTime();
		test2();
		verifyTest("test2", startTime, debug);
	}

	private static void verifyTest(String msg, long startTime, boolean debug)
	{
		long duration = (System.nanoTime() - startTime);
		String dataMsg = "";
		if (debug) 
		{
			dataMsg = "\n";
			for (int i = 0; i < a.length; i++)
				dataMsg += a[i] + ", ";
		}

		System.out.println("--- " + msg + dataMsg + "\n--- time: " + duration + "\n");
	}

	private static void test1()
	{
		for (int i = 0; i < a.length; i++)
			a[i] = i*i*i;
	}

	private static void test2()
	{
	  int i = 0;
		int c = 0;
		int k = 1;
		int m = 6;
		while (i < a.length)
		{
			a[i] = c;
			c = c + k;
			k = k + m;
			m = m + 6;
			i = i + 1;
		}
	}
}