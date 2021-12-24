package programmers;

import java.util.HashSet;

/**
 * Date: 2021-12-24
 * Time: 11:44
 * https://programmers.co.kr/learn/courses/30/lessons/42862
 */
public class Greedy42862_체육복 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2,4}, new int[]{1,3,5}));
        System.out.println(solution(5, new int[]{2,4}, new int[]{3}));
        System.out.println(solution(3, new int[]{3}, new int[]{1}));
        System.out.println(solution(2, new int[]{1}, new int[]{1,2}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {

        HashSet<Integer> lostSet = new HashSet<>();
        HashSet<Integer> reserveSet = new HashSet<>();

        for (int l : lost) {
            lostSet.add(l);
        }
        for (int r : reserve) {
            if(lostSet.contains(r)) {
                lostSet.remove(r);
            } else {
                reserveSet.add(r);
            }
        }

        int count = lostSet.size();

        for (int l : lostSet) {
            if(reserveSet.contains(l-1)){
                count--;
                reserveSet.remove(l-1);
            } else if(reserveSet.contains(l+1)){
                count--;
                reserveSet.remove(l+1);
            }
        }

        return n - count;
    }
}
