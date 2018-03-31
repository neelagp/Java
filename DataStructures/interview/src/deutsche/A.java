package deutsche;

/**
 * Created by NeelaGouda on 4/28/16.
 */
public class A extends Thread{
        int count = 0;
        public void run(){
            //while(true){ //(b)
            count++; //(a)
            //}
        }
        public static void main(String []args) throws InterruptedException {
            A a = new A();
            a.start();
            a.join();
            System.out.println(a.count);
        }
}
