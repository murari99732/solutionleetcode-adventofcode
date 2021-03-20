package practice;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class March20 {
    int id;
    String value;

    public Slamp(int id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Slamp)) return false;
        Slamp slamp = (Slamp) o;
        return id == slamp.id &&
                value.equals(slamp.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}

public class StockSpanner {

    public static final int FIVE_SECONDS = 5000;
    public static final int MAX_Y = 400;
    public static final int MAX_X = 400;
    static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
    static int value = 0;
    static BinaryTree root = null;
    static BinaryTree prev = null;
    static HashMap<Integer, App.Cordinate> mapvalue = new HashMap<>();
    static ArrayDeque<App.Cordinate> queue = new java.util.ArrayDeque<>();
    Stack<Integer> st;
    HashMap<Integer, Integer> map;

    public StockSpanner() {
        st = new Stack();
        map = new HashMap();

    }


    public static void main(String... args) throws Exception {

    }

    static void display() {
        Thread t1 = new Thread(() -> {
            producer();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread t2 = new Thread(() -> {
            try {
                consumer();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {

            }
        });
        t1.start();
        t2.start();
    }

    private static void consumer() throws InterruptedException {

        while (true) {
            System.out.println(blockingQueue.take());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void producer() {
        int i = 0;
        while (true) {
            try {
                blockingQueue.put(i);

                i++;
            } catch (Exception e) {

            }
        }
    }


    static ArrayList<Integer> bracket(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-' || s.charAt(i) == '+' || s.charAt(i) == '*') {
                ArrayList<Integer> br = bracket(s.substring(0, i));
                ArrayList<Integer> cr = bracket(s.substring(i + 1));
                for (Integer it : br) {
                    for (Integer ir : br) {

                    }
                }
            }
        }
        return null;
    }

    static void add(App.Cordinate cordinate) {
        if (mapvalue.containsKey(cordinate.x)) {
            App.Cordinate cordinate1 = mapvalue.get(cordinate.x);
            queue.remove(cordinate1);
            mapvalue.put(cordinate.x, cordinate);
            queue.addFirst(cordinate);
        } else if (queue.size() == 3) {
            App.Cordinate last = queue.getLast();
            mapvalue.remove(last.x);
            mapvalue.put(cordinate.x, cordinate);
        } else {
            queue.addFirst(cordinate);
            mapvalue.put(cordinate.x, cordinate);
        }

    }

    private static LinkedList getmiddle(LinkedList list) {
        LinkedList fast = list;
        LinkedList slow = list;
        while (fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = null;
        return list;
    }

    static LinkedList reverselinked(LinkedList list) {
        if (list.next == null || list == null) {
            return list;
        }
        LinkedList pr = reverselinked(list.next);
        list.next.next = list;
        list.next = null;
        return pr;
    }

    static void rotate(LinkedList list) {
        LinkedList head = list;
        LinkedList tail = null;
        int i = 0;
        while (head != null && i != 4) {
            head = head.next;
            i++;
        }
        LinkedList first = head.next;
        head.next = null;
        while (first.next != null) {
            first = first.next;
        }
        first.next = list;
    }


    static void getinordersucesor(BinaryTree tree) {
        BinaryTree prev = null;
        while (tree != null) {
            if (tree.data < 4) {
                prev = tree;
                tree = tree.left;
            } else if (tree.data > 4) {
                tree = tree.right;
            } else {

            }
        }
    }

    static void getinordersuccesor(BinaryTree tree, int data) {
        BinaryTree inorder = null;
        while (tree != null) {
            if (tree.data < data) {
                inorder = tree;
                tree = tree.left;
            } else if (tree.data > data) {
                tree = tree.right;
            } else {
                BinaryTree tr = getinordervalue(tree);
            }
        }
    }

    private static BinaryTree getinordervalue(BinaryTree tree) {
        if (tree.left != null) {
            tree = tree.left;
        }
        while (tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }

    static void printvalue(BinaryTree tree, int sum) {
        if (tree == null) {
            return;
        }
        if (value == sum) {
            System.out.println(tree.data);
            value++;
        }
        printvalue(tree.left, sum + 1);
        printvalue(tree.right, sum + 1);
    }

    static BinaryTree maximumtree(BinaryTree tree) {
        if (tree == null) {
            return null;
        }
        if (tree.left == null && tree.right == null) {
            return tree;
        }
        BinaryTree a = maximumtree(tree.left);
        BinaryTree b = maximumtree(tree.right);
        return null;
    }

    static int removenodes(BinaryTree tree, int sum) {
        if (tree == null) {
            return 0;
        }
        if (tree.left == null && tree.right == null && sum == 13) {
            return tree.data;
        } else if (sum > 13) {

        }
        int a = removenodes(tree.left, sum + tree.data);
        int b = removenodes(tree.right, sum + tree.data);
        return 0;
    }

    static int getnode(BinaryTree tree, int v) {
        if (tree.left == null && tree.right == null) {
            return 0;
        }
        int left = getnode(tree.left, v);
        int right = getnode(tree.right, v);
        if (left == 3) {
            System.out.println(tree.data);
        } else if (right == 3) {
            System.out.println(tree.data);
        }
        return Math.max(left, right) + 1;

    }

    static BinaryTree desirizlize(ArrayList<Integer> arrayList, int i) {
        if (arrayList.get(i) == -1) {
            return null;
        }
        BinaryTree tree = createNode(arrayList.get(i));
        tree.left = desirizlize(arrayList, i + 1);
        tree.right = desirizlize(arrayList, i + 1);
        return tree;
    }

    private static BinaryTree createNode(Integer integer) {
        BinaryTree b = new BinaryTree();
        b.data = integer;
        return b;
    }

    static void seriliaze(BinaryTree tree, ArrayList<Integer> arrayList) {
        if (tree == null) {
            arrayList.add(-1);
            return;
        }
        arrayList.add(tree.data);
        seriliaze(tree.left, arrayList);
        seriliaze(tree.right, arrayList);
    }

    static void doublylinkedlist(BinaryTree tree) {
        if (tree == null) {
            return;
        }
        doublylinkedlist(tree.left);
        if (tree == null) {
            root = tree;
            prev = tree;
            prev = prev.right;
        } else {
            prev.right = tree;
            prev = prev.right;
        }
        doublylinkedlist(tree.right);
    }

    static void inordersuccesor(BinaryTree tree) {
        if (tree == null) {
            return;
        }
        inordersuccesor(tree.left);
        if (tree == null) {
            root = tree;
            prev = tree;
            prev = prev.right;
        } else {
            prev.right = tree;
            prev = prev.right;
        }

        inordersuccesor(tree.right);
    }

    static BinaryTree getrightnode(BinaryTree tree) {
        if (tree == null) {
            return null;
        }
        if (tree.left == null && tree.right == null) {
            return tree;
        }
        BinaryTree left = getrightnode(tree.left);
        BinaryTree righ = getrightnode(tree.right);
        if (tree.data == 12) {
            tree.data = -1;
            return righ != null ? righ : tree;
        }
        return righ;

    }


    static int checksumofleft(BinaryTree tree) {
        if (tree == null) {
            return 0;
        }
        if (tree.left == null && tree.right == null) {
            return tree.data;
        }
        int a = checksumofleft(tree.left);
        int b = checksumofleft(tree.right);

        if (a != b) {
            return -1;
        }
        return a + b + tree.data;

    }

    static void getmaintree(BinaryTree tree, BinaryTree main) {
        if (tree == null) {
            return;
        }
        if (tree.data == main.data) {
            findequal(tree, main);
        }
        getmaintree(tree.left, main);
        getmaintree(tree.right, main);

    }

    private static boolean findequal(BinaryTree tree, BinaryTree main) {
        if (tree == null && main == null) {
            return true;
        }
        if (tree == null) {
            return false;
        }
        if (main == null) {
            return false;
        }
        boolean a = findequal(tree.left, main.left);
        boolean b = findequal(tree.right, main.right);
        return a || b;
    }

    static int getsum(BinaryTree tree) {
        if (tree == null) {
            return 0;
        }
        if (tree.left == null && tree.right == null) {
            return tree.data;
        }
        int a = getsum(tree.left);
        int b = getsum(tree.right);
        value = Math.max(value, a + b + tree.data);
        if (tree.left != null && tree.right != null) {
            return a > b ? a + tree.data : b + tree.data;
        }
        return tree.left != null ? tree.left.data + tree.data : tree.right.data + tree.data;
    }

    static int sumpath(BinaryTree tree) {
        if (tree == null) {
            return 0;
        }
        if (tree.left == null && tree.right == null) {
            return tree.data;
        }
        int a = sumpath(tree.left);
        int b = sumpath(tree.right);
        int max = Math.max(a, b);
        int sum = Math.max(max, a + b);
        value = Math.max(value, sum);
        return value;
    }

    static void sumpaths(BinaryTree tree, ArrayList<Integer> list, int sum) {
        if (tree == null) {
            return;
        }
        list.add(tree.data);
        sumpaths(tree.left, list, sum);
        sumpaths(tree.right, list, sum);
        Integer reduce = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
        list.remove(list.size() - 1);

    }


    static void findpathval(BinaryTree tree, ArrayList<Integer> arr, ArrayList<Integer> brr) {
        if (tree == null) {
            return;
        }
        brr.add(tree.data);
        if (tree.left == null && tree.right == null) {
            System.out.println("true");
            return;
        }
        findpathval(tree.left, arr, brr);
        findpathval(tree.right, arr, brr);
        brr.remove(brr.size() - 1);
    }

    static void findpath(BinaryTree tree, ArrayList<Integer> arr, int val) {
        if (tree == null) {
            return;
        }
        if (tree.left == null && tree.right == null && arr.get(val) == tree.data) {
            System.out.println("true");
            return;
        }
        findpath(tree.left, arr, val + 1);
        findpath(tree.right, arr, val + 1);
    }

    static void pairs(BinaryTree tree, Set<Integer> set, int sum) {
        if (tree == null) {
            return;
        }
        if (set.contains(sum - tree.data)) {
            System.out.println(tree.data + " " + (sum - tree.data));
        }
        set.add(tree.data);
        pairs(tree.left, set, sum);
        pairs(tree.right, set, sum);
    }

    public int next(int price) {
        if (st.size() == 0) {
            st.push(price);
            map.put(price, 1);
            System.out.print(map.get(price) + " ");
            return map.get(price);
        } else if (st.peek() > price) {
            st.push(price);
            map.put(price, 1);
            System.out.print(map.get(price) + " ");
            return map.get(price);

        } else {
            int sum = 1;
            while (!st.isEmpty() && st.peek() < price) {
                int val = st.pop();
                int wal = map.get(val);
                sum = sum + wal;
            }
            st.push(price);
            map.put(price, sum);
            System.out.print(map.get(price) + " ");
            return map.get(price);
        }


    }

    static class LinkedList {
        int data;
        LinkedList next;
    }

    static class BinaryTree {
        int data;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree() {
        }

        public BinaryTree(int data, BinaryTree left, BinaryTree right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
