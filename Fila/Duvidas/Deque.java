public class Deque{
    
    private int capacidade;
    private int tamanho;
    private Object[] a;
    private int inicio;
    private int fim;
    
    public Deque(int capacidade){
        this.capacidade = capacidade;
        this.tamanho = 0;
        this.a = new Object[capacidade];
        this.inicio = 0;
        this.fim = 0;
    }
    
    private boolean isFull(){
        return tamanho == capacidade;
    }
    
    public void inserirInicio(Object o){
        
        if(isFull()){
            
            int novacap = capacidade * 2;
            Object[] b = new Object[novacap];
            
            for(int i = 0; i < tamanho; i++){
                b[i] = a[(inicio + i) % capacidade];
            }
            a = b;
            inicio = 0;
            fim = tamanho;
            capacidade = novacap;
        }
        
        inicio = (inicio - 1 + capacidade) % capacidade;
        a[inicio] = o;
        tamanho ++;
            
    }
    
    public void removerInicio(){
        
        if(tamanho == 0){
            System.out.println("Deque vazio");
            return;
    }
        a[inicio] = null;
        inicio = (inicio + 1) % capacidade;
        tamanho --;
    
    }
    
    public void inserirFim(Object o){
        
        if(isFull()){
            int novacap = capacidade * 2;
            Object[] b = new Object[novacap];
            
            for(int i = 0; i < tamanho; i++){
                b[i] = a[(inicio + i) % capacidade];
            }
            
            a = b;
            inicio = 0;
            fim = tamanho;
            capacidade = novacap;
            
        }
        
        a[fim] = o;
        fim = (fim + 1) % capacidade;
        tamanho ++;
    }
    
    public void removerFim(){
        
        if(tamanho == 0){
            
            System.out.println("Deque vazio");
            return;
        }
        
        fim = (fim -1 + capacidade) % capacidade;
        a[fim] = null;
        tamanho --;
    }
    
    public Object primeiro(){
        return inicio;
    }
    
    public Object ultimo(){
        return fim;
    }
    
    public boolean isEmpty(){
        return tamanho == 0;
    }
    
    
    
}