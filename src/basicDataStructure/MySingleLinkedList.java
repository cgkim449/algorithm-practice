package basicDataStructure;

/**
 * Date: 2021-12-05
 * Time: 19:38
 */
public class MySingleLinkedList<E> {
    Node<E> head;

    public class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    public void addNode(E e) {
        if(head == null) {
            head = new Node<E>(e);
        } else {
            Node<E> node = head;
            while(node.next != null) {
                node = node.next;
            }
            node.next = new Node<E>(e);
        }
    }

    public void addNodeInside(E data, E isData) {
        Node<E> searchedNode = search(isData);
        if(searchedNode == null) {
            addNode(data);
            return;
        }
        Node<E> temp = searchedNode.next;

        Node<E> newNode = new Node<>(data);
        searchedNode.next = newNode;
        newNode.next = temp;
    }

    public boolean delNode(E data) {
        if(head == null) {
            return false;
        }

        if(head.data == data) {
            head = head.next;
            return true;
        }

        Node<E> node = head;

        while(true) {
            if(node.next == null) {
                return false;
            }
            if(node.next.data == data) {
                node.next = node.next.next;
                return true;
            }
            node = node.next;
        }

    }

    public Node<E> search(E isData) {
        if(head == null) {
            return null;
        }
        Node<E> node = head;
        while(true) {
            if(node.data == isData) {
                return node;
            }
            node = node.next;
            if(node == null) {
                return null;
            }
        }
    }

    public void printAll() {
        if(head != null) {
            Node<E> node = head;
            while(true) {
                System.out.println(node.data);
                node = node.next;
                if(node == null) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        MySingleLinkedList<Integer> mySingleLinkedList = new MySingleLinkedList<>();
        mySingleLinkedList.addNode(1);
        mySingleLinkedList.addNode(2);
        mySingleLinkedList.addNode(3);
        mySingleLinkedList.addNodeInside(5, 1);
        mySingleLinkedList.addNodeInside(6, 3);
        mySingleLinkedList.addNodeInside(7, 20); // 해당 데이터가 없으면 맨뒤에 추가하는 테스트
        mySingleLinkedList.delNode(3);
        mySingleLinkedList.delNode(1);
        mySingleLinkedList.delNode(7);
        System.out.println(mySingleLinkedList.delNode(20));
        mySingleLinkedList.printAll();
    }
}
