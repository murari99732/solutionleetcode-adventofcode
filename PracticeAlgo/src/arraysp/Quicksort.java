package arraysp;

public class Quicksort {
	public static void quicksort(int arr[], int start, int  end) {
		if(start<end)
		{
			int pivot=start;
			int i=start;
			int j=end;
			while(i<j)
			{
				while(arr[pivot]>arr[i])
				{
					i++;
				}
				while(arr[pivot]<arr[j])
				{
					j--;
				}
				if(i<j)
				{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			if(j<i)
			{
				int temp=arr[pivot];
				arr[pivot]=arr[j];
				arr[j]=temp;
			}
			quicksort(arr,start,j-1);
			quicksort(arr, j+1, end);
		}
	
	}

	public static void main(String[] args) {
		 int arr[] = { 12, 8, 30, 6, 15, 2, 1, 18 };

		    System.out.print("Input: ");
		    for (int i = 0; i < arr.length; i++) {
		      System.out.print(arr[i] + " ");
		    }

		quicksort(arr, 0, arr.length - 1);

		    System.out.println();

		    System.out.print("Output: ");
		    for (int i = 0; i < arr.length; i++) {
		      System.out.print(arr[i] + " ");
		    }
	}

}
