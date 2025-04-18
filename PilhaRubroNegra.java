public class PilhaRubroNegra implements Pilha{

    private int capacidade;
    private Object[] a;
    private int TopoVermelho;
    private int TopoPreto;
    private int FC;

//constructor
public PilhaRubroNegra(int capacidade, int crescimento){

    this.capacidade = capacidade;
    this.TopoVermelho = -1;
    this.TopoPreto = capacidade;
    this.a = new Object[capacidade];

}

private boolean isFull(){

    return (TopoVermelho +1) == TopoPreto;
}

public size(){

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

        //TopoPreto
        for(int i = capacidade -1; i >= TopoPreto; i--){
            

            b[i] = a[i];
        }
        
        TopoPreto = size() - TopoPreto;
        a = b;
            
    }

    a[++TopoVermelho] = o;
    
    

}

}