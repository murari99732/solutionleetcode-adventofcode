package queueimpl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class QueueMinimum {

	static void nonrepeating(Queue<Character> queue) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Queue<Character> q = new LinkedList<Character>();
		
		while (!queue.isEmpty()) {
			char c = queue.remove();
			if (map.containsKey(c) ) {
				map.put(c, 1);
				if(!q.isEmpty())
				 q.remove();
				
			}
			else
			{
				map.put(c, map.getOrDefault(c, 0)+1);
				q.add(c);
			}

		}

	}

	public static void main(String[] args) {

	}

}
