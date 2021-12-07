package javachobo;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Date: 2021-12-07
 * Time: 20:59
 */

/*
 * 배열에 객체를
 * 1.순차적으로 저장할 때와('마지막'에 저장할때와)
 * 2.객체를 '마지막'부터 삭제하면
 * System.arraycopy()를 호출하지 않기때문에 작업시간이 짧음
 *
 * 그러나 배열의 중간에 위치('마지막'이 아닌 객체)한 객체를 추가하거나 삭제하는 경우
 * System.arraycopy()를 호출해서 다른 데이터를 이동시켜줘야하기때문에 작업시간이 오래걸림.
 * 
 * System.arraycopy()는 단순히 2.'데이터'를 복사해주는 애임
 * 우리가 1.배열을 생성해서 제공해줘야하고, 3.참조변수값도 변경해줘야함.
 * 1,2,3 순서로 일어남
 *
 * 1. size != capacity
 * 2. System.arraycopy(data, index+1, data, index, size-index-1); // size - (index + 2) + 1 개
 */
public class MyVector implements List {
    Object[] data = null;
    int capacity = 0;
    int size = 0;

    public MyVector(int capacity) {
        if(capacity < 0) {
            throw new IllegalArgumentException("유효하지 않은 값입니다:" + capacity);
        }
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public MyVector() {
        this(10); // 크기를 지정하지 않으면 크기를 10으로 한다
    }

    // 최소한의 저장공간(capacity)를 확보하는 메서드
    public void ensureCapacity(int minCapacity) {
        if(minCapacity - data.length > 0) {
            setCapacity(minCapacity);
        }
    }

    public boolean add(Object obj) {
        // 새로운 객체를 저장하기 전에 저장할 공간을 확보한다
        ensureCapacity(size + 1);
        data[size++] = obj;
        return true;
    }

    public Object get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("범위를 벗어났습니다");
        }
        return data[index];
    }

    public Object remove(int index) {
        Object oldObj = null;

        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("범위를 벗어낫다.");
        }
        oldObj = data[index];

        // 삭제하고자 하는 객체가 마지막 객체가 아니라면, 배열복사를 통해 빈자리를 채워줘야한다
        if(index != size -1) {
            System.arraycopy(data, index + 1, data, index, size-index-1);
        }
        // 마지막 데이터를 null로 한다. 배열은 0부터 시작하므로 마지막 요소는 index가 size-1이다.
        data[size-1] = null;
        size--;
        return oldObj;
    }

    public boolean remove(Object obj) {
        for (int i = 0; i < size; i++) {
            if(obj.equals(data[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public void trimToSize() {
        setCapacity(size);
    }

    private void setCapacity(int capacity) {
        if(this.capacity==capacity) return;// 크기가 같으면 변경하지 않는다

        Object[] tmp = new Object[capacity];
        System.arraycopy(data, 0, tmp, 0, size);
        data =tmp;
        this.capacity = capacity;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

    public boolean isEmpty() {return size==0;}
    public int capacity() {return capacity;}
    public int size() {return size;}

    /////////////////////////////////////////////////

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
