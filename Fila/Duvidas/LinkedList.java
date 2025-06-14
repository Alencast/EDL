public class LinkedList{ 
    
    private class Node { 
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
        
        public Node getPrev(){ 
            return prev;
        }
        
        public Node getNext(){ 
            return next;
        }
        
        public void setValue(int value){ 
            this.value = value;
        }
        
        public void setPrev(Node prev){ 
            this.prev = prev;
        }
        
        public void setNext(Node next){ 
            this.next = next;
        }
    } 
    
    private Node head;
    private Node tail;
    private int tamanho;
    
    public int size(){ 
        
       return tamanho;
    } 
    
    public Node search(Node n){ 
        
        Node no_atual = head;
        
        while(no_atual != null && no_atual != n){ 
            
            no_atual = no_atual.getNext();
        }
        
        return no_atual;
    }
    
    public boolean isEmpty(){
        
        return head == null;
    }
    
    public boolean isFirst(Node n){ 
        return head == n;
    }
    
    public boolean isLast(Node n){ 
        return tail == n;
    }
    
    public int first(){ 
        
        return head.value;
    }
    
    public int last(){ 
        
        return tail.value;
    }
    
    public void replaceElement(Node n, Object o){ 
        
        n.setValue(o);
    }
    
    public void swapElements(Node n, Node q){ 
        
        Object temp = n.getValue();
        n.setValue(q.getValue());
        q.setValue(temp);
    }
    
    public void insertBefore(Node n, Object o){ 
        tamanho++;
        Node no_atual = new Node(o);
        
        no_atual.setPrev(n.getPrev());
        no_atual.setNext(n);
        
        if(n.getPrev() != null){ 
            n.getPrev().setNext(no_atual);
        }
        else{ 
            head = no_atual;
        }
        
        n.setPrev(no_atual);
    }
    
    public void insertAfter(Node n, Object o){ 
        tamanho++;
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
    
    public void insertFirst(Object o){ 
        tamanho++;
        Node no_atual = new Node(o);
        
        if(head != null){ 
            
            no_atual.setNext(head);
            head.setPrev(no_atual);
            head = no_atual;
        }
        
        else{ 
            head = tail = no_atual;
        }
    }
    
    public void insertLast(Object o){ 
        tamanho++;
        Node no_atual = new Node(o);
        
        if(tail != null){ 
            
            no_atual.setPrev(tail);
            tail.setNext(no_atual);
            tail = no_atual;
        }
        else{ 
            head = tail = no_atual;
        }
    }
    
    public void remove(Node n){ 
        tamanho--;
        if(n.getPrev()!= null){ 
            
            n.getPrev().setNext(n.getNext());
        }
        else{ 
            head = n.getNext();
        }
        
        if(n.getNext() != null){ 
            
            n.getNext().setPrev(n.getPrev());
        }
        else{ 
            tail = n.getPrev();
        }
    }
}
