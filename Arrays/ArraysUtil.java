
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
	public static int[] removeOdds(int arr[])
	{
		int evenCount = 0;
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] % 2 == 0)
			{
				evenCount++;
			}
		}
		int result[] = new int[evenCount];
		int idx = 0;
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] % 2 == 0)
			{
				result[idx] = arr[i];
				idx++;
			}
		}
		return result;
	}
	public void reverseArray(int arr[], int start, int end)
	{
		while(start < end)
		{
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	public int findMininum(int arr[])
	{
		int min = arr[0];
		for(int i = 1; i < arr.length; i++)
		{
			if(arr[i] < min)
			{
				min = arr[i];
			}
		}
		return min;
	}
	public int findMaximum(int arr[])
	{
		int max = arr[0];
		for(int i = 1; i < arr.length; i++)
		{
			if(arr[i] > max)
			{
				max = arr[i];
			}
		}
		return max;
	}
	public static void main(String args[])
	{
		int myArray[] = new int[]{1,2,45,0,0,32,0,4,59,6,70,3};
		ArraysUtil arrUtil = new ArraysUtil();
		
		//Print an Array
		System.out.println("Array:");
		arrUtil.printArray(myArray);

		// Remove Even numbers from an Array
		System.out.println("Odd Array");
		int oddArray[] = arrUtil.removeEven(myArray);
		arrUtil.printArray(oddArray);

		// Remove Odds numbers from an Array
		System.out.println("Even Array");
		int eveArray[] = arrUtil.removeOdds(myArray);
		arrUtil.printArray(eveArray);

		//Reverse the Array
		System.out.println("Array in Reverse Order");
		arrUtil.reverseArray(myArray, 0, myArray.length -1);
		arrUtil.printArray(myArray);

		//Find the Mininum number of an Array
		System.out.println("Array Mininum Number");
		int min = arrUtil.findMininum(myArray);
		System.out.println(min);

		//Find the Maximum number of an Array
		System.out.println("Array Maximum Number");
		int max = arrUtil.findMaximum(myArray);
		System.out.println(max);
		

		
	}
}
