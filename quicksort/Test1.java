
public class Test1
{
	public static void main(String[] args)
	{
		int[] a = new int[] { 7, 3, 5, 1, 6, 11, 201, 4 };
		quickSort(a, 0, a.length - 1);
		
		System.out.println("result:");
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + ",");
		}
	}
	
	public static void quickSort(int[] a, int left, int right)
	{
		if (left >= right) return;
		int middle = quickSortPartition(a, left, right);
		quickSort(a, left, middle-1);
		quickSort(a, middle+1, right);
	}
	
	public static int quickSortPartition(int[] a, int left, int right)
	{
		int pivotIndex = right;
		int pivotValue = a[pivotIndex];
		int storeIndex = left;
		
		for(int i = left; i < right; i++)
		{
			if (a[i] < pivotValue)
			{
				if (i != storeIndex) 
				{
					int tmp = a[i];
					a[i] = a[storeIndex];
					a[storeIndex] = tmp;
				}
				storeIndex++;
			}
		}
		
		a[pivotIndex] = a[storeIndex];
		a[storeIndex] = pivotValue;
		return storeIndex;
	}
}