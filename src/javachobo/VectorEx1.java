package javachobo;

import java.util.Vector;

/**
 * Date: 2021-12-07
 * Time: 20:47
 */

/*
 * ArrayList는 데이터를 읽어오고 저장?하는데는 효율이 좋지만,
 * 용량을 변경해야할 때는
 * 1. 새로운 배열 생성
 * 2. 데이터 복사
 * 3. 참조변수 값 변경
 * 해야 하기 때문에 상당히 효율이 떨어짐
 */

public class VectorEx1 {
    public static void main(String[] args) {
        // trimTosize(), ensureCapacity(), setSize(), clear(), size(), capacity() (ArrayList는 없음)
        Vector v = new Vector(5); // 용량 = 5
        v.add("1");
        v.add("2");
        v.add("3");
        print(v);

        v.trimToSize(); // 빈 공간을 없앤다. 용량과 크기가 같아진다
        System.out.println("===After trimToSize() ===");
        print(v);

        v.ensureCapacity(6);
        System.out.println("===After ensureCapacity(6)===");
        print(v);

        v.setSize(7);
        System.out.println("===After setSize(7)===");
        print(v);

        v.clear();
        System.out.println("===After clear()===");
        print(v);
    }

    public static void print(Vector v) {
        System.out.println(v);
        System.out.println("size:" + v.size());
        System.out.println("capacity:" + v.capacity());
    }
}
