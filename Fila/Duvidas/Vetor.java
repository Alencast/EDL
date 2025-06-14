public class Vetor{ 
    private Object[] a;
    private int tamanho;
    private int capacidade;
    
    public Vetor(int capacidade){ 
        this.capacidade = capacidade;
        this.a = new Object[capacidade];
        this.tamanho = 0;
    }
    
    public int size(){ 
        return tamanho;
    }
    
    public boolean isFull() {
        return tamanho == capacidade;
    }
    
    public boolean isEmpty(){ 
        return tamanho == 0;
    }
    
    public Object elemAtRank(int r){ 
        return a[r];
    }
    
    public Object replaceAtRank(Object o, int r){ 
        
        Object replaced = a[r];
        a[r] = o;
        return replaced;
    }
    
    public void insertAtRank(int r, Object o){  
        
        if(isFull()){ 
            int novacap = capacidade * 2;
            Object[] b = new Object[novacap];
            for(int i = 0; i < capacidade; i++){ 
                b[i] = a[i];
            }
            
            a = b;
            capacidade = novacap;
        }
        
        for(int i = tamanho; i > r; i--){ 
            a[i] = a[i-1];
        }
        
        a[r] = o;
        tamanho++;
       
    }
    
    public Object removeAtRank(int r){ 
        
        if(isEmpty()){ 
            throw new IllegalStateException("vazio");
        }
        
        Object removed = a[r];
        for(int i = r; i < tamanho-1 ; i++){ 
            a[i] = a[i+1];
        }
        a[tamanho-1] = null; 
        
        tamanho--;
        return removed;
        
    }
}
