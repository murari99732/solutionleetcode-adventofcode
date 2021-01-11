package recursion;
//https://www.youtube.com/watch?v=6O9UQMG70xk&list=PL2P-bWJKKyMC_wsQf5-vA7vK5WBfsGerl&index=14

//Java file delete recursion
public class PatternRecurse {
	static void powerSum(int x) {
		if (x == 0) {
			return;
		}
			sum(x);
			System.out.println();
			powerSum(x-1);
		}

	
	static void sum(int s)
	{
		if(s==0)
		{
			return;
		}
		
		sum(s-1);
		System.out.print("# ");
			
	}

	public static void main(String[] args) {
		powerSum(8);
	}
}
