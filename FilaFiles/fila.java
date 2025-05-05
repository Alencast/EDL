public class fila{

    private int capacidade;
    private int tamanho;
    private Object[] a;
    private int inicio;
    private int fim;


    public fila(int capacidade){
        this.capacidade = capacidade;
        this.tamanho = 0;
        this.a = new Object[capacidade];
        this.inicio = 0;
        this.fim = 0;
    }

    public boolean isFull(){

        return capacidade == tamanho;
    }
    
    public boolean isEmpty(){

        return tamanho == 0;
    }

    public void enqueue(Object o){

        if(isFull()){

            this.capacidade *= 2;
            Object[] b = new Object[capacidade];
            int j = 0;

            //Não é circular
            if(inicio < fim){

                for(int i = inicio; i < fim; i++){
                    b[j++] = a[i];
                }
            }
            else{ //circular

                for(int i = inicio; i < a.length; i++){
                    b[j++] = a[i];
                }

                for(int i = 0; i < fim; i++){
                    b[j++] = a[i];
                }
            }
            
            a = b;
            inicio = 0;
            fim = tamanho;
        }

        fim = (fim+1) % capacidade;
        a[fim] = o;
        tamanho++;

    }


}