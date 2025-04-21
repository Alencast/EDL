public class PilhaRubroNegra{

    public int capacidade;
    public Object[] a;
    public int TopoVermelho;
    public int TopoPreto;
    public int FC;

//constructor
public PilhaRubroNegra(int capacidade, int crescimento){

    this.capacidade = capacidade;
    this.TopoVermelho = -1;
    this.TopoPreto = capacidade;
    this.a = new Object[capacidade];

}


private void redimensionarArray(int novaCapacidade){
    
    Object[] b = new Object[novaCapacidade];

    for(int i = 0; i <= TopoVermelho; i++){

        b[i] = a[i];
    }

    int novoTopoPreto = novaCapacidade - (capacidade - TopoPreto);
    int j = novaCapacidade - 1;

    for(int i = a.length - 1;i >= TopoPreto;i--){

        b[j--] = a[i];
    }

    TopoPreto = novoTopoPreto;
    a = b;
    capacidade = novaCapacidade;
}


public void popVermelho(){

    if(isEmptyVermelho()){
        throw new PilhaVaziaExcecao("Pilha vermelha vazia!"); 
    }   

    a[TopoVermelho--] = null; 

    if((TopoVermelho + 1) + (capacidade - TopoPreto) <= (capacidade/3)){

        int novaCapacidade = capacidade / 2;
        redimensionarArray(novaCapacidade);

    }
}

public void popPreto(){

    if(isEmptyPreto()){

        throw new PilhaVaziaExcecao("Pilha preta vazia");
    }

    a[TopoPreto++] = null;
}

public Object top(){

    return this.a[capacidade - 1];
}
public boolean isEmptyVermelho(){

    return TopoVermelho == -1;
}

public boolean isEmptyPreto(){

    return TopoPreto == -1;
}

private boolean isFull(){

    return (TopoVermelho +1) == TopoPreto;
}

public int size(){

    return capacidade;
}

public void pushVermelho(Object o){

    if(isFull()){

        this.capacidade *= 2;
       

        Object[] b = new Object[capacidade];

        //TopoVermelho
        for(int i = 0; i <= TopoVermelho; i++){

            b[i] = a[i];
        }

        int j = capacidade -1;
        //TopoPreto
        for(int i = a.length - 1; i >= TopoPreto; i--){            

            b[j--] = a[i];
        }
        
        TopoPreto = j -1;
        a = b;
            
    }

    a[++TopoVermelho] = o;
    
    

}

public void pushPreto(Object o){

    if(isFull()){

        capacidade *= 2;

        Object[] b = new Object[capacidade];

        for(int i = 0; i <= TopoVermelho; i++){

            b[i] = a[i];
        }

        int j = capacidade -1;

        for(int i = a.length -1; i >= TopoPreto; i--){

            b[j--] = a[i];
        }
        
        TopoPreto = j + 1;

        a = b;
    }
    a[--TopoPreto] = o;

}

}