
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
	public int secondMaximum(int arr[])
	{
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] > max)
			{
				secondMax = max;
				max = arr[i];
			}
			else if(arr[i] > secondMax && arr[i] != max)
			{
				secondMax = arr[i];
			}
		}
		return secondMax;
	}
	public void moveElements(int arr[], int l, int n)
	{
		int j = 0;
		for(int i = 0; i < l; i++)
		{
			if(arr[i] != n && arr[j] == n)
			{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			if(arr[j] != n)
			{
				j++;
			}
		}
	}
	public void expandArray_buggy(int arr[], int capacity)
	{
		int temp[] = new int[capacity];
		for(int i = 0; i < arr.length; i++)
		{
			temp[i] = arr[i];
		}
		arr = temp;
	}
	public int[] expandArray(int arr[], int capacity)
	{
		int temp[] = new int[capacity];
		for(int i = 0; i < arr.length; i++)
		{
			temp[i] = arr[i];
		}
		return temp;
	}
	public int findMisingNumber(int arr[])
	{
		int n = arr.length + 1;
		int sum = n * (n+1)/2;
		for(int i = 0; i < n - 1; i++)
		{
			sum -= arr[i];
		}
		return sum;
	}
	public boolean isPalindrome(String word)
	{
		char[] charArray = word.toCharArray();
		int start = 0;
		int end = word.length() -1;
		while(start < end)
		{
			if(charArray[start] != charArray[end])
			{
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	public static void main(String args[])
	{
		int myArray[] = new int[]{1,2,45,0,0,32,0,4,59,6,70,3};
		ArraysUtil arrUtil = new ArraysUtil();
		
		//Print an Array
		System.out.println("Array:");
		arrUtil.printArray(myArray);
		System.out.println();

		// Remove Even numbers from an Array
		System.out.println("Odd Array");
		int oddArray[] = arrUtil.removeEven(myArray);
		arrUtil.printArray(oddArray);
		System.out.println();

		// Remove Odds numbers from an Array
		System.out.println("Even Array");
		int eveArray[] = arrUtil.removeOdds(myArray);
		arrUtil.printArray(eveArray);
		System.out.println();

		//Reverse the Array
		System.out.println("Array in Reverse Order");
		arrUtil.reverseArray(myArray, 0, myArray.length -1);
		arrUtil.printArray(myArray);
		arrUtil.reverseArray(myArray, 0, myArray.length -1);
		arrUtil.printArray(myArray);
		System.out.println();

		//Find the Mininum number of an Array
		System.out.println("Array Mininum Number");
		int min = arrUtil.findMininum(myArray);
		System.out.println(min);
		System.out.println();

		//Find the Maximum number of an Array
		System.out.println("Array Maximum Number");
		int max = arrUtil.findMaximum(myArray);
		System.out.println(max);
		System.out.println();
		
		//Find the Maximum number of an Array
		System.out.println("Second Array Maximum Number");
		int secmax = arrUtil.secondMaximum(myArray);
		System.out.println(secmax);
		System.out.println();

		// Copy the Array To a new one
		//Move all Matching Elements to the end of an Array	
		int ntoMove = 0;
		System.out.println("Move all matching elements to the end of the Array");
		System.out.println("Move all zeros to the end of an Array");
		int copyArr[] = new int[myArray.length];
		for(int i = 0; i < myArray.length; i++)
		{
			copyArr[i] = myArray[i];
		}
		arrUtil.printArray(copyArr);
		arrUtil.moveElements(copyArr, copyArr.length, ntoMove);
		arrUtil.printArray(copyArr);
		System.out.println();

		// Resize an Array - Buggy (Garbage Collected as they call it here)
		// After exiting the function scope it is deleted
		int l_myArray= myArray.length;
		System.out.println("Size of the Array before expand: "+ l_myArray);
		arrUtil.expandArray_buggy(myArray, 20);
		l_myArray= myArray.length;
		System.out.println("Size of the Array after expand: "+ l_myArray);

		// Here we are returning the array so it keep its size
		l_myArray= myArray.length;
		System.out.println("Size of the Array before expand: "+ l_myArray);
		myArray = arrUtil.expandArray(myArray, 20);
		l_myArray= myArray.length;
		System.out.println("Size of the Array after expand: "+ l_myArray);

		//Finding the missing number of an array
		int newArray[] = new int[]{10,8,4,6,7,2,3,1,9};
		int mn = arrUtil.findMisingNumber(newArray);
		arrUtil.printArray(newArray);
		System.out.println("The missing number in the array is: "+ mn);

		// Check if a string is palindrome or not
		String pali = new String("examaxe");
		String notpali = new String("Examaxe");
		if(arrUtil.isPalindrome(pali) == true)
		{
			System.out.println(pali + " Is palindrome");
		}
		if(arrUtil.isPalindrome(notpali) != true)
		{
			System.out.println(notpali + " Is not palindrome");
		}
		
	}
}
