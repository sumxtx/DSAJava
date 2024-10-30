
public class ArraysUtil
{
	public void printArray(int arr[])
	{
		int n = arr.length;
		for(int i = 0; i < n; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static int[] removeEven(int arr[])
	{
		int oddCount = 0;
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] % 2 != 0)
			{
				oddCount++;
			}
		}
		int result[] = new int[oddCount];
		int idx = 0;
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] % 2 != 0)
			{
				result[idx] = arr[i];
				idx++;
			}
		}
		return result;
	}
	public static void main(String args[])
	{
		int myArray[] = new int[]{1,2,45,0,0,32,0,4,59,6,70,3};
		ArraysUtil arrUtil = new ArraysUtil();
		
		//Print an Array
		arrUtil.printArray(myArray);

		// Remove Even numbers from an Array
		int oddArray[] = arrUtil.removeEven(myArray);
		arrUtil.printArray(oddArray);

		
	}
}
