
public class BinarySearch 
{
	// Recursive implementation of binary search.
	public static int recursiveBinarySearch(int arr[], int leftPointer, int rightPointer, int x)
	{
		if(rightPointer >= 1)
		{
			int mid = leftPointer + (rightPointer - 1) / 2;
			
			if(arr[mid] == x)
			{
				return mid;
			}
			
			if(arr[mid] > x)
			{
				return recursiveBinarySearch(arr, leftPointer, mid - 1, x);
			}
			
			return recursiveBinarySearch(arr, mid + 1, rightPointer, x);
		}
		return -1;
	}
	
	// Conventional implementation of binary search.
	public static int binarySearch(int arr[], int x)
	{
		int leftPointer = 0;
		int rightPointer = arr.length - 1;
		
		while(leftPointer <= rightPointer)
		{
			int mid = leftPointer + (rightPointer - 1) / 2;
			
			if(arr[mid] == x)
			{
				return mid;
			}
			
			if(arr[mid] < x)
			{
				leftPointer = mid + 1;
			}
			
			else
			{
				rightPointer = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String args[])
	{
		int arr[] = {2, 3, 4, 10, 40};
		int n = arr.length;
		int x = 10;
		int result = recursiveBinarySearch(arr, 0, n -1, x);
		
		System.out.println("Recursive: ");
		
		if(result == -1)
		{
			System.out.println("Element not present.");
		}
		else
		{
			System.out.println("Element found at index: " + result);
		}
		
		System.out.println("Conventional: ");
		
		int result2 = binarySearch(arr, x);
		
		if(result2 == -1)
		{
			System.out.println("Element not present.");
		}
		else
		{
			System.out.println("Element found at index: " + result2);
		}
	}
}
