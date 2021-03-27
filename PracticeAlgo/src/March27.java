package practice;

import java.util.LinkedList;
import java.util.*;

public class March27 {

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

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("ABC");
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

        public Edge(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }

    static class Root {
        int dx;
        int dy;

        public Root(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }


}
