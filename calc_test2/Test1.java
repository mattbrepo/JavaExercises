import java.util.*;

public class Test1
{
	private static int[] a = new int[10000];

	public static void main(String[] args)
	{
		boolean debug = false;
		long startTime = System.nanoTime();
		test1();
		verifyTest("test1", startTime, debug);

		a = new int[a.length];

		startTime = System.nanoTime();
		test2();
		verifyTest("test2", startTime, debug);
	}

	private static void verifyTest(String msg, long startTime, boolean debug)
	{
		long duration = (System.nanoTime() - startTime) / 1000;
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
			a[i] = 4*(i*i) + 3*i + 1;
	}

	private static void test2()
	{
		int c = 1;
		int k = 7;
		for (int i = 0; i < a.length - 1; i++)
		{
			a[i] = c;
			c = c + k;
			k = k + 8;
		}
		a[a.length - 1] = c;
	}
}