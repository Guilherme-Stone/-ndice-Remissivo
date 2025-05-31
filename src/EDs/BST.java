package EDs;


import Classes.Palavras;

import java.security.PublicKey;
import java.util.Deque;
import java.util.LinkedList;

public class BST {

    public Node root;
    public int size;

    public BST(){
        this.root = null;
        this.size = 0;
    }

    public class Node {
        Palavras value;
        Node left;
        Node right;
        Node parent;

        public Node(Palavras v) {
            this.value = v;
        }
        //grau é a qnt de filhos quem um pai tem'

        public boolean hasOnlyLeftChild() {
            return (this.left != null && this.right == null);
        }

        public boolean hasOnlyRightChild() {
            return (this.left == null && this.right != null);
        }

        public boolean isLeaf() {
            return this.left == null && this.right == null;
        }

    }


    public boolean isEmpty() {
        return this.root == null;
    }


    public void recursiveAdd(Palavras element) {

         recursiveAdd(this.root, element);
    }

    private void recursiveAdd(Node node, Palavras element) {
        Node newNode = new Node(element);

        if(node == null){
            this.root = newNode;
            this.size++;
            return;
        }
        if (element.compareTo(node.value)<0) {
            if (node.left == null) {
                node.left = newNode;
                this.size++;
                return;
            }
            recursiveAdd(node.left, element);
        } else {
            if (node.right == null) {
                node.right = newNode;
                this.size++;
                return;
            }
            recursiveAdd(node.right, element);
        }
    }


    public Palavras recursiveSearch(Palavras element) {
        return recursiveSearch(this.root, element);
    }

    private Palavras recursiveSearch(Node node, Palavras element) {
        if (node == null) return null;
        if (element.equalsNormalizado(node.value)) return node.value;
        if (element.getPalavra().compareToIgnoreCase(node.value.getPalavra())<0)return recursiveSearch(node.left, element);
        else return recursiveSearch(node.right, element);
    }

    public Node min() {

        if (isEmpty()) return null;
        else return min(this.root);

    }


    private Node min(Node node) {
        if (node.left == null) return node;
        else return min(node.left);
    }

    // iterativa
    public Node max() {
        if (isEmpty()) return null;

        Node node = this.root;
        while (node.right != null) {
            node = node.right;
        }

        return node;
    }

    // recursiva
    private Node max(Node node) {
        if (node.right == null) return node;
        else return max(node.right);
    }


    public Node sucessor(Node node) {
        if (node == null) return null;

        if (node.right != null) return min(node.right);
        else {
            Node aux = node.parent;

            while (aux.left != null && aux.value.compareTo(node.value)<0) {
                aux = aux.parent;
            }
            return aux;
        }
    }

    public Node predecessor(Node node) {
        if (node == null) return null;


        //Então a função retorna max(node.left), ou seja, o maior valor da subárvore esquerda.
        if (node.left != null) return max(node.left);

        else {
            Node aux = node.parent;

            while (aux.right != null && aux.value.compareTo(node.value)<0) {
                aux = aux.parent;
            }
            return aux;
        }

    }

    public int height() {
        return height(this.root);
    }

    private int height(Node node) {
        if (node == null) return -1;
        else return 1 + Math.max(height(node.left), height(node.right));
    }

    public void remove(Palavras value) {
        Palavras toRemove = recursiveSearch(value);
        if (toRemove != null) {
            remove(toRemove);
            this.size -= 1;
        }
    }


    private void remove(Node toRemove) {
        if (toRemove.isLeaf()) {
            if (toRemove == this.root)
                this.root = null;
            else {
                if (toRemove.value.compareTo(toRemove.parent.value)< 0)
                    toRemove.parent.left = null;
                else
                    toRemove.parent.right = null;
            }


        } else if (toRemove.hasOnlyLeftChild()) {
            if (toRemove == this.root) {
                this.root = toRemove.left;
                this.root.parent = null;
            } else {
                toRemove.left.parent = toRemove.parent;
                if (toRemove.value.compareTo(toRemove.parent.value)< 0)
                    toRemove.parent.left = toRemove.left;
                else
                    toRemove.parent.right = toRemove.left;
            }
        } else if (toRemove.hasOnlyRightChild()) {
            if (toRemove == this.root) {
                this.root = toRemove.right;
                this.root.parent = null;
            } else {
                toRemove.right.parent = toRemove.parent;
                if (toRemove.value.compareTo(toRemove.parent.value)< 0)
                    toRemove.parent.left = toRemove.right;
                else
                    toRemove.parent.right = toRemove.right;
            }


        } else {
            Node sucessor = sucessor(toRemove);
            toRemove.value = sucessor.value;
            remove(sucessor);
        }

    }

    public void preOrder() {
        preOrder(this.root);
    }

    public void preOrder(Node node) {
        if (node != null) return;
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(this.root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }
    }

    public void posOrder() {
        posOrder(this.root);
    }

    private void posOrder(Node node) {
        if (node != null) {
            posOrder(node.left);
            posOrder(node.right);
            System.out.println(node.value);
        }
    }

    public void printBFS() {
       FilaDinamica<Node> queue = new FilaDinamica<>();

       queue.enfileira(root);

            while (!queue.isEmpty()) {
                Node current = queue.desenfileirar();

                System.out.print(current.value.getPalavra() +" ");
                current.value.getOcorrencias().print();
                System.out.println();

                if(current.left != null) queue.enfileira(current.left);
                if(current.right != null) queue.enfileira(current.right);

            }
        }

    }


