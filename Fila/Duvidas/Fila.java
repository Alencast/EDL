public class Fila{ 
    
    public int capacidade;
    public int tamanho;
    public Object[] a;
    public int inicio;
    public int fim;
    
    public Fila(int capacidade){ 
        
        this.capacidade = capacidade;
        this.tamanho = 0;
        this.a = new Object[capacidade];
        this.inicio = 0;
        this.fim = 0;
    }
    
    public boolean isFull(){ 
        
        return tamanho == capacidade;
    }
    
    public boolean isEmpty(){ 
        
        return tamanho == 0;
    }
    
    public void enqueue(Object o){ 
        
        if(isFull()){ 
            int novacap = capacidade * 2;
            Object[] b = new Object[novacap];
            
            for(int i = 0; i < tamanho; i++){ 
                b[i] = a[(inicio + i) % capacidade];
            }
            
            a = b;
            capacidade = novacap;
            inicio = 0;
            fim = tamanho;
        }
        
        a[fim] = o;
        fim = (fim + 1) % capacidade;
        tamanho++;
    }
    
    public Object dequeue(){ 
        if(isEmpty()){ 
            throw new IllegalStateException("vazia");
        }
        
        Object removido = a[inicio];
        
        a[inicio] = null;
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        
        return removido;
        
        
    } 
}
