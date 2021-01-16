

import java.util.*;

public class Recursion16Part2 {

    static int min = Integer.MAX_VALUE;


    static void minimumsetoftugwar(int arr[], int i, ArrayList<Integer> ar, ArrayList<Integer> br, String a, String b) {
        if (i == arr.length) {
            Optional<Integer> reduce = ar.stream().reduce((c, d) -> c + d);
            Optional<Integer> reduce1 = br.stream().reduce((c, d) -> c + d);
            if (reduce.isPresent() && reduce1.isPresent()) {
                min = Math.min(min, Math.abs(reduce.get() - reduce1.get()));
                if (min == 1) {
                    System.out.println(ar + "           " + br);
                    min = 2;
                    return;
                }
            }
            return;
        }
        ar.add(arr[i]);
        minimumsetoftugwar(arr, i + 1, ar, br, a + arr[i] + " ", b);
        ar.remove(ar.size() - 1);
        br.add(arr[i]);
        minimumsetoftugwar(arr, i + 1, ar, br, a, b + arr[i] + " ");
        br.remove(br.size() - 1);
    }

    static void mapwithword(String word, Set<String> set, String ans) {
        if (word.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            String dc = word.substring(0, i + 1);
            if (set.contains(dc)) {
                mapwithword(word.substring(i + 1), set, ans + dc + " ");
            }
        }
    }

    static void maptocharacter(String pattern, int dx, String word, HashMap<Character, String> map) {

        if (dx == pattern.length() && word.length() == 0) {
            System.out.println(map);
            return;
        } else if (dx == pattern.length()) {
            return;
        }

        if (map.containsKey(pattern.charAt(dx))) {
            String s = map.get(pattern.charAt(dx));
            if (word.contains(s) && word.length() >= s.length()) {
                maptocharacter(pattern, dx + 1, word.substring(s.length()), map);
            }


        } else {
            for (int i = 0; i < word.length(); i++) {
                String ab = word.substring(0, i + 1);
                map.put(pattern.charAt(dx), ab);
                maptocharacter(pattern, dx + 1, word.substring(i + 1), map);
                map.remove(pattern.charAt(dx));
            }
        }
    }

    static void equalsum(ArrayList<ArrayList<Integer>> ar, int ssf, int arr[], int n) {
        if (n == arr.length) {
            System.out.println(ar);
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (ar.get(i).size() > 0) {
                ar.get(i).add(arr[n]);
                equalsum(ar, ssf, arr, n + 1);
                ar.get(i).remove(ar.get(i).size() - 1);
            } else {
                ar.get(i).add(arr[n]);
                equalsum(ar, ssf + 1, arr, n + 1);
                ar.get(i).remove(ar.get(i).size() - 1);
                break;
            }
        }
    }

    static void kpartitionvalue(ArrayList<ArrayList<Integer>> arrayList, int ssf, int n) {
        if (n == 5) {
            System.out.println(arrayList);
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (arrayList.get(i).size() > 0) {
                arrayList.get(i).add(n);
                kpartitionvalue(arrayList, ssf, n + 1);
                arrayList.get(i).remove(arrayList.get(i).size() - 1);

            } else {
                arrayList.get(i).add(n);
                kpartitionvalue(arrayList, ssf + 1, n + 1);
                arrayList.get(i).remove(arrayList.get(i).size() - 1);

            }
        }
    }

    static void ksubsetsum(int arr[], int n, ArrayList<ArrayList<Integer>> ar, int ssf) {

        for (int i = 0; i < 3; i++) {
            if (ar.get(i).size() > 0) {
                ar.get(i).add(arr[n]);
                ksubsetsum(arr, n + 1, ar, ssf);
                ar.get(i).remove(ar.get(i).size() - 1);
            } else {
                ar.get(i).add(arr[n]);
                ksubsetsum(arr, n + 1, ar, ssf + 1);
                ar.get(i).remove(ar.get(i).size() - 1);
                break;
            }
        }
    }

    static void premutationbox(int arr[], int count, int n, boolean b[]) {
        if (count == n) {
            Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
            System.out.println("");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (b[i] == false) {
                b[i] = true;
                arr[i] = count;
                premutationbox(arr, count + 1, n, b);
                arr[i] = 0;
                b[i] = false;
            }
        }
    }

    static void combinationbox(int arr[], int di, int count) {
        if (count == 3) {
            Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
            System.out.println("");
            return;
        }
        for (int i = di; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = count;
                combinationbox(arr, i, count + 1);
                arr[i] = 0;
            }
        }
    }

    static void combinationbox1(int arr[], int di, int count) {
        if (count == 3) {
            Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
            System.out.println("");
            return;
        }
        if (di >= arr.length) {
            if (count == 3) {
                Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
                System.out.println("");
                return;
            }
            return;
        }
        arr[di] = count;
        combinationbox1(arr, di + 1, count + 1);
        arr[di] = 0;
        combinationbox1(arr, di + 1, count);
    }

    static void permuattecombination(int arr[], int n, int count) {
        if (count == 3) {
            Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
            System.out.println("");
            return;
        }
        if (n >= arr.length) {
            if (count == 3) {
                Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
                System.out.println("");
                return;
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = count;
                permuattecombination(arr, i, count + 1);
                arr[i] = 0;
            }
        }  //permuattecombination(arr, n + 1, count);
    }

    static void permuattatcombi(int arr[], int n, int val) {
        if (n >= arr.length) {
            if (val == 4) {
                Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
                System.out.println("");

            }
            return;
        }
        arr[n] = val;
        permuattatcombi(arr, n + 1, val + 1);
        arr[n] = 0;
        permuattatcombi(arr, n + 1, val);
    }

    static void permuatecombi(int arr[], int n, int val) {
        if (val == 4) {
            Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
            System.out.println("");
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0) {
                arr[j] = val;
                permuatecombi(arr, j, val + 1);
                arr[j] = 0;
            }
        }
    }

    static void permutationstring(String word, String ans, Set<Character> set) {
        if (word.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            if (set.size() > 0 && set.contains(word.charAt(i))) {

                permutationstring(word.substring(i), ans + word.charAt(i) + " ", set);
            } else {
                set.add(word.charAt(i));
                char c = word.charAt(i);
                String dc = word.substring(0, i);
                String bc = word.substring(i + 1);
                permutationstring(dc + bc, ans + c + " ", set);
            }
        }
    }

    static void swapsting(int arr[], int start, int end, String ans, int v) {
        if(v==3)
        {
            Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
            System.out.println("");
            return;
        }
        if(start>=end)
        {
            Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
            System.out.println("");
            return;
        }
        if (arr[start] < arr[end]) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            swapsting(arr, start + 1, end - 1, ans+" {" + arr[start] + " " + arr[end] + " }",v+1);
        } else {
            swapsting(arr, start, end - 1, ans,v);
        }
    }

    public static void main(String[] args) {
        swapsting(new int []{1,2,3,4,5,6,7,8,9},0,8,"",0);
    }
}

