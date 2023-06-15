import java.util.*;

public class Test1
{
	public static void main(String[] args)
	{
		//int[] a = new int[] { 1, 7, 21, 15, 3, 2 };
		int[] a = new int[10];
		for(int i=0; i<a.length; i++)
			a[a.length - i - 1]=i;

		printArray("pre", a);
		int loopCounter = insertionSort(a);
		printArray("post", a);
		System.out.println("loopCounter: " + loopCounter);
	}

	private static int insertionSort(int[] a)
	{
		int loopCounter = 0;
		for(int j=1; j < a.length; j++)
		{
			//loopCounter++;
			int key = a[j];
			int i = j - 1;
			while (i >= 0 && a[i] > key)
			{
				loopCounter++;
				a[i+1]=a[i];
				i--;
			}
			a[i+1]=key;
		}

		return loopCounter++;
	}

	private static void printArray(String msg, int[] a)
	{
		String dataMsg = "";
		for (int i = 0; i < a.length; i++)
			dataMsg += a[i] + ", ";

		System.out.println("---" + msg);
		System.out.println(dataMsg);
	}
}