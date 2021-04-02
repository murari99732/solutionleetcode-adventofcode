

import java.awt.*;
import java.util.LinkedList;
import java.util.*;

public class Root1 {
    static HashMap<Integer, Value> map = new HashMap<>();
    static ArrayDeque<Value> queue = new ArrayDeque<>();
    static Stack<Integer> st = new Stack<>();
    static Stack<Integer> tp = new Stack<>();
    static int arr[] = new int[10];
    static int s1 = 0;
    static int s2 = arr.length - 1;

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

    public static final int FIVE_SECONDS = 5000;
    public static final int MAX_Y = 400;
    public static final int MAX_X = 400;

    public static void main(String... args) throws Exception {
        Robot robot = new Robot();
        Random random = new Random();
        while (true) {
            robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
            Thread.sleep(FIVE_SECONDS);
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
