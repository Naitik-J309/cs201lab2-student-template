public class SinglyLinkedList<E extends Comparable<E>> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private static class Node<E> {
        private E element;
        private Node<E> next;
    
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }
    
        public E getElement(){
            return element;
        }
    
        public Node<E> getNext(){
            return next;
        }
    
        public void setNext(Node<E> n){
            next = n;
        }
    }

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.getElement());
            sb.append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }

    // write your codes here
    public void swap() {
        if (size <= 1){
            return;
        }

        Node<E>[] arr = new Node[size];
        Node<E> current = head;
        int i = 0;
        while (current != null) {
            arr[i] = current;
            i++;
            current = current.getNext();
        }

        int[] order = new int[size];
        for (int k = 0; k < size; k++) order[k] = k;


        for (int a = 0; a < size - 1; a++) {
            int minindex = a;
            for (int b = a + 1; b < size; b++) {
                int comp=arr[order[b]].getElement().compareTo(arr[order[minindex]].getElement());
                if ( comp < 0) {
                    minindex = b;
                }
            }
            int tmp = order[a];
            order[a] = order[minindex];
            order[minindex] = tmp;
        }

        for (int a = 0; a < size / 2; a++) {
            int low = order[a];
            int high = order[size - 1 - a];
            Node<E> t = arr[low];
            arr[low] = arr[high];
            arr[high] = t;
        }

        for (int a = 0; a < size - 1; a++) {
            arr[a].setNext(arr[a + 1]);
        }
        arr[size - 1].setNext(null);
        head = arr[0];
        tail = arr[size - 1];
    }
   
}

