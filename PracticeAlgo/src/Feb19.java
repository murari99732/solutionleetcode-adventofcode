package practice;

import java.util.*;

public class Feb19 {
    public static final int FIVE_SECONDS = 5000;
    public static final int MAX_Y = 400;
    public static final int MAX_X = 400;
    static HashMap<Integer, Data> map = new HashMap<>();
    static Deque<Data> queue = new LinkedList<>();
    static PriorityQueue<Integer> pr = new PriorityQueue<>();
    static HashMap<Integer, Integer> mapval = new HashMap<>();
    static ArrayDeque<Integer> ar = new ArrayDeque<>();
    static int max = 0;

    static void get(int id) {
        if (map.containsKey(id)) {
            Data data = map.get(id);
            map.remove(data);
            queue.remove(data);
            queue.addFirst(data);
            map.put(data.id, data);
        }
    }

    static void push(Data v) {
        if (map.containsKey(v)) {
            queue.remove(v);
            queue.addFirst(v);
            map.put(v.id, v);
        } else if (queue.size() == 5) {
            Data data = queue.removeLast();
            map.remove(data.id);
            queue.addFirst(v);
            map.put(v.id, v);
        } else {
            map.put(v.id, v);
            queue.addFirst(v);
        }

    }

    public static void main(String... args) throws Exception {
        ArrayList<Cordinate> ar = new ArrayList<>();
        ar.add(new Cordinate(0, 2));
        ar.add(new Cordinate(5, 10));
        ar.add(new Cordinate(13, 23));
        ar.add(new Cordinate(24, 25));

        ArrayList<Cordinate> br = new ArrayList<>();
        br.add(new Cordinate(1, 5));
        br.add(new Cordinate(8, 12));
        br.add(new Cordinate(15, 24));
        br.add(new Cordinate(25, 26));
        combine(ar, br);
    }

    static TreeNode construct(int arr[], int start, int end) {
        int i = start;
        for (i = start + 1; i < end; i++) {
            if (arr[start] > arr[i]) {
                break;
            }
        }
        TreeNode tr = null;
        tr.left = construct(arr, start, i);
        tr.right = construct(arr, i + 1, end);
        return tr;

    }

    static void combine(ArrayList<Cordinate> ar, ArrayList<Cordinate> br) {
        int i = 0;
        int j = 0;
        ArrayList<Cordinate> cr = new ArrayList<>();
        while (i != ar.size() - 1 && j != br.size() - 1) {


            if (cr.size() == 0) {
                int x = ar.get(i).x;
                int y = ar.get(i).y;
                cr.add(new Cordinate(x, y));
                i++;
            } else {
                int x = ar.get(i).x;
                int y = ar.get(i).y;
                int xi = br.get(j).x;
                int yi = br.get(j).y;
                if (x < xi && y > yi) {

                } else if (x >= xi && y <= yi) {
                    cr.add(new Cordinate(xi, yi));
                } else if (x <= xi && y < yi) {
                    cr.add(new Cordinate(x, yi));
                } else if (y > xi) {
                    cr.add(new Cordinate(x, yi));
                }
            }

        }
        System.out.println(ar);
    }

    static void frequnce(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++)
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        PriorityQueue<Character> pr = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (Character it : map.keySet()) {
            pr.add(it);
        }

        while (pr.size() != 0) {
            System.out.println(pr.poll());
        }
    }

    static int countmatrix(int m[][], int x, int y) {
        if (x == 0 && y == 0) {
            return m[x][y];
        }
        if (x == m.length - 1) {
            return m[x][y];
        }
        if (y == m.length - 1) {
            return m[x][y];
        }
        if (x < 0 || y < 0 || x >= m.length || y >= m.length) {
            return 0;
        }
        int a = countmatrix(m, x - 1, y - 1);
        int b = countmatrix(m, x - 1, y);
        int c = countmatrix(m, x, y - 1);
        if (m[x][y] == 0) {
            return 0;
        } else
            return Math.min(a, Math.min(b, c)) + 1;

    }

    static void check(int arr[]) {
        Stack<Cordinate> st = new Stack<>();
        int i = 0;
        while (i < arr.length) {
            if (st.isEmpty()) {
                st.push(new Cordinate(arr[i], 1));
            } else if (st.peek().x > arr[i]) {
                st.push(new Cordinate(arr[i], 1));
            } else if (st.peek().x < arr[i]) {
                int v = 0;
                while (!st.isEmpty() && (st.peek().x < arr[i])) {

                    v = v + st.pop().y;
                }
                System.out.println(arr[i] + "    " + v);
                st.push(new Cordinate(arr[i], v));
            }
            i++;
        }
        System.out.println(st);
    }

    static void findall(String word, String ans) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ans.length(); i++) {
            map.put(ans.charAt(i), map.getOrDefault(ans.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < word.length()) {
            char key = word.charAt(i);
            if (map.containsKey(key)) {
                hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
            }
            while (j < i && i - j >= 2) {
                if (hashMap.containsKey(word.charAt(j))) {
                    Integer integer = hashMap.get(word.charAt(j));
                    if (integer - 1 == 0) {
                        hashMap.remove(word.charAt(j));
                    } else {
                        hashMap.put(word.charAt(j), integer - 1);
                    }
                }
                j++;
            }
            if (hashMap.equals(map)) {
                count++;
                System.out.println(map);
            }
            i++;
        }

    }

    static void oddeven(Node node) {
        Node iseeven = null;
        Node even = null;
        Node isodd = null;
        Node odd = null;
        Node head = node;
        int i = 0;
        while (head != null) {
            if (i % 2 == 0) {
                if (iseeven == null) {
                    iseeven = head;
                    iseeven = even;
                } else {
                    even.left = head;
                    even = even.left;
                }
            } else {
                if (isodd == null) {
                    isodd = head;
                    isodd = odd;
                } else {
                    odd.left = head;
                    odd = odd.left;
                }
            }
            head = head.left;
        }
        even.left = isodd;
    }

    static void sub(int arr[]) {

        int i = 0;
        int sum = 0;
        while (i < arr.length) {
            sum = sum + arr[i];
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
            i++;
        }
        i = 0;
        int bum = 0;
        int rum = 0;
        while (i < arr.length) {
            bum = bum + (-arr[i]);
            rum = Math.max(rum, max);
            if (bum < 0) {
                bum = 0;
            }
            i++;
        }
        int num = 0;
        for (int j = 0; j < arr.length; j++) {
            num = num + arr[j];
        }
        num = num - bum;
        max = Math.max(num, max);
        System.out.println(max);

    }

    static void subarray(int arr[], int i, int value, boolean is) {

        if (arr.length == i && is) {
            max = Math.max(max, value);
            return;
        }
        if (i == arr.length) {
            i = 0;
            is = true;
        }
        max = Math.max(max, value);
        subarray(arr, i + 1, value + arr[i], is);

    }

    static int findcombi1(int n) {
        if (n == 3)
            return 1;
        if (n == 5)
            return 1;
        if (n == 10)
            return 1;
        if (n < 0) {
            return 0;
        }
        int a = findcombi1(n - 3);
        int b = findcombi1(n - 5);
        int c = findcombi1(n - 10);

        return a + b + c;

    }

    static void findcombi(int arr[], int i, int val, String ans) {
        if (val == 20) {
            System.out.println(ans);
            return;
        } else if (val > 20) {
            return;
        }
        if (arr.length <= i) {

            return;
        }
        for (int j = i; j < arr.length; j++) {
            findcombi(arr, i, val + arr[j], ans + arr[j] + " ");
        }
    }

    public static String removeKdigits(String num, int k) {
        int count = 0;
        String val = "";
        if (num.length() == 1) {
            return Integer.parseInt(String.valueOf(num.charAt(0))) + "";
        } else if (num.length() == 2) {
            int a = Integer.parseInt(String.valueOf(num.charAt(0)));
            int b = Integer.parseInt(String.valueOf(num.charAt(1)));
            if (a > b) {
                val = val + a;
            } else {
                val = val + b;
            }
            return val;
        }
        int i = 1;
        while (i < num.length()) {
            int a = Integer.parseInt(String.valueOf(num.charAt(i - 1)));
            int b = Integer.parseInt(String.valueOf(num.charAt(i)));
            if (a < b) {
                val = val + a;
                i++;
            } else if (k != count) {
                i++;
                count++;
            } else {
                val = val + a;
                i++;
            }
        }
        int a = Integer.parseInt(String.valueOf(num.charAt(i - 2)));
        int b = Integer.parseInt(String.valueOf(num.charAt(i - 1)));
        if (count >= k) {
            val = val + b;
        } else if (a > b) {
            val = val + b;
        }
        return val;

    }

    static void singleelement(int arr[]) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return;
            } else if (arr[mid] != arr[mid + 1] && (j - (mid + 1) % 2 != 0)) {
                j = mid + 1;
            } else if (arr[mid] == arr[mid + 1] && (j - (mid + 1) % 2 == 0)) {
                j = mid + 1;
            }
        }
    }

    static void floodfill(int m[][], int x, int y) {
        if (m.length == x && m.length == y) {
            return;
        }
        if (x >= m.length || y >= m.length || m[x][y] != 0 || x < 0 || y < 0) {
            return;
        }
        m[x][y] = 1;
        floodfill(m, x + 1, y);
        floodfill(m, x, y + 1);
    }

    static void checkvalue(ArrayList<Cordinate> ar) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int v = -1;
        for (int i = 0; i < 5; i++) {
            map.put(ar.get(i).x, ar.get(i).y);
        }
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        int diffa = 0;
        int diffb = 0;
        for (int i = 1; i < coordinates.length; i++) {
            int f = coordinates[i][0] - coordinates[i - 1][0];
            int g = coordinates[i][1] - coordinates[i - 1][1];
            f = Math.abs(f);
            g = Math.abs(g);
            if (diffa == 0) {
                diffa = f - g;
            } else {
                if (f - g != diffa) {
                    return false;
                }
            }

        }
        return true;
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        int a = getHeight(root, x);
        int b = getHeight(root, y);
        if (a == b) {
            return getnode(root, x, y);
        }
        return false;

    }

    private static boolean getnode(TreeNode root, int x, int y) {
        if (root == null) {
            return true;
        }
        boolean a = getnode(root.left, x, y);
        boolean b = getnode(root.right, x, y);
        if (root.left != null && root.right != null && root.left.data == x && root.right.data == y) {
            return false;
        } else if (root.left != null && root.right != null && root.left.data == y && root.right.data == x) {
            return false;
        }
        return a && b;
    }

    private static int getHeight(TreeNode root, int y) {
        if (root == null) {
            return 0;
        }
        if (root.data == y) {
            return 1;
        }
        int a = getHeight(root.left, y);
        int b = getHeight(root.right, y);
        if (a != 0) {
            return a + 1;
        } else if (b != 0) {
            return b + 1;
        } else
            return a != 0 ? a : b;

    }

    static void painthouse(int dp[][]) {
        int r = 0;
        int g = 0;
        int b = 0;
        for (int i = 0; i < dp.length; i++) {
            if (i == 0) {
                r = dp[i][0];
                g = dp[i][1];
                b = dp[i][2];
            } else {
                int vr = Math.max(g, b) + dp[i][0];
                int cr = Math.max(r, b) + dp[i][1];
                int dr = Math.max(r, g) + dp[i][2];
                r = vr;
                g = cr;
                b = dr;
            }
        }
    }

    public static int majorityElement1(int[] nums) {

        int i = 0;
        int val = 0;
        int count = 0;
        while (nums.length != i) {
            if (count == 0) {
                val = nums[i];
                count = 1;
            } else if (val == nums[i]) {
                count++;
            } else if (val != nums[i]) {
                count--;
            }
            i++;
        }
        return val;

    }

    static int maxvalue(int dp[], int i, boolean b) {
        if (dp.length == i) {
            return 0;
        }
        if (b == true) {
            int a = maxvalue(dp, i + 1, false) + dp[i];
            int c = maxvalue(dp, i + 1, true);
            return Math.max(a, c);
        } else {
            int c = maxvalue(dp, i + 1, true);
            //  int d=maxvalue(dp, i + 1, false);
            return Math.max(c, 0);
        }
    }

    public static void findComplement(int num) {

        int v = 0;
        for (int j = 31; j >= 0; j--) {
            if ((num & (1 << j)) != 0) {
                v = j + 1;
                break;
            }
        }
        int i = 0;
        int sum = 0;
        while (v != 0) {
            num = num ^ (1 << i);
            i++;
            v--;
        }
        System.out.println(num);


    }

    static void ransomnotes(String a, String b) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < b.length(); i++) {
            map.put(b.charAt(i), map.getOrDefault(b.charAt(i), 0) + 1);
        }
        for (int i = 0; i < a.length(); i++) {
            if (map.containsKey(a.charAt(i)) && map.get(a.charAt(i)) > 0) {
                int v = map.get(a.charAt(i));
                map.put(a.charAt(i), v - 1);
            } else
                return;
        }

    }

    public static void numJewelsInStones(String jewels, String stones) {
        int count = 0;
        int k = 0;
        for (int i = 0; i < jewels.length(); i++) {

            while (jewels.charAt(i) == stones.charAt(k)) {
                count++;
                k++;
            }
        }

    }

    static int matrixchain(int arr[], int dx, int dy) {
        if (dx <= dy) {
            return 0;
        }
        int min = 0;
        for (int i = dx; i < dy; i++) {
            int a = matrixchain(arr, i, dx);
            int b = matrixchain(arr, dx + 1, dy);
            int m = a + b + arr[dx - 1] * arr[i] * arr[dy];
            min = Math.max(min, m);
        }
        return min;
    }

    static void checkval(TreeNode tree, String word, ArrayList<String> ar) {
        if (tree == null) {
            return;
        }
        if (tree.left == null && tree.right == null) {

        }
        ar.add(tree.data + "");
        checkval(tree.left, word, ar);
        checkval(tree.right, word, ar);
        ar.remove(ar.size() - 1);
    }

    static boolean valid(String word, int i, TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        }
        if (word.charAt(i) != treeNode.data) {
            return false;
        }
        if (treeNode.left == null && treeNode.right == null && word.charAt(i) == treeNode.data) {
            return true;
        }
        boolean valid = valid(word, i + 1, treeNode.left);
        boolean valid1 = valid(word, i + 1, treeNode.right);
        return valid || valid1;
    }

    static void checkvalidstr(TreeNode tree, String word, String ans) {
        if (tree == null) {
            return;
        }
        if (tree.left == null && tree.right == null) {
            ans = ans + tree.data;
            if (ans.equals(word)) {
                System.out.println(true);
            }
            return;
        }
        checkvalidstr(tree.left, word, ans + tree.data);
        checkvalidstr(tree.right, word, ans + tree.data);
    }

    static void checkvalid(TreeNode tree, String word) {
        if (tree == null) {
            return;
        }
        if (tree.data != word.charAt(0)) {
            return;
        }
        if (tree.right == null && tree.left == null) {
            if (tree.data == word.charAt(0)) {
                System.out.println("true");
            }
            return;
        }
        checkvalid(tree.left, word.substring(0));
        checkvalid(tree.right, word.substring(0));
    }

    static void unique(int a) {
        mapval.put(a, mapval.getOrDefault(a, 0) + 1);
        if (mapval.get(a) == 1) {
            ar.addLast(a);
        } else if (mapval.get(a) > 1) {
            ar.remove(a);
        }
        System.out.println(ar.getFirst());

    }

    static int editdis(String ans, String bns) {
        if (ans.length() == 0) {
            return bns.length();
        }
        if (bns.length() == 0) {
            return ans.length();
        }
        if (ans.charAt(0) == bns.charAt(0)) {
            return editdis(ans.substring(1), bns.substring(1));
        }
        return Math.min(editdis(ans.substring(1), bns), Math.min(editdis(ans, bns.substring(1)), editdis(ans.substring(1), bns.substring(1))) + 1);
    }

    static void subarray(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (map.containsKey(sum % 5)) {
                Integer integer = map.get(sum % 5);
                map.put(sum % 5, integer + 1);
            } else {
                map.put(sum % 5, 1);
            }

        }
        System.out.println(map);
    }

    static void jumpvalue(int arr[]) {
        int br[] = new int[arr.length];

        Arrays.fill(br, Integer.MAX_VALUE);
        br[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= arr[i] && i + j < arr.length; j++) {
                br[i + j] = Math.min(br[i + j], br[i] + 1);
            }
        }
        Arrays.stream(br).forEach(a -> System.out.print(a + " "));
    }

    static void jump(int arr[], int path, String ans) {
        if (path == arr.length) {
            System.out.println(ans);
        } else if (path > arr.length) {
            return;
        }
        int val = arr[path];
        int max = 0;
        int v = 0;
        for (int i = 1; i <= arr[path] && path + i < arr.length; i++) {
            if (max <= arr[i + path]) {
                max = arr[i + path];
                v = i + path;
            }
        }
        jump(arr, v, ans + arr[v] + "  ");
    }

    static int findall(int arr[], int path, String count) {
        if (path == arr.length || path > arr.length) {
            return 0;
        }
        int value = arr[path];
        int max = 0;
        for (int i = 1; i <= value; i++) {
            max = Math.max(arr[i], max);
        }
        System.out.println(max);
        int val = findall(arr, path + max, count + max + " ") + 1;
        return val;
    }

    public static int majorityElement(int[] nums) {

        int i = 0;
        int val = 0;
        int count = 0;
        while (nums.length != i) {
            if (count == 0) {
                val = nums[i];
            } else if (val == nums[i]) {
                count++;
            } else if (val != nums[i]) {
                count--;
            }
        }
        if (count >= nums.length / 2) {
            return val;
        } else {
            return -1;
        }

    }

    static class Node {
        int data;
        Node left;

        public Node(int data, Node left) {
            this.data = data;
            this.left = left;
        }

        public Node() {
        }
    }

    static class Cordinate {
        int x;
        int y;

        public Cordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Cordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
    }

    static class Data {
        int id;
        int value;

        public Data(int id, int value) {
            this.id = id;
            this.value = value;
        }

        public Data() {
        }
    }
}
