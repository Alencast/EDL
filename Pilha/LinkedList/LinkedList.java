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
    
    //Métodos de fila
    public boolean isFirst(int value){
        return value == head.value;
    }
    
    public boolean isLast(int value){
        return value == tail.value;
    }
    
    //Métodos para acessar
    public int first(){
        return head.value;
    }
    
    public int last(){
        return tail.value;
    }
    
    public Node before(Node p){
        
        Node no_atual = head;
        
        while(no_atual.getNext() != p){ // O que fazer se a lista estiver vazia?  
            no_atual = no_atual.getNext(); //lembrar de separar o método de busca
            
            
        }
        
        return no_atual;
    }
    
    public Node after(Node p){
        
        Node no_atual = head;
        
        while(no_atual != p){
            no_atual = no_atual.getNext();
        }
        return no_atual.getNext();
    }
    
    
    
    

        
    
}