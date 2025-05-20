public class Fila{
    
    private int capacidade;
    private int tamanho;
    private Object[] a;
    private int inicio;
    private int fim;
    
    public Fila(int capacidade){
        this.capacidade = capacidade;
        this.tamanho = 0;
        this.a = new Object[capacidade];
        this.inicio = 0;
        this.fim = 0;
    }
    
    private boolean isFull(){
        return tamanho == capacidade;
    }
    
    public void enqueue(Object o){
        
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
    
    public Object dequeue(){
        
        if(tamanho == 0){
            
            System.out.println("Fila vazia");
            return null;
        }
        
        Object result = a[inicio];
        a[inicio] = null;
        inicio = (inicio + 1) % capacidade;
        tamanho--;

        return result;
    }
}