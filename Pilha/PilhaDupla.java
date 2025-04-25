public class PilhaDupla {

    private int capacidade;
    private int topoVermelho;
    private int topoPreto;
    private Object[] a;
    
   public PilhaDupla(int capacidade){
    
    this.capacidade = capacidade;
    this.topoVermelho = 0;
    this.topoPreto = capacidade;
    this.a = new Object[capacidade];
    
   }

   public void pushVermelho(Object o){

    if(topoVermelho >= topoPreto){
        
        throw RuntimeException("Pilha vermelha colidiu com a preta");
    }

   }
}
