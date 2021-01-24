package practice;

import java.util.*;
import java.util.stream.Collectors;

public class Graph25Jan {
    static int dxc = 0;
    static int count = 0;

    static Node createNode(int data) {
        Node node = new Node();
        node.data = data;
        return node;
    }

    static int addition(Node node) {
        if (node == null) {
            return 0;
        }
        int a = addition(node.right);
        int b = addition(node.left);
        return a + b;
    }

    static void additionvalue(Node node, Integer sum) {
        if (node == null) {
            return;
        }
        sum = sum + node.data;
        additionvalue(node.left, sum);
        additionvalue(node.right, sum);


    }

    private static void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + "  ");
        preorder(node.left);
        preorder(node.right);
    }

    private static void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.data + "  ");
        inorder(node.right);
    }

    private static void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(node.left);

        postorder(node.right);
        System.out.print(node.data + "  ");
    }

    static int differnce(Node node) {
        if (node == null) {
            return 0;
        }
        int a = differnce(node.left);
        int b = differnce(node.right);
        return node.data - (a + b);

    }

    static int numberofnodes(Node node) {
        if (node == null) {
            return 0;
        }
        int a = numberofnodes(node.left);
        int b = numberofnodes(node.right);
        return 1 + a + b;
    }

    static int numberofleafs(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        int a = numberofleafs(node.left);
        int b = numberofleafs(node.right);
        return a + b;
    }

    static int getheight(Node node) {
        if (node == null) {
            return 0;
        }
        int a = getheight(node.left);
        int b = getheight(node.right);
        return Math.max(a, b) + 1;
    }

    static void leftview(Node node, int level) {
        if (node == null) {
            return;
        }
        if (dxc == level) {
            System.out.print(node.data + " ");
            dxc++;
        }
        leftview(node.left, level + 1);
        leftview(node.right, level + 1);
    }

    public static void main(String[] args) {
        Node node = new Node();
        node = createNode(1);
        node.left = createNode(2);
        node.right = createNode(3);
        node.left.left = createNode(4);
        node.left.right = createNode(5);
        node.right.left = createNode(6);
        node.right.right = createNode(7);
        node.right.right.right = createNode(7);


        postorder(node);
        System.out.println();
        inorder(node);
        System.out.println();
        preorder(node);
        System.out.println();

        //  Node mirrortree = mirrortree(node);
        // postordertry(mirrortree);
        System.out.println();
        checksumarray(node,0,0, new ArrayList<>());
    }

    static  void printallpath(Node node, int arr[], int idx)
    {
        if(node==null)
        {
            return;
        }     arr[idx]=node.data;
        if(node.left== null && node.right== null)
        {
            Arrays.stream(arr).forEach(a->System.out.print(a+" "));
            System.out.println();
            return;
        }

        printallpath(node.left, arr, idx+1);
        printallpath(node.right, arr, idx+1);

    }

    static  boolean sum(Node node, int sum)
    {
        if(node==null)
        {
            return  false;
        }
        if(node.left== null && node.right==null)
        {
            if(sum-node.data==0)
            {
                return true;
            }
            return false;
        }
       return sum(node.left, sum-node.data)||
        sum(node.right, sum-node.data);
    }

    static void printeverypath(Node node, ArrayList<Integer> ar) {
        if (node == null) {
            return;
        }ar.add(node.data);
        if (node.left == null && node.right == null) {
            System.out.println(ar);
            return;
        }

        printeverypath(node.left, ar);
        printeverypath(node.right, ar);
        ar.remove(ar.size()-1);

    }

    static int checksumvalue(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return node.data;
        }
        int a = checksumvalue(node.left);
        int b = checksumvalue(node.right);
        if (a == 7) {
            System.out.println("found");
        }
        if (b == 7) {
            System.out.println("found");
        }
        return a + b + node.data;
    }

    static void checksumarray(Node node, int sum, int value, ArrayList<Integer> ar) {
        if (node == null) {
            return;
        }
        ar.add(node.data);
        if (node.left == null && node.right == null) {
            int reduce = ar.stream().reduce(0,(a, b) -> a + b);
            int reduce1 =   ar.stream().collect(Collectors.summingInt(Integer::intValue));
            System.out.println("found"+" "+reduce+"         "+reduce1);
            return;
        }
        checksumarray(node.left, sum, value + node.data, ar);
        checksumarray(node.right, sum, value + node.data, ar);
        ar.remove(ar.size() - 1);
    }

    static void checksum(Node node, int sum, int value) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (value + node.data == sum) {
                System.out.println("found");
            }
            return;
        }
        checksum(node.left, sum, value + node.data);
        checksum(node.right, sum, value + node.data);

    }

    static Node heightbalance(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            node.sum = 1;
            return node;
        }
        Node a = heightbalance(node.left);
        Node b = heightbalance(node.right);
        if (Math.abs(a.sum - b.sum) > 3) {
            System.out.println("break");
            return null;
        }
        node.sum = a.sum + b.sum;
        return node;


    }

    static int getmaximumheight(Node node) {
        if (node == null) {
            return 0;
        }
        int a = getmaximumheight(node.left);
        int b = getmaximumheight(node.right);
        int max = 0;
        max = Math.max(max, a + b + 1);
        return Math.max(max, Math.max(a, b) + 1);
    }

    static void height(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int p = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                Node poll = q.poll();
                if (poll.left != null) {
                    q.add(poll.left);
                }
                if (poll.right != null) {
                    q.add(poll.right);
                }
                size--;
            }
            p++;
        }
    }


    static Node preinordertree(int inorder[], int preorder[], int start, int end) {
        if (start > end) {
            return null;
        }
        Node temp = createNode(preorder[count++]);
        if (start == end) {
            return temp;
        }
        int mid = getsize(inorder, start, end, temp.data);
        temp.left = preinordertree(inorder, preorder, start, mid - 1);
        temp.right = preinordertree(inorder, preorder, mid + 1, end);
        return temp;
    }

    private static int getsize(int[] inorder, int start, int end, int data) {

        for (int i = start; i <= end; i++) {
            if (data == inorder[i]) {
                return i;
            }
        }
        return 0;

    }

    static Node createdoubletree(Node node) {
        if (node == null) {
            return null;
        }
        node.left = createdoubletree(node.left);
        node.right = createdoubletree(node.right);
        Node temp = createNode(node.data);
        Node left = node.left;
        node.left = temp;
        temp.left = left;
        return node;
    }

    static int findwidth(Node node, int level) {
        if (node == null) {
            return -1;
        }
        if (level == 0) {
            count = count + 1;
            return 1;
        }
        int a = findwidth(node, level - 1);
        int b = findwidth(node, level - 1);
        return Math.max(a, b);

    }

    static boolean checkisomorphic(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return checkisomorphic(node1.left, node2.left) && checkisomorphic(node1.right, node2.right) || checkisomorphic(node1.left, node2.right) &&
                checkisomorphic(node1.right, node2.left);


    }

    static void checkfoldable(Node node1, Node node2) {

        boolean checkcheckfoldable = checkcheckfoldable(node1.left, node2.left);
        System.out.println(checkcheckfoldable);
    }

    private static boolean checkcheckfoldable(Node left, Node left1) {
        if (left == null && left1 == null) {
            return true;
        }
        if (left == null || left1 == null) {
            return false;
        }
        return checkcheckfoldable(left.left, left1.right) && checkcheckfoldable(left.right, left1.left);
    }

    static boolean checkifmirror(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.left.data == node2.right.data && checkifmirror(node1.left, node2.right) && checkifmirror(node1.right, node2.right);

    }

    static void maximumwidth(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int level = 0;
        int max = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            max = Math.max(size, max);
            while (size > 0) {
                Node poll = q.poll();
                if (poll.left != null) {
                    q.add(poll.left);
                }
                if (poll.right != null) {
                    q.add(poll.right);
                }
                size--;
            }
        }
        System.out.println(max);
    }

    static void printatgivenlevle(Node node, int l1, int l2) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                Node poll = q.poll();
                if (level >= l1 && level <= l2) {
                    System.out.print(poll.data + " ");
                }
                if (poll.left != null) {
                    q.add(poll.left);
                }
                if (poll.right != null) {
                    q.add(poll.right);
                }
                size--;
            }
            level++;
        }
    }

    static void spiralway(Node node) {
        Stack<Node> q = new Stack<>();
        Stack<Node> r = new Stack<>();
        q.add(node);
        while (!q.isEmpty() || !r.isEmpty()) {
            if (!q.isEmpty()) {
                int size = q.size();
                while (size > 0) {
                    Node temp = q.pop();

                    System.out.print(temp.data + " ");
                    if (temp.right != null) {
                        r.push(temp.right);
                    }
                    if (temp.left != null) {
                        r.push(temp.left);
                    }
                    size--;
                }
            }
            if (!r.isEmpty()) {
                int size = r.size();
                while (size > 0) {
                    Node temp = r.pop();

                    System.out.print(temp.data + " ");
                    if (temp.left != null) {
                        q.push(temp.left);
                    }
                    if (temp.right != null) {
                        q.push(temp.right);
                    }
                    size--;
                }
            }
        }

    }

    static void sumoflevle(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        int point = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            while (size > 0) {
                Node temp = q.poll();
                sum = sum + temp.data;
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
                size--;
            }
            System.out.println(point + "  Level value sum" + sum);
            point++;
        }
    }

    static void printbottom(Node node) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node poll = q.poll();
            map.put(poll.sum, poll.data);
            if (poll.left != null) {
                poll.left.sum = poll.sum - 1;
                q.add(poll.left);
            }
            if (poll.right != null) {
                poll.right.sum = poll.sum + 1;
                q.add(poll.right);
            }
        }
        System.out.println(map);
    }

    static void topview(Node node) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node poll = q.poll();
            if (!map.containsKey(poll.sum)) {
                map.put(poll.sum, poll.data);
            }
            if (poll.left != null) {
                poll.left.sum = poll.sum - 1;
                q.add(poll.left);
            }
            if (poll.right != null) {
                poll.right.sum = poll.sum + 1;
                q.add(poll.right);
            }
        }
        System.out.println(map);

    }

    static int getlevelofnode(Node node, int level) {
        if (node == null) {
            return -1;
        }
        if (node.data == 8) {
            return level;
        }
        int a = getlevelofnode(node.left, level + 1);
        int b = getlevelofnode(node.right, level + 1);
        return Math.max(a, b);
    }

    static boolean checkNode(Node node, Node sode) {
        if (node == null && sode == null) {
            return true;
        }
        if (node == null || sode == null) {
            return false;
        }
        if (node.data != sode.data) {
            return false;
        }
        boolean b = checkNode(node.left, sode.left);
        boolean c = checkNode(node.right, sode.right);
        return b && c;
    }

    static Node delete(Node node) {
        if (node == null) {
            return null;
        }
        node.left = delete(node.left);
        node.right = delete(node.right);
        System.out.println(node.data);
        node = null;
        return node;
    }

    static void mirror(Node node) {
        if (node == null) {
            return;
        }
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirror(node.left);
        mirror(node.right);
    }

    static Node mirrortree(Node node) {
        if (node == null) {
            return null;
        }
        node.left = mirrortree(node.left);
        node.right = mirrortree(node.right);
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        return node;
    }

    static void postordertry(Node node) {
        Stack<Node> st = new Stack();
        Stack<Integer> tst = new Stack<>();
        st.push(node);
        while (!st.isEmpty()) {
            Node pop = st.pop();
            tst.push(pop.data);
            if (pop.left != null) {
                st.push(pop.left);
            }
            if (pop.right != null) {
                st.push(pop.right);
            }

        }

        while (!tst.isEmpty()) {
            System.out.print(tst.pop() + " ");
        }

    }

    static void postorderit(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (node.right != null) {
            stack.push(node.left);
            node = node.left;
        }
        while (stack.size() > 0) {
            Node pop = stack.pop();
            System.out.print(pop.data + " ");
            if (pop.right != null) {
                Node temp = pop.right;

                while (temp.left != null) {
                    stack.push(pop);
                    temp = temp.left;
                }
            }
        }
    }

    static void preorderit(Node node) {
        Stack<Node> st = new Stack<>();
        st.push(node);
        while (!st.isEmpty()) {
            Node pop = st.pop();
            System.out.print(pop.data + "  ");
            if (pop.right != null) {
                st.push(pop.right);
            }
            if (pop.left != null) {
                st.push(pop.left);
            }
        }
    }

    static void rightview(Node node, int level) {
        if (node == null) {
            return;
        }
        if (dxc == level) {
            System.out.print(node.data + " ");
            dxc++;
        }
        rightview(node.right, level + 1);
        rightview(node.left, level + 1);
    }

    static void printreverseusingit(Node node) {
        Queue<Node> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node poll = q.poll();
            st.push(poll.data);
            if (poll.right != null) {
                q.add(poll.right);
            }
            if (poll.left != null) {
                q.add(poll.left);
            }
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }

    }

    static void printreverselevl(Node node) {
        int height = getheight(node);
        for (int i = height - 1; i >= 0; i--) {
            printatgivenlevel(node, i);
            System.out.println();
        }
    }

    static void printusinglevel(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                Node poll = q.poll();
                System.out.print(poll.data + " ");
                if (poll.left != null) {
                    q.add(poll.left);
                }
                if (poll.right != null) {
                    q.add(poll.right);
                }
                size--;
            }
            System.out.println();
        }
    }

    static void printlevelwise(Node node) {
        int height = getheight(node);
        for (int i = 0; i < height; i++) {
            printatgivenlevel(node, i);
            System.out.println();
        }
    }

    static void printatgivenlevel(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level == 0) {
            System.out.print(node.data + " ");
            return;
        }
        printatgivenlevel(node.left, level - 1);
        printatgivenlevel(node.right, level - 1);
    }

    static class Node {
        int data;
        Node left;
        Node right;
        int sum;

        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.left = next;
            this.right = prev;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    ", sum=" + sum +
                    '}';
        }
    }
}
