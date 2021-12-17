package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-17
 * Time: 12:45
 * https://www.acmicpc.net/problem/1138
 */
public class Impl1138_한줄로_서기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] intArray = new int[n];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = intArray.length - 1; i >=0; i--) {
            int m = intArray[i];
            ll.add(m, i+1);
        }
        StringBuilder sb = new StringBuilder();
        for (int l : ll) {
            sb.append(l).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
