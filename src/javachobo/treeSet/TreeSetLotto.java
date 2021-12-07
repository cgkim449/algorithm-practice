package javachobo.treeSet;

import java.util.Set;
import java.util.TreeSet;

/**
 * Date: 2021-12-07
 * Time: 19:26
 */
public class TreeSetLotto {
    public static void main(String[] args) {
        Set set = new TreeSet();

        for (int i = 0; set.size() < 6; i++) {
            int num = (int) (Math.random()*45) + 1;
            set.add(num);
        }
        System.out.println(set);
    }
}
