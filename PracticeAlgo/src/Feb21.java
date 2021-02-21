

import java.util.*;

public class Feb21 {
    public static void main(String[] args) {


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
