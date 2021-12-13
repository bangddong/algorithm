package DataStructure;

public class DoubleLinkedList<T> {
    public Node<T> head = null;
    public Node<T> tail = null;

    public static class Node<T> {
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (this.head == null) {
            this.head = new Node<T>(data);
            this.tail = this.head;
        } else {
            Node<T> node = this.head;
            // 맨 끝 Node로 이동
            while(node.next != null) {
                node = node.next;
            }
            // 신규 Node 생성
            node.next = new Node<T>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void printAll() {
        if(this.head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while(node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }
    // 앞에서부터 탐색
    public T searchFromHead(T isData) {
        if (this.head != null) {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == isData) {
                    return node.data;
                } else {
                    node = node.next;
                }
            }
        }
        return null;
    }
    // 뒤에서부터 탐색
    public T searchFromTail(T isData) {
        if (this.head != null) {
            Node<T> node = this.tail;
            while (node != null) {
                if (node.data == isData) {
                    return node.data;
                } else {
                    node = node.prev;
                }
            }
        }
        return null;
    }

    public boolean insertToFront(T existedData, T addData) {
        if (this.head == null) {
            this.head = new Node<T>(addData);
            this.tail = this.head;
            return true;
        } else if (this.head == existedData) {
            Node<T> newHead = new Node<T>(addData);
            newHead.next = this.head;
            this.head = newHead;
            this.head.next.prev = this.head;
            return true;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == existedData) {
                    // 이전 노드값 셋팅
                    Node<T> nodePrev = node.prev;
                    // 이전 노드값의 다음에 신규 노드 생성
                    node.prev.next = new Node<T>(addData);
                    node.prev.next.next = node;

                    nodePrev.next.prev = nodePrev;
                    node.prev = nodePrev.next;
                    return true;
                } else {
                    node = node.next;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> MyLinkdList = new DoubleLinkedList<>();

        MyLinkdList.addNode(1);
        MyLinkdList.addNode(2);
        MyLinkdList.addNode(3);
        MyLinkdList.addNode(4);
        MyLinkdList.addNode(5);
        MyLinkdList.printAll();
        System.out.println("--------------------------");

        MyLinkdList.insertToFront(3, 2);
        MyLinkdList.printAll();
        System.out.println("--------------------------");

        MyLinkdList.insertToFront(6, 2);
        MyLinkdList.insertToFront(1, 0);
        MyLinkdList.printAll();
        System.out.println("--------------------------");

    }
}
