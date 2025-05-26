package EDs;

public class FilaDinamica<T> {

    private int numerodelementos;
    private Node head;

    private class Node {
        private Node next;
        private T elemento;

        public Node(T elemento) {
            this.elemento = elemento;
            this.next = null;
        }
    }



    public FilaDinamica(){
        this.numerodelementos = 0;
        this.head  = null;
    }

    public boolean isEmpty(){
        return numerodelementos == 0;
    }


    public T frente(){
        if(isEmpty()) return null;
        return head.elemento;
    }

    public void enfileira(T element){
        Node n = new Node(element);

        if(head == null) {
            head = n;
            numerodelementos++;
        }else {

            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = n;


            numerodelementos++;
        }
    }

    public T desenfileirar(){
        if(isEmpty()){
            return null;
        }else {
            T valor = head.elemento;
            head = head.next;
            numerodelementos--;
            return valor;
        }
    }

    public void imprime(){
        Node current = head;
        while(current.next != null){
            System.out.println(current.elemento);
        }
    }
}


