public class FilaLinkedList {

    public class No{
        int valor;
        No next;

        No(int valor){
            this.valor = valor;
    }
}

    private No tail;

    public void push(int valor){

        No novo = new No(valor);
        novo.next = tail;
        tail = novo;

        
    }
    
    
}
