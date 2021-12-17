package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-17
 * Time: 20:15
 * https://www.acmicpc.net/problem/11399
 */
public class Sort11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        ArrayList<Integer> al = new ArrayList<>();
        while (st.hasMoreTokens()){
            al.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(al);
        int[] cache = new int[n];
        cache[0] = al.get(0);
        int sum = cache[0];
        for (int i = 1; i < al.size(); i++) {
            cache[i] += cache[i-1] + al.get(i);
            sum += cache[i];
        }
        System.out.println(sum);
        br.close();
    }
}
/*
 * 실행시간이 빠른거부터 해야 최소시간.
 * 프머 디스크 컨트롤러랑 같은문제. 
 * sjf 알고리즘
 */