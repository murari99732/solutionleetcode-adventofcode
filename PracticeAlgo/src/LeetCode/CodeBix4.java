package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CodeBix4 {

    static int count = 0;

    static void findmaximumcontinogousarray(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(arr[j], max);
                min = Math.min(arr[j], min);
                if (max - min == j - i) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }

    static void longestsubstring(String word, int k) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        int i = 0;
        int j = 0;
        while (i < word.length()) {
            hashmap.put(word.charAt(i), hashmap.getOrDefault(word.charAt(i), 0) + 1);
            if (hashmap.size() <= k) {
                System.out.println(word.substring(j, i + 1));
            } else {
                while (hashmap.size() > k && i > j) {
                    Integer integer = hashmap.get(word.charAt(j));
                    if (integer - 1 == 0) {
                        hashmap.remove(word.charAt(j));
                    } else {
                        hashmap.put(word.charAt(j), integer - 1);
                    }
                    j++;
                }
            }
            i++;
        }
    }

    static void sumvalue(int arr[], int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int val = 0;
        int count = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            val = val + arr[i];
            if (map.containsKey(val - 5)) {
                count++;
                max = Math.max(max, count);
                map.put(val, count);
            } else {
                map.put(val, count);
            }

        }
        System.out.println(max);
    }

    static void findallanagram(String word, int i, HashMap<Character, Integer> map, Set<Character> set) {
        if (i == word.length()) {
            return;
        }
        char c = word.charAt(i);
        if (set.contains(c)) {
            map.put(c, i);
            if (map.size() == set.size()) {
                System.out.println(count++);
                return;
            }
            findallanagram(word, i + 1, map, set);
            Integer integer = map.get(c);
            if (integer - 1 == 0) {
                map.remove(c);
            } else {
                map.put(c, i - 1);
            }
        }
        findallanagram(word, i + 1, map, set);

    }

    static void kanagram(String a, String b, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
        }
        for (int i = 0; i < b.length(); i++) {
            if (map.containsKey(b.charAt(i))) {
                Integer integer = map.get(b.charAt(i));
                if (integer - 1 == 0) {
                    map.remove(b.charAt(i));
                } else {
                    map.put(b.charAt(i), integer - 1);
                }

            } else {
                map.put(b.charAt(i), map.getOrDefault(b.charAt(i), 0) + 1);
            }
        }
        Integer reduce = map.keySet().stream().map(CodeBix4::hubm).reduce(0, (element1, element2) -> element1 + element2);
        System.out.println(reduce);
    }

    private static Integer hubm(Character character) {
        return 1;
    }

    static void anagrammapping(String a, String b) {
        HashMap<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            map.put(i, a.charAt(i));
        }
        int bc[] = new int[b.length()];
        for (int j = 0; j < bc.length; j++) {

        }
    }

    static int minimum(ArrayList<Integer> arr, int i) {
        if (i == 0) {
            return Integer.MAX_VALUE;
        }
        int n = minimum(arr, i - 1);
        return Math.min(arr.get(i), n);
    }

    static void findanagram(String a, String b) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            if (map.containsKey(a.charAt(i))) {
                ArrayList<Integer> br = map.get(a.charAt(i));
                br.add(i);
                map.put(a.charAt(i), br);
            } else {
                ArrayList<Integer> cr = new ArrayList<>();
                cr.add(i);
                map.put(a.charAt(i), cr);

            }
        }
        ArrayList<Cordinate> list = new ArrayList<Cordinate>();
        for (int i = 0; i < b.length(); i++) {
            if (map.containsKey(b.charAt(i))) {
                ArrayList<Integer> cr = map.get(b.charAt(i));
                list.add(new Cordinate(b.charAt(i), cr.get(0)));
                cr.remove(0);
                map.put(b.charAt(i), cr);
            }

        }
        System.out.println(list);
    }

    static void groupanagram(ArrayList<String> ar) {
        Set<HashMap<Character, Integer>> set = new HashSet<>();
        for (String it : ar) {
            String dc = it;
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < dc.length(); i++) {
                map.put(dc.charAt(i), map.getOrDefault(dc.charAt(i), 0) + 1);
            }
            set.add(map);
        }
        System.out.println(set);
    }

    static void pattern(ArrayList<String> word, String pattern) {
        HashMap<Character, String> set = new HashMap<>();
        HashMap<String, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < word.size(); i++) {
            hashMap.put(word.get(i), false);
        }
        int dc = 0;
        for (int i = 0; i < word.size(); i++) {
            if (hashMap.get(word.get(i)) == false) {
                set.put(pattern.charAt(dc++), word.get(i));
                hashMap.put(word.get(i), true);
            }
            else if(hashMap.get(word.get(i))==true)
            {
                if(set.get(pattern.charAt(dc++))!=word.get(i))
                {   System.out.println("false");
                    return;
                }


            }
        }
        System.out.println("true");
        return;
    }

    public static void main(String[] args) {
        ArrayList<String> ar= new ArrayList<>();
        ar.add("pep");
        ar.add("coding");
        ar.add("pep");
        ar.add("coding");
        pattern(ar,"abcb");
    }

    static class Cordinate {
        char val;
        int index;

        public Cordinate(char val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Cordinate{" +
                    "val=" + val +
                    ", index=" + index +
                    '}';
        }
    }

}





