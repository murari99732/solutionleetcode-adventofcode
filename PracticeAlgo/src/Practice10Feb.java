

import java.util.*;

public class Practice10Feb {

    static int k = 0;

    static int findstairs(int n, int dp[]) {
        if (n < 2) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int a = findstairs(n - 1, dp);
        int b = findstairs(n - 2, dp);
        int c = findstairs(n - 3, dp);
        dp[n] = Math.min(a, Math.min(b, c)) + 1;
        return dp[n];
    }

    static void finddp(int n, int ans) {
        if (n == 10) {
            System.out.print(ans + " ");
            System.out.println();
            return;
        } else if (n > 10) {
            return;
        }
        finddp(n + 1, ans + 1);
        finddp(n + 2, ans + 1);
        finddp(n + 3, ans + 1);

    }

    public static void main(String[] args) {
        ArrayList<Integer> ar= new ArrayList<>();
        ar.add(0);
        ar.add(1);
        ar.add(2);
        ar.add(3);
        ar.add(4);ar.add(5);
        ar.add(6);
        ar.add(7);

        execution(ar, 0, 0);
    }

    static void execution(ArrayList<Integer> arr, int i, int k) {
        if(arr.size()==1)
        {
            System.out.println(arr.get(i));
            return;
        }
        if (i == arr.size()) {
            i = 0;
        }
        if (k == 4) {
            arr.remove(i);
            k = 0;
        }
        execution(arr, i + 1, k + 1);
    }

    static void maximumword(String word[], int i, HashMap<Character, Integer> map, int value, int score[]) {
        maximumword(word, i + 1, map, value, score);
        String val = word[i];
        boolean flag = true;
        int sum = 0;
        for (int j = 0; j < val.length(); j++) {
            char c = val.charAt(j);
            Integer integer = map.get(c);
            if (map.containsKey(c) && integer > 0) {
                int v = score[c - 'A' + 1];
                sum = sum + score[v];
                map.put(c, integer - 1);
            } else {
                flag = false;
            }
        }
        if (flag == true) {
            maximumword(word, i + 1, map, value + sum, score);
        }
    }

    static void printabver(String word, int i, String ans, int count) {
        if (word.length() == i) {
            System.out.println(ans + "" + count);
            return;
        }
        if (count > 0) {
            printabver(word, i + 1, ans + count + word.charAt(i) + " ", 0);
            printabver(word, i + 1, ans, count + 1);
        } else {
            printabver(word, i + 1, ans + word.charAt(i) + " ", 0);
            printabver(word, i + 1, ans, count + 1);
        }
    }

    static void sudoku(int board[][], int x, int y) {
        int dx = 0;
        int dy = 0;
        if (y == board.length - 1) {
            dx = x + 1;
            dy = 0;
        } else {
            dx = x;
            dy = y + 1;
        }
        if (board[x][y] != 0) {
            sudoku(board, dx, dy);
        } else {
            for (int count = 1; count <= 9; count++) {
                if (safevisit(board, x, y, count)) {
                    board[x][y] = count;
                    sudoku(board, dx, dy);
                    board[x][y] = 0;
                }
            }
        }
    }

    private static boolean safevisit(int[][] board, int x, int y, int count) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == count) {
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[x][i] == count) {
                return false;
            }
        }
        int dx = (x / 3) * 3;
        int dy = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + dx][j + dy] == count) {
                    return false;
                }
            }
        }
        return true;
    }

    static void chess(int board[][], int dx, int dy, int ans, int count) {
        chess(board, dx, dy, ans + count, count + 1);
    }

    static void prinencoding(String word, String ans) {
        prinencoding(word.substring(1), ans + word.charAt(0));
        if (word.length() > 2) {
            String st = word.substring(0, 2);

        }
    }

    static ArrayList<String> getper(String word, int i) {
        if (i == word.length()) {
            ArrayList<String> cr = new ArrayList<>();
            cr.add(word.charAt(word.length() - 1) + "");
            return cr;
        }
        ArrayList<String> ar = getper(word, i + 1);
        ArrayList<String> cr = new ArrayList<>();

        for (String it : ar) {
            for (int j = 0; j < it.length(); j++) {
                String dc = it.substring(0, j);
                String fc = it.substring(j + 1);
                cr.add(dc + word.charAt(i) + fc);
                cr.add(it);
            }
        }
        return cr;
    }

    static void permuatte(String word, int arr[], String ans) {
        if (ans.length() == word.length()) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            if (arr[i] == -1) {
                arr[i] = 0;
                permuatte(word, arr, ans + word.charAt(i));
                arr[i] = -1;
            }
        }
    }

    static void permtation(String word, String ans) {
        if (word.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            String f = word.substring(0, i);
            String t = word.substring(i + 1);
            permtation(f + t, ans + word.charAt(i));
        }
    }

    static void key(String word, String ans) {
        String s = word.charAt(0) + "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            key(word.substring(1), ans + c + " ");
        }
    }

    static void subsequnce(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        subsequnce(str.substring(1), ans + str.charAt(0));
        subsequnce(str.substring(1), ans);
    }

    static ArrayList<String> getmazecale(int board[][], int x, int y) {
        if (x == board.length - 1 && y == board.length - 1) {
            ArrayList<String> cd = new ArrayList<>();
            cd.add("");
            return cd;
        }
        if (x >= board.length || y >= board.length || x < 0 || y < 0) {
            ArrayList<String> cd = new ArrayList<>();
            cd.add("");
            return cd;
        }
        ArrayList<String> dr = new ArrayList<>();
        ArrayList<String> er = new ArrayList<>();
        ArrayList<String> fr = new ArrayList<>();
        for (int i = x; i < board.length; i++) {
            dr = getmazecale(board, x + i, y);
        }
        for (int i = y; i < board.length; i++) {
            er = getmazecale(board, x, y + i);
        }
        for (int i = x; i < board.length; i++) {
            for (int j = y; j < board.length; j++) {
                fr = getmazecale(board, i + x, j + y);
            }
        }
        ArrayList<String> hr = new ArrayList<>();
        for (String it : dr) {
            hr.add(it + "H");
        }
        for (String it : er) {
            hr.add(it + "v");
        }
        for (String it : fr) {
            hr.add(it + "D");
        }
        return hr;
    }

    static ArrayList<String> getmaze(int board[][], int x, int y) {
        if (x == board.length && y == board.length) {
            ArrayList<String> cd = new ArrayList<>();
            cd.add("");
            return cd;
        }
        if (x >= board.length || y >= board.length || x < 0 || y < 0) {
            ArrayList<String> cd = new ArrayList<>();
            cd.add("");
            return cd;
        }
        ArrayList<String> a = getmaze(board, x + 1, y);
        ArrayList<String> b = getmaze(board, x, y + 1);
        ArrayList<String> c = new ArrayList<>();
        for (String it : a) {
            c.add(it + "H");
        }
        for (String it : b) {
            c.add(it + "v");
        }
        return c;
    }

    static ArrayList<String> stairspath(int n) {
        if (n == 0) {
            ArrayList<String> cr = new ArrayList<>();
            cr.add("");
            return cr;
        } else if (n < 0) {
            ArrayList<String> cr = new ArrayList<>();

            return cr;
        }
        ArrayList<String> stair1 = stairspath(n - 1);
        ArrayList<String> stair2 = stairspath(n - 2);
        ArrayList<String> stair3 = stairspath(n - 3);
        ArrayList<String> stairs = new ArrayList<>();
        for (String it : stair1) {
            stairs.add(it + "H");
        }
        for (String it : stair2) {
            stairs.add(it + "V");
        }
        for (String it : stair3) {
            stairs.add(it + "D");
        }
        return stairs;
    }

    static ArrayList<String> getkeypad(String word) {
        if (word.length() == 0) {
            ArrayList<String> cr = new ArrayList<>();
            cr.add("");
            return cr;
        }
        ArrayList<String> getkeypad = getkeypad(word.substring(1));
        ArrayList<String> cr = new ArrayList<>();
        String val = "";
        for (int i = 0; i < val.length(); i++) {
            char c = val.charAt(i);
            for (String it : getkeypad) {
                cr.add(it + c);
            }
        }
        return cr;
    }

    static ArrayList<String> getsubequnce(String word) {
        if (word.length() == 0) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }
        ArrayList<String> getsubequnce = getsubequnce(word.substring(1));
        ArrayList<String> br = new ArrayList<>();
        for (String it : getsubequnce) {
            br.add(it);
            br.add(it + word.charAt(0) + " ");
        }
        return br;
    }


    static int[] indexvalue(int arr[], int i, int value) {
        if (arr.length == i) {
            int br[] = new int[10];
            return br;
        }
        int[] br = indexvalue(arr, i + 1, value);
        if (arr[i] == value) {
            br[k++] = i;
        }
        return br;
    }

    static ArrayList<Integer> allindex(int arr[], int i, int value) {
        if (arr.length == i) {
            ArrayList<Integer> ar = new ArrayList<>();
            return ar;
        }
        ArrayList<Integer> ar = allindex(arr, i + 1, value);
        if (arr[i] == value) {
            ar.add(i);
        }
        return ar;
    }

    static int maxm(int arr[], int i) {
        if (i == arr.length) {
            return 0;
        }
        int n = maxm(arr, i + 1);
        if (arr[i] == 58) {
            return i;
        }
        if (n != 0) {
            return n;
        }

        return n;
    }

    static ArrayList<Integer> post(int n, ArrayList<Integer> ar) {
        if (n == 0) {
            ar.add(n);
            return ar;
        }
        ar.add(n);
        ar = post(n - 1, ar);
        ar.add(n);
        return ar;
    }

    static int power(int x, int p) {
        if (p == 0) {
            return 1;
        }
        int v = power(x, p - 1);
        int val = v * x;
        return val;
    }

    static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int v = factorial(n - 1);
        return n * v;
    }

    static ArrayList<Integer> increasing(int n) {
        if (n == 0) {
            ArrayList<Integer> ar = new ArrayList<>();
            ar.add(0);
            return ar;
        }
        ArrayList<Integer> br = increasing(n - 1);
        br.add(n);
        return br;
    }


    private static GoodPractice.TreeNode createNode(int val) {
        GoodPractice.TreeNode tr = new GoodPractice.TreeNode();
        tr.data = val;
        tr.height = 0;
        return tr;
    }

    static int smallernumber(int arr[], HashMap<Integer, Integer> map, int i) {
        if (arr.length == i) {
            return 0;
        }
        int a = smallernumber(arr, map, i + 1);
        int val = 0;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] >= arr[j]) {
                Integer integer = map.get(arr[j]);
                val = val + integer;
                a = a + 1;
            }
        }
        map.put(arr[i], val);
        return a;
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n >= 10 && !set.contains(n)) {

            int sum = 0;
            int dp = n;
            while (dp != 0) {
                sum = sum + (dp % 10) * (dp % 10);
                dp = dp / 10;
            }
            if (sum == 1) {
                return true;
            }
            n = sum;

        }
        return false;
    }

    static ArrayList<Integer> paranthesis(String ans, int start, int end) {

        ArrayList<Integer> cr = new ArrayList<>();
        for (int i = start + 1; i < end; i = i + 2) {
            ArrayList<Integer> ar = paranthesis(ans, start, i);
            ArrayList<Integer> br = paranthesis(ans, i + 1, end);
            for (int it : ar)
                for (int di : br) {
                    if (ans.charAt(i) == '+') {
                        cr.add(it + di);

                    } else if (ans.charAt(i) == '-') {
                        cr.add(it - di);

                    } else if (ans.charAt(i) == '*') {
                        cr.add(it * di);
                    }
                }
        }
        if (cr.size() == 0) {
            cr.add(Integer.parseInt(ans.substring(start, end)));
        }
        return cr;
    }

    static void area(int dx, int dy, int xdx, int xdy, int px, int py, int xpx, int xpy) {

        int fc = Math.max(dx, xdx);
        int gc = Math.max(dy, xdy);

        int rc = Math.max(px, xpx);
        int hc = Math.max(py, xpy);
        int vc = fc - rc;
        int kc = gc - hc;
        System.out.println(vc * kc);


    }

    static void getdiff(int arr[]) {
        HashMap<Integer, Integer> map[] = new HashMap[arr.length];
        for (int i = 0; i < arr.length; i++) {
            map[i] = new HashMap<>();
            HashMap<Integer, Integer> dp = map[i];
            for (int j = 0; j < i; j++) {
                HashMap<Integer, Integer> prev = map[j];
                Integer integer = prev.get(arr[i] - arr[j]);
                dp.put(arr[i] - arr[j], dp.getOrDefault(arr[i] - arr[j], 0) + 1);
                map[i] = dp;
            }
        }

    }

    static void strictlyincreas(int arr[], int brr[], int i, int j) {
        if (arr[i] > arr[i + 1]) {
            if (brr[j] > brr[j + 1] && arr[i - 1] > brr[j] && arr[i + 1] < brr[j]) {

                strictlyincreas(arr, brr, i, j);
            }
        }
    }

    static void dictionary(int arr[]) {
        HashMap<Integer, Integer> map[] = new HashMap[arr.length];
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            int a = arr[i];
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                HashMap<Integer, Integer> set = map[j];
                int diff = arr[i] - arr[j];
                set.put(diff, set.getOrDefault(diff, 0) + 1);
                max = Math.max(max, set.get(diff));


            }
        }
    }

    static int editdistance(String word, String ans) {
        if (word.length() == 0) {
            return ans.length();
        }
        if (ans.length() == 0) {
            return word.length();
        }

        if (word.charAt(0) == ans.charAt(0)) {
            return editdistance(word.substring(1), ans.substring(1));
        }
        int i = Math.min(editdistance(word.substring(1), ans), Math.min(editdistance(word.substring(1), ans.substring(1)), editdistance(word, ans.substring(1)))) + 1;
        return i;

    }

    static void glad(int arr[]) {
        int dp[][] = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (i == j) {
                    dp[i][j] = arr[i];
                } else if (i + 1 == j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + arr[i];
                }
            }
        }
    }

    static int happy(int arr[][], int i, boolean b[], int idx) {
        if (arr.length == i) {
            return 0;
        }

        int v = 0;
        for (int j = 0; j < arr[0].length; j++) {

            int w = 0;
            if (b[j] == false) {
                b[j] = true;
                w = happy(arr, i + 1, b, idx);
                v = Math.max(v, w + arr[i][j]);
                b[j] = false;
            }

        }
        return v;

    }

    static void happiness(int arr[][], int value, boolean b[], int v) {
        if (v >= arr.length) {
            System.out.println(value);
            return;
        }
        for (int j = 0; j < arr[0].length; j++) {
            if (b[j] == false) {
                b[j] = true;
                happiness(arr, value + arr[v][j], b, v + 1);
                b[j] = false;
            }
        }
    }

    static void findsubsequnce(String ans, String word) {
        int dp[][] = new int[ans.length() + 1][word.length() + 1];
        for (int i = 0; i < ans.length(); i++) {
            for (int j = 0; j < word.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (ans.charAt(i) == word.charAt(i)) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }

                }
            }
        }
    }

    static boolean findsubse(String str, String word) {
        if (word.length() == 0) {
            return true;
        }
        if (str.length() == 0) {
            return false;
        }
        if (str.charAt(0) == word.charAt(0)) {
            return findsubse(str.substring(1), word.substring(1));
        }
        boolean a = findsubse(str.substring(1), word);
        boolean b = findsubse(str, word.substring(1));
        return a || b
                ;
    }

    static void getdisticnt(String word) {
        HashMap<Character, GetValue> map = new HashMap<>();
        int dp[] = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (i == 0) {
                ArrayList<String> ar = new ArrayList<>();
                dp[0] = 2;
                map.put(word.charAt(i), new GetValue(i, word.charAt(i), ar));
            } else {
                int val = dp[i - 1];
                dp[i] = val * 2;
                if (map.containsKey(word.charAt(i))) {
                    GetValue getValue = map.get(word.charAt(i));
                    int v = dp[getValue.id];
                    dp[i] = dp[i] - v;
                    GetValue getValue1 = map.get(word.charAt(i - 1));
                    ArrayList<String> ar = getValue1.ar;


                }
            }
        }
    }


    static class GetValue {
        int id;
        char c;
        ArrayList<String> ar;

        public GetValue(char c, ArrayList<String> ar) {
            this.c = c;
            this.ar = ar;
        }

        public GetValue(int id, char c, ArrayList<String> ar) {
            this.id = id;
            this.c = c;
            this.ar = ar;
        }
    }
}
