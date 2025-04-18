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

public Object pop(){

    return a[capacidade -1];
}

public Object top(){

    return capacidade;
}
public boolean isEmpty(){

    return TopoVermelho == -1;
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