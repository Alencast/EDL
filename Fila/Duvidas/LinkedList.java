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
        return head == null;
    }
    
    public boolean isFirst(int value){
        return head.value == value;
    }
    
    public boolean isLast(int value){
        return tail.value == value;
    }
    
    public int first(){
        return head.value;
    }
    
    public int last(){
        return tail.value;
    }
    
   public Node before(Node p){
       
       Node no_atual = head;
       
       while(no_atual != p && no_atual != null){
           no_atual = no_atual.getNext();
       }
       
       if(no_atual == null){
           
           return null; // p não tá na lista
       }
       return no_atual.getPrev();
    }
   
    public Node after(Node p){
        
        Node no_atual = head;
        
        while(no_atual != p && no_atual != null){
            
            no_atual = no_atual.getNext();
            
        }
        
        if(no_atual == null){
           
           return null; // p não tá na lista
       }
       
        return no_atual.getNext();
    }
   
    //Métodos para atualizar a lista

    public void replaceElement(Node n, Node o){

        Node no_atual = head;

        while(no_atual != n && no_atual != null){
            no_atual = no_atual.getNext();
        }

        if(no_atual != null){ 
            no_atual.setValue(o.getValue());
       }

       else{
        throw new IllegalArgumentException("n não está na lista");
       }
    }

    
    public void swapElements(Node n, Node q){
        
        Node no_atual1 = head;

        while(no_atual1 != n && no_atual1 != null){

            no_atual1 = no_atual1.getNext();
        }

        Node no_atual2 = head;

        while(no_atual2 != q && no_atual2 != null){

            no_atual2 = no_atual2.getNext();
        }

       int temporario = no_atual1.getValue();

       no_atual1.setValue(no_atual2.getValue());
       no_atual2.setValue(temporario);    
    }
}
