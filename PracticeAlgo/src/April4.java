package practice;

import java.util.LinkedList;
import java.util.*;

public class April4 {
    public static final int FIVE_SECONDS = 5000;
    public static final int MAX_Y = 400;
    public static final int MAX_X = 400;
    static HashMap<Integer, Value> map = new HashMap<>();
    static ArrayDeque<Value> queue = new ArrayDeque<>();
    static Stack<Integer> st = new Stack<>();
    static Stack<Integer> tp = new Stack<>();
    static int arr[] = new int[10];
    static int s1 = 0;
    static int s2 = arr.length - 1;
    static Generic root = new Generic();
    static int count = 0;

    static void pop1() {
        if (s1 == 0) {
            System.out.println("sorry full");
            return;
        } else {
            System.out.println(arr[s1--] + "  ");

        }
    }

    static void pop2() {
        if (s2 == arr.length) {
            System.out.println("sorry full");
            return;
        } else {
            System.out.println(arr[s2++] + "  ");

        }
    }

    static void pushs1(int v) {

        if (s1 == s2 && s1 >= arr.length) {
            System.out.println("sorry full");
            return;
        } else {
            arr[s1++] = v;
        }
    }

    static void pushs2(int v) {

        if (s1 == s2 && s2 < 0) {
            System.out.println("sorry full");
            return;
        } else {
            arr[s2--] = v;
        }
    }

    static void pushval(int arr[]) {
        Stack<Generic> st = new Stack<>();
        Generic root;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Generic n = new Generic();
                n.data = arr[i];
                if (st.size() > 0) {
                    st.peek().arrayList.add(n);
                    st.push(n);
                } else {
                    root = n;
                }
            }
        }
    }

    static void display(Generic root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        for (Generic it : root.arrayList) {
            display(it);
        }
    }

    static int size(Generic tree) {
        if (tree == null) {
            return 0;
        }
        int max = 0;
        for (Generic it : tree.arrayList) {
            max = Math.max(max, size(it));
        }
        return max + 1;
    }

    static int getsize(Linking list) {
        if (list == null) {
            return 0;
        }
        int v = getsize(list) + 1;
        return v;
    }

    static boolean find(Linking list) {
        if (list == null) {
            return false;
        }
        if (list.data == 2) {
            return true;
        }
        return find(list.next);
    }

    static void rotate(Linking list, int v) {
        Linking head = list;
        while (head != null && v != 0) {
            head = head.next;
            v--;
        }
        Linking tail = list.next;
        list.next = null;
        tail.next = head;

    }

    static Linking recursive(Linking list) {
        if (list == null || list.next == null) {
            return list;
        }
        Linking root = recursive(list.next);
        list.next.next = list;
        list.next = null;
        return root;
    }

    static Linking middle(Linking list) {
        Linking slow = list;
        Linking fast = list;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return list;

    }

    static Linking sort(Linking list) {
        Linking mid = middle(list);
        Linking next = mid.next;
        mid.next = null;
        return mergesortvale(sort(mid), sort(next));
    }

    static Linking mergesortvale(Linking first, Linking second) {
        Linking root = null;
        Linking shoot = null;
        while (first != null && second != null) {
            if (first.data > second.data) {
                shoot.next = second;
                shoot = shoot.next;
                second = second.next;
            } else if (first.data < second.data) {
                shoot.next = second;
                shoot = shoot.next;
                first = first.next;
            }
        }
        return root.next;
    }

    static void removeduplicate(Linking list) {
        Linking temp = list;
        while (true) {
            int data = list.data;
            while (list.data == data) {
                list = list.next;
            }
            temp.next = list;
            list = list.next;
        }
    }

    public static void main(String... args) throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        ListIterator<Integer> listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.add(23);
        }

    }

    static void putvalue(ArrayList<App.Edge>[] arrayLists) {
        boolean b[] = new boolean[arrayLists.length];
        Queue<Shoot> q = new LinkedList<>();
        q.add(new Shoot(0, 0));
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Shoot poll = q.poll();
            if (poll.src == 1) {
                min = Math.min(min, poll.weight);
            }
            b[poll.src] = true;
            for (App.Edge it : arrayLists[poll.src]) {
                if (b[it.dy] == false) {
                    q.add(new Shoot(it.dy, poll.weight + it.weight));
                }
            }
        }

    }

    static void putvalue1(ArrayList<App.Edge>[] arrayLists) {
        boolean b[] = new boolean[arrayLists.length];
        PriorityQueue<Shoot> q = new PriorityQueue<>((a, c) -> a.weight - c.weight);
        q.add(new Shoot(0, 0));
        while (!q.isEmpty()) {
            Shoot poll = q.poll();
            if (poll.src == 1) {
                System.out.println(poll.weight);
                break;
            }
            b[poll.src] = true;
            for (App.Edge it : arrayLists[poll.src]) {
                if (b[it.dy] == false) {
                    q.add(new Shoot(it.dy, poll.weight + it.weight));
                }
            }
        }

    }

    static void push(int arr[]) {
        Queue<Integer> q = new LinkedList<>();
        int i = 0;
        while (i < arr.length) {
            if (q.size() == 0) {
                System.out.println(arr[i]);
                q.add(arr[i]);
            } else if (q.contains(arr[i])) {
                q.remove(arr[i]);
                if (!q.isEmpty()) {
                    System.out.println(q.peek());
                } else {
                    System.out.println(-1);
                }
            } else if (!q.contains(arr[i])) {
                q.add(arr[i]);
                System.out.println(q.peek());
            }
            i++;
        }
    }

    static void insert(int key, Value value) {
        if (map.containsKey(key)) {
            Value value1 = map.get(key);
            map.remove(value1);
            queue.remove(value1);
            map.put(key, value);
            queue.addFirst(value);
        } else if (!map.containsKey(key)) {
            if (queue.size() == 3) {
                queue.removeLast();
                queue.addFirst(value);
                map.put(key, value);
            } else {
                queue.addFirst(value);
                map.put(key, value);
            }

        }

    }

    static void getmap(int key) {
        if (map.containsKey(key)) {
            Value value = map.get(key);
            queue.remove(value);
            queue.addFirst(value);
        } else {

        }

    }

    static void push(int val) {
        if (!st.isEmpty()) {
            st.push(val);
        } else if (!tp.isEmpty()) {
            tp.push(val);
        } else {
            st.push(val);
        }
    }

    static void pop() {
        if (!st.isEmpty()) {
            while (st.size() > 1) {
                tp.push(st.pop());
            }
            System.out.println(st.pop());
        } else if (!tp.isEmpty()) {
            while (tp.size() > 1) {
                st.push(tp.pop());
            }
            System.out.println(tp.pop());
        }
    }

    static void duplicate(String word) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> tack = new Stack<>();
        int i = 0;
        boolean flag = true;
        while (i < word.length()) {
            char c = word.charAt(i);
            if (c == '(') {
                stack.push(c);
                flag = true;
            } else if (c == ')') {

                if (st.peek() == '(' && flag == false) {
                    return;
                }

                while (!st.isEmpty() && st.peek() != '(') {
                    st.pop();
                }
                st.pop();
                flag = false;

            } else if (!Character.isAlphabetic(c) && !Character.isDigit(c)) {
                stack.push(c);
                flag = true;
            }

        }
    }

    static void diplayvalue(String c) {

        int i = 0;
        while (i < c.length()) {
            char val = c.charAt(i);
            if (val == 'i') {
                System.out.println(i + 1);
            } else {
                Stack<Integer> st = new Stack<>();
                while (i < c.length() && c.charAt(i) == 'd') {
                    st.push(i + 1);
                    i++;
                }
                while (!st.isEmpty()) {
                    System.out.println(st.pop());
                }
            }
            i++;
        }
    }

    static void display(int i) {
        if (i >= 100) {
            return;
        }
        System.out.println(i);
        display(i + 1);
    }

    static void clebrityprob(int m[][]) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < m.length; i++) {
            st.push(i);
        }
        while (!st.isEmpty() && st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            if (m[a][b] == 0) {
                st.push(a);
            }
        }
        for (int i = 0; i < m.length; i++) {
            if (m[st.peek()][i] != 0) {
                System.out.println("sorry");
                return;
            }
        }
    }

    static void infixevalution(String word) {
        Stack<Integer> q = new Stack<>();
        Stack<Character> r = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isDigit(c)) {
                q.push(Integer.parseInt(String.valueOf(c)));
            } else if (c == '(') {
                r.push('(');
            } else if (c == ')') {
                while (!r.isEmpty() && r.peek() != '(') {
                    Character poll = r.pop();
                    q.push(calculate(poll, q.pop(), q.pop()));
                }
                r.pop();
            } else {
                int getpriority = getpriority(c);
                if (getpriority == getpriority(r.peek())) {
                    q.push(calculate(r.pop(), q.pop(), q.pop()));
                    r.push(c);
                } else if (getpriority > getpriority(r.peek())) {
                    q.push(calculate(r.pop(), q.pop(), q.pop()));
                    r.push(c);
                } else {
                    r.push(c);
                }

            }
        }
    }

    private static int getpriority(char c) {
        if (c == '+') {
            return 1;
        }
        if (c == '-') {
            return 1;
        }
        if (c == '*') {
            return 2;
        }
        if (c == '/') {
            return 2;
        }
        return -1;
    }

    private static Integer calculate(Character poll, Integer pop, Integer pop1) {
        if (poll.equals('+')) {
            return pop + pop1;
        } else if (poll.equals('-')) {
            return pop - pop1;
        } else if (poll.equals('*')) {
            return pop * pop1;
        } else {
            return pop / pop1;
        }
    }

    static void findmax(int arr[]) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int i = 0;
        while (i < 4) {
            if (queue.isEmpty()) {
                queue.addFirst(i);
            } else {
                while (queue.size() > 0 && arr[queue.peekLast()] < arr[i]) {
                    queue.pollLast();
                }
                queue.addLast(i);
            }
            i++;
        }

        while (i < arr.length) {
            System.out.print(arr[queue.peekFirst()] + " ");
            while (i - queue.peekFirst() >= 4) {
                queue.pollFirst();
            }
            while (queue.size() > 0 && arr[queue.peekLast()] < arr[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            i++;
        }

    }

    static void stock(int arr[]) {
        int brr[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (st.isEmpty()) {
                st.push(i);
                brr[i] = -1;
            } else {
                while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    brr[i] = -1;
                    st.push(i);
                } else {
                    brr[i] = st.peek();
                    st.push(i);
                }
            }
        }
        Arrays.stream(brr).forEach(a -> System.out.print(a + " "));
    }

    static void next(int arr[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (st.isEmpty()) {
                st.push(i);
            } else if (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                    arr[st.peek()] = arr[i];
                    st.pop();
                }
            } else if (arr[st.peek()] > arr[i]) {
                st.push(i);
            }
        }
        while (!st.isEmpty()) {
            arr[st.pop()] = -1;
        }
        Arrays.stream(arr).forEach(a -> System.out.println(a));
    }

    static void balancebrackets(String arr) {
        Stack<Character> st = new Stack<>();
        Stack<Character> ts = new Stack<>();
        int i = 0;
        while (i < arr.length()) {
            char c = arr.charAt(i);
            if (Character.isDigit(c)) {
                st.push(c);
            } else if (c == '{' || c == '(' || c == '[') {
                ts.push(c);
            } else if (c == '}' || c == ')' || c == ']') {
                if (c == '}') {
                    while (!st.isEmpty() && st.peek() != '{') {
                        st.pop();
                    }
                    if (st.isEmpty() || st.peek() != '{') {
                        System.out.println("impbalnce");
                    } else
                        st.pop();
                } else if (c == ')') {
                    while (!st.isEmpty() && st.peek() != '(') {
                        st.pop();
                    }
                    if (st.isEmpty() || st.peek() != '(') {
                        System.out.println("impbalnce");
                    } else
                        st.pop();
                }
                if (c == ']') {
                    while (!st.isEmpty() && st.peek() != '[') {
                        st.pop();
                    }
                    if (st.isEmpty() || st.peek() != '[') {
                        System.out.println("impbalnce");
                    } else
                        st.pop();
                }

            }

            i++;
        }
        System.out.println("waoo");
    }

    static class Linking {
        int data;
        Linking next = new Linking();
    }

    static class Generic {
        int data;
        ArrayList<Generic> arrayList = new ArrayList<>();
    }

    static class Shoot {
        int src;
        int weight;

        public Shoot(int src, int weight) {
            this.src = src;
            this.weight = weight;
        }
    }

    static class Value {
        int id;
        String value;

        public Value(int id, String value) {
            this.id = id;
            this.value = value;
        }

        public Value() {
        }
    }
}
