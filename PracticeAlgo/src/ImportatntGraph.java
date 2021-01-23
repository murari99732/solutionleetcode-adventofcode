package practice;

import java.util.*;

public class ImportatntGraph {


    static int xmoves[] = {};
    static int ymove[] = {};

    static void dfs(ArrayList<Edge>[] ar) {
        boolean b[] = new boolean[ar.length];
        for (int i = 0; i < ar.length; i++) {
            if (b[i] == false) {
                DFSUiltiy(i, b, ar);
            }
        }
    }

    private static void DFSUiltiy(int src, boolean[] b, ArrayList<Edge>[] ar) {
        b[src] = true;
        for (Edge it : ar[src]) {
            if (b[it.des] == false) {
                DFSUiltiy(it.des, b, ar);
            }
        }
    }

    static void aksar(ArrayList<Edge>[] ar) {
        boolean b[] = new boolean[ar.length];
        for (int i = 0; i < ar.length; i++) {
            if (b[i] == true) {
                continue;
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                Integer poll = q.poll();

                b[poll] = true;
                for (Edge it : ar[poll]) {
                    if (b[it.des] == false) {
                        q.add(it.des);
                    } else if (b[it.des] == true && poll != it.des) {
                        System.out.println("cycle");
                    }
                }
            }
        }
    }

    static void cycledireced(ArrayList<Edge>[] ar, int src, boolean flag[], boolean temp[]) {
        temp[src] = true;
        flag[src] = true;
        for (Edge it : ar[src]) {
            if (flag[it.des] == true) {
                System.out.println("cycle");
            }
            if (flag[it.des] == false) {
                cycledireced(ar, it.des, flag, temp);
            }
        }
        flag[src] = false;
    }

    static void friendsharing(int adj[][]) {
        boolean b[] = new boolean[adj.length];
        for (int i = 0; i < adj.length; i++) {
            if (b[i] == false) {
                friendutil(b, i, adj);
            }
        }
    }

    private static void friendutil(boolean[] b, int i, int[][] adj) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while (!q.isEmpty()) {
            int v = q.poll();
            b[v] = true;
            for (int j = 0; j < b.length; j++) {
                if (b[j] == false && adj[v][j] != 1) {
                    q.add(j);
                }
            }
        }

    }

    static void mapkey(ArrayList<ArrayList<Integer>> ar) {
        boolean b[] = new boolean[ar.size()];
        int d = 0;

        Queue<Integer> q = new LinkedList<>();
        b[0] = true;
        for (int j = 0; j < ar.get(0).size(); j++) {
            q.add(ar.get(0).get(j));
            b[j] = true;
        }
        while (!q.isEmpty() || q.size() > 0) {
            Integer poll = q.poll();

            for (Integer it : ar.get(poll)) {
                if (b[it] == false) {
                    b[poll] = true;
                    q.add(it);
                }
            }


        }
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }

    static void surroundedregion(char m[][], int x, int y, char replace) {
        if (x == m.length && y == m.length) {
            display(m);
            return;
        }
        if (m.length - 1 <= x || x < 0 || y < 0 || m.length - 1 <= y || m[x][y] == replace) {
            return;
        }

        m[x][y] = replace;
        surroundedregion(m, x + 1, y, replace);
        surroundedregion(m, x, y + 1, replace);
        surroundedregion(m, x - 1, y, replace);
        surroundedregion(m, x, y - 1, replace);
    }

    static void clonegraph(ArrayList<Edge>[] ar) {
        Map<Integer, ArrayList<Edge>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        ArrayList<Edge> br = new ArrayList<>();
        boolean b[] = new boolean[ar.length];
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            b[poll] = true;
            for (Edge it : ar[poll]) {
                if (b[it.des] == false) {
                    if (map.containsKey(it.src)) {
                        ArrayList<Edge> edges = map.get(it.src);
                        edges.add(new Edge(it.src, it.des, it.weight));
                        map.put(it.src, edges);
                        q.add(it.des);
                    } else {
                        ArrayList<Edge> arrayList = new ArrayList<>();
                        arrayList.add(new Edge(it.src, it.des, it.weight));
                        map.put(it.src, arrayList);
                        q.add(it.des);
                    }
                }
            }
        }
        System.out.println(map);
        ArrayList<Edge>[] cr = new ArrayList[map.size()];
        for (Integer it : map.keySet()) {
            ArrayList<Edge> arrayList = map.get(it);
            cr[it] = arrayList;
        }
        Arrays.stream(cr).forEach(a -> System.out.println(a));
    }

    private static void display(char[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + "   ");
            }
            System.out.println();
        }
    }

    static void wordsearch(char m[][], String word, int x, int y, String pattern, int idx) {
        if (m.length == x && m.length == y) {
            return;
        }
        if (x > 0 || y > 0 || m.length <= x || m.length <= y || m[x][y] != pattern.charAt(idx)) {
            return;
        }
        word = word + m[x][y];
        if (word.equals(pattern)) {
            System.out.println("found");
            return;
        }
        wordsearch(m, word, x + 1, y, pattern, idx + 1);
        wordsearch(m, word, x, y + 1, pattern, idx + 1);
        wordsearch(m, word, x - 1, y, pattern, idx + 1);
        wordsearch(m, word, x, y - 1, pattern, idx + 1);
        word = word.substring(0, word.length() - 1);
    }

    static void wordsearch2(ArrayList<String> ar, char c[][]) {
        Trie tr = new Trie();
        for (int i = 0; i < ar.size(); i++) {
            insert(tr, ar.get(i));
        }
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (tr.label[Integer.parseInt(String.valueOf(c[i][j]))] != null) {
                    ArrayList<String> dc = new ArrayList<>();

                }
            }
        }


    }

    private static void wordsearchutils(ArrayList<String> list, Trie tr, char[][] c, int i, int j, String dc) {
        if (i < 0 || j < 0 || i >= c.length || j >= c.length || c[i][j] == '*' || tr == null) {
            return;
        }
        dc = dc + c[i][j];
        if (tr.isFlag == true) {
            list.add(dc);
            dc = "";
        }
        char temp = c[i][j];
        c[i][j] = '*';
        wordsearchutils(list, tr.label[Integer.parseInt(String.valueOf(temp))], c, i + 1, j, dc);
        wordsearchutils(list, tr.label[Integer.parseInt(String.valueOf(c[i][j]))], c, i, j + 1, dc);
        wordsearchutils(list, tr.label[Integer.parseInt(String.valueOf(c[i][j]))], c, i - 1, j, dc);
        wordsearchutils(list, tr.label[Integer.parseInt(String.valueOf(c[i][j]))], c, i - 1, j, dc);
        c[i][j] = temp;


    }

    private static void insert(Trie tr, String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (tr.label[Integer.parseInt(String.valueOf(c))] == null) {
                tr.label[Integer.parseInt(String.valueOf(c))] = new Trie();
            }
            tr = tr.label[Integer.parseInt(String.valueOf(c))];
        }
        tr.isFlag = true;

    }

    static void wordladder(ArrayList<String> word) {
        HashMap<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < word.size(); i++) {
            map.put(word.get(i), false);
        }
        Queue<Ladder> q = new LinkedList<>();
        q.add(new Ladder(word.get(0), ""));
        map.put(word.get(0), true);

        while (!q.isEmpty()) {
            Ladder poll = q.poll();
            map.put(poll.start, true);
            if (poll.start.equals("cog")) {
                System.out.println(poll.path);

            }
            for (String it : word) {
                if (getonlycharacters(it, poll.start) && map.get(it) == false) {
                    q.add(new Ladder(it, poll.path + poll.start + "   "));

                }
            }
        }
    }

    private static boolean getonlycharacters(String match, String start) {
        if (match.length() != start.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < match.length(); i++) {
            if (match.charAt(i) != start.charAt(i)) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    static void rottenoranges(int m[][]) {
        Queue<Cordinates> q = new LinkedList<>();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] == 2) {
                    q.add(new Cordinates(i, j));
                }
            }
        }
        int php = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                Cordinates poll = q.poll();
                if (m[poll.x - 1][poll.y] == 1) {
                    q.add(new Cordinates(poll.x - 1, poll.y));
                }
                if (m[poll.x + 1][poll.y] == 1) {
                    q.add(new Cordinates(poll.x + 1, poll.y));
                }
                if (m[poll.x][poll.y - 1] == 1) {
                    q.add(new Cordinates(poll.x, poll.y + 1));
                }
                if (m[poll.x][poll.y + 1] == 1) {
                    q.add(new Cordinates(poll.x, poll.y + 1));
                }
                size--;
            }
            php++;
        }
        System.out.println(php);
    }

    static void chess(int m[][], int x, int y, int count) {

        m[x][y] = count;
        for (int i = 0; i < 8; i++) {
            if (m[x + xmoves[i]][y + ymove[i]] == 0) {
                chess(m, x + xmoves[i], y + ymove[i], count + 1);
            }
        }
        m[x][y] = 0;
    }

    static void knight(int m[][]) {
        Queue<Cordinates> q = new LinkedList<>();
        q.add(new Cordinates(0, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                Cordinates poll = q.poll();
                for (int i = 0; i < 8; i++) {
                    if (poll.x + i < m.length && m[poll.x + i][poll.y + i] == 0) {

                    }
                }
            }

        }
    }

    static void chessv(int m[][], int x, int y, int count) {
        m[x][y] = count;
        chessv(m, x + 1, y + 1, count + 1);
        m[x][y] = 0;
    }

    static void topo(ArrayList<Edge>[] ar) {
        boolean visited[] = new boolean[ar.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < ar.length; i++) {
            if (visited[i] == false) {
                topoutils(visited, i, ar, st);
            }
        }
        while (!st.isEmpty()) {
            st.pop();
        }
    }

    private static void topoutils(boolean[] visited, int i, ArrayList<Edge>[] ar, Stack<Integer> st) {
        visited[i] = true;
        for (Edge it : ar[i]) {
            if (visited[it.des] == false) {
                topoutils(visited, it.des, ar, st);
            }
        }
        st.push(i);
    }


    static void snakeladders(int arr[]) {
        Queue<Snake> q = new LinkedList<>();
        q.add(new Snake(arr[0], ""));
        int v = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                Snake poll = q.poll();
                for (int i = 1; i <= 6; i++) {
                    if (poll.idx + i < arr.length) {
                        if (arr[poll.idx + i] == 0) {
                            q.add(new Snake(poll.idx + i, poll.path + ""));
                        } else {
                            q.add(new Snake(arr[poll.idx + i], poll.path));
                        }
                    }
                }
                v++;
            }
        }
    }

    static void cheapestflight(ArrayList<ArrayList<Integer>> ar) {
        ArrayList<Edge>[] brr = new ArrayList[ar.size()];
        for (int i = 0; i < ar.size(); i++) {
            brr[ar.get(i).get(0)].add(new Edge(ar.get(i).get(0), ar.get(i).get(1), ar.get(i).get(3)));
        }

        Queue<Rode> q = new LinkedList<>();
        q.add(new Rode(brr[0].get(0).src, "", brr[0].get(0).weight));
        while (!q.isEmpty()) {
            Rode poll = q.poll();
            for (Edge it : brr[poll.src]) {
                q.add(new Rode(it.src, "", poll.weight + it.weight));
            }
        }

    }

    static void iternatory(ArrayList<ArrayList<String>> ar) {
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < ar.size(); i++) {
            map.put(ar.get(i).get(0), false);
            map.put(ar.get(i).get(1), false);
        }
        Queue<Sode> q = new LinkedList<>();
        q.add(new Sode("JFK", "JFK" + " "));
        while (!q.isEmpty()) {
            Sode poll = q.poll();
            if(poll.src.equals("SJC"))
            {
                System.out.println(poll.path);
            }
            map.put(poll.src, true);
            for (int i = 0; i < ar.size(); i++) {
                if (ar.get(i).get(0).equals(poll.src)) {
                    if (map.get(ar.get(i).get(1)) == false) {
                        q.add(new Sode(ar.get(i).get(1), poll.path + ar.get(i).get(1) + " "));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> brr= new ArrayList<>();
        ArrayList<String> ar = new ArrayList<>();
        ar.add("MUC");
        ar.add("LHR");
        ArrayList<String> br = new ArrayList<>();
        br.add("JFK");
        br.add("MUC");
        ArrayList<String> cr = new ArrayList<>();
        cr.add("SFO");
        cr.add("SJC");
        ArrayList<String> dr = new ArrayList<>();
        dr.add("LHR");
        dr.add("SFO");
        brr.add(ar); brr.add(br); brr.add(cr); brr.add(dr);
        iternatory(brr);
    }

    static class Sode {
        String src;
        String path;

        public Sode(String src, String path) {
            this.src = src;
            this.path = path;
        }
    }

    static class Rode {
        int src;
        String path;
        int weight;

        public Rode(int src, String path, int weight) {
            this.src = src;
            this.path = path;
            this.weight = weight;
        }
    }

    static class Snake {
        int idx;
        String path;

        public Snake(int idx, String path) {
            this.idx = idx;
            this.path = path;
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

    static class Ladder {
        String start;
        String path;

        public Ladder(String start, String path) {
            this.start = start;
            this.path = path;
        }
    }

    static class Trie {
        boolean isFlag;
        Trie label[];

        public Trie() {
            this.isFlag = false;
            this.label = new Trie[26];
        }
    }

    static class Edge {
        int src;
        int des;
        int weight;

        public Edge(int src, int des, int weight) {
            this.src = src;
            this.des = des;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "src=" + src +
                    ", des=" + des +
                    ", weight=" + weight +
                    '}';
        }
    }
}
