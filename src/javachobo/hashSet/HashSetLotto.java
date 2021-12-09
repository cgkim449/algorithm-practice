package javachobo.hashSet;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Date: 2021-12-07
 * Time: 18:12
 */
public class HashSetLotto {
    public static void main(String[] args) {
        Set set = new HashSet();

        for (int i = 0; set.size() < 6; i++) {
            int num = (int) (Math.random()*45) + 1;
            set.add(new Integer(num));
        }

        List list = new LinkedList<>(set);
        Collections.sort(list);
        System.out.println(list);
    }
}