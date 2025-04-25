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

        if(t >= capacidade - 1){ //se o topo for >= capacidade-1, a pilha está cheia

            if(FC == 0){ //se o fator de crescimento for igual a 0, a pilha dobra de tamanho por padrão
               
                capacidade *= 2;
            }
            else{
                capacidade += FC; //se o fator de crescimento for diferente de zero, some FC à capacidade
            }

            Object[] b = new Object[capacidade]; // é criado um novo array b, com a capacidade nova
            for(int i = 0; i < a.length; i++){ // passa todos os elementos do array antigo para o novo
                b[i] = a[i]; 
            }
            a = b; //ao final, a recebe o array novo que está em b
        }

        a[++t] = o; //novo topo vai pro a, lembrar que ++t != t++
    }

    public Object pop() throws PilhaVaziaExcecao{

        if(isEmpty()){ //verifica se a lista está vazia
            throw new PilhaVaziaExcecao("Pilha vazia"); // caso esteja, lança a exception
        }

        return a[t--]; //pega o topo e remove a referência, ou seja, o valor ainda está lá, mas não é possível acessá-lo (lembrar que t-- != --t)

    }

    public Object top() throws PilhaVaziaExcecao{

        if (isEmpty()){ //verifica se a lista está vazia
            throw new PilhaVaziaExcecao("Pilha vazia"); //caso esteja, retorna o exception
        }
        
        return a[t]; //retorna o array a no indice t(topo)
    }

    public boolean isEmpty(){// verifica se a lista está vazia
        
        return t == -1; //retorna um boolean, fazendo a seguinte pergunta: t é igual a -1? se o topo for igual a -1, então a lista está vazia
    }

    public int size(){ //retorna o tamanho da lista
        return t + 1;
    }

    
}