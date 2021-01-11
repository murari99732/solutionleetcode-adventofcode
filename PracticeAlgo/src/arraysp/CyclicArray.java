package arraysp;

public class CyclicArray {

	public static void cyclic(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			int fastforward=i;
			int slowward=i;
			while(true)
			{
				slowward=move(arr, i);
				fastforward=move(arr,i);
				fastforward=move(arr,i);
				if(slowward<0)
				{
					break;
				}
				if(fastforward==slowward)
				{
					System.out.println("");
				
				}
				
			}
		}
	}
	private static int move(int[] arr, int i) {
	int index=i+arr[i];
	if(index>arr.length)
	{
		index=index%arr.length;
	}
	if(i%arr.length==i)
	{
		return -1;
	}
	return index;
	}
	public static void main(String[] args) {
		 int[] arr = {4, 1, 2, 1};

		 cyclic(arr);
	}
}
