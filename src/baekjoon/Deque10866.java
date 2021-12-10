package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-10
 * Time: 09:53
 * https://www.acmicpc.net/problem/10866
 */
public class Deque10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String cmd;
        StringBuilder sb = new StringBuilder();
        MyDeque<Integer> MyDeque = new MyDeque<>();
        StringTokenizer st;
        while(n-- > 0) {
            cmd = br.readLine();
            switch (cmd) {
                case "front": sb.append(MyDeque.empty() ? "-1" : MyDeque.front()).append("\n"); break;
                case "back": sb.append(MyDeque.empty() ? "-1" : MyDeque.back()).append("\n"); break;
                case "empty": sb.append(MyDeque.empty() ? "1" : "0").append("\n"); break;
                case "pop_front": sb.append(MyDeque.empty() ? "-1" : MyDeque.popFront()).append("\n"); break;
                case "pop_back": sb.append(MyDeque.empty() ? "-1" : MyDeque.popBack()).append("\n"); break;
                case "size": sb.append((MyDeque.size())).append("\n"); break;
                default:
                    st = new StringTokenizer(cmd, " ");
                    st.nextToken();
                    int x = Integer.parseInt(st.nextToken());
                    if(cmd.charAt(5) == 'f') {
                        MyDeque.pushFront(x);
                    } else {
                        MyDeque.pushBack(x);
                    }
                    break;
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}

class MyDeque<E> {
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

    public boolean empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public E front() {
        if(empty()) {
            return null;
        }
        return head.data;
    }

    public E back() {
        if(empty()) {
            return null;
        }
        return tail.data;
    }

    public E popFront() {
        if(empty()) {
            return null;
        }

        if(size == 1) {
            Node<E> temp = head;
            head = null;
            tail = null;
            size--;
            return temp.data;
        }

        Node<E> temp = head;
        head = head.next;
        head.prev = null;
        size--;
        return temp.data;
    }

    public E popBack() {
        if(empty()) {
            return null;
        }

        if(size == 1) {
            Node<E> temp = head;
            head = null;
            tail = null;
            size--;
            return temp.data;
        }

        Node<E> temp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;

        return temp.data;
    }

    public void pushFront(E data) {
        Node<E> newNode = new Node<>(data);
        if(empty()) {
            head = newNode;
            tail = newNode;
        } else {
            Node<E> temp = head;
            head = newNode;
            head.next = temp;
            head.next.prev = head;
        }
        size++;
    }

    public void pushBack(E data) {
        Node<E> newNode = new Node<>(data);
        if(empty()) {
            head = newNode;
            tail = newNode;
        } else {
            Node<E> temp = tail;
            tail = newNode;
            tail.prev = temp;
            tail.prev.next = tail;
        }
        size++;
    }
}
