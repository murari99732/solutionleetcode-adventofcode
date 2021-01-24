class Node {
  Node next;
  int data;
}

class Linked {
 
  public Node seperateOddEven(Node node) {
    if(node == null || node.next == null) {
      return node;
    }
    
    Node evenStartingNode, evenEndNode, oddStartingNode, oddEndNode;
    
    evenStartingNode = evenEndNode = oddStartingNode = oddEndNode = null;
    
    while(node != null) {
      if(node.data % 2 == 0) {
        if(evenStartingNode == null) {
          evenStartingNode = node;
          evenEndNode = evenStartingNode;
        } else {
          evenEndNode.next = node;
          evenEndNode = evenEndNode.next;
        }
      } else {
        if(oddStartingNode == null) {
          oddStartingNode = node;
          oddEndNode = oddStartingNode;
        } else {
          oddEndNode.next = node;
          oddEndNode = oddEndNode.next;
        }
      }
      
      node = node.next;
    }

    evenEndNode.next = oddStartingNode;
    oddEndNode.next = null;
    return evenStartingNode;
  }
  
 
  public Node getNewNode(int key) {
    Node a = new Node();
    a.next = null;
    a.data = key;
    return a;
  }

  /*
   * insert method is used to insert the element in Linked List
   */
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

public class LinkedListApplication {

  public static void main(String[] args) {

    Node head = null;
    Linked a = new Linked();

    head = a.insert(12, head);
    head = a.insert(99, head);
    head = a.insert(8, head);
    head = a.insert(39, head);
    head = a.insert(5, head);
    head = a.insert(70, head);
    head = a.insert(25, head);
    
    a.printList(head);
    System.out.println();
    
    head = a.seperateOddEven(head);

    a.printList(head);
  }
}
