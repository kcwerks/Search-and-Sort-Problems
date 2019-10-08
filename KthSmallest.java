// Java program to find k'th smallest element
// in expected linear time...

public class KthSmallest 
{
	// Returns k'th smallest element in arr[l...r] using QuickSort.
	// Assumes all elements in array are distinct.
	public static int kthSmallest(int arr[], int leftPointer, int rightPointer, int k)
	{
		if(k > 0 && k <= rightPointer - leftPointer + 1)
		{
			int pos = randomPartition(arr, leftPointer, rightPointer);
			
			if(pos - leftPointer == k - 1)
			{
				return arr[pos];
			}
			
			if(pos - leftPointer > k - 1)
			{
				return kthSmallest(arr, leftPointer, pos - 1, k);
			}
			
			return kthSmallest(arr, pos + 1, rightPointer, k - pos + leftPointer - 1);
		}
		return Integer.MAX_VALUE;
	}
	
	public static void swap(int arr[], int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	// Standard partition for QuickSort. Considers the last element as pivot
	// and moves all smaller elements to left of it and greater elements 
	// to right.
	public static int partition(int arr[], int leftPointer, int rightPointer)
	{
		int x = arr[rightPointer], i = leftPointer;
		for(int j = leftPointer; j <= rightPointer - 1; j++)
		{
			if(arr[j] <= x)
			{
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, rightPointer);
		
		return i;
	}
	
	// Picks a random pivot element between leftPointer and rightPointer
	// and partitions around the randomly picked element.
	public static int randomPartition(int arr[], int leftPointer, int rightPointer)
	{
		int n = rightPointer - leftPointer + 1;
		int pivot = (int)(Math.random()) * (n - 1);
		swap(arr, leftPointer + pivot, rightPointer);
		return partition(arr, leftPointer, rightPointer);
	}
	
	public static void main(String[] args) 
	{
		int arr[] = {12, 3, 5, 7, 4, 19, 26};
		int n = arr.length, k = 3;
		System.out.println("K'th smallest element is: " + kthSmallest(arr, 0, n - 1, k));
	}
}
