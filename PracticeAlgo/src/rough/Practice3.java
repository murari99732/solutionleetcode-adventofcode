package rough;


class Practice3 {
    public static void prime(int n)
    {
      int ugly []= new int[n];
      int ugly2=2;
      int ugly3=3;
      int ugly5=5;
      int ugltnext=1;
      ugly[0]=1;
      for(int i=0;i<n;i++)
      {
    	  ugltnext=Math.min(ugly2, Math.min(ugly3,ugly5));
    	  ugly[i]=ugltnext;
    	  if(ugly[i]%2==0)
    	  {
    		  
    	  }
    	  if(ugly[i]%3==0)
    	  {
    		  
    	  }
    	  if(ugly[i]%5==0)
    	  {
    		  
    	  }
      }
    }
	public static void main (String[] args) {
	//	System.out.println(prime(12));
	}
}