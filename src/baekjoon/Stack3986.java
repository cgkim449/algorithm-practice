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
 * Time: 17:47
 * https://www.acmicpc.net/problem/3986
 */
public class Stack3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int count = 0;

        while(n-- > 0) {
            char[] chars = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();

            for (char c : chars) {
                if (!stack.isEmpty()) {
                    if (stack.peek() == c) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            }

            if(stack.empty()) {
                count++;
            }
        }
        System.out.println(count);
        br.close();
        bw.close();
    }
}
