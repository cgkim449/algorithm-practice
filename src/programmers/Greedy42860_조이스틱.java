package programmers;

/**
 * Date: 2021-12-28
 * Time: 12:11
 * https://programmers.co.kr/learn/courses/30/lessons/42860
 */
public class Greedy42860_조이스틱 {
    public static void main(String[] args) {
        System.out.println(solution("JEROEN")); // 012345
        System.out.println(solution("JAN"));
        System.out.println(solution("JAZ"));
        System.out.println(solution("BAABB"));// 1 11 11
    }
    public static int solution(String name) {
        int count = 0;
        int cursor = 0;

        char[] charArr = name.toCharArray();
        
        while (true) {
            if(charArr[cursor] <= 'N') {
                count += charArr[cursor] - 'A';
            } else {
                count += 'Z'-charArr[cursor]+1;
            }

            charArr[cursor]='A';

            // 가장 가까운 인덱스 검색
            int front = 0;
            int back = 0;
            int frontTemp = cursor;
            int backTemp = cursor;
    
            // 앞으로 검색
            loop:
            while (true) {
                for (int i = frontTemp; i <= charArr.length-1; i++) {
                    char c = charArr[i];
                    if(c!='A'){
                        front=i-frontTemp;
                        frontTemp=i;
                        break loop;
                    }
                }
                for (int i = 0; i < frontTemp; i++) {
                    char c = charArr[i];
                    if(c!='A'){
                        front=charArr.length-1-frontTemp+1+i;
                        frontTemp=i;
                        break loop;
                    }
                }
                // 없다? 전부 'A'다 끝.
                return count;
            }
            
            // 뒤로 검색
            loop:
            while (true) {
                for (int i = backTemp; i >=0; i--) {
                    char c = charArr[i];
                    if(c!='A'){
                        back=backTemp-i;
                        backTemp=i;
                        break loop;
                    }
                }
                for (int i = charArr.length-1; i >=backTemp; i--) {
                    char c = charArr[i];
                    if(c!='A'){
                        back=backTemp+1+charArr.length-1-i;
                        backTemp=i;
                        break loop;
                    }
                }

                // 없다? 전부 'A'다 끝.
                return count;
            }

            int shortest = front;
            cursor = frontTemp;
            if(front>back){
                shortest =back;
                cursor=backTemp;
            }
            count+=shortest; // 커서 이동
        }
    }
}
