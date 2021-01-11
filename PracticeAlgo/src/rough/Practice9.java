package rough;

public class Practice9 {
	public static void ugly(int n) {

		int ugly2=2;
		int ugly3=3;
		int ugly5=5;
		int arr[]= new int[n];
		
		int j=2;
		int a1=0;
		int b1=0;
		int c1=0;
		arr[0]=1;
		for(int i=1;i<n;i++)
		{
			int max= Math.min(ugly2, Math.min(ugly3, ugly5));
			arr[i]=max;
			if(max%ugly2==0)
			{
				a1++;
				ugly2=a1*2;
			}
			 if(i%ugly3==0)
			{
				 b1++;
					ugly3=b1*3;
			}
			 if(i%ugly5==0)
			{
				c1++;
				
				ugly5=c1*5;
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
	}
	public static void main(String[] args) {
		ugly(15);
	}
}