package DataStructure;

public class SingleLinkedList<T> {
    public Node<T> head = null;

    public static class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    // 맨 뒤에 Node 추가
    public void addNode(T data) {
        // head의 default가 null임으로 최초값은 head로 셋팅
        if (head == null) {
            head = new Node<T>(data);
        } else {
            Node<T> node = this.head;
            // Node의 마지막을 찾아감.
            while(node.next != null) {
                node = node.next;
            }
            // 마지막 뒤에 새로운 Node를 지정
            node.next = new Node<T>(data);
        }
    }
    // Node 중간에 Node를 추가하기 위해 특정 Node값 탐색
    public Node<T> search(T data) {
        if(this.head == null) {
            return null;
        } else {
            // 처음부터 탐색
            Node<T> node = this.head;
            while(node != null) {
                // 찾고자 하는 Node를 찾았다면 해당 Node return
                if (node.data == data) {
                    return node;
                } else {
                    // 찾을 때 까지 next
                    node = node.next;
                }
            }
            // return 받지 못했다면 찾고자 하는 Node는 없음.
            return null;
        }
    }
    // Node 중간에 Node 추가
    public void addNodeInside(T data, T isData) {
        Node<T> searchNode = this.search(isData);

        if(searchNode == null) {
            this.addNode(data);
        } else {
            // 이전 Node의 다음 주소값 획득
            Node<T> nextNode = searchNode.next;
            // 끼워넣고자 하는 이전 Node의 다음 주소를 새 Node로 변경
            searchNode.next = new Node<T>(data);
            // 새 Node의 다음 주소를 미리 구한 Node의 주소로 변경
            searchNode.next.next = nextNode;
        }
    }

    // 특정 Node 삭제
    public boolean delNode(T isData) {
        // Head가 없다면 바로 false return
        if (this.head == null) {
            return false;
        } else {
            Node<T> node = this.head;
            if (node.data == isData) {
                this.head = this.head.next;
                return true;
            } else {
                while(node.next != null) {
                    // 지우고자 하는 Data를 찾았다면 이전 Data의 다음 주소값을 변경시켜 버림
                    if (node.next.data == isData) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                // 지우고자 하는 Data를 찾지 못함.
                return false;
            }
        }
    }

    public void printAll() {
        if (head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while(node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> MyLinkedList = new SingleLinkedList<>();
        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.addNodeInside(5, 1);
        MyLinkedList.addNodeInside(6, 3);
        MyLinkedList.addNodeInside(7, 20);
        System.out.println(MyLinkedList.delNode(10));
        MyLinkedList.printAll();
    }
}
