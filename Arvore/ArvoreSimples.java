public class ArvoreSimples{ 
    
    public class Node{ 
        
        private Object value;
        private Node pai;
        private ArrayList filhos = ArrayList();
        
        Node(Node pai, Object value){ 
            this.pai = pai;
            this.value = value;
        }
        
       public Object element(){ 
           return value;
       } 
       
       public Node parent(){ 
           return pai;
       }
       
       public void setElement(Object value){ 
           this.value = value;
       }
       
       public void addChild(Node n){ 
           filhos.add(n);
       }
       
       public void removeChild(Node n){ 
           filhos.remove(n);
       }
       
       public int childrenNumber(){ 
           return filhos.size();
       }
       
       public Iterator children(){ 
           return filhos.iterator();
       }
    }
    
    Node raiz;
    int tamanho;
    
    //constructor
    public ArvoreSimples(Object value){ 
        this.raiz = new Node(null, value);
        tamanho = 1;
    }
    
    public int size(){ 
        return tamanho;
    }
    
    public boolean isEmpty(){ 
        return false;
    }
    
    public Node root(){ 
        return raiz;
    }
    
    public Node parent(Node v){ 
        return (v.parent());
    }
    
    public Iterator children(Node v){ 
        return v.children();
    }
    
    public boolean isInternal(Node v){ 
        return(v.childrenNumber() > 0);
    }
    
    
    public boolean isExternal(Node v){ 
        return(v.childrenNumber() == 0);
    }
    
    public boolean isRoot(Node v){ 
        return v == raiz;
    }
    
    public int depth(Node v){ 
        
        int profundidade = profundidade(v);
        return profundidade;
    }
    
    private int profundidade(Node v){ 
        if(v == raiz){ 
            return 0;
        }
        else{ 
            return 1 + profundidade(v.parent());
        }
        
    }
    
    public int height(){ 
        int altura = 0;
        return altura;
    }
    
    
    
}