package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B7567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
        StringTokenizer st;

        String s = br.readLine();

        int total = 10;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(i-1)) total += 10;
            else total += 5;
        }
        System.out.println(total);
        bw.close();
    }
}
