

import java.util.*;

public class UnionFind {
    public static final int FIVE_SECONDS = 5000;
    public static final int MAX_Y = 400;
    public static final int MAX_X = 400;
    static int i = 0;
    static int count = 0;
    static int max = Integer.MAX_VALUE;

    static void permutate(ArrayList<String> ar, String ans, boolean b[], int v) {
        if (v == 3) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < ar.size(); i++) {
            if (b[i] == false) {
                b[i] = true;
                permutate(ar, ans + ar.get(i) + "  ", b, v + 1);
                b[i] = false;
            }
        }
    }

    public static int removeDuplicates(int[] nums) {
        int temp[] = nums.clone();
        int count = 0;
        int i = 0;
        int k = 0;
        while (i < temp.length) {
            if (i + 1 < temp.length && temp[i] == temp[i + 1]) {
                while (i + 1 < temp.length && temp[i] == temp[i + 1]) {
                    i++;
                }
                nums[k++] = temp[i];
                i++;
                count++;
            } else {
                nums[k++] = temp[i];
                count++;
                i++;
            }
        }
        System.out.print(count);
        return count;

    }

    static long inversionCount(long arr[], long N) {
        long i = 0l;
        long j = N - 1l;
        while (i < j) {
            if ((long) arr[(int) i] > (long) arr[(int) j]) {
                return j - i + 1;
            }
            j--;
        }
        return 0;
    }

    static long countPairs(int x[], int y[], int n, int m) {
        Arrays.sort(x);
        Arrays.sort(y);

        int i = 0;
        int j = m;
        int v = 0;
        long count = 0;
        while (i < n) {
            int k = m - 1;
            while (k >= 0) {
                while (v < n) {
                    long dx = (long) Math.pow(x[i], y[k]);
                    long dy = (long) Math.pow(y[k], x[v]);
                    if (dx > dy) {
                        count++;
                    }
                    v++;
                }
                k--;
            }
            i++;


        }
        return count;

    }

    static int countTriplet(int arr[], int n) {
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        int count = 0;
        while (i < j) {
            int k = j - 1;
            int sum = 0;
            int v = i;

            while (v < k) {
                if (arr[v] + arr[k] == arr[j]) {
                    count++;
                    v++;
                    k--;
                } else if (arr[v] + arr[k] < arr[j]) {
                    v++;
                } else if (arr[v] + arr[k] > arr[j]) {
                    k--;
                }
            }
            j--;

        }
        return count;

    }

    static void bitget(int arr[]) {
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            n = n | arr[i];
        }

        int p = 0;
        int count = 0;
        while (n != 0) {
            int sumo = 0;
            int sum1 = 0;
            for (int i = 0; i < arr.length; i++) {
                int v = 1 << p;
                if ((arr[i] & v) == 0) {
                    sumo = sumo + 1;
                } else {
                    sum1 = sum1 + 1;
                }
            }
            int d = sum1 * sumo * 2;
            count = count + d;
            p++;
            int gh = p & -p;
            p = p - gh;
        }
    }

    static void swap(int n) {
        int w = n << 1;
        int t = n >> 1;
    }

    static void solve(int n) {
        int v = ((n << 3) - n) >> 3;
        System.out.println(v);

    }

    static void copysets(int start, int end, int first, int second) {
        while (start < end) {
            int p = first & (1 << start);
            if (p != 0) {
                second = second | 1 << start;
            } else {
                second = second & (~(1 << start));
            }
            start++;
        }
        System.out.println(Integer.toBinaryString(second));
    }

    static void poweroftwo(int n) {
        int v = n & -n;
        n = n - v;
        if (n != 0) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }

    static void counthrice(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum ^ arr[i];
        }
        int p = 0;
        int add = 0;
        ArrayList<Integer> ar = new ArrayList<>();
        while (sum != 0) {
            int v = sum & -sum;
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                int w = arr[i] & (1 << p);
                if (w != 0) {
                    count++;
                }
            }
            if (count % 3 != 0)
                add = add | 1 << p;

            p++;
            sum = sum - v;
        }
        System.out.println(add);

    }

    private static void sumxor(int[] ints) {
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum = sum ^ (ints[i] << 1);
        }
        System.out.println(sum);
    }

    static void countze(int n) {
        int count = 0;
        while (n != 0) {
            if (n == 2) {
                n = 1;
                count++;
            } else if (n == 1) {
                n = 0;
                count++;
            } else if (n == 3) {
                n = 2;
                count++;
            } else if ((n & 3) == 1) {
                n = (n - 1) >> 2;
                count++;
            } else if ((n & 3) == 3) {
                n = (n + 1) >> 2;
                count++;
            } else if (n % 2 == 0) {
                n = n >> 1;
                count++;
            }
        }
        System.out.println(count);
    }

    static void counttriplets(int arr[]) {
        Arrays.sort(arr);
        int i = 0;
        int sum = 0;
        int j = arr.length - 1;
        int count = 0;
        while (i < j) {
            int f = i;
            int d = j - 1;
            while (f < d) {
                if (arr[f] + arr[d] == arr[j]) {
                    System.out.println(arr[f] + " " + arr[d] + "  " + arr[j]);
                    f++;
                    d--;
                    count++;
                } else if (arr[f] + arr[d] > arr[j]) {
                    f++;
                } else if (arr[f] + arr[d] > arr[j]) {
                    d--;
                }
            }
            j--;
        }
    }

    static void allrepating(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum ^ arr[i];
        }

        int sumv = 0;
        int sumb = 0;
        for (int i = 0; i < arr.length; i++) {
            int v = sum & -sum;
            if (arr[i] - v == 0) {
                sumv = sumv ^ arr[i];
            } else {
                sumb = sumb ^ arr[i];
            }
        }
    }

    private static void minimumnumberofdev(ArrayList<Integer> ar, int i, int sum) {
        if (i == ar.size()) {
            if (sum == (1 << ar.size() - 1)) {
                System.out.println(sum);
            }
        }
        minimumnumberofdev(ar, i + 1, sum | ar.get(i));
        minimumnumberofdev(ar, i, sum);
    }

    static void kenghin(int n) {
        int count = 0;
        while (n != 0) {
            int v = n & -n;
            n = n - v;
            count++;
        }
        System.out.println(count);
    }

    static void rightmostbit(int n) {
        System.out.println(Integer.toBinaryString(n));
        int v = (~n);
        int w = v + 1;
        System.out.println(Integer.toBinaryString(w & n));
    }

    static void bitmanip(int n) {
        int v = ~n;
        System.out.println(Integer.toBinaryString(v));
        System.out.println(Integer.toBinaryString(1 >>> 3));
    }

    static void minimumxor(int arr[]) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int sum = arr[i] ^ arr[i + 1];
            System.out.println(sum);
        }
    }

    static void reverse(int n) {
        boolean flag = false;
        int np = 0;
        int sum = 0;
        for (int i = 31; i >= 0; i--) {

            if (flag == true) {
                if ((n & (1 << i)) != 0) {
                    sum = sum | 1 << np;
                    np++;
                } else {
                    np++;
                }

            } else if ((n & (1 << i)) != 0) {
                flag = true;
                sum = sum | 1 << np;
                np++;
            }

        }
        System.out.println(Integer.toBinaryString(sum));
        System.out.println(Integer.toBinaryString(n));
    }

    static void countbits(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int v = i;
            while (v != 0) {
                int vc = v & -v;
                v = v - vc;
                count++;

            }
        }
        System.out.println(count);
    }

    static void counteven(int arr[]) {
        int value = 0;
        for (int i = 0; i < arr.length; i++) {
            value = value ^ arr[i];
        }
        int p = 0;
        int sum = 0;
        while (value != 0) {
            int countz = 0;
            int counto = 0;
            for (int i = 0; i < arr.length; i++) {
                int d = arr[i] & (1 << p);
                if (d == 0) {
                    countz++;
                } else {
                    counto++;
                }
            }
            sum = sum + counto * countz * 2;


            int f = value & -value;
            p++;
            value = value - f;
        }
        System.out.println(sum);
    }

    static void countodd(int arr[]) {
        int value = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int sum = arr[i] ^ arr[j];
                while (sum != 0) {
                    int v = sum & -sum;
                    sum = sum - v;
                    value++;
                }

            }
        }
        System.out.println(value);
    }

    static void swapoddeven(int n) {
        int v = 0XAAAAAAAA;
        int w = 0X55555555;
        int ev = v & n;
        int fr = v & w;
        ev = ev << 1;
        fr = fr >> 1;
        System.out.println(ev | fr);
    }

    static void divide(int n) {

        System.out.println(((n << 3) - n) >> 3);
        System.out.println(n >> 3);
    }

    static void powertwo(int pow) {
        int count = 0;
        while (pow != 0) {
            int dc = pow & -pow;
            pow = pow - dc;
            count++;
        }
        if (count == 1) {
            System.out.println("true");
        }
    }

    static void copyset(int a, int b, int ec, int fc) {
        System.out.println(Integer.toBinaryString(a) + "  " + Integer.toBinaryString(b));
        int p = fc;
        while (p <= ec) {
            int w = 1 << p;

            int dc = a & w;
            if (dc != 0) {
                b = b | w;
            }
            p++;
        }
        System.out.println(Integer.toBinaryString(a) + "  " + Integer.toBinaryString(b));
        System.out.println(b);

    }

    static void flip(int a, int b) {
        int w = a ^ b;
        int pc = 0;
        int count = 0;
        while (w != 0) {
            int dc = 1 << pc;
            if ((w | dc) != (b | dc)) {
                count++;
            }
            int wc = w & -w;
            w = w - wc;
        }
        System.out.println(count);
    }

    static void findthree(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum ^ arr[i];
        }
        int s = 0;
        int pc = 0;
        while (sum != 0) {
            int v = 0;
            for (int i = 0; i < arr.length; i++) {
                if ((arr[i] & (1 << pc)) != 0) {
                    v++;
                }
            }
            if (v % 3 != 0) {
                s = s | 1 << pc;
            }
            pc++;
            int dc = sum & -sum;
            sum = sum - dc;
        }
        System.out.println(s);
    }

    static void permuattion(String word, int i, String ans, int bc) {
        if (i == word.length()) {
            System.out.println(ans + " " + bc);
            return;
        }
        if (bc > 0) {
            permuattion(word, i + 1, ans + bc + word.charAt(i), 0);
            permuattion(word, i + 1, ans, bc + 1);
        } else {
            permuattion(word, i + 1, ans + word.charAt(i), 0);
            permuattion(word, i + 1, ans, bc + 1);
        }
    }

    static void xoraddsum(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum ^ (2 * arr[i]);

        }
        System.out.println(sum);
    }

    static void samenumbeofbits(int n, int arr[], int sum) {
        if (n == 5) {

            System.out.println(sum);
            System.out.println();
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0) {
                arr[j] = 1;
                samenumbeofbits(n + 1, arr, sum | 1 << j);
                arr[j] = 0;
            }
        }

    }

    static void nsetbits(int n) {

        int count = 0;
        while (n != 0) {
            int w = n & -n;
            n = n ^ w;
            count++;
        }
        System.out.println(count);

        for (int i = 0; i < 12; i++) {
            int count1 = 0;
            int f = i;
            while (f != 0) {
                int w = f & -f;
                f = f ^ w;
                count1++;
            }
            if (count1 == count) {
                System.out.println(i);
            }
        }
    }

    static void reducenumber(int n) {
        int count = 0;
        while (n != 1) {
            if (n == 1) {

            } else if (n == 2) {
                n = n - 1;
            } else if (n == 3) {
                n = n - 1;
            } else if ((n & 3) == 3) {
                n = n + 1 / 2;
            } else if ((n & 3) == 1) {
                n = n - 1 / 2;
            }


        }

    }

    static void allrepeating(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum ^ arr[i];
        }

        int v = sum & -sum;
        int vw = 0;
        Map<Boolean, Integer> map = new HashMap<>();
        while (vw < arr.length) {
            int d = arr[vw] & v;
            if (d == 0) {
                if (map.containsKey(false)) {
                    map.put(false, map.get(false) ^ arr[vw]);
                } else {
                    map.put(false, arr[vw]);
                }
            } else {
                if (map.containsKey(true)) {
                    map.put(true, map.get(true) ^ arr[vw]);
                } else {
                    map.put(true, arr[vw]);
                }
            }
            vw++;
        }

        System.out.println(map);
    }

    static void numberofvalidwords() {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();

        int d = 1;
        for (int i = 0; i < 6; i++) {
            System.out.print("Enter the string:  " + i + " ");
            String abc = sc.next();
            for (int j = 0; j < abc.length(); j++) {
                if (!map.containsKey(abc.charAt(j))) {
                    map.put(abc.charAt(j), d);
                    d++;
                }
            }
            System.out.println();
        }
        System.out.println(map);
        ArrayList<String> ar = new ArrayList<>();
        ar.add("above");
        ar.add("ghsij");
        ar.add("klmsd");
        ar.add("rstuajk");
        validwords(ar, map, 0, 0);
    }

    private static void validwords(ArrayList<String> ar, HashMap<Character, Integer> map, int i, int count) {
        for (int j = 0; j < ar.size(); j++) {
            String dc = ar.get(i);
            boolean flag = true;
            for (int k = 0; k < dc.length(); k++) {
                if (map.containsKey(dc.charAt(k)) && map.get(dc.charAt(k)) < 0) {
                    Integer integer = map.get(dc.charAt(k));
                    map.put(dc.charAt(k), integer - 1);
                } else {
                    flag = false;
                    break;

                }
            }
            if (flag == false) {
                validwords(ar, map, i + 1, count + 1);
            }

        }
    }

    static void skillmap(int people[], int i, int sum, int val) {
        if (i == 4) {
            if (sum == 31) {
                System.out.println(val);
            }
            return;
        }
        skillmap(people, i + 1, sum | people[i], val * 10 + people[i]);
        skillmap(people, i + 1, sum, val);
    }

    static void greycode(int n, String ans) {
        if (n == 0) {
            System.out.println(ans);
            return;
        }
        greycode(n - 1, 1 + ans);
        greycode(n - 1, 0 + ans);
    }

    static ArrayList<String> greycode(int n) {
        if (n == 0) {
            ArrayList<String> dc = new ArrayList<>();
            dc.add(0 + "");
            dc.add(1 + "");
            return dc;
        }
        ArrayList<String> br = greycode(n - 1);
        ArrayList<String> cr = new ArrayList<>();
        for (String it : br) {
            cr.add(0 + it);
            cr.add(1 + it);
        }
        return cr;
    }

    static void jospheous(int n) {
        int i = 1;
        int vc = 1;
        while (i * i <= n) {
            vc = i * i;
            i = i + 1;
        }
        System.out.println(i + "  " + vc);
        int dc = n - vc;
        System.out.println(dc * 2 + 1);


    }

    static void bitmanipulation() {
        int v = 31;
        int c = 0;
        while (v != 0) {
            int dx = v & -v;
            v = v - dx;
            c++;
        }
        System.out.println(c);

    }

    static void maxpro(int prices[]) {
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < prices.length - 1; i++) {
            if (flag == true) {
                while (prices[i] > prices[i + 1]) {
                    i++;
                }
                sum = sum - prices[i];
                i++;
                flag = false;
            } else {
                while (prices[i] > prices[i - 1]) {
                    i++;
                }
                sum = sum + prices[i];
                i++;
                flag = true;
            }
        }

        System.out.print(sum);
    }

    public static int maxProfit1(int[] prices, int sum, int i, boolean isafe, HashMap<String, Integer> map) {
        if (prices.length <= i) {
            return 0;
        }
        String key = prices[i] + "##" + isafe;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (isafe == true) {
            int b = maxProfit1(prices, sum - prices[i], i + 1, false, map) - prices[i];
            int c = maxProfit1(prices, sum, i + 1, true, map);
            map.put(key, Math.max(b, c));
            return Math.max(b, c);
        } else {
            int b = maxProfit1(prices, sum + prices[i], i + 1, true, map) + prices[i];
            int c = maxProfit1(prices, sum, i + 1, false, map);
            map.put(key, Math.max(b, c));
            return Math.max(b, c);
        }

    }

    public static void rotate(int[] nums, int k) {
        int v = k % nums.length;

        int temp[] = nums.clone();
        int c = 0;
        for (int j = v; j < nums.length; j++) {
            nums[c++] = temp[j];
        }
        for (int j = 0; j < v; j++) {
            nums[c++] = temp[j];
        }

    }

    private static void rotatefirsttime(int[] nums) {

        int v = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = v;

    }

    static List<Integer> count(int[] nums) {
        List<Integer> tr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            long count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            tr.add((int) count);
        }
        System.out.print(tr);

        return tr;
    }

    public static List<Integer> countSmaller(int[] nums) {
        TreeNode tree = new TreeNode();

        for (int i = nums.length - 1; i >= 0; i--) {
            tree = insert(tree, nums[i]);
        }
        DFS(tree);
        return null;

    }

    private static void DFS(TreeNode tree) {
        if (tree == null) {
            return;
        }
        System.out.println(tree.data + "  " + tree.count);
        DFS(tree.left);
        DFS(tree.right);
    }

    private static TreeNode insert(TreeNode tree, int num) {
        TreeNode tr = createNode(num);
        while (tree != null) {
            if (tree.data > num) {
                tree.count++;
                tree = tree.left;
            } else if (tree.data < num) {
                tr.count = tree.count + 1;
                tree = tree.right;
            }
        }
        return null;
    }

    private static TreeNode createNode(int num) {
        TreeNode tr = new TreeNode();
        tr.data = num;
        tr.count = 0;
        return tr;

    }

    static void containerwater(int[] arr) {

        int max = arr[0];
        int value = 0;
        if (arr.length == 2) {
            if (max < arr[1]) {
                max = arr[1];
                value = 1;
            }
        }
        for (int i = 1; i < arr.length - 1; i++) {

            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                if (max < arr[i]) {
                    max = arr[i];
                    value = i;
                }
            } else if (arr[i - 1] < arr[i]) {
                if (max < arr[i]) {
                    max = arr[i];
                    value = i;
                }
            } else if (arr[i + 1] < arr[i]) {
                if (max < arr[i]) {
                    max = arr[i];
                    value = i;
                }
            }
        }
    }

    static void peakele(int arr[]) {
        int i = 0;
        int max = 0;
        int j = arr.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                max = Math.max(max, arr[mid]);
                i = mid - 1;
            } else if (arr[mid] < arr[mid + 1]) {
                i = mid;
            } else if (arr[mid] > arr[mid - 1]) {
                j = mid;
            }

        }
        System.out.print(max);
    }

    static void knight(int board[][], int dx, int dy, int k) {
        int x[] = {};
        int y[] = {};
        Queue<Cordinate> q = new LinkedList<>();
        q.add(new Cordinate(3, 3, 1));
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (count == 2) {
                return;
            }
            while (size > 0) {
                Cordinate poll = q.poll();
                for (int i = 0; i < 8; i++) {
                    if (x[i] + poll.x >= 0 && x[i] + poll.x < 5 && y[i] + poll.y >= 0 && y[i] + poll.y < 5) {
                        q.add(new Cordinate(x[i] + poll.x, y[i] + poll.y, poll.probability * 1 / 8));
                    }

                }
                size--;
            }
            count++;
        }

    }


    static void getValue(TreeNode tree, TreeNode target, int K) {
        getValueTree(tree, target.data);
    }

    private static TreeNode getValueTree(TreeNode tree, int data) {
        if (tree == null) {
            return null;
        }
        TreeNode a = getValueTree(tree.left, data);
        TreeNode b = getValueTree(tree.right, data);
        if (a.data == data) {
            rotatell(tree);
        }
        return null;
    }

    private static void rotatell(TreeNode tree) {
        TreeNode tr = tree.left;
        tr.right = tree;
        getDistancevalue(tr, 3);

    }

    private static void getDistancevalue(TreeNode tr, int i) {
        if (tr == null) {
            return;
        }
    }

    public static int minFallingPathSum(int[][] matrix) {
        int max = Integer.MAX_VALUE;
        int dp[][] = new int[matrix.length][matrix.length];
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == matrix.length - 1) {
                    dp[i][j] = matrix[i][j];
                } else if (j == 0) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + matrix[i][j];
                } else if (j == matrix.length - 1) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j - 1]) + matrix[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], Math.min(dp[i + 1][j + 1], dp[i + 1][j - 1])) + matrix[i][j];
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            max = Math.min(dp[0][i], max);
        }
        return max;
    }

    private static void getutils(int[][] matrix, int dx, int dy, int sum, boolean[][] booleans) {
        if (dx == matrix.length - 1 && dy < matrix.length && dy >= 0) {
            count = Math.min(sum + matrix[dx][dy], count);
            return;
        }
        if (dx < 0 || dy < 0 || dy >= matrix.length || booleans[dx][dy] == true) {
            return;
        }
        booleans[dx][dy] = true;
        getutils(matrix, dx + 1, dy - 1, sum + matrix[dx][dy], booleans);
        getutils(matrix, dx + 1, dy, sum + matrix[dx][dy], booleans);
        getutils(matrix, dx + 1, dy + 1, sum + matrix[dx][dy], booleans);
        booleans[dx][dy] = false;
    }


    public static int lengthOfLIS(int[] nums) {

        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;
        int v = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    v = i;
                    max = Math.max(max, dp[i]);
                }
            }
        }


        return max;
    }


    public static String largestTimeFromDigits(int[] arr) {
        int f = first(arr);
        if (f == -1) {
            return "";
        }
        int s = second(arr, f);
        if (s == -1) {
            return "";
        }
        int sl = third(arr, f, s);
        if (sl == -1) {
            return "";
        }
        int s2 = fourth(arr, f, s, sl);
        String val = f + "" + s + ":" + sl + "" + s2;
        System.out.print(val);
        return val;

    }

    private static int fourth(int[] arr, int f, int s, int sl) {
        int max = 0;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (i != sl && i != f && s != f) {
                if (max < arr[i]) {
                    max = arr[i];
                    index = i;
                }
            }
        }
        return index;
    }

    private static int third(int[] arr, int f, int s) {
        int max = 0;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 7 && i != f && s != f) {
                if (max < arr[i]) {
                    max = arr[i];
                    index = i;
                }
            }
        }
        return index;
    }

    private static int second(int[] arr, int f) {
        int max = 0;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[f] == 2 && arr[i] < 5 && f != i) {
                if (max < arr[i]) {
                    max = arr[i];
                    index = i;
                }
            } else if (arr[f] != 2 && f != i) {
                if (max < arr[i]) {
                    max = arr[i];
                    index = i;
                }
            }
        }
        return index;
    }

    private static int first(int[] arr) {
        int max = -1;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 3) {
                if (max < arr[i]) {
                    max = arr[i];
                    index = i;
                }
            }
        }
        if (index == -1) {
            return -1;
        }
        return index;
    }

    public static int longestConsecutive(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], false);
        }
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int ps = 0;
            if (map.get(val) == false) {
                int dval = val - 1;
                while (map.get(dval) != null && map.get(dval) == false) {
                    map.put(dval, true);
                    ps++;
                    dval--;
                }
            }
            if (map.get(val) == false) {
                int sval = val + 1;
                while (map.get(sval) != null && map.get(sval) == false) {
                    map.put(sval, true);
                    ps++;
                    sval++;
                }
            }
            map.put(val, true);
            ps++;
            max = Math.max(ps, max);
        }
        System.out.print(max);
        return max;
    }


    static void gettime(int arr[]) {
        permutatevalue(arr, new ArrayList<>(), "", new boolean[10]);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ar = new ArrayList<>();
        permutateList(nums, ar, new boolean[10], list);
        System.out.print(list);
        return list;

    }

    private static void permutateList(int[] nums, List<Integer> objects, boolean[] booleans, List<List<Integer>> list) {
        if (objects.size() == nums.length) {
            list.add(new ArrayList<>(objects));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (booleans[i] == false) {
                booleans[i] = true;
                objects.add(nums[i]);
                permutateList(nums, objects, booleans, list);
                objects.remove(objects.size() - 1);
                booleans[i] = false;
            }
        }

    }

    private static void permutatevalue(int[] arr, ArrayList<String> val, String ans, boolean b[]) {
        if (ans.length() == 4) {
            System.out.print(ans + "  ");
            val.add(ans);
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            if (b[j] == false) {
                b[j] = true;
                permutatevalue(arr, val, ans + arr[j], b);
                b[j] = false;
            }
        }
    }


    static TreeNode deletebst(TreeNode tree, int value) {
        if (tree == null) {
            return tree;
        }
        if (tree.data < value) {
            tree.left = deletebst(tree.left, value);
        } else if (tree.data > value) {
            tree.right = deletebst(tree.right, value);
        } else {
            if (tree.left != null && tree.right != null) {
                TreeNode tr = createsuccesor(tree);
                int temp = tree.data;
                tree.data = tr.data;
                tr.data = temp;
                deletebst(tree, value);

            } else if (tree.left == null && tree.right == null) {
                return null;
            } else if (tree.left != null) {
                return tree.left;
            } else if (tree.right != null) {
                return tree.right;
            }

        }
        return null;
    }

    private static TreeNode createsuccesor(TreeNode tree) {

        if (tree.right != null) {
            tree = tree.right;
        }
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    public static void main(String[] args) {
        int i = findvalue(new int[]{3, 2, 2, 5, 2}, 4);
        System.out.print(i);
    }

    static void unionfind(int nums[]) {
        int parent[] = new int[1000];
        for (int i = 0; i < 1000; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 2; j < Math.sqrt(nums[i]); j++) {
                if (nums[i] % j == 0) {
                    unionplace(parent, nums[i], j);
                    unionplace(parent, nums[i], nums[i] / j);
                }
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = getparentvalue(parent, nums[i]);
            map.put(a, map.getOrDefault(a, 0) + 1);
            max = Math.max(map.get(a), max);
        }
 

    }

    private static void unionplace(int[] parent, int num, int i) {
        int a = getparentvalue(parent, num);
        int b = getparentvalue(parent, i);
        if (a != b) {
            parent[b] = a;
        }
    }

    private static int getparentvalue(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        parent[i] = getparentvalue(parent, parent[i]);
        return parent[i];
    }


    static int findvalue(int arr[], int n) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == n) {
                return i;
            } else {
                if (i == n) {
                    n = arr[i];
                }
                i++;
            }
            if (i == arr.length) {
                i = 0;
            }

        }
        System.out.print(i);
        return i;
    }

    static int find(int arr[], int n, int i) {
        if (arr[i] == n) {
            return i;
        }
        if (arr.length == i) {
            return -1;
        }
        if (i == n) {
            return arr[i];
        }
        int v = find(arr, n, i + 1);
        return v;
    }

    public static int largestComponentSize(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++)
                if (istrue(arr[i], arr[j], 2)) {
                    count++;
                }
        }
        System.out.print(count);
        return count;
    }

    private static boolean istrue(int first, int second, int value) {
        if (value == first) {
            return false;
        }
        if (value == second) {
            return false;
        }
        if (first % value == 0 && second % value == 0) {
            return true;
        }
        return istrue(first, second, value + 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        TreeNode tr = createTree(nums, 0, nums.length);
        return tr;

    }

    private TreeNode createTree(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }
        int max = 0;
        int index = 0;
        for (int i = start; i < end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode tr = createNode(max);
        tr.left = createTree(nums, start, max);
        tr.right = createTree(nums, max + 1, end);
        return tr;

    }

    public TreeNode deserialize(String data) {
        TreeNode tr = deserializeutils(new ArrayList<>(), 0);
        return tr;

    }

    private TreeNode deserializeutils(ArrayList<String> ar, int i) {
        if (ar.get(i) == null) {
            return null;
        }
        TreeNode node = createNode(Integer.parseInt(ar.get(i)));
        node.left = deserializeutils(ar, i + 1);
        node.right = deserializeutils(ar, i + 1);
        return node;


    }

    public String serialize(TreeNode root) {
        ArrayList<String> ar = new ArrayList<>();
        serializeutil(root, ar);
        String ans = "";
        for (int i = 0; i < ar.size(); i++) {
            if (ar.get(i) != null) {
                ans = ans + ar.get(i);
            } else {
                ans = ans + -1;
            }
        }
        return ans;

    }

    private void serializeutil(TreeNode root, ArrayList<String> ar) {
        if (root == null) {
            ar.add(null);
            return;
        }
        ar.add(root.data + "");
        serializeutil(root.left, ar);
        serializeutil(root.right, ar);
    }

    static class Value {
        int sum;
        int pos;
        int count;

        public Value(int sum, int pos, int count) {
            this.sum = sum;
            this.pos = pos;
            this.count = count;
        }
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        int count;

        public TreeNode(Integer data, TreeNode left, TreeNode right, Integer count) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.count = count;
        }

        public TreeNode() {
        }

        public TreeNode(Integer data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static class Cordinate {
        int x;
        int y;
        int probability = 1;

        public Cordinate(int x, int y, int probability) {
            this.x = x;
            this.y = y;
            this.probability = probability;
        }
    }
}
