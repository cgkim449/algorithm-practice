package javachobo;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Date: 2021-12-07
 * Time: 20:25
 */

/*
 * 배열은 뒤에서 부터 삭제한다! 왜냐면 자리이동이 일어나서다
 */
public class ArrayListEx1 {
    public static void main(String[] args) {
        // add, subList, get, set, containsAll, contains, remove, size, retainAll, Collections.sort, 
        ArrayList list1 = new ArrayList(10);
        list1.add(new Integer(5));
        list1.add(new Integer(4));
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        list1.add(new Integer(1));
        list1.add(new Integer(3));

        ArrayList list2 = new ArrayList(list1.subList(1, 4));
        print(list1, list2);

        Collections.sort(list1);
        Collections.sort(list2);
        print(list1, list2);

        System.out.println("list1.containsAll(list2):" + list1.containsAll(list2));

        list2.add("B");
        list2.add("C");
        list2.add(3, "A");
        print(list1, list2);

        list2.set(3, "AA");
        print(list1, list2);

        // list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다
        System.out.println("list1.retainAll(list2):" + list1.retainAll(list2));
        print(list1, list2);

        // list2에서 list1에 포함된 객체들을 삭제한다
        for (int i = list2.size() - 1; i >= 0; i--) { // 뒤에서 부터 삭제한다! 왜냐면 자리이동이 일어나서다
            if(list1.contains(list2.get(i))) {
                list2.remove(i);
            }
        }
        print(list1, list2);
    }
    static void print(ArrayList list1, ArrayList list2) {
        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);
        System.out.println();
    }
}
