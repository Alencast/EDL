public class PilhaRB{
    
    private int capacidade;
    private Object[] a;
    private int tv;
    private int tp;
    
    public PilhaRB(int capacidade){
        this.capacidade = capacidade;
        this.a = new Object[capacidade];
        this.tv = -1;
        this.tp = capacidade;
    }
    
    private boolean isFull(){
        return tv+1 == tp;
    }
    
    
    public void pushRed(Object o){
        
        if(isFull()){
            int novacap = capacidade * 2;
            Object[] b = new Object[novacap];
            
            for(int i = 0; i <= tv; i++){
                b[i] = a[i];
            }
            
            int j = capacidade - 1;
            
            for(int i = capacidade-1; i >= tp;i--){
                
                b[j--] = a[i];
            }
            
            a = b;
            capacidade = novacap;
            tp = j + 1;
        }
        a[++tv] = o;
    }
    
    public void pushBlack(Object o){
        
        if(isFull()){
            int novacap = capacidade * 2;
            Object[] b = new Object[novacap];
            
            for(int i = 0; i <= tv; i++){
                b[i] = a[i];
            }
            
            int j = capacidade - 1;
            
            for(int i = capacidade - 1; i >= tp; i--){
                b[j--] = a[i];
            }
            
            a = b;
            tp = j + 1;
            capacidade = novacap;
            
        }
        
        a[--tp] = o;
    }
    
}