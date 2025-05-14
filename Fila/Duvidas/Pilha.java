public class Pilha{
    
    private int capacidade;
    private int tamanho;
    private Object[] a;
    private int fim;
    
    
    public Pilha(int capacidade){
        
        this.capacidade = capacidade;
        this.tamanho = 0;
        this.a = new Object[capacidade];
        this.fim = -1;
    }
    
    private boolean isFull(){
        
        return capacidade == tamanho;
    }
    
    private boolean isEmpty(){
        return tamanho == 0;
    }
    
    public void empilhar(Object o){
        
        if(isFull()){
            
            int novacap = capacidade * 2;
            Object[] b = new Object[novacap];
            
            for(int i = 0; i <= fim; i++){
                
                b[i] = a[i];
            }
            
            a = b;
            capacidade = novacap;
        }
        
        a[++fim] = o;
        tamanho ++;
    }
    
    public Object desempilhar(){
        
        if(isEmpty()){
            
           throw new IllegalArgumentException("A pilha está vazia");
        }
        
        Object removido = a[fim];
        a[fim--] = null;
        tamanho--;

        return removido;
    }
    
    public Object topo(){
        
        if(isEmpty()){
            throw new IllegalArgumentException("Pilha vazia");
        }    
    
    return a[fim];
    
    }
    

    
}