import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class CodeBix {
	static ArrayList<ArrayList<Integer>> ar = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) {

		getvalue(new int [] {2,1,3,5,4,2});
	
	}

	static void getvalue(int arr[]) {
		int i = 0;
		while (i < arr.length) {
			if (arr[i] - 1 != i) {
				int value = arr[i] - 1;
				int temp = arr[i];
				arr[i] = arr[value];
				arr[value] = temp;
			}
			i++;
		}
		for(int j=0;j<arr.length;j++)
		{
			if(arr[j]-1!=j)
			{
				System.out.println(arr[j]);
			}
		}
		Arrays.stream(arr).forEach(a->System.out.print(a+" "));
	}

	static int subarraySum(int num[], int k) {
		TreeMap<Integer, TreeValue> tree = new TreeMap<Integer, TreeValue>((a, b) -> {

			return 0;
		});
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		hashmap.put(0, -1);
		int sum = 0;
		int count = 0;
		for (int i = 0; i < num.length; i++) {
			sum = sum + num[i];
			if (hashmap.containsKey(sum - k)) {
				count = count + 1;
				hashmap.put(sum, i);
			} else
				hashmap.put(sum, i);
		}
		return count;
	}
}
