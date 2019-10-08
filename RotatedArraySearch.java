// Java implementation to search an element
// in a sorted and rotated array using
// single pass of Binary Search

public class RotatedArraySearch 
{

	public static int search(int arr[], int leftPointer, int rightPointer, int key)
	{
		if(leftPointer > rightPointer)
		{
			return -1;
		}
		
		int mid = (leftPointer + rightPointer) / 2;
		
		if(arr[mid] == key)
		{
			return mid;
		}
		
		if(arr[leftPointer] <= arr[mid])
		{
			if(key >= arr[leftPointer] && key <= arr[mid])
			{
				return search(arr, leftPointer, mid - 1, key);
			}
		}
		return search(arr, mid + 1, rightPointer, key);
	}
	
	public static void main(String[] args) 
	{
		int arr[] = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
		int n = arr.length;
		int key = 6;
		int index = search(arr, 0, n - 1, key);
		
		if(index != -1)
		{
			System.out.println("Index: " + index);
		}
		else
		{
			System.out.println("Key not found...");
		}
	}
}
