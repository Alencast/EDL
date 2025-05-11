public class ListaLigada {
    
    private class Node{
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        public int getValue(){
            return value;
        }
        public void setValue(int value){
            this.value = value;
        }

        public Node getPrev(){
            return prev;
        }

        public void setPrev(Node prev){
            this.prev = prev;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }
        
        

    }

    private Node head;
    private Node tail;

    //Métodos genéricos

    public int size(){

        int contador = 0;
        Node no_atual = head;

        while(no_atual != null){

            no_atual = no_atual.getNext();

            contador++;
        }
        return contador;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean isFirst(int value){
        return value == head.value;
    }

    public boolean isLast(int value){
        return value == tail.value;
    }

    public int first(){
        return head.value;
    }

    public int last(){
        return tail.value;
    }

    public Node before(Node p){
        Node no_atual = head;
        while(no_atual != p.getPrev() && no_atual.getNext() != null){
            no_atual = no_atual.getNext();
        }
        return no_atual;
    }

    public Node after(Node p){
        Node no_atual = head;
        while(no_atual != p && no_atual.getNext() != null){
            no_atual = no_atual.getNext();
        }

        return no_atual.getNext();
    }

}
