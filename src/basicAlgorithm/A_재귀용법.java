package basicAlgorithm;

/**
 * Date: 2021-12-16
 * Time: 17:24
 */
public class A_재귀용법 {

    public static int f(int n) {
        if(n==1) {
            return 1;
        }
        if(n==2) {
            return 2;
        }
        if(n==3) {
            return 4;
        }
        return f(n-1) + f(n-2)+f(n-3);
    }

    public static void main(String[] args) {
        System.out.println(f(5));
    }
}
/* factorial
 * n-1번의 factorial 함수를 호출해서 곱셈을 함.
 * 일종의 n-1번 반복문을 호출한 것과 동일(재귀호출의 시간복잡도는 함수를 몇번 호출했는지임)
 * factorial 호출할때마다 지역변수 n 생성. 따라서 시간복잡도 공간복잡도 둘다 O(n)
 *
 * 마치 while문 같음. 얘를 들면 while(n-- > 0) 이 있다고 하면 재귀에서는 n-- 가 매개변수.그리고 <= 0이면 return.
 * 즉 매개변수에 뭔가 n이 줄어들음.
 */