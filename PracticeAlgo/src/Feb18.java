

public class Feb18 {
    public static final int FIVE_SECONDS = 5000;
    public static final int MAX_Y = 400;
    public static final int MAX_X = 400;
    static HashMap<Integer, Data> map = new HashMap<>();
    static Deque<Data> queue = new LinkedList<>();
    static PriorityQueue<Integer> pr = new PriorityQueue<>();
    static HashMap<Integer, Integer> mapval = new HashMap<>();
    static ArrayDeque<Integer> ar = new ArrayDeque<>();

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
        boolean maxvalue = checkStraightLine(new int[][]{{0, 0}, {0, 1}, {0, -1}});
        System.out.println(maxvalue);
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
                if (f-g!=diffa) {
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
