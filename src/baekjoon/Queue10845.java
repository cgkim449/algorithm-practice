package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Date: 2021-12-08
 * Time: 11:21
 * https://www.acmicpc.net/problem/10845
 */
public class Queue10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String cmd;
        StringBuilder sb = new StringBuilder();
        MyQueue<Integer> myQueue = new MyQueue<>();

        while(n-- > 0) {
            cmd = br.readLine();
            switch (cmd) {
                case "front": sb.append(myQueue.empty() ? "-1" : myQueue.front()).append("\n"); break;
                case "back": sb.append(myQueue.empty() ? "-1" : myQueue.back()).append("\n"); break;
                case "empty": sb.append(myQueue.empty() ? "1" : "0").append("\n"); break;
                case "pop": sb.append(myQueue.empty() ? "-1" : myQueue.pop()).append("\n"); break;
                case "size": sb.append((myQueue.size())).append("\n"); break;
                default: myQueue.push(Integer.parseInt(cmd.substring(5))); break;
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}

class MyQueue<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        public Node(E data) {
            this.data = data;
        }
    }

    public E front() {
        return head.data;
    }

    public E back() {
        return tail.data;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public E pop() {
        if(empty()) {
            return null;
        } else {
            E temp = head.data;
            if(head.next == null) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
            return temp;
        }
    }

    public void push(E e) {
        Node<E> newNode = new Node<>(e);
        if(empty()) {
            head = newNode;
            tail = newNode;
        } else {
            Node<E> temp = tail;
            tail = newNode;
            temp.next = tail;
            tail.prev = temp;
        }
        size++;
    }



}
