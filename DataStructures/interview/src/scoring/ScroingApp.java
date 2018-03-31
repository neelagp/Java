package scoring;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by NeelaGouda on 2/8/16.
 */
public class ScroingApp {

    public static Node root;
    public Queue<Node> bfsQueue = new LinkedList<Node>();

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public ScroingApp() {
        this.root = null;
    }

    class Node{
        int data;
        Node left;
        Node right;
        int count = 1;

        public Node(int data) {
            this.data = data;
            left = null;
            right= null;
        }
    }

    public void insert(int id){
        Node newNode = new Node(id);

        if(root == null){
            root= newNode;
            return;
        }

        Node current = root;
        Node parent = null;

        while(true){

            parent = current;
            if(id < current.data){
                current = current.left;

                if(current == null){
                    parent.left = newNode;
                    return;
                }
            }
            else if (id > current.data){
                current = current.right;

                if(current == null){
                    parent.right = newNode;
                    return;

                }
            }
            else {
                current.count = current.count + 1;
                return;
            }


        }

    }

    public void printScores(){

        if(root == null){
            return;
        }
        bfsQueue.add(root);

        while( !bfsQueue.isEmpty()){
            Node n = bfsQueue.remove();
            System.out.println(n.data + " : " + n.count);

            if(n.left != null){
                bfsQueue.add(n.left);
            }
            if(n.right != null){
                bfsQueue.add(n.right);
            }

        }



    }

    public void insertInMap(int d){

        if(map.containsKey(d)){
            Integer val = map.get(d);
            val = val +1;
            map.put(d, val);
        }
        else {
            map .put (d, 1);
        }

    }

    public void printFromMap(){

        for(Map.Entry e : map.entrySet()){
            System.out.println(e.getKey() +" : " + e.getValue());
        }
    }

    public static void main(String[] args) {
        int[] scores = {4, 2, 5, 5, 6, 1, 4};
        ScroingApp scoringApp =new ScroingApp();
        for( int i : scores) {
            scoringApp.insert(i);
        }
        scoringApp.printScores();

        for( int i : scores) {
            scoringApp.insertInMap(i);
        }
        scoringApp.printScores();

    }
}
