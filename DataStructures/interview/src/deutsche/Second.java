package deutsche;

/**
 * Created by NeelaGouda on 4/28/16.
 */
public class Second {

    public void foo(StringBuffer sb){
        sb.append("foo");
        sb = new StringBuffer();
        sb.append("wow");
    }

    public static void main(String[] args) {
        Second second = new Second();
        StringBuffer sbOriginal = new StringBuffer("SB1");
        second.foo(sbOriginal);
        System.out.println(sbOriginal);

    }

}
