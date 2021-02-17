

import java.util.*;

public class FEB17 {
    static int arr[] = new int[10];
    static int size = 0;
    static Nodes nodes = new Nodes();

    public static void main(String[] args) {
        int maxtwotran = maxtwotran(new int[]{2,1,5,4,0,3}, 0, true, 2);
        System.out.println(maxtwotran);
    }

    static int maxtwotran(int profit[], int i, boolean b, int k) {
        if (i >= profit.length) {

            return 0;
        }
        if (k == 0) {
            return 0;
        }
        if (b == true) {
            int a = maxtwotran(profit, i + 1, false, k) - profit[i];
            int c = maxtwotran(profit, i + 1, true, k);
            return Math.max(a, c);
        } else {
            int a = maxtwotran(profit, i + 1, true, k - 1) + profit[i];
            int c = maxtwotran(profit, i + 1, false, k);
            return Math.max(a, c);
        }

    }

    static void numberrange(int start, int end, int ans) {
        if (start == end) {
            System.out.println(ans);

            return;
        }
        numberrange(start + 1, end, ans & start);
    }

    static void sub(int arr[]) {
        int i = 0;
        int j = 0;
        int sum = 0;
        while (i < arr.length) {
            sum = sum + arr[i];
            while (sum > 3 && j < i) {
                sum = sum - arr[j];
                j++;
            }
            if (sum == 3) {
                System.out.print("found");
            }
            i++;
        }
    }

    static void subarray(int arr[], int k) {
        int dp[][] = new int[arr.length + 1][k + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else {
                    int include = 0;
                    int exclude = 0;
                    if (j >= arr[i]) {
                        include = dp[i - 1][j - arr[i]];
                    }
                    exclude = dp[i - 1][j];
                    dp[i][j] = include + exclude;
                }
            }
        }
        System.out.println(dp[dp.length - 1][dp[0].length - 1]);
    }

    static void findarray(int arr[], int i, int value, String sum) {
        if (i == arr.length) {
            if (value == 12)
                System.out.println(sum);
            return;
        }
        if (value <= 12) {
            findarray(arr, i + 1, value + arr[i], sum + arr[i] + " ");
            findarray(arr, i + 1, value, sum);
        }
    }

    static void leftmost(int m[][]) {
        int count = 0;
        int max = m.length - 1;
        for (int i = 0; i < m.length; i++) {
            int v = 0;
            for (int j = max; j >= 0; j--) {
                if (m[i][j] == 1) {
                    max--;
                    count = Math.max(count, m.length - j);
                } else if (m[i][j] == 0) {
                    break;
                }

            }
        }
        System.out.println(count);
    }

    static void preorder(int arr[], int start, int end) {
        int val = arr[start];

        for (int i = 0; i < end; i++) {
            if (val > arr[start]) {
                size = i;
                break;
            }
        }
        preorder(arr, start + 1, size);
        preorder(arr, size + 1, end);

    }

    static void rotatedarray(int arr[], int val) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (val == arr[mid]) {
                System.out.println("found");
                return;
            }
            if (arr[i] < arr[mid]) {
                if (arr[i] < val && val < arr[mid]) {
                    j = mid;
                } else {
                    i = mid;
                }

            } else if (arr[j] > arr[mid]) {
                if (arr[j] > val && val > arr[mid]) {
                    i = mid;
                } else {
                    j = mid;
                }
            }

        }
    }

    static void backspacestring(String a, String b) {
        String c = removehash(a);
        String d = removehash(b);
        if (c.equals(d)) {
            System.out.println(true);
        }
    }

    private static String removehash(String b) {

        String abc = "";
        int i = b.length() - 1;
        while (i >= 0) {
            int j = 0;
            int start = i;
            while (b.charAt(i) == '#') {
                j++;
                i--;
            }
            while (i >= 0 && j != 0) {
                i--;
                j--;
            }
            if (i < 0) {
                abc = "" + abc;
            } else
                abc = b.charAt(i) + abc;
            i--;
        }
        System.out.println(abc);
        return abc;
    }

    static void add(int v) {
        arr[size++] = v;
    }

    static void remove() {
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
    }


    static void coinchange(int arr[], int i, int pr, String ans) {
        if (pr == 12) {
            System.out.println(ans);
            return;
        }
        if (pr > 12) {
            return;
        }
        for (int j = i; j < arr.length; j++) {
            pr = pr + arr[j];
            coinchange(arr, j, pr, ans + arr[j]);
            pr = pr - arr[j];
        }
    }


    static void shiftstring(ArrayList<Cordinates> ar, String ans, int i, String val) {

        Cordinates cordinates = ar.get(i);
        if (cordinates.x == 1) {
            int y = cordinates.y;
            String ab = ans.substring(y) + ans.substring(0, y);
        } else {
            int y = cordinates.y;
            String ab = ans.substring(y, ans.length() - 1) + ans.substring(0, y);
        }

    }

    static void lastweight(int weight[]) {
        PriorityQueue<Integer> pr = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < weight.length; i++) {
            pr.add(weight[i]);
        }
        while (pr.size() != 1) {
            int poll = pr.poll();
            int bc = pr.poll();
            int wb = poll - bc;
            if (wb != 0) {
                pr.add(wb);
            }
        }
        System.out.println(pr);
    }

    static int knapsack(int weight[], int price[], int sum, int profit, int j) {

        if (j >= weight.length) {
            if (sum == 0) {
                return 0;
            }
            return 0;
        }
        if (weight[j] > sum) {
            return knapsack(weight, price, sum, profit, j + 1);
        } else {
            int a = knapsack(weight, price, sum - weight[j], profit, j + 1) + price[j];
            int b = knapsack(weight, price, sum, profit, j + 1);
            return Math.max(a, b);
        }

    }

    static int uniq(int m[][], int x, int y) {
        if (m.length == x && m.length == y) {
            return 1;
        }
        int a = uniq(m, x + 1, y);
        int b = uniq(m, x, y + 1);
        return a + b;
    }

    static void rodcutting(int price[], int sum) {
        int dp[][] = new int[price.length][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < sum; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    int include = 0;
                    int exclude = 0;
                    if (price[i] >= j) {
                        include = dp[i][j - price[i]] + price[i];
                    }
                    dp[i][j] = Math.max(include, dp[i - 1][j]);
                }
            }
        }
    }

    static void uniquepaths(int m[][], int x, int y, boolean b[][]) {
        if (m.length == x && m.length == y) {
            size++;
            return;
        }
        b[x][y] = true;
        uniquepaths(m, x + 1, y, b);
        uniquepaths(m, x, y + 1, b);
        b[x][y] = false;

    }

    static void validparnthes(String word) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '(' || word.charAt(i) == '{' || word.charAt(i) == '[') {
                st.push(word.charAt(i));
            } else if (!st.isEmpty()) {
                if (!st.isEmpty() && word.charAt(i) == ')' && st.peek() == '(') {
                    st.pop();
                } else if (!st.isEmpty() && word.charAt(i) == ']' && st.peek() == '[') {
                    st.pop();
                } else if (!st.isEmpty() && word.charAt(i) == '}' && st.peek() == '{') {
                    st.pop();
                } else {
                    System.out.println("Kuch toh galata hai");
                }
            }
        }
    }

    static void push(int v) {
        if (size != arr.length) {
            arr[size] = v;
            size++;
        }
    }

    static void pop() {
        if (size != 0) {
            arr[size] = 0;
            size--;
        }
    }

    static void display() {
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }

    static void pusht(int v) {
        Nodes post = nodes;
        while (post.next != null) {
            post = post.next;
        }
        post.next = createNode(v);
    }

    static void displayt() {
        Nodes tieto = nodes;
        while (tieto != null && tieto != null) {
            System.out.print(tieto.data + " ");
            tieto = tieto.next;
        }
    }

    static void popt() {
        if (nodes == null) {
            System.out.println("Empty");
            return;
        }
        Nodes post = nodes;
        while (post.next.next != null) {
            post = post.next;
        }
        post.next = null;
    }

    private static Nodes createNode(int v) {
        Nodes n = new Nodes();
        n.data = v;
        return n;
    }

    static class Cordinates {
        int x;
        int y;

        public Cordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Nodes {
        int data;
        Nodes next;
    }
}
