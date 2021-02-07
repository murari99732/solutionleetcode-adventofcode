
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UnionFindFeb8 {
    static void union(int parent[], int first, int second) {
        int a = findparent(parent, first);
        int b = findparent(parent, second);
        if (a != b) {
            parent[b] = a;
        }

    }

    private static int findparent(int[] parent, int second) {
        if (parent[second] == -1) {
            return second;
        }
        parent[second] = findparent(parent, parent[second]);
        return parent[second];
    }

    public static void main(String[] args) {
        int parent[] = new int[1000];
        Arrays.fill(parent, -1);
        union(parent, 5, 4);
        union(parent, 1, 2);
        union(parent, 2, 3);
        union(parent, 1, 3);
        union(parent, 4, 5);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            int a = findparent(parent, i);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        System.out.print(map.values());

    }
}
