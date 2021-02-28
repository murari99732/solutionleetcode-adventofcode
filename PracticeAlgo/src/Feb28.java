

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Feb28 {
    static void insert(int arr[], int n, int i) {
        int brr[] = new int[arr.length + 1];

        int k = 0;
        for (int j = 0; j < arr.length; j++) {
            if (j < i) {
                brr[k++] = arr[j];
            } else if (i == j) {
                brr[k++] = n;
                brr[k++] = arr[j];
            } else {
                brr[k++] = arr[j];
            }
        }
        for (int j = 0; j < brr.length - 1; j++) {
            if (i <= j) {
                brr[j] = brr[j + 1];
            }
        }
        Arrays.stream(brr).forEach(a -> System.out.print(a + " "));
    }


    static void findvalue(int arr[]) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
            map.put(arr[i], i);
        }
        int diff = max - min;
        Integer integer = map.get(max);
        Integer integer1 = map.get(min);
        int val = diff + integer - integer1;

    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int i = 0;
        int sum = 0;
        for (int j = 0; j < A.size(); j++) {
            sum = sum * 10 + A.get(j);
        }
        sum = sum + 1;
        A.clear();
        while (sum != 0) {
            A.add(sum % 10);
            sum = sum / 10;
        }
        int k = A.size() - 1;
        while (k > i) {
            int v = A.get(i);
            int u = A.get(k);
            A.remove(i);
            A.add(i, u);
            A.remove(k);
            A.add(k, v);
            k--;
            i++;
        }
        System.out.print(A);
        return A;
    }

    static void display(ArrayList<Integer> arr, int i, int sum, int val) {
        if (arr.size() == i) {
            if (sum == val) {
                System.out.print("found");
            }
            return;
        }

        if (sum == val) {
            int vc = val;
            val = 0;
            display(arr, i + 1, sum, val + arr.get(i));
            val = vc;
        } else
            display(arr, i + 1, sum, val + arr.get(i));

    }

    public static int solve(int A, ArrayList<Integer> arr) {
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum = sum + arr.get(i);
            getvalue(arr, i + 1, 0, sum);
        }
        return 0;
    }

    static void getvalue(ArrayList<Integer> ar, int i, int sum, int val) {
        if (i == ar.size()) {
            if (sum == val) {
                System.out.print("found");
            }
            return;
        }
        if (sum == val) {
            val = 0;
        }
        if (sum > val) {
            return;
        }
        for (int j = i; j < ar.size(); j++) {

            sum = sum + ar.get(j);
            getvalue(ar, j + 1, sum, val);
            sum = sum - ar.get(j);
        }
    }

    static void printRepeating(int arr[], int size) {
        int i;
        System.out.println("The repeating elements are : ");

        for (i = 0; i < size; i++) {
            int j = Math.abs(arr[i]);
            if (arr[j] >= 0)
                arr[j] = -arr[j];
            else
                System.out.print(j + " ");
        }
    }

    static void sort(String[] str, String val) {
        Map<String, Long> freq =
                Stream.of(val)
                        .collect(Collectors.groupingBy(Function.identity(),
                                Collectors.counting()));
        Arrays.sort(str, (a, b) -> {
            while (a.length() != 0 && b.length() != 0) {
                if (freq.get(a.charAt(0)).intValue() != freq.get(b.charAt(0)).intValue())
                    return freq.get(a.charAt(0)).intValue() - freq.get(b.charAt(0)).intValue();
                a = a.substring(1);
                b = b.substring(1);
            }
            return a.length() != 0 ? 1 : 0;
        });
        Arrays.stream(str).forEach(a -> System.out.print(a + " "));
    }

    // Driver code
    public static void main(String[] args) {

        maxidiff(new int[]{2,5,15,6,4});
    }

    static void maxidiff(int arr[]) {
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = 0;
            for (int j = 0; j < i; j++) {
                sum = Math.max(sum, arr[i] - arr[j]);
            }
        }
        System.out.print(sum);
    }

    static void sortarray(int arr[]) {
        int i = 0;
        int k = 0;
        int j = arr.length - 1;
        while (i < j && k <= j) {
            if (arr[k] == 0) {
                while (arr[i] == 0) {
                    i++;
                }
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                i++;
                k++;
            } else if (arr[k] == 1) {
                k++;
            } else if (arr[k] == 2) {
                while (arr[j] == 2) {
                    j--;
                }
                int temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }

    static void findpairval(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(12 - arr[i])) {
                System.out.println(arr[i] + " " + arr[map.get(12 - arr[i])]);
            } else {
                map.put(arr[i], i);
            }
        }
    }

    static void secondsmallest(int arr[]) {
        int sum = Integer.MAX_VALUE;
        int fum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum = Math.min(sum, arr[i]);
            fum = Math.min(fum, arr[i] > sum ? arr[i] : fum);

        }
        System.out.print(sum + " " + fum);
    }

    static void seggragte(int arr[]) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            while (arr[i] == 0) {
                i++;
            }
            while (arr[j] == 1) {
                j--;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }

    static void findsorted(int arr[], int brr[], int crr[], int i, int j, int k) {
        while (i != arr.length && j != brr.length && k != crr.length) {
            if (arr[i] <= brr[j] && arr[i] < crr[k] || arr[i] < brr[j] && arr[i] <= crr[k]) {
                i++;
            } else if (brr[j] <= arr[i] && brr[j] < crr[k] || brr[j] < arr[i] && brr[j] <= crr[k]) {
                j++;
            } else if (crr[k] <= arr[j] && crr[k] < brr[j] || crr[k] < arr[j] && crr[k] <= brr[j]) {
                k++;
            } else {
                System.out.println("found");
                i++;
                k++;
                j++;
            }
        }

    }

    static void findpairs(int arr[], int i, int j) {
        if (i >= j) {
            return;
        }
        if (arr[i] + arr[j] == 12) {
            System.out.println(arr[i] + " " + arr[j]);
            findpairs(arr, i, j - 1);
        } else if (arr[i] + arr[j] < 12) {
            findpairs(arr, i + 1, j);
        } else if (arr[i] + arr[j] > 12) {
            findpairs(arr, i, j - 1);
        }
    }

    static void duplicate(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int val = Math.abs(arr[i]);
            if (arr[val] >= 0) {
                arr[val] = -arr[val];
            } else {
                System.out.print(val);
            }
        }
    }

    static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int b = Math.abs(arr[i]);
            if (arr[b] >= 0) {
                arr[b] = -arr[b];
            } else {
                System.out.print(b);
            }
        }
    }

    public static int repeatedNumber(List<Integer> A) {


        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) != i + 1) {
                if (A.get(i) == A.get(A.get(i) - 1)) {
                    return A.get(i);
                }
                int temp = A.get(i) - 1;
                int stemp = A.get(i);
                A.remove(i);
                A.add(i, temp);
                A.remove(temp);
                A.add(temp, stemp);
            }
        }
        A.stream().forEach(a -> System.out.print(a + " "));
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) != i + 1) {
                return A.get(i);
            }
        }
        return -1;
    }

}
