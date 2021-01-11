package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class HeapFunctional {

	static Integer[] list = new Integer[10];
	static int size = 0;

	static void insert(int value) {
		list[size] = value;
		int parent = (size - 1) / 2;
		int val = size;
		while (parent >= 0 && list[parent] < list[val]) {
			int temp = list[parent];
			list[parent] = list[val];
			list[val] = temp;
			val = parent;
			parent = (val - 1) / 2;
		}
		size++;
	}

	static void kthsmallest(int arr[]) {
		PriorityQueue<Integer> p = new PriorityQueue<Integer>();
		for (int i = 0; i < 3; i++) {
			p.add(arr[i]);
		}
		for (int i = 3; i < arr.length; i++) {
			if (arr[i] > p.peek()) {
				p.poll();
				p.add(arr[i]);
			}

		}
		System.out.println(p.peek());
	}

	static PriorityQueue<Integer> pr = new PriorityQueue<Integer>();

	static void kthsmalleststream(int value) {
		if (pr.size() < 3) {
			pr.add(value);
		} else if (pr.size() == 3) {
			if (value < pr.peek()) {
				pr.remove();
				pr.add(value);
			}
		}
	}

	static class Cordinate {
		int x;
		int y;

		public Cordinate(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		int arr[] = new int[] { 2, 3, 6, 5, 6, 2, 6, 7, 8, 3, 4, 5, 6, 2, 9, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		Map<Integer, Integer> tree = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			tree.put(arr[i], tree.getOrDefault(arr[i], 0) + 1);
		}
		pr.addAll(tree.keySet());
		// pr.stream().sorted((a,b)->{return
		// tree.get(b)-tree.get(a);}).limit(3).forEach(a->System.out.print(a+" "));
	
		List<Cordinate> ar = Arrays.asList(new Cordinate(1, 4), new Cordinate(3, 5), new Cordinate(0, 4),
				new Cordinate(3, 5));
		ar.stream().map(a -> {
			Map<Cordinate, Integer> map = new HashMap<Cordinate, Integer>();
			int x = a.x * a.x;
			int y = a.y * a.y;
			map.put(new Cordinate(x, y), (int) Math.sqrt(x + y));

			return map;
		}).limit(1).forEach(b->System.out.println(b.entrySet().iterator().next().getValue()));
	//	System.out.println(list);

	}
	
	static void addvalue(int arr[])
	{
		PriorityQueue<Integer> pr= new PriorityQueue<Integer>();
		for(int i=0;i<arr.length;i++)
		{
			pr.add(arr[i]);
		}
		int sum=0;
		while(!pr.isEmpty())
		{
			int v=pr.poll();
			int m=pr.poll();
			int add=v+m;
			pr.add(add);
			sum=sum+add;
		}
	}

	static Map.Entry getheap(Map.Entry<Integer, Integer> map) {
		if (pr.size() <= 3) {
			pr.add(map.getKey());
			return map;
		} else {
			if (pr.size() > 3) {
				if (pr.peek() > map.getValue()) {
					pr.poll();
					pr.add(map.getValue());
					return map;
				}
			}
		}
		return null;

	}

}
