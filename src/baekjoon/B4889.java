package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * Created by cgkim449
 * Date: 2021-12-02
 * Time: 18:07
 */
public class B4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int j = 1;
        while (true) {
            char[] chars = br.readLine().toCharArray();
            if (chars[0] == '-') break;
            Stack<Character> stack = new Stack<>();
            int count = 0;
            stack.push('{');
            if (chars[0] == '}') count++;
            for (int i = 1; i < chars.length; i++) {
                char c = chars[i];
                if (!stack.empty()) {
                    if (c == '{') stack.push(c);
                    else stack.pop();
                } else if (stack.empty()) {
                    stack.push('{');
                    if (c == '}') count++;
                }
            }
            if (!stack.empty()) {
                while (true) {
                    stack.pop();
                    stack.pop();
                    count++;
                    if (stack.empty()) break;
                }
            }
            sb.append(j++).append(". ").append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
