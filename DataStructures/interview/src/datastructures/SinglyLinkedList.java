package datastructures;

import java.util.*;

/**
 * Created by NeelaGouda on 5/9/16.
 */
public class SinglyLinkedList {

    private Node head;

    private static class Node{
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display(Node head){

        if(head==null){
            return;
        }
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }

    }

    public int length(Node head){
        if(head == null)
            return 0;

        int count = 0;
        Node current = head;

        while (current != null){
            count++;
            current = current.next;
        }

        return count;
    }

    /**
     *
     * @param head- current head node
     * @param data new data to be inserted
     * @return returns updated head node
     */
    public Node insertNodeAtBeginning(Node head, int data){
        Node current = new Node(data);
        if(head == null)
            head = current;

        current.next = head;
        head= current;
        return head;
    }

    public Node insertNodeAtEnd(Node head, int data){
        Node newNode = new Node(data);

        if(head == null)
            return newNode;

        Node current = head;

        while(current.next != null){
            current = current.next;
        }

        current.next = newNode;

        return head;
    }

    public void insertAfter(Node previous, int data){

        Node nextNode = new Node(data);
        nextNode.next = previous.next;
        previous.next = nextNode;
    }

    public void insertAtPosition(Node head, int position, int data){
        Node newNode = new Node(data);
        if(head == null){
            return;
        }

        int count = 0;
        Node previous = head;
        while (count < position -1){
            previous = previous.next;
            count++;
        }

        Node current = previous.next;
        previous.next = newNode;
        newNode.next = current;
    }

    public Node deleteHeadNode(Node head){
        if (head==null){
            return head;
        }

        Node temp = head;
        head = head.next;
        temp.next = null;

        return head;
    }

    public Node deleteLastNode(Node head){
        if (head == null)
            return head;

        Node current = head;
        Node previous = head;

        while (current.next!= null) {
            previous= current;
            current = current.next;
        }

        previous.next = null;
        return head;
    }

    public void deleteAtPosition(Node head, int position){
        if(head == null){
            return;
        }

        int count = 0;
        Node previous= head;
        Node current = head;

        while(count < position -1){
            previous = current;
            current = current.next;
            count++;
        }

        Node temp = current.next;
        current.next = null;
        previous.next = temp;

    }

    public void removeDuplicates(Node head){
        if (head == null)
            return;

        Node current = head;
        Node previous = head;

        Map<Integer,Integer> noDupMap = new HashMap<Integer, Integer>();

        while(current != null){
            if(noDupMap.containsKey(current.data)){
                //delete node
                Node temp = current.next;
                current.next = null;
                previous.next = temp;
                current = temp;

            }
            else{
                noDupMap.put(current.data, 1);
                previous = current;
                current = current.next;
            }


        }
    }

    public void removeDuplicatesWithoutBuffer(Node head){
        if(head == null)
            return;

        int tempData = 0;
        Node current = head;


        while(current != null){
            tempData = current.data;
            Node newCurrent = current.next;
            Node previous = current;

            while(newCurrent != null){
                if(newCurrent.data == tempData){
                    Node temp = newCurrent.next;
                    newCurrent.next = null;
                    previous.next = temp;
                    newCurrent = temp;
                }

                else{
                    previous = newCurrent;
                    newCurrent = newCurrent.next;
                }

            }
            current = current.next;
        }


    }

    public void findKElements(Node head, int k){
        if (head == null)
            return;

        Node current = head;
        int count = 0;

        while(current != null){

            if(count >= k-1){
                System.out.println(current.data);
            }
            count++;
            current = current.next;

        }
    }

    public Node findKNodes(Node head , int k){
        if(head == null){
            return head;
        }

        Node current = head;
        int count = 0;

        while (current != null) {

            if (count == k - 1) {
                return current;
            }

            count++;
            current = current.next;
        }

        return head;
    }

    public void deleteMiddleNode(Node head){
        if (head == null)
            return;

        int length = length(head);

        int middle = length/2;

        deleteAtPosition(head, middle);
    }

    public Node intersecting(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return  null;
        }

        Node current1 = head1;


        while (current1 != null ) {
            Node current2 = head2;
            while (current2 != null) {
                if (current1 == current2) {
                    return current2;
                }
                current2 = current2.next;
            }
            current1 = current1.next;
        }
        return null;
    }

    public boolean isPalindrome(Node head){
        Node fast = head;
        Node slow = head;
        Stack<Integer> stack = new Stack<Integer>();

        while (fast != null && fast.next != null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        //odd numbered linked list
        if(fast != null){
            slow = slow.next;

        }

        while (slow != null){
            int top = stack.pop().intValue();
            if(top != slow.data)
                return false;

            slow = slow.next;
        }
        return true;
    }

    public Node reverseLinkedList (Node head){
        Node previousNode = null;
        Node nextNode;

        if (head == null){
            return head;
        }

        Node currentNode = head;

        while (currentNode != null) {

            nextNode = currentNode.next;
            currentNode.next= previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return currentNode;
    }
    public static void main(String[] args) {
        //creating node with following data
        //10->8->1->11
        SinglyLinkedList singlyLinkedList =  new SinglyLinkedList();

        Node head = new Node(10);
        Node second = new Node(8);
        Node third = new Node(1);
        Node four = new Node(1);
        Node five = new Node(11);
        Node last = new Node(10);

        head.next = second;
        second.next= third;
        third.next = four;
        four.next = five;
        five.next = last;
        singlyLinkedList.display(head);

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);


        a.next = b;
        b.next = c;
        c.next = second;



        int length = singlyLinkedList.length(head);
        System.out.println("length of linked list is : " +length);

        /*singlyLinkedList.insertAfter(third, 23);
        singlyLinkedList.display(head);

        Node newNode = singlyLinkedList.insertNodeAtBeginning(head, 15);
        singlyLinkedList.display(newNode);

        singlyLinkedList.insertAtPosition(head,4, 77);
        singlyLinkedList.display(head);*/

        /*singlyLinkedList.deleteLastNode(head);
        singlyLinkedList.display(head);

        singlyLinkedList.deleteAtPosition(head,2);
        singlyLinkedList.display(head);*/

        /*singlyLinkedList.removeDuplicates(head);
        singlyLinkedList.display(head);*/


        /*singlyLinkedList.findKElements(head, 4);

        Node kNode = singlyLinkedList.findKNodes(head, 4);
        singlyLinkedList.display(kNode);*/

        /*singlyLinkedList.deleteMiddleNode(head);
        singlyLinkedList.display(head);*/

       /* Node intersectingNode = singlyLinkedList.intersecting(head,a);
        System.out.println("Node second reference" + second);
        System.out.println("intersecting node reference" + intersectingNode);
        System.out.println("intersectingNode value" + intersectingNode.data);*/

        boolean result = singlyLinkedList.isPalindrome(head);
        System.out.println("linked list is palindrome :" +result);

    }
}
