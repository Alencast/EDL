public class LinkedList{
    
    private class Node{
        int value;
        Node prev;
        Node next;
        
        Node(int value){
            this.value = value;
            this.prev = null;
            this.next = null;
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
            contador++;
            no_atual = no_atual.getNext();
            
        }
        return contador;
    }
    
    private boolean isEmpty(){
        return head == null;
    }
    
    
    //Métodos de fila;
    public boolean isFirst(Node n){
        return n == head;
    }
    
    public boolean isLast(Node n){
        return n == tail;
    }
    
    //Métodos para acessar
    public Node first(){
        return head;
    }
    public Node last(){
        return tail;
    }
    
    //Método para buscar
    public Node buscar(Node p){
        
        Node no_atual = head;
        
        while(no_atual != null && no_atual != p){
            
            no_atual = no_atual.getNext();
        }
        
        
        return no_atual;
    }
    
    public Node before(Node p){
        
       return p.getPrev();
    }
    
    public Node after(Node p){
        
        return p.getNext();
    }
    
    //Métodos para atualizar
    public void replaceElement(Node n, int o){
        
        n.setValue(o);
    }
    
    public void swapElements(Node n, Node q){
        
        int temporario = n.getValue();
        
        n.setValue(q.getValue());
        q.setValue(temporario);
    }
    
    public void insertBefore(Node n, int o){
        
       Node no_atual = new Node(o);
       
       no_atual.setNext(n);
       no_atual.setPrev(n.getPrev());
       
       if(n.getPrev() != null){
           
           n.getPrev().setNext(no_atual);
       }
       else{
           head = no_atual;
       }
       
       n.setPrev(no_atual);
    }
    
    public void insertAfter(Node n, int o){
        
        Node no_atual = new Node(o);
        
        no_atual.setPrev(n);
        no_atual.setNext(n.getNext());
        
        if(n.getNext() != null){
            
            n.getNext().setPrev(no_atual);
        }
        
        else{
            
            tail = no_atual;
        }
        
        n.setNext(no_atual);
    }
    
    public void remove(Node n){
        
       if(n.getPrev() != null){
            n.getPrev().setNext(n.getNext());
       }
       else{
           head = n.getNext();
       }
       
       if(n.getNext() != null){
           
           n.getNext().setPrev(n.getPrev());
       }
       
       tail = n.getPrev();
        
    }

     public void insertFirst(int o){
        
        Node no_atual = new Node(o);
        
       if(isEmpty()){
           
           head = no_atual;
           tail = no_atual;
       }
       else{
           
            no_atual = head;
            head.setPrev(no_atual);
            head = no_atual;
       }
    }
    
    public void insertLast(int o){
        
        Node no_atual = new Node(o);
        
        if(isEmpty()){
            
            head = no_atual;
            tail = no_atual;
        }
        else{
            
            no_atual = tail;
            tail.setNext(no_atual);
            tail = no_atual;
            
        }
    }
    
}