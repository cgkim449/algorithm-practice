package basicAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Date: 2021-12-16
 * Time: 17:03
 */
public class A_삽입정렬 {
    public static ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int i = 1; i <= dataList.size() - 1; i++) {
            int temp = i;
            for (int j = i - 1; j >= 0; j--) {
                if(dataList.get(temp) > dataList.get(j)) {
                    break;
                }
                Collections.swap(dataList, temp--, j);
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dataList.add((int)(Math.random()*100));
        }
        System.out.println(sort(dataList));
    }
}
/* https://visualgo.net/en/sorting
 * O(n제곱). (n-1)(n)/2
 */