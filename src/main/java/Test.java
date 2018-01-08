import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List l = new ArrayList<String>(){
            {
                for (int i = 0; i <2 ; i++) {
                    this.add("你妹"+i);
                }
            }
        };
        System.out.println(l);
    }
}
