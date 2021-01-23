

import java.util.*;

public class CloneGraph24Jan {


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
        ArrayList<Edge>[] cr= new ArrayList[map.size()];
        for(Integer it:map.keySet())
        {
            ArrayList<Edge> arrayList = map.get(it);
            cr[it]=arrayList;
        }
        Arrays.stream(cr).forEach(a->System.out.println(a));
    }

    private static void display(char[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] ar= new ArrayList[4];
        for(int i=0;i<ar.length;i++)
        {
            ar[i]= new ArrayList<>();
        }
        ar[0].add(new Edge(0,1,3));
        ar[0].add(new Edge(0,2,4));
        ar[1].add(new Edge(1,3,3));
        ar[1].add(new Edge(1,2,4));
        ar[2].add(new Edge(2,3,3));
        ar[2].add(new Edge(2,0,4));
        clonegraph(ar);
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
