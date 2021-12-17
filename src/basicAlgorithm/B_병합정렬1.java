package basicAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Date: 2021-12-16
 * Time: 19:19
 * https://www.acmicpc.net/problem/2751
 */
public class B_병합정렬1 {
    public static ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int j = 2;; j*=2) {
            if(dataList.size() / (j /2) == 0) { // 바로 이전 j가 마지막 merge.
                break;
            }
            for (int i = 0; i <= dataList.size() - 1; i+=j) {
                if (dataList.size() - 1 - i + 1 <= j / 2) {
                    break;
                }
                int cursor1 = i;
                int cursor2 = i + j / 2;

                int length = 0;

                if(i >= (dataList.size() / j) * j) { // (배열 길이 % j) != 0 이면 맨 마지막 꼬다리가 남는다
                    length = dataList.size() - 1 - i + 1;
                } else {
                    length = j; // j개
                }

                int[] ints = new int[length];

                for (int t = 0; t < length; t++) {
                    if (cursor1 == i + j / 2) { // cursor2는 아직 갈길이 남앗는데 cursor1이 끝까지 갔을때
                        for (int k = t; k < ints.length; k++) {
                            ints[k] = dataList.get(cursor2++);
                        }
                        break;
                    }
                    if (cursor2 == dataList.size() || cursor2 == i + j / 2 + j / 2) { // 맨 마지막 꼬다리일때는 cursor2 == dataList.size()일때가 cursor2가 끝까지 간거임
                        for (int k = t; k < ints.length; k++) {
                            ints[k] = dataList.get(cursor1++);
                        }
                        break;
                    }

                    if (dataList.get(cursor1) > dataList.get(cursor2)) {
                        ints[t] = dataList.get(cursor2++);
                    } else {
                        ints[t] = dataList.get(cursor1++);
                    }
                }

                int temp = i;
                for (int anInt : ints) {
                    dataList.set(temp++, anInt);
                }
            }
        }
        return dataList;
    }

    public static void main(String[] args) throws IOException { // 5 4 3 2 1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> dataList = new ArrayList<>();

        while(n-- > 0) {
            dataList.add(Integer.parseInt(br.readLine()));
        }

        dataList=sort(dataList);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : dataList) {
            sb.append(integer).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}

/* https://visualgo.net/
 * 두 단계
 * 1. 끝까지(전부 1개짜리로) 분리함
 * 2. 합쳐서 전부 두개짜리로 만듬(커서를 이동시키면서). 합쳐서 전부 4개짜리로 만듬.
 * 
 * 1. 1개로 분리
 * 2. 합쳐서 전부 두개짜리로 만듬
 *  - 두 개 커서를 이동시키는데, 한쪽 커서가 먼저 끝에 도달하면 나머지 커서 있는쪽 애들 전부 배열에 넣음
 *  - 배열 생성해서 거기에 담아놓고 ArrayList에 다시 담음
 * 
 * 저 위에잇는 사이트 비슷하게 햇음
 */