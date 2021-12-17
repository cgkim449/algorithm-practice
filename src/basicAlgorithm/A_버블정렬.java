package basicAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Date: 2021-12-14
 * Time: 14:20
 */
public class A_버블정렬 {
    public static ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        loop:
        for (int i = 0; i < dataList.size(); i++) {
            boolean isSwapped = false;
            for (int j = 0; j < dataList.size() - i; j++) {
                if(j == dataList.size() - i - 1) {
                    continue loop;
                }
                if(dataList.get(j) > dataList.get(j+1)) {
                    Collections.swap(dataList, j , j+1);
                    isSwapped = true;
                }
            }
            if(!isSwapped) {
                break;
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
 * 1. isSwapped : 반복문 돌았는데 한번도 스왑되지 않았다는건 스왑할 필요가 없었다는거고 그말은 정렬이 다 된상태라는 것
 * 2. 이중포문인데 인덱스 하나씩 줄음
 *
 * 시간복잡도
 * 최악의 경우 n*(n-1)/2. 따라서 O(n제곱)임.
 * 최선은 이미 다 정렬 다 되있는 상태. O(n).
 */