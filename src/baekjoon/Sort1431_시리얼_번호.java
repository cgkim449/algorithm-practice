package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-17
 * Time: 16:54
 */
public class Sort1431_시리얼_번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<String> al = new ArrayList<>();
        while (n-- > 0) {
            al.add(br.readLine());
        }
        Collections.sort(al, (o1, o2) -> {
            if(o1.length() != o2.length()) {
                return Integer.compare(o1.length(), o2.length());
            }
            char[] o1charArray = o1.toCharArray();
            char[] o2charArray = o2.toCharArray();

            int sumO1 = 0;
            int sumO2 = 0;

            for (int i = 0; i < o1charArray.length; i++) {
                char c1 = o1charArray[i];
                char c2 = o2charArray[i];
                if(c1 < 'A') {
                    sumO1 += Integer.parseInt(c1+"");
                }
                if(c2 < 'A') {
                    sumO2 += Integer.parseInt(c2 +"");
                }
            }
            if(sumO1 == sumO2) {
                return o1.compareTo(o2);
            }
            return Integer.compare(sumO1, sumO2);
        });

        for (String s : al) {
            sb.append(s).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();

    }
}
