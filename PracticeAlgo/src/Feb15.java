

import java.util.*;

public class Feb15 {

    public static final int FIVE_SECONDS = 5000;
    public static final int MAX_Y = 400;
    public static final int MAX_X = 400;
    static int max1 = 0;
    static int x[] = {};
    static int y[] = {};
    static int count = 0;

    public static void main(String[] args) {
        TreeNode root = createNewNode(2);
        root.left = createNewNode(7);
        root.right = createNewNode(9);
        root.left.left = createNewNode(2);
        root.left.right = createNewNode(6);
        root.left.right.left = createNewNode(5);
        root.left.right.right = createNewNode(11);

        System.out.println(sumvalue(root, false).data);
        System.out.println(sumOfLeftLeafNodes(root, false));
        parity(new int[]{1, 2, 3, 4});
    }

    static int besttime(int arr[], int i, boolean isfase, int k) {
        if (i >= arr.length) {
            return 0;
        }
        if (k == 0) {
            return 0;
        }
        if (isfase == true) {
            int i1 = besttime(arr, i + 1, false, k) + arr[i];
            int i2 = besttime(arr, i + 1, true, k);
            return Math.max(i1, i2);
        } else {
            int i1 = besttime(arr, i + 1, true, k - 1) - arr[i];
            int i2 = besttime(arr, i + 1, false, k);
            return Math.max(i1,i2);
        }
    }

    static void minimumcost(HashMap<Integer, Integer> map, int arr[], int value, int sum, String ans) {
        for (Integer it : map.keySet()) {
            minimumcost(map, arr, value + it, sum + map.get(it), ans + map.get(it));
        }
    }

    static void parity(int arr[]) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (arr[i] % 2 != 0 && arr[j] % 2 == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            while (arr[i] % 2 == 0) {
                i++;
            }
            while (arr[j] % 2 != 0) {
                j--;
            }
        }
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }

    private static TreeNode createNewNode(int i) {
        TreeNode t = new TreeNode();
        t.data = i;
        return t;
    }

    public static int sumOfLeftLeafNodes(TreeNode node, boolean ifLeftLeaf) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null && ifLeftLeaf) {
            return node.data;
        }

        return sumOfLeftLeafNodes(node.left, true) + sumOfLeftLeafNodes(node.right, false);
    }

    static TreeNode sumvalue(TreeNode tree, boolean istrue) {
        if (tree == null) {
            return null;
        }
        if (tree.left == null && tree.right == null && istrue) {
            return tree;
        }
        TreeNode v = sumvalue(tree.left, true);
        TreeNode w = sumvalue(tree.right, false);
        if (v != null && w != null)
            tree.data = tree.data + v.data + w.data;
        if (v != null)
            tree.data = tree.data + v.data;
        if (w != null)
            tree.data = tree.data + w.data;
        return tree;
    }

    static void sum(TreeNode tree, boolean isleft, int val) {
        if (tree == null) {
            return;
        }
        if (tree.left == null && tree.right == null && isleft == true) {
            System.out.println(val + tree.data + " ");
            return;
        }
        sum(tree.left, true, val + tree.data);
        sum(tree.right, false, val + tree.data);
    }


    static void gethir(ArrayList<Cordinate> ar) {
        Collections.sort(ar, (a, b) -> a.x - b.x);
        for (int i = 0; i < ar.size(); i++) {
            for (int j = i + 1; j < ar.size(); j++) {
                if (ar.get(i).y <= ar.get(j).x) {
                    System.out.print(j);
                    break;
                }
            }
        }
    }

    static void getva(int n) {
        int dp[] = new int[n];
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (i == j * j) {
                    dp[i] = 1;
                    break;
                } else {
                    dp[i] = dp[i - j * j] + 1;
                }
            }
        }
        Arrays.stream(dp).forEach(a -> System.out.print(a + " "));
    }

    static void longestcommonfactor(int arr[]) {
        int dp[] = new int[1000];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 2; j < Math.sqrt(arr[i]); j++) {
                if (arr[i] % j == 0) {
                    findbyid(dp, j, arr[i]);
                    findbyid(dp, arr[i] / j, arr[j]);
                }
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int a = key(dp, arr[i]);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
    }

    private static void findbyid(int[] dp, int idx, int val) {
        int keya = key(dp, idx);
        int keyb = key(dp, val);
        if (keya != keyb) {
            dp[keya] = keyb;
        }
    }

    private static int key(int[] dp, int val) {
        if (dp[val] == -1) {
            return val;
        }
        dp[val] = key(dp, dp[val]);
        return dp[val];
    }

    static TreeNode deletenode(TreeNode tree, int value) {
        if (tree == null) {
            return null;
        }
        if (tree.data > value) {
            tree.left = deletenode(tree.left, value);
        } else if (tree.data < value) {
            tree.right = deletenode(tree.right, value);
        } else {
            if (tree.left == null && tree.right == null) {
                return null;
            } else if (tree.left == null && tree.right != null) {
                TreeNode tr = tree.right;
                return tr;
            } else if (tree.right == null && tree.left != null) {
                TreeNode tr = tree.left;
                return tr;
            } else if (tree.right != null && tree.left != null) {
                TreeNode tr = getSuccessor(tree);
                tree.data = tr.data;
                tree.left = deletenode(tree.left, tr.data);
            }
        }
        return tree;

    }

    private static TreeNode getSuccessor(TreeNode tree) {
        if (tree.right != null) {
            tree = tree.right;
        }
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    static void permutation(String word, String ans) {
        if (word.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            permutation(word.substring(0, i) + word.substring(i + 1), ans + c + " ");
        }
    }

    static void valid(int arr[], String ans, boolean b[], int count) {
        if (count == arr.length) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (b[i] == false) {
                b[i] = true;
                valid(arr, ans + arr[i] + " ", b, count + 1);
                b[i] = false;
            }
        }
    }

    static void consecutivesub(int arr[]) {
        HashMap<Integer, Boolean> set = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            set.put(arr[i], false);
        }
        int i = 0;
        int max = 0;
        while (i != arr.length) {
            int val = arr[i];
            int r = 0;
            while (set.containsKey(val) && set.get(val) == false) {
                r++;
                max = Math.max(max, r);
                set.put(val, true);
                val = val--;
            }
            while (set.containsKey(val) && set.get(val) == false) {
                r++;
                max = Math.max(max, r);
                set.put(val, true);
                val = val++;
            }
            i++;
        }
    }


    static void allnodes(TreeNode tree, int value) {
        TreeNode tr = getNode(tree, value);
        findvalue(tr, value);
        ArrayList<TreeNode> ar = new ArrayList<>();
        getNodevalue(tree, value, ar);
        for (int i = ar.size() - 1; i >= 0; i--) {
            value = value - 1;
            getNode(ar.get(i), value);
        }

    }

    private static boolean getNodevalue(TreeNode tree, int value, ArrayList<TreeNode> br) {
        if (tree == null) {
            return false;
        }
        if (tree.data == value) {
            return true;
        }
        boolean a = getNodevalue(tree.left, value, br);
        boolean b = getNodevalue(tree.right, value, br);
        if (a == true) {
            br.add(tree);
        }
        if (b == true) {
            br.add(tree);
        }
        return a == false ? b : a;
    }

    private static void findvalue(TreeNode tr, int value) {
        if (tr == null) {
            return;
        }
        if (value == 0) {
            System.out.print(tr.data);
        }
        findvalue(tr.left, value - 1);
        findvalue(tr.right, value);
    }


    private static TreeNode getNode(TreeNode tree, int value) {
        if (tree == null) {
            return null;
        }
        if (tree.data == value) {
            return tree;
        }
        TreeNode a = getNode(tree.left, value);
        TreeNode b = getNode(tree.right, value);
        return a != null ? a : b;
    }

    static void fallingpath1(int board[][], int x, int y, int value) {
        if (x == board.length && y == board.length) {
            System.out.print(value);
            return;
        }
        if (x < 0 || y < 0 || x > board.length || y >= board.length) {
            return;
        }
        fallingpath1(board, x + 1, y, value + board[x][y]);
        fallingpath1(board, x, y + 1, value + board[x][y]);

    }

    static int fallingpath(int board[][], int x, int y) {
        if (x == board.length && y == board.length) {
            return Integer.MAX_VALUE;
        }
        if (x < 0 || y < 0 || x > board.length || y >= board.length) {
            return 0;
        }
        int a = fallingpath(board, x + 1, y);
        int b = fallingpath(board, x, y + 1);
        return Math.min(a, b) + board[x][y];
    }

    static ArrayList lettercombination1(String words) {
        ArrayList<String> ar = lettercombination1(words.substring(1));
        ArrayList<String> br = new ArrayList<>();
        String word = "";
        for (int i = 0; i < word.length(); i++) {
            for (String it : ar) {
                br.add(it + word.charAt(i) + " ");
            }
        }
        return null;
    }

    static void lettercombination(String words, String ans) {
        String word = "";
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            lettercombination(words.substring(1), ans + c + " ");
        }
    }

    static void serialze(TreeNode tree, ArrayList<String> ar) {
        if (tree == null) {
            ar.add("X");
            return;
        }
        ar.add(tree.data + "");
        serialze(tree.left, ar);
        serialze(tree.right, ar);
    }


    static String serializeble(TreeNode tree) {
        if (tree == null) {
            return "X";
        }
        String a = serializeble(tree.left);
        String b = serializeble(tree.right);
        return tree.data + a + b;
    }

    static void findpeak(int arr[], int idx, int idy) {
        while (idx < idy) {
            int mid = (idx + idy) / 2;
            if (arr[mid] < arr[mid + 1]) {
                idx = mid + 1;
            } else if (arr[mid] > arr[mid - 1]) {
                idy = mid--;
            } else {
                System.out.print(arr[mid]);
                break;
            }
        }

    }

    static void containers(int arr[], int idx, int idy) {
        int max = 0;
        while (idx <= idy) {
            max = Math.max((idy - idx) * Math.min(arr[idx], arr[idy]), max);
            if (arr[idx] < arr[idy]) {
                idx++;
            } else {
                idy--;
            }
        }
    }

    static double knight(int idx, int idy, int n, int k, HashMap<String, Double> map) {
        if (k == 0) {
            return 1;
        }
        double pl = 0;

        for (int j = 1; j <= 8; j++) {
            if (x[j] + idx > n && y[j] + idy > n) {
                pl = pl + knight(x[j] + idx, y[j] + idy, n, k - 1, map) / 8;
            }
        }
        return pl;
    }

    static void knightprobablity(int idx, int idy, int n, int k) {
        int dx[][] = new int[n][n];
        int i = 0;
        Queue<Cordinate> q = new LinkedList<>();
        q.add(new Cordinate(idx, idy));
        while (k != i) {
            int size = q.size();
            while (size < 0) {
                Cordinate poll = q.poll();
                for (int j = 1; j <= 8; j++) {
                    if (x[j] + poll.x > n && y[j] + poll.y > n) {
                        dx[x[j] + poll.x][y[j] + poll.y] = dx[x[j] + poll.x][y[j] + poll.y] / 8;
                        q.add(new Cordinate(x[j] + poll.x, y[j] + poll.y));
                    }
                }
                i++;
            }
        }
    }

    static void palindrome(String word) {
        boolean dp[][] = new boolean[word.length()][word.length()];
        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    dp[i][j] = true;
                } else {
                    if (word.charAt(i) == word.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        int board[][] = new int[dp.length][dp.length];
        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                if (i == j) {
                    board[i][j] = 0;
                } else if (i + 1 == j) {
                    if (word.charAt(i) == word.charAt(j)) {
                        board[i][j] = 0;
                    } else {
                        board[i][j] = 1;
                    }
                } else {
                    if (word.charAt(i) == word.charAt(j) && dp[i][j]) {
                        board[i][j] = 0;
                    } else {
                        int k = i + 1;
                        int p = 0;
                        int min = Integer.MAX_VALUE;
                        for (int m = 0; m < j; m++) {
                            min = Math.min(min, board[m][k]);
                            k++;
                        }
                        board[i][j] = min + 1;
                    }
                }
            }
        }
        System.out.print(board[board.length - 1][board.length - 1]);
    }

    static void cordi(ArrayList<Cordinate> ar) {
        Collections.sort(ar, (a, b) -> a.x - b.x);
        int dp[] = new int[ar.size()];
        for (int i = 1; i < ar.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (ar.get(i).x - ar.get(j).x > 3 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
    }

    static void pali(int n) {
        int count = 0;
        int len = 0;
        while (count < n) {
            len++;
            int v = 1 << (len - 1) >> 1;
            count = count + v;
        }
    }

    static void divideval(int g) {

        int count = 0;
        Long sum = 0L;
        int dp = 32;
        while (count != 32) {
            int v = g & 1 << count;
            if (v != 0) {
                sum = sum | 1 << dp;
            }
            dp--;
            count++;
        }
        System.out.print(sum);

    }

    static void trailingzero(int n) {
        int v = n & -n;
        int count = 0;
        while (v != 1) {
            count++;
            v = v >> 1;
        }
        System.out.print(count);
    }

    static void swap(int n) {
        int a = 0XAAAAAAAA;
        int b = 0X55555555;
        int v = n & a;
        int w = n & b;
        v = v << 1;
        w = w >> 1;
        int x = v | w;
    }

    static void reversebit(int n) {
        int d = 32;
        int sum = 0;
        boolean f = true;
        int r = 0;
        while (d != 0) {
            int v = 1 << d;
            if (f == false) {
                if ((v & n) != 0) {
                    sum = sum | 1 << r;
                }
                r++;
            } else if ((v & n) != 0 && f == true) {
                sum = sum | 1 << r++;
                f = false;
            }
            d--;
        }
        System.out.println(Integer.toBinaryString(sum));
        System.out.println(Integer.toBinaryString(n));
    }

    static void divide() {

    }

    static void getone(int n) {
        while (n != 0) {
            if (n == 1) {
                System.out.print(max1);
                break;
            } else if (n == 2) {
                System.out.print(max1 + 1);
                break;
            } else if (n == 3) {
                System.out.print(max1 + 2);
                break;
            } else if ((n & 3) == 3) {
                n = n + 1;
                max1++;
            } else if ((n & 3) == 1) {
                n = n - 1;
                max1++;
            } else {
                n = n >> 1;
                max1++;
            }
        }
        System.out.print(max1);
    }

    static void allrepaetingexpect(int arr[]) {
        int val = 0;
        for (int i = 0; i < arr.length; i++) {
            val = val ^ arr[i];
        }
        int su1 = 0;
        int su2 = 0;
        int v = val & -val;
        for (int i = 0; i < arr.length; i++) {
            if ((v & arr[i]) == 0) {
                su1 = su1 ^ arr[i];
            } else {
                su2 = su2 ^ arr[i];
            }
        }
        System.out.print(su1 + "  " + su2);

    }

    static void minmumskils(int arr[], int i, int val, int count) {
        if (i == arr.length) {
            if (val == i << arr.length - 1) {
                System.out.print(count);
            }
            return;
        }
        minmumskils(arr, i + 1, val | arr[i], count + 1);
        minmumskils(arr, i + 1, val, count);
    }

    static void josphes(ArrayList<Integer> ar, int n, int i) {
        if (ar.size() == 1) {
            System.out.print(ar);
            return;
        }

        if (i >= ar.size()) {
            i = 0;
        }
        if (n >= 4) {
            ar.remove(i);
            n = 0;
        }

        josphes(ar, n + 1, i + 1);

    }

    static void rightmostbit(int n) {
        while (n != 0) {
            int v = n & -n;
            System.out.println(Integer.toBinaryString(n));
            n = n - v;
        }
    }

    static int smajhan(int egg, int height) {
        if (height == 0 || height == 1) {
            return height;
        }
        if (egg == 1) {
            return height;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= height; i++) {
            int v = smajhan(egg - 1, height - 1);
            int w = smajhan(egg, height - i);
            int dx = Math.max(v, w) + 1;
            min = Math.min(dx, min);
        }
        return min;
    }

    static void getmax(int arr[], int idx, int fdx, int value, boolean bf) {
        if (idx > fdx) {


            max1 = Math.max(max1, value);
            return;
        }
        if (bf == true) {

            value = value + arr[idx];
            getmax(arr, idx + 1, fdx, value, false);
            value = value - arr[idx];
            value = value + arr[fdx];
            getmax(arr, idx, fdx - 1, value, false);
            value = value - arr[fdx];
        } else {
            value = value - arr[idx];
            getmax(arr, idx + 1, fdx, value, true);
            value = value + arr[idx];
            value = value - arr[fdx];
            getmax(arr, idx, fdx - 1, value, true);
            value = value + arr[fdx];
        }

    }

    static int value(int arr[], int value, int idx, int fdx, boolean bf) {
        if (fdx < idx) {
            return 0;
        }
        if (bf == true) {
            int v = value(arr, value + arr[idx], idx + 1, fdx, false) + arr[idx];
            max1 = Math.max(max1, v);
            int w = value(arr, value + arr[fdx], idx, fdx - 1, false) + arr[fdx];
            max1 = Math.max(max1, w);
            return Math.max(v, w);
        } else {
            int v = value(arr, value, idx + 1, fdx, true) - arr[idx];
            int w = value(arr, value, idx, fdx - 1, true) - arr[fdx];

            return Math.min(v, w);
        }

    }

    static void perfectsquare(int n) {
        int dp[] = new int[n];
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                if (j == Math.sqrt(i)) {
                    min = Math.min(0, min);
                    break;
                } else {

                    min = Math.min(dp[i - j * j], min);
                }
            }
            dp[i] = min + 1;

        }
        Arrays.stream(dp).forEach(a -> System.out.print(a + " "));
    }

    static int minimumcurts(String word, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (isaplindrome(word.substring(i, j + 1))) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int a = minimumcurts(word, i, k);
            int b = minimumcurts(word, k + 1, j);
            int val = a + b + 1;
            min = Math.min(min, val);
        }
        return min;
    }

    private static boolean isaplindrome(String substring) {
        int i = 0;
        int j = substring.length() - 1;
        while (i < j) {
            if (substring.charAt(i) != substring.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static void chords(int n) {
        int dp[] = new int[n / 2];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; 2 * i < n; i++) {
            int v = i - 1;
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum = sum + dp[j] * dp[v];
                v--;
            }
            dp[i] = sum;
        }
        Arrays.stream(dp).forEach(a -> System.out.print(a + " "));
    }

    static int palidrome(String a, int i, int j) {
        if (i == j) {
            return 1;
        }
        if (a.charAt(i) == a.charAt(j)) {
            return 2 + palidrome(a, i + 1, j - 1);
        }
        return Math.max(palidrome(a, i + 1, j), palidrome(a, i, j - 1));
    }

    static void tiling(int m, int n) {
        int dp[] = new int[n];
        for (int i = 1; i < n; i++) {
            if (i < m) {
                dp[i] = i;
            } else if (i == m) {
                dp[i] = i * 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }
    }

    static void maximumbridge(List<Cordinates> list) {
        Collections.sort(list, (a, b) -> a.x - b.x);
        int dp[] = new int[list.size()];
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(i).y > list.get(j).y && dp[j] + 1 < dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }

        }
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
    }

    static class Cordinate {
        int x;
        int y;

        public Cordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Cordinates {
        int x;
        int y;

        public Cordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
