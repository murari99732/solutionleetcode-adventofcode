

import java.util.HashMap;
import java.util.Map;

public class LeetCode9feb {
    public static void main(String[] args) {
        findword("abab", "ab");
    }

    static void longestsub(int arr[], int i, int value, String ans) {
        if (arr.length == i) {

        }
        longestsub(arr, i + 1, value + arr[i], ans + arr[i] + " ");
        longestsub(arr, i + 1, value, ans);

    }

    static void findword(String word, String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0) + 1);
        }
        Map<Character, Integer> set = new HashMap<>();
        int i = 0;
        int j = 0;
        while (i < word.length()) {
            while (i - j + 1 > pattern.length()) {
                if (map.containsKey(word.charAt(j)) && map.get(word.charAt(j)) >= 0) {
                    int integer = set.get(word.charAt(j));
                    if (integer - 1 == 0) {
                        set.remove(word.charAt(j));
                    } else {
                        set.put(word.charAt(j), integer - 1);
                    }
                }
                j++;
            }
            if (i - j + 1 <= pattern.length()) {
                if (map.containsKey(word.charAt(i))) {
                    set.put(word.charAt(i), set.getOrDefault(word.charAt(i), 0) + 1);
                }
            }
            if (i - j + 1 == pattern.length()) {
                if (map.equals(set)) {
                    System.out.print("found");
                }
            }
            i++;

        }
    }

}
