public class PilhaLinkedList {

    

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
            tail.next = novo;
            tail = novo; // [10] → [20] → [30] → topo

            // novo.next = tail;
            // tail = novo; topo → [10] → [20] → [30] → null
    
            
        }
        
        
    
    
    
}
