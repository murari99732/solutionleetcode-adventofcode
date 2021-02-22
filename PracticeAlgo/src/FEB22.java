

import java.util.*;

public class FEB22 {
    public static final int FIVE_SECONDS = 5000;
    public static final int MAX_Y = 400;
    public static final int MAX_X = 400;

    public static void main(String... args) throws Exception {
        singlenumber(new int[]{2, 1, 1,2,3,1,2,2});
    }

    static void singlenumber(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        int w = 0;
        int p = 0;
        while (sum != 0) {
            int v = sum & -sum;
            int k = 0;
            for (int i = 0; i < arr.length; i++) {
                int y = arr[i] & 1 << w;
                if (y != 0) {
                    k++;
                }
            }
            if (k % 3 != 0) {
                p = p | 1 << w;
            }
            w++;
            sum = sum - v;
        }
        System.out.println(p);
    }

    static void subset(int arr[], int val, ArrayList<Integer> ar, int count) {
        System.out.println(ar);

        for (int j = count; j < arr.length; j++) {
            if (arr[j] % val == 0) {
                ar.add(val);
                subset(arr, arr[j], ar, j);
                ar.remove(ar.size() - 1);
            }
        }
    }

    static void subset(int arr[], ArrayList<Integer> ar, int i) {
        ArrayList<Integer> br = new ArrayList<>();
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] % arr[j] == 0 || arr[j] % arr[i] == 0) {
                ar.add(arr[i]);
                subset(arr, ar, j);
                ar.remove(arr[i]);
            }
        }
    }

    static void largest(int arr[]) {
        int parent[] = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 2; j <= Math.sqrt(arr[i]); j++) {
                if (arr[i] % j == 0) {
                    parentval(parent, arr[i], j);
                    parentval(parent, arr[i], arr[i] / j);
                }
            }
        }
    }

    private static void parentval(int[] parent, int id, int val) {
        int v = getch(parent, id);
        int w = getch(parent, val);
        if (v != w) {
            parent[w] = v;
        }
    }

    private static int getch(int[] parent, int id) {
        if (id == -1) {
            return id;
        }
        parent[id] = getch(parent, parent[id]);
        return parent[id];
    }

    static void search(int arr[], int val) {
        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {

            int mid = (i + j) / 2;
            if (i == j) {
                System.out.println(i + 1);
                break;
            }
            if (arr[mid] < val) {
                i = mid + 1;
            } else if (arr[mid] > val) {
                j = mid - 1;
            } else {
                System.out.println(mid);
                return;
            }
        }
    }

    static void keysroom(ArrayList<Cordinate> ar) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean b[] = new boolean[ar.size()];
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (int i = 0; i < ar.size(); i++) {
                if (b[i] == false) {
                    q.add(i);
                }
            }
        }
    }

    static int coinchange(int coins[], int index, int amount, int val) {
        if (amount == val) {
            return 1;
        } else if (amount < val) {
            return 0;
        }
        int v = 0;
        for (int i = index; i < coins.length; i++) {
            if (val + coins[index] <= amount) {
                v = v + coinchange(coins, i, amount, val + coins[i]);
            }
        }
        return v;
    }

    static void queuerecons(ArrayList<Cordinate> ar) {
        Collections.sort(ar, (a, b) -> {
            if (a.x != b.x) return b.x - a.x;
            else return a.y - b.y;
        });
        ArrayList<Cordinate> arr = new ArrayList<>();
        for (int i = 0; i < ar.size(); i++) {
            arr.add(ar.get(i).y, ar.get(i));
        }
    }

    static int count() {
        Random r = new Random();
        return r.nextInt(10);
    }

    static int getamount(int coin[], int amount, int i) {
        if (amount == 0) {
            return 1;
        }
        int count = 0;
        for (int j = i; j < coin.length; j++) {
            if (amount >= coin[i]) {
                count = count + getamount(coin, amount - coin[j], j);
            }
        }
        return count;
    }

    static void sorting(ArrayList<Cordinate> ar) {
        Collections.sort(ar, (a, b) -> {
            if (a.x == b.x)
                return a.y - b.y;
            return b.x - a.x;
        });
        System.out.println(ar);
    }

    static void randompic(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        Random r = new Random(sum);
        r.nextInt();
    }

    static void findlowest(Cordinate arr[]) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int dx = arr[i].x * arr[i].x;
            int dy = arr[i].y * arr[i].y;
            int val = (int) Math.sqrt(dx - 0 + dy - 0);
            min = Math.min(val, min);

        }
    }

    static int findbits(int n) {
        if (n == 0) {
            return 0;
        }
        int m = findbits(n - 1);

        int v = n;
        int count = 0;
        while (v != 0) {
            int x = v & -v;
            v = v - x;
            count++;
        }
        m = m + count;
        return m;
    }

    static void longestcomponennt(int arr[]) {
        int parent[] = new int[1000];
        Arrays.fill(parent, -1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 2; j < Math.sqrt(arr[i]); j++) {
                if (arr[i] % j == 0) {
                    putparent(arr[i], parent, j);
                    putparent(arr[i], parent, arr[i] / j);
                }
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int p = getparent(parent, arr[i]);
            map.put(p, map.getOrDefault(p, 0) + 1);

        }
    }

    private static void putparent(int i, int[] parent, int j) {
        int a = getparent(parent, j);
        int b = getparent(parent, i);
        if (a != b) {
            a = b;
        }
    }

    private static int getparent(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        parent[i] = getparent(parent, parent[i]);
        return parent[i];
    }

    static void findpath(ArrayList<ArrayList<Integer>> ar) {
        Queue<Pathalu> q = new LinkedList<>();
        q.add(new Pathalu(0, ""));
        boolean b[] = new boolean[ar.size()];
        while (!q.isEmpty()) {
            Pathalu poll = q.poll();
            b[poll.idx] = true;
            for (Integer it : ar.get(poll.idx)) {
                if (b[it] == false) {
                    q.add(new Pathalu(it, poll.path + poll.idx + " "));
                }
            }

        }
    }

    static void iternary(ArrayList<ArrayList<String>> ar, String src, String des) {
        Queue<PathVal> q = new LinkedList<>();
        q.add(new PathVal(src, ""));
        while (!q.isEmpty()) {
            PathVal poll = q.poll();
            if (poll.src.equals(des)) {
                System.out.println(poll.path + des);
            }

            for (int i = 0; i < ar.size(); i++) {
                if (ar.get(i) != null && ar.get(i).get(0).equals(poll.src)) {
                    q.add(new PathVal(ar.get(i).get(1), poll.path + ar.get(i).get(0) + " "));
                }
            }
        }
    }

    static void chepestflight(ArrayList<ArrayList<Cordinate>> ar, int src, int des) {
        PriorityQueue<Flight> p = new PriorityQueue<Flight>();
        p.add(new Flight(src, 0, ""));
        boolean b[] = new boolean[ar.size()];
        while (!p.isEmpty()) {
            int size = p.size();
            while (size > 0) {
                Flight poll = p.poll();
                if (poll.des == des) {
                    System.out.println(poll.path + "                       " + poll.cost);
                    return;
                }
                for (Cordinate it : ar.get(poll.des)) {
                    if (b[it.y] = false) {
                        p.add(new Flight(it.y, it.count, poll.path + it.x + " "));

                    }

                }
            }

        }

    }

    static void snakelad(int m[][], int idx, int dy) {
        Queue<Snake> q = new LinkedList<>();
        q.add(new Snake(0, 0, 0, ""));
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                Snake poll = q.poll();
                int fx = 0;
                int fy = 0;
                if (poll.dx == m.length && poll.dy == m.length) {
                    System.out.println(poll.count + " " + poll.path);
                    return;
                }
                for (int i = dy + 1; i < dy + 6; i++) {
                    if (i >= poll.dy) {
                        fy = i % 6;
                        fx = poll.dx + 1;
                    } else {
                        fx = poll.dx;
                        fy = i;
                    }
                    if (m[fx][fy] == -1) {
                        q.add(new Snake(fx, fy, poll.count + 1, poll.path + " { " + fx + "  " + fy + " } "));
                    } else {
                        int value = m[fx][fy];
                        double val = value / m.length;
                        val = Math.ceil(val);
                        int dyx = (int) val - value;
                        int vw = convertv(value, m.length, m.length, m);
                        q.add(new Snake((int) val, vw, poll.count + 1, poll.path + " { " + val + "  " + vw + " } "));
                    }
                }
                size--;
            }
        }
    }

    private static int convertv(int value, int length, int length1, int m[][]) {

        double val = value / length;
        val = Math.ceil(val);
        int dy = (int) val - value;
        return m[(int) val][6 - dy];

    }

    static void ladders(int arr[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(arr[0]);
        int j = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int value = q.poll();
                if (value == arr.length) {
                    System.out.println(j);
                }
                for (int i = 1; i <= 6; i++) {
                    if (value + arr[i] < arr.length) {
                        if (arr[i + value] == -1) {
                            q.add(i + value);
                        } else {
                            q.add(arr[i + value]);
                        }
                    }
                }
            }
            j++;
        }
    }

    static void rottenorange(int m[][]) {
        Queue<Cordinate> q = new LinkedList<>();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] == 2) {
                    q.add(new Cordinate(i, j));
                }
            }
        }
        boolean b[][] = new boolean[m.length][m.length];
        int i = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                Cordinate poll = q.poll();
                if (poll.x + 1 < m.length && poll.x + 1 < m.length && m[poll.x + 1][poll.y] == 1) {
                    m[poll.x + 1][poll.y] = 2;
                    q.add(new Cordinate(poll.x + 1, poll.y));
                }
                if (poll.y + 1 < m.length && poll.y + 1 < m.length && m[poll.x][poll.y + 1] == 1) {
                    m[poll.x][poll.y + 1] = 2;
                    q.add(new Cordinate(poll.x, poll.y + 1));
                }
                if (poll.x - 1 < m.length && poll.x - 1 < m.length && m[poll.x - 1][poll.y] == 1) {
                    m[poll.x - 1][poll.y] = 2;
                    q.add(new Cordinate(poll.x - 1, poll.y));
                }
                if (poll.y - 1 < m.length && poll.y - 1 < m.length && m[poll.x][poll.y - 1] == 1) {
                    m[poll.x][poll.y - 1] = 2;
                    q.add(new Cordinate(poll.x, poll.y - 1));
                }
                size--;
            }
            i++;
        }
    }

    static void wordladder(ArrayList<String> ar, String start, String end) {
        Queue<Ladder> q = new LinkedList<>();
        q.add(new Ladder(start, start + "  "));
        while (!q.isEmpty()) {
            Ladder poll = q.poll();
            if (poll.word.equals(end)) {
                System.out.println(poll.path);
            }
            for (int i = 0; i < ar.size(); i++) {
                if (issafe(ar.get(i), poll.word)) {
                    q.add(new Ladder(ar.get(i), poll.path + ar.get(i) + "  "));
                }
            }
        }
    }

    private static boolean issafe(String s, String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            if (map.containsKey(word.charAt(i))) {
                Integer integer = map.get(word.charAt(i));
                if (integer - 1 == 0) {
                    map.remove(word.charAt(i));
                } else {
                    map.put(word.charAt(i), integer - 1);
                }
            } else {
                sum++;
            }
        }


        if (sum == 1) {
            return true;
        } else return false;
    }

    static void searchword(char m[][]) {
        Trie trie = new Trie();
        ArrayList<String> ar = new ArrayList<>();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                char c = m[i][j];
                int v = c - 'A' + 1;
                if (trie.trie[v] != null) {
                    searchvalue(trie, m, i, j, "", ar);
                }
            }
        }
    }

    private static void searchvalue(Trie trie, char[][] m, int i, int j, String s, ArrayList<String> ar) {
        if (i == m.length && j == m.length) {
            return;
        }
        int v = m[i][j] - 'A' + 1;
        if (i < 0 || j < 0 || i >= m.length || j >= m.length || trie.trie[v] == null)
            return;
        if (trie.isflag) {
            ar.add(s);
        }
        searchvalue(trie.trie[v], m, i + 1, j, s + m[i][j] + "", ar);
        searchvalue(trie.trie[v], m, i, j + 1, s + m[i][j] + "", ar);
        searchvalue(trie.trie[v], m, i - 1, j, s + m[i][j] + "", ar);
        searchvalue(trie.trie[v], m, i, j - 1, s + m[i][j] + "", ar);
    }

    static void wordsearch(Trie trie, String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int v = c - 'A' + 1;
            if (trie.trie[v] == null) {
                trie.trie[v] = new Trie();
            }
            trie = trie.trie[v];
        }
        trie.isflag = true;
    }

    static void search(Trie trie, String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int v = c - 'A' + 1;
            if (trie.trie[v] == null) {
                System.out.println("not found");
                return;
            }
            trie = trie.trie[v];
        }
        trie.isflag = true;
        System.out.println("found");
        return;
    }

    static void DFS(int m[][]) {
        boolean b[] = new boolean[m.length];
        for (int i = 0; i < b.length; i++) {
            if (b[i] == false) {
                DFSutility(m, i, b);
            }
        }
    }

    static void stronglyconnected(ArrayList<Cordinate>[] ar) {
        boolean b[] = new boolean[ar.length];
        for (int i = 0; i < ar.length; i++) {
            if (b[i] == false) {
                boolean bc = DFSuti(b, ar, i);
                if (bc == true) {
                    return;
                }
            }
        }
    }

    static void getvalue(boolean b[], int val, int m[][]) {
        b[val] = true;
        for (int i = 0; i < m.length; i++) {
            if (b[i] == false && m[val][i] == 1) {
                getvalue(b, i, m);
            }
        }
    }

    private static boolean DFSuti(boolean[] b, ArrayList<Cordinate>[] ar, int i) {

        b[i] = true;
        int v = 0;
        for (Cordinate it : ar[i]) {
            if (b[it.y] == false) {
                v++;
                DFSuti(b, ar, it.y);
            }
        }
        if (v != ar.length - 1) {
            return false;
        }
        b[i] = false;
        return false;
    }

    static void clonegraph(ArrayList<Cordinate>[] ar) {
        Map<Integer, ArrayList<Cordinate>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean b[] = new boolean[ar.length];
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int v = q.poll();
                b[v] = true;
                ArrayList<Cordinate> val = new ArrayList<>();
                for (Cordinate it : ar[v]) {
                    val.add(it);
                    if (b[it.y] == false) {
                        q.add(it.y);
                    }
                }
                map.put(v, val);
                size--;
            }
        }
        System.out.println(map);
    }

    static void findisland(int m[][], int val, boolean b[]) {
        b[val] = true;
        for (int i = 0; i < m.length; i++) {
            if (b[i] == true && m[val][i] == 1) {
                findisland(m, i, b);
            }
        }
    }

    public static int islandPerimeter(int[][] grid, int x, int y, int count) {
        int val = 0;
        islandPerimeter(grid, x, y, count + val);
        islandPerimeter(grid, x, y, count + val);
        return 0;
    }

    static void keys(ArrayList<ArrayList<Integer>> ar) {

        boolean b[] = new boolean[ar.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(ar.get(0).get(0));
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                Integer poll = q.poll();
                b[poll] = true;
                for (Integer it : ar.get(poll)) {
                    if (b[it] == false) {
                        q.add(it);
                    }
                }
                size--;
            }
        }

    }

    static void DFSutility(int m[][], int val, boolean b[]) {
        b[val] = true;

        for (int i = 0; i < m.length; i++) {
            if (b[val] == false && m[val][i] == 1 && val != i) {
                DFSutility(m, i, b);
            }
        }


    }

    static void bfs(int m[][]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean b[] = new boolean[m.length];
        while (!q.isEmpty()) {
            int v = q.poll();
            b[v] = true;
            for (int i = 0; i < m.length; i++) {
                if (b[i] == false && i != v && m[v][i] == 1) {
                    q.add(i);
                }
            }
        }
    }

    public static void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        while (j < nums.length && j <= k) {
            if (nums[j] == 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;


            } else if (nums[j] == 1) {
                j++;
            } else {
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                k--;


            }
        }
        Arrays.stream(nums).forEach(a -> System.out.print(a + " "));
    }

    static class Pathalu {
        int idx;
        String path;

        public Pathalu(int idx, String path) {
            this.idx = idx;
            this.path = path;
        }
    }

    static class PathVal {
        String src;
        String path;

        public PathVal(String src, String path) {
            this.src = src;
            this.path = path;
        }
    }

    static class Flight {
        int des;
        int cost;
        String path;

        public Flight(int des, int cost, String path) {
            this.des = des;
            this.cost = cost;
            this.path = path;
        }
    }

    static class Snake {
        int dx;
        int dy;
        int count;
        String path;

        public Snake(int dx, int dy, int count, String path) {
            this.dx = dx;
            this.dy = dy;
            this.count = count;
            this.path = path;
        }
    }

    static class Ladder {
        String word;
        String path;

        public Ladder(String word, String path) {
            this.word = word;
            this.path = path;
        }
    }

    static class Trie {
        boolean isflag;
        Trie trie[];

        public Trie() {
            this.isflag = false;
            this.trie = new Trie[26];
        }
    }

    static class Rest {
        int x;
        int y;
        int count;

        public Rest(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static class Cordinate {
        int x;
        int y;
        int count;

        public Cordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Cordinate(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Cordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
