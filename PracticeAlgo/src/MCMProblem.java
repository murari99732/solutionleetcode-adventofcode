public class MCMProblem {
    public static void main(String[] args) {
        int nitin = partitionpali("NITINIITIIW", 1, 4);
        System.out.println(nitin);
    }

    static int partitionval(int arr[], int start, int end) {
        if (ispalindrome("")) {
            return 0;
        }
        for (int i = start; i < end; i++) {
            int a = partitionval(arr, start, i);
            int b = partitionval(arr, i + 1, end);
            int min = Math.min(0, a + b + 1);

        }
    }

    static int matrixmultiplicationvalue(int arr[], int start, int end) {
        if (start >= end) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            int a = matrixmultiplicationvalue(arr, start, i);
            int b = matrixmultiplicationvalue(arr, i + 1, end);
            int c = arr[start - 1] * arr[i] * arr[end];
            min = Math.min(a + b + c, min);

        }
        return min;
    }

    static int egg(int egg, int floor) {
        if (egg == 0 || egg == 1) {
            return floor;
        }
        if (floor == 0 || floor == 1) {
            return floor;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= floor; i++) {
            int a = egg(egg - 1, floor - 1);
            int b = egg(egg, floor - i);
            int max = Math.max(a, b) + 1;
            min = Math.min(min, max);
        }
        return min;
    }

    static int eggbreak(int egg, int floor) {
        if (egg == 0) {
            return floor;
        }
        if (floor == 0 || floor == 1) {
            return floor;
        }
        for (int i = 1; i < floor; i++) {
            int a = eggbreak(egg - 1, i - 1);
            int b = eggbreak(egg, i + 1);
            int i1 = Math.max(a, b) + 1;
        }
        return 0;
    }

    static boolean bracket(String word, int start, int end) {
        if (isevalute(word, start, end)) {
            return true;
        }
        for (int i = start; i < end; i = i + 2) {
            boolean b = bracket(word, start, i);
            boolean c = bracket(word, i + 1, end);
        }
        return false;
    }

    private static boolean isevalute(String word, int start, int end) {
        boolean b = false;
        boolean c = false;
        if (word.charAt(start) == 'T') {
            b = true;
        } else if (word.charAt(start) != 'T') {
            b = false;
        }
        if (word.charAt(end) == 'T') {
            c = true;
        } else if (word.charAt(end) == 'F') {
            c = false;
        }
        if (word.charAt(start + 1) == '|')
            return b || c;
        if (word.charAt(start + 1) == '&')
            return b && c;
        if (word.charAt(start + 1) == '^')
            return b ^ c;
        return false;

    }

    static int partitionpali(String word, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            int a = partitionpali(word, start, i);
            int b = partitionpali(word, i + 1, end);
            int w = 1;
            if (ispalindrome(word.substring(start, end))) {
                w = 0;
            }
            int v = a + b + w;
            min = Math.min(v, min);
        }
        return min;
    }

    static void partitionplaindrome(String word, String ans) {
        if (word.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            String w = word.substring(0, i + 1);
            if (ispalindrome(w)) {

                String v = word.substring(i + 1);
                partitionplaindrome(v, ans + w + " ");

            }
        }
    }

    private static boolean ispalindrome(String w) {
        int i = 0;
        int j = w.length() - 1;
        while (i < j) {
            if (w.charAt(i) != w.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static int matrixmultiplication(int arr[], int start, int end) {
        if (start >= end) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end - 1; i++) {
            int m = matrixmultiplication(arr, start, i);
            int n = matrixmultiplication(arr, i + 1, end);
            int w = m + n + (arr[start - 1] * arr[i] * arr[end]);
            min = Math.min(w, min);
        }
        return min;
    }
}
