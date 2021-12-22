package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by cgkim449
 * Date: 2021-12-02
 * Time: 09:45
 * https://www.acmicpc.net/problem/1302
 */
public class Hash1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String,Integer> hashMap = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());


        while(n-- > 0) {
            String bookTitle = br.readLine();
            hashMap.put(bookTitle, hashMap.getOrDefault(bookTitle, 0) + 1);
        }

        int max = 0;
        for (String s : hashMap.keySet()) {
                max = Math.max(max, hashMap.get(s));
        }

        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        for (String s : hashMap.keySet()) {
            if(hashMap.get(s) == max) {
                priorityQueue.offer(s);
            }
        }

        bw.write(priorityQueue.poll());
        bw.close();
    }
}
