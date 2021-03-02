

import java.util.*;

public class March3 {
    static int count = 0;

    public static void main(String[] args) {
        ArrayList<Cordinates> ar= new ArrayList<>();
        ar.add(new Cordinates(7,0));
        ar.add(new Cordinates(4,4));
        ar.add(new Cordinates(7,1));
        ar.add(new Cordinates(5,0));
        ar.add(new Cordinates(6,1));
        ar.add(new Cordinates(5,2));
        reconstructQueue(ar);
    }

    public static void reconstructQueue(ArrayList<Cordinates> people) {

        Collections.sort(people, (a, b) -> {
            if (a.val == b.val)
                return a.wal - b.wal;
            return b.val - a.val;
        });

        for (int i = 0; i < people.size(); i++) {
            Cordinates ct = people.get(i);
            people.remove(ct);
            people.add(ct.wal, ct);
        }
        System.out.print(people);

    }

    static void getheight(TreeNode tr) {
        if (tr == null) {
            return;
        }
        getheight(tr.left);
        if (count == 3) {
            System.out.print(tr.data);
        }
        count++;
        getheight(tr.right);
    }

    public static int subarraysDivByK(int[] A, int K) {
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
            if (map.containsKey(sum % K)) {
                count++;

            } else {
                map.put(sum, i);
            }
        }
        return count;
    }

    public static int search(int[] nums, int target) {
        PriorityQueue<Integer> pr = new PriorityQueue<>();
        pr.element();
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                System.out.print(mid);
                return mid;
            }
            if (nums[mid] >= nums[i]) {
                if (nums[i] <= target && nums[mid] >= target) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (nums[j] >= target && nums[mid] <= target) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }

        }

        return -1;

    }

    static int knapsackrecu(int weight[], int price[], int mass, int value, int idx) {
        if (mass == 0) {
            return 0;
        }
        if (idx >= weight.length) {
            return 0;
        }
        int max = 0;
        for (int i = idx; i < weight.length; i++) {
            if (mass >= 0) {
                int a = knapsackrecu(weight, price, mass - weight[idx], value, i + 1) + price[idx];
                int b = knapsackrecu(weight, price, mass, value, i + 1);
                max = Math.max(a, b);
                return max;
            } else {
                int b = knapsackrecu(weight, price, mass, value, i + 1);
                return b;
            }
        }
        return -1;
    }

    public static List<Integer> largestDivisibleSubset(int[] arr) {

        int dp[] = new int[arr.length];
        int dx = 0;
        int fx = 0;
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && max < dp[j] + 1) {
                    max = dp[j] + 1;
                }

            }
            if (dx < max) {
                dx = max;
                fx = i;
            }
            dp[i] = max;
        }
        Arrays.stream(dp).forEach(a -> System.out.print(a + " "));
        Queue<Cordinates> q = new LinkedList<>();
        ArrayList<Integer> arr1 = new ArrayList<>();
        q.add(new Cordinates(fx, arr[fx]));
        arr1.add(arr[fx]);
        while (!q.isEmpty()) {
            Cordinates c = q.poll();
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] == c.val - 1) {
                    arr1.add(arr[i]);
                    q.add(new Cordinates(c.val - 1, arr[i]));
                }
            }
        }
        return arr1;

    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
    }

    static class Cordinates {
        int val;
        int wal;

        Cordinates(int val, int wal) {
            this.val = val;
            this.wal = wal;
        }

        @Override
        public String toString() {
            return "Cordinates{" +
                    "val=" + val +
                    ", wal=" + wal +
                    '}';
        }
    }
}
