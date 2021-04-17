import java.util.*;

public class April18 {

    public static void main(String[] args) {
        maxdistancevalue(new int[]{3,5,4,2});
    }

    static void maxdistancevalue(int arr[]) {

        int brr[] = new int[arr.length];
        int crr[] = arr.clone();
        Arrays.sort(crr);
        HashMap<Integer, Integer> bap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            bap.put(arr[i], i);
        }
        for (int i = 0; i < crr.length; i++) {
            brr[i] = bap.get(crr[i]);
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, crr[i]);
            max = Math.max(max, crr[i] - min);
        }
        System.out.print(max);

    }

    static void maxdistance(int arr[]) {
        HashMap<Integer, Integer> bap = new HashMap<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
    }

    static void findpermuation(String word) {
        int count = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'I') {
                System.out.print("  " + count++);
            } else if (word.charAt(i) == 'D') {
                while (i < word.length() && word.charAt(i) == 'D') {
                    st.push(count++);
                    i++;
                }
                while (!st.isEmpty()) {
                    System.out.print(st.pop() + " ");
                }
            }
        }
    }

    static void findprime(int arr[]) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int j = 1; j < arr.length; j++) {
            int count = 0;
            for (int i = 2; i < j; i++) {
                if (j % i == 0) {
                    count++;
                }
            }
            if (count != 0 && !arrayList.contains(j)) {
                arrayList.add(j);
            }
        }
    }

    static void equivalentsubarray(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.size() < set.size()) {

            }
        }

    }

    static void checkarray(int arr[], int pairs) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(pairs - (pairs - arr[i]) % pairs)) {
                System.out.println(pairs - arr[i] + "   " + arr[i]);

            } else {
                map.put((pairs - arr[i]) % pairs, i);
            }
        }
    }

    static void longestsubarray(int arr[]) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> zero = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            zero.put(arr[i], zero.getOrDefault(arr[i], 0) + 1);
            int z = zero.get(0) != null ? zero.get(0) : 0;
            int y = zero.get(1) != null ? zero.get(1) : 0;
            int x = zero.get(2) != null ? zero.get(2) : 0;
            String bs = (z - y) + "#" + (y - x);
            if (map.containsKey(bs)) {
                System.out.println(i + "   " + map.get(bs));
            } else {
                map.put(bs, map.getOrDefault(bs, 0) + 1);
            }
        }
    }

    static void evaluate(String value) {
        Stack<Integer> stack = new Stack<>();
        Stack<Character> charstack = new Stack<>();

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(Integer.parseInt(String.valueOf(c)));
            } else if (c == '(') {
                charstack.push('(');
            } else if (c == ')') {
                while (charstack.peek() != '(') {
                    stack.push(dooperation(stack.pop(), stack.pop(), charstack.pop()));
                }
                charstack.pop();
            } else {
                char peek = charstack.peek();
                int n = getPriority(peek);
                int m = getPriority(c);
                while (n <= m) {
                    stack.push(dooperation(stack.pop(), stack.pop(), charstack.pop()));
                    n = getPriority(peek);
                }
                charstack.push(c);

            }
        }


    }

    private static int getPriority(char first) {
        if (first == '+') {
            return 1;
        } else if (first == '-') {
            return 1;
        } else if (first == '*') {
            return 2;
        } else {
            return 2;
        }


    }

    private static Integer dooperation(Integer pop, Integer pop1, Character pop2) {
        if (pop2 == '+') {
            return pop + pop1;
        } else if (pop2 == '-') {
            return pop - pop1;
        } else if (pop2 == '*') {
            return pop * pop1;
        } else {
            return pop / pop1;
        }

    }

}
