package dynamicprogramming;

public class LongestSubsequenceAddition {

static	void subsquenceAdditon(int a[],int length)
	{
	int maximum=a[0];
	
	int b[]= new int[length];
	int add[]=a;
	for(int i=1;i<length;i++)
	{

		for(int j=0;j<i;j++)
		{
			if(a[i]>a[j] &&a[i]+add[j] >add[i])
			{
				add[i]=a[i]+add[j];
				maximum=Math.max(maximum, add[i]);
			}
			
			
		}
	}

System.out.println(maximum);
	}
	public static void main(String[] args) {
		int a[] = { 12,7,1,6,8};
		subsquenceAdditon(a,a.length);
	}
	
}
