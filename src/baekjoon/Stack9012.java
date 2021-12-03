package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by cgkim449
 * Date: 2021-12-03
 * Time: 10:39
 * https://www.acmicpc.net/problem/9012
 */
public class Stack9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        loop:
        while(n-- > 0) {
            stack.clear();
            char[] charArray = br.readLine().toCharArray();

            for (char c : charArray) {
                if (c == ')') { // ')'를 만나면
                    try {
                        stack.pop(); // 스택에 제일 위에 있는거 꺼내본다
                    } catch (EmptyStackException e) { // 스택이 비어있으면
                        sb.append("NO").append("\n"); // NO 출력
                        continue loop; // 다시 맨처음으로
                    }
                } else { // '('는 무조건 스택에 넣는다
                    stack.push(c);
                }
            }

            if(!stack.isEmpty()) { // 위 작업이 다 끝났는데 스택이 비어있지 않으면
                sb.append("NO").append("\n"); // NO 출력
            } else {
                sb.append("YES").append("\n"); // 비어있으면 YES 출력
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
