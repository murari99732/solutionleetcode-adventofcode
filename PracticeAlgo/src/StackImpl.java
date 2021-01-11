import java.util.ArrayList;
import java.util.Stack;

public class StackImpl<T> {
	ArrayList<T> a;
	int size;

	public StackImpl() {
		a = new ArrayList<T>();
		size = 0;
	}

	void push(T val) {

		a.add(val);
		size++;

	}

	T pop() {
		if (size == -1) {
			throw new RuntimeException();
		}
		T d = a.remove(size - 1);
		size--;
		return d;
	}

	void peek() {
		System.out.println(a.get(size - 1));
	}

	int size() {
		return size;
	}

}
