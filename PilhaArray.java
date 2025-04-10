public class PilhaArray implements Pilha{

    private int capacidade;
    private Object [] a;
    private int t; // índice do elemento no topo
    private int FC; //fator de crescimento do array


    public PilhaArray(int capacidade, int crescimento){

        this.capacidade = capacidade;
        this.t = -1;
        this.FC = crescimento <= 0 ? 0 : crescimento;
        this.a = new Object[capacidade];
    }

    public void push(Object o){

        if(t >= capacidade - 1){

            if(FC == 0){
               
                capacidade *= 2;
            }
            else{
                capacidade += FC;
            }

            Object[] b = new Object[capacidade];
            for(int i = 0; i < a.length; i++){
                b[i] = a[i];
            }
            a = b;
        }

        a[++t] = o; //novo topo vai pro a
    }

    public Object pop() throws PilhaVaziaExcecao{

        if(isEmpty()){
            throw new PilhaVaziaExcecao("Pilha vazia");
        }

        return a[t--]; //pega o topo e remove (lembrar que t-- != --t)

    }

    public Object top() throws PilhaVaziaExcecao{

        if (isEmpty()){
            throw new PilhaVaziaExcecao("Pilha vazia");
        }
        
        return a[t];
    }

    public boolean isEmpty(){
        
        return t == -1;
    }

    public int size(){
        return t + 1;
    }

    
}