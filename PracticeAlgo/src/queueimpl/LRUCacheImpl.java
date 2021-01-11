package queueimpl;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Cache {
	int key;
	String value;
}

public class LRUCacheImpl {
	static Map<Integer, Cache> map = new HashMap<>();
	static Deque<Cache> deque = new LinkedList<Cache>();

	static Cache getValue(int value) {
		if (map.get(value) != null) {
			deque.remove(map.get(value));
			deque.addFirst(map.get(value));

			return map.get(value);

		}
		return null;

	}

	static void insertValue(Cache cache) {
		if (map.size() == 3 && !map.containsKey(cache.key)) {
			map.remove(deque.removeLast());
			deque.addFirst(cache);
			map.put(cache.key, cache);
		} else {
			if (map.containsKey(cache.key)) {
				deque.remove(map.get(cache.key));
				deque.addFirst(cache);
				map.put(cache.key, cache);
			}
		}
	}

	public static void main(String[] args) {

	}

}
