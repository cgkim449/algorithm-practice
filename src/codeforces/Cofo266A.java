package codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * Date: 2021-12-12
 * Time: 18:32
 */
public class Cofo266A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        char[] charArray = br.readLine().toCharArray();

        int count = 0;
        for (char c : charArray) {
            if(stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (stack.peek() == c) {
                count++;
            } else {
                stack.push(c);
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
        br.close();
    }
}
