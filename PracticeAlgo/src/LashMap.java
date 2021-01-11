

import java.util.ArrayList;
import java.util.LinkedList;

public class LashMap<K, V> {
	class Map {
		K key;
		V value;

		public Map() {
			// TODO Auto-generated constructor stub
		}

		public Map(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}
	}

	LinkedList<Map>[] arr;
	static int count;

	public LashMap() {
		count = 0;
		init(4);

	}

	private void init(int i) {
		arr = new LinkedList[i];
		for (int j = 0; j < i; j++) {
			arr[i].add(new Map());
		}

	}

	void push(K key, V value) {
		int bucket = findbucket(key);
		int find = getvalue(bucket, value);
		if (find == -1) {
			arr[bucket].add(new Map(key, value));
			count++;
		} else {
			arr[bucket].add(new Map(key, value));
		}
		int lf = arr.length / count;
		if (lf > 1) {
			rotate();
		}
	}

	private void rotate() {
		int size = arr.length;
		init(size * 2);
		LinkedList<Map>[] temp = arr;
		for (int i = 0; i < temp.length; i++) {
			LinkedList<LashMap<K, V>.Map> arrayList = temp[i];
			for (int j = 0; j < arrayList.size(); j++) {
				LashMap<K, V>.Map map = arrayList.get(j);
				push(map.key, map.value);

			}

		}

	}

	private int getvalue(int bucket, V value) {

		int size = -1;
		for (Map it : arr[bucket]) {
			if (it.value == value) {
				return size;
			}
			size++;
		}

		return size;
	}

	private int findbucket(K key) {
		int v = key.hashCode() % arr.length;
		return v;
	}

}
