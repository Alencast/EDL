public class PilhaRubroNegra implements Pilha{

    private int capacidade;
    private Object[] a;
    private int PilhaVermelha;
    private int PilhaPreta;
    private int FC;

//constructor
public PilhaRubroNegra(int capacidade, int crescimento){

    this.capacidade = capacidade;
    this.PilhaVermelha = -1;
    this.PilhaPreta = capacidade;
    this.a = new Object[capacidade];

}

private boolean isFull(){

    return (PilhaVermelha +1) == PilhaPreta;
}

public size(){

    return capacidade;
}

public void pushVermelho(Object o){

    if(isFull()){

        this.capacidade *= 2;
       

        Object[] b = new Object[capacidade];

        //PilhaVermelha
        for(int i = 0; i <= PilhaVermelha; i++){

            b[i] = a[i];
        }

        //PilhaPreta
        for(int i = capacidade -1; i >= PilhaPreta; i--){
            

            b[i] = a[i];
        }
        
        PilhaPreta = size() - PilhaPreta;
        a = b;
            
    }

    a[++PilhaVermelha] = o;
    
    

}

}