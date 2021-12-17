package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-17
 * Time: 22:43
 */
public class B9733_꿀벌 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        HashMap<String, Integer> hashMap = new HashMap<>();
        int total = 0;

        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            st = new StringTokenizer(sc.nextLine(), " ");
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
                total++;
            }
        }

        String[] jobs = {"Re","Pt","Cc","Ea","Tb","Cm","Ex"};
        for (String job : jobs) {
            double temp;
            if(hashMap.get(job)==null) {
                temp = 0;
            } else {
                temp = hashMap.get(job)/(double)total;
            }
            sb.append(job).append(" ").append(hashMap.get(job) == null ? 0 : hashMap.get(job) ).append(" ").append(String.format("%.2f",temp)).append("\n");
        }
        sb.append("Total").append(" ").append(total).append(" 1.00");

        bw.write(sb.toString());
        bw.close();
    }
}
