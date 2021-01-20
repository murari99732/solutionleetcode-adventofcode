class Node {
  Node next;
  int data;
}

class Linked {
  public Node addTwoNumbers(Node node1, Node node2) {
    node1 = this.reverse(node1);
    node2 = this.reverse(node2);
    
    Node newListHead = null;
    Node prev = null;
    int sum, c = 0;
    
    while(node1 != null || node2 != null) {
      sum = c + (node1 != null ? node1.data : 0)
          + (node2 != null ? node2.data: 0);
      
      c = sum / 10;
      
      Node node = getNewNode(sum % 10);
      if(newListHead == null) {
        newListHead = node;
      } else {
        prev.next = node;
      }
      
      prev = node;
      
      if(node1 != null) {
        node1 = node1.next;
      }
      
      if(node2 != null) {
        node2 = node2.next;
      }
    }
    
    if(c != 0) {
      prev.next = getNewNode(c);
    }
    
    newListHead = this.reverse(newListHead);
    
    return newListHead;
  }
  
 
  public Node reverse(Node node) {
    if(node == null || node.next == null) {
      return node;
    }
    
    Node temp = reverse(node.next);
    node.next.next = node;
    node.next = null;
    
    return temp;
  }

  public Node getNewNode(int key) {
    Node a = new Node();
    a.next = null;
    a.data = key;
    return a;
  }

  public Node insert(int key, Node node) {

    if (node == null)
      return getNewNode(key);
    else
      node.next = insert(key, node.next);

    return node;
  }

  public void printList(Node node) {
    if (node == null) {
      return;
    }

    System.out.print(node.data + " ");
    printList(node.next);
  }
}

public class AdditionLinkedList {
  public static void main(String[] args) {
    Linked a = new Linked();
    
    Node head1 = null;
    head1 = a.insert(1, head1);
    head1 = a.insert(7, head1);
    head1 = a.insert(8, head1);
    head1 = a.insert(2, head1);
    head1 = a.insert(5, head1);
    
    a.printList(head1);
    System.out.println();
    
    Node head2 = null;
    head2 = a.insert(5, head2);
    head2 = a.insert(6, head2);
    head2 = a.insert(7, head2);
    
    a.printList(head2);
    System.out.println();
    
    Node addLists = a.addTwoNumbers(head1, head2);
    a.printList(addLists);
    
  }
}
