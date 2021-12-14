package basicDataStructure;

/**
 * Date: 2021-12-13
 * Time: 18:09
 */

class Node{
    Node left;
    Node right;
    int value;
    Node(int data) {
        this.value = data;
        this.left = null;
        this.right = null;
    }
}

public class MyNodeMgmt {
    Node head = null;

    public boolean insertNode(int data) {

        // CASE1: Node 가 하나도 없을 때
        if (this.head == null) {
            this.head = new Node(data);
        } else {
            // CASE2: Node 가 하나라도 들어가 있을 때
            Node findNode = this.head;
            while (true) {

                // CASE2-1: 현재 Node 의 왼쪽에 data 가 들어가야 할 때
                if (data < findNode.value) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }

                    // CASE2-2: 현재 Node 의 오른쪽에 data 가 들어가야 할 때
                } else {
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public Node search(int data) {
        // CASE1: Node 가 하나도 없을 때
        if (head == null) {
            return null;
        } else {
            // CASE2: Node 가 하나라도 들어가 있을 때
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.value == data) {
                    return findNode;
                } else if (data < findNode.value) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
            return null;
        }
    }

    public boolean delete(int value) {
        boolean searched = false;
        Node currParentNode = this.head;
        Node currNode = this.head;

        // 코너 케이스1: Node 가 하나도 없을 때
        if (this.head == null) {
            return false;
        } else {
            // 코너 케이스2: (Node 가 단지 하나이고, 해당 Node 삭제 시)
            if (this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }

            while (currNode != null) {
                if (currNode.value == value) {
                    searched = true;
                    break;
                } else if (value < currNode.value) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }

            if (searched == false) {
                return false;
            }
        }

        // Case1: 삭제할 Node가 Leaf Node인 경우
        if (currNode.left == null && currNode.right == null) {
            if (value < currParentNode.value) {
                currParentNode.left = null;
                currNode = null;
            } else {
                currParentNode.right = null;
                currNode = null;
            }
            return true;
            // Case2: 삭제할 Node가 Child Node를 한 개 가지고 있을 경우 (왼쪽)
        } else if (currNode.left != null && currNode.right == null) {
            if (value < currParentNode.value) {
                currParentNode.left = currNode.left;
                currNode = null;
            } else {
                currParentNode.right = currNode.left;
                currNode = null;
            }
            return true;
            // Case2: 삭제할 Node가 Child Node를 한 개 가지고 있을 경우 (오른쪽)
        } else if (currNode.left == null && currNode.right != null) {
            if (value < currParentNode.value) {
                currParentNode.left = currNode.right;
                currNode = null;
            } else {
                currParentNode.right = currNode.right;
                currNode = null;
            }
            return true;
            // Case3-1: 삭제할 Node가 Child Node를 두 개 가지고 있을 경우
        } else {

            if (value < currParentNode.value) {

                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (currNode.left != null) {
                    changeParentNode = currNode;
                    changeNode = currNode.left;
                }

                if (changeNode.right != null) {
                    // Case3-1-2: 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 오른쪽에 Child Node가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    // Case3-1-1: 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 오른쪽에 Child Node가 없을 때
                    changeParentNode.left = null;
                }
                currParentNode.left = changeNode;
                changeNode.right = currNode.right;
                changeNode.left = currNode.left;

                currNode = null;
            } else {
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }

                if (changeNode.right != null) {
                    // Case3-2-2: 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 오른쪽에 Child Node가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    // Case3-2-1: 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 오른쪽에 Child Node가 없을 때
                    changeParentNode.left = null;
                }

                currParentNode.right = changeNode;

                if (currNode.right != changeNode) {
                    changeNode.right = currNode.right;
                }
                changeNode.left = currNode.left;
                currNode = null;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        MyNodeMgmt myTree = new MyNodeMgmt();
    }
}
