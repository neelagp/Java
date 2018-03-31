package cracking;

import java.util.List;

/**
 * Created by NeelaGouda on 1/7/18.
 */
public class DistinctInList {

    public Node head;

     class Node{

        Node next =null;
        int data;
        Node (int d){
            data =d;
        }
    }

    void addNode(int data){

        Node newNode = new Node(data);

        if (head == null){
            head = newNode;
            return;
        }
        Node current = head;

        while(current.next != null ){
            current = current.next;
        }
        newNode.next = null;
        current.next = newNode;

    }

    void print(Node node){

        Node current = node;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    Node distinctList(Node head){

        Node current = head;
        Node prev = head;



        while(current != null && current.next != null){
            if(current.data == current.next.data){
                prev.next = current.next.next;
                current.next = current.next.next;

            }
            else{
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        DistinctInList list = new DistinctInList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(2);
        list.addNode(2);
        list.addNode(4);
        list.addNode(4);
        list.addNode(5);
        list.print(list.head);
        Node distList = list.distinctList(list.head);
        list.print(distList);

    }
}
