package dynamicprogramming;

public class MinimumJump {

	static int minJumpsToReachTillEnd(int arr[], int length) {
	
		int d=0;
		 if(arr.length == 0) {
		      return -1;
		    }
		int b[]= new int[length];
		for(int i=0;i<length;i++)
		{
			b[i]=Integer.MAX_VALUE;
		}
		b[0]=0;
		for(int i=0;i<length-1;i++)
		{
			for(int j=i+1;j<=arr[i]+i && j<length;j++)
			{
				b[j]=Math.min(b[i]+1, b[j]);
				
				
			}
		}
		return b[length-1];
		
	}

	public static void main(String[] args) {
		 int[] arr = {1, 2, 1, 3, 2, 1, 2, 1};
		    
		    System.out.println(minJumpsToReachTillEnd(arr,arr.length));
	}
}
