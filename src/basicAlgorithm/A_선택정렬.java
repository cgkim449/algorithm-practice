package basicAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Date: 2021-12-16
 * Time: 16:43
 */
public class A_선택정렬 {
    public static ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int i = dataList.size(); i >= 2; i--) { // 비교하는 개수
            int min = dataList.size() - i;
            for (int j = dataList.size() - i + 1; j < dataList.size(); j++) { // 인덱스
                if(dataList.get(min) > dataList.get(j)) {
                    min = j;
                }
            }
            Collections.swap(dataList, dataList.size() - i, min);
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
 * 시간복잡도
 * 최악의 경우 n*(n-1)/2. 따라서 O(n제곱)임.
 */
