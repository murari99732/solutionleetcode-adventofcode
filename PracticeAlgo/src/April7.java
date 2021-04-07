package practice;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.*;
import java.util.stream.Collectors;



public class April7 {

    public static final int FIVE_SECONDS = 5000;
    public static final int MAX_Y = 400;
    public static final int MAX_X = 400;
    static int x[] = {};
    static int y[] = {};
    static int val = 0;
    static int max = 0;
    static int k = 0;
    static Tree prev = null;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int size = 0;


    public static void main(String... args) throws Exception {
        Robot robot = new Robot();
        Random random = new Random();
        while (true) {
            robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
            Thread.sleep(FIVE_SECONDS);
        }
    }

    static void coinchangeproblem(int arr[], int sum, String ans, boolean b[], int k) {
        for (int i = k; i < arr.length; i++) {
            if (sum <= 12) {
                sum = sum + arr[i];
                coinchangeproblem(arr, sum, ans + arr[i], b, i);
                sum = sum - arr[i];
            }
        }
    }

    static void targetsum(int arr[], int sum) {
        boolean dp[][] = new boolean[arr.length + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    int including = 0;
                    int excluding = 0;
                    if (dp[i][j - 1]) {
                        dp[i][j] = true;
                    } else {
                        if (dp[i][j - arr[i - 1]]) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = false;
                        }
                    }
                }
            }
        }
    }

    static void minmum(int arr[][]) {
        int dp[][] = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = arr[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + arr[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + arr[i][j];
                }
            }
        }
    }

    static void minimummoves(int arr[]) {
        int dp[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int max = Integer.MAX_VALUE;
            for (int j = 1; j <= arr[i]; j++) {
                if (j < arr.length) {
                    max = Math.min(max, dp[j + i]);
                }

            }
            if (max != Integer.MAX_VALUE) {
                dp[i] = max + 1;
            } else {

            }
        }
    }

    static void stairscom(int arr[]) {
        int dp[] = new int[arr.length];
        dp[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }

    static int stairs(int n, int arr[]) {
        if (n < 2) {
            return 0;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        int v = stairs(n - 1, arr);
        int w = stairs(n - 2, arr);
        arr[n] = Math.min(v, w) + 1;
        return arr[n];
    }

    static void coinpro(int arr[], int i, String ans, int sum) {
        if (i == arr.length) {
            if (sum == 13) {
                System.out.println(ans);
                return;
            } else if (sum > 13) {
                return;
            }
            return;
        }
        coinpro(arr, i + 1, ans + arr[i] + " ", sum + arr[i]);
        coinpro(arr, i + 1, ans, sum);
    }

    static void coinchange(int arr[], int i, String ans, int sum) {
        if (sum == 13) {
            System.out.println(ans);
            return;
        } else if (sum > 13) {
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            if (sum + arr[j] <= 13) {
                coinchange(arr, j, ans + arr[j], sum + arr[j]);
            }
        }
    }

    static void arrpermutate(int arr[], int count, boolean b[], String ans) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = count;
                arrpermutate(arr, count + 1, b, ans + arr[i] + " ");
                arr[i] = 0;
            }
        }
    }

    static void combination(int arr[], int i, int k, boolean b[], String ans) {
        if (i == 3) {
            Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
            System.out.println();
            return;
        }
        for (int j = k; j < b.length; j++) {
            if (arr[j] == 0) {
                arr[j] = i;
                combination(arr, i + 1, j + 1, b, ans + arr[i] + " ");
                arr[j] = 0;
            }
        }
    }

    static void permutate(int arr[], int i, boolean b[], String ans) {
        if (arr.length == i) {
            Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
            System.out.println();
            return;
        }
        for (int j = 0; j < b.length; j++) {
            if (arr[j] == 0) {
                arr[j] = i;
                permutate(arr, i + 1, b, ans + arr[i] + " ");
                arr[j] = 0;
            }
        }
    }

    static void wordpattern(String word, String solution, HashMap<Character, String> map) {
        if (map.containsKey(word.charAt(0))) {
            String s = map.get(word.charAt(0));
            if (!word.contains(s) || !word.substring(0, s.length()).equals(s)) {
                return;
            }
            wordpattern(word.substring(1), solution.substring(s.length() + 1), map);
        } else {
            for (int i = 0; i < solution.length(); i++) {
                map.put(word.charAt(0), solution.substring(0, i + 1));
                wordpattern(word.substring(1), solution.substring(i + 1), map);
                map.remove(word.charAt(0));
            }
        }

    }

    static void sumarray(int arr[], int k, ArrayList<ArrayList<Integer>> arrayLists) {
        if (k == 5) {
            List<Integer> collect = arrayLists.stream().map(a -> a.stream().reduce(0, Integer::sum)).collect(Collectors.toList());
            collect.stream().allMatch(a -> a.equals(a));
            return;
        }
        for (int i = 0; i < arrayLists.size(); i++) {
            if (arrayLists.get(i).size() > 0) {
                arrayLists.get(i).get(arr[k]);
                sumarray(arr, k + 1, arrayLists);
                arrayLists.get(i).remove(arrayLists.get(i).size() - 1);
            } else {
                arrayLists.get(i).get(arr[k]);
                sumarray(arr, k + 1, arrayLists);
                arrayLists.get(i).remove(arrayLists.get(i).size() - 1);
                break;
            }
        }
    }

    static void palidrompar(String word, String ans) {
        if (word.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            if (recursive(word.substring(0, i + 1))) {
                palidrompar(word.substring(i + 1), ans + word.substring(0, i + 1) + " ");
            }
        }
    }

    private static boolean recursive(String substring) {
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

    static void kpalindrome(String word, String ans) {
        if (word.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            kpalindrome(word.substring(0, i) + word.substring(i + 1), ans + word.charAt(i));
        }
    }

    static void kpartitom(int arr[], int k, boolean b[], ArrayList<ArrayList<Integer>> arrayList) {
        if (k == 5) {
            System.out.println(arrayList);
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).size() < 0) {
                arrayList.get(i).add(arr[k]);
                kpartitom(arr, k + 1, b, arrayList);
                arrayList.get(i).remove(arrayList.get(i).size() - 1);
                break;

            } else {
                arrayList.get(i).add(arr[k]);
                kpartitom(arr, k + 1, b, arrayList);
                arrayList.get(i).remove(arrayList.get(i).size() - 1);

            }
        }
    }

    static void friendpairing(int arr[], int i, boolean b[], String ans) {
        if (arr.length == i) {
            System.out.println(ans);
            return;
        }
        if (b[i] == false) {
            b[i] = true;
            friendpairing(arr, i + 1, b, ans + "{" + arr[i] + " }");

            for (int j = i + 1; j < arr.length; j++) {
                if (b[j] == false) {
                    b[j] = true;
                    friendpairing(arr, i + 1, b, ans + "{" + arr[i] + arr[j] + "}");
                    b[j] = false;
                }
            }
            b[i] = false;
        } else {
            friendpairing(arr, i + 1, b, ans);
        }

    }

    static void solvearithmetic(String word, HashMap<Character, Integer> map, int sum, boolean b[]) {
        if (word.length() == 0) {
            getsum(map);
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (!map.containsKey(word.charAt(0)) && b[i] == false) {
                b[i] = true;
                map.put(word.charAt(i), i);
                solvearithmetic(word.substring(1), map, sum + i, b);
                map.remove(word.charAt(i));
                b[i] = false;
            }

        }

    }

    private static boolean getsum(HashMap<Character, Integer> map) {

        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        String a = "send";
        String b = "more";
        String c = "money";
        for (int i = 0; i < a.length(); i++) {
            sum1 = sum1 + map.get(a.charAt(i));
        }
        for (int i = 0; i < b.length(); i++) {
            sum2 = sum2 + map.get(b.charAt(i));
        }
        for (int i = 0; i < c.length(); i++) {
            sum3 = sum3 + map.get(c.charAt(i));
        }
        if (sum1 + sum2 == sum3) {
            System.out.println(map);
            return true;
        }
        return false;
    }


    static void findmax(int m[][]) {
        boolean b[][] = new boolean[m.length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] != 0 && b[i][j] == false) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    DFSUitli(m, i, j, arr, b);
                }
            }
        }
    }

    private static void DFSUitli(int[][] m, int i, int j, ArrayList<Integer> arr, boolean[][] b) {
        if (i < 0 || j < 0 || i >= m.length || j >= m.length || b[i][j] == true) {
            return;
        }

        arr.add(m[i][j]);
        b[i][j] = true;
        DFSUitli(m, i + 1, j, arr, b);
        DFSUitli(m, i, j + 1, arr, b);
        DFSUitli(m, i - 1, j, arr, b);
        DFSUitli(m, i, j - 1, arr, b);
    }


    static void pepcoding(String word, String ans, int count) {
        if (word.length() == 0) {
            System.out.println(ans);
            return;
        }
        if (count > 0) {
            pepcoding(word.substring(1), ans + count + word.charAt(0), 0);
            pepcoding(word.substring(1), ans, count + 1);
        } else {
            pepcoding(word.substring(1), ans + word.charAt(0), 0);
            pepcoding(word.substring(1), ans, count + 1);
        }
    }

    static void targetsum(int arr[], int dx, int sum) {
        targetsum(arr, dx + 1, sum + arr[dx]);
        targetsum(arr, dx + 1, sum);
    }

    static void floodfill(int m[][], int dx, int dy, boolean b[][]) {
        if (dx < 0 || dx >= m.length || dy < 0 || dy >= m.length || b[dx][dy] == true || m[dx][dy] == 1) {
            return;
        }
        b[dx][dy] = true;
        m[dx][dy] = 1;
        floodfill(m, dx + 1, dy, b);
        floodfill(m, dx, dy + 1, b);
        floodfill(m, dx - 1, dy, b);
        floodfill(m, dx, dy - 1, b);
        b[dx][dy] = false;
    }

    static void printencoding(int arr[], int i, String value) {
        if (arr.length == i) {
            System.out.println(value);
            return;
        }
        printencoding(arr, i + 1, value + ('A' + arr[i] - 1));
        if (i + 1 < arr.length && arr[i] * 10 + arr[i + 1] < 26) {
            printencoding(arr, i + 2, value + ('A' + arr[i] * 10 + arr[i + 1] - 1));
        }
    }

    static void permutation(String word, String ans) {
        if (word.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            permutation(word.substring(0, i) + word.substring(i + 1), ans + word.charAt(i));
        }
    }

    static ArrayList<String> getstock(int m[][], int dx, int dy) {
        ArrayList<String> a = getstock(m, dx + 1, dy);
        ArrayList<String> b = getstock(m, dx, dy + 1);
        ArrayList<String> c = new ArrayList<>();
        for (String it : a) {
            c.add(it + 'H');
        }
        return null;

    }

    static void getstack(int arr[]) {
        Stack<Integer> st = new Stack<>();
        int size = Integer.MAX_VALUE;
        int i = 0;
        while (i < arr.length) {
            if (size == Integer.MAX_VALUE) {
                st.push(arr[i]);
                size = arr[i];
            } else if (size < arr[i]) {
                st.push(arr[i]);
            } else {
                st.push(arr[i] + arr[i] - size);
                size = arr[i];

            }
        }
    }

    static void getvaluev(int arr[]) {
        int i = 0;
        Stack<Integer> st = new Stack<>();
        while (i < arr.length) {

        }
    }

    static void getmin(int arr[]) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> ts = new Stack<>();
        int i = 0;
        int min = Integer.MAX_VALUE;
        while (i < arr.length) {
            if (min > arr[i]) {
                ts.push(arr[i]);
                st.push(arr[i]);
            } else {
                st.push(arr[i]);
            }
        }
    }

    static void pop() {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> ts = new Stack<>();
        while (!st.isEmpty() && !ts.isEmpty()) {
            while (st.peek() != ts.peek()) {
                st.pop();
            }
            st.pop();
            ts.pop();
        }
    }

    static void nextlargest(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.size() == 0) {
                System.out.print(-1 + " ");
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(stack.peek() + " ");
                }
                stack.push(arr[i]);
            }
        }

    }

    static void infixtopostfix(String ans) {
        Stack<Character> st = new Stack<>();
        Stack<Character> symbol = new Stack<>();
        for (int i = 0; i < ans.length(); i++) {
            char c = ans.charAt(i);
            if (Character.isAlphabetic(c)) {
                st.push(c);
            } else {
                int val = getlev(c);
                if (symbol.size() == 0) {
                    symbol.push(c);
                } else {
                    int v = checkv(symbol.peek());
                    while (v == val || v < val && symbol.size() != 0) {
                        st.push(symbol.pop());
                    }
                    symbol.push(c);
                }

            }

        }
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    private static int checkv(Character peek) {
        if (Character.isAlphabetic(peek)) {
            return -1;
        } else {
            return getlev(peek);
        }
    }

    private static int getlev(char c) {
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


    static void longest(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while (i < arr.length) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.size() <= k) {
                max = Math.max(max, i - j + 1);
            }
            while (map.size() > k && j < i) {
                int v = map.get(arr[j]);
                if (v - 1 == 0) {
                    map.remove(arr[j]);
                } else {
                    map.put(arr[j], v - 1);
                }
                j++;
            }

        }
    }


    static void longestdiv(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (map.containsKey(k - (sum % k))) {
                System.out.println(map.get(k - (sum % k)));
            } else {
                map.put(sum % k, i);
            }

        }
    }

    static void contigousarray(int arr[]) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                sum = sum - 1;
            } else {
                sum = sum + 1;
            }
            if (map.containsKey(sum)) {
                System.out.println(map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
    }

    static void findval(String arr[]) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            HashMap<Character, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < arr[i].length(); j++) {
                hashMap.put(arr[i].charAt(j), hashMap.getOrDefault(arr[i].charAt(j), 0) + 1);
            }
            if (map.containsKey(hashMap)) {
                ArrayList<String> arrayList = map.get(hashMap);
                arrayList.add(arr[i]);
            } else {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(arr[i]);
                map.put(hashMap, arrayList);
            }
        }

    }

    static void findanagram(String word, String find) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < find.length(); i++) {
            map.put(find.charAt(i), map.getOrDefault(find.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int i = 0;
        int j = 0;
        while (i < word.length()) {
            j = i + map.size();
            int k = i;
            while (k < j) {
                hashMap.put(word.charAt(k), hashMap.getOrDefault(word.charAt(k), 0) + 1);
                k++;
            }
            if (map.equals(hashMap)) {
                System.out.println(hashMap);
            }
            Integer integer = hashMap.get(word.charAt(i));
            if (integer - 1 == 0) {
                map.remove(word.charAt(i));
            } else {
                map.put(word.charAt(i), integer - 1);
            }
            i++;
        }

    }

    static void subarraysumequalk(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int sum = 0;
        map.put(0, -1);
        while (i < arr.length) {
            sum = sum + arr[i];
            if (map.containsKey(sum - k)) {
                System.out.println(i + "   " + map.get(sum - k));
            } else {
                map.put(sum, i);
            }
            i++;
        }


    }

    static void kthlargest(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                if (max - min == j - i) {
                    System.out.println((max - min) + "  " + max + "  " + min);
                }

            }
        }
    }

    static void klargest(String word, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int count = 0;
        int max = 0;
        while (i < word.length()) {

            if (word.charAt(i) == '0') {
                count++;
            }
            while (count > k) {
                if (word.charAt(j) == '0') {
                    count--;
                }
                j++;
            }
            max = Math.max(max, i - j + 1);
            i++;

        }
        System.out.println(max);
    }

    static void longestsub(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while (i < word.length()) {
            if (map.containsKey(word.charAt(i))) {
                while (j < i && map.containsKey(word.charAt(i))) {
                    int v = map.get(word.charAt(j));
                    if (v - 1 == 0) {
                        map.remove(word.charAt(j));
                    }
                    j++;
                }
            } else {
                map.put(word.charAt(i), i);
                max = Math.max(max, i - j + 1);

            }
            i++;
        }
        System.out.println(max);
    }

    static void largestarr(String word, String pord) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        }
        int i = 0;
        int j = 0;
        while (i < pord.length()) {
            if (map.containsKey(pord.charAt(i))) {
                hashmap.put(pord.charAt(i), hashmap.getOrDefault(pord.charAt(i), 0) + 1);
            }
            boolean flag = check(map, hashmap);
            while (j < i) {
                if (map.containsKey(pord.charAt(j))) {
                    Integer integer = hashmap.get(pord.charAt(j));
                    if (integer - 1 == 0) {
                        hashmap.remove(pord.charAt(j));
                        j++;
                    } else {
                        hashmap.put(pord.charAt(j), integer - 1);
                    }
                }
            }

        }


    }

    private static boolean check(HashMap<Character, Integer> map, HashMap<Character, Integer> hashmap) {
        return false;
    }

    static void largestsubarry(int arr[]) {
        int sum = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (map.containsKey(sum)) {
                max = Math.max(max, map.get(sum) - i);
            } else
                map.put(sum, i);
        }
    }

    static void distinct(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (i < arr.length) {


            while (i - j > 4) {
                if (map.containsKey(arr[j])) {
                    map.remove(arr[j]);
                }
                j++;
            }
            if (i - j <= 4) {
                map.put(arr[i], i);
            }
            if (i - j == 4) {
                System.out.println(map.keySet());
            }
            i++;

        }
    }

    static void arraypairs(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(10 - (arr[i] % 10))) {
                System.out.println(true);
                Integer integer = map.get(10 - (arr[i] % 10));
                if (integer - 1 == 0) {
                    map.remove(10 - (arr[i] % 10));
                } else {
                    map.put(10 - (arr[i] % 10), integer - 1);
                }
            }
            map.put(arr[i] % 10, map.getOrDefault(arr[i] % 10, 0) + 1);
        }
    }

    static void findsub(String word, String ans, HashMap<String, Integer> map) {
        for (int i = 0; i < word.length(); i++) {

            for (int j = 10; j < word.length() && j + i < word.length(); j++) {
                String w = word.substring(i, i + j);
                String v = word.substring(i + j);
                if (v.contains(w)) {
                    System.out.println(w + "   " + v);
                }
            }
        }
    }

    static void insert(int value) {
        arr.add(value);
        size++;
        int parent = size / 2;
        while (arr.get(parent) < value && parent >= 0) {
            int temp = arr.get(parent);
            arr.remove(parent);
            arr.add(parent, value);
            arr.add(arr.size() - 1);
            arr.add(temp);
            parent = parent / 2;
        }

    }

    static void max() {
        System.out.println(arr.get(0));
        arr.remove(0);
        arr.add(0, arr.get(arr.size() - 1));
        int index = 0;
        while (index < arr.size()) {

            int a = 2 * index + 1;
            int b = 2 * index + 2;
            if (arr.get(a) > arr.get(index)) {
                int temp = exchnage();
                index = a;
                a = 2 * index + 1;

            }
        }
    }

    private static int exchnage() {
        return 0;
    }

    static void getsibling(Tree tree, int val) {
        while (tree != null) {
            if (tree.data > val) {
                prev = tree;
                tree = tree.left;
            } else if (tree.data < val) {
                tree = tree.right;
            } else {
                Tree getright = getsuccesor(tree);
            }
        }
    }

    private static Tree getsuccesor(Tree tree) {
        if (tree.right != null) {
            tree = tree.right;
        }
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    static void findparent(Tree tree, int data) {
        if (tree.data > data) {
            prev = tree;
            findparent(tree.left, data);
        } else if (tree.data < data) {
            prev = tree;
            findparent(tree.right, data);
        } else {
            System.out.println(prev.data);
        }
    }

    static void rightnode(Tree tree, int data) {
        if (tree == null) {
            return;
        }
        if (tree.left != null && tree.left.data == data && tree.right != null) {
            System.out.println(tree.right.data);
        }
        rightnode(tree.left, data);
        rightnode(tree.right, data);
    }

    static void binarytreeval(Tree tree) {
        if (tree == null) {
            return;
        }
        binarytreeval(tree.left);
        if (prev == null) {
            prev = tree;
        } else {
            prev.left = tree;
            prev = prev.left;
            prev = tree;
        }
        binarytreeval(tree.right);

    }

    static Tree desirilze(ArrayList<Integer> arr) {
        if (arr.get(k) == -1) {
            k++;
            return null;
        }
        Tree tr = createnode(arr.get(k++));
        tr.left = desirilze(arr);
        tr.right = desirilze(arr);
        return tr;
    }

    static void searilize(Tree tree, ArrayList<Integer> arr) {
        if (tree == null) {
            arr.add(-1);
            return;
        }
        arr.add(tree.data);
        searilize(tree.left, arr);
        searilize(tree.right, arr);
    }

    public static void printAllElementsAtKDistanceFromLeafNode(Tree node, int k) {
        if (node == null || k < 0) {
            return;
        }

        int arr[] = new int[20];
        boolean visited[] = new boolean[20];

        printAllElementsAtKDistanceFromLeafNodeUtil(node, k, arr, visited, 0);
    }

    public static void printAllElementsAtKDistanceFromLeafNodeUtil(Tree node, int k, int[] arr, boolean[] visited, int count) {
        if (node == null) {
            return;
        }

        arr[count] = node.data;
        visited[count] = false;

        if (node.left == null && node.right == null && count - k >= 0 && visited[count - k] == false) {
            System.out.print(arr[count - k] + " ");
            visited[count - k] = true;
            return;
        }

        printAllElementsAtKDistanceFromLeafNodeUtil(node.left, k, arr, visited, count + 1);
        printAllElementsAtKDistanceFromLeafNodeUtil(node.right, k, arr, visited, count + 1);
    }

    public static Tree createNewNode(int val) {
        Tree newNode = new Tree();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }


    static int getval(Tree tree, int val, int level) {
        if (tree == null) {
            return 0;
        }
        if (tree.left == null && tree.right == null) {
            return 1;
        }
        int a = getval(tree.left, val, level);
        int b = getval(tree.right, val, level);
        if (a == val || b == val) {
            System.out.println(tree.data);
            return Math.max(a, b) + 1;
        }


        return Math.max(a, b) + 1;
    }

    static int getdiameter(Tree tree) {
        int a = getdiameter(tree.left);
        int b = getdiameter(tree.right);
        int m = Math.max(a, b);
        max = Math.max(max, m);
        return m + 1;

    }


    static Tree lca(Tree tree, int val, int wal) {
        if (tree == null) {
            return null;
        }
        if (tree.data == val) {
            return tree;
        }
        if (tree.data == wal) {
            return tree;
        }
        Tree a = lca(tree.left, val, wal);
        Tree b = lca(tree.right, val, wal);
        if (a != null && b != null) {

            return tree;
        }
        return a != null ? a : b;

    }

    static Tree printancestor(Tree tree) {
        if (tree.data == 12) {
            return tree;
        }
        Tree a = printancestor(tree.left);
        Tree b = printancestor(tree.right);
        if (a != null || b != null) {
            return tree;
        }
        return a != null ? a : b;
    }

    static void givensequnce(Tree tree, ArrayList<Integer> arr, int i) {
        if (arr.get(i) != tree.data) {
            return;
        }
        if (tree.left == null && tree.right == null && arr.get(i) == tree.data) {
            System.out.println("waoo");
            return;
        }
        givensequnce(tree.left, arr, i + 1);
        givensequnce(tree.right, arr, i + 1);
    }

    static void maxsum(Tree tree, int sum) {
        if (tree == null) {
            return;
        }
        sum = sum + tree.data;
        if (tree.left == null && tree.right == null) {
            System.out.println(sum);
        }
        maxsum(tree.left, sum);
        maxsum(tree.right, sum);
        sum = sum - tree.data;

    }

    static Tree hieghtbalance(Tree tree) {
        if (tree == null) {
            return tree;
        }

        if (tree.left == null && tree.right == null) {
            tree.height = 1;
            return tree;
        }
        Tree l = hieghtbalance(tree.left);
        Tree r = hieghtbalance(tree.right);
        if (l != null && r != null) {
            if (l.height - r.height > 1 && l.height - r.height < -1) {
                return null;
            }
        }
        tree.height = l.height - r.height;
        return tree;
    }

    static Tree peroder(int pre[], int post[], int start, int end) {
        Tree tree = createnode(pre[start]);
        int val = findall(post, pre, pre[start]);
        tree.left = peroder(pre, post, start, val);
        tree.right = peroder(pre, post, val + 1, end);
        return tree;
    }

    private static int findall(int[] post, int[] pre, int i) {
        return 0;
    }

    static Tree doubletree(Tree tree) {
        if (tree == null) {
            return null;
        }
        Tree left = doubletree(tree.left);
        Tree right = doubletree(tree.right);
        Tree tr = createnode(tree.data);
        if (tree.left != null) {
            Tree temp = tree.left;
            temp.left = tr;
            tr.left = temp;
        } else {
            tree.left = tr;
        }
        return tree;

    }

    private static Tree createnode(int tree) {
        Tree tr = new Tree();
        tr.data = tree;
        return tr;
    }

    static void printelem(Tree tree, int start, int end, int level) {
        if (tree == null) {
            return;
        }
        if (level > start && level < end) {
            System.out.println(tree.data);
        }
        printelem(tree.left, start, end, level + 1);
        printelem(tree.right, start, end, level + 1);

    }

    static void printbinary(Tree tree) {
        Queue<Tree> q = new LinkedList<>();
        Queue<Tree> r = new LinkedList<>();
        q.add(tree);
        while (!q.isEmpty()) {
            if (q.size() > 0) {
                int size = q.size();
                while (size > 0) {
                    Tree poll = q.poll();
                    if (poll.left != null) {
                        r.add(poll.left);
                    }
                    if (poll.right != null) {
                        r.add(poll.right);
                    }
                }
            } else {
                int size = r.size();
                while (size > 0) {
                    Tree poll = r.poll();
                    if (poll.right != null) {
                        r.add(poll.left);
                    }
                    if (poll.right != null) {
                        r.add(poll.right);
                    }
                }
            }
        }
    }

    static void printtop(Tree tree) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Tree> q = new LinkedList<>();
        q.add(tree);
        while (!q.isEmpty()) {
            Tree poll = q.poll();
            if (!map.containsKey(poll.height)) {
                map.put(tree.height, tree.data);
            }
            if (poll.left != null) {
                poll.left.height = poll.height - 1;
                q.add(poll.left);
            }
            if (poll.right != null) {
                poll.left.height = poll.height + 1;
                q.add(poll.right);
            }
        }
    }

    static int findlevel(Tree tree, int data, int level) {
        if (tree == null) {
            return -1;
        }
        if (tree.data == data) {
            return level;
        }
        int a = findlevel(tree.left, data, level + 1);
        int b = findlevel(tree.right, data, level + 1);
        return Math.max(a, b);
    }

    static boolean findtree(Tree tree, Tree root) {
        if (tree == null && root == null) {
            return true;
        }
        if (tree == null) {
            return false;
        }
        if (root == null) {
            return false;
        }
        if (tree.data != root.data) {
            return false;
        }
        return findtree(tree.left, root.left) || findtree(tree.right, root.right);
    }

    static Tree gettree(Tree tree) {
        if (tree == null) {
            return null;
        }
        tree.left = gettree(tree.left);
        tree.right = gettree(tree.right);
        Tree tr = tree.left;
        tree.left = tree.right;
        tree.right = tr;
        return tree;
    }

    static void binarytree(Tree tree) {
        if (tree == null) {
            return;
        }
        Tree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
        binarytree(tree.left);
        binarytree(tree.right);
    }

    static void preorder(Tree tree) {
        if (tree == null) {
            return;
        }
        Stack<Tree> st = new Stack<>();
        st.push(tree);
        while (!st.isEmpty()) {
            Tree pop = st.pop();
            if (pop.right != null) {
                st.push(pop.right);
            }
            if (pop.left != null) {
                st.push(pop.left);
            }
        }
    }

    static void inorder(Tree tree) {
        if (tree == null) {
            return;
        }
        Stack<Tree> st = new Stack<>();
        st.push(tree);
        while (tree.left != null) {
            st.push(tree.left);
            tree = tree.left;
        }
        while (!st.isEmpty()) {
            Tree tr = st.pop();
            System.out.println(tr.data);
            if (tr.right != null) {
                st.push(tr.right);
                tr = tr.right;
                while (tr != null) {
                    st.push(tr.left);
                    tr = tr.left;
                }
            }

        }
    }

    static void printleft(Tree tree, int level) {
        if (tree == null) {
            return;
        }
        if (val == level) {
            System.out.println(tree.data);
            val++;
        }
        printleft(tree.left, level + 1);
        printleft(tree.right, level + 1);

    }

    static void reverse(Tree tree) {
        Queue<Tree> q = new LinkedList<>();
        q.add(tree);
        Stack<Integer> st = new Stack<>();
        while (!q.isEmpty()) {
            Tree poll = q.poll();
            st.push(poll.data);
            if (poll.left != null) {
                poll = poll.left;
            }
        }
    }

    static void levelorder(Tree tree) {
        Queue<Tree> q = new LinkedList<>();
        q.add(tree);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                Tree poll = q.poll();
                System.out.println(poll.data);
                if (poll.left != null) {
                    q.add(poll.left);
                }
                if (poll.right != null) {
                    q.add(poll.right);
                }
                size--;
            }
        }
    }

    static void wordsearch(char c[][], int dx, int dy, String word) {
        if (word.length() == 0) {
            return;
        }
        wordsearch(c, dx + 1, dy, word.substring(1));
        wordsearch(c, dx, dy + 1, word.substring(1));

    }

    static void clonegraph(ArrayList<Edge>[] arrayLists) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (Edge it : arrayLists[v]) {
                if (map.containsKey(v)) {
                    ArrayList<Integer> edges = map.get(v);
                    edges.add(it.dy);
                } else {
                    ArrayList<Integer> ar = new ArrayList<>();
                    ar.add(it.dy);
                    map.put(v, ar);
                }
            }
        }
    }

    static void printvalue(int m[][], int dx, int dy, int val, int sar) {
        if (m[dx][dy] == sar) {
            return;
        }
        m[dx][dy] = sar;
        printvalue(m, dx + 1, dy, val, sar);
        printvalue(m, dx, dy + 1, val, sar);

    }

    static void numberofisland(int m[][], int dx, int dy) {
        if (dx < 0 || dy < 0 || dx >= m.length || dy >= m.length || m[dx][dy] == -1) {
            return;
        }
        m[dx][dy] = -1;
        numberofisland(m, dx + 1, dy);
        numberofisland(m, dx, dy + 1);
    }

    static void maximumgold(int m[][]) {
        int dp[][] = new int[m.length][m.length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (m[i][j] == 0)
                    dp[i][j] = 0;
            }
        }
        for (int i = m.length - 1; i >= 0; i--) {
            for (int j = m.length - 1; j >= 0; j--) {
                if (m[i][j] == 0) {
                    dp[i][j] = 0;
                } else if (i == m.length - 1) {
                    dp[i][j] = m[i][j] + dp[i][j - 1];
                } else if (j == m.length - 1) {
                    dp[i][j] = m[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j]);
                }
            }
        }
    }

    static void flow(int m[][], int dx, int dy, String ans) {
        if (dx == m.length && dy == m.length) {
            System.out.println(ans);
            return;
        }
        if (dx < 0 || dy < 0 || dx >= m.length || dy >= m.length || m[dx][dy] == Integer.MIN_VALUE) {
            return;
        }
        int val = m[dx][dy];
        m[dx][dy] = Integer.MIN_VALUE;
        if (dx + 1 > m.length && m[dx + 1][dy] > m[dx][dy]) {
            flow(m, dx + 1, dy, ans + m[dx][dy]);
        }
        if (dy + 1 > m.length && m[dx][dy + 1] > m[dx][dy]) {
            flow(m, dx, dy + 1, ans + m[dx][dy]);
        }
        if (dx + 1 > m.length && dy + 1 > m.length && m[dx + 1][dy + 1] > m[dx][dy]) {
            flow(m, dx + 1, dy + 1, ans + m[dx][dy]);
        }
        if (dx + 1 > m.length && m[dx + 1][dy - 1] > m[dx][dy]) {
            flow(m, dx + 1, dy, ans + m[dx][dy]);
        }


    }

    static void bipartie(ArrayList<Edge>[] arrayLists) {
        int b[] = new int[arrayLists.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            b[poll] = 1;
            for (Edge it : arrayLists[poll]) {
                if (b[it.dy] == 0) {
                    b[it.dy] = -b[it.dy];
                    q.add(it.dy);
                } else if (b[it.dy] == b[it.dx]) {
                    return;
                }
            }
        }

        for (int i = 0; i < b.length; i++) {
            if (b[i] == -1) {
                System.out.println(i);
            } else {
                System.out.println(i);
            }
        }

    }

    static void topological(ArrayList<Edge>[] arrayLists) {
        boolean b[] = new boolean[arrayLists.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arrayLists.length; i++) {
            if (b[i] == false) {
                topoutil(b, i, st, arrayLists);
            }
        }
    }

    private static void topoutil(boolean[] b, int i, Stack<Integer> st, ArrayList<Edge>[] arrayLists) {
        b[i] = true;
        for (Edge it : arrayLists[i]) {
            if (b[it.dy] = false) {
                topoutil(b, it.dy, st, arrayLists);
            }
        }
        st.add(i);
    }

    static void allpath(ArrayList<Edge>[] arrayLists, ArrayList<Integer> arr, int des, int val) {
        if (val == des) {
            System.out.println(arr);
            return;
        }
        arr.add(val);
        for (Edge it : arrayLists[val]) {
            allpath(arrayLists, arr, it.dy, it.dx);
        }
        arr.remove(arr.size() - 1);

    }

    static void cheapestflight(ArrayList<Edge>[] arrayLists) {
        PriorityQueue<Root> queue = new PriorityQueue<>();
        queue.add(new Root(0, -1, arrayLists[0].get(0).weight));
        boolean b[] = new boolean[arrayLists.length];
        while (!queue.isEmpty()) {
            Root poll = queue.poll();
            for (Edge it : arrayLists[poll.dx]) {
                if (b[it.dy] == false) {
                    queue.add(new Root(it.dy, it.dx, it.weight + poll.weight));
                }
            }


        }
    }

    static void snakeladder(int arr[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                Integer poll = q.poll();
                for (int i = 1; i <= 6; i++) {
                    if (arr[i + poll] < arr.length && arr[i + poll] == 0) {
                        q.add(i + poll);
                    } else {
                        q.add(arr[i + poll]);
                    }
                    size--;

                }
            }
        }
    }

    static void knight(int m[][], int dx, int dy, int count) {
        int v = m[dx][dy];
        m[dx][dy] = count;
        for (int i = 1; i <= 8; i++) {
            if (dx + x[i] < m.length && dy + y[i] < m.length && m[dx + x[i]][dy + y[i]] == 0) {
                knight(m, dx + x[i], dy + y[i], count + 1);

            }
        }
        m[dx][dy] = v;
    }

    static void rotten(int m[][]) {
        Queue<TicTacToe.Cordinate> q = new LinkedList<>();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] == 2)
                    q.add(new TicTacToe.Cordinate(i, j));
            }
        }

        while (!q.isEmpty()) {
            int val = q.size();
            while (q.size() > 0) {
                TicTacToe.Cordinate poll = q.poll();
                if (poll.x + 1 < m.length && m[poll.x + 1][poll.y + 1] == 1) {
                    m[poll.x + 1][poll.y + 1] = 2;
                    q.add(new TicTacToe.Cordinate(poll.x + 1, poll.y + 1));
                }
            }
        }
    }

    static void wordsearch2(ArrayList<String> arr) {

        Queue<GetString> q = new LinkedList();
        q.add(new GetString(arr.get(0), arr.get(0)));
        boolean b[] = new boolean[arr.size()];
        b[0] = true;
        while (!q.isEmpty()) {
            GetString poll = q.poll();
            if (poll.dx.equals("RES")) {
                System.out.println(poll.dx);
            }
            for (int i = 0; i < arr.size(); i++) {
                if (b[i] == false && poll.dx != arr.get(i)) {
                    b[i] = true;
                    q.add(new GetString(arr.get(i), poll.dy + " -> " + poll.dx));
                }
            }
        }

    }

    static void find(String ans, ArrayList<String> arr, String value, boolean b[], int i) {
        b[i] = true;
        for (int j = 0; j < arr.size(); j++) {
            if (arr.get(j) != value) {
                find(ans + value + " ", arr, arr.get(j), b, j);
            }
        }


    }

    private static void wordutility(Trie trie, String s, char[][] c, int i, int j) {
        if (i < 0 || j < 0 || i >= c.length || j >= c.length || trie.trie[c[i][j] - 'A' + 1] == null) {
            return;
        }
        if (trie.flag == true) {
            System.out.println(s);
        }
        wordutility(trie.trie[c[i][j] - 'A' + 1], s + c[i][j], c, i + 1, j);
        wordutility(trie.trie[c[i][j] - 'A' + 1], s + c[i][j], c, i, j + 1);

    }

    static void wordsearch(String word) {
        Trie tree = new Trie();

        for (int i = 0; i < word.length(); i++) {
            int val = word.charAt(i) - 'A' + 1;
            if (tree.trie[val].flag == false) {
                tree.trie[val] = new Trie();
            }
            tree = tree.trie[val];
        }


    }

    static class Tree {
        int data;
        int height;
        Tree left;
        Tree right;

    }

    static class GenericTree {
        String data;
        ArrayList<GenericTree> child = new ArrayList<>();


    }

    static class GetString {
        String dx;
        String dy;

        public GetString(String dx, String dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }

    static class Trie {
        boolean flag;
        Trie trie[];

        Trie() {
            flag = false;
            trie = new Trie[26];
        }
    }

    static class Edge {
        int dx;
        int dy;
        int weight;

        public Edge(int dx, int dy, int weight) {
            this.dx = dx;
            this.dy = dy;
            this.weight = weight;
        }

        public Edge(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }

    static class Root {
        int dx;
        int dy;
        int weight;

        public Root(int dx, int dy, int weight) {
            this.dx = dx;
            this.dy = dy;
            this.weight = weight;
        }

        public Root(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }


}
