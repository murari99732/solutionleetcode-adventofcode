package rough;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Practice11 {

	public static void main(String[] args) {
		int[] arr = { 0, 0, 1, 1, 1, 1, 1, 2 };
		int a[] = { 1, 4, 4, 4, 5, 6, 7, 7, 8,2,3 };

		int k = 10;
		max(a, 3);

	}

	public static void shuffle(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			Random r = new Random();
			int d = r.nextInt(arr.length);
			int temp = arr[d];
			arr[d] = arr[i];
			arr[i] = temp;
		}
	}

	public static void max(int arr[], int k) {
		int start = 0;
		int max = 0;
		int end = 0;
		int sum = 0;
		while (end < arr.length) {

			sum = sum + arr[end];

			max = max = Math.max(sum, max);

			if (end - start + 1 == k) {

				sum = sum - arr[start];
				start++;
			}
			end++;
		}
		System.out.println(max);
	}

	public static void frequency1(List<Integer> list) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
		}
		Collections.sort(list, (a, b) -> {
			int f = map.get(a);
			int g = map.get(b);
			if (f != g) {
				return f - g;
			}
			return list.get(a) - list.get(b);
		});
		System.out.println(map);
	}

}