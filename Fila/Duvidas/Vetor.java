public class Vetor{
    private Object[] a;
    private int tamanho;

    public Vetor(int capacidade){
        this.a = new Object[capacidade];
        this.tamanho = 0;        
    }

    public int size(){
        return tamanho;
    }

    public boolean isEmpty(){
        return tamanho == 0;
    }

    public Object elemAtRank(int r){

        if(r < 0 || r >= tamanho){
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        return a[r];

    }

    public Object replaceAtRank(int r, Object o){
        
        if(r < 0 || r >= tamanho){
            throw new IndexOutOfBoundsException("Index inválido");
        }

        Object replaced = a[r];
        a[r] = o;
        return replaced;
    }


    public void insertAtRank(int r, Object o){

        if(r < 0 || r > tamanho){
            throw new IndexOutOfBoundsException("Index inválido");
        }

       if(tamanho == a.length){
            
        Object[] b = new Object[a.length * 2];
        for(int i = 0; i < tamanho; i++){
            b[i] = a[i];
        }

        a = b;
       }

       for(int i = tamanho; i > r; i--){
            
            a[i] = a[i - 1];
       }

       a[r] = o;
       tamanho++;
    }

    public Object removeAtRank(int r){

         if (r < 0 || r >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida para remoção: " + r);
        }

        Object removed = a[r];

       for(int i = r; i < tamanho - 1; i++){

        a[i] = a[i+1];
       }   

       a[tamanho - 1] = null;
       tamanho--;
       return removed;

    }
}