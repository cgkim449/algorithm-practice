package basicDataStructure;

/**
 * Date: 2021-12-05
 * Time: 21:09
 */
public class MyDoubleLinkedList<E> {
    public Node<E> head;
    public Node<E> tail;

    public class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    public void addNode(E data) {
        if(head == null) {
            head = new Node<>(data);
            return;
        }
        Node<E> node = head;
        while(true) {
            if(node.next == null) {
                Node<E> newNode = new Node<>(data);
                node.next = newNode;
                newNode.prev = node;
                tail = newNode;
                return;
            }
            node = node.next;
        }
    }

    public boolean insertToFront(E existedData, E addData) {
        if(head == null) {
            Node<E> newNode = new Node<>(addData);
            head = newNode;
            tail = newNode;
            return true;
        }

        if(head.data == existedData) {
            Node<E> newNode = new Node<>(addData);
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            return true;
        }
        Node<E> searchedNode = searchFromHead(existedData);
        if(searchedNode == null) {
            return false;
        }
        Node<E> newNode = new Node<>(addData);
        Node<E> temp = searchedNode.prev;
        newNode.next = searchedNode;
        newNode.prev = temp;
        temp.next = newNode;
        searchedNode.prev = newNode;
        return true;
    }

    public Node<E> searchFromHead(E isData) {
        if(head == null) {
            return null;
        }

        Node<E> node = head;
        while(true) {
            if(node == null) {
                return null;
            }
            if(node.data == isData) {
                return node;
            }
            node=node.next;
        }
    }

    public Node<E> searchFromTail(E isData) {
        if(head == null) {
            return null;
        }

        Node<E> node = tail;
        while(true) {
            if(node == null) {
                return null;
            }
            if(node.data == isData) {
                return node;
            }
            node=node.prev;
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
        MyDoubleLinkedList<Integer> myDoubleLinkedList = new MyDoubleLinkedList<>();
        myDoubleLinkedList.addNode(2);
        myDoubleLinkedList.addNode(4);
        myDoubleLinkedList.addNode(5);
        myDoubleLinkedList.addNode(8);
        myDoubleLinkedList.addNode(3);

        System.out.println("----------------");

        myDoubleLinkedList.insertToFront(3, 2);
        myDoubleLinkedList.printAll();
        System.out.println("----------------");

        System.out.println(myDoubleLinkedList.insertToFront(6, 2));
        System.out.println(myDoubleLinkedList.insertToFront(1, 0));
        myDoubleLinkedList.printAll();
        System.out.println("----------------");

        myDoubleLinkedList.addNode(6);
        myDoubleLinkedList.printAll();
    }
}
