package LeetCode;

import java.util.*;

public class HeapProblem {


    static PriorityQueue<Integer> pr = new PriorityQueue<>();

    static void longestsubarrayonetwozero(int arr[]) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> zero = new HashMap<>();
        HashMap<Integer, Integer> one = new HashMap<>();
        HashMap<Integer, Integer> two = new HashMap<>();
        zero.put(0, 0);
        zero.put(1, 0);
        zero.put(2, 0);
        for (int i = 0; i < arr.length; i++) {
            zero.put(arr[i], zero.getOrDefault(arr[i], 0) + 1);
            int i1 = zero.get(2) - zero.get(1);
            int i2 = zero.get(1) - zero.get(0);
            if (map.containsKey(i2 + "##" + i1)) {
                System.out.println(map.get(i2 + "##" + i1) + "   " + i);
            } else {
                map.put(i2 + "##" + i1, i);
            }

        }
    }

    static void pair(int arr[]) {
        HashMap<Integer, Cordinate> map = new HashMap<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                map.put(sum, new Cordinate(i, j));
            }
        }
    }

    static void fraction(int value, int div) {
        Set<Integer> map = new HashSet<>();
        int rem = value / div;
        int temp = value - rem * div;

        String digit = rem + ".";

        while (!map.contains(temp) && temp != 0) {
            map.add(temp);

            int val = temp * 10;
            int dc = val / div;
            temp = val - dc * div;

            digit = digit + dc;
        }
        System.out.println(digit);
    }

    static void mappingwithfirsttosec(String a, String b) {
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < b.length(); i++) {
            hashMap.put(b.charAt(i), false);
        }
        for (int i = 0; i < a.length(); i++) {
            if (map.containsKey(a.charAt(i))) {
                Character character = map.get(a.charAt(i));
                if (b.charAt(i) != character) {
                    System.out.println(false);
                    return;
                }
            } else {
                if (hashMap.get(b.charAt(i)) == false) {
                    map.put(a.charAt(i), b.charAt(i));
                    hashMap.put(b.charAt(i), true);
                } else {
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
        return;
    }

    static void rabbit(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int sum = 0;
        for (Integer it : map.keySet()) {
            int val = map.get(it);
            if (val != 0 && it != 0) {
                double d = val / (it + 1);
                int c = val / (it + 1);
                if (c == d) {
                    sum = sum + c;
                } else {
                    sum = sum + val;
                }
            } else {
                sum = sum + val;
            }
        }
        System.out.println(sum);
    }

    static void smallestarrayfrqeuncymost(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int v = 0;
        ArrayList<Integer> brr = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (v < map.get(arr[i])) {
                v = map.get(arr[i]);
            }
        }
        for (Integer key : map.keySet()) {
            if (v == map.get(key)) {
                brr.add(key);
            }
        }

        HashMap<Integer, ArrayList<Integer>> ban = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (brr.contains(arr[i])) {
                if (ban.containsKey(arr[i])) {
                    ArrayList<Integer> cr = ban.get(arr[i]);
                    cr.add(i);
                    if (cr.size() == v) {
                        int first = cr.get(0);
                        min = Math.min(i - first, min);
                    }

                } else {
                    ArrayList<Integer> ar = new ArrayList<>();
                    ar.add(i);
                    ban.put(arr[i], ar);
                }
            }
        }
        System.out.println(min);


    }

    static void taskcompletion(int arr[]) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                if (map.containsKey(1)) {
                    ArrayList<Integer> ar = map.get(1);
                    ar.add(arr[i]);
                    map.put(1, ar);
                } else {
                    ArrayList<Integer> ar = new ArrayList<>();
                    ar.add(arr[i]);
                    map.put(1, ar);
                }
            } else {
                if (map.containsKey(2)) {
                    ArrayList<Integer> ar = map.get(2);
                    ar.add(arr[i]);
                    map.put(2, ar);
                } else {
                    ArrayList<Integer> ar = new ArrayList<>();
                    ar.add(arr[i]);
                    map.put(2, ar);
                }
            }
        }
        System.out.println(map);
    }

    static void findsum(int m[][], int n[][], int val) {
        int mx = 0;
        int my = 0;
        int nx = m.length - 1;
        int ny = m.length - 1;
        while (my != 3 && ny != 0) {
            int sum = m[my][mx] + n[ny][nx];
            if (val > sum) {
                mx = mx + 1;
                if (mx == 3) {
                    mx = 0;
                    my = my + 1;
                }
            } else if (val < sum) {
                nx = nx - 1;
                if (nx == -1) {
                    nx = 3;
                    ny = ny - 1;
                }
            } else {
                System.out.println(n[ny][nx] + " " + m[my][mx] + " " + val);
                mx = mx + 1;
                ny = ny - 1;
                if (mx == 3) {
                    mx = 0;
                    my = my + 1;
                }
                if (nx == -1) {
                    nx = 3;
                    ny = ny - 1;
                }

            }
        }
    }

    static void kthlargest(int arr[], int k) {
        PriorityQueue<Integer> pr = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pr.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (pr.peek() < arr[i]) {
                pr.poll();
                pr.add(arr[i]);
            }
        }
        System.out.println(pr);
    }

    public static void main(String[] args) {

        streamlargest(1);
        streamlargest(5);
        streamlargest(12);
        streamlargest(3);
        streamlargest(10);
        streamlargest(4);
        streamlargest(7);
        streamlargest(8);
        streamlargest(5);
        display();

    }

    private static void display() {
        System.out.println(pr);
    }

    static void streamlargest(int v) {
        if (pr.size() < 3) {
            pr.add(v);
        } else {
            if (pr.peek() < v) {
                pr.poll();
                pr.add(v);
            }
        }

    }

    static class Cordinate {
        int x;
        int y;

        public Cordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}





