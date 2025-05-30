package EDs;

public class LinkedList {
    public Node head;
   public int num;

    public LinkedList() {
        this.head = null;
        this.num = 0;

    }

    public class Node {
        Node next;
        public int linha;

        public Node(int linha) {
            this.next = null;
            this.linha = linha;
        }

    }


    public void append(int linha) {

        Node newNode = new Node(linha);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;


        }
        num++;
    }


    public void insert(Node newNode, int index) {

        Node current = head;

        if (index == 0) {
            head = newNode;
            num++;
        } else {

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            if (current.next == null) {
                newNode.next = current.next;
            }
            num++;
        }
    }

    public int getLast() {
        if (head == null) {
            return -1;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.linha;
    }

    public void delete(int index) {

        Node current = head;
        Node previous = null;
        int deletedValue = -1;

        if (index == 0) {
            deletedValue = head.linha;
            head = head.next;
            num--;
        } else {
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
            }
            if (current.next != null) {
                deletedValue = current.linha;
                previous.next = current.next;
            }
            num--;
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.linha+ " ");
            current = current.next;
        }

    }
}



    /*public void changePosition(int index1, int index2) {
        Node current = head;
        Node current1 = head;

        Node index1Node = new Node(0);
        Node index2Node = new Node(0);

        index1Node.data = 0;
        index2Node.data = 0;

////////////////////////////////////////////////////////

        for (int i = 0; i < index1; i++) {
            current = current.next;
        }

        for (int i = 0; i < index2; i++) {
            current1 = current1.next;
        }
        index1Node = current1;
        System.out.println("Valor index 1:" + index1Node.data);
        index2Node = current;
        System.out.println("Valor index 2: " + index2Node.data);
            /////////////////////////////////////////////////////////
        int valueOfindex1 = index1Node.data;

        index1Node.data = index2Node.data;
        index2Node.data = valueOfindex1;

        }
        public void getList() {
            Node current = head;

            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }*/

