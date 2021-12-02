package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Stack10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        MyStack myStack = new MyStack(n);

        while(n-- > 0) {
            String s = br.readLine();
            switch (s) {
                case "top": sb.append(myStack.top()).append("\n"); break;
                case "size": sb.append(myStack.size()).append("\n"); break;
                case "empty": sb.append(myStack.empty()).append("\n"); break;
                case "pop": sb.append(myStack.pop()).append("\n"); break;
                default: myStack.push(Integer.parseInt(s.substring(5))); break;
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}

class MyStack {
    int[] stack;
    int size = 0;

    public MyStack(int length) {
        stack = new int[length];
    }

    public int top() { return empty() == 1 ? -1 : stack[size - 1]; }

    public int size() {
        return size;
    }

    public int empty() {
        return size == 0 ? 1 : 0;
    }

    public int pop() {
        return empty() == 1 ? -1 : stack[size-- - 1];
    }

    public void push(int n) {
        stack[size++] = n;
    }
}