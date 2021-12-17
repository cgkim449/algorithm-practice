package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-17
 * Time: 19:09
 */
public class Sort11004_K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        ArrayList<Integer> al = new ArrayList<>(n);
        while (st.hasMoreTokens()) {
            al.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(al);
        System.out.println(al.get(k-1));
        br.close();
    }
}
