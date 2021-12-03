package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by cgkim449
 * Date: 2021-12-03
 * Time: 15:02
 */
public class Sort1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.length() < o2.length()) {
                return -1;
            } else if(o1.length() == o2.length()) {
                char[] o1Arr = o1.toCharArray();
                char[] o2Arr = o2.toCharArray();

                int o1Total = 0;
                int o2Total = 0;

                for (int i = 0; i < o1Arr.length; i++) {
                    char c = o1Arr[i];
                    char c1 = o2Arr[i];
                    if (c < 65) {
                        o1Total += Character.getNumericValue(c);
                    }

                    if (c1 < 65) {
                        o2Total += Character.getNumericValue(c1);
                    }
                }

                if(o1Total < o2Total) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return 1;
        });


        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        bw.close();
        br.close();
    }
}
